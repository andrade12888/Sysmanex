/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import modelo.Entidad;
import modelo.Estado;
import modelo.Expediente;
import modelo.Tramite;

/**
 *
 * @author andra
 */
@WebServlet(name = "CExpediente", urlPatterns = {"/CExpediente.do"})
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class CExpediente extends HttpServlet {

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
        Expediente unExpediente = new Expediente();
        unExpediente.setNumeroExpediente(request.getParameter("txtNroExpediente"));
        unExpediente.setAsuntoExpediente(request.getParameter("txtAsunto"));
        unExpediente.setExpedientePublico(Boolean.parseBoolean(request.getParameter("publico")));
        Tramite unTramite = new Tramite();
        unTramite.BuscarTramite(Integer.parseInt(request.getParameter("selTramite")));
        unExpediente.setTramiteExpediente(unTramite);
        Estado unEstado = new Estado();
        unEstado.BuscarEstado(5);
        unExpediente.setEstadoExpediente(unEstado);
        unExpediente.setEntidadOrigien((Entidad) request.getSession().getAttribute("usuarioLogeado"));

        int resultado = unExpediente.AgregarExpediente();
        
        
        if (resultado == 1) {
            List<Part> fileParts = request.getParts().stream().filter(part -> "input-1a".equals(part.getName())).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
            if (fileParts.isEmpty()) {
                unExpediente.setListaArchivosExpediente(null);
            } else {
                for (Part filePart : fileParts) {
                    String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
                    String extension = "";
                    int i = fileName.lastIndexOf('.');
                    if (i >= 0) {
                        extension = fileName.substring(i + 1);
                    }
                    File archivoDestino = new File("C:\\upload\\" + fileName);
                    Path destino = Paths.get("C:\\upload\\" + fileName);
                    try (InputStream input = filePart.getInputStream()) {
                        Files.copy(input, destino, REPLACE_EXISTING);
                        int result = unExpediente.AgregarArchivoExpediente(destino.getFileName().toString());
                        if(result == 1){
                            unExpediente.getListaArchivosExpediente().add(destino.getFileName().toString());
                        }else{
                            resultado = 3;
                        }
                    }catch(Exception e){
                        resultado = 4;
                    }
                }
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
