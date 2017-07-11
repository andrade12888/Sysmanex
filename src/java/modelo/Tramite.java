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
 * @author andra
 */
public class Tramite {

    private int id;
    private String nombre;
    private int plazo;
    private boolean baja;

    public Tramite() {
    }

    public Tramite(String nombre, int plazo) {
        this.nombre = nombre;
        this.plazo = plazo;
        this.baja = false;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPlazo() {
        return plazo;
    }

    public void setPlazo(int plazo) {
        this.plazo = plazo;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public int AgregarTramite() {
        Conecciones conDB = new Conecciones();
        int resultado;
        if (!"".equals(this.nombre) && this.plazo >= 0) {
            String query = "INSERT INTO \"SysmanexSch1\".\"Tramite\"(\n"
                    + "\"tramiteNombre\", \"tramitePlazo\", \"tramiteBaja\")\n"
                    + "   VALUES ('" + this.nombre + "', '" + this.plazo + "', " + this.baja + ");";
            try {
                resultado = conDB.hacerConsultaIUD(query);
            } catch (SQLException ex) {
                resultado = -1;
                Logger.getLogger(Tramite.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resultado = 2;
        }

        return resultado;
    }

    public int ModificarTramite(String id) {
        Conecciones conDB = new Conecciones();
        int resultado;

        if (!"".equals(this.nombre) && this.plazo >= 0) {
            String query = "UPDATE \"SysmanexSch1\".\"Tramite\"\n"
                    + "	SET \"tramiteNombre\"=\'" + nombre + "\', \"tramitePlazo\"=" + plazo + "\n"
                    + "	WHERE \"tramiteId\"=" + Integer.parseInt(id) + ";";
            try {
                resultado = conDB.hacerConsultaIUD(query);
            } catch (SQLException ex) {
                resultado = -1;
                Logger.getLogger(Tramite.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            resultado = 2;
        }

        return resultado;
    }

    public static int BorrarTramite(String id) {
        Conecciones conDB = new Conecciones();
        int resultado;

        String query = "UPDATE \"SysmanexSch1\".\"Tramite\"\n"
                + "	SET \"tramiteBaja\"=\'true'"
                + "	WHERE \"tramiteId\"=" + id + ";";
        try {
            resultado = conDB.hacerConsultaIUD(query);
        } catch (SQLException ex) {
            resultado = -1;
            Logger.getLogger(Tramite.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }

    public String BuscarTramite(String nombre) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Tramite\""
                + " WHERE \"tramiteId\" LIKE \'%" + nombre + "\'"
                + " ORDER BY \"tramiteId\" ASC;";
        rs = conDB.hacerConsulta(query);

        return this.TablaTramites(rs);
    }

    public void BuscarTramite(int id) {
        Conecciones conDB = new Conecciones();
        ResultSet rs = null;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Tramite\""
                + "WHERE \"tramiteBaja\"=\'false\' AND \"tramiteId\"=" + id
                + " ORDER BY \"tramiteId\" ASC;";
        try {
            rs = conDB.hacerConsulta(query);
            try {
                while (rs.next()) {
                    this.setId(id);
                    this.setNombre(rs.getString("tramiteNombre"));
                    this.setPlazo(rs.getInt("tramitePlazo"));
                    this.setBaja(rs.getBoolean("tramiteBaja"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(Tramite.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Tramite.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static ResultSet tramitesDB() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Tramite\""
                + "WHERE \"tramiteBaja\"=\'false\' ORDER BY \"tramiteId\" ASC;";
        rs = conDB.hacerConsulta(query);
        return rs;
    }

    public String TablaTramites(ResultSet rs) throws SQLException {
        String tabla = "<form name=\"frmBorrar\" action=\"tramites.do\" method=\"POST\"><table class=\"table table-striped\"><th>Tramites</th><th>Plazo en dias</th><th>Opciones</th>";
        while (rs.next()) {
            tabla += "<tr><td><input type=\"hidden\" id=\"id" + rs.getInt("tramiteId") + "\" value=\"" + rs.getInt("tramiteId") + "\">"
                    + " <span id=\"tdd" + rs.getInt("tramiteId") + "\">" + rs.getString("tramiteNombre") + "</span></td>"
                    + "<td><span id=\"tdp" + rs.getInt("tramiteId") + "\">" + rs.getInt("tramitePlazo") + "</span></td>"
                    + "<td><button onclick=\"modalTramite(" + rs.getInt("tramiteId") + ")\" id=\"" + rs.getInt("tramiteId") + "\" "
                    + "type=\"button\" class=\"btn glyphicon glyphicon-pencil\" data-toggle=\"modal\" data-target=\"#myModal\">\n"
                    + "</button><button name=\"btnTramite\" value=\"" + rs.getInt("tramiteId") + "\" type=\"submit\" class=\"btn glyphicon glyphicon-trash\"></button></td>";
        }
        tabla += "</table></form>";

        return tabla;
    }

    public String TablaTramites() throws SQLException {

        ResultSet rs = this.tramitesDB();
        String tabla = "<form name=\"frmBorrar\" action=\"tramites.do\" method=\"POST\"><table class=\"table table-striped\"><th>Tramites</th><th>Plazo en dias</th><th>Opciones</th>";
        while (rs.next()) {
            tabla += "<tr><td><input type=\"hidden\" id=\"id" + rs.getInt("tramiteId") + "\" value=\"" + rs.getInt("tramiteId") + "\">"
                    + " <span id=\"tdd" + rs.getInt("tramiteId") + "\">" + rs.getString("tramiteNombre") + "</span></td>"
                    + "<td><span id=\"tdp" + rs.getInt("tramiteId") + "\">" + rs.getInt("tramitePlazo") + "</span></td>"
                    + "<td><button onclick=\"modalTramite(" + rs.getInt("tramiteId") + ")\" id=\"" + rs.getInt("tramiteId") + "\" "
                    + "type=\"button\" class=\"btn glyphicon glyphicon-pencil\" data-toggle=\"modal\" data-target=\"#myModal\">\n"
                    + "</button><button name=\"btnTramite\" value=\"" + rs.getInt("tramiteId") + "\" type=\"submit\" name=\" \"class=\"btn glyphicon glyphicon-trash\"></button></td>";
        }
        tabla += "</table></form>";

        return tabla;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

}
