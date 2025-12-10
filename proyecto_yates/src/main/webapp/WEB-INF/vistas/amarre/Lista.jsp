<%-- 
    Document   : Lista
    Created on : 10 dic 2025, 10:54:07
    Author     : krate
--%>

<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 class="mb-4">Lista de Amarres Registrados</h1>

        <div class="table-responsive shadow-sm rounded">
            <table class="table table-striped table-hover align-middle">
                <thead class="table-dark">
                    <tr>
                        <th>Número de Amarre</th>
                        <th>ID de Zona</th>
                        <th>Cédula del Propietario</th>
                        <th>Fecha de Compra</th>
                    </tr>
                </thead>

                <tbody>
                    <%
                        List<com.yates.proyecto_yates.model.entity.AmarreEntity> objetosCons
                                = (List<com.yates.proyecto_yates.model.entity.AmarreEntity>) request.getAttribute("objetosCons");

                        if (objetosCons != null) {
                            for (com.yates.proyecto_yates.model.entity.AmarreEntity s : objetosCons) {
                    %>
                    <tr>
                        <td><%= s.getNum_amarre()%></td>
                        <td><%= s.getZona()%></td>
                    </tr>
                    <%
                            }
                        }
                    %>
                </tbody>
            </table>
        </div>

        <nav class="nav mb-4 p-2 bg-dark rounded shadow-sm">
            <a href="${pageContext.request.contextPath}/AmarreServlet?action=lista1" class="btn btn-outline-light me-2">Cargar lista</a>
            <a href="${pageContext.request.contextPath}/AmarreServlet?action=formulario" class="btn btn-outline-light me-2">Agregar Nuevo Amarre</a>
            <a href="#" class="btn btn-outline-light me-2">Listar amarres por dueño</a>
            <a href="#" class="btn btn-outline-light">Listar amarres por zona</a>
        </nav>

    </body>
</html>
