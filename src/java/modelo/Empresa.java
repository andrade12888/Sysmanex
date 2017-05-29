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
   
    //POST: Retorna 1 si se ejecuta con exito, 0 si no reotorna nada, 2 si alguna de las variables
    //      es nula (Rut o persona autorizada) o -1 si existe algun error en la secuancia SQL
    protected int AgregarEmpresa() {
        Conecciones conDB = new Conecciones();
        int resultado;
        if (!"".equals(this.rutEmpresa) || !(this.listaPersonasAutorizadas.isEmpty())) {
            
            for(Persona p:this.listaPersonasAutorizadas)
            {
                 String query = "INSERT INTO \"SysmanexSch1\".\"Empresa\"(\n"
                    + "\"empresaRut\", \"empresaAutorizadosId\",\n"
                    + "\"empresaNombre\")\n"
                    + "   VALUES ('" + this.rutEmpresa + "', '" + p.getCiPersona() +"', '" + this.nombreEmpresa+"');";
                 conDB.hacerConsultaIUD(query);                
            }
           resultado = 1;
        } else {
            resultado = 2;
        }
        return resultado;
    }
    
     protected static ResultSet BuscarEmpresas() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Empresa\" ORDER BY \"ArchivoNombre\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }
    
     protected static ResultSet BuscarArchivoPorNombre(String nombre) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Archivo\""
                + " WHERE \"ArchivoNombre\" LIKE \'%" + nombre + "\'"
                + " ORDER BY \"ArchivoNombre\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }
     
     protected static ResultSet BuscarArchivoPorId(int idArchivo) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Archivo\""
                + " WHERE \"ArchivoId\" = "+idArchivo + ";";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    
}

