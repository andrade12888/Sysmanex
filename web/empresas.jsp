<%@page import="modelo.Empresa" %>
<% Empresa emp = new Empresa();

%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">    
    <form name="frmEmpresas" action="CEmpresas.do" method="POST">
        <div class="col-md-4"> <h3>Ingrese los datos de la Empresa</h3></div>
        <div class="row">        
            <div class="col-lg-4">
                <span id="txtInputRut">RUT Empresa</span>
                <input required="required" type="number" name="txtRutEmp" value="" class="form-control"/>   
                <span id="txtInputNom">Nombre: </span>
                <input required="required" type="text" name="txtNomEmpresa" value="" class="form-control"/>
            </div>         
            <div class="col-lg-2"></div>
            <div class="col-lg-2">
                <br><input type="submit" value="Guardar" name="btnEmpresas" class="btn-agregar" />
            </div>
        </div>
        <div class="row">
            <div class="col-lg-4"></div>
            <div class="col-lg-4"><br><div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div></div>
            <div class="col-lg-4"></div>
        </div>
    </form>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8"><br> <%= emp.TablaEmpresas()%></div>
        <div class="col-lg-2"></div>
    </div>
</div>

<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Actualizar Empresa</h4>
            </div>
            <div class="modal-body">
                <form name="frmActualizarEmpresa" action="CEmpresas.do" method="POST">
                    <div class="row">
                        <div class="col-lg-5">Ingrese el nuevo Nombre<input required="required" type="text" id="txtActualizarNombre" name="txtActualizarEmpresa" value="" class="form-control"/></div>                                            
                        <div class="col-lg-2"><input type="hidden" id="txtActualizarNombre" name="txtActualizarId"/></div>
                    </div>  
                    <div class="row">
                        <div class="col-lg-5">Ingrese el nuevo RUT<input required="required" type="text" id="txtActualizarRUT" name="txtActualizarEmpresaRUT" value="" class="form-control"/></div>                                            
                        <div class="col-lg-2"><input type="hidden" id="txtActualizarRUT" name="txtActualizarRUT"/></div>
                    </div>  
                    <br>
                    <div class="row">                        
                        <div class="col-lg-2"><input type="hidden" id="txtViejoRUT" name="txtViejoRUT" value=""/></div>
                    </div>
                    <div class="modal-footer">                    
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="submit" name="btnEmpresas" value="Update" class="btn-agregar">Guardar cambios</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>                      
<div class="modal fade" id="modalEliminarEmpresa" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">Confirme la eliminacion de la Empresa</h4>
            </div>
            <div class="modal-body">
                <form name="frmBorrarEmpresa" action="CEmpresas.do" method="POST">                    
                    <div class="modal-footer">                    
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
                        <button type="submit" id="btnEmpresas" name="btnEmpresas" value="Delete" class="btn-agregar" >Confirmar</button>                           
                        <input type="hidden" id="btnEliEmp" name="btnEliEmp" value=""/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<jsp:include page="master/footer.jsp"/>

