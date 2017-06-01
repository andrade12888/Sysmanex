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
public class Entidad {

    private int entidadId;
    private String nombre;
    private String contrasenia;
    private Rol rol;

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getEntidadId() {
        return entidadId;
    }

    /**
     * @param entidadId the entidadId to set
     */
    public void setEntidadId(int entidadId) {
        this.entidadId = entidadId;
    }
    
    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    
    public Entidad() {
       
    }
    
    public Entidad(String nombre, String contrasenia) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }
     public Entidad(String nombre, String contrasenia, Rol rolEntidad) {
        this.nombre = nombre;
        this.contrasenia = contrasenia;
        this.rol=rolEntidad;
    }

    public int Autenticar(String userId, String password) throws ClassNotFoundException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        int resultado = 0;

        try {
            String query = "Select \"entidadId\",\"entidadNombre\",\"rolId\" FROM \"SysmanexSch1\".\"Entidad\"\n"
                    + "WHERE \"entidadNombre\" = '" + userId + "'\n AND\"entidadPassword\" = '" + password + "';";
            rs = conDB.hacerConsulta(query);
            while (rs.next()) {
                resultado = rs.getInt("rolId");
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    //PRE: El rol debe existir en la base de datos
     protected int AgregarEntidad() {
        Conecciones conDB = new Conecciones();
        int resultado;
        if (!"".equals(this.nombre) && !"".equals(this.contrasenia) && this.rol!=null) {
            String query = "INSERT INTO \"SysmanexSch1\".\"Entidad\"(\n"
                    + "\"entidadNombre\", \"entidadPassword\", \"rolId\")\n"
                    + "   VALUES ('" + this.nombre + "', '" + this.contrasenia + "', " + this.rol.getId() + ");";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }

     protected  int ModificarEntidad(String idEntidad) {
        Conecciones conDB = new Conecciones();
        int resultado;

          if (!"".equals(this.nombre) && !"".equals(this.contrasenia) && this.rol!=null) {
            String query = "UPDATE \"SysmanexSch1\".\"Entidad\"\n"
                    + "	SET \"entidadNombre\"=\'" + this.nombre + "\', \"entidadPassword\"='" + this.contrasenia +"',\"rolId\"=" + this.rol.getId() +"\n"
                    + "	WHERE \"entidadId\"=" + Integer.parseInt(idEntidad) + ";";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }

    public int BorrarEntidad(String id) {
        Conecciones conDB = new Conecciones();
        int resultado=0;
        //TODO

        return resultado;
    }       

    protected static ResultSet BuscarEntidad(String nombre) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Entidad\""
                + " WHERE \"entidadNombre\" LIKE \'%" + nombre + "\'"
                + " ORDER BY \"entidadNombre\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }
    
    protected static ResultSet BuscarEntidades() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Entidad\""               
                + " ORDER BY \"entidadNombre\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    

}
