/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Nova
 */
public class UnidadArmada extends Entidad {
    private ArrayList<Persona> personas;
    private String sigla;

    /**
     * @return the personas
     */
    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    /**
     * @param personas the personas to set
     */
    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public UnidadArmada(ArrayList<Persona> personas, String sigla) {
        this.personas = personas;
        this.sigla = sigla;
    }

    public UnidadArmada(ArrayList<Persona> personas, String sigla, String nombre, String contrasenia) {
        super(nombre, contrasenia);
        this.personas = personas;
        this.sigla = sigla;
    }
    
    
}
