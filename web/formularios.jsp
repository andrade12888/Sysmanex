<%-- 
    Document   : formularios
    Created on : Jul 2, 2017, 8:42:02 PM
    Author     : SG0891660

--%>
<%@page import="modelo.Formulario" %>
<% Formulario frm = new Formulario();%>

<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>

<div class="bodyContent">
    <form enctype="multipart/form-data" name="frmFormularios" action="formulario.do" method="POST">
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                <form  action="formulario.do" method="post" id="frmFormulario">
                    <div class="panel panel-success" id="pnlFormulario">
                        <div class="panel-heading">
                            <h3 class="panel-title">Formularios</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="row">
                                    <div class="col-lg-4"></div>
                                    <div class="col-lg-4"><br><div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div></div>
                                    <div class="col-lg-4"></div>
                                </div>
                                </form>
                                <div class="row">
                                    <div class="col-lg-2"></div>
                                    <div class="col-lg-8"><br> <%= frm.TablaFormularios()%></div>
                                    <div class="col-lg-2"></div>
                                </div>
                            </div>                        
                            <div class="row">
                                <div class="col-lg-12">
                                    <label class="control-label">Seleccionar archivo</label>
                                </div>
                                <div class="col-lg-9">
                                    <input id="input-1a" name="input-1a" type="file" class="file" multiple="true" data-show-preview="true">
                                </div>  
                                <div class="col-lg-3"><button id="uploadButton" value="2" name="btnSubirFrm" type="submit" class="btn btn-agregar">Subir Fomulario</button></div> 
                                <div class="col-lg-12"><button id="borrarButton" type="reset" class="btn btn-agregar">Borrar archivos</button></div> 
                                
                            </div>
                        </div>
                        
                    </div>  
                </form>                
            </div>
            <div class="col-lg-2"></div>
        </div>

</div>


<jsp:include page="master/footer.jsp"/>