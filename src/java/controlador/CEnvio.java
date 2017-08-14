/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Utilidades.Mensajes;
import java.io.IOException;
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
        if (motivo <= 0) {
            Mensajes.mensajeSuccessError("Error al enviar el Expediente. El motivo es mandatorio", "misExpedientes.jsp", "red", request, response);
            return;
        }

        String obser = request.getParameter("txtMotivoObs");
        if ("".equals(obser)) {
            obser = "Sin observaciones";
        }

        Entidad u1 = (Entidad) request.getSession().getAttribute("usuarioLogeado");
        String[] destinos = request.getParameterValues("selDestinos");
        Expediente unExpediente = new Expediente();
        unExpediente.traerExpediente(nroExped);

        if (destinos != null) {
            for (String dest : destinos) {
                try {
                    String tipo = dest.substring(0, 6);
                    int id = Integer.parseInt(dest.substring(6, dest.length()));
                    if (tipo.equalsIgnoreCase("selPer")) {
                        try {
                            Persona unaEntidad = new Persona();
                            unaEntidad.BuscarPersonaPorId(id);
                            u1.enviarExpediente(nroExped, unaEntidad, motivo, obser);
             
                        } catch (Exception ex) {
                            Mensajes.mensajeSuccessError("Error al agregar destinatarios", "misExpedientes.jsp", "red", request, response);
                            return;
                        }

                    } else if (tipo.equalsIgnoreCase("selUni")) {
                        try {
                            UnidadArmada unaEntidad = new UnidadArmada();
                            unaEntidad.BuscarUnidadPorId(id);
                            u1.enviarExpediente(nroExped, unaEntidad, motivo, obser);

                        } catch (Exception ex) {
                            Mensajes.mensajeSuccessError("Error al agregar unidades destinatarias", "misExpedientes.jsp", "red", request, response);
                            return;
                        }
                    }
                } catch (Exception ex) {
                    Mensajes.mensajeSuccessError("Ha ocurrido un error al ingresar los destinatarios. No se pudo enviar el expediente", "misExpedientes.jsp", "red", request, response);
                    return;

                }
            }
            Mensajes.mensajeSuccessError("Envio Exitoso", "misExpedientes.jsp", "green", request, response);
        } else {
            Mensajes.mensajeSuccessError("Error al enviar el Expediente.Elija destinatarios", "misExpedientes.jsp", "red", request, response);
        }
        Mensajes.mensajeSuccessError("Envio Exitoso", "misExpedientes.jsp", "green", request, response);
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
