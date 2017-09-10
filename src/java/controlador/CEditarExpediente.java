/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Utilidades.Mensajes;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Entidad;
import modelo.Expediente;
import modelo.Tramite;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Nova
 */
@WebServlet(name = "CEditarExpediente", urlPatterns = {"/CEditarExpediente"})
public class CEditarExpediente extends HttpServlet {

    private boolean isMultipart;
    private final int maxFileSize = 50 * 1024;
    private final int maxMemSize = 4 * 1024;
    private File file;

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
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html;charset=UTF-8");
        if (isMultipart) {
            subirArchivo(request, response);
        } else {
            String nroExped = request.getParameter("txtExpedienteEnvio");
            Expediente unExpediente = new Expediente();
            unExpediente.traerExpediente(nroExped);
            Entidad logeado = (Entidad) request.getSession().getAttribute("usuarioLogeado");
            String observacion = request.getParameter("txtObservacion");
            unExpediente.AgregarDetalle(observacion, logeado.getEntidadId());
            
        }

    }

    private void subirArchivo(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String relativeWebPath = "/upload/";
        String filePath = getServletContext().getRealPath(relativeWebPath);
        response.setContentType("text/html;charset=UTF-8");
        Entidad logeado = (Entidad) request.getSession().getAttribute("usuarioLogeado");
        String errorMessage = "";
        Expediente unExpediente = new Expediente();
        unExpediente.setEntidadOrigien(logeado);
        if (isMultipart) {
            try {
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        String fieldname = item.getFieldName();
                        String fieldvalue = item.getString();
                        if ("txtExpedienteEnvio".equals(fieldname)) {
                            unExpediente.traerExpediente(fieldvalue);
                            unExpediente.traerArchivos();
                        }
                    }
                }
                for (FileItem item : items) {
                    String nroExped = unExpediente.getNumeroExpediente();
                    int iterador = unExpediente.getListaArchivosExpediente().size();

                    if (!item.isFormField() && !"".equals(item.getName())) {
                        String fileName = item.getName();
                        String extension = "";
                        int i = fileName.lastIndexOf('.');
                        if (i > 0) {
                            extension = fileName.substring(i + 1);
                        }
                        // Write the file
                        if (fileName.lastIndexOf("\\") >= 0) {
                            file = new File(filePath
                                    + nroExped + iterador + '.' + extension);
                        } else {
                            file = new File(filePath
                                    + nroExped + iterador + '.' + extension);
                        }
                        try {
                            item.write(file);
                            iterador++;
                            String nombre = file.getName();
                            unExpediente.AgregarArchivoExpediente("\\Sysmanex\\upload\\" + nombre);
                        } catch (Exception ex) {
                            errorMessage = "Error al escribir el archivo " + file.getName() + " en disco ";
                            request.setAttribute("errorMessage", errorMessage);
                            request.getRequestDispatcher("bandeja.jsp").forward(request, response);
                        }
                    }
                }

            } catch (FileUploadException ex) {
                errorMessage = "Hubo un error.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("nuevoExpediente.jsp").forward(request, response);
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
