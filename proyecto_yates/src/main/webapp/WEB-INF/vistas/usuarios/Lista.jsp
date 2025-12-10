<%-- 
    Document   : Lista
    Created on : 10 dic 2025, 11:21:16
    Author     : krate
--%>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Socios</title>
</head>
<body>

<h1>Lista de Socios Registrados</h1>

<table border="1">
    <tr>
        <th>Cédula</th>
        <th>Nombre</th>
        <th>Fecha Vinculación</th>
        <th>Dirección</th>
        <th>Teléfono</th>
    </tr>

    <c:forEach var="socio" items="${objetosCons}">
        <tr>
            <td>${socio.cedula}</td>
            <td>${socio.nombre}</td>
            <td>${socio.fechaVinculacion}</td>
            <td>${socio.direccion}</td>
            <td>${socio.telefono}</td>
        </tr>
    </c:forEach>

</table>

<form action="${pageContext.request.contextPath}/SocioServlet?action=lista1" method="GET">
    <button type="submit">Cargar lista</button>
</form>

</body>
</html>

