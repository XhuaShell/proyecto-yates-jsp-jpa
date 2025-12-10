<%-- 
    Document   : FormularioEdicion
    Created on : 10 dic 2025, 11:21:10
    Author     : krate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container mt-4">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">Editar Información del Socio</h4>
                </div>

                <div class="card-body">

                    <form action="${pageContext.request.contextPath}/SocioServlet?action=edicion" method="POST">

                        <p><strong>Cédula:</strong> ${usuario.cedula}</p>
                        <p><strong>Email:</strong> ${usuario.email}</p>
                        <p><strong>Tipo de Usuario:</strong> ${usuario.tipoUsuario}</p>

                        <label for="nombre">Nombre</label>
                        <input type="text" id="nombre" name="nombre" value="${usuario.nombre}" />

                        <label for="direccion">Dirección</label>
                        <input type="text" id="direccion" name="direccion" value="${usuario.direccion}" />

                        <label for="telefono">Teléfono</label>
                        <input type="number" id="telefono" name="telefono" value="${usuario.telefono}" />

                        <label for="fecha_vinculacion">Fecha de Vinculación</label>
                        <input type="date" id="fecha_vinculacion" name="fecha_vinculacion" value="${usuario.fechaVinculacion}" />

                        <button type="subm

    </body>
</html>
