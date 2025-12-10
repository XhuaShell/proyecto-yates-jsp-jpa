/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.yates.proyecto_yates.controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author krate
 */
@WebServlet(name = "AmarreServlet", urlPatterns = {"/AmarreServlet"})
public class AmarreServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AmarreServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AmarreServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Leer el parámetro action
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
            default:
                response.sendError(400, "POST action no válida");
        }
    }

    // ACTUALIZAR
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "edicion":
                edit(request, response);
                break;

            default:
                response.sendError(400, "PUT action no válida");
        }
    }

    // ELIMINAR
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            case "delete":
                delete(request, response);
                break;

            default:
                response.sendError(400, "DELETE action no válida");
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

    private void delete(HttpServletRequest req, HttpServletResponse res) {
        // DELETE /AmarreServlet?action=delete
    }

    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Aquí haces forward a JSP o imprimes HTML
    }

    private void mostrarLista(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    }

    private void mostrarActualizacion(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    }

    private void mostrarEliminacion(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    }

    private void mostrarMain(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    }

}
