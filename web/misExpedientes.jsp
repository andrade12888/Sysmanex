<%@page import="modelo.Entidad"%>
<%@page import="controlador.CUsuarios"%>
<%
    Entidad u1 = (Entidad) request.getSession().getAttribute("usuarioLogeado");
    CUsuarios.CargarDatos(request, response);
    String lstUnidadesPersonas = request.getSession().getAttribute("lstUnidadesPersonas").toString();

%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <h2 class="h2">Mis expedientes</h2>
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8"><br> <%= u1.TablaExpedientes()%></div>
        <div class="col-lg-2"></div>
    </div>
</div>
<div class="modal fade" id="modalExpediente" tabindex="-1" role="dialog" aria-labelledby="modalExpedientelLabel">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="modalExpedienteLabel">Enviar expediente N:</h4>
            </div>
            <div class="modal-body">
                <form name="frmEnviarExpediente" action="/CExpediente.do">
                    <div class="row">
                        <div class="col-lg-5">Posibles Destinatarios
                            <select name="selDestinatario" id="selDestinatario" class="form-control">
                                <option value="0">Seleccione Destinatarios</option>
                                <%= lstUnidadesPersonas%>
                            </select>
                        </div>
                        <div class="col-lg-2">
                            <br>
                            <input type="button" class="btn-agregar" value=">" onclick="agregarDestinatario();">
                            <input type="button" class="btn-agregar" value="<" onclick="quitarDestinatario();">
                        </div>
                        <div class="col-lg-5">Destinos
                            <select name="selDestinos" id="selDestinos" class="form-control" multiple="true"></select>
                        </div> 
                    </div>
                    <div class="modal-footer">
                        <input type="submit" value="Enviar" name="btnFinalizar" class="btn btn-primary"/>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<jsp:include page="master/footer.jsp"/>