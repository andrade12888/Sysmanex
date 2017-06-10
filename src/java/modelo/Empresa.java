/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import accesoaDatos.Conecciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nova
 */
public class Empresa {

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private String rutEmpresa;
    private ArrayList<Persona> listaPersonasAutorizadas;
    private String nombreEmpresa;
    //</editor-fold>

   //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    /**
     * Get the value of rutEmpresa
     *
     * @return the value of rutEmpresa
     */
    public String getRutEmpresa() {
        return rutEmpresa;
    }

    /**
     * Set the value of rutEmpresa
     *
     * @param rutEmpresa new value of rutEmpresa
     */
    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    /**
     * @return the listaPersonasAutorizadas
     */
    public ArrayList<Persona> getListaPersonasAutorizadas() {
        return listaPersonasAutorizadas;
    }

    /**
     * @param listaPersonasAutorizadas the listaPersonasAutorizadas to set
     */
    public void setListaPersonasAutorizadas(ArrayList<Persona> listaPersonasAutorizadas) {
        this.listaPersonasAutorizadas = listaPersonasAutorizadas;
    }

    /**
     * @return the nombreEmpresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * @param nombreEmpresa the nombreEmpresa to set
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Empresa(String rutEmpresa, ArrayList<Persona> listaPersonasAutorizadas) {
        this.rutEmpresa = rutEmpresa;
        this.listaPersonasAutorizadas = listaPersonasAutorizadas;
    }

    public Empresa(String rutEmpresa, ArrayList<Persona> listaPersonasAutorizadas, String nombreEmpresa) {
        this.rutEmpresa = rutEmpresa;
        this.listaPersonasAutorizadas = listaPersonasAutorizadas;
        this.nombreEmpresa = nombreEmpresa;
    }

    //</editor-fold>
    
    //PRE: NA
    //POST: Retorna 1 si se ejecuta con exito, 0 si no reotorna nada, 2 si alguna de las variables
    //      es nula (Rut o persona autorizada) o -1 si existe algun error en la secuancia SQL
    protected int AgregarEmpresa() {
        Conecciones conDB = new Conecciones();
        int resultado;        

        if (!"".equals(this.rutEmpresa) && !"".equals(this.nombreEmpresa)) {
            
            String queryInsertEmpresa = "INSERT INTO \"SysmanexSch1\".\"Empresa\"(\n"
                    + "\"empresaRut\", \"empresaNombre\")\n"
                    + "   VALUES ('" + this.rutEmpresa + "', '" + this.nombreEmpresa + "');";
            try {
                conDB.hacerConsultaIUD(queryInsertEmpresa);
            } catch (SQLException ex) {
                Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
            }
            resultado = 1;
        } else {
            System.err.print("El RUT no puede ser vacio.\n");
            System.err.print("El nombre de la empresa no puede ser vacio.");
            resultado = 2;
        }
        return resultado;
    }

    protected static ResultSet BuscarEmpresas() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String query = "SELECT * FROM \"SysmanexSch1\".\"Empresa\" ORDER BY \"empresaNombre\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    protected static ResultSet BuscarEmpresaPorNombre(String nombre) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String query = "SELECT * FROM \"SysmanexSch1\".\"Empresa\""
                + " WHERE \"empresaNombre\" LIKE \'%" + nombre + "\'"
                + " ORDER BY \"empresaNombre\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    protected static ResultSet BuscarEmpresaPorRUT(String rutEmpresa) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Empresa\""
                + " WHERE \"empresaRut\" = \'" + rutEmpresa + "\';";
        rs = conDB.hacerConsulta(query);

        return rs;
    }
    
    //TODO: Discutir sobre el borrado de empresas
    protected static int BorrarEmpresa(String RUT) throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado=-1;

        String query = "DELETE \"SysmanexSch1\".\"Empresa\"\n"              
                + "	WHERE \"empresaRut\"='" + RUT + "\';";
        try {
            resultado = conDB.hacerConsultaIUD(query);
        } catch (SQLException ex) {
            throw ex;
        }

        
        return resultado;
    }

}
