<%@page import="controlador.CExpediente"%>
<%
    CExpediente.CargarDatos(request, response);
    String lstRecibidos = request.getSession().getAttribute("lstRecibidos").toString();
%>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <h2 class="h2">Bandeja de entrada</h2>
    <div class="row">        
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <br>
            <div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div>            
            <br>
            <table class="table">
                <tr><th>N Expediente</th><th>Asunto</th><th>Tramite</th>
                    <th>Proviene de</th><th>Tiempo para tramitar</th><th>Estado</th></tr>
                        <%= lstRecibidos%>
            </table>            
        </div>
        <div class="col-lg-2"></div>
    </div>
</div>
<div id="resp"></div>

<jsp:include page="master/footer.jsp"/>