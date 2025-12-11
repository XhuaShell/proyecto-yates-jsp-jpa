<%-- 
    Document   : FormularioEdicion
    Created on : 10 dic 2025, 11:30:22
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.yates.proyecto_yates.model.dto.TipoYateDTO" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Tipo de Yate</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>

        <%
            TipoYateDTO t = (TipoYateDTO) request.getAttribute("tipoYate");
        %>

        <div class="container mt-4">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">Editar Tipo de Yate</h4>
                </div>

                <div class="card-body">
                    <form action="<%= request.getContextPath()%>/TipoYateServlet?action=edicion" method="POST">

                        <div class="mb-3">
                            <label for="num_tipo_yate" class="form-label">Código (obligatorio)</label>
                            <input 
                                type="text" 
                                class="form-control" 
                                id="num_tipo_yate" 
                                name="num_tipo_yate" 
                                value="<%= (t != null ? t.getNum_tipo_yate() : "")%>"
                                required
                                >
                        </div>

                        <div class="mb-3">
                            <label for="nombre" class="form-label">Nombre (opcional)</label>
                            <input 
                                type="text" 
                                class="form-control" 
                                id="nombre" 
                                name="nombre" 
                                value="<%= (t != null ? t.getNombre() : "")%>"
                                >
                        </div>

                        <div class="mb-3">
                            <label for="descripcion" class="form-label">Descripción (opcional)</label>
                            <textarea 
                                class="form-control" 
                                id="descripcion" 
                                name="descripcion"
                                ><%= (t != null ? t.getDescripcion() : "")%></textarea>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">
                            Guardar Cambios
                        </button>
                    </form>
                </div>
            </div>
        </div>

    </body>
</html>
