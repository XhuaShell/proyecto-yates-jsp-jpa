package com.yates.proyecto_yates.controller;

import com.yates.proyecto_yates.model.PanelTemplates;
import com.yates.proyecto_yates.model.dto.PanelInfoDTO;
import com.yates.proyecto_yates.model.dto.UsuarioDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "PanelServlet", urlPatterns = {"/panel"})
public class PanelServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        HttpSession session = req.getSession(false);

        // Si no hay sesión → vete al login
        if (session == null || session.getAttribute("usuario") == null) {
            resp.sendRedirect(req.getContextPath() + "/login");
            return;
        }

        // Parametro obligatorio: typeuser
        String type = req.getParameter("typeuser");
        if (type == null || type.isBlank()) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                    "Falta el parámetro 'typeuser' (admin o socio)");
            return;
        }

        PanelInfoDTO panel = null;

        switch (type.toLowerCase()) {

            case "admin":
                panel = PanelTemplates.panelAdmin();
                break;

            case "socio":
                panel = PanelTemplates.panelSocio();
                break;

            default:
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST,
                        "El valor de 'typeuser' no es válido");
                return;
        }

        // Guardar el panel en la request (o en sesión si quieres)
        req.setAttribute("panelInfo", panel);

        // Si quieres enviar también el usuario:
        UsuarioDTO usuario = (UsuarioDTO) session.getAttribute("usuario");
        req.setAttribute("usuario", usuario);

        // Redirigir al JSP que pinta el panel
        req.getRequestDispatcher("/WEB-INF/vistas/panel.jsp").forward(req, resp);
    }
}
