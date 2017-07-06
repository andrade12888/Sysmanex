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
    <form name="frmTramites" action="tramites.do" method="POST" id="formTramites">
        <div class="row">
            <div class="col-lg-4">Ingrese tipo de tramite<input id="txtTipoTramite" type="text" name="txtTramite" value="" class="form-control"/></div>
            <div id="divTramitePlazo" class="col-lg-3"><span class="spanTramite">Plazo para tramitar</span><input id="txtPlazoTramite" required="required" type="number" name="txtPlazo" class="form-control" /></div>                                                     
            <div class="col-lg-2"></div>
            <div class="col-lg-2"><br><input id="btnGuardar" type="button" value="Guardar" name="btnTramite" class="btn-agregar" onclick="controlTramiteTextoVacio('formTramites','txtTipoTramite','txtPlazoTramite','spanTramite');" /></div>
            <input type="hidden" name="btnTramite" value="Guardar" />
        </div>
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4"><br><div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div></div>
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
                <h4 class="modal-title" id="myModalLabel">Actualizar Tramite</h4>
            </div>
            <div class="modal-body">
                <form name="frmActualizarTramite" id="frmActualizarTramite" action="tramites.do" method="POST">
                    <div class="row">
                        <div class="col-lg-5">Ingrese tipo de Tramite<input type="text" id="txtActualizarTramite" required="required" name="txtActualizarTramite" value="" class="form-control"/></div>
                        <div class="col-lg-5"><span class="spanUpdTramite">Plazo para tramitar</span><input type="number" required="required" id="txtActualizarPlazo" name="txtActualizarPlazo" class="form-control" /></div>                    
                        <div class="col-lg-2"><input type="hidden" id="txtActualizarId" name="txtActualizarId"/></div>
                    </div>  
                    <br>
                    <div class="modal-footer">                    
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="button" name="btnTramite" value="Update" class="btn btn-primary" onclick="controlTramiteTextoVacio('frmActualizarTramite','txtActualizarTramite','txtActualizarPlazo','spanUpdTramite');">Guardar cambios</button>
                        <input type="hidden" name="btnTramite" value="Update" />
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="master/footer.jsp"/>

