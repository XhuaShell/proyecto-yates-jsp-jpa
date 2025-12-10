<%-- 
    Document   : Lista
    Created on : 10 dic 2025, 11:21:16
    Author     : krate
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yates.proyecto_yates.model.dto.UsuarioDTO" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Usuarios</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4 text-center">Lista de Usuarios Registrados</h1>

    <div class="table-responsive shadow-sm rounded">
        <table class="table table-striped table-hover align-middle text-center">
            <thead class="table-dark">
                <tr>
                    <th>Cédula</th>
                    <th>Nombre</th>
                    <th>Fecha Vinculación</th>
                    <th>Dirección</th>
                    <th>Teléfono</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<UsuarioDTO> usuarios = (List<UsuarioDTO>) request.getAttribute("objetosCons");
                    if (usuarios != null) {
                        for (UsuarioDTO u : usuarios) {
                %>
                <tr>
                    <td><%= u.getCedula() %></td>
                    <td><%= u.getNombre() %></td>
                    <td><%= u.getFechaVinculacion() %></td>
                    <td><%= u.getDireccion() %></td>
                    <td><%= u.getTelefono() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="5">No hay usuarios registrados.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

    <div class="text-center mt-3">
        <a href="<%= request.getContextPath() %>/UsuarioServlet?action=lista1" class="btn btn-primary">
            Cargar lista
        </a>
    </div>
</div>
</body>
</html>


