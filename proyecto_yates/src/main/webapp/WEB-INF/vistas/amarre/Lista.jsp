<%-- 
    Document   : ListaAmarres
    Created on : 10 dic 2025
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yates.proyecto_yates.model.dto.AmarreDTO" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Amarres</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-4">
            <h1 class="mb-4 text-center">Lista de Amarres</h1>

            <div class="table-responsive shadow-sm rounded">
                <table class="table table-striped table-hover align-middle text-center">
                    <thead class="table-dark">
                        <tr>
                            <th>Número de Amarre</th>
                            <th>ID Zona</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<AmarreDTO> amarres = (List<AmarreDTO>) request.getAttribute("objetosCons");
                            if (amarres != null) {
                                for (AmarreDTO a : amarres) {
                        %>
                        <tr>
                            <td><%= a.getNum_amarre()%></td>
                            <td><%= a.getId_zona()%></td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="2">No hay amarres registrados.</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <div class="text-center mt-3">
                <a href="<%= request.getContextPath()%>/AmarreServlet?action=lista1" class="btn btn-primary">
                    Cargar lista
                </a>
            </div>
        </div>
    </body>
</html>
