/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.util.ArrayList;
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
 * @author Nova
 */
@WebServlet(name = "CVisualizarExpediente", urlPatterns = {"/VisualizarExpediente.do"})
public class CVisualizarExpediente extends HttpServlet {

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
        Entidad u1 = (Entidad) request.getSession().getAttribute("usuarioLogeado");
        String conectado = "";
        Persona unPersona = new Persona();
        unPersona.BuscarPersonaPorId(u1.getEntidadId());
        if (unPersona.getCiPersona() != null) {
            conectado = unPersona.getNombrePersona() + " " + unPersona.getApellidoPersona();
        } else {
            UnidadArmada unaUnidad = new UnidadArmada();
            unaUnidad.BuscarUnidadEntidadId(u1.getEntidadId());
            conectado = unaUnidad.getSigla();
        }

        String nroExped = request.getParameter("nroExped");
        Expediente unExpediente = new Expediente();
        unExpediente.traerExpediente(nroExped);
        unExpediente.traerArchivos();
        unExpediente.traerDetalle();
        unExpediente.leerExpediente(u1.getEntidadId());
        int iterador = 0;
        if (unExpediente.getListaArchivosExpediente() != null) {
            String tabla = "<table class=\"table table-striped\"><tr><th>Archivo</th></tr>";
            for (String archivo : unExpediente.getListaArchivosExpediente()) {
                tabla = tabla + "<tr><td><a class=\"doc\" data-fancybox-type=\"iframe\" href=\"" + archivo + "\">" + nroExped + iterador + "</a></td></tr>";
                iterador++;
            }
            tabla = tabla + "</table>";
            request.setAttribute("tablaArchivos", tabla);
        }
        if (unExpediente.getListaDetalle() != null) {
            String tabla = "<div class=\"listaDetalle\">";
            for (String detalle : unExpediente.getListaDetalle()) {
                String string = detalle;
                String[] partes = string.split("#");
                String originador = "";
                Persona unaPersona = new Persona();
                unaPersona.BuscarPersonaPorId(Integer.parseInt(partes[2]));
                if (unaPersona.getCiPersona() != null) {
                    originador = unaPersona.getNombrePersona() + " " + unaPersona.getApellidoPersona();
                } else {
                    UnidadArmada unaUnidad = new UnidadArmada();
                    unaUnidad.BuscarUnidadEntidadId(Integer.parseInt(partes[2]));
                    originador = unaUnidad.getSigla();
                }

                tabla = tabla + "<ul class='ulObservacion'>"
                        + "<li class='liFechaEntidadObservacion'>" + originador + "  -  " + partes[3] + "</li>"
                        + "<li class='liDetalleObservacion'><span>" + partes[1] + "</span></li>"
                        + "</ul>";
                iterador++;
            }
            tabla = tabla + "</div>";
            request.setAttribute("listaDetalle", tabla);
        }

        request.setAttribute("tablaTramitados", unExpediente.mostrarSeguimiento(nroExped));
        request.setAttribute("numeroExpediente", nroExped);
        request.setAttribute("asuntoExpediente", unExpediente.getAsuntoExpediente());
        request.setAttribute("fechaExpediente", unExpediente.getFechaExpediente());
        request.setAttribute("entidadExpediete", unExpediente.getEntidadOrigien().getNombreEntidad());
        request.setAttribute("tramiteExpediete", unExpediente.getTramiteExpediente().getNombre());

        String errorMessage = "";
        request.setAttribute("errorMessage", errorMessage);
        request.getRequestDispatcher("expediente.jsp").forward(request, response);

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
