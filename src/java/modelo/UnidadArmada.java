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
     */
    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public UnidadArmada(ArrayList<Persona> personas, String sigla) {
        this.personas = personas;
        this.sigla = sigla;
    }

    public UnidadArmada(ArrayList<Persona> personas, String sigla, String nombre, String contrasenia) {
        super(nombre, contrasenia);
        this.personas = personas;
        this.sigla = sigla;
    }

    //PRE: La entidad debe existir
    protected int AgregarUnidad() {
        Conecciones conDB = new Conecciones();
        int resultado = -1;
        String queryInsertUnidad = "INSERT INTO \"SysmanexSch1\".\"Unidad\"(\n"
                + "\"unidadSigla\", \"unidadEntidadId\")\n"
                + "   VALUES ('" + this.sigla + "', '" + this.getEntidadId() + "');";
        String queryInsertPersonaEnUnidad;

        //PRE: solo se ingresa la Unidad sin personas
        //POST: Solo se agrega la Unidad
        if (!"".equals(this.sigla) && (this.personas.isEmpty())) {
            resultado = conDB.hacerConsultaIUD(queryInsertUnidad);

        } else if (!"".equals(this.sigla) && !(this.personas.isEmpty())) {

            try {
                conDB.getConnect().setAutoCommit(false);
                ResultSet rs = conDB.hacerConsulta(queryInsertUnidad);
                rs.next();

                for (Persona p : this.personas) {

                    queryInsertPersonaEnUnidad = "INSERT INTO \"SysmanexSch1\".\"UnidadTienePersona\"(\n"
                            + "\"unidadId\", \"unidadEntidadId\")\n"
                            + "   VALUES ('" + rs.getInt(1) + "', '" + p.getCiPersona() + "');";
                    conDB.hacerConsultaIUD(queryInsertPersonaEnUnidad);
                }

                if (!rs.isClosed()) {
                    rs.close();
                }
                conDB.getConnect().commit();
                resultado = 1;

            } catch (SQLException e) {

                if (conDB.getConnect() != null) {
                    try {
                        System.err.print("Ocurrio un error ingresando las personas a la empresa");
                        conDB.getConnect().rollback();
                        return -1;
                    } catch (SQLException excep) {
                        return -1;
                    }
                }

            } finally {
                if (conDB.getConnect() != null) {
                    try {
                        conDB.getConnect().setAutoCommit(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(Empresa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        else{
            System.err.print("El RUT no puede ser vacio.\n");
            System.err.print("El RUT no puede ser vacio.");
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

    protected static ResultSet BuscarUnidadPorSigla(String sigla) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Unidad\""
                + " WHERE \"unidadSigla\" = \'" + sigla + "\';";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    protected static int BorrarEmpresa(String RUT) {
        Conecciones conDB = new Conecciones();
        int resultado = 0;
//TODO
        return resultado;
    }

}
