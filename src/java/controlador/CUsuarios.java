/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empresa;
import modelo.Persona;
import modelo.UnidadArmada;

/**
 *
 * @author andra
 */
@WebServlet(name = "CUsuarios", urlPatterns = {"CUsuarios.do"})
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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//            String id = $("#selectId option:selected").attr("id");
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
        
        
        
        request.getSession().setAttribute("lstUnidades", unidadesOpt);
        request.getSession().setAttribute("lstEmpresa", empresaOpt);
        request.getSession().setAttribute("lstPersonas", personasOpt);
        request.getSession().setAttribute("lstUnidadesPersonas", unidadesOpt+personasOpt);
        
        
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
