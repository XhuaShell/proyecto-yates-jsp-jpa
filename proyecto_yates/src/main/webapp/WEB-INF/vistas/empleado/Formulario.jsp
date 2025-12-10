<%-- 
    Document   : Formulario
    Created on : 10 dic 2025, 11:03:33
    Author     : krate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Registrar Empleado</title>
</head>
<body>
  <h1>Registrar Empleado</h1>

  <form action="${pageContext.request.contextPath}/EmpleadoServlet?action=formulario" method="POST">

    <label for="codigo">Código de Empleado:</label>
    <input type="text" id="codigo" name="codigo" required><br><br>

    <label for="cedula">Cédula:</label>
    <input type="number" id="cedula" name="cedula" required><br><br>

    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" required><br><br>

    <label for="direccion">Dirección:</label>
    <input type="text" id="direccion" name="direccion" required><br><br>

    <label for="fecha_vinculacion">Fecha de Vinculación:</label>
    <input type="date" id="fecha_vinculacion" name="fecha_vinculacion" required><br><br>
    
    <label for="salario">Salario:</label>
    <input type="number" id="salario" name="salario" required><br><br>

    <label for="telefono">Número Telefónico:</label>
    <input type="number" id="telefono" name="telefono" required><br><br>

    <button type="submit">Enviar</button>
  </form>
</body>
</html>

