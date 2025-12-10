<%-- 
    Document   : Deleter
    Created on : 10 dic 2025, 9:57:54
    Author     : krate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Eliminar Amarre</title>
</head>
<body>
  <h1>Eliminar Amarre</h1>

  <form action="AmarreServlet?action=delete" method="POST">
    <input type="hidden" name="_method" value="DELETE">

    <label for="num_amarre">Código de Amarre:</label>
    <input type="text" id="num_amarre" name="num_amarre" required><br><br>

    <button type="submit">Eliminar</button>
  </form>

</body>
</html>

