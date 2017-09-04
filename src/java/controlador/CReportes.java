/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Utilidades.Mensajes;
import java.io.IOException;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Expediente;
import modelo.Reportes;
/**
 *
 * @author SG0891660
 */
@WebServlet(name = "CReportes", urlPatterns = {"/CReportes"})
public class CReportes extends HttpServlet {

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
         String btn = "";

        if (request.getParameter("btnVencidos") != null) {
            btn = request.getParameter("btnVencidos");
        }

        switch (btn) {
            case "MostrarVencidos": {
            try {                
                 SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
                 Date date = format1.parse("2017-07-16");
                 String formatted = format1.format(date);
                
                //Expediente.TablaReportesVencidos();                           
                ResultSet rs =  Expediente.ExpedientesVencidosPorAno(formatted);
                Reportes.LineChart(rs,"ExpVencidos");
                Mensajes.mensajeSuccessError("", "customReports.jsp", "white", request, response);
                break;
            } catch (Exception ex) {                
            }
            }
            case "": {

                break;
                }
            default:Mensajes.mensajeSuccessError("Ha ocurrido un error inesperado", "customReports.jsp", "red", request, response);
            }           
                        
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
