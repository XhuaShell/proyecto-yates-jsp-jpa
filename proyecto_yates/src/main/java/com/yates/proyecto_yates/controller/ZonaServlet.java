package com.yates.proyecto_yates.controller;

import com.yates.proyecto_yates.model.dto.ZonaDTO;
import com.yates.proyecto_yates.model.repositorys.ZonaRepository;
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

@WebServlet(name = "ZonaServlet", urlPatterns = {"/ZonaServlet"})
public class ZonaServlet extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("YatePU");
    EntityManager em = emf.createEntityManager();
    ZonaRepository repo = new ZonaRepository(em);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta el parámetro 'action'");
            return;
        }

        switch (action) {
            case "":
                mostrarFormulario(request, response);
                break;
            case "lista":
                mostrarLista(request, response);
                break;
            case "getLista":
                getLista(request, response);
                break;
            case "main":
                mostrarmain(request, response);
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

    // MÉTODOS PRIVADOS
    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/zona/Formulario.jsp").forward(req, res);
    }

    private void mostrarLista(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/zona/Lista.jsp").forward(req, res);
    }

    private void mostrarmain(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/index.jsp").forward(req, res);
    }

    private void getLista(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<ZonaDTO> zonas = repo.listar();
        req.setAttribute("objetosCons", zonas);
        req.getRequestDispatcher("/WEB-INF/vistas/zona/Lista.jsp").forward(req, res);
    }

    private void create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            // Leer parámetros
            Character idZona = req.getParameter("id_zona").charAt(0);
            Double cuotaAdmin = Double.parseDouble(req.getParameter("cuota_administracion"));
            Integer capacidad = Integer.parseInt(req.getParameter("capacidad"));
            Double profundidad = Double.parseDouble(req.getParameter("profundidad"));
            Double dimMaxEslora = Double.parseDouble(req.getParameter("dim_max_eslora"));
            Double dimMaxManga = Double.parseDouble(req.getParameter("dim_max_manga"));
            Double dimMaxCalado = Double.parseDouble(req.getParameter("dim_max_calado"));
            Double dimMinEslora = Double.parseDouble(req.getParameter("dim_min_eslora"));
            Double dimMinManga = Double.parseDouble(req.getParameter("dim_min_manga"));
            Double dimMinCalado = Double.parseDouble(req.getParameter("dim_min_calado"));

            ZonaDTO zona = new ZonaDTO();
            zona.setId_zona(idZona);
            zona.setCuota_administracion(cuotaAdmin);
            zona.setCapacidad(capacidad);
            zona.setProfundidad(profundidad);
            zona.setDim_max_eslora(dimMaxEslora);
            zona.setDim_max_manga(dimMaxManga);
            zona.setDim_max_calado(dimMaxCalado);
            zona.setDim_min_eslora(dimMinEslora);
            zona.setDim_min_manga(dimMinManga);
            zona.setDim_min_calado(dimMinCalado);

            em.getTransaction().begin();
            repo.guardar(zona);
            em.getTransaction().commit();

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        // Redirigir a la lista
        res.sendRedirect(req.getContextPath() + "/ZonaServlet?action=getLista");
    }
}
