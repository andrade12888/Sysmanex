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
public class Estado {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private int idEstado;
    private String descripcionEstado;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    /**
     * Get the value of idEstado
     *
     * @return the value of idEstado
     */
    public int getIdEstado() {
        return idEstado;
    }

    /**
     * Set the value of idEstado
     *
     * @param idEstado new value of idEstado
     */
    public void setIdEstado(int idEstado) {
        this.idEstado = idEstado;
    }   

    /**
     * Get the value of descripcionEstado
     *
     * @return the value of descripcionEstado
     */
    public String getDescripcionEstado() {
        return descripcionEstado;
    }

    /**
     * Set the value of descripcionEstado
     *
     * @param descripcionEstado new value of descripcionEstado
     */
    public void setDescripcionEstado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Estado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
    }
    //</editor-fold>
    
}
