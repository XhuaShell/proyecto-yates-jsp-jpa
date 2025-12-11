package com.yates.proyecto_yates.controller;

import com.yates.proyecto_yates.model.TipoUsuario;
import com.yates.proyecto_yates.model.dto.UsuarioDTO;
import com.yates.proyecto_yates.model.repositorys.UsuarioRepository;
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
import java.time.LocalDate;
import java.util.List;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("YatePU");
    EntityManager em = emf.createEntityManager();

    UsuarioRepository repo = new UsuarioRepository(em);

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet UsuarioServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet UsuarioServlet at " + request.getContextPath() + "</h1>");
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
                System.out.println("Hola, esot en el metodo get");
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
                System.out.println("Hola, esot en el metodo get");

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

    private void getLista(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // GET /AmarreServlet?action=lista&id=1
        List<UsuarioDTO> socios = repo.listar(); // Leer desde BD
        req.setAttribute("objetosCons", socios); // Pasar al JSP
        req.getRequestDispatcher("/WEB-INF/vistas/usuarios/Lista.jsp")
                .forward(req, res);
        System.out.println("Usuarios encontrados: " + socios.size());

    }

    private void create(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        // POST /AmarreServlet?action=formulario
        String ced = req.getParameter("cedula");
        String nom = req.getParameter("nombre");
        String fechaStr = req.getParameter("fecha_vinculacion");
        LocalDate fechaVinculacion = null;
        if (fechaStr != null && !fechaStr.isEmpty()) {
            fechaVinculacion = LocalDate.parse(fechaStr);
        }
        String direc = req.getParameter("direccion");
        String telefono = req.getParameter("telefono");
        String mail = req.getParameter("email");
        String contr = req.getParameter("contraseña");
        TipoUsuario tip = TipoUsuario.NORMAL;

        UsuarioDTO usu = new UsuarioDTO(ced, nom, direc, telefono, mail, fechaVinculacion, tip, contr);

// Verificar valores
        System.out.println("Creando UsuarioDTO:");
        System.out.println("Cédula: " + usu.getCedula());
        System.out.println("Nombre: " + usu.getNombre());
        System.out.println("Dirección: " + usu.getDireccion());
        System.out.println("Teléfono: " + usu.getTelefono());
        System.out.println("Email: " + usu.getMail());
        System.out.println("Contraseña: " + usu.getContrasena());
        System.out.println("Fecha Vinculación: " + usu.getFechaVinculacion());
        System.out.println("Tipo Usuario: " + usu.getTipoUsuario());

        try {
            em.getTransaction().begin();  // 1. Iniciar transacción
            repo.guardar(usu);            // 2. Marcar cambios
            em.getTransaction().commit(); // 3. Confirmar cambios en la DB
        } catch (Exception e) {
            em.getTransaction().rollback(); // deshacer si algo falla
            e.printStackTrace();
        }
        req.getRequestDispatcher("/WEB-INF/vistas/index.jsp")
                .forward(req, res);
    }

    private void edit(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String cedula = req.getParameter("cedula");
        if (cedula == null || cedula.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta la cédula del usuario");
            return;
        }

        String nombre = req.getParameter("nombre");
        String direccion = req.getParameter("direccion");
        String telefono = req.getParameter("telefono");
        String fechaStr = req.getParameter("fecha_vinculacion");

        LocalDate fechaVinculacion = null;
        if (fechaStr != null && !fechaStr.isEmpty()) {
            fechaVinculacion = LocalDate.parse(fechaStr);
        }

        UsuarioDTO usuarioExistente = repo.porId(cedula);
        if (usuarioExistente == null) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND, "Usuario no encontrado");
            return;
        }

        usuarioExistente.setNombre(nombre);
        usuarioExistente.setDireccion(direccion);
        usuarioExistente.setTelefono(telefono);
        usuarioExistente.setFechaVinculacion(fechaVinculacion);

        em.getTransaction().begin();
        repo.guardar(usuarioExistente);
        em.getTransaction().commit();

        res.sendRedirect(req.getContextPath() + "/UsuarioServlet?action=lista1");
    }

    private void delete(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        String cedula = req.getParameter("codigo");
        if (cedula == null || cedula.isEmpty()) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, "Falta la cédula del usuario");
            return;
        }

        try {
            em.getTransaction().begin();
            repo.eliminar(cedula);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        res.sendRedirect(req.getContextPath() + "/UsuarioServlet?action=lista1");
    }

    private void mostrarFormulario(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        // Aquí haces forward a JSP o imprimes HTML
        req.getRequestDispatcher("/WEB-INF/vistas/usuarios/Formulario.jsp")
                .forward(req, res);
    }

    private void mostrarLista(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/usuarios/Lista.jsp")
                .forward(req, res);
    }

    private void mostrarActualizacion(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/usuarios/FormularioEdicion.jsp")
                .forward(req, res);
    }

    private void mostrarEliminacion(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/vistas/usuarios/Deleter.jsp")
                .forward(req, res);
    }

    private void mostrarMain(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    }

}
