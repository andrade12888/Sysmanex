<%-- 
    Document   : documentos
    Created on : 18-may-2017, 1:45:32
    Author     : Nova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <form name="frmDocumentos" action="documentos.do" method="POST">
        <div class="row">
            <div class="col-lg-2">Ingrese tipo de documento</div>
            <div class="col-lg-4"><input type="text" name="txtDocumento" value="" class="form-control" /></div>
            <div class="col-lg-2"></div>
            <div class="col-lg-2"><input type="submit" value="Guardar" name="btnDocumento" /></div>
        </div>
    </form>    
</div>
<jsp:include page="master/footer.jsp"/>

