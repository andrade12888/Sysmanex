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
public class Persona extends Entidad {
       
    private String ciPersona;

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    /**
     * Get the value of ciPersona
     *
     * @return the value of ciPersona
     */
    public String getCiPersona() {
        return ciPersona;
    }

    /**
     * Set the value of ciPersona
     *
     * @param ciPersona new value of ciPersona
     */
    public void setCiPersona(String ciPersona) {
        this.ciPersona = ciPersona;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Persona(String ciPersona, String nombrePersona, String contrasenaPersona) 
            { super(nombrePersona,contrasenaPersona);
        this.ciPersona = ciPersona;
    }
    //</editor-fold>
    
}

