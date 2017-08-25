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
        <link href="css/style.min.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="js/jstree.js" type="text/javascript"></script>



    </head>
    <body>
        <div  id="jstree">

            <%= u1.mostrarSeguimiento("2017001600001")%>

        </div>
        <script>
           $(function () {
                // 6 create an instance when the DOM is ready
               $('#jstree').jstree();
                // 7 bind to events triggered on the tree
       //         $('#jstree').on("changed.jstree", function (e, data) {
        //            console.log(data.selected);
       //         });

           });
        </script>
    </body>
</html>
