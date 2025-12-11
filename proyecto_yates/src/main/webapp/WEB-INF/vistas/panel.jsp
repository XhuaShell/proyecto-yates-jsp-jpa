<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<%@include file="./plantillas/header.jsp" %>

<style>
    .panel-container {
        max-width: 900px;
        margin: 40px auto;
        padding: 20px;
        font-family: Arial, sans-serif;
    }

    .panel-header {
        margin-bottom: 30px;
        border-bottom: 2px solid #444;
        padding-bottom: 10px;
    }

    .panel-header h2 {
        margin: 0;
        color: #222;
    }

    .panel-user {
        margin-top: 5px;
        color: #555;
        font-size: 14px;
    }

    .panel-section {
        margin-bottom: 25px;
        background: #f5f5f5;
        padding: 20px;
        border-radius: 10px;
        border: 1px solid #ddd;
    }

    .panel-section h3 {
        margin-top: 0;
        margin-bottom: 15px;
        color: #333;
        font-size: 20px;
    }

    .panel-list {
        list-style: none;
        padding: 0;
        margin: 0;
    }

    .panel-list li {
        margin-bottom: 10px;
    }

    .panel-list a {
        display: inline-block;
        padding: 8px 14px;
        text-decoration: none;
        color: #fff;
        background: #0077cc;
        border-radius: 6px;
        transition: background 0.2s;
    }

    .panel-list a:hover {
        background: #005899;
    }

    .debug-box {
        background: #eee;
        padding: 10px;
        border-left: 4px solid #444;
        margin-bottom: 20px;
        font-size: 13px;
        color: #333;
    }
</style>

<div class="panel-container">

    <div class="panel-header">
        <h2>${panelInfo.titulo}</h2>
        <div class="panel-user">Usuario: <strong>${usuario.nombre}</strong></div>
    </div>

    <c:forEach var="seccion" items="${panelInfo.secciones}">
        <div class="panel-section">
            <h3>${seccion.titulo}</h3>

            <ul class="panel-list">
                <c:forEach var="btn" items="${seccion.botones}">
                    <li>
                        <a href="${btn.link}">${btn.nombre}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </c:forEach>

</div>

<%@include file="./plantillas/footer.jsp" %>
