<%@page import="modelo.Persona" %>
<% Persona per = new Persona();

%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <form name="frmPersonas" action="CUsuarios.do" method="POST">        
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4"><br><div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div></div>
            <div class="col-lg-4"></div>
        </div>
    </form>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8"><br> <%= per.TablaPersonas() %></div>
        <div class="col-lg-2"></div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Actualizar Personas</h4>
            </div>
            <div class="modal-body">
                <form name="frmActualizarPersona" action="CUsuarios.do" method="POST">
                    <div class="row">
                        <div class="col-lg-5">Ingrese el Nombre<input required="required" type="text" id="txtActualizarNombre" name="txtActualizarNombre" value="" class="form-control"/></div>                                            
                        <div class="col-lg-2"><input type="hidden" id="txtActualizarId" name="txtActualizarId"/></div>
                    </div>
                     <div class="row">       <br>
                        <div class="col-lg-5">Ingrese el Apellido<input required="required" type="text" id="txtActualizarApellido" name="txtActualizarApellido" value="" class="form-control"/></div>                                            
                        <div class="col-lg-2"></div>
                     </div>       <br>
                     <div class="row">   
                         <div class="col-lg-5">Ingrese el E-mail<input required="required" type="email" id="txtActualizarEmail" name="txtActualizarEmail" value="" class="form-control"/></div>                                            
                        <div class="col-lg-2"></div>
                     </div>
                   
                    <br>
                    <div class="modal-footer">                    
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="submit" name="btnPersona" value="Update" class="btn-agregar">Guardar cambios</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="master/footer.jsp"/>

