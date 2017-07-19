<%@page import="controlador.CExpediente"%>
<%
    CExpediente.CargarDatos(request, response);
    String lstRecibidos = request.getSession().getAttribute("lstRecibidos").toString();
%>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <h2 class="h2">Mis expedientes</h2>
    <div class="row">        
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <br>
            <div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div>            
            <br>
            <table class="table table-striped">
                <tr><th>N Expediente</th><th>Asunto</th><th>Tramite</th>
                    <th>Proviene de</th><th>Tiempo para tramitar</th><th>Estado</th></tr>
                        <%= lstRecibidos%>
            </table>            
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>
<div class="modal fade" id="modalMostrarExpediente" tabindex="-1" role="dialog" aria-labelledby="modalMostrarExpedienteLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modalMostrarExpedienteLabel"></h4>
            </div>
            <div class="modal-body">
                <form action="CEnvio.do" method="post" name="formEnvio" id="fromEnvio">
                    <div class="panel panel-success" id="pnlDestinatarios">
                        <div class="panel-heading">
                            <h3 class="panel-title">Datos de envio del expediente</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-2"><input type="hidden" id="txtExpedienteEnvio" name="txtExpedienteEnvio"></div>
                                <div class="col-lg-3">Posibles Destinatarios
                                    <select name="selDestinatario" id="selDestinatario" class="form-control">
                                        <option value="0">Seleccione Destinatarios</option>
                                        <%= //lstUnidadesPersonas%>
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
                                    <select required="required" name="selDestinos" id="selDestinos" class="form-control" multiple>

                                    </select>
                                </div> 
                            </div>
                            <div class="row">
                                <div class="col-lg-4">Motivo de pase
                                    <select required="required" name="selMotivos" id="selMotivos" class="form-control">
                                        <option value="0">Seleccione Motivo</option>
                                        <%= //lstMotivos%>
                                    </select>
                                </div>
                                <div class="col-lg-8">
                                    Descripcion del motivo<input type="text" name="txtMotivoObs" class="form-control" id="txtMotivoObs">
                                </div>
                            </div>
                        </div> 
                        <div class="panel-footer">
                            <div>
                                <input type="submit" value="Finalizar" name="btnFinalizar" class="btn btn-primary"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>                       
<jsp:include page="master/footer.jsp"/>