<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yates.proyecto_yates.model.dto.VentaDTO" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Ventas</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <h1 class="mb-4 text-center">Lista de Ventas Registradas</h1>

    <div class="table-responsive shadow-sm rounded">
        <table class="table table-striped table-hover align-middle text-center">
            <thead class="table-dark">
                <tr>
                    <th>Número Venta</th>
                    <th>Fecha</th>
                    <th>Monto</th>
                    <th>Número Amarre</th>
                    <th>Vendedor</th>
                    <th>Comprador</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<VentaDTO> ventas = (List<VentaDTO>) request.getAttribute("objetosCons");
                    if (ventas != null) {
                        for (VentaDTO v : ventas) {
                %>
                <tr>
                    <td><%= v.getNum_venta() %></td>
                    <td><%= v.getFecha() %></td>
                    <td><%= v.getMonto() %></td>
                    <td><%= v.getNum_amarre() %></td>
                    <td><%= v.getVendedor_cedula() %></td>
                    <td><%= v.getComprador_cedula() %></td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="6">No hay ventas registradas.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>

    <div class="text-center mt-3">
        <a href="<%= request.getContextPath() %>/VentaServlet?action=lista1" class="btn btn-primary">
            Cargar lista
        </a>
    </div>
</div>
</body>
</html>
