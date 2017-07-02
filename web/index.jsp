<%-- 
    Document   : index
    Created on : 02-abr-2017, 13:45:46
    Author     : Nova
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sysmanex</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script src="js/bootstrap.js" type="text/javascript"></script>
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/master.css">
    </head>
    <body>
        <div class="login">
            <h1>Bienvenido a Sysmanex</h1>
            <div class="loginContent">

                <form action="LogIn" method="post">
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
                        <div class="col-lg-4 text-right"><br><br><input type="submit" id="smtLogin" class="btn-agregar" value="Login"/></div>
                        <div class="col-lg-4"></div>
                    </div>   
                </form>
            </div>
        </div>        
    </body>
</html>
