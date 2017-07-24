<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <div class="row">        
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <br>
            <div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div>            
            <br>
            <div class="panel panel-success">
                <div class="panel-heading">
                    <h3 class="panel-title">Datos de Expediente N°: ${numeroExpediente}</h3>
                </div>
                <div class="panel-body">
                    
                
                Numero de Expediente: <label>${numeroExpediente}</label>
                <br>
                Asunto: <label>${asuntoExpediente}</label>
                <br>
                Fecha de creacion: <label>${fechaExpediente}</label>
                <br>
                Originador: <label>${entidadExpediete}</label>
                <br>
                Tipo de tramite: <label>${tramiteExpediete}</label>
                ${tablaArchivos}
                </div>
            </div>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>
<div id="resp"></div>

<jsp:include page="master/footer.jsp"/>