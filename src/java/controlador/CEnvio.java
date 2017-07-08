/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Entidad;
import modelo.Expediente;
import modelo.Persona;
import modelo.UnidadArmada;

/**
 *
 * @author andra
 */
@WebServlet(name = "CEnvio", urlPatterns = {"/CEnvio.do"})
public class CEnvio extends HttpServlet {

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
        String nroExped = request.getParameter("txtExpedienteEnvio");
        int motivo = Integer.parseInt(request.getParameter("selMotivos"));
        String obser = request.getParameter("txtMotivoObs");
        Entidad u1 = (Entidad) request.getSession().getAttribute("usuarioLogeado");
        String[] destinos = request.getParameterValues("selDestinos");
        Expediente unExpediente = new Expediente();
        unExpediente.traerExpediente(nroExped);

        for (String dest : destinos) {
            String tipo = dest.substring(0,6);
            int id = Integer.parseInt(dest.substring (6,7));
            if(tipo.equalsIgnoreCase("selPer")){
                Persona unaEntidad = new Persona();
                unaEntidad.BuscarPersonaPorId(id);
                u1.enviarExpediente(nroExped, unaEntidad, motivo, obser);
            }else if(tipo.equalsIgnoreCase("selUni")){
                UnidadArmada unaEntidad = new UnidadArmada();
                unaEntidad.BuscarUnidadPorId(id);
                u1.enviarExpediente(nroExped, unaEntidad, motivo, obser);
            }
        }

//        Entidad unDestinatario = new Entidad();
//        unDestinatario.buscarEntidadId(Integer.parseInt(fieldvalue.substring(6)));
//        unExpediente.getListaDestinariosExpediente().add(unDestinatario);

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
