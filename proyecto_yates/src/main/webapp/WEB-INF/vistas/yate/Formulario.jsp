<%-- 
    Document   : FormularioYate
    Created on : 10 dic 2025
    Author     : krate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registrar Yate</title>
</head>
<body>

    <h1>Registrar Yate</h1>

    <form action="${pageContext.request.contextPath}/YateServlet?action=formulario" method="POST">

        <label for="matricula">Matrícula:</label>
        <input type="text" id="matricula" name="matricula" required><br><br>

        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>

        <label for="eslora">Eslora (m):</label>
        <input type="number" id="eslora" name="eslora" step="0.01" required><br><br>

        <label for="manga">Manga (m):</label>
        <input type="number" id="manga" name="manga" step="0.01" required><br><br>

        <label for="calado">Calado (m):</label>
        <input type="number" id="calado" name="calado" step="0.01" required><br><br>

        <label for="usuario_dueno_cedula">Cédula del Dueño:</label>
        <input type="text" id="usuario_dueno_cedula" name="usuario_dueno_cedula" required><br><br>

        <label for="id_tipo">Tipo de Yate:</label>
        <select id="id_tipo" name="id_tipo" required>
            <option disabled selected value="">Seleccione un tipo</option>
            <c:forEach var="t" items="${tipos}">
                <option value="${t.id_tipo}">${t.id_tipo}</option>
            </c:forEach>
        </select>
        <br><br>

        <button type="submit">Enviar</button>
    </form>

</body>
</html>
