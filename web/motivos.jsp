<%@page import="modelo.Motivo" %>
<% Motivo motivo = new Motivo();

%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <form name="frmMotivos" action="motivos.do" method="POST">
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-4">Ingrese el Motivo del tramite<input type="text" name="txtMotivo" value="" class="form-control"/></div>         
            <div class="col-lg-2"></div>
            <div class="col-lg-2"><br><input type="submit" value="Guardar" name="btnMotivos" class="btn-agregar" /></div>
        </div>
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4"><br><div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div></div>
            <div class="col-lg-4"></div>
        </div>
    </form>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8"><br> <%= motivo.TablaMotivos()%></div>
        <div class="col-lg-2"></div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Actualizar Motivo</h4>
            </div>
            <div class="modal-body">
                <form name="frmActualizarMotivo" action="motivos.do">
                    <div class="row">
                        <div class="col-lg-5">Ingrese el nuevo Motivo<input type="text" id="txtActualizarMotivo" name="txtActualizarMotivo" value="" class="form-control"/></div>                                            
                        <div class="col-lg-2"><input type="hidden" id="txtActualizarId" name="txtActualizarId"/></div>
                    </div>  
                    <br>
                    <div class="modal-footer">                    
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="submit" name="btnMotivos" value="Update" class="btn-agregar">Guardar cambios</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="master/footer.jsp"/>

