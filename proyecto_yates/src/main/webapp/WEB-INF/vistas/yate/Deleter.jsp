<%-- 
    Document   : DeleteYate
    Created on : 10 dic 2025
    Author     : krate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Eliminar Yate</title>
</head>
<body>

    <h1>Eliminar Yate</h1>

    <form action="${pageContext.request.contextPath}/YateServlet?action=delete" method="POST">
        <input type="hidden" name="_method" value="DELETE">

        <label for="matricula">Matrícula del yate:</label>
        <input type="text" id="matricula" name="matricula" required><br><br>

        <button type="submit">Enviar</button>
    </form>

</body>
</html>
