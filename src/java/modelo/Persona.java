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
    private String personaNombre;
    private String apellidoPersona;

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
     public Persona(String ciPersona,String nombrePerona, String apellidoPersona) {
        this.personaNombre=nombrePerona;
        this.ciPersona = ciPersona;
        this.apellidoPersona = apellidoPersona;
    }
      public Persona(String ciPersona, String apellidoPersona, String nombre, String contrasenia) {
        super(nombre, contrasenia);
        this.ciPersona = ciPersona;
        this.apellidoPersona = apellidoPersona;
    }    

     
    //</editor-fold>

    /**
     * @return the apellidoPersona
     */
    public String getApellidoPersona() {
        return apellidoPersona;
    }

    /**
     * @param apellidoPersona the apellidoPersona to set
     */
    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }
     
    /**
     * @return the personaNombre
     */
    public String getPersonaNombre() {
        return personaNombre;
    }

    /**
     * @param personaNombre the personaNombre to set
     */
    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }
    
}

