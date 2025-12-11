<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Editar Amarre</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container mt-4">
    <div class="card shadow-sm">
        <div class="card-header bg-primary text-white">
            <h4 class="mb-0">Editar Información del Amarre</h4>
        </div>

        <div class="card-body">
            <form action="${pageContext.request.contextPath}/AmarreServlet?action=edicion" method="POST">
                <div class="mb-3">
                    <label for="num_amarre" class="form-label">Número de Amarre (obligatorio)</label>
                    <input 
                        type="number" 
                        class="form-control" 
                        id="num_amarre" 
                        name="num_amarre" 
                        required
                        >
                </div>

                <div class="mb-3">
                    <label for="id_zona" class="form-label">ID Zona (opcional)</label>
                    <input 
                        type="text" 
                        class="form-control" 
                        id="id_zona" 
                        name="id_zona" 
                        maxlength="1"
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
