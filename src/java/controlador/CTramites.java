/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Tramite;


/**
 *
 * @author Nova
 */
@WebServlet(name = "Tramites", urlPatterns = {"/tramites.do"})
public class CTramites extends HttpServlet {

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
        String btn = "";
        response.setContentType("text/html;charset=UTF-8");
        if (request.getParameter("btnTramite") != null) {
            btn = request.getParameter("btnTramite");
        }
        switch (btn) {
            case "Guardar": {
                String tipoTramite = request.getParameter("txtTramite");
                int plazoTramite = parseInt( request.getParameter("txtPlazo"));
                Tramite unDocu = new Tramite(tipoTramite, plazoTramite);
                int resultado = unDocu.AgregarTramite();
                switch (resultado) {
                    case 1:
                        request.setAttribute("errorMessage", "Se ingreso correctamente");
                        request.setAttribute("colorError", "green");
                        request.getRequestDispatcher("tramites.jsp").forward(request, response);
                        break;
                    case 0:
                        request.setAttribute("errorMessage", "Ocurrio un error");
                        request.setAttribute("colorError", "red");
                        request.getRequestDispatcher("tramites.jsp").forward(request, response);
                        break;
                    case 2:
                        request.setAttribute("errorMessage", "Nombre y plazo son campos requeridos.");
                        request.setAttribute("colorError", "red");
                        request.getRequestDispatcher("tramites.jsp").forward(request, response);
                        break;
                }
                break;
            }
            case "Update": {
                String tipoTramite = request.getParameter("txtActualizarTramite");
                int plazoTramite = parseInt(request.getParameter("txtActualizarPlazo"));
                String idTramite = request.getParameter("txtActualizarId");
                Tramite unDocu = new Tramite(tipoTramite, plazoTramite);
                int resultado = unDocu.ModificarTramite(idTramite);
                switch (resultado) {
                    case 1:
                        request.setAttribute("errorMessage", "Se actualizo correctamente");
                        request.setAttribute("colorError", "green");
                        request.getRequestDispatcher("tramites.jsp").forward(request, response);
                        break;
                    case 0:
                        request.setAttribute("errorMessage", "Ocurrio un error");
                        request.setAttribute("colorError", "red");
                        request.getRequestDispatcher("tramites.jsp").forward(request, response);
                        break;
                    case 2:
                        request.setAttribute("errorMessage", "Nombre y plazo son campos requeridos.");
                        request.setAttribute("colorError", "red");
                        request.getRequestDispatcher("tramites.jsp").forward(request, response);
                        break;
                }
                break;
            }
            default:                
                int resultado = Tramite.BorrarTramite(btn);
                switch (resultado) {
                    case 1:
                        request.setAttribute("errorMessage", "Se elimino correctamente");
                        request.setAttribute("colorError", "green");
                        request.getRequestDispatcher("tramites.jsp").forward(request, response);
                        break;
                    case 0:
                        request.setAttribute("errorMessage", "Ocurrio un error");
                        request.setAttribute("colorError", "red");
                        request.getRequestDispatcher("tramites.jsp").forward(request, response);
                        break;
                }
                break;
        }

    }
    
    public static void CargarDatos(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException{
        
        
        
        ResultSet rst = Tramite.tramitesDB();
        String tramiteOpt = "";
        while (rst.next()) {
            tramiteOpt += "<option value=\"" + rst.getInt("tramiteId") + "\">"
                    + rst.getString("tramiteNombre")+ " </option>";
        }
        
       
        request.getSession().setAttribute("lstTramites", tramiteOpt);
    
        
        
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
