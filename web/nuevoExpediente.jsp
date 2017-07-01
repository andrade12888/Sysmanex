<%@page import="controlador.CUsuarios"%>
<%@page import="controlador.CTramites"%>
<%@page import="controlador.CMotivos"%>
<%
    CUsuarios.CargarDatos(request, response);
    CTramites.CargarDatos(request, response);
    CMotivos.CargarDatos(request, response);
    String lstTramites = request.getSession().getAttribute("lstTramites").toString();
    String lstUnidadesPersonas = request.getSession().getAttribute("lstUnidadesPersonas").toString();
    String lstMotivos = request.getSession().getAttribute("lstMotivos").toString();
%>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <form enctype="multipart/form-data" action="CExpediente.do" method="post" id="fromExpediente">
                <div class="panel panel-success" id="pnlExpediente">
                    <div class="panel-heading">
                        <h3 class="panel-title">Datos de Expediente</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-3">
                                Nº Expediente <input type="text" id="txtNroExpediente" name="txtNroExpediente" class="form-control" required="true">
                            </div>
                            <div class="col-lg-9">
                                Asunto <input type="text" name="txtAsunto" class="form-control">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-3">Tipo de tramite
                                <select name="selTramite" id="selTramite" class="form-control">
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
                                <input id="input-1a" name="input-1a" type="file" class="file" multiple="true" data-show-preview="true">
                            </div>  
                            <div class="col-lg-1"><button type="submit" class="btn btn-primary">Enviar</button></div> 
                            <div class="col-lg-2"><button type="reset" class="btn btn-default">Borrar archivos</button></div> 
                        </div>
                    </div>
                    <div class="panel-footer text-right">
                        <input type="button" value="Siguiente" name="btnSiguiente" class="btn btn-default" onclick="ExpedSiguiente();"/>
                    </div>
                </div>  
            </form>
                <div class="panel panel-success" id="pnlDestinatarios" style="display: none;">
                    <div class="panel-heading">
                        <h3 class="panel-title">Datos de envio del expediente</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-2"><input type="hidden" id="txtExpedienteEnvio" name="txtExpedienteEnvio"></div>
                            <div class="col-lg-3">Posibles Destinatarios
                                <select name="selDestinatario" id="selDestinatario" class="form-control">
                                    <option value="0">Seleccione Destinatarios</option>
                                    <%= lstUnidadesPersonas%>
                                </select>
                            </div>
                            <div class="col-lg-2 text-center">
                                <br>
                                <button type="button" class="btn glyphicon glyphicon-chevron-right" onclick="agregarDestinatario();"></button>
                                <br>
                                <br>
                                <button type="button" class="btn glyphicon glyphicon-chevron-left" onclick="quitarDestinatario();"></button>
                            </div>
                            <div class="col-lg-4">Destinos
                                <select name="selDestinos" id="selDestinos" class="form-control" multiple="true"></select>
                            </div> 
                        </div>
                        <div class="row">
                            <div class="col-lg-4">Motivo de pase
                                <select name="selMotivos" id="selMotivos" class="form-control">
                                    <option value="0">Seleccione Motivo</option>
                                    <%= lstMotivos %>
                                </select>
                            </div>
                            <div class="col-lg-8">
                                
                            </div>
                        </div>
                    </div> 
                    <div class="panel-footer">
                        <input type="button" value="Atras" name="btnAtras" class="btn btn-default" onclick="ExpedAtras();"/>
                        <div style="float: right;">
                            <input type="submit" value="Finalizar" name="btnFinalizar" class="btn btn-primary"/>
                        </div>
                    </div>
                </div>
        </div>
        <div class="col-lg-2"></div>
    </div>    
</div>
<jsp:include page="master/footer.jsp"/>


