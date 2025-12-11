package com.yates.proyecto_yates.controller;

import com.yates.proyecto_yates.model.PanelFactory;
import com.yates.proyecto_yates.model.dto.PanelInfoDTO;
import com.yates.proyecto_yates.model.dto.UsuarioDTO;
import com.yates.proyecto_yates.model.dto.UsuarioLoginDTO;
import com.yates.proyecto_yates.model.repositorys.UsuarioRepository;
import com.yates.proyecto_yates.model.repositorys.config.JpaUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Hol");
        request.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String mail = req.getParameter("mail");
        String contrasena = req.getParameter("contrasena");

        UsuarioLoginDTO ulogin = new UsuarioLoginDTO(mail, contrasena);

        try {

            UsuarioRepository repo = new UsuarioRepository(
                    JpaUtil.getEntityManager()
            );
            UsuarioDTO user = repo.validarCredenciales(ulogin);

            if (user == null) {
                req.setAttribute("error", "Credenciales incorrectas");
                req.getRequestDispatcher("/WEB-INF/vistas/login.jsp").forward(req, resp);
                return;
            }

            // guardar usuario en sesión
            req.getSession().setAttribute("usuario", user);

            // sacar panel según tipo usuario
            PanelInfoDTO panel = PanelFactory.getPanel(user.getTipoUsuario().toString());

            req.getSession().setAttribute("panelInfo", panel);

            resp.sendRedirect(req.getContextPath() + "/panel?typeuser=" + user.getTipoUsuario().toString().toLowerCase());
        } catch (Exception e) {
            req.setAttribute("error", "Ocurrió un error: " + e.getMessage());
            req.getRequestDispatcher("/WEB-INF/vistas/error.jsp").forward(req, resp);
        }
    }
}
