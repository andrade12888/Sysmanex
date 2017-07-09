/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import controlador.CEnvio;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author SG0891660
 */
public abstract class Mensajes {
    
      public static void mensajeSuccessError(String mensaje, String paginaEnvio,String color,HttpServletRequest request, HttpServletResponse response)
    {
        request.setAttribute("errorMessage", mensaje);
        request.setAttribute("colorError", color);
        try {
            request.getRequestDispatcher(paginaEnvio).forward(request, response);
        } catch (ServletException ex) {
            Logger.getLogger(CEnvio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CEnvio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(CEnvio.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
}
