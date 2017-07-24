<%@page import="modelo.Entidad"%>
<%@page import="controlador.CUsuarios"%>
<%@page import="controlador.CMotivos"%>
<%
    Entidad u1 = (Entidad) request.getSession().getAttribute("usuarioLogeado");
    CUsuarios.CargarDatos(request, response);
    CMotivos.CargarDatos(request, response);
    String lstUnidadesPersonas = request.getSession().getAttribute("lstUnidadesPersonas").toString();
    String lstMotivos = request.getSession().getAttribute("lstMotivos").toString();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>
<script>
    $(document).ready(function () {
        $("td[name*='oculto']").hide();

    });
    function ocultar(id) {
        $("#oculto" + id).slideUp();
        $("#m" + id).show();
        $("#o" + id).hide();
    }
    function mostrar(id) {
        $("#oculto" + id).slideDown();
        $("#o" + id).show();
        $("#m" + id).hide();
    }
</script>
<style type="text/css">

    .paging-nav {
        text-align: right;
        padding-top: 2px;
    }

    .paging-nav a {
        margin: auto 1px;
        text-decoration: none;
        display: inline-block;
        padding: 1px 7px;
        background: #91b9e6;
        color: white;
        border-radius: 3px;
    }

    .paging-nav .selected-page {
        background: #187ed5;
        font-weight: bold;
    }

    .paging-nav,
    #tableData {
        margin: 0 auto;
        font-family: Arial, sans-serif;
    }
</style>
<div class="bodyContent">
    <h2 class="h2">Mis expedientes</h2>
    <div class="row">        
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <br>
            <div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div>            
            <br> <%= u1.TablaExpedientes()%></div>
        <div class="col-lg-2"></div>
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