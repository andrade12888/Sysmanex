/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import accesoaDatos.Conecciones;
import java.sql.ResultSet;
import java.sql.SQLException;

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

    public int AgregarDocumento() {
        Conecciones conDB = new Conecciones();
        int resultado;
        if (!"".equals(this.nombre) && this.plazo>=0) {
            String query = "INSERT INTO \"SysmanexSch1\".\"Documento\"(\n"
                    + "\"documentoNombre\", \"documentoPlazo\", \"documentoBaja\")\n"
                    + "   VALUES ('" + this.nombre + "', '" + this.plazo + "', " + this.baja + ");";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }

    public int ModificarDocumento(String id) {
        Conecciones conDB = new Conecciones();
        int resultado;

        if (!"".equals(this.nombre) && this.plazo>=0) {
            String query = "UPDATE \"SysmanexSch1\".\"Documento\"\n"
                    + "	SET \"documentoNombre\"=\'" + nombre + "\', \"documentoPlazo\"=" + plazo + "\n"
                    + "	WHERE \"documentoId\"=" + Integer.parseInt(id) + ";";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }

    public int BorrarDocumento(String id) {
        Conecciones conDB = new Conecciones();
        int resultado;

        String query = "UPDATE \"SysmanexSch1\".\"Documento\"\n"
                + "	SET \"documentoBaja\"=\'true'"
                + "	WHERE \"documentoId\"=" + Integer.parseInt(id) + ";";
        resultado = conDB.hacerConsultaIUD(query);

        return resultado;
    }

    public String BuscarDocumento(String nombre) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Documento\""
                + " WHERE \"documentoId\" LIKE \'%" + nombre + "\'"
                + " ORDER BY \"documentoId\" ASC;";
        rs = conDB.hacerConsulta(query);

        return this.TablaDocumentos(rs);
    }

    public void BuscarDocumento(int id) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs = null;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Documento\""
                + "WHERE \"documentoBaja\"=\'false\' AND \"documentoId\"="+id
        + " ORDER BY \"documentoId\" ASC;";
        rs = conDB.hacerConsulta(query);
        while(rs.next()){
            this.id = id;
            this.setNombre(rs.getString("documentoNombre"));
            this.setPlazo(rs.getInt("documentoPlazo"));
            this.setBaja(rs.getBoolean("documentoBaja"));
        }
    }

    private ResultSet documentosDB() {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Documento\""
                + "WHERE \"documentoBaja\"=\'false\' ORDER BY \"documentoId\" ASC;";
        rs = conDB.hacerConsulta(query);
        return rs;
    }

    public String TablaDocumentos(ResultSet rs) throws SQLException {
        String tabla = "<form name=\"frmBorrar\" action=\"documentos.do\" method=\"POST\"><table class=\"table table-striped\"><th>Documentos</th><th>Plazo en dias</th><th>Opciones</th>";
        while (rs.next()) {
            tabla += "<tr><td><input type=\"hidden\" id=\"id" + rs.getInt("documentoId") + "\" value=\"" + rs.getInt("documentoId") + "\">"
                    + " <span id=\"tdd" + rs.getInt("documentoId") + "\">" + rs.getString("documentoNombre") + "</span></td>"
                    + "<td><span id=\"tdp" + rs.getInt("documentoId") + "\">" + rs.getInt("documentoPlazo") + "</span></td>"
                    + "<td><button onclick=\"modalDocumento(" + rs.getInt("documentoId") + ")\" id=\"" + rs.getInt("documentoId") + "\" "
                    + "type=\"button\" class=\"btn glyphicon glyphicon-pencil\" data-toggle=\"modal\" data-target=\"#myModal\">\n"
                    + "</button><button name=\"btnDocumento\" value=\"" + rs.getInt("documentoId") + "\" type=\"submit\" class=\"btn glyphicon glyphicon-trash\"></button></td>";
        }
        tabla += "</table></form>";

        return tabla;
    }

    public String TablaDocumentos() throws SQLException {

        ResultSet rs = this.documentosDB();
        String tabla = "<form name=\"frmBorrar\" action=\"documentos.do\" method=\"POST\"><table class=\"table table-striped\"><th>Documentos</th><th>Plazo en dias</th><th>Opciones</th>";
        while (rs.next()) {
            tabla += "<tr><td><input type=\"hidden\" id=\"id" + rs.getInt("documentoId") + "\" value=\"" + rs.getInt("documentoId") + "\">"
                    + " <span id=\"tdd" + rs.getInt("documentoId") + "\">" + rs.getString("documentoNombre") + "</span></td>"
                    + "<td><span id=\"tdp" + rs.getInt("documentoId") + "\">" + rs.getInt("documentoPlazo") + "</span></td>"
                    + "<td><button onclick=\"modalDocumento(" + rs.getInt("documentoId") + ")\" id=\"" + rs.getInt("documentoId") + "\" "
                    + "type=\"button\" class=\"btn glyphicon glyphicon-pencil\" data-toggle=\"modal\" data-target=\"#myModal\">\n"
                    + "</button><button name=\"btnDocumento\" value=\"" + rs.getInt("documentoId") + "\" type=\"submit\" class=\"btn glyphicon glyphicon-trash\"></button></td>";
        }
        tabla += "</table></form>";

        return tabla;
    }

}
