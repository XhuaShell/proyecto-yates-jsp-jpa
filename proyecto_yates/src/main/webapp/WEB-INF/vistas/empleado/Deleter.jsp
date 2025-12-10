<%-- 
    Document   : Deleter
    Created on : 10 dic 2025, 11:03:25
    Author     : krate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Eliminar Empleado</title>
</head>
<body>
  <h1>Eliminar Empleado</h1>

  <form action="${pageContext.request.contextPath}/EmpleadoServlet?action=delete" method="POST">
      <label for="codigo">Código de empleado:</label>
      <input type="text" id="codigo" name="codigo" required><br><br>

      <button type="submit">Enviar</button>
  </form>
</body>
</html>

