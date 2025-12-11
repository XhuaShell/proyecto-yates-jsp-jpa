<%-- 
    Document   : Lista
    Created on : 10 dic 2025, 11:30:29
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yates.proyecto_yates.model.dto.TipoYateDTO" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Tipos de Yate</title>
    </head>
    <body>
        <h1>Tipos de Yate Registrados</h1>

        <table border="1">
            <tr>
                <th>Código</th>
                <th>Nombre</th>
                <th>Descripción</th>
            </tr>

            <%
                List<TipoYateDTO> tipos = (List<TipoYateDTO>) request.getAttribute("objetosCons");
                if (tipos != null) {
                    for (TipoYateDTO tipoYate : tipos) {
            %>
            <tr>
                <td><%= tipoYate.getNum_tipo_yate()%></td>
                <td><%= tipoYate.getNombre()%></td>
                <td><%= tipoYate.getDescripcion()%></td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="3">No hay tipos de yate registrados.</td>
            </tr>
            <%
                }
            %>
        </table>

        <form action="<%= request.getContextPath()%>/TipoYateServlet" method="GET">
            <input type="hidden" name="action" value="lista1">
            <button type="submit">Cargar lista</button>
        </form>

    </body>
</html>
