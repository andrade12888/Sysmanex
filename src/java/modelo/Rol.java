/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import accesoaDatos.Conecciones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nova
 */
public class Rol {
    private int id;
    private String descripcion;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rol(String descripcion) {
        this.descripcion = descripcion;
    }

    public Rol() {
    }
        
    public String getRolDB(int rolId){
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String resultado = "";

        try {
            String query = "Select \"rolDescripcion\" FROM \"SysmanexSch1\".\"Rol\"\n"
                    + "WHERE \"rolId\" = " + rolId + ";";
            rs = conDB.hacerConsulta(query);
            while (rs.next()) {
                resultado = rs.getString("rolDescripcion");
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }
    
     public int AgregarRol() {
        Conecciones conDB = new Conecciones();
        int resultado;
        if (!"".equals(this.descripcion)) {
            String query = "INSERT INTO \"SysmanexSch1\".\"Rol\"(\n"
                    + "\"rolDescripcion\")" + " VALUES ('" + this.descripcion + "');";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }

    protected static int ModificarRol(int id, String descripcionRol) {
        Conecciones conDB = new Conecciones();
        int resultado;

        if (!"".equals(descripcionRol) || id>0) {
            String query = "UPDATE \"SysmanexSch1\".\"Rol\"\n"
                    + "	SET \"rolDescripcion\"=\'" + descripcionRol + "'\n"
                    + "	WHERE \"rolId\"=" + id + ";";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }

    
}
