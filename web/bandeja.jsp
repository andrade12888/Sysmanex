<%@page import="controlador.CExpediente"%>
<%
    CExpediente.CargarDatos(request, response);
    String lstRecibidos = request.getSession().getAttribute("lstRecibidos").toString();
%>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <div class="row">        
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <br>
            <div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div>            
            <br>
            <div class="panel panel-success" id="pnlBandeja">
                <div class="panel-heading">
                    <h3 class="panel-title">Bandeja de entrada</h3>
                </div>
                <div class="panel-body">
                    <table class="table">
                        <tr><th>N Expediente</th><th>Asunto</th><th>Tramite</th>
                            <th>Proviene de</th><th>Tiempo para tramitar</th><th>Estado</th></tr>
                                <%= lstRecibidos%>
                    </table> 
                </div>
            </div>
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>
<div id="resp"></div>

<jsp:include page="master/footer.jsp"/>