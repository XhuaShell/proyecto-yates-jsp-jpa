<%-- 
    Document   : Lista
    Created on : 10 dic 2025, 11:30:29
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Tipos de Yate</title>
</head>
<body>
<h1>Tipos de Yate Registrados</h1>

<table border="1">
    <tr>
        <th>Código</th>
        <th>Nombre</th>
        <th>Descripción</th>
    </tr>

    <c:forEach var="tipoYate" items="${objetosCons}">
        <tr>
            <td>${tipoYate.codigo}</td>
            <td>${tipoYate.nombre}</td>
            <td>${tipoYate.descripcion}</td>
        </tr>
    </c:forEach>
</table>

<form action="${pageContext.request.contextPath}/TipoyateServlet?action=lista1" method="GET">
    <button type="submit">Cargar lista</button>
</form>

</body>
</html>

