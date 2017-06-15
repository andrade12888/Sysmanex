<%@page import="modelo.Entidad"%>
<%
    Entidad u1 = (Entidad) request.getSession().getAttribute("usuarioLogeado");

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <h2 class="h2">Mis expedientes</h2>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8"><br> <%= u1.TablaExpedientes() %></div>
        <div class="col-lg-2"></div>
    </div>
</div>

<jsp:include page="master/footer.jsp"/>