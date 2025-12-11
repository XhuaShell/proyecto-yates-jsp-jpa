<%-- 
    Document   : Formulario
    Created on : 10 dic 2025, 20:22:02
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Venta</title>
    </head>
    <body>
        <h1>Registrar Venta</h1>
        <form action="${pageContext.request.contextPath}/VentaServlet?action=formulario" method="POST">
            
            <label for="num_venta">Número de Venta:</label>
            <input type="text" id="num_venta" name="num_venta"><br><br>

            <label for="fecha">Fecha:</label>
            <input type="date" id="fecha" name="fecha"><br><br>

            <label for="monto">Monto:</label>
            <input type="number" step="0.01" id="monto" name="monto"><br><br>

            <label for="num_amarre">Número de Amarre:</label>
            <input type="text" id="num_amarre" name="num_amarre"><br><br>

            <label for="vendedor_cedula">Cédula del Vendedor:</label>
            <input type="text" id="vendedor_cedula" name="vendedor_cedula"><br><br>

            <label for="comprador_cedula">Cédula del Comprador:</label>
            <input type="text" id="comprador_cedula" name="comprador_cedula"><br><br>

            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
