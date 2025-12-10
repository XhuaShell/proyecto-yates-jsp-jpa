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
@WebServlet(name = "TipoYateServlet", urlPatterns = {"/TipoYateServlet"})
public class TipoYateServlet extends HttpServlet {

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
            out.println("<title>Servlet TipoYateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TipoYateServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        switch (action) {
            // VISTAS
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
                mostrarmain(request, response);
                break;

            // API
            case "getLista":
                getLista(request, response);
                break;

            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Acción no válida");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("create".equals(action)) {
            create(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "POST action no válida");
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if ("delete".equals(action)) {
            delete(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "DELETE action no válida");
        }
    }

    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse res) {
    }

    private void mostrarLista(HttpServletRequest req, HttpServletResponse res) {
    }

    private void mostrarActualizacion(HttpServletRequest req, HttpServletResponse res) {
    }

    private void mostrarEliminacion(HttpServletRequest req, HttpServletResponse res) {
    }

    private void mostrarmain(HttpServletRequest req, HttpServletResponse res) {
    }

    private void getLista(HttpServletRequest req, HttpServletResponse res) {
    }

    private void create(HttpServletRequest req, HttpServletResponse res) {
    }

    private void delete(HttpServletRequest req, HttpServletResponse res) {
    }

}
