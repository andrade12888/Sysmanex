/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Utilidades.FileSettings;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import modelo.Formulario;
import org.apache.commons.fileupload.FileUploadBase.SizeLimitExceededException;

/**
 *
 * @author SG0891660
 */
@WebServlet(name= "CFormularios", urlPatterns = {"/formulario.do"})
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class CFormularios extends HttpServlet {

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

        if(request.getParameter("btnBajarFrm")!=null)
        {
            BajarArchivo(request,response);
             
        } else SubirArchivo(request,response);                                             
    }       
    
    private void BajarArchivo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException       
    {
        try{
             // Leeo la ruta del archivo desde el form
        String filePath = request.getParameter("formularioRuta");
          
        File downloadFile = new File(filePath);
        FileInputStream inStream = new FileInputStream(downloadFile);            

        ServletContext context = getServletContext();         
        // gets MIME type of the file
        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {        
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
         
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
         
        // Se fuerza el  download
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"", downloadFile.getName());
        response.setHeader(headerKey, headerValue);
         
        // Obtener respuesta
        OutputStream outStream = response.getOutputStream();
         
        byte[] buffer = new byte[4096];
        int bytesRead = -1;
         
        while ((bytesRead = inStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
         
        inStream.close();
        outStream.close();
        } catch (Exception ex) {
                        request.setAttribute("errorMessage", "Ocurrio un error al bajar el archivo");
                        request.setAttribute("colorError", "red");
                        request.getRequestDispatcher("formularios.jsp").forward(request, response);                                                
                    }
    }

     private void SubirArchivo(HttpServletRequest request, HttpServletResponse response)//TODO: Control de errores
            throws ServletException, IOException{  
         
         String fileName="";
        try {
            // Verify the content type
            String contentType = request.getContentType();
            
            if ((contentType.contains("multipart/form-data"))) {
                DiskFileItemFactory factory = new DiskFileItemFactory();
                // maximum size that will be stored in memory
                factory.setSizeThreshold(FileSettings.getMaxMemSize());                                
                
                // Create a new file upload handler
                ServletFileUpload upload = new ServletFileUpload(factory);
                
                // maximum file size to be uploaded.
                upload.setSizeMax( FileSettings.getMaxFileSize() );
                
                try {
                    // Parse the request to get file items.
                    List fileItems = upload.parseRequest(request);
                    
                    // Process the uploaded file items
                    Iterator i = fileItems.iterator();
                    fileName=FileSettings.GuardarArchivoEndDisco(i);
                    
                } catch(SizeLimitExceededException fse) {
                    int tamano =(FileSettings.getMaxFileSize()/1024)/1024;
                    request.setAttribute("errorMessage", "El tamano del archivo supera el tamaño permitido ("+tamano+" MB)");
                    request.setAttribute("colorError", "red");
                    request.getRequestDispatcher("formularios.jsp").forward(request, response);    
                } catch(Exception ex) {
                    
                    request.setAttribute("errorMessage", "Ocurrio un error al subir el archivo");
                    request.setAttribute("colorError", "red");
                    request.getRequestDispatcher("formularios.jsp").forward(request, response);    
                }
            }
            
            Formulario f = new Formulario();
            
            //Me quedo con el nobmre antes del punto
            String[] parts = fileName.split("[.]");
            String part1 = parts[0];
            f.setNombreFormulario(part1);            
            // constructs the directory path to store upload file
            f.setRutaRormulario(FileSettings.getFilePathWeb()+fileName);
            f.setFechaCreacionFormulario(Utilidades.ConvertionUtil.CurrentDate());
            f.AgregarFormulario();
            request.getRequestDispatcher("formularios.jsp").forward(request, response); 
        } catch (SQLException ex) {
            request.setAttribute("errorMessage", "Ocurrio un error al subir el archivo");
            request.setAttribute("colorError", "red");
            request.getRequestDispatcher("formularios.jsp").forward(request, response); 
       
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
