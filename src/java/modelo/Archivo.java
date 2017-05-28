/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Nova
 */
public class Archivo {
    
   // <editor-fold defaultstate="collapsed" desc="Properties">
    
    private int idArchivo;
    private String nombreArchivo;
    private byte tamanoArchivo;    
    
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
    public byte getTamanoArchivo() {
        return tamanoArchivo;
    }

    /**
     * Set the value of tamanoArchivo
     *
     * @param tamanoArchivo new value of tamanoArchivo
     */
    public void setTamanoArchivo(byte tamanoArchivo) {
        this.tamanoArchivo = tamanoArchivo;
    }

    //</editor-fold>
   
   //<editor-fold defaultstate="collapsed" desc="Constructor">
    public Archivo(String nombreArchivo, byte tamanoArchivo) {
        this.nombreArchivo = nombreArchivo;
        this.tamanoArchivo = tamanoArchivo;
    }
   //</editor-fold>
    
    
}

