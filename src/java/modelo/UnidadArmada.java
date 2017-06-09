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

/**
 *
 * @author Nova
 */
public class UnidadArmada extends Entidad {

    private ArrayList<Persona> personas;
    private String sigla;
  

    /**
     * @return the personas
     */
    public ArrayList<Persona> getPersonas() {
        return personas;
    }

    /**
     * @param personas the personas to set
     */
    public void setPersonas(ArrayList<Persona> personas) {
        this.personas = personas;
    }

    /**
     * @return the sigla
     */
    public String getSigla() {
        return sigla;
    }

    /**
     * @param sigla the sigla to set
     *
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;

    }

    public UnidadArmada(ArrayList<Persona> personas, String sigla) {
        this.personas = personas;
        this.sigla = sigla;
    }

    public UnidadArmada(String sigla, int idEntidad) {
        this.sigla = sigla;
        super.setEntidadId(idEntidad);
    }

        //PRE: La entidad debe existir        
        protected int AgregarUnidad() {
        Conecciones conDB = new Conecciones();
        int resultado = -1;
        String queryInsertUnidad = "INSERT INTO \"SysmanexSch1\".\"Unidad\"(\n"
                + "\"unidadSigla\", \"unidadEntidadId\")\n"
                + "   VALUES ('" + this.sigla + "', '" + this.getEntidadId() + "');";

        if (!"".equals(this.sigla) && !"".equals(this.getEntidadId())) {
            resultado = conDB.hacerConsultaIUD(queryInsertUnidad);

        
        }  else {
            System.err.print("El nombre de la unidad no puede ser vacio.\n");
            System.err.print("La unidad no puede ser vacia.");
            resultado = 2;
        }
        return resultado;
    }

    protected static ResultSet BuscarUnidades() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String query = "SELECT * FROM \"SysmanexSch1\".\"Unidad\" ORDER BY \"unidadSigla\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    protected static ResultSet BuscarUnidadPorNombre(String nombre) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String query = "SELECT * FROM \"SysmanexSch1\".\"Unidad\""
                + " WHERE \"unidadSigla\" LIKE \'%" + nombre + "\'"
                + " ORDER BY \"unidadSigla\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    protected static ResultSet BuscarUnidadPorEntidadId(int entidad) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Unidad\""
                + " WHERE \"unidadEntidadId\" = " + entidad + ";";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    //TODO: Delete o baja logica
    protected static int BorrarUnidadArmada(String sigla) {
        Conecciones conDB = new Conecciones();
        int resultado = 0;

        return resultado;
    }


}
