<%-- 
    Document   : Deleter
    Created on : 10 dic 2025, 20:30:00
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Eliminar Venta</title>
</head>
<body>
    <h1>Eliminar Venta</h1>

    <form action="${pageContext.request.contextPath}/VentaServlet?action=delete" method="POST">
        <label for="num_venta">Número de Venta:</label>
        <input type="text" id="num_venta" name="num_venta" required><br><br>

        <button type="submit">Eliminar</button>
    </form>
</body>
</html>
