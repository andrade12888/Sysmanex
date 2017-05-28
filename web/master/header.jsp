<%-- 
    Document   : exito
    Created on : 02-abr-2017, 14:00:16
    Author     : Nova
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Entidad"%>
<%
    Entidad u1 = (Entidad) request.getSession().getAttribute("usuarioLogeado");

%>
<!DOCTYPE html>
<html>
    <head>
        <title>Sysmanex</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/> 
        <link href="css/master.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>  
        <script src="js/Master.js" type="text/javascript"></script>
    </head>
    <body>
        <!--    --------------       Header inicio       -------------    -->
        <div>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                        <a class="navbar-brand" href="bandeja.jsp">Sistema de Expedientes</a>
                    </div>        
                    <!-- Collect the nav links, forms, and other content for toggling -->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li class="active"><a href="bandeja.jsp">Bandeja de Entrada <span class="sr-only">(current)</span></a></li>
                            <li><a href="nuevoExpediente.jsp">Nuevo Expediente</a></li>
                            <li><a href="#">Mis Expedientes</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Agregar Datos<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Nuevo Tramite</a></li>
                                    <li><a href="documentos.jsp">Documentos</a></li>
                                    <li><a href="#">Nueva Unidad</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Separated link</a></li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">One more separated link</a></li>
                               
                                </ul>
                            </li>
                                 <li class="ax"></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                    
                </div><!-- /.container-fluid -->
                
            </nav>
            <div class="usuarioLogeado"><label class="lblUsuarioLogeado">Bienvenido! Usuario: <%= u1.getNombreEntidad() %></label>(<a href="logout.jsp">salir</a>)</div>
        </div>
