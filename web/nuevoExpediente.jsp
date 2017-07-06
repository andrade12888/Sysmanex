<%@page import="controlador.CUsuarios"%>
<%@page import="controlador.CTramites"%>
<%@page import="controlador.CMotivos"%>
<%
    CUsuarios.CargarDatos(request, response);
    CTramites.CargarDatos(request, response);
    String lstTramites = request.getSession().getAttribute("lstTramites").toString();

%>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <div style="color: #FF0000; text-align: center;">${errorMessage}</div></div>
            <form enctype="multipart/form-data" action="CExpediente.do" method="post" id="fromExpediente">
                <div class="panel panel-success" id="pnlExpediente">
                    <div class="panel-heading">
                        <h3 class="panel-title">Datos de Expediente</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-3">
                                <span>Nº Expediente</span> <input required="required" type="number" id="idExpediente" name="txtNroExpediente" class="form-control">
                            </div>
                            <div class="col-lg-9">
                                Asunto <input type="text" name="txtAsunto" class="form-control" id="idAsunto">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-3">Tipo de tramite
                                <select name="selTramite" id="selTramite" class="form-control" required="true">
                                    <option>Seleccione Tramite</option>
                                    <%= lstTramites%>
                                </select></div>
                            <div class="col-lg-6">
                                <br>
                                <label class="radio-inline">
                                    Se puede acceder desde la web?
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="publico" value="false" checked="checked">NO
                                </label>
                                <label class="radio-inline">
                                    <input type="radio" name="publico" value="true" >SI
                                </label>
                            </div>
                            <div class="col-lg-3"></div>               
                        </div>

                        <div class="row">
                            <div class="col-lg-12">
                                <label class="control-label">Seleccionar archivo</label>
                            </div>
                            <div class="col-lg-9">
                                <input name="file" id="kv-explorer" type="file" multiple>
                                <br>
                            </div>  
                            <div class="col-lg-1"><button type="submit" class="btn btn-primary">Enviar</button></div> 
                            <div class="col-lg-2"><button type="reset" class="btn btn-default">Borrar archivos</button></div> 
                        </div>
                    </div>
                    <div class="panel-footer text-right">
                        <div>
                            <input type="submit" value="Siguiente" name="btnFinalizar" class="btn btn-primary"/>
                        </div>
                    </div>
                </div>  
            </form>                
        </div>
        <div class="col-lg-2"></div>
    </div>    
</div>
<jsp:include page="master/footer.jsp"/>


