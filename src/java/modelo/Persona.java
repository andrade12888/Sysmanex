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
public class Persona extends Entidad {

    private String ciPersona;
    private String personaNombre;
    private String apellidoPersona;

    //<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    /**
     * Get the value of ciPersona
     *
     * @return the value of ciPersona
     */
    public String getCiPersona() {
        return ciPersona;
    }

    /**
     * Set the value of ciPersona
     *
     * @param ciPersona new value of ciPersona
     */
    public void setCiPersona(String ciPersona) {
        this.ciPersona = ciPersona;
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Persona(String ciPersona, String nombrePerona, String apellidoPersona) {
        this.personaNombre = nombrePerona;
        this.ciPersona = ciPersona;
        this.apellidoPersona = apellidoPersona;
    }

    public Persona(String ciPersona, String apellidoPersona, String nombre, String contrasenia) {
        super(nombre, contrasenia);
        this.ciPersona = ciPersona;
        this.apellidoPersona = apellidoPersona;
    }

    //</editor-fold>
    /**
     * @return the apellidoPersona
     */
    public String getApellidoPersona() {
        return apellidoPersona;
    }

    /**
     * @param apellidoPersona the apellidoPersona to set
     */
    public void setApellidoPersona(String apellidoPersona) {
        this.apellidoPersona = apellidoPersona;
    }

    /**
     * @return the personaNombre
     */
    public String getPersonaNombre() {
        return personaNombre;
    }

    /**
     * @param personaNombre the personaNombre to set
     */
    public void setPersonaNombre(String personaNombre) {
        this.personaNombre = personaNombre;
    }

    //Segun lo enviado desde el form, persona debe :
    //1: Agregar entidad(user)
    //2: Agregar persona con el id de Entiad que capturo del insert anterior
    //3: Agregar en UnidadArmada o Empresa dicha persona 
    protected int AgregarPersona() {
        Conecciones conDB = new Conecciones();
        int resultado =-1;

        if (!"".equals(this.ciPersona) && !"".equals(this.getPersonaNombre()) && !"".equals(this.apellidoPersona) && this.getEntidadId() > 0) {
            String query = "INSERT INTO \"SysmanexSch1\".\"Persona\"(\n"
                    + "\"personaCi\", \"personaNombre\", \"personaApellido\", \"personaEntidadId\")\n"
                    + "   VALUES ('" + this.ciPersona + "', '" + this.getPersonaNombre() + "', " + "', '" + this.apellidoPersona + "', " + this.getEntidadId() + ");";

            try {
                conDB.getConnect().setAutoCommit(false);
                conDB.hacerConsultaIUD(query);
//                for (String a : this.listaArchivosExpediente) {
//
//                    queryInsertArchivoExpediente = "INSERT INTO \"SysmanexSch1\".\"ExpedienteArchivo\"(\n"
//                            + "\"ExpedienteId\", \"ArchivoId\")\n"
//                            + " VALUES ('" + this.numeroExpediente + "', '" + a + "');";
//                    conDB.hacerConsultaIUD(queryInsertArchivoExpediente);
//                }

                conDB.getConnect().commit();
                resultado = 1;

            } catch (SQLException e) {

                if (conDB.getConnect() != null) {
                    try {
                        System.err.print("Ocurrio un error ingresando el expediente");
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
        } else {
            System.err.print("Asunto, Motivo no pueden ser vacio.\n");
            resultado = 2;
        }
        return resultado;
    }

    protected int ModificarPersona(String ciPersona) {
        Conecciones conDB = new Conecciones();
        int resultado;

        if (!"".equals(this.getPersonaNombre()) && !"".equals(this.apellidoPersona) && this.getEntidadId() > 0) {
            String query = "UPDATE \"SysmanexSch1\".\"Persona\"\n"
                    + "	SET \"personaNombre\"=\'" + this.getPersonaNombre() + "\', \"personaApellido\"='" + this.apellidoPersona + "\',\"personaEntidadId\"=" + this.getEntidadId() + "\\n"
                    + "	WHERE \"entidadId\"=" + Integer.parseInt(ciPersona) + ";";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }

    //TODO: Definir borrar persona. Otra vez, Delete o baja logica
    protected static int BorrarPersona(String ci) {
        Conecciones conDB = new Conecciones();
        int resultado = 0;

        return resultado;
    }

    protected static ResultSet BuscarPersona(String nombre) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Persona\""
                + " WHERE \"personaNombre\" LIKE \'%" + nombre + "\'"
                + " ORDER BY \"personaNombre\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    protected static ResultSet BuscarPersonas() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Persona\""
                + " ORDER BY \"personaNombre\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

}
