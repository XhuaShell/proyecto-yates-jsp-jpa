<%-- 
    Document   : FormularioEdicion
    Created on : 10 dic 2025, 11:03:41
    Author     : krate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Editar Empleado</title>
</head>
<body>
  <h1>Editar Empleado</h1>

  <form action="${pageContext.request.contextPath}/EmpleadoServlet?action=edicion" method="POST">

    <label for="codigo">Código de empleado:</label>
    <input type="text" id="codigo" name="codigo" required><br><br>

    <label for="nombre">Nombre:</label>
    <input type="text" id="nombre" name="nombre" ><br><br>

    <label for="cedula">Cédula:</label>
    <input type="number" id="cedula" name="cedula" ><br><br>

    <label for="fecha_vinculacion">Fecha de Vinculación:</label>
    <input type="date" id="fecha_vinculacion" name="fecha_vinculacion" ><br><br>
    
    <label for="direccion">Dirección:</label>
    <input type="text" id="direccion" name="direccion" ><br><br>

    <label for="telefono">Número telefónico:</label>
    <input type="number" id="telefono" name="telefono" ><br><br>

    <button type="submit">Enviar</button>
  </form>
</body>
</html>

