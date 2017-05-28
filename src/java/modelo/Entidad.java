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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nova
 */
public class Entidad {

    private int id;
    private String nombreEntidad;
    private String contrasenia;
    private Rol rol;

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Entidad() {

    }

    public Entidad(String nombreEntidad, String contrasenia) {
        this.nombreEntidad = nombreEntidad;
        this.contrasenia = contrasenia;
    }

    public void Autenticar(String nombre, String pass) throws ClassNotFoundException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        Rol unRol = new Rol();

        try {
            Connection conect = conDB.getConnect();
            PreparedStatement query = conect.prepareStatement("Select \"entidadId\",\"entidadNombre\",\"rolId\" FROM \"SysmanexSch1\".\"Entidad\""
                    + " WHERE \"entidadNombre\" = ? AND \"entidadPassword\" = ?;");
            query.setString(1, nombre);
            query.setString(2, pass);
            
            rs = query.executeQuery();

            while (rs.next()) {
                unRol.setDescripcion(unRol.getRolDB(rs.getInt(3)));
                unRol.setId(rs.getInt(3));
                this.setRol(unRol);
                this.setId(rs.getInt("entidadId"));
                this.setContrasenia(pass);
                this.setNombreEntidad(rs.getString(2));
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
