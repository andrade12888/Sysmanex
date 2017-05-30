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
    private Documento documentoExpediente;
    private Entidad entidadOrigien;    
    private Estado estadoExpediente;
    private Motivo motivoExpediente;
    private ArrayList<String> listaArchivosExpediente;
    private ArrayList<Entidad> listaDestinariosExpediente;
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

    public Documento getDocumentoExpediente() {
        return documentoExpediente;
    }

    public void setDocumentoExpediente(Documento documentoExpediente) {
        this.documentoExpediente = documentoExpediente;
    }

    public ArrayList<String> getListaArchivosExpediente() {
        return listaArchivosExpediente;
    }

    public void setListaArchivosExpediente(ArrayList<String> listaArchivosExpediente) {
        this.listaArchivosExpediente = listaArchivosExpediente;
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
   
     //</editor-fold>

    public Expediente(String asuntoExpediente, boolean expedientePublico, Documento documentoExpediente, Entidad entidadOrigien) {
        this.asuntoExpediente = asuntoExpediente;
        this.expedientePublico = expedientePublico;
        this.documentoExpediente = documentoExpediente;
        this.entidadOrigien = entidadOrigien;
    }
    
   
    
}

