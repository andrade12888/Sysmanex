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
public class Motivo {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private int idMotivo;
    private String descripcionMotivo;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    /**
     * Get the value of idMotivo
     *
     * @return the value of idMotivo
     */
    public int getMotivoId() {
        return idMotivo;
    }

    /**
     * Set the value of idMotivo
     *
     * @param motivoId new value of idMotivo
     */
    public void setMotivoId(int motivoId) {
        this.idMotivo = motivoId;
    }  
    
    /**
     * Get the value of descripcionMotivo
     *
     * @return the value of descripcionMotivo
     */
    public String getMotivoDescripcion() {
        return descripcionMotivo;
    }

    /**
     * Set the value of descripcionMotivo
     *
     * @param motivoDescripcion new value of descripcionMotivo
     */
    public void setMotivoDescripcion(String motivoDescripcion) {
        this.descripcionMotivo = motivoDescripcion;
    }    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
     public Motivo(String descripcionMotivo) {
        this.descripcionMotivo = descripcionMotivo;
    }   
    //</editor-fold> 
}

