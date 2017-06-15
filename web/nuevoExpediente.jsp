<%@page import="controlador.CUsuarios"%>
<%@page import="controlador.CTramites"%>
<%
    CUsuarios.CargarDatos(request, response);
    CTramites.CargarDatos(request, response);
    String lstTramites = request.getSession().getAttribute("lstTramites").toString();
    String lstUnidadesPersonas = request.getSession().getAttribute("lstUnidadesPersonas").toString();
%>
<%@page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <div class="row">
                <div class="col-lg-3">Nº Expediente <input type="text" name="txtNroExpediente" class="form-control"></div>
                <div class="col-lg-9">Asunto <input type="text" name="txtAsunto" class="form-control"></div>
            </div>
            <div class="row">
                <div class="col-lg-3">Tipo de tramite
                    <select name="selTramite" id="selTramite" class="form-control">
                        <option>Seleccione Tramite</option>
                        <%= lstTramites%>
                    </select></div>
                <div class="col-lg-6"><br>Se puede acceder desde la web?
                    No <input type="radio" name="publico" value="0" checked="checked" class="radio-inline" />
                    Si <input type="radio" name="publico" value="1" class="radio-inline"/>
                </div>
                <div class="col-lg-3"></div>               
            </div>
            <div class="row">
                <div class="col-lg-3">Posibles Destinatarios
                    <select name="selDestinatario" id="selDestinatario" class="form-control">
                        <option value="0">Seleccione Destinatarios</option>
                        <%= lstUnidadesPersonas%>
                    </select>
                </div>
                <div class="col-lg-1"><br><button class="btn-agregar" onclick="agregarDestinatario();">></button></div>
                <div class="col-lg-4">Destinos
                    <select name="selDestinos" id="selDestinos" class="form-control" multiple="true"></select>
                </div> 

            </div>
            <div class="row">
                <div class="col-lg-12">
                    <label class="control-label">Seleccionar Archivos</label>
                     <input id="input-2" name="input2[]" type="file" class="file" multiple data-show-upload="false" data-show-caption="true">
                </div>      
            </div>            
        </div>
        <div class="col-lg-2"></div>
    </div>    
</div>
                        <script>
    $('#input-2').fileinput({
        language: 'es',
        uploadUrl: 'C:\Users\andra\Desktop/',
        allowedFileExtensions: ['jpg', 'png', 'gif','doc','docx','pdf','xls','xlsx']
    });
                        </script>
<jsp:include page="master/footer.jsp"/>


