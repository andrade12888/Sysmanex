/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Utilidades.Mensajes;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empresa;
import modelo.Entidad;
import modelo.Persona;
import modelo.Rol;
import modelo.UnidadArmada;

/**
 *
 * @author andra
 */
@WebServlet(name = "CUsuarios", urlPatterns = {"/CUsuarios.do"})
public class CUsuarios extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
                
        String usuario= request.getParameter("txtNombreUsuario");
        String usrPass= request.getParameter("txtPass");        
        String tipoUsuario = request.getParameter("rdTipo");
        int usrRol = Integer.parseInt(request.getParameter("lstRoles"));
        
        Rol r = new Rol();
        r.setId(usrRol);
                /***
                 * // 2 si existe un Expediente con el tipo de tramite que trato de eliminar
                 *   -1 si ocurrion un error del tipo Sql 
                 *    0 si se puede eliminar
                 */
        Entidad e = new Entidad(usuario, usrPass,r);        
        
        if("persona".equalsIgnoreCase(tipoUsuario))
        {
            //Ingreso persona
        } else if("unidad".equalsIgnoreCase(tipoUsuario))
        {
            String siglaUnidad = request.getParameter("txtUnidadSigla");       
            UnidadArmada ua = new UnidadArmada();
            ua.setSigla(siglaUnidad);
            ua.setContrasenia(usrPass);                        
            
            //ingreso unidad 
            int resultadoIngresoUnidadUser = ua.AgregarUnidadUser(e);
            
                switch (resultadoIngresoUnidadUser) {
                    case 1:
                        Mensajes.mensajeSuccessError("El usuario "+usuario+" ha sido ingresado con exito.", "gestionUsuarios.jsp","green", request, response);                                                                        
                        break;
                    case 0:                        
                        Mensajes.mensajeSuccessError("El usuario "+usuario+" ya existe en la base de datos.", "gestionUsuarios.jsp","red", request, response);                                                                        
                        break;
                        
                    case -1:
                        Mensajes.mensajeSuccessError("Ha ocurrido un error al ingresar el usuario.", "gestionUsuarios.jsp","red", request, response);                                                                        
                        break;
                    case 23503:
                        Mensajes.mensajeSuccessError("Debe seleccionar un rol.", "gestionUsuarios.jsp","red", request, response);                                                                        
                        break;
                    default: Mensajes.mensajeSuccessError("Ha ocurrido un error al ingresar el usuario.", "gestionUsuarios.jsp","red", request, response);                                                                        
                        break;
                }
              }
        
    }
    
    public static void CargarDatos(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException{
        
        request.getSession().setAttribute("lstEmpresa", null); 
        request.getSession().setAttribute("lstUnidades", null);
        request.getSession().setAttribute("lstPersonas", null);
        request.getSession().setAttribute("lstUnidadesPersonas", null);
        ResultSet rs = Empresa.BuscarEmpresas();
        String empresaOpt = "";
       
        while (rs.next()) {
            empresaOpt += "<option value=\"selEmp" + rs.getString("empresaRut") 
                    + "\" id=\"selEmp" + rs.getString("empresaRut") + "\">" 
                    + rs.getString("empresaNombre")+ " </option>";
        }

        ResultSet rsu = UnidadArmada.BuscarUnidades();
        String unidadesOpt = "";
        while (rsu.next()) {
            unidadesOpt += "<option value=\"selUni" + rsu.getInt("unidadId") 
                    + "\" id=\"selUni" + rsu.getInt("unidadId") 
                    + "\">"+ rsu.getString("unidadSigla")+ " </option>";
        }
        
        ResultSet rsp = Persona.BuscarPersonas();
        String personasOpt = "";
        while (rsp.next()) {
            personasOpt += "<option value=\"selPer" + rsp.getInt("personaEntidadId") 
                    + "\" id=\"selPer" + rsp.getInt("personaEntidadId") + "\">"
                    + rsp.getString("personaNombre")+" "+rsp.getString("personaApellido")+ " </option>";
        }
        
        ResultSet rsr = Rol.BuscarRoles();
        String rolesOpt = "";
        while (rsr.next()) {
            rolesOpt += "<option value=\"" + rsr.getInt("rolId") 
                    + "\" id=\"" + rsr.getInt("rolId") + "\">"
                    + rsr.getString("rolDescripcion")+" </option>";
        }
        
        
        
        request.getSession().setAttribute("lstUnidades", unidadesOpt);
        request.getSession().setAttribute("lstEmpresa", empresaOpt);
        request.getSession().setAttribute("lstPersonas", personasOpt);
        request.getSession().setAttribute("lstUnidadesPersonas", unidadesOpt+personasOpt);
        request.getSession().setAttribute("lstRoles", rolesOpt);
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
