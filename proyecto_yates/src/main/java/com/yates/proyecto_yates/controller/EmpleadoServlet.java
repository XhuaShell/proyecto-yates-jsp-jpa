package com.yates.proyecto_yates.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/EmpleadoServlet"})
public class EmpleadoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EmpleadoServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EmpleadoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String action = request.getParameter("action");

        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el parámetro 'action'");
            return;
        }

        switch (action) {

            case "formulario":
                mostrarFormulario(request, response);
                break;

            case "lista":
                mostrarLista(request, response);
                break;

            case "edicion":
                mostrarActualizacion(request, response);
                break;

            case "delete":
                mostrarEliminacion(request, response);
                break;

            case "main":
                mostrarMain(request, response);
                break;
            case "lista1":
                getLista(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Acción '" + action + "' no válida");
        }
    }

    // CREAR
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "formulario":
                create(request, response);
                break;
            case "edicion":
                edit(request, response);
                break;
            case "delete":
                delete(request, response);
                break;

            default:
                response.sendError(400, "POST action no válida");

        }
    }

    private void getLista(HttpServletRequest req, HttpServletResponse res) {
        // GET /AmarreServlet?action=lista&id=1
    }

    private void create(HttpServletRequest req, HttpServletResponse res) {
        // POST /AmarreServlet?action=formulario
    }

    private void edit(HttpServletRequest req, HttpServletResponse res) {
        // PUT /AmarreServlet?action=edicion
    }

    private void delete(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    }

    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Aquí haces forward a JSP o imprimes HTML
        req.getRequestDispatcher("/WEB-INF/vistas/empleado/Formulario.jsp")
       .forward(req, res);
    }

    private void mostrarLista(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/empleado/Lista.jsp")
       .forward(req, res);
    }

    private void mostrarActualizacion(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/empleado/FormularioEdicion.jsp")
       .forward(req, res);
    }

    private void mostrarEliminacion(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/empleado/Deleter.jsp")
       .forward(req, res);
    }

    private void mostrarMain(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    }

}
   


