<%@page import="modelo.Expediente"%>
<%
    Expediente u1 = new Expediente();
    u1.traerExpediente("2017001600001");

%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <ul>
                <li>2017001600001
                    <%= u1.seguimientoExpedientes("2017001600001") %>
                </li>
            </ul>
        </div>
    </body>
</html>
