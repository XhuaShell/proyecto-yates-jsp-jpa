package com.yates.proyecto_yates.controller;

import com.yates.proyecto_yates.model.dto.YateDTO;
import com.yates.proyecto_yates.model.repositorys.YateRepository;
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

@WebServlet(name = "YateServlet", urlPatterns = {"/YateServlet"})
public class YateServlet extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("YatePU");
    EntityManager em = emf.createEntityManager();

    YateRepository repo = new YateRepository(em);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet YateServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet YateServlet at " + request.getContextPath() + "</h1>");
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
                System.out.println("Hola, estoy en el metodo get YateServlet");
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
                System.out.println("Hola, estoy en el metodo get YateServlet - lista1");
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
        List<YateDTO> yates = repo.listar();
        req.setAttribute("objetosCons", yates);
        req.getRequestDispatcher("/WEB-INF/vistas/yate/Lista.jsp")
                .forward(req, res);
        System.out.println("Yates encontrados: " + yates.size());
    }

    private void create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // Obtener parámetros usando los nombres exactos de los atributos
        String matricula = req.getParameter("matricula");
        String nombre = req.getParameter("nombre");
        String esloraStr = req.getParameter("eslora");
        String mangaStr = req.getParameter("manga");
        String caladoStr = req.getParameter("calado");
        String usuarioDuenoCedula = req.getParameter("usuario_dueno_cedula");
        String idTipoStr = req.getParameter("id_tipo");
        
        // Validar parámetros obligatorios
        if (matricula == null || matricula.isEmpty() || 
            nombre == null || nombre.isEmpty() ||
            esloraStr == null || esloraStr.isEmpty() ||
            mangaStr == null || mangaStr.isEmpty() ||
            caladoStr == null || caladoStr.isEmpty() ||
            usuarioDuenoCedula == null || usuarioDuenoCedula.isEmpty() ||
            idTipoStr == null || idTipoStr.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Faltan parámetros requeridos");
            return;
        }
        
        // Convertir tipos double
        double eslora, manga, calado;
        try {
            eslora = Double.parseDouble(esloraStr);
            manga = Double.parseDouble(mangaStr);
            calado = Double.parseDouble(caladoStr);
        } catch (NumberFormatException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "eslora, manga y calado deben ser números válidos");
            return;
        }
        
        // Convertir id_tipo a Long
        Long idTipo;
        try {
            idTipo = Long.parseLong(idTipoStr);
        } catch (NumberFormatException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "id_tipo debe ser un número válido");
            return;
        }
        
        // Crear DTO con los parámetros exactos
        YateDTO yate = new YateDTO();
        yate.setMatricula(matricula);
        yate.setNombre(nombre);
        yate.setEslora(eslora);
        yate.setManga(manga);
        yate.setCalado(calado);
        yate.setUsuario_dueno_cedula(usuarioDuenoCedula);
        yate.setId_tipo(idTipo);
        
        // Verificar valores
        System.out.println("Creando YateDTO:");
        System.out.println("matricula: " + yate.getMatricula());
        System.out.println("nombre: " + yate.getNombre());
        System.out.println("eslora: " + yate.getEslora());
        System.out.println("manga: " + yate.getManga());
        System.out.println("calado: " + yate.getCalado());
        System.out.println("usuario_dueno_cedula: " + yate.getUsuario_dueno_cedula());
        System.out.println("id_tipo: " + yate.getId_tipo());

        try {
            em.getTransaction().begin();
            repo.guardar(yate);
            em.getTransaction().commit();
            System.out.println("Yate creado exitosamente");
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al crear yate: " + e.getMessage());
            return;
        }
        
        // Redirigir a lista después de crear
        res.sendRedirect(req.getContextPath() + "/YateServlet?action=lista1");
    }

    private void edit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String matricula = req.getParameter("matricula");
        if (matricula == null || matricula.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta la matrícula del yate");
            return;
        }
        
        String nombre = req.getParameter("nombre");
        String esloraStr = req.getParameter("eslora");
        String mangaStr = req.getParameter("manga");
        String caladoStr = req.getParameter("calado");
        String usuarioDuenoCedula = req.getParameter("usuario_dueno_cedula");
        String idTipoStr = req.getParameter("id_tipo");
        
        // Validar parámetros
        if (nombre == null || nombre.isEmpty() ||
            esloraStr == null || esloraStr.isEmpty() ||
            mangaStr == null || mangaStr.isEmpty() ||
            caladoStr == null || caladoStr.isEmpty() ||
            usuarioDuenoCedula == null || usuarioDuenoCedula.isEmpty() ||
            idTipoStr == null || idTipoStr.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Faltan parámetros requeridos");
            return;
        }
        
        // Convertir tipos double
        double eslora, manga, calado;
        try {
            eslora = Double.parseDouble(esloraStr);
            manga = Double.parseDouble(mangaStr);
            calado = Double.parseDouble(caladoStr);
        } catch (NumberFormatException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "eslora, manga y calado deben ser números válidos");
            return;
        }
        
        // Convertir id_tipo a Long
        Long idTipo;
        try {
            idTipo = Long.parseLong(idTipoStr);
        } catch (NumberFormatException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "id_tipo debe ser un número válido");
            return;
        }

        YateDTO yateExistente = repo.porId(matricula);
        if (yateExistente == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND, "Yate no encontrado con matrícula: " + matricula);
            return;
        }

        // Actualizar todos los atributos
        yateExistente.setNombre(nombre);
        yateExistente.setEslora(eslora);
        yateExistente.setManga(manga);
        yateExistente.setCalado(calado);
        yateExistente.setUsuario_dueno_cedula(usuarioDuenoCedula);
        yateExistente.setId_tipo(idTipo);

        try {
            em.getTransaction().begin();
            repo.guardar(yateExistente);
            em.getTransaction().commit();
            System.out.println("Yate actualizado exitosamente: " + matricula);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al actualizar yate: " + e.getMessage());
            return;
        }

        res.sendRedirect(req.getContextPath() + "/YateServlet?action=lista1");
    }

    private void delete(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String matricula = req.getParameter("matricula");
        if (matricula == null || matricula.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta la matrícula del yate");
            return;
        }

        try {
            em.getTransaction().begin();
            repo.eliminar(matricula);
            em.getTransaction().commit();
            System.out.println("Yate eliminado exitosamente: " + matricula);
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            res.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al eliminar yate: " + e.getMessage());
            return;
        }

        res.sendRedirect(req.getContextPath() + "/YateServlet?action=lista1");
    }

    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/yate/Formulario.jsp")
                .forward(req, res);
    }

    private void mostrarLista(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/yate/Lista.jsp")
                .forward(req, res);
    }

    private void mostrarActualizacion(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/yate/FormularioEdicion.jsp")
                .forward(req, res);
    }

    private void mostrarEliminacion(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/yate/Deleter.jsp")
                .forward(req, res);
    }

    private void mostrarMain(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Implementación si es necesaria
    }

    @Override
    public String getServletInfo() {
        return "Servlet para manejo de Yates";
    }
}