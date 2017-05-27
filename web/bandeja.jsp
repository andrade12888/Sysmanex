<%@page import="modelo.Documento"  %>
<% Documento doc = new Documento();

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <form name="frmDocumentos" action="documentos.do" method="POST">
        <!--div class="row">
            <div class="col-lg-4">Ingrese tipo de documento<input type="text" name="txtDocumento" value="" class="form-control"/></div>
            <div class="col-lg-3">Plazo para tramitar<input type="text" name="txtPlazo" class="form-control" /></div>
            <div class="col-lg-2"></div>
            <div class="col-lg-2"><br><input type="submit" value="Guardar" name="btnDocumento" class="btn-agregar" /></div>
        </div>
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4"><br><div style="color: ${colorError}; text-align: center;">${errorMessage}</div></div>
            <div class="col-lg-4"></div>
        </div-->
    </form>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8"><br> <%= doc.TablaDocumentos()%></div>
        <div class="col-lg-2"></div>
    </div>
</div>

<jsp:include page="master/footer.jsp"/>