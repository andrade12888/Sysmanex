<%-- 
    Document   : index
    Created on : 02-abr-2017, 13:45:46
    Author     : Nova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sysmanexxx</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">        
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/master.css">
        
        <script src="js/bootstrap.js"></script>
    </head>
    <body>
        <form action="procesar.do" method="post">
            <div class="row">
                <div class="col-lg-4"></div>
                <div class="col-lg-4">Usuario: <input type="text" name="txtUsu" class="form-control"></div>
                <div class="col-lg-4"></div>
            </div>
            <div class="row">
                <div class="col-lg-4"></div>
                <div class="col-lg-4">Contraseña: <input type="password" name="pswUsu" class="form-control"></div>
                <div class="col-lg-4"></div>
            </div>
            <div class="row">
                <div class="col-lg-4"></div>
                <div class="col-lg-4"><br><div style="color: #FF0000; text-align: center;">${errorMessage}</div></div>
                <div class="col-lg-4"></div>
            </div>

            <div class="row">
                <div class="col-lg-4"></div>
                <div class="col-lg-4 text-right"><br><br><input type="submit" id="smtLogin" class="btn-default" value="Login"/></div>
                <div class="col-lg-4"></div>
            </div>   
        </form>
    </body>
</html>
