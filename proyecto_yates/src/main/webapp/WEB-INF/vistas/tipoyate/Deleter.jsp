<%-- 
    Document   : Deleter
    Created on : 10 dic 2025, 11:30:01
    Author     : krate
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Tipo de Yate</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container py-5" style="max-width: 600px;">
            <h1 class="mb-4 text-center fw-semibold">Eliminar Tipo de Yate</h1>

            <form action="<%= request.getContextPath()%>/TipoYateServlet?action=delete" method="POST">

                <div class="mb-3">
                    <label for="num_tipo_yate" class="form-label">Código del Tipo de Yate</label>
                    <input 
                        type="text" 
                        id="num_tipo_yate" 
                        name="num_tipo_yate" 
                        class="form-control" 
                        required
                        >
                </div>

                <button type="submit" class="btn btn-danger w-100 py-2">Eliminar</button>
            </form>
        </div>
    </body>
</html>
