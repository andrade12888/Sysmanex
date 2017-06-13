/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import accesoaDatos.Conecciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nova
 */
public class Expediente {

    //<editor-fold defaultstate="collapsed" desc="Properties">
    public Expediente(String numeroExpediente, String fechaExpediente, String asuntoExpediente, boolean expedientePublico, Tramite documentoExpediente, Entidad entidadOrigien, Estado estadoExpediente, Motivo motivoExpediente) {
        this.numeroExpediente = numeroExpediente;
        this.fechaExpediente = fechaExpediente;
        this.asuntoExpediente = asuntoExpediente;
        this.expedientePublico = expedientePublico;
        this.documentoExpediente = documentoExpediente;
        this.entidadOrigien = entidadOrigien;
        this.estadoExpediente = estadoExpediente;
        this.motivoExpediente = motivoExpediente;
    }
    private String numeroExpediente;
    private String fechaExpediente;
    private String asuntoExpediente;
    private boolean expedientePublico;
    private Tramite documentoExpediente;
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
    public void setNumeroExpediente(String numeroExpediente) {
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

    public Tramite getDocumentoExpediente() {
        return documentoExpediente;
    }

    public void setDocumentoExpediente(Tramite documentoExpediente) {
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
    public Expediente(String asuntoExpediente, boolean expedientePublico, Tramite documentoExpediente, Entidad entidadOrigien) {
        this.asuntoExpediente = asuntoExpediente;
        this.expedientePublico = expedientePublico;
        this.documentoExpediente = documentoExpediente;
        this.entidadOrigien = entidadOrigien;
    }
    //</editor-fold>

    protected int AgregarExpediente() {
        Conecciones conDB = new Conecciones();
        int resultado = -1;
        String queryInsertArchivoExpediente;
        String returnIdString = "') RETURNING \"idExpediente\" ;";
        String queryInsertExpediente = "INSERT INTO \"SysmanexSch1\".\"Expediente\"(\n"
                + "\"expedienteNumero\", \"expedienteAsunto\", \"expedienteFecha\", "
                + "\"expedientePublico\", \"expedienteDocumentoId\", \"expedienteEstadoId\", "
                + "\"expedienteBaja\", \"expedienteMotivoId\", \"expedienteEntidadId\")\n"
                + "   VALUES ('" + this.getNumeroExpediente() + "', '" + this.asuntoExpediente + "',"
                + " '" + this.fechaExpediente + "', '" + this.expedientePublico + "', "
                + "'" + this.documentoExpediente.getId() + "', '" + this.estadoExpediente.getIdEstado() + "',"
                + " '" + this.expedienteBaja + "', '" + this.motivoExpediente.getMotivoId() + "',"
                + " '" + this.entidadOrigien.getEntidadId() + "' );";

        if (!"".equals(this.asuntoExpediente)
                && this.estadoExpediente != null
                && !"".equals(this.numeroExpediente)
                && this.getListaArchivosExpediente() != null) {
            queryInsertExpediente = "INSERT INTO \"SysmanexSch1\".\"Expediente\"(\n"
                    + "\"expedienteNumero\", \"expedienteAsunto\", \"expedienteFecha\", "
                    + "\"expedientePublico\", \"expedienteDocumentoId\", \"expedienteEstadoId\", "
                    + "\"expedienteBaja\", \"expedienteMotivoId\", \"expedienteEntidadId\")\n"
                    + "   VALUES ('" + this.getNumeroExpediente() + "', '" + this.asuntoExpediente + "',"
                    + " '" + this.fechaExpediente + "', '" + this.expedientePublico + "', "
                    + "'" + this.documentoExpediente.getId() + "', '" + this.estadoExpediente.getIdEstado() + "',"
                    + " '" + this.expedienteBaja + "', '" + this.motivoExpediente.getMotivoId() + "',"
                    + " '" + this.entidadOrigien.getEntidadId() + returnIdString;

            try {
                conDB.getConnect().setAutoCommit(false);
                ResultSet rs = conDB.hacerConsulta(queryInsertExpediente);
                rs.next();
                int idExpediente = rs.getInt(1);

                for (String a : this.listaArchivosExpediente) {

                    queryInsertArchivoExpediente = "INSERT INTO \"SysmanexSch1\".\"ExpedienteArchivo\"(\n"
                            + "\"ExpedienteId\", \"ArchivoURL\")\n"
                            + " VALUES ('" + idExpediente + "', '" + a + "');";
                    conDB.hacerConsultaIUD(queryInsertArchivoExpediente);
                }

                conDB.getConnect().commit();
                resultado = 1;

            } catch (SQLException e) {

                if (conDB.getConnect() != null) {
                    try {
                        System.err.print("Ocurrio un error ingresando el expediente");
                        conDB.getConnect().rollback();
                        return -1;
                    } catch (SQLException excep) {
                        return -1;
                    }
                }

            } finally {
                if (conDB.getConnect() != null) {
                    try {
                        conDB.getConnect().setAutoCommit(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } else if (!"".equals(this.asuntoExpediente)
                && this.estadoExpediente != null
                && !"".equals(this.numeroExpediente)) {
            try {
                resultado = conDB.hacerConsultaIUD(queryInsertExpediente);
            } catch (SQLException ex) {
                Logger.getLogger(Expediente.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.err.print("Asunto, Motivo no pueden ser vacio.\n");
            resultado = 2;
        }
        return resultado;
    }

    //TODO: Definir los resultados de la busqueda
    protected static ResultSet BuscarExpedientes() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String query = "SELECT * FROM \"SysmanexSch1\".\"Expediente\" ORDER BY \"expedienteNumero\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    protected static ResultSet BuscarExpedientePorNumero(String numeroExpediente) throws SQLException {
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
                + "AND ex.\"expedienteNumero\" LIKE '%" + numeroExpediente + "%'";
        rs = conDB.hacerConsulta(query);

        return rs;
    }
    
    protected static ResultSet Destinos(String numeroExpediente) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String query = "select en.\"entidadNombre\", ee.\"ExpedienteEntidadFechaRecibido\"\n" +
"from \"SysmanexSch1\".\"ExpedienteEntidad\" ee, \"SysmanexSch1\".\"Entidad\" en\n" +
"WHERE ee.\"idEntidad\" = en.\"entidadId\"\n" +
"AND ee.\"ExpedienteNumero\" LIKE '%" + numeroExpediente + "%'";
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
