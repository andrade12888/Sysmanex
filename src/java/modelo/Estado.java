/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import accesoaDatos.Conecciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nova
 */
public class Estado {

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private int idEstado;
    private String descripcionEstado;
    private boolean estadoBaja;
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

    /**
     * @return the estadoBaja
     */
    public boolean isEstadoBaja() {
        return estadoBaja;
    }

    /**
     * @param estadoBaja the estadoBaja to set
     */
    public void setEstadoBaja(boolean estadoBaja) {
        this.estadoBaja = estadoBaja;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Estado(String descripcionEstado) {
        this.descripcionEstado = descripcionEstado;
        this.estadoBaja = false;
    }

    public Estado() {

    }
    //</editor-fold>

    protected static String getEstadoDB(int estadoId) {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String resultado = "";

        try {
            String query = "Select \"estadoDescripcion\" FROM \"SysmanexSch1\".\"Estado\"\n"
                    + "WHERE \"estadoId\" = " + estadoId + ";";
            rs = conDB.hacerConsulta(query);
            while (rs.next()) {
                resultado = rs.getString("estadoDescripcion");
            }

            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    protected int AgregarEstado() throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado;
        if (!"".equals(this.descripcionEstado)) {
            String query = "INSERT INTO \"SysmanexSch1\".\"Estado\"(\n"
                    + "\"estadoDescripcion\",\"estadoBaja\")" + " VALUES ('" + this.descripcionEstado + "',  '" + this.estadoBaja + "');";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }

    protected static int ModificarEstado(int idEstadi, String descripcionEstado, boolean nuevoEstadoBaja) throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado;

        if (!"".equals(descripcionEstado) || idEstadi > 0) {
            String query = "UPDATE \"SysmanexSch1\".\"Estado\"\n"
                    + "	SET \"estadoDescripcion\"=\'" + descripcionEstado + "'\n"
                    + "	 \"estadoBaja\"=\'" + nuevoEstadoBaja + "'\n"
                    + "	WHERE \"estadoId\"=" + idEstadi + ";";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }

    protected static ResultSet BuscarEstados() {
        Conecciones conDB = new Conecciones();
        ResultSet rs = null;

        try {
            String query = "Select * FROM \"SysmanexSch1\".\"Estado\" ORDER BY \"estadoDescripcion\" ASC;";
            rs = conDB.hacerConsulta(query);

        } catch (Exception ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    public void BuscarEstado(int id) {
        Conecciones conDB = new Conecciones();
        ResultSet rs = null;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Estado\""
                + "WHERE \"estadoBaja\"=\'false\' AND \"estadoId\"=" + id + ";";
        try {
            rs = conDB.hacerConsulta(query);
            try {
                while (rs.next()) {                   
                    this.setIdEstado(id);
                    this.setDescripcionEstado(rs.getString("estadoDescripcion"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Estado.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Estado.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
