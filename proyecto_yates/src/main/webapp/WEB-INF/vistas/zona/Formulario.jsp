<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Zona</title>
    </head>
    <body>
        <div class="container py-5" style="max-width: 600px;">
            <h1 class="mb-4 text-center fw-semibold">Registrar Zona</h1>

            <form action="${pageContext.request.contextPath}/ZonaServlet?action=formulario" method="POST">

                <div class="mb-3">
                    <label for="id_zona" class="form-label">Id Zona</label>
                    <input type="text" id="id_zona" name="id_zona" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="cuota_administracion" class="form-label">Cuota Administración</label>
                    <input type="number" step="0.01" id="cuota_administracion" name="cuota_administracion" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="capacidad" class="form-label">Capacidad</label>
                    <input type="number" id="capacidad" name="capacidad" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="profundidad" class="form-label">Profundidad</label>
                    <input type="number" step="0.01" id="profundidad" name="profundidad" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="dim_max_eslora" class="form-label">Dim. Máx. Eslora</label>
                    <input type="number" step="0.01" id="dim_max_eslora" name="dim_max_eslora" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="dim_max_manga" class="form-label">Dim. Máx. Manga</label>
                    <input type="number" step="0.01" id="dim_max_manga" name="dim_max_manga" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="dim_max_calado" class="form-label">Dim. Máx. Calado</label>
                    <input type="number" step="0.01" id="dim_max_calado" name="dim_max_calado" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="dim_min_eslora" class="form-label">Dim. Mín. Eslora</label>
                    <input type="number" step="0.01" id="dim_min_eslora" name="dim_min_eslora" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="dim_min_manga" class="form-label">Dim. Mín. Manga</label>
                    <input type="number" step="0.01" id="dim_min_manga" name="dim_min_manga" class="form-control" required>
                </div>

                <div class="mb-3">
                    <label for="dim_min_calado" class="form-label">Dim. Mín. Calado</label>
                    <input type="number" step="0.01" id="dim_min_calado" name="dim_min_calado" class="form-control" required>
                </div>

                <button type="submit" class="btn btn-primary w-100 py-2">Enviar</button>
            </form>
        </div>
    </body>
</html>
