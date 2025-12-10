<%-- 
    Document   : Deleter
    Created on : 10 dic 2025, 11:20:51
    Author     : krate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Eliminar Socio</title>
</head>
<body>
  <h1>Eliminar Socio</h1>

  <form action="${pageContext.request.contextPath}/SocioServlet?action=delete" method="POST">
    <label for="codigo">Código de socio:</label>
    <input type="text" id="codigo" name="codigo" required><br><br>

    <button type="submit">Enviar</button>
  </form>
</body>
</html>

