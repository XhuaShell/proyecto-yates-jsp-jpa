package com.yates.proyecto_yates.controller;

import com.yates.proyecto_yates.model.dto.TipoYateDTO;
import com.yates.proyecto_yates.model.repositorys.TipoYateRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "TipoYateServlet", urlPatterns = {"/TipoYateServlet"})
public class TipoYateServlet extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("YatePU");
    EntityManager em = emf.createEntityManager();
    TipoYateRepository repo = new TipoYateRepository(em);

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

    private void getLista(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<TipoYateDTO> tipos = repo.listar();
        req.setAttribute("objetosCons", tipos);
        req.getRequestDispatcher("/WEB-INF/vistas/tipoyate/Lista.jsp")
                .forward(req, res);
    }

    private void create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String codigoStr = req.getParameter("num_tipo_yate");
        Long codigo = (codigoStr != null && !codigoStr.isEmpty()) ? Long.parseLong(codigoStr) : null;
        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");

        TipoYateDTO tipo = new TipoYateDTO();
        tipo.setNum_tipo_yate(codigo);
        tipo.setNombre(nombre);
        tipo.setDescripcion(descripcion);

        try {
            em.getTransaction().begin();
            repo.guardar(tipo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        res.sendRedirect(req.getContextPath() + "/TipoYateServlet?action=lista1");
    }

    private void edit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String codigoStr = req.getParameter("num_tipo_yate");
        if (codigoStr == null || codigoStr.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el código del tipo de yate");
            return;
        }
        Long codigo = Long.parseLong(codigoStr);
        TipoYateDTO tipoExistente = repo.porId(codigo);
        if (tipoExistente == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND, "Tipo de Yate no encontrado");
            return;
        }

        String nombre = req.getParameter("nombre");
        String descripcion = req.getParameter("descripcion");

        tipoExistente.setNombre(nombre);
        tipoExistente.setDescripcion(descripcion);

        try {
            em.getTransaction().begin();
            repo.guardar(tipoExistente);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        res.sendRedirect(req.getContextPath() + "/TipoYateServlet?action=lista1");
    }

    private void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String codigoStr = req.getParameter("num_tipo_yate");
        if (codigoStr == null || codigoStr.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el código del tipo de yate");
            return;
        }
        Long codigo = Long.parseLong(codigoStr);

        try {
            em.getTransaction().begin();
            repo.eliminar(codigo);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        res.sendRedirect(req.getContextPath() + "/TipoYateServlet?action=lista1");
    }

    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/tipoyate/Formulario.jsp")
                .forward(req, res);
    }

    private void mostrarLista(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/tipoyate/Lista.jsp")
                .forward(req, res);
    }

    private void mostrarActualizacion(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String codigoStr = req.getParameter("num_tipo_yate");
        if (codigoStr != null && !codigoStr.isEmpty()) {
            Long codigo = Long.parseLong(codigoStr);
            TipoYateDTO tipo = repo.porId(codigo);
            req.setAttribute("tipoYate", tipo);
        }
        req.getRequestDispatcher("/WEB-INF/vistas/tipoyate/FormularioEdicion.jsp")
                .forward(req, res);
    }

    private void mostrarEliminacion(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/tipoyate/Deleter.jsp")
                .forward(req, res);
    }

    private void mostrarMain(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Implementación opcional si necesitas página principal
    }
}
