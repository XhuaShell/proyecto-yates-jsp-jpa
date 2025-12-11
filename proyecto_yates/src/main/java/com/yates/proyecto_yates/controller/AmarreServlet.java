package com.yates.proyecto_yates.controller;

import com.yates.proyecto_yates.model.dto.AmarreDTO;
import com.yates.proyecto_yates.model.repositorys.AmarreRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet(name = "AmarreServlet", urlPatterns = {"/AmarreServlet"})
public class AmarreServlet extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("YatePU");
    EntityManager em = emf.createEntityManager();

    AmarreRepository repo = new AmarreRepository(em);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
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
                System.out.println("Hola, estoy en el metodo get");
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
                System.out.println("Hola, estoy en el metodo get");
                break;
                
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Acción '" + action + "' no válida");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el parámetro 'action'");
            return;
        }

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

    private void getLista(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<AmarreDTO> amarres = repo.listar();
        req.setAttribute("objetosCons", amarres);
        req.getRequestDispatcher("/WEB-INF/vistas/amarre/Lista.jsp")
                .forward(req, res);
        System.out.println("Amarres encontrados: " + amarres.size());
    }

    private void create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Obtener parámetros usando los nombres exactos de los atributos

        String idZonaStr = req.getParameter("id_zona");
        
        // Validar parámetros
        if (idZonaStr == null || idZonaStr.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Faltan parámetros requeridos");
            return;
        }
        
        // Convertir tipos según los atributos del DT
        
        char idZona = idZonaStr.charAt(0);
        
        // Crear DTO con los parámetros exactos
        AmarreDTO amarre = new AmarreDTO();
        amarre.setId_zona(idZona);
        
        // Verificar valores
        System.out.println("Creando AmarreDTO:");
        System.out.println("num_amarre: " + amarre.getNum_amarre());
        System.out.println("id_zona: " + amarre.getId_zona());

        try {
            em.getTransaction().begin();
            repo.guardar(amarre);
            em.getTransaction().commit();
            System.out.println("Amarre creado exitosamente");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al crear amarre");
            return;
        }
        
        req.getRequestDispatcher("/WEB-INF/vistas/index.jsp")
                .forward(req, res);
    }

    private void edit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String numAmarreStr = req.getParameter("num_amarre");
        if (numAmarreStr == null || numAmarreStr.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el número de amarre");
            return;
        }
        
        Long numAmarre;
        try {
            numAmarre = Long.parseLong(numAmarreStr);
        } catch (NumberFormatException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "num_amarre debe ser un número válido");
            return;
        }
        
        String idZonaStr = req.getParameter("id_zona");
        if (idZonaStr == null || idZonaStr.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el id_zona");
            return;
        }
        
        char idZona = idZonaStr.charAt(0);

        AmarreDTO amarreExistente = repo.porId(numAmarre);
        if (amarreExistente == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND, "Amarre no encontrado");
            return;
        }

        // Actualizar solo el atributo id_zona (num_amarre es la clave primaria)
        amarreExistente.setId_zona(idZona);

        try {
            em.getTransaction().begin();
            repo.guardar(amarreExistente);
            em.getTransaction().commit();
            System.out.println("Amarre actualizado exitosamente");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar amarre");
            return;
        }

        res.sendRedirect(req.getContextPath() + "/AmarreServlet?action=lista1");
    }

    private void delete(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String numAmarreStr = req.getParameter("num_amarre");
        if (numAmarreStr == null || numAmarreStr.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el número de amarre");
            return;
        }
        
        Long numAmarre;
        try {
            numAmarre = Long.parseLong(numAmarreStr);
        } catch (NumberFormatException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "codigo debe ser un número válido");
            return;
        }
        System.out.println("Codigo:"+numAmarre);
        try {
            em.getTransaction().begin();
            repo.eliminar(numAmarre);
            em.getTransaction().commit();
            System.out.println("Amarre eliminado exitosamente");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar amarre");
            return;
        }

        res.sendRedirect(req.getContextPath() + "/AmarreServlet?action=lista1");
    }

    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/amarre/Formulario.jsp")
                .forward(req, res);
    }

    private void mostrarLista(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/amarre/Lista.jsp")
                .forward(req, res);
    }

    private void mostrarActualizacion(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/amarre/FormularioEdicion.jsp")
                .forward(req, res);
    }

    private void mostrarEliminacion(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/amarre/Deleter.jsp")
                .forward(req, res);
    }

    private void mostrarMain(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Implementación si es necesaria
    }

    @Override
    public String getServletInfo() {
        return "Servlet para manejo de Amarres";
    }
}