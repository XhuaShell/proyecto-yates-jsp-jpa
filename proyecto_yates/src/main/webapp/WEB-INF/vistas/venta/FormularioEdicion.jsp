<%-- 
    Document   : FormularioEdicionVenta
    Created on : 10 dic 2025, 20:22:16
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yates.proyecto_yates.model.dto.VentaDTO" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Venta</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-4">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">Editar Información de la Venta</h4>
                </div>

                <div class="card-body">
                    <%
                        VentaDTO venta = (VentaDTO) request.getAttribute("venta");
                    %>
                    <form action="<%= request.getContextPath()%>/VentaServlet?action=edicion" method="POST">

                        <div class="mb-3">
                            <label for="num_venta" class="form-label">Número de Venta</label>
                            <input type="text" class="form-control" id="num_venta" name="num_venta" 
                                   value="<%= venta != null ? venta.getNum_venta() : ""%>" required>
                        </div>

                        <div class="mb-3">
                            <label for="fecha" class="form-label">Fecha</label>
                            <input type="date" class="form-control" id="fecha" name="fecha" 
                                   value="<%= venta != null ? venta.getFecha() : ""%>" required>
                        </div>

                        <div class="mb-3">
                            <label for="monto" class="form-label">Monto</label>
                            <input type="number" step="0.01" class="form-control" id="monto" name="monto" 
                                   value="<%= venta != null ? venta.getMonto() : ""%>" required>
                        </div>

                        <div class="mb-3">
                            <label for="num_amarre" class="form-label">Número de Amarre</label>
                            <input type="text" class="form-control" id="num_amarre" name="num_amarre" 
                                   value="<%= venta != null ? venta.getNum_amarre() : ""%>" required>
                        </div>

                        <div class="mb-3">
                            <label for="vendedor_cedula" class="form-label">Cédula del Vendedor</label>
                            <input type="text" class="form-control" id="vendedor_cedula" name="vendedor_cedula" 
                                   value="<%= venta != null ? venta.getVendedor_cedula() : ""%>" required>
                        </div>

                        <div class="mb-3">
                            <label for="comprador_cedula" class="form-label">Cédula del Comprador</label>
                            <input type="text" class="form-control" id="comprador_cedula" name="comprador_cedula" 
                                   value="<%= venta != null ? venta.getComprador_cedula() : ""%>" required>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">Guardar Cambios</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
