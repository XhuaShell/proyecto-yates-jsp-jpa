<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.yates.proyecto_yates.model.dto.YateDTO"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Yates</title>
</head>
<body>
    <h1>Lista de Yates</h1>
    
    <%
        List<YateDTO> yates = (List<YateDTO>) request.getAttribute("objetosCons");
        
        if (yates == null || yates.isEmpty()) {
    %>
            <p>No hay yates registrados.</p>
    <%
        } else {
    %>
            <table border="1">
                <tr>
                    <th>Matrícula</th>
                    <th>Nombre</th>
                    <th>Eslora</th>
                    <th>Manga</th>
                    <th>Calado</th>
                    <th>Cédula Dueño</th>
                    <th>ID Tipo</th>
                    <th>Acciones</th>
                </tr>
    <%
            for (YateDTO yate : yates) {
    %>
                <tr>
                    <td><%= yate.getMatricula() %></td>
                    <td><%= yate.getNombre() %></td>
                    <td><%= yate.getEslora() %></td>
                    <td><%= yate.getManga() %></td>
                    <td><%= yate.getCalado() %></td>
                    <td><%= yate.getUsuario_dueno_cedula() %></td>
                    <td><%= yate.getId_tipo() %></td>
                    <td>
                        <a href="YateServlet?action=edicion&codigo=<%= yate.getMatricula() %>">Editar</a>
                        <a href="YateServlet?action=delete&codigo=<%= yate.getMatricula() %>" 
                           onclick="return confirm('¿Eliminar yate <%= yate.getMatricula() %>?')">Eliminar</a>
                    </td>
                </tr>
    <%
            }
    %>
            </table>
    <%
        }
    %>
    
    <br>
    <a href="YateServlet?action=formulario">Nuevo Yate</a>
</body>
</html>