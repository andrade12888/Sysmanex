<%@page import="modelo.UnidadArmada" %>
<% UnidadArmada ua = new UnidadArmada();

%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <form name="frmUnidades" action="CUsuarios.do" method="POST">        
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4"><br><div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div></div>
            <div class="col-lg-4"></div>
        </div>
    </form>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8"><br> <%= ua.TablaUnidades() %></div>
        <div class="col-lg-2"></div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Actualizar Unidad</h4>
            </div>
            <div class="modal-body">
                <form name="frmActualizarUnidades" action="CUsuarios.do" method="POST">
                    <div class="row">
                        <div class="col-lg-5">Ingrese el Nombre o Sigla de la unidad<input required="required" type="text" id="txtActualizarNombre" name="txtActualizarNombre" value="" class="form-control"/></div>                                            
                        <div class="col-lg-2"><input type="hidden" id="txtActualizarId" name="txtActualizarId"/></div>
                    </div>                     
                    <br>
                    <div class="modal-footer">                    
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="submit" name="btnUnidad" value="Update" class="btn-agregar">Guardar cambios</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="master/footer.jsp"/>

