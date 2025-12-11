<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Registrar Yate</title>
</head>
<body>
    <h1>Registrar Nuevo Yate</h1>
    
    <form action="YateServlet?action=formulario" method="POST">
        <input type="hidden" name="action" value="formulario">
        
        <label for="matricula">Matrícula:</label>
        <input type="text" id="matricula" name="matricula" required><br><br>
        
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required><br><br>
        
        <label for="eslora">Eslora:</label>
        <input type="number" id="eslora" name="eslora" step="0.01" required><br><br>
        
        <label for="manga">Manga:</label>
        <input type="number" id="manga" name="manga" step="0.01" required><br><br>
        
        <label for="calado">Calado:</label>
        <input type="number" id="calado" name="calado" step="0.01" required><br><br>
        
        <label for="usuario_dueno_cedula">Cédula del Dueño:</label>
        <input type="text" id="usuario_dueno_cedula" name="usuario_dueno_cedula" required><br><br>
        
        <label for="id_tipo">ID Tipo de Yate:</label>
        <input type="number" id="id_tipo" name="id_tipo" required><br><br>
        
        <input type="submit" value="Registrar Yate">
    </form>
    
    <br>
    <a href="YateServlet?action=lista1">Ver Lista de Yates</a>
</body>
</html>