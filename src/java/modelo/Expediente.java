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
public class Expediente {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private int numeroExpediente;
    private String fechaExpediente;
    private String asuntoExpediente;
    private boolean expedientePublico;
    private ArrayList<Entidad> listaDestinariosExpediente;
    private Entidad entidadOrigien;    
    private Entidad entidadDestino;
    private Estado estadoExpediente;
    private Motivo motivoExpediente;
    private ArrayList<Documento> listaDocumentosExpediente;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    /**
     * Get the value of numeroExpediente
     *
     * @return the value of numeroExpediente
     */
    public int getNumeroExpediente() {
        return numeroExpediente;
    }

    /**
     * Set the value of numeroExpediente
     *
     * @param numeroExpediente new value of numeroExpediente
     */
    public void setNumeroExpediente(int numeroExpediente) {
        this.numeroExpediente = numeroExpediente;
    }

    /**
     * Get the value of fechaExpediente
     *
     * @return the value of fechaExpediente
     */
    public String getFechaExpediente() {
        return fechaExpediente;
    }

    /**
     * Set the value of fechaExpediente
     *
     * @param fechaExpediente new value of fechaExpediente
     */
    public void setFechaExpediente(String fechaExpediente) {
        this.fechaExpediente = fechaExpediente;
    }    

    /**
     * Get the value of asuntoExpediente
     *
     * @return the value of asuntoExpediente
     */
    public String getAsuntoExpediente() {
        return asuntoExpediente;
    }

    /**
     * Set the value of asuntoExpediente
     *
     * @param asuntoExpediente new value of asuntoExpediente
     */
    public void setAsuntoExpediente(String asuntoExpediente) {
        this.asuntoExpediente = asuntoExpediente;
    }

    /**
     * Get the value of expedientePublico
     *
     * @return the value of expedientePublico
     */
    public boolean isExpedientePublico() {
        return expedientePublico;
    }

    /**
     * Set the value of expedientePublico
     *
     * @param expedientePublico new value of expedientePublico
     */
    public void setExpedientePublico(boolean expedientePublico) {
        this.expedientePublico = expedientePublico;
    }   
    
    public ArrayList<Entidad> getListaDestinariosExpediente() {
        return listaDestinariosExpediente;
    }

    public void setListaDestinariosExpediente(ArrayList<Entidad> listaDestinariosExpediente) {
        this.listaDestinariosExpediente = listaDestinariosExpediente;
    }

    /**
     * Get the value of entidadOrigien
     *
     * @return the value of entidadOrigien
     */
    public Entidad getEntidadOrigien() {
        return entidadOrigien;
    }

    /**
     * Set the value of entidadOrigien
     *
     * @param entidadOrigien new value of entidadOrigien
     */
    public void setEntidadOrigien(Entidad entidadOrigien) {
        this.entidadOrigien = entidadOrigien;
    }

    /**
     * Get the value of entidadDestino
     *
     * @return the value of entidadDestino
     */
    public Entidad getEntidadDestino() {
        return entidadDestino;
    }

    /**
     * Set the value of entidadDestino
     *
     * @param entidadDestino new value of entidadDestino
     */
    public void setEntidadDestino(Entidad entidadDestino) {
        this.entidadDestino = entidadDestino;
    }        
    
    public ArrayList<Documento> getListaDocumentosExpediente() {
        return listaDocumentosExpediente;
    }
    
    public void setListaDocumentosExpediente(ArrayList<Documento> listaDocumentosExpediente) {
        this.listaDocumentosExpediente = listaDocumentosExpediente;
    }           

    /**
     * Get the value of estadoExpediente
     *
     * @return the value of estadoExpediente
     */
    public Estado getEstadoExpediente() {
        return estadoExpediente;
    }

    /**
     * Set the value of estadoExpediente
     *
     * @param estadoExpediente new value of estadoExpediente
     */
    public void setEstadoExpediente(Estado estadoExpediente) {
        this.estadoExpediente = estadoExpediente;
    }       

    /**
     * Get the value of motivoExpediente
     *
     * @return the value of motivoExpediente
     */
    public Motivo getMotivoExpediente() {
        return motivoExpediente;
    }

    /**
     * Set the value of motivoExpediente
     *
     * @param motivoExpediente new value of motivoExpediente
     */
    public void setMotivoExpediente(Motivo motivoExpediente) {
        this.motivoExpediente = motivoExpediente;
    }
    //</editor-fold>
     
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Expediente(String fechaExpediente, String asuntoExpediente, boolean expedientePublico, ArrayList<Entidad> listaDestinariosExpediente, Entidad entidadOrigien, Entidad entidadDestino, Estado estadoExpediente, Motivo motivoExpediente, ArrayList<Documento> listaDocumentosExpediente) {
        this.fechaExpediente = fechaExpediente;
        this.asuntoExpediente = asuntoExpediente;
        this.expedientePublico = expedientePublico;
        this.listaDestinariosExpediente = listaDestinariosExpediente;
        this.entidadOrigien = entidadOrigien;
        this.entidadDestino = entidadDestino;
        this.estadoExpediente = estadoExpediente;
        this.motivoExpediente = motivoExpediente;
        this.listaDocumentosExpediente = listaDocumentosExpediente;
    }

    public Expediente(String fechaExpediente, String asuntoExpediente, boolean expedientePublico, Entidad entidadOrigien, Estado estadoExpediente, Motivo motivoExpediente) {
        this.fechaExpediente = fechaExpediente;
        this.asuntoExpediente = asuntoExpediente;
        this.expedientePublico = expedientePublico;
        this.entidadOrigien = entidadOrigien;
        this.estadoExpediente = estadoExpediente;
        this.motivoExpediente = motivoExpediente;
    }

    public Expediente(String fechaExpediente, String asuntoExpediente, boolean expedientePublico, ArrayList<Entidad> listaDestinariosExpediente, Entidad entidadOrigien) {
        this.fechaExpediente = fechaExpediente;
        this.asuntoExpediente = asuntoExpediente;
        this.expedientePublico = expedientePublico;
        this.listaDestinariosExpediente = listaDestinariosExpediente;
        this.entidadOrigien = entidadOrigien;
    }
     //</editor-fold>
    
}

