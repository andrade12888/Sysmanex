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
        <link href="css/fileinput.css" rel="stylesheet" type="text/css"/>
        <script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
        <script src="js/jquery-3.1.1.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.js" type="text/javascript"></script>  
        <script src="js/Master.js" type="text/javascript"></script>
         
        <script src="js/fileinput.js" type="text/javascript"></script>
       <script src="js/locales/es.js" type="text/javascript"></script>
        
        
    </head>
    <body>
        <!--    --------------       Header inicio       -------------    -->
        <div>
            <nav class="navbar navbar-default">
                <div class="container-fluid">
                    <!-- Brand and toggle get grouped for better mobile display -->
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
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
                            <li><a href="misExpedientes.jsp">Mis Expedientes</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" >Agregar Datos<span class="caret"></span></a>
                                <ul class="dropdown-menu">
                                    <li><a href="motivos.jsp">Motivos</a></li>                                
                                    <li><a href="tramites.jsp">Tramites</a></li>
                                    <li><a href="formularios.jsp">Formularios</a></li>                                                                         
                                </ul>
                            </li>
                            <li><a href="gestionUsuarios.jsp">Gestion Usuarios</a></li>
                                 <li class="ax"></li>
                        </ul>
                    </div><!-- /.navbar-collapse -->
                    
                </div><!-- /.container-fluid -->
                
            </nav>
            <div class="usuarioLogeado"><label class="lblUsuarioLogeado">Bienvenido! <%= u1.getNombreEntidad() %></label>(<a href="logout.jsp">salir</a>)</div>
        </div>
