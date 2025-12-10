<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Socio</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-4">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">Editar Información del Socio</h4>
                </div>

                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/UsuarioServlet?action=edicion" method="POST">
                        <div class="mb-3">
                            <label for="cedula" class="form-label">Cédula (obligatoria)</label>
                            <input 
                                type="text" 
                                class="form-control" 
                                id="cedula" 
                                name="cedula" 
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
                                >
                        </div>

                        <div class="mb-3">
                            <label for="direccion" class="form-label">Dirección (opcional)</label>
                            <input 
                                type="text" 
                                class="form-control" 
                                id="direccion" 
                                name="direccion" 
                                >
                        </div>

                        <div class="mb-3">
                            <label for="telefono" class="form-label">Número Telefónico (opcional)</label>
                            <input 
                                type="number" 
                                class="form-control" 
                                id="telefono" 
                                name="telefono" 
                                >
                        </div>

                        <div class="mb-3">
                            <label for="fecha_vinculacion" class="form-label">Fecha de Vinculación (opcional)</label>
                            <input 
                                type="date" 
                                class="form-control" 
                                id="fecha_vinculacion" 
                                name="fecha_vinculacion" 
                                >
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
