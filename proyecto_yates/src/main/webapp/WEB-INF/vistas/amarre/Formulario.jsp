<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registrar Amarre</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container py-5" style="max-width: 600px;">
            <h1 class="mb-4 text-center fw-semibold">Registrar Amarre</h1>

            <form action="${pageContext.request.contextPath}/AmarreServlet?action=formulario" method="POST">

                <div class="mb-3">
                    <label for="id_zona" class="form-label">ID Zona</label>
                    <input type="text" id="id_zona" name="id_zona" class="form-control" maxlength="1">
                </div>

                <button type="submit" class="btn btn-primary w-100 py-2">Enviar</button>
            </form>
        </div>
    </body>
</html>
