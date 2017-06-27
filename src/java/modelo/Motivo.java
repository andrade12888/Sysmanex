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
public class Motivo {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private int idMotivo;
    private String descripcionMotivo;
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    /**
     * Get the value of idMotivo
     *
     * @return the value of idMotivo
     */
    public int getMotivoId() {
        return idMotivo;
    }

    /**
     * Set the value of idMotivo
     *
     * @param motivoId new value of idMotivo
     */
    public void setMotivoId(int motivoId) {
        this.idMotivo = motivoId;
    }  
    
    /**
     * Get the value of descripcionMotivo
     *
     * @return the value of descripcionMotivo
     */
    public String getMotivoDescripcion() {
        return descripcionMotivo;
    }

    /**
     * Set the value of descripcionMotivo
     *
     * @param motivoDescripcion new value of descripcionMotivo
     */
    public void setMotivoDescripcion(String motivoDescripcion) {
        this.descripcionMotivo = motivoDescripcion;
    }    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Constructores">
     public Motivo(String descripcionMotivo) {
        this.descripcionMotivo = descripcionMotivo;
    }   
      public Motivo() {
        
    }   
    //</editor-fold> 
     
    protected static String getMotivoDB(int motivoId){
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String resultado = "";

        try {
            String query = "Select \"motivoDescripcion\" FROM \"SysmanexSch1\".\"Motivo\"\n"
                    + "WHERE \"motivoId\" = " + motivoId + ";";
            rs = conDB.hacerConsulta(query);
            while (rs.next()) {
                resultado = rs.getString("motivoDescripcion");
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }
    
     public static ResultSet BuscarMotivos(){
        Conecciones conDB = new Conecciones();
        ResultSet rs = null;       

        try {
            String query = "Select * FROM \"SysmanexSch1\".\"Motivo\" ORDER BY \"motivoDescripcion\" ASC;";
            rs = conDB.hacerConsulta(query);                       

        } catch (Exception ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
    
     public int AgregarMotivo() throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado;
        if (!"".equals(this.descripcionMotivo)) {
            String query = "INSERT INTO \"SysmanexSch1\".\"Motivo\"(\n"
                    + "\"motivoDescripcion\")" + " VALUES ('" + this.descripcionMotivo + "');";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }        

  /*  protected static int ModificarMotivo(int idMotivo, String motivoDescripcion) {
        Conecciones conDB = new Conecciones();
        int resultado;

        if (!"".equals(motivoDescripcion) || idMotivo>0) {
            String query = "UPDATE \"SysmanexSch1\".\"Motivo\"\n"
                    + "	SET \"motivoDescripcion\"=\'" + motivoDescripcion + "'\n"
                    + "	WHERE \"motivoId\"=" + idMotivo + ";";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }*/

}

