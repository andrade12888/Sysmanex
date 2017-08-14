/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Utilidades.Mensajes;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Entidad;
import modelo.Estado;
import modelo.Expediente;
import modelo.Persona;
import modelo.Tramite;
import modelo.UnidadArmada;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author andra
 */
@WebServlet(name = "CExpediente", urlPatterns = {"/CExpediente.do"})
@MultipartConfig(location = "/tmp", fileSizeThreshold = 1024 * 1024,
        maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class CExpediente extends HttpServlet {

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
        String relativeWebPath = "/upload/";
        String filePath = getServletContext().getRealPath(relativeWebPath);
        isMultipart = ServletFileUpload.isMultipartContent(request);
        response.setContentType("text/html;charset=UTF-8");
        Entidad logeado = (Entidad) request.getSession().getAttribute("usuarioLogeado");
        String errorMessage = "";
        Expediente unExpediente = new Expediente();
        unExpediente.setEntidadOrigien(logeado);
        int retorno = -1;
        if (isMultipart) {

            try {
                List<FileItem> items = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                for (FileItem item : items) {
                    if (item.isFormField()) {
                        String fieldname = item.getFieldName();
                        String fieldvalue = item.getString();

                        switch (fieldname) {
                            case "txtNroExpediente":
                                if (!"".equals(fieldvalue)) {
                                    unExpediente.setNumeroExpediente(fieldvalue, logeado.getEntidadId());
                                } else {
                                    Mensajes.mensajeSuccessError("El Nro de expediente no puede ser vacie", "nuevoExpediente.jsp", "red", request, response);
                                    return;
                                }
                                break;
                            case "txtAsunto":

                                unExpediente.setAsuntoExpediente(fieldvalue);
                                break;
                            case "publico":
                                unExpediente.setExpedientePublico(Boolean.parseBoolean(fieldvalue));
                                break;
                            case "selTramite":
                                if (!"0".equals(fieldvalue)) {
                                    Tramite unTramite = new Tramite();
                                    unTramite.BuscarTramite(Integer.parseInt(fieldvalue));
                                    unExpediente.setTramiteExpediente(unTramite);
                                }else {
                                    Mensajes.mensajeSuccessError("Debe seleccionar un tramite", "nuevoExpediente.jsp", "red", request, response);
                                    return;
                                }

                                break;
                        }
                    }
                }
                if (retorno == -1) {
                    int resultado = unExpediente.AgregarExpediente();
                    request.getSession().setAttribute("expedienteEnviar", unExpediente.getNumeroExpediente());
                    String nroExped = unExpediente.getNumeroExpediente();
                    int iterador = 0;
                    if (resultado == 1) {
                        for (FileItem item : items) {
                            if (!item.isFormField() && !"".equals(item.getName())) {
                                String fieldName = item.getFieldName();
                                String fileName = item.getName();
                                String contentType = item.getContentType();
                                boolean isInMemory = item.isInMemory();
                                long sizeInBytes = item.getSize();
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
                                    unExpediente.AgregarArchivoExpediente("\\Sysmanex\\upload\\"+nombre);

                                } catch (Exception ex) {
                                    errorMessage = "Error al escribir el archivo " + file.getName() + " en disco ";
                                    request.setAttribute("errorMessage", errorMessage);
                                    request.getRequestDispatcher("nuevoExpediente.jsp").forward(request, response);
                                }
                            }
                        }
                    } else if (resultado == 23505) {
                        Mensajes.mensajeSuccessError("El expediente nro: " + unExpediente.getNumeroExpediente() + " ya fue ingresado", "nuevoExpediente.jsp", "red", request, response);
                    } else {
                        errorMessage = "Error al subir archivo ";
                        request.setAttribute("errorMessage", errorMessage);
                        request.getRequestDispatcher("nuevoExpediente.jsp").forward(request, response);
                    }

                    if (resultado == 1) {
                        errorMessage = "Expediente agregado correctamente.";
                        request.setAttribute("errorMessage", errorMessage);
                        request.getRequestDispatcher("envioExpediente.jsp").forward(request, response);
                    }
                } else {
                    if (retorno == 1) {
                        errorMessage = "Expediente  eliminado correctamente.";
                        request.setAttribute("errorMessage", errorMessage);
                        request.getRequestDispatcher("misExpedientes.jsp").forward(request, response);
                    } else {
                        errorMessage = "No se ha podido borrar el expediente.";
                        request.setAttribute("errorMessage", errorMessage);
                        request.getRequestDispatcher("misExpedientes.jsp").forward(request, response);
                    }
                }
            } catch (FileUploadException ex) {
                errorMessage = "Hubo un error.";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("nuevoExpediente.jsp").forward(request, response);
            }
        } else {
            String btn = request.getParameter("btnEliminarExpediente");
            int result = unExpediente.BorrarExpediente(btn);
            if (result == 1) {
                errorMessage = "Expediente borrado correctamente";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("misExpedientes.jsp").forward(request, response);
            } else {
                errorMessage = "Error al borrar expediente";
                request.setAttribute("errorMessage", errorMessage);
                request.getRequestDispatcher("misExpedientes.jsp").forward(request, response);
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

    public static void CargarDatos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {

        request.getSession().setAttribute("lstRecibidos", null);
        Entidad u1 = (Entidad) request.getSession().getAttribute("usuarioLogeado");
        ResultSet rs = u1.ExpedientesRecibidos();
        String recibidos = "";
        
        while (rs.next()) {
            String estado=""; 
            Estado unEstado = new Estado();
            unEstado.BuscarEstadoDescripcion(rs.getString("estadoDescripcion"));
            switch(unEstado.getIdEstado()){
                case 1: estado = "class=\"enTramite\""; break;
                case 2: estado = "class=\"noLeido\""; break;
                case 3: estado = "class=\"finalizado\""; break;
                case 4: estado = "class=\"nagado\""; break;
                case 5: estado = "class=\"tramitado\""; break;
            
            }
            String nombre = "";
            Persona unaPersona = new Persona();
            unaPersona.BuscarPersonaPorId(rs.getInt("expedienteEntidadId"));
            if (unaPersona.getCiPersona() != null) {
                nombre = unaPersona.getNombrePersona() + " " + unaPersona.getApellidoPersona();
            } else {
                UnidadArmada unaUnidad = new UnidadArmada();
                unaUnidad.BuscarUnidadEntidadId(rs.getInt("expedienteEntidadId"));
                nombre = unaUnidad.getSigla();
            }            
            recibidos += "<tr "+estado+">"
                    + "<td><a href='VisualizarExpediente.do?nroExped=" + rs.getString("expedienteNumero") + "'>" + rs.getString("expedienteNumero") + "</a> </td>"
                    + "<td>" + rs.getString("expedienteAsunto") + " </td>"
                    + "<td>" + rs.getString("tramiteNombre") + " </td>"
                    + "<td>" + nombre + "</td>"
                    + "<td>" + rs.getString("restante") + "  Dias.  </td>"
                    + "<td>" + rs.getString("estadoDescripcion") + " </td>"
                    + "</tr>";
        }
        
        request.getSession().setAttribute("lstRecibidos", recibidos);
        
        
        

    }

}
