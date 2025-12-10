<%-- 
    Document   : FormularioEdicion
    Created on : 10 dic 2025, 11:30:22
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Tipo de Yate</title>
</head>
<body>
<h1>Editar Tipo de Yate</h1>
<form action="${pageContext.request.contextPath}/TipoyateServlet?action=edicion&_method=PATCH" method="POST">

    <label for="codigo">Código:</label>
    <input type="text" id="codigo" name="codigo" value="${tipoYate.codigo}" required><br><br>

    <label for="nombre">Nombre del Tipo:</label>
    <input type="text" id="nombre" name="nombre" value="${tipoYate.nombre}" required><br><br>

    <label for="descripcion">Descripción:</label>
    <textarea id="descripcion" name="descripcion">${tipoYate.descripcion}</textarea><br><br>

    <button type="submit">Guardar Cambios</button>
</form>
</body>
</html>
