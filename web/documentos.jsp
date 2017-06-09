<%-- 
    Document   : document
    Created on : 18-may-2017, 1:45:32
    Author     : Nova
--%>
<%@page import="modelo.Tramite"  %>
<% Tramite doc = new Tramite();

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <form name="frmDocumentos" action="documentos.do" method="POST">
        <div class="row">
            <div class="col-lg-4">Ingrese tipo de documento<input type="text" name="txtDocumento" value="" class="form-control"/></div>
            <div class="col-lg-3">Plazo para tramitar<input type="text" name="txtPlazo" class="form-control" /></div>
            <div class="col-lg-2"></div>
            <div class="col-lg-2"><br><input type="submit" value="Guardar" name="btnDocumento" class="btn-agregar" /></div>
        </div>
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4"><br><div style="color: ${colorError}; text-align: center;">${errorMessage}</div></div>
            <div class="col-lg-4"></div>
        </div>
    </form>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8"><br> <%= doc.TablaTramites()%></div>
        <div class="col-lg-2"></div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Actualizar Documento</h4>
            </div>
            <div class="modal-body">
                <form name="frmActualizarDocumento" action="documentos.do">
                    <div class="row">
                        <div class="col-lg-5">Ingrese tipo de documento<input type="text" id="txtActualizarDocumento" name="txtActualizarDocumento" value="" class="form-control"/></div>
                        <div class="col-lg-5">Plazo para tramitar<input type="text" id="txtActualizarPlazo" name="txtActualizarPlazo" class="form-control" /></div>                    
                        <div class="col-lg-2"><input type="hidden" id="txtActualizarId" name="txtActualizarId"/></div>
                    </div>  
                    <br>
                    <div class="modal-footer">                    
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="submit" name="btnDocumento" value="Update" class="btn btn-primary">Guardar cambios</button>
                    </div>
                </form>
            </div>
        </div>
    </div
    
    <jsp:include page="master/footer.jsp"/>

