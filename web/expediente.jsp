<%@page import="controlador.CUsuarios"%>
<%@page import="controlador.CMotivos"%>
<%
    CUsuarios.CargarDatos(request, response);
    CMotivos.CargarDatos(request, response);
    String lstUnidadesPersonas = request.getSession().getAttribute("lstUnidadesPersonas").toString();
    String lstMotivos = request.getSession().getAttribute("lstMotivos").toString();
%>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <div class="row">        
        <div class="col-lg-1"></div>
        <div class="col-lg-10">
            <div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div>            
            <br>
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Datos de Expediente N°: ${numeroExpediente}</h3>
                </div>
                <input type="hidden" value="${conecadoNombre}" id="conectadoNombre">
                <div class="panel-body"> 
                    <div class="row">
                        <div class="col-lg-6">
                            Numero de Expediente: <label>${numeroExpediente}</label>
                            <br>
                            Asunto: <label>${asuntoExpediente}</label>
                            <br>
                            Fecha de creacion: <label>${fechaExpediente}</label>
                            <br>
                            Originador: <label>${entidadExpediete}</label>
                            <br>
                            Tipo de tramite: <label>${tramiteExpediete}</label>
                        </div>
                        <div class="col-lg-6">                            
                            ${tablaArchivos}
                            <form enctype="multipart/form-data" action="CEditarExpediente" method="post" id="fromExpediente">                                
                                <input id="kv-explorer" name="kv-explorer" type="file" multiple>
                                <input type="hidden" id="txtExpedienteEnvio" name="txtExpedienteEnvio" value="${numeroExpediente}">
                                <input id="btnSubirArchivo" name="btnSubirArchivo" type="submit" class="btn btn-agregar" value="Agregar">
                            </form>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-lg-12">
                            <br>
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Observaciones</h3>
                                    <div><button class="btn" style="position: absolute;right: 25px;margin-top: -25px;"  onclick="modalAgregarObservacion()">
                                            <span style="color: #337ab7;font-weight: bold;">+</span>
                                        </button>
                                    </div>
                                </div>
                                <div class="panel-body"> 
                                    <div id="divObservaciones">
                                        ${listaDetalle}
                                    </div>                           
                                </div>
                            </div>
                            <br>
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h3 class="panel-title">Seguimiento</h3>
                                </div>
                                <div class="panel-body"> 
                                    <div id="jstree">
                                        ${tablaTramitados}
                                    </div>
                                    <script>
                                        $('#jstree').jstree();
                                    </script>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="right" style="text-align: right;">
                <button onclick="modalEnvio('${numeroExpediente}')" id="${numeroExpediente}" type="button" class="btn btn-agregar glyphicon glyphicon-send">  Enviar</button>
            </div>
        </div>
        <div class="col-lg-1"></div>
    </div>
</div>
<div class="modal fade" id="modalExpediente" tabindex="-1" role="dialog" aria-labelledby="modalExpedientelLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modalExpedienteLabel"></h4>
            </div>
            <div class="modal-body">
                <form action="CReEnvio.do" method="post" name="formEnvio" id="fromEnvio">
                    <div class="panel panel-success" id="pnlDestinatarios">
                        <div class="panel-heading">
                            <h3 class="panel-title">Datos de envio del expediente</h3>
                        </div>
                        <div class="panel-body">
                            <div class="row">
                                <div class="col-lg-2">
                                    <input type="hidden" id="txtExpedienteEnvio" name="txtExpedienteEnvio">
                                </div>
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
                                    <select required="required" name="selDestinos" id="selDestinos" class="form-control" multiple>

                                    </select>
                                </div> 
                            </div>
                            <div class="row">
                                <div class="col-lg-4">Motivo de pase
                                    <select required="required" name="selMotivos" id="selMotivos" class="form-control">
                                        <option value="0">Seleccione Motivo</option>
                                        <%= lstMotivos%>
                                    </select>
                                </div>
                                <div class="col-lg-8">
                                    Descripcion del motivo<input type="text" name="txtMotivoObs" class="form-control" id="txtMotivoObs">
                                </div>
                            </div>
                        </div> 
                        <div class="panel-footer">
                            <div>
                                <input type="submit" value="Finalizar" name="btnFinalizar" class="btn btn-agregar"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="modalExpedienteObsevacion" tabindex="-1" role="dialog" aria-labelledby="modalExpedienteObsevacionLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
            </div>
            <div class="modal-body">
                <form action="CEditarExpediente" method="post" name="fromObservaciones" id="fromObservaciones">
                    <div class="panel panel-success" id="pnlModalObservaciones">
                        <div class="panel-heading">
                            <h3 class="panel-title">Agregar Observacion al expediente N ${numeroExpediente}</h3>
                        </div>
                        <div class="panel-body">
                            <textarea class="form-control" name="txtObservacion" id="txtObservacion"></textarea>
                        </div> 
                        <div class="panel-footer">
                            <div>
                                <input type="button" value="Agregar" name="btnFinalizar" class="btn btn-agregar" onclick="agregarObservacionExpediente();"/>
                            </div>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
<div id="resp"></div>

<jsp:include page="master/footer.jsp"/>