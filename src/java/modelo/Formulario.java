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
 * @author SG0891660
 */
public class Formulario {
    
        private String nombreFormulario;

    /**
     * Get the value of nombreFormulario
     *
     * @return the value of nombreFormulario
     */
    public String getNombreFormulario() {
        return nombreFormulario;
    }

    /**
     * Set the value of nombreFormulario
     *
     * @param nombreFormulario new value of nombreFormulario
     */
    public void setNombreFormulario(String nombreFormulario) {
        this.nombreFormulario = nombreFormulario;
    }

    private String rutaRormulario;

    /**
     * Get the value of rutaRormulario
     *
     * @return the value of rutaRormulario
     */
    public String getRutaRormulario() {
        return rutaRormulario;
    }

    /**
     * Set the value of rutaRormulario
     *
     * @param rutaRormulario new value of rutaRormulario
     */
    public void setRutaRormulario(String rutaRormulario) {
        this.rutaRormulario = rutaRormulario;
    }

    private String fechaCreacionFormulario;

    /**
     * Get the value of fechaCreacionFormulario
     *
     * @return the value of fechaCreacionFormulario
     */
    public String getFechaCreacionFormulario() {
        return fechaCreacionFormulario;
    }

    /**
     * Set the value of fechaCreacionFormulario
     *
     * @param fechaCreacionFormulario new value of fechaCreacionFormulario
     */
    public void setFechaCreacionFormulario(String fechaCreacionFormulario) {
        this.fechaCreacionFormulario = fechaCreacionFormulario;
    }

    private Persona creadorFormulario;

    /**
     * Get the value of creadorFormulario
     *
     * @return the value of creadorFormulario
     */
    public Persona getCreadorFormulario() {
        return creadorFormulario;
    }

    /**
     * Set the value of creadorFormulario
     *
     * @param creadorFormulario new value of creadorFormulario
     */
    public void setCreadorFormulario(Persona creadorFormulario) {
        this.creadorFormulario = creadorFormulario;
    }

    public Formulario(String nombreFormulario, String rutaRormulario, String fechaCreacionFormulario, Persona creadorFormulario) {
        this.nombreFormulario = nombreFormulario;
        this.rutaRormulario = rutaRormulario;
        this.fechaCreacionFormulario = fechaCreacionFormulario;
        this.creadorFormulario = creadorFormulario;
    }
    
     public Formulario() {}

     protected static String getFormulario(String nombreFormulario){
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String resultado = "";

        try {
            String query = "Select \"formularioRuta\" FROM \"SysmanexSch1\".\"Formulario\"\n"
                    + "WHERE \"formularioNombre\" = '" + nombreFormulario + "';";
            rs = conDB.hacerConsulta(query);
            while (rs.next()) {
                resultado = rs.getString("formularioRuta");
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return resultado;
    }
    
     protected static ResultSet BuscarFormularios(){
        Conecciones conDB = new Conecciones();
        ResultSet rs = null;       

        try {
            String query = "Select * FROM \"SysmanexSch1\".\"Formulario\" ORDER BY \"formularioNombre\" ASC;";
            rs = conDB.hacerConsulta(query);                       

        } catch (Exception ex) {
            Logger.getLogger(Conecciones.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
    
     protected int AgregarFormulario() throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado;
        if (!"".equals(this.nombreFormulario) && !"".equals(this.rutaRormulario)) {
            String query = "INSERT INTO \"SysmanexSch1\".\"Formulario\"(\n" +
                            "\"formularioNombre\", \"formularioRuta\","
                    + " \"formularioFechaCreacion\", \"formularioCiCreador\")\n" +
                            "VALUES ('" + this.nombreFormulario+ "', '" + this.rutaRormulario + "',"
                    + " '" + this.fechaCreacionFormulario + "', '" + this.creadorFormulario +"');";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }
     
     public String TablaFormularios() throws SQLException {

        ResultSet rs = Formulario.BuscarFormularios();
        String tabla = "<form name=\"frmSubirFrm\" action=\"formulario.do\" method=\"POST\">"
                + "<table class=\"table table-striped\"><th>Formualrios Disponibles</th><th>Fecha de Creacion</th>"
                + "<th></th><th>Descarga</th>";
        while (rs.next()) {
           tabla += "<tr>" + "<td> <span id=\"tdd" + rs.getInt("formularioId") + "\">" + rs.getString("formularioNombre") + "</span>"
                   + "</td>" + "<td><span id=\"tdp" + rs.getInt("formularioId") + "\">" + rs.getDate("formularioFechaCreacion") + "</span></td>"
                    + "<td>&nbsp;</td><td><button type=\"submit\" id=\"btnBajarForm\" name=\"btnBajarFrm\" value=\"" + rs.getInt("formularioId") + "\"  class=\"glyphicon glyphicon-download\"></button></td>"
                   + " <input type=\"hidden\" id=\"id" + rs.getInt("formularioId")+ "\" value=\""+ rs.getInt("formularioId") + "\" name=\"formularioId" + "\">\n" 
                   + "<input type=\"hidden\"  id=\"id" + rs.getInt("formularioId") +"\" value=\""+ rs.getString("formularioRuta") +"\" name=\"formularioRuta" + "\">";
        }
        tabla += "</table></form>";

        return tabla;
    }
     
}
