<%@page import="modelo.Expediente"%>
<%@page import="controlador.CUsuarios"%>
<%@page import="controlador.CMotivos"%>
<%
    CUsuarios.CargarDatos(request, response);
    CMotivos.CargarDatos(request, response);
    String lstUnidadesPersonas = request.getSession().getAttribute("lstUnidadesPersonas").toString();
    String lstMotivos = request.getSession().getAttribute("lstMotivos").toString();
    String exp = request.getSession().getAttribute("expedienteEnviar").toString();                          
%>

<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <form action="CEnvio.do" method="post" name="formEnvio" id="fromEnvio">
                <div class="panel panel-success" id="pnlDestinatarios">
                    <div class="panel-heading">
                        <h3 class="panel-title">Datos de envio del expediente</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">                                                            
                            <div class="col-lg-2"><input type="hidden" id="txtExpedienteEnvio" name="txtExpedienteEnvio" value="<%=exp%>"></div>
                            <div class="col-lg-3">Posibles Destinatarios
                                <select required="required" name="selDestinatario" id="selDestinatario" class="form-control">
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
                                <select name="selDestinos" id="selDestinos" class="form-control" multiple>

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
        <div class="col-lg-2"></div>
    </div>    
</div>
<jsp:include page="master/footer.jsp"/>