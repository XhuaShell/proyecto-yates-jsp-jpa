<%-- 
    Document   : FormularioEdicion
    Created on : 10 dic 2025, 10:54:00
    Author     : krate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Formulario Actualización Amarre</title>
</head>
<body>
  <h1>Editar Amarre</h1>

  <form action="${pageContext.request.contextPath}/AmarreServlet?action=edicion" method="POST">

    <label for="num_amarre">Código de Amarre:</label>
    <input type="text" id="num_amarre" name="num_amarre" required><br><br>

    <label for="id_zona">ID Zona:</label>
    <input type="text" id="id_zona" name="id_zona"><br><br>

    <label for="usuario_propietario_cedula">Cédula del Propietario:</label>
    <input type="text" id="usuario_propietario_cedula" name="usuario_propietario_cedula"><br><br>

    <label for="fecha_compra">Fecha de Compra:</label>
    <input type="date" id="fecha_compra" name="fecha_compra"><br><br>

    <button type="submit">Enviar</button>

  </form>

</body>
</html>

