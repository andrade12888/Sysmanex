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
public class Empresa {
    
   //<editor-fold defaultstate="collapsed" desc="Properties">
    private String rutEmpresa;    
    private ArrayList<Persona> listaPersonasAutorizadas;
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
    //</editor-fold>    

   //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Empresa(String rutEmpresa, ArrayList<Persona> listaPersonasAutorizadas) {
        this.rutEmpresa = rutEmpresa;
        this.listaPersonasAutorizadas = listaPersonasAutorizadas;
    }
 
    //</editor-fold>
   
}

