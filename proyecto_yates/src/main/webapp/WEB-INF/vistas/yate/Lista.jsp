<%-- 
    Document   : ListaYates
    Created on : 10 dic 2025
    Author     : krate
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<div class="container mt-4">

    <h1 class="mb-4 text-white">Lista de Yates Registrados</h1>

    <div class="table-responsive shadow-sm rounded">
        <table class="table table-striped table-hover align-middle">
            <thead class="table-dark">
                <tr>
                    <th>Matrícula</th>
                    <th>Nombre</th>
                    <th>Eslora (m)</th>
                    <th>Manga (m)</th>
                    <th>Calado (m)</th>
                    <th>Cédula del Dueño</th>
                    <th>Tipo de Yate (ID)</th>
                </tr>
            </thead>

            <tbody>
                <c:forEach var="y" items="${objetosCons}">
                    <tr>
                        <td>${y.matricula}</td>
                        <td>${y.nombre}</td>
                        <td>${y.eslora}</td>
                        <td>${y.manga}</td>
                        <td>${y.calado}</td>
                        <td>${y.usuario_dueno_cedula}</td>
                        <td>${y.id_tipo}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <nav class="nav mb-4 p-2 bg-dark rounded shadow-sm">
        <a href="${pageContext.request.contextPath}/YateServlet?action=lista" class="btn btn-outline-light me-2">Cargar lista</a>
        <a href="${pageContext.request.contextPath}/YateServlet?action=formulario" class="btn btn-outline-light me-2">Agregar Yate</a>
        <a href="${pageContext.request.contextPath}/YateServlet?action=listaPorDueno" class="btn btn-outline-light me-2">Listar por dueño</a>
        <a href="${pageContext.request.contextPath}/YateServlet?action=otraaccion" class="btn btn-outline-light">Otra acción</a>
    </nav>

</div>
