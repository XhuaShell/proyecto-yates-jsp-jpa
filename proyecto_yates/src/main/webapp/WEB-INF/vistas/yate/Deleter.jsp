<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Eliminar Yate</title>
</head>
<body>
    <h1>Eliminar Yate</h1>
    
    <form action="YateServlet?action=delete" method="POST">
        <input type="hidden" name="action" value="delete">
        
        <label for="matricula">Matrícula del Yate a Eliminar:</label>
        <input type="text" id="matricula" name="matricula" required><br><br>
        
        <input type="submit" value="Eliminar Yate" 
        <a href="YateServlet?action=lista1">Cancelar</a>
    </form>
    
    <br>
    <a href="YateServlet?action=formulario">Registrar Nuevo Yate</a> |
    <a href="YateServlet?action=edicion">Editar Yate</a>
</body>
</html>