<%-- 
    Document   : Formulario
    Created on : 10 dic 2025, 11:30:11
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Registrar Tipo de Yate</title>
</head>
<body>
<h1>Registrar Tipo de Yate</h1>
<form action="${pageContext.request.contextPath}/TipoyateServlet?action=formulario" method="POST">

    <label for="codigo">Código:</label>
    <input type="text" id="codigo" name="codigo" required><br><br>

    <label for="nombre">Nombre del Tipo:</label>
    <input type="text" id="nombre" name="nombre" required><br><br>

    <label for="descripcion">Descripción:</label>
    <textarea id="descripcion" name="descripcion"></textarea><br><br>

    <button type="submit">Enviar</button>
</form>
</body>
</html>

