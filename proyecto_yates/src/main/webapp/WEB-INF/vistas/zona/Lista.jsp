<%-- 
    Document   : ListaZonas
    Created on : 10 dic 2025
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yates.proyecto_yates.model.dto.ZonaDTO" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Lista de Zonas</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-4">
            <h1 class="mb-4 text-center">Lista de Zonas Registradas</h1>

            <div class="table-responsive shadow-sm rounded">
                <table class="table table-striped table-hover align-middle text-center">
                    <thead class="table-dark">
                        <tr>
                            <th>Id Zona</th>
                            <th>Cuota Administración</th>
                            <th>Capacidad</th>
                            <th>Profundidad</th>
                            <th>Dim. Máx. Eslora</th>
                            <th>Dim. Máx. Manga</th>
                            <th>Dim. Máx. Calado</th>
                            <th>Dim. Mín. Eslora</th>
                            <th>Dim. Mín. Manga</th>
                            <th>Dim. Mín. Calado</th>
                        </tr>
                    </thead>
                    <tbody>
                        <%
                            List<ZonaDTO> zonas = (List<ZonaDTO>) request.getAttribute("objetosCons");
                            if (zonas != null) {
                                for (ZonaDTO z : zonas) {
                        %>
                        <tr>
                            <td><%= z.getId_zona()%></td>
                            <td><%= z.getCuota_administracion()%></td>
                            <td><%= z.getCapacidad()%></td>
                            <td><%= z.getProfundidad()%></td>
                            <td><%= z.getDim_max_eslora()%></td>
                            <td><%= z.getDim_max_manga()%></td>
                            <td><%= z.getDim_max_calado()%></td>
                            <td><%= z.getDim_min_eslora()%></td>
                            <td><%= z.getDim_min_manga()%></td>
                            <td><%= z.getDim_min_calado()%></td>
                        </tr>
                        <%
                            }
                        } else {
                        %>
                        <tr>
                            <td colspan="10">No hay zonas registradas.</td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>
                </table>
            </div>

            <div class="text-center mt-3">
                <a href="<%= request.getContextPath()%>/ZonaServlet?action=getLista" class="btn btn-primary">
                    Cargar lista
                </a>
            </div>
        </div>
    </body>
