<%-- 
    Document   : ListaZonas
    Created on : 10 dic 2025
    Author     : krate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Zonas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-4">

    <h1 class="mb-4 text-center">Lista de Zonas Registradas</h1>

    <div class="table-responsive shadow-sm rounded">
        <table class="table table-striped table-bordered table-hover align-middle text-center">
            <thead class="table-dark">
                <tr>
                    <th>Id Zona</th>
                    <th>Cuota Administración</th>
                    <th>Capacidad</th>
                    <th>Profundidad</th>
                    <th>Dim. Máx. Eslora</th>
                    <th>Dim. Máx. Manga</th>
                    <th>Dim. Máx. Calado</th>
                    <th>Dim. Mín. Eslora</th>
                    <th>Dim. Mín. Manga</th>
                    <th>Dim. Mín. Calado</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="z" items="${objetosCons}">
                    <tr>
                        <td>${z.id_zona}</td>
                        <td>${z.cuota_administracion}</td>
                        <td>${z.capacidad}</td>
                        <td>${z.profundidad}</td>
                        <td>${z.dim_max_eslora}</td>
                        <td>${z.dim_max_manga}</td>
                        <td>${z.dim_max_calado}</td>
                        <td>${z.dim_min_eslora}</td>
                        <td>${z.dim_min_manga}</td>
                        <td>${z.dim_min_calado}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <div class="text-center mt-3">
        <a href="${pageContext.request.contextPath}/ZonaServlet?action=lista" class="btn btn-primary">
            Cargar lista
        </a>
    </div>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
