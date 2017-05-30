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

    private int id;
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

    public int getId() {
        return id;
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

}
