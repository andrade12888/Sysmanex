/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import Utilidades.Control;
import Utilidades.Mensajes;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empresa;

/**
 *
 * @author SG0891660
 */
@WebServlet(name = "CEmpresas", urlPatterns = {"/CEmpresas.do"})
public class CEmpresas extends HttpServlet {

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

        String RUT = request.getParameter("txtActualizarEmpresaRUT");
        String nombre = request.getParameter("txtActualizarEmpresa");
         String rutViejo = request.getParameter("txtViejoRUT");
        String btn = "";

        if (request.getParameter("btnEmpresas") != null) {
            btn = request.getParameter("btnEmpresas");
        }
        switch (btn) {
            case "Guardar": {

                Empresa empresa = ConstruirEmpresa(nombre, RUT);

                if (empresa != null) {

                    boolean existe = Control.ControlEmpresaExistente(empresa, request, response);

                    if (!existe) {
                        try {
                            empresa.AgregarEmpresa();
                            Mensajes.mensajeSuccessError("La empresa " + empresa.getNombreEmpresa() + " se ingreso correctamente", "empresas.jsp", "green", request, response);
                        } catch (Exception ex) {
                            Mensajes.mensajeSuccessError("Error al ingresar la empresa", "empresas.jsp", "red", request, response);
                        }
                    } else {
                        Mensajes.mensajeSuccessError("La empresa ya existe", "empresas.jsp", "red", request, response);
                    }
                }
            }
            break;

            case "Update": {
                
                Empresa empresa = ConstruirEmpresa(nombre, RUT);
                //Si la empresa es nul, entonces los campos rut o nombre ingresados son vacios
                if (empresa != null) {
                    boolean existe = Control.ControlEmpresaExistente(empresa, request, response);

                    if (!existe) {
                        try {
                                int re = Empresa.ModificarEmpresa(empresa, rutViejo);
                            if (re == 1) {
                                Mensajes.mensajeSuccessError("La empresa " + empresa.getNombreEmpresa() + " se modifico correctamente", "empresas.jsp", "green", request, response);
                            }
                            if (re == 23503) {
                                Mensajes.mensajeSuccessError("La empresa " + empresa.getNombreEmpresa() + " tiene personas asociadas y no se puede cambiar el RUT", "empresas.jsp", "green", request, response);
                            }

                            Mensajes.mensajeSuccessError("Error al ingresar la empresa (Codigo:DBQ)", "empresas.jsp", "red", request, response);
                        } catch (Exception ex) {
                            Mensajes.mensajeSuccessError("Error al ingresar la empresa", "empresas.jsp", "red", request, response);
                        }
                    } else {
                        Mensajes.mensajeSuccessError("La empresa ya existe", "empresas.jsp", "red", request, response);
                    }
                }
                Mensajes.mensajeSuccessError("Los campos RUT y nombre empresa son mandatorios", "empresas.jsp", "red", request, response);

            }
            break;

            case "Delete": {
                 
                String empresaRut = request.getParameter("empresaBorrar");
                //Si la empresa es nul, entonces los campos rut o nombre ingresados son vacios
                if (empresaRut != null) {
                        try{
                            int re = Empresa.BorrarEmpresa(empresaRut);
                            if (re == 1) {
                                Mensajes.mensajeSuccessError("La empresa se elimino correctamente", "empresas.jsp", "green", request, response);
                            }
                            if (re == 23503) {
                                Mensajes.mensajeSuccessError("La empresa tiene personas asociadas y no se puede borrar", "empresas.jsp", "green", request, response);
                            }

                            Mensajes.mensajeSuccessError("Error al ingresar la empresa (Codigo:DBQ)", "empresas.jsp", "red", request, response);
                        } catch (Exception ex) {
                            Mensajes.mensajeSuccessError("Error al ingresar la empresa", "empresas.jsp", "red", request, response);
                        }                    
                } else
                    Mensajes.mensajeSuccessError("Los campos RUT y nombre empresa son mandatorios", "empresas.jsp", "red", request, response);
            }
            break;

            default:
                Mensajes.mensajeSuccessError("Elija una opcion valida", "empresas.jsp", "red", request, response);

        }
    }

    //Si los valores de el nombre y el rut no son vacios, entonces creo un objeto Empresa con dichos valores
    private Empresa ConstruirEmpresa(String nombre, String rut) {
        if (!"".equalsIgnoreCase(nombre) && !"".equalsIgnoreCase(rut)) {

            Empresa empresa = new Empresa();
            empresa.setNombreEmpresa(nombre);
            empresa.setRutEmpresa(rut);

            return empresa;
        }
        return null;
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
        //  processRequest(request, response);
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
