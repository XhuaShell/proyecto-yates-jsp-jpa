<%-- 
    Document   : Lista
    Created on : 10 dic 2025, 11:03:48
    Author     : krate
--%>

<%@page import="java.util.List"%>
<%@page import="com.yates.proyecto_yates.model.dto.EmpleadoDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Lista de Empleados</title>
</head>
<body>

<h1>Lista de Empleados Registrados</h1>

<table border="1">
  <tr>
    <th>Código</th>
    <th>Nombre</th>
    <th>Cédula</th>
    <th>Fecha Vinculación</th>
    <th>Dirección</th>
    <th>Teléfono</th>
  </tr>

  <% 
    List<EmpleadoDTO> empleados = (List<EmpleadoDTO>) request.getAttribute("empleados");
    if (empleados != null) {
        for (EmpleadoDTO s : empleados) {
  %>
    <tr>
      <td><%= s.getId_empleado() %></td>
      <td><%= s.getNombre() %></td>
      <td><%= s.getCedula() %></td>
      <td><%= s.getFechaVinculacion() %></td>
      <td><%= s.getDireccion() %></td>
      <td><%= s.getTelefono() %></td>
    </tr>
  <% 
        }
    } 
  %>
</table>

<form action="${pageContext.request.contextPath}/EmpleadoServlet?action=lista" method="GET">
  <button type="submit">Cargar lista</button>
</form>

</body>
</html>

