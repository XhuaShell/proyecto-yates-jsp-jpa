<%-- 
    Document   : Formulario
    Created on : 10 dic 2025, 11:30:11
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Tipo de Yate</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container py-5" style="max-width: 600px;">
            <h1 class="mb-4 text-center fw-semibold">Registrar Tipo de Yate</h1>

            <form action="${pageContext.request.contextPath}/TipoYateServlet?action=formulario" method="POST">
                <label for="nombre">Nombre:</label>
                <input type="text" id="nombre" name="nombre" required><br>

                <label for="descripcion">Descripción:</label>
                <textarea id="descripcion" name="descripcion"></textarea><br>

                <button type="submit">Enviar</button>
            </form>
        </div>
    </body>
</html>
