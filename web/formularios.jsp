<%-- 
    Document   : formularios
    Created on : Jul 2, 2017, 8:42:02 PM
    Author     : SG0891660
--%>
<%@page import="modelo.Formulario" %>
<% Formulario frm = new Formulario();%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>

<div class="bodyContent">
    <form name="frmFormularios" action="" method="POST">
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                <form enctype="multipart/form-data" action="CFormulario.do" method="post" id="frmFormulario">
                    <div class="panel panel-success" id="pnlFormulario">
                        <div class="panel-heading">
                            <h3 class="panel-title">Formularios</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="row">
                                    <div class="col-lg-4"></div>
                                    <div class="col-lg-4"><br><div style="color: ${colorError}; text-align: center;">${errorMessage}</div></div>
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
                                <div class="col-lg-3"><button type="submit" class="btn btn-primary">Subir Fomulario</button></div> 
                                <div class="col-lg-12"><button type="reset" class="btn file">Borrar archivos</button></div> 
                                
                            </div>
                        </div>
                        
                    </div>  
                </form>                
            </div>
            <div class="col-lg-2"></div>
        </div>

</div>


<jsp:include page="master/footer.jsp"/>