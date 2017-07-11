<%@page import="controlador.CUsuarios"%>
<%
    CUsuarios.CargarDatos(request, response);
    String empresas = request.getSession().getAttribute("lstEmpresa").toString();
    String unidades = request.getSession().getAttribute("lstUnidades").toString();
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <div class="row">
        <div class="col-lg-1 col-md-1 col-sm-1"></div>
        <div class="col-lg-11 col-md-11 col-sm-11">
            <form action="CUsuarios.do" method="POST" name="formUsuarios" id="fromUsuarios" autocomplete="off">

                <div class="row">
                    <div class="col-lg-3 col-md-3 col-sm-3">
                        <div class="form-group">
                            <label for="txtNombreUsuario">Usuario</label>
                            <input type="text" name="txtNombreUsuario" placeholder="Usuario" class="form-control"  autocomplete="off"/>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-3">
                        <div class="form-group">
                            <label for="txtPass">Contraseña</label>
                            <input type="password" name="txtPass" class="form-control" autocomplete="off"/>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-3">
                        <label>Tipo de usuario</label><br>
                        <div class="btn-group" data-toggle="buttons">
                            <label class="btn btn-info active" id="lblTipo">
                                <input type="radio" name="rdTipo" id="rdPersona" value="persona" checked> Persona
                            </label>
                            <label class="btn btn-info" id="lblTipo">
                                <input type="radio" name="rdTipo" id="rdUnidad" value="unidad" > Unidad
                            </label>
                        </div>
                    </div>
                </div>
                <div id="divTipoPersona">
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-3">
                            <div class="form-group">
                                <label for="txtPersonaCi">CI</label>
                                <input type="text" name="txtPersonaCi" placeholder="Ci" class="form-control"  autocomplete="off"/>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-3">
                            <div class="form-group">
                                <label for="txtPersonaNombre">Nombre</label>
                                <input type="text" name="txtPersonaNombre" placeholder="Nombre" class="form-control"  autocomplete="off"/>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-3">
                            <div class="form-group">
                                <label for="txtPersonaApellido">Apellido</label>
                                <input type="text" name="txtPersonaApellido" placeholder="Apellido" class="form-control"  autocomplete="off"/>
                            </div>                            
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-3"></div>
                    </div>
                    <div class="row">
                        <div class="col-lg-3 col-md-3 col-sm-3">
                            <label>Pertenece</label><br>
                            <div class="btn-group" data-toggle="buttons">
                                <label class="btn btn-info active" id="lblPertenece">
                                    <input type="radio" name="rdPetenece" id="rdarmada" value="armada" autocomplete="off" checked> Armada
                                </label>
                                <label class="btn btn-info" id="lblPertenece">
                                    <input type="radio" name="rdPetenece" id="rdempresa" value="empresa" autocomplete="off"> Empresa
                                </label>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-3" id="divUsuarioUnidad">
                            <div class="form-group">
                                <label for="lstUnidades">Unidad</label>
                                <select name="lstUnidades" class="form-control">
                                    <option value="0">Seleccione unidad</option>
                                    <%= unidades%>
                                </select>
                            </div>                           
                        </div>

                        <div class="col-lg-3 col-md-3 col-sm-3" id="divUsuarioEmpresa" style="display: none;">
                            <div class="form-group">
                                <label for="lstEmpresa">Empresa</label>
                                <select name="lstEmpresa" class="form-control">
                                    <option value="0">Seleccione empresa</option>
                                    <%= empresas%>
                                </select>
                            </div>
                        </div>   

                        <div class="col-lg-3 col-md-3 col-sm-3" id="divRoles">
                            <div class="form-group">
                                <label for="lstUnidades">Roles</label>
                                <select name="lstUnidades" class="form-control">
                                    <option value="0">Seleccione un rol</option>
                                    <%= unidades%>
                                </select>
                            </div>
                        </div>    
                    </div>
                </div>
                <div id="divTipoUnidad">
                    <div id="divSigla" class="row">
                        <div class="col-lg-3 col-md-3 col-sm-3">
                            <div class="form-group">
                                <label for="txtUnidadSigla">Sigla</label>
                                <input type="text" name="txtUnidadSigla" placeholder="Sigla de la unidad" class="form-control"  autocomplete="off"/>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-3" id="divRoles">
                            <div class="form-group">
                                <label for="lstUnidades">Roles</label>
                                <select name="lstUnidades" class="form-control">
                                    <option value="0">Seleccione un rol</option>
                                    <%= unidades%>
                                </select>
                            </div>
                        </div>
                    </div>

                </div>

                <div class="row">
                    <div class="col-lg-offset-10 col-md-offset-10 col-sm-offset-10 col-lg-2 col-md-2 col-sm-2">
                        <input type="submit" value="Agregar" class="btn btn-primary"/>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>
<jsp:include page="master/footer.jsp"/>
