<%@page contentType="text/html; charset=UTF-8" %>
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
                <div class="col-lg-3">Tipo de documento<select name="selDestinatario" class="form-control">
                        <option>Seleccione documento</option>
                        <option>Carta de servicio</option>
                        <option>Memorandum</option>
                    </select></div>
                <div class="col-lg-3"><br>Se puede acceder desde la web?
                    Si <input type="radio" name="publico" value="0" checked="checked" class="radio-inline" />
                    No <input type="radio" name="publico" value="0" class="radio-inline"/>
                </div>
                <div class="col-lg-3"></div>
                <div class="col-lg-3"></div>
            </div>
            <div class="row">
                <div class="col-lg-3">Posibles Destinatarios<select name="selDestinatario" class="form-control">
                        <option>Seleccione destinatarios</option>
                        <option>Unidad</option>
                    </select>
                </div>
                <div class="col-lg-1"><br><button class="btn-agregar">></button></div>
                <div class="col-lg-8">Destinos<textarea name="Destinos" rows="4" cols="1" class="form-control">
                    </textarea></div>        
            </div>
            <div class="row">
                <div class="col-lg-3">Adjuntar Archivo<input type="file" name="upArchivo" value="" /></div>
                <div class="col-lg-3"></div>
                <div class="col-lg-3"></div>
                <div class="col-lg-3"></div>
            </div>            
        </div>
        <div class="col-lg-2"></div>
    </div>    
</div>
<jsp:include page="master/footer.jsp"/>


