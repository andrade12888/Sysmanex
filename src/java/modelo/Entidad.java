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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nova
 */
public class Entidad {

    private String nombreEntidad;
    private int entidadId;

    private String contrasenia;
    private Rol rol;
    private ArrayList<Expediente> misExpedientes;

    public ArrayList<Expediente> getMisExpedientes() {
        return misExpedientes;
    }

    public void setMisExpedientes(ArrayList<Expediente> misExpedientes) {
        this.misExpedientes = misExpedientes;
    }

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

    public Entidad(String nombreEntidad, String contrasenia) {
        this.nombreEntidad = nombreEntidad;
        this.contrasenia = contrasenia;
    }
     public Entidad(String nombre, String contrasenia, Rol rolEntidad) {
        this.nombreEntidad = nombre;
        this.contrasenia = contrasenia;
        this.rol=rolEntidad;
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
                this.setEntidadId(rs.getInt("entidadId"));
                this.setContrasenia(pass);
                this.setNombreEntidad(rs.getString(2));
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet ExpedientesDB() {
        Conecciones conDB = new Conecciones();
        ResultSet rs = null;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Expediente\""
                + " WHERE \"expedienteEntidadId\" = " + this.getEntidadId() + ""
                + " ORDER BY \"expedienteFecha\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    public String TablaExpedientes(ResultSet rs) throws SQLException {
        String tabla = "<form name=\"frmMisExpedientes\" action=\"documentos.do\" "
                + "method=\"POST\"><table class=\"table table-striped\"><th>"
                + "Numero</th><th>Asunto</th><th>Fecha</th><th>Tipo de Documento</th><th>Estado</th>";
        while (rs.next()) {
            tabla += "<tr><td><input type=\"hidden\" id=\"id" + rs.getInt("documentoId") + "\" value=\"" + rs.getInt("documentoId") + "\">"
                    + " <span id=\"tdd" + rs.getInt("documentoId") + "\">" + rs.getString("documentoNombre") + "</span></td>"
                    + "<td><span id=\"tdp" + rs.getInt("documentoId") + "\">" + rs.getInt("documentoPlazo") + "</span></td>"
                    + "<td><span id=\"tdp" + rs.getInt("documentoId") + "\">" + rs.getInt("documentoPlazo") + "</span></td>"
                    + "<td><span id=\"tdp" + rs.getInt("documentoId") + "\">" + rs.getInt("documentoPlazo") + "</span></td>"
                    + "<td><button onclick=\"modalDocumento(" + rs.getInt("documentoId") + ")\" id=\"" + rs.getInt("documentoId") + "\" "
                    + "type=\"button\" class=\"btn glyphicon glyphicon-pencil\" data-toggle=\"modal\" data-target=\"#myModal\">\n"
                    + "</button><button name=\"btnDocumento\" value=\"" + rs.getInt("documentoId") + "\" type=\"submit\" class=\"btn glyphicon glyphicon-trash\"></button></td>";
        }
        tabla += "</table></form>";

        return tabla;
    }

    public String TablaExpedientes() throws SQLException {

        ResultSet rs = this.ExpedientesDB();
        String tabla = "<form name=\"frmMisExpedientes\" action=\"documentos.do\" "
                + "method=\"POST\"><table class=\"table table-striped\"><th>"
                + "Numero</th><th>Asunto</th><th>Fecha</th><th>Tipo de Documento</th><th>Estado</th><th>Opciones</th>";
        while (rs.next()) {
            Tramite unDoc = new Tramite();
            unDoc.BuscarDocumento(rs.getInt("expedienteDocumentoId"));
            tabla += "<tr><td><input type=\"hidden\" id=\"id" + rs.getInt("expedienteNumero") + "\" value=\"" + rs.getInt("expedienteNumero") + "\">"
                    + " <span id=\"enum" + rs.getInt("expedienteNumero") + "\">" + rs.getInt("expedienteNumero") + "</span></td>"
                    + "<td><span id=\"easu" + rs.getString("expedienteAsunto") + "\">" + rs.getString("expedienteAsunto") + "</span></td>"
                    + "<td><span id=\"efec" + rs.getString("expedienteFecha") + "\">" + rs.getString("expedienteFecha") + "</span></td>"
                    + "<td><span id=\"edoc" + unDoc.getId() + "\">" + unDoc.getNombre() + "</span></td>"
                    + "<td><span id=\"eest" + rs.getInt("expedienteEstadoId") + "\">" + rs.getInt("expedienteEstadoId") + "</span></td>"
                    + "<td><button onclick=\"modalDocumento(" + rs.getInt("expedienteNumero") + ")\" id=\"" + rs.getInt("expedienteNumero") + "\" "
                    + "type=\"button\" class=\"btn glyphicon glyphicon-send\" data-toggle=\"modal\" data-target=\"#myModal\">\n"
                    + "</button><button name=\"btnDocumento\" value=\"" + rs.getInt("expedienteNumero") + "\" type=\"submit\" class=\"btn glyphicon glyphicon-trash\"></button></td>";
        }
        tabla += "</table></form>";

        return tabla;
    }

    //PRE: El rol debe existir en la base de datos
    protected int AgregarEntidad() {
        Conecciones conDB = new Conecciones();
        int resultado;
        if (!"".equals(this.nombreEntidad) && !"".equals(this.contrasenia) && this.rol != null) {
            String query = "INSERT INTO \"SysmanexSch1\".\"Entidad\"(\n"
                    + "\"entidadNombre\", \"entidadPassword\", \"rolId\")\n"
                    + "   VALUES ('" + this.nombreEntidad + "', '" + this.contrasenia + "', " + this.rol.getId() + ");";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }

    protected int ModificarEntidad(String idEntidad) {
        Conecciones conDB = new Conecciones();
        int resultado;

        if (!"".equals(this.nombreEntidad) && !"".equals(this.contrasenia) && this.rol != null) {
            String query = "UPDATE \"SysmanexSch1\".\"Entidad\"\n"
                    + "	SET \"entidadNombre\"=\'" + this.nombreEntidad + "\', \"entidadPassword\"='" + this.contrasenia +"',\"rolId\"=" + this.rol.getId() +"\n"       
                    + "	WHERE \"entidadId\"=" + Integer.parseInt(idEntidad) + ";";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }

    public int BorrarEntidad(String id) {
        Conecciones conDB = new Conecciones();
        int resultado = 0;
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
