<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>

<%@page import="modelo.Expediente" %>
<% Expediente exp = new Expediente();

%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<jsp:include page="master/header.jsp"/>
<div class="bodyContent">
    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-6"><h3>Seleccione el tipo de reporte que desea ver.</h3></div>         
        <div class="col-lg-2"></div>
        <div class="col-lg-2"><br></div>
    </div>
    <div class="row">
        <div class="col-lg-4"></div>
        <div class="col-lg-4"><br><div id="errorMotivo" style="color: ${colorError}; text-align: center;">${errorMessage}</div></div>
        <div class="col-lg-4"></div>
    </div>
    <form name="frmReportes" action="CReportes" method="POST">
        <div class="row" >
            <div class="col-lg-3"><table border="1" cellspacing="2" cellpadding="2">
                    <thead>
                        <tr>
                            <th>Tramites vencidos</th>
                            <th>Reporte 1</th>
                            <th>Reporte 2</th>
                            <th>Reporte 3</th>
                            <th>Reporte 4</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td> <input type="submit" value="MostrarVencidos" name="btnVencidos" class="btn-block" />
                                <input type="hidden" value="MostrarVencidos" name="btnVencidos" />
                            </td>
                            <td></td>
                            <td></td>
                            <td></td>
                            <td></td>
                        </tr>
                    </tbody>
                </table>
                <br/>
            </div>            
            <div class="col-lg-2">
                <div class="row">
                    <div class="col-lg-2"></div>
                    <div class="col-lg-8">
                        <div class="col-lg-3">
                            <table border="1" cellspacing="2" cellpadding="2">

                            </table>
                        </div>
                    </div>
                    <div class="col-lg-2"></div>
                </div>

            </div>
        </div>
    </form>
</div>

<jsp:include page="master/footer.jsp"/>

<!--   
<sql:setDataSource var = "snapshot" driver = "org.postgresql.Driver"
                   url = "jdbc:postgresql://localhost:5432/SysmanexDB2"
                   user = "postgres"  password = "gabrielsebastian"/>
<sql:query dataSource = "${snapshot}" var = "result">             
       SELECT * FROM "SysmanexSch1"."Persona" 
</sql:query>
       
   <table border="1">
    
       <tr>
<c:forEach var="columnName" items="${result.columnNames}">
    <th><c:out value="${columnName}"/></th>
</c:forEach>
</tr>

<c:forEach var="row" items="${result.rowsByIndex}">
    <tr>
    <c:forEach var="column" items="${row}">
        <td><c:out value="${column}"/></td>
    </c:forEach>
    </tr>
</c:forEach>
</table>   
-->