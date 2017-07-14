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
<script>
    function maxLengthCheck(object) {
    if (object.value.length > 5) {
        object.value = object.value.slice(0,5); 
    }
}
</script>
<div class="bodyContent">
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <div style="color: #FF0000; text-align: center;">${errorMessage}</div>
            <form enctype="multipart/form-data" action="CExpediente.do" method="post" id="fromExpediente">
                <div class="panel panel-success" id="pnlExpediente">
                    <div class="panel-heading">
                        <h3 class="panel-title">Datos de Expediente</h3>
                    </div>
                    <div class="panel-body">
                        <div class="row">
                            <div class="col-lg-3">
                                <span>Nº Expediente</span> <input required="required" type="number" id="idExpediente" name="txtNroExpediente" min="1" max="99999" class="form-control" oninput="maxLengthCheck(this)">
                            </div>
                            <div class="col-lg-9">
                                Asunto <input required="required" type="text" name="txtAsunto" class="form-control" id="idAsunto">
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-lg-3">Tipo de tramite
                                <select name="selTramite" id="selTramite" class="form-control" required="required">
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
                            <div class="col-lg-9">
                                <label class="control-label">Seleccionar archivo</label>
                                <input id="input-1a" name="input-1a" type="file" class="file" multiple="multiple" data-show-preview="true">
                            </div> 
                            <div class="col-lg-1">
                                <br>
                                
                            </div> 
                            <div class="col-lg-2">
                                <br>
                                <button type="reset" class="btn btn-default">Borrar archivos</button>
                            </div> 
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


