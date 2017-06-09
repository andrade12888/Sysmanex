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
    private String nombrePersona;
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
        this.nombrePersona = nombrePerona;
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


    //Segun lo enviado desde el form, persona debe :
    //1: Agregar entidad(user)
    //2: Agregar persona con el id de Entiad que capturo del insert anterior
    //3: Agregar en UnidadArmada o Empresa dicha persona 
    
    //TODO: Se puede devolver un numero diferente para cada transsaccion que falle
    //TODO: Como llegan los valores, por parametros o por objetos?
    protected int AgregarPersonaEnUnidad(int unidadId) throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado =-1;

        //Controlo que los valores necesario para inrgesar una persona no sean vacios
        if (!"".equals(this.ciPersona) && !"".equals(super.getNombreEntidad()) && !"".equals(this.apellidoPersona)) 
        {                     
            try {
                //Seteo autocommit false para que todo se ejecute como una transaccion
                conDB.getConnect().setAutoCommit(false);

                //Agrego la entidad con la contrasena, username y rol que viene del form
                Entidad e = new Entidad(super.getNombreEntidad(),super.getContrasenia(), super.getRol());
                //Me quedo con el id de entidad si se ejecuto correctamente
                int entidadId = e.AgregarEntidad();
                
                //Si se agrego correctamente la entidad, agrego la persona con el id de entidad guardado
                  String queryPersona = "INSERT INTO \"SysmanexSch1\".\"Persona\"(\n"
                    + "\"personaCi\", \"personaNombre\", \"personaApellido\", \"personaEntidadId\")\n"
                    + "   VALUES ('" + this.ciPersona + "', '" + super.getNombreEntidad() + "', " + "',"
                    + " '" + this.apellidoPersona + "', " + entidadId + ");";
                conDB.hacerConsultaIUD(queryPersona);
                
                //Ahora agrego la persona a la unidad en la tabla UnidadTienePersona con el valor 
                // de entidadId que viene del form
                 String queryPersonaEnUnidad = "INSERT INTO \"SysmanexSch1\".\"UnidadTienePersona\"(\n"
                    + "\"unidadId\", \"personaCi\")\n"
                    + "   VALUES ('" + this.ciPersona + "', '" +unidadId+");";
                conDB.hacerConsultaIUD(queryPersonaEnUnidad);
                
                conDB.getConnect().commit();
                resultado = 1;

            } catch (SQLException e) {

                if (conDB.getConnect() != null) {
                    try {
                        System.err.print("Ocurrio un error ingresando la persona a la Unidad");
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
                        throw ex;
                    }
                }
            }
        } else {
            System.err.print("Los campos en Nombre, Apellido y CI no pueden ser vacios.\n");
            resultado = 2;
        }
        return resultado;
    }

    protected int ModificarPersona(String ciPersona) throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado;

        if (!"".equals(super.getNombreEntidad()) && !"".equals(this.apellidoPersona) && this.getEntidadId() > 0) {
            String query = "UPDATE \"SysmanexSch1\".\"Persona\"\n"
                    + "	SET \"personaNombre\"=\'" + super.getNombreEntidad()+ "\',"
                    + " \"personaApellido\"='" + this.apellidoPersona + "\',\"personaEntidadId\"=" + this.getEntidadId() + "\\n"
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

    /**
     * @return the nombrePersona
     */
    public String getNombrePersona() {
        return nombrePersona;
    }

    /**
     * @param nombrePersona the nombrePersona to set
     */
    public void setNombrePersona(String nombrePersona) {
        this.nombrePersona = nombrePersona;
    }

}
