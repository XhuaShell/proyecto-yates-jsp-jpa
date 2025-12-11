<%-- 
    Document   : DeleterAmarre
    Created on : 10 dic 2025
    Author     : krate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Eliminar Amarre</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container py-5" style="max-width: 500px;">
            <h1 class="mb-4 text-center">Eliminar Amarre</h1>

            <form action="${pageContext.request.contextPath}/AmarreServlet?action=delete" method="POST">
                <div class="mb-3">
                    <label for="num_amarre" class="form-label">Número de Amarre</label>
                    <input type="number" id="num_amarre" name="num_amarre" class="form-control" required>
                </div>

                <button type="submit" class="btn btn-danger w-100">Eliminar</button>
            </form>
        </div>
    </body>
</html>
