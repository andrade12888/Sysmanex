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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Motivo;

/**
 *
 * @author SG0891660
 */
@WebServlet(name= "Motivos", urlPatterns = {"/motivos.do"})
public class CMotivos extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String btn="";
        
        if (request.getParameter("btnMotivos") != null) {
            btn = request.getParameter("btnMotivos");
        }
        
         switch (btn) {
            case "Guardar": {
                String tipoTramite = request.getParameter("txtMotivo");                
                Motivo unMotivo = new Motivo(tipoTramite);
                int resultado = unMotivo.AgregarMotivo();
                switch (resultado) {
                    case 1:
                        request.setAttribute("errorMessage", "Se ingreso correctamente");
                        request.setAttribute("colorError", "green");
                        request.getRequestDispatcher("Motivos.jsp").forward(request, response);
                        break;
                    case 0:
                        request.setAttribute("errorMessage", "Ocurrio un error");
                        request.setAttribute("colorError", "red");
                        request.getRequestDispatcher("Motivos.jsp").forward(request, response);
                        break;
                    case 2:
                        request.setAttribute("errorMessage", "La descripcion del motivo no puede ser vacia.");
                        request.setAttribute("colorError", "red");
                        request.getRequestDispatcher("Motivos.jsp").forward(request, response);
                        break;
                }
                break;
            }
            case "Update": {
                String descMotivo = request.getParameter("txtActualizarMotivo");               
                 int idMotivo = parseInt(request.getParameter("txtActualizarId"));                
                int resultado = Motivo.ModificarMotivo(idMotivo,descMotivo);
                switch (resultado) {
                    case 1:
                        request.setAttribute("errorMessage", "Se actualizo correctamente");
                        request.setAttribute("colorError", "green");
                        request.getRequestDispatcher("Motivos.jsp").forward(request, response);
                        break;
                    case 0:
                        request.setAttribute("errorMessage", "Ocurrio un error");
                        request.setAttribute("colorError", "red");
                        request.getRequestDispatcher("Motivos.jsp").forward(request, response);
                        break;
                    case 2:
                        request.setAttribute("errorMessage", "La descripcion del motivo no puede ser vacia.");
                        request.setAttribute("colorError", "red");
                        request.getRequestDispatcher("Motivos.jsp").forward(request, response);
                        break;
                }
                break;
            }
            default:       
                int idMotivo = parseInt(request.getParameter("btnMotivos"));                ; 
                int resultado = Motivo.BorrarMotivo(idMotivo);
                switch (resultado) {
                    case 1:
                        request.setAttribute("errorMessage", "Se elimino correctamente");
                        request.setAttribute("colorError", "green");
                        request.getRequestDispatcher("Motivos.jsp").forward(request, response);
                        break;
                    case 23503:
                        request.setAttribute("errorMessage", "No se puede borrar el motivo. Existe un Tramite con este motivo");
                        request.setAttribute("colorError", "red");
                        request.getRequestDispatcher("Motivos.jsp").forward(request, response);
                        break;
                    case -1:
                        request.setAttribute("errorMessage", "Error al borrar el motivo.");
                        request.setAttribute("colorError", "red");
                        request.getRequestDispatcher("Motivos.jsp").forward(request, response);
                        break;    
                }
                break;
        }
       
    }
    
     public static void CargarDatos(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException{
        
        ResultSet rst = Motivo.BuscarMotivos();
        String tramiteOpt = "";
        while (rst.next()) {
            tramiteOpt += "<option value=\"" + rst.getInt("motivoId") + "\">"
                    + rst.getString("motivoDescripcion")+ " </option>";
        }
               
        request.getSession().setAttribute("lstMotivos", tramiteOpt);

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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CMotivos.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(CMotivos.class.getName()).log(Level.SEVERE, null, ex);
             request.setAttribute("errorMessage", "Ocurrio un error al ingresar el Motivo en la base de datos: <br>"+ ex.getMessage());           
             request.setAttribute("colorError", "red");
             request.getRequestDispatcher("Motivos.jsp").forward(request, response);
        }
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
