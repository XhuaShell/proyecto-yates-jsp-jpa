<%-- 
    Document   : Deleter
    Created on : 10 dic 2025, 11:30:01
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Eliminar Tipo de Yate</title>
</head>
<body>
<h1>Eliminar Tipo de Yate</h1>
<form action="${pageContext.request.contextPath}/TipoyateServlet?action=delete&_method=DELETE" method="POST">

    <label for="codigo">Código del Tipo de Yate:</label>
    <input type="text" id="codigo" name="codigo" required><br><br>

    <button type="submit">Eliminar</button>
</form>
</body>
</html>
