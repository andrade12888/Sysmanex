/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoginModule;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Entidad;

/**
 *
 * @author SG0891660
 */
public class LogIn extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {

        String usu = request.getParameter("txtUsu");
        String pass = request.getParameter("pswUsu");

        if (usu.equals("") || pass.equals("")) {
            request.setAttribute("errorMessage", "Los campos Usuario y contraseña no puede ser vacios.");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            Entidad usr = new Entidad();

            try {
                usr.Autenticar(usu, pass);

                if (usr.getEntidadId() == 0) {
                    request.setAttribute("errorMessage", "Usuario/Contraseña incorrecta.");
                    request.getRequestDispatcher("index.jsp").forward(request, response);

                } else {
                    int resultado = usr.getRol().getId();
                    if (resultado == 2) {
                        request.setAttribute("errorMessage", "El usuario no esta autorizado a ingresar al sistema. Consulte con el administrador");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    } else {
                        request.getSession().setAttribute("usuarioLogeado", usr);
                        request.getRequestDispatcher("bandeja.jsp").forward(request, response);
                    }
                }
            } catch (Exception e) {
                request.setAttribute("errorMessage", "Error al connectarse a la base de datos.Por favor contactarse con el administrador.");                
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
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
        try {
            try {
                processRequest(request, response);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LogIn.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException ex) {
            Logger.getLogger(LogIn.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            try {
                processRequest(request, response);

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(LogIn.class
                        .getName()).log(Level.SEVERE, null, ex);

            }
        } catch (SQLException ex) {
            Logger.getLogger(LogIn.class
                    .getName()).log(Level.SEVERE, null, ex);
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
