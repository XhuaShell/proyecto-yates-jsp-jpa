<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Editar Yate</title>
</head>
<body>
    <h1>Editar Yate</h1>
    
    <form action="YateServlet?action=edicion" method="POST">
        <input type="hidden" name="action" value="edicion">
        
        <label for="matricula">Matrícula:</label>
        <input type="text" id="matricula" name="matricula" required 
               value="<%= request.getParameter("matricula") != null ? request.getParameter("matricula") : "" %>"><br><br>
        
        <label for="nombre">Nombre:</label>
        <input type="text" id="nombre" name="nombre" required 
               value="<%= request.getParameter("nombre") != null ? request.getParameter("nombre") : "" %>"><br><br>
        
        <label for="eslora">Eslora:</label>
        <input type="number" id="eslora" name="eslora" step="0.01" required 
               value="<%= request.getParameter("eslora") != null ? request.getParameter("eslora") : "" %>"><br><br>
        
        <label for="manga">Manga:</label>
        <input type="number" id="manga" name="manga" step="0.01" required 
               value="<%= request.getParameter("manga") != null ? request.getParameter("manga") : "" %>"><br><br>
        
        <label for="calado">Calado:</label>
        <input type="number" id="calado" name="calado" step="0.01" required 
               value="<%= request.getParameter("calado") != null ? request.getParameter("calado") : "" %>"><br><br>
        
        <label for="usuario_dueno_cedula">Cédula del Dueño:</label>
        <input type="text" id="usuario_dueno_cedula" name="usuario_dueno_cedula" required 
               value="<%= request.getParameter("usuario_dueno_cedula") != null ? request.getParameter("usuario_dueno_cedula") : "" %>"><br><br>
        
        <label for="id_tipo">ID Tipo de Yate:</label>
        <input type="number" id="id_tipo" name="id_tipo" required 
               value="<%= request.getParameter("id_tipo") != null ? request.getParameter("id_tipo") : "" %>"><br><br>
        
        <input type="submit" value="Actualizar Yate">
    </form>
    
    <br>
    <a href="YateServlet?action=lista1">Cancelar</a>
</body>
</html>