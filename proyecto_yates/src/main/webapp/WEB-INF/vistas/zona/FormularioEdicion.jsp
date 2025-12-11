<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Editar Zona</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container mt-4">
            <div class="card shadow-sm">
                <div class="card-header bg-primary text-white">
                    <h4 class="mb-0">Editar Información de la Zona</h4>
                </div>

                <div class="card-body">
                    <form action="${pageContext.request.contextPath}/ZonaServlet?action=edicion" method="POST">
                        <div class="mb-3">
                            <label for="id_zona" class="form-label">Id Zona</label>
                            <input type="text" class="form-control" id="id_zona" name="id_zona">
                        </div>

                        <div class="mb-3">
                            <label for="cuota_administracion" class="form-label">Cuota Administración</label>
                            <input type="number" step="0.01" class="form-control" id="cuota_administracion" name="cuota_administracion">
                        </div>

                        <div class="mb-3">
                            <label for="capacidad" class="form-label">Capacidad</label>
                            <input type="number" class="form-control" id="capacidad" name="capacidad">
                        </div>

                        <div class="mb-3">
                            <label for="profundidad" class="form-label">Profundidad</label>
                            <input type="number" step="0.01" class="form-control" id="profundidad" name="profundidad">
                        </div>

                        <div class="mb-3">
                            <label for="dim_max_eslora" class="form-label">Dim. Máx. Eslora</label>
                            <input type="number" step="0.01" class="form-control" id="dim_max_eslora" name="dim_max_eslora">
                        </div>

                        <div class="mb-3">
                            <label for="dim_max_manga" class="form-label">Dim. Máx. Manga</label>
                            <input type="number" step="0.01" class="form-control" id="dim_max_manga" name="dim_max_manga">
                        </div>

                        <div class="mb-3">
                            <label for="dim_max_calado" class="form-label">Dim. Máx. Calado</label>
                            <input type="number" step="0.01" class="form-control" id="dim_max_calado" name="dim_max_calado">
                        </div>

                        <div class="mb-3">
                            <label for="dim_min_eslora" class="form-label">Dim. Mín. Eslora</label>
                            <input type="number" step="0.01" class="form-control" id="dim_min_eslora" name="dim_min_eslora">
                        </div>

                        <div class="mb-3">
                            <label for="dim_min_manga" class="form-label">Dim. Mín. Manga</label>
                            <input type="number" step="0.01" class="form-control" id="dim_min_manga" name="dim_min_manga">
                        </div>

                        <div class="mb-3">
                            <label for="dim_min_calado" class="form-label">Dim. Mín. Calado</label>
                            <input type="number" step="0.01" class="form-control" id="dim_min_calado" name="dim_min_calado">
                        </div>

                        <button type="submit" class="btn btn-primary w-100">Guardar Cambios</button>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
