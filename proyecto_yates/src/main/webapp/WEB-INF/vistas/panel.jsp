<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>

<%@include file="./plantillas/header.jsp" %>

<p>Debug: ${panelInfo}</p>

<p>Usuario: ${usuario.nombre}</p>

<c:forEach var="seccion" items="${panelInfo.secciones}">
    <h3>${seccion.titulo}</h3>
    <ul>
        <c:forEach var="btn" items="${seccion.botones}">
            <li>
                <a href="${btn.link}">${btn.nombre}</a>
            </li>
        </c:forEach>
    </ul>
</c:forEach>

<%@include file="./plantillas/footer.jsp" %>
