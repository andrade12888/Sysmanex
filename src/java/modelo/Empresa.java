/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import accesoaDatos.Conecciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nova
 */
public class Empresa {

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private String rutEmpresa;
    private ArrayList<Persona> listaPersonasAutorizadas;
    private String nombreEmpresa;
    //</editor-fold>

   //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    /**
     * Get the value of rutEmpresa
     *
     * @return the value of rutEmpresa
     */
    public String getRutEmpresa() {
        return rutEmpresa;
    }

    /**
     * Set the value of rutEmpresa
     *
     * @param rutEmpresa new value of rutEmpresa
     */
    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    /**
     * @return the listaPersonasAutorizadas
     */
    public ArrayList<Persona> getListaPersonasAutorizadas() {
        return listaPersonasAutorizadas;
    }

    /**
     * @param listaPersonasAutorizadas the listaPersonasAutorizadas to set
     */
    public void setListaPersonasAutorizadas(ArrayList<Persona> listaPersonasAutorizadas) {
        this.listaPersonasAutorizadas = listaPersonasAutorizadas;
    }

    /**
     * @return the nombreEmpresa
     */
    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    /**
     * @param nombreEmpresa the nombreEmpresa to set
     */
    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }
    //</editor-fold>    

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Empresa(String rutEmpresa, ArrayList<Persona> listaPersonasAutorizadas) {
        this.rutEmpresa = rutEmpresa;
        this.listaPersonasAutorizadas = listaPersonasAutorizadas;
    }

    public Empresa(String rutEmpresa, ArrayList<Persona> listaPersonasAutorizadas, String nombreEmpresa) {
        this.rutEmpresa = rutEmpresa;
        this.listaPersonasAutorizadas = listaPersonasAutorizadas;
        this.nombreEmpresa = nombreEmpresa;
    }
    
    public Empresa(){}

    //</editor-fold>
    
    //PRE: NA
    //POST: Retorna 1 si se ejecuta con exito, 0 si no reotorna nada, 2 si alguna de las variables
    //      es nula (Rut o persona autorizada) o -1 si existe algun error en la secuancia SQL
    public int AgregarEmpresa() {
        Conecciones conDB = new Conecciones();
        int resultado;        

        if (!"".equals(this.rutEmpresa) && !"".equals(this.nombreEmpresa)) {
            
            String queryInsertEmpresa = "INSERT INTO \"SysmanexSch1\".\"Empresa\"(\n"
                    + "\"empresaRut\", \"empresaNombre\")\n"
                    + "   VALUES ('" + this.rutEmpresa + "', '" + this.nombreEmpresa + "');";
            try {
                conDB.hacerConsultaIUD(queryInsertEmpresa);
            } catch (SQLException ex) {
                return -1;
            }
            resultado = 1;
        } else {           
            resultado = 2;
        }
        return resultado;
    }

    public static ResultSet BuscarEmpresas() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String query = "SELECT * FROM \"SysmanexSch1\".\"Empresa\" ORDER BY \"empresaNombre\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    public static ResultSet BuscarEmpresaPorNombre(String nombre) {
        try {
            Conecciones conDB = new Conecciones();
            ResultSet rs;
            String query = "SELECT * FROM \"SysmanexSch1\".\"Empresa\""
                    + " WHERE \"empresaNombre\" LIKE \'%" + nombre + "\'"
                    + " ORDER BY \"empresaNombre\" ASC;";
            rs = conDB.hacerConsulta(query);            
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public static ResultSet BuscarEmpresaPorRUT(String rutEmpresa) {
        try {
            Conecciones conDB = new Conecciones();
            ResultSet rs;
            
            String query = "SELECT * FROM \"SysmanexSch1\".\"Empresa\""
                    + " WHERE \"empresaRut\" = \'" + rutEmpresa + "\';";
            rs = conDB.hacerConsulta(query);
            
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }
    

    public static int BorrarEmpresa(String RUT) throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado;

        String query = "DELETE FROM \"SysmanexSch1\".\"Empresa\"\n"              
                + "	WHERE \"empresaRut\"='"+ RUT +"\';";
        try {
            resultado = conDB.hacerConsultaIUD(query);
        } catch (SQLException ex) {
            if("23503".equalsIgnoreCase(ex.getSQLState()))
                return Integer.parseInt(ex.getSQLState());
            return -1;
        }       
        return resultado;
    }
        
    public static int ModificarEmpresa(Empresa emp, String rut) throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado;

        String query = "UPDATE \"SysmanexSch1\".\"Empresa\""
                + " SET \"empresaRut\" = '"+emp.rutEmpresa+"', \"empresaNombre\" = '"+emp.nombreEmpresa + "' "
                + "WHERE \"empresaRut\" = '"+rut+"';";
        try {
            resultado = conDB.hacerConsultaIUD(query);
        } catch (SQLException ex) {
            if("23503".equalsIgnoreCase(ex.getSQLState()))
                return Integer.parseInt(ex.getSQLState());
            return -1;
        }       
        return resultado;
    }
    
     public String TablaEmpresas() throws SQLException {

        ResultSet rs = Empresa.BuscarEmpresas();
        String tabla = "<form name=\"frmBorrar\" action=\"CEmpresas.do\" method=\"POST\"><table class=\"table table-striped\"><th>Empresas</th><th>Opciones</th>";
        while (rs.next()) {
            tabla += "<tr><td><input name=\"empresaBorrar\" type=\"hidden\" id=\"id" + rs.getString("empresaRut") + "\" value=\"" + rs.getString("empresaRut") + "\">"
                    + " <span id=\"tdd" + rs.getString("empresaRut") + "\">" + rs.getString("empresaNombre") + "</span></td>"
                    + "<td><button onclick=\"modalEmpresas(" + rs.getString("empresaRut") + ")\" id=\"" + rs.getString("empresaRut") + "\" "
                    + "type=\"button\" class=\"btn glyphicon glyphicon-pencil\" data-toggle=\"modal\" data-target=\"#myModal\">\n"
                    + "</button><button onclick=\"modalEliminarEmpresa(" + rs.getString("empresaRut") + ")\" name=\"btnEmpresas\" value=\"Delete\" type=\"button\" class=\"btn glyphicon glyphicon-trash\" data-toggle=\"modal\" data-target=\"#modalEliminarEmpresa\"></button></td>";
        }
        tabla += "</table></form>";

        return tabla;
    }

}
 