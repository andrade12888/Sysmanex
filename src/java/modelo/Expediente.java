/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import accesoaDatos.Conecciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nova
 */
public class Expediente {

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private String numeroExpediente;
    private String fechaExpediente;
    private String asuntoExpediente;
    private boolean expedientePublico;
    private Tramite tramiteExpediente;
    private Entidad entidadOrigien;
    private Estado estadoExpediente;
    private Motivo motivoExpediente;
    private ArrayList<String> listaArchivosExpediente;
    private ArrayList<Entidad> listaDestinariosExpediente;
    private boolean expedienteBaja;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    /**
     * Get the value of numeroExpediente
     *
     * @return the value of numeroExpediente
     */
    public String getNumeroExpediente() {
        return numeroExpediente;
    }

    /**
     * Set the value of numeroExpediente
     *
     * @param numeroExpediente new value of numeroExpediente
     */
    public void setNumeroExpediente(String numeroExpediente, int entidadId) {
        Calendar cal = Calendar.getInstance();
        int anio = cal.get(Calendar.YEAR);
        String idUnidad = String.format("%04d", entidadId);
        String numero = String.format("%05d", Integer.parseInt(numeroExpediente));

        this.numeroExpediente = String.valueOf(anio)+ idUnidad + numero;
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

    public Tramite getTramiteExpediente() {
        return tramiteExpediente;
    }

    public void setTramiteExpediente(Tramite TramiteExpediente) {
        this.tramiteExpediente = TramiteExpediente;
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

    /**
     * @return the expedienteBaja
     */
    public boolean isExpedienteBaja() {
        return expedienteBaja;
    }

    /**
     * @param expedienteBaja the expedienteBaja to set
     */
    public void setExpedienteBaja(boolean expedienteBaja) {
        this.expedienteBaja = expedienteBaja;
    }

    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Expediente(String asuntoExpediente, boolean expedientePublico, Tramite TramiteExpediente, Entidad entidadOrigien) {
        this.asuntoExpediente = asuntoExpediente;
        this.expedientePublico = expedientePublico;
        this.tramiteExpediente = TramiteExpediente;
        this.entidadOrigien = entidadOrigien;
        this.listaArchivosExpediente = new ArrayList<String>();
        this.listaDestinariosExpediente = new ArrayList<Entidad>();
    }

    public Expediente() {
        this.listaArchivosExpediente = new ArrayList<String>();
        this.listaDestinariosExpediente = new ArrayList<Entidad>();
    }

    public Expediente(String numeroExpediente, String fechaExpediente, String asuntoExpediente, boolean expedientePublico, Tramite TramiteExpediente, Entidad entidadOrigien, Estado estadoExpediente, Motivo motivoExpediente) {
        this.numeroExpediente = numeroExpediente;
        this.fechaExpediente = fechaExpediente;
        this.asuntoExpediente = asuntoExpediente;
        this.expedientePublico = expedientePublico;
        this.tramiteExpediente = TramiteExpediente;
        this.entidadOrigien = entidadOrigien;
        this.estadoExpediente = estadoExpediente;
        this.motivoExpediente = motivoExpediente;
        this.listaArchivosExpediente = new ArrayList<String>();
        this.listaDestinariosExpediente = new ArrayList<Entidad>();
    }

//</editor-fold>
    public int AgregarExpediente() {
        Conecciones conDB = new Conecciones();
        int resultado = -1;
        Connection conect = conDB.getConnect();
        ResultSet rs;
        PreparedStatement queryInsertExpediente;
        try {
            queryInsertExpediente = conect.prepareStatement("INSERT INTO \"SysmanexSch1\".\"Expediente\"("
                    + "\"expedienteNumero\", \"expedienteAsunto\", \"expedienteFecha\", "
                    + "\"expedientePublico\", \"expedienteTramiteId\", \"expedienteEstadoId\", "
                    + "\"expedienteBaja\", \"expedienteEntidadId\")"
                    + " VALUES (?, ?,CURRENT_DATE, '" + this.expedientePublico + "',"
                    + " '" + this.tramiteExpediente.getId() + "', '" + this.estadoExpediente.getIdEstado() + "',"
                    + " false," + this.entidadOrigien.getEntidadId() + ");", Statement.RETURN_GENERATED_KEYS);
            queryInsertExpediente.setString(1, this.numeroExpediente);
            queryInsertExpediente.setString(2, this.asuntoExpediente);
            queryInsertExpediente.executeUpdate();
            rs = queryInsertExpediente.getGeneratedKeys();

            while (rs.next()) {
                resultado = 1;
            }
            rs.close();

        } catch (SQLException ex) {
             System.out.println(ex.toString());
            Logger.getLogger(Expediente.class.getName()).log(Level.SEVERE, null, ex);
            resultado = 2;
        }
        return resultado;
    }

    public int AgregarArchivoExpediente(String url) {
        Conecciones conDB = new Conecciones();
        int resultado = -1;
        String query = "INSERT INTO \"SysmanexSch1\".\"Archivo\" VALUES ('" + this.getNumeroExpediente() + "','" + url + "');";
        try {
            resultado = conDB.hacerConsultaIUD(query);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
            Logger.getLogger(Expediente.class.getName()).log(Level.SEVERE, null, ex);
            resultado = 2;
        }
        return resultado;
    }

    public ResultSet BuscarExpedientePorNumero(String numeroExpediente) {
        Conecciones conDB = new Conecciones();
        
        ResultSet rs;
        String query = "SELECT ex.\"expedienteNumero\",tra.\"tramiteNombre\", ex.\"expedienteAsunto\",en.\"entidadNombre\", ex.\"expedienteFecha\",\n"
                + "mo.\"motivoDescripcion\"\n"
                + "FROM \"SysmanexSch1\".\"Expediente\" as ex, \"SysmanexSch1\".\"Tramite\" as tra, \"SysmanexSch1\".\"Entidad\" as en, \n"
                + "\"SysmanexSch1\".\"Motivo\" as mo, \"SysmanexSch1\".\"Estado\" as es\n"
                + "WHERE tra.\"tramiteId\" = ex.\"expedienteTramiteId\"\n"
                + "AND ex.\"expedienteMotivoId\" = mo.\"motivoId\"\n"
                + "AND ex.\"expedienteEstadoId\" = es.\"estadoId\"\n"
                + "AND ex.\"expedienteEntidadId\" = en.\"entidadId\"\n"
                + "AND ex.\"expedientePublico\" = true\n"
                + "AND ex.\"expedienteBaja\" = false\n" //le agrege esto xq todas las tablas que tengan baja logica deben consultar su estado antes de traer el resultado
                + "AND ex.\"expedienteNumero\" LIKE '%" + numeroExpediente + "%'";
        try {
            rs = conDB.hacerConsulta(query);
            return rs;
        } catch (SQLException ex) {
            return null;
        } 
    }
    
    public void traerExpediente(String numeroExpediente){
        try {
            ResultSet rs = BuscarExpedientePorNumero(numeroExpediente);
            while(rs.next()){
                Entidad originador = new Entidad();
                originador.buscarEntidadId(rs.getInt("expedienteEntidadId"));
                Estado unEstado = new Estado();
                unEstado.BuscarEstado(rs.getInt("expedienteEstadoId"));                
                
                this.setEntidadOrigien(originador);
                this.setNumeroExpediente(numeroExpediente, originador.getEntidadId());
                this.setAsuntoExpediente(rs.getString("expedienteAsunto"));
                this.setFechaExpediente(rs.getString("expedienteFecha"));
                this.setExpedientePublico(rs.getBoolean("expedientePublico"));
                this.setEstadoExpediente(unEstado);
                
            
            }   
        } catch (SQLException ex) {
            Logger.getLogger(Expediente.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    //le saque el like porque los destinos siempre van a ser traidos con el numero de expediente..
    // expediente tenia LIKE por las busquedas en ajax
    protected static ResultSet Destinos(String numeroExpediente) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String query = "select en.\"entidadNombre\", ee.\"ExpedienteEntidadFechaRecibido\"\n"
                + "from \"SysmanexSch1\".\"ExpedienteEntidad\" ee, \"SysmanexSch1\".\"Entidad\" en\n"
                + "WHERE ee.\"idEntidad\" = en.\"entidadId\"\n"
                + "AND ee.\"ExpedienteNumero\" = '" + numeroExpediente + "'";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    protected static int BorrarExpediente(String numeroExpediente) throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado;

        String query = "UPDATE \"SysmanexSch1\".\"Expediente\"\n"
                + "SET \"expedienteBaja\"=TRUE \n"
                + "WHERE \"expedienteNumero\"='" + numeroExpediente + "\';";
        resultado = conDB.hacerConsultaIUD(query);

        return resultado;
    }

}
