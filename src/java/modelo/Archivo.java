/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import accesoaDatos.Conecciones;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nova
 */
public class Archivo {
    
   // <editor-fold defaultstate="collapsed" desc="Properties">
    
    private int idArchivo;
    private String nombreArchivo;
    private int tamanoArchivo;   
    private String rutaArchivo;
    
    //</editor-fold>
    
   //<editor-fold defaultstate="collapsed" desc="Setters y Getters">
   /**
     * Get the value of idArchivo
     *
     * @return the value of idArchivo
     */       
    
    public int getIdArchivo() {
        return idArchivo;
    }

    /**
     * Set the value of idArchivo
     *
     * @param idArchivo new value of idArchivo
     */
    public void setIdArchivo(int idArchivo) {
        this.idArchivo = idArchivo;
    }      

    /**
     * Get the value of nombreArchivo
     *
     * @return the value of nombreArchivo
     */
    public String getNombreArchivo() {
        return nombreArchivo;
    }

    /**
     * Set the value of nombreArchivo
     *
     * @param nombreArchivo new value of nombreArchivo
     */
    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
     
    /**
     * Get the value of tamanoArchivo
     *
     * @return the value of tamanoArchivo
     */
    public int getTamanoArchivo() {
        return tamanoArchivo;
    }

    /**
     * Set the value of tamanoArchivo
     *
     * @param tamanoArchivo new value of tamanoArchivo
     */
    public void setTamanoArchivo(int tamanoArchivo) {
        this.tamanoArchivo = tamanoArchivo;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }


    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }
    //</editor-fold>
   
   //<editor-fold defaultstate="collapsed" desc="Constructor">
    public Archivo(String nombreArchivo, int tamanoArchivo, String rutaArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.tamanoArchivo = tamanoArchivo;
        this.rutaArchivo = rutaArchivo;
    }
   //</editor-fold>
    
    
    //POST: Retorna 1 si se ejecuta con exito, 0 si no reotorna nada, 2 si alguna de las variables
    //      es nula (Nombre o Ruta) o -1 si existe algun error en la secuancia SQL
    protected int AgregarArchivo() {
        Conecciones conDB = new Conecciones();
        int resultado;
        if (!"".equals(this.nombreArchivo) || !"".equals(this.rutaArchivo)) {
            String query = "INSERT INTO \"SysmanexSch1\".\"Archivo\"(\n"
                    + "\"ArchivoRuta\", \"ArchivoNombre\", \"ArchivoTamano\")\n"
                    + "   VALUES ('" + this.rutaArchivo + "', '" + this.nombreArchivo + "', " + this.tamanoArchivo + ");";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }
    
     protected static ResultSet BuscarArchivos() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Archivo\" ORDER BY \"ArchivoNombre\" ASC;";
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

