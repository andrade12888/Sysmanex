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
 * @author Nova
 */
public class Persona extends Entidad {

    private String ciPersona;
    private String nombrePersona;
    private String apellidoPersona;
    private String emailPersona;
    

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
    
        /**
     * @return the emailPersona
     */
    public String getEmailPersona() {
        return emailPersona;
    }

    /**
     * @param emailPersona the emailPersona to set
     */
    public void setEmailPersona(String emailPersona) {
        this.emailPersona = emailPersona;
    }

    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public Persona(String ciPersona, String nombrePerona, String apellidoPersona) {
        this.nombrePersona = nombrePerona;
        this.ciPersona = ciPersona;
        this.apellidoPersona = apellidoPersona;
    }

    public Persona(String ciPersona, String personaNombre, String apellidoPersona, String userId, String contrasenia, Rol rol, String personaEmail) {
        super(userId, contrasenia, rol);
        this.ciPersona = ciPersona; 
        this.nombrePersona= personaNombre;
        this.apellidoPersona = apellidoPersona;
        this.emailPersona=personaEmail;
    }

    //</editor-fold>
   
//TODO: Ver refactor de los metods de Agregar PersonaEnUnidad y Empresa
    //Segun lo enviado desde el form, persona debe :
    //1: Agregar entidad(user)
    //2: Agregar persona con el id de Entiad que capturo del insert anterior
    //3: Agregar en UnidadArmada dicha persona 
    
    //TODO: Se puede devolver un numero diferente para cada transsaccion que falle
    //TODO: Como llegan los valores, por parametros o por objetos?
    
    //PRE: La unidad existe dado que viene del Form
    protected int AgregarPersonaEnUnidad(int unidadId) throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado =-1;

        //Controlo que los valores necesario para inrgesar una persona no sean vacios
        if (!"".equals(this.ciPersona) &&
                !"".equals(super.getNombreEntidad()) &&
                !"".equals(this.apellidoPersona)&&
                !"".equals(super.getContrasenia())&&
                !"".equals(this.emailPersona) ) 
        {                     
            try {
                //Seteo autocommit false para que todo se ejecute como una transaccion
                conDB.getConnect().setAutoCommit(false);

                //Agrego la entidad con la contrasena, username y rol que viene del form
                Entidad e = new Entidad(super.getNombreEntidad(),
                        super.getContrasenia(),
                        super.getRol());
                //Me quedo con el id de entidad si se ejecuto correctamente
                int entidadId = e.AgregarEntidad();
                
                //Si se agrego correctamente la entidad, agrego la persona con el id de entidad guardado
                  String queryPersona = "INSERT INTO \"SysmanexSch1\".\"Persona\"(\"personaCi\", \"personaNombre\","
                          + " \"personaApellido\", \"personaEntidadId\", \"personaEmail\")" 
                    + "   VALUES ('" + this.ciPersona + "', '" + this.nombrePersona + "', " +
                     " '" + this.apellidoPersona + "', " + entidadId +"', " + this.emailPersona + ");";
                conDB.hacerConsultaIUD(queryPersona);
                
                //Ahora agrego la persona a la unidad en la tabla UnidadTienePersona con el valor 
                // de unidad que viene del form
                 String queryPersonaEnUnidad = "INSERT INTO \"SysmanexSch1\".\"UnidadTienePersona\"(\n"
                    + "\"unidadId\", \"personaCi\")\n"
                    + "   VALUES ('" + unidadId + "', " +this.ciPersona+");";
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
            System.err.print("Los campos en Nombre, Apellido CI, Email no pueden ser vacios.\n");
            resultado = 2;
        }
        return resultado;
    }
    
    //Segun lo enviado desde el form, persona debe :
    //1: Agregar entidad(user)
    //2: Agregar persona con el id de Entiad que capturo del insert anterior
    //3: Agregar en  Empresa dicha persona 
    
    //TODO: Se puede devolver un numero diferente para cada transsaccion que falle
    //TODO: Como llegan los valores, por parametros o por objetos?
    //PRE: La empresa existe dado que viene del Form
    protected int AgregarPersonaEnEmpresa(String rutEmpresa) throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado =-1;

        //Controlo que los valores necesario para inrgesar una persona no sean vacios
        if (!"".equals(this.ciPersona) && !"".equals(super.getNombreEntidad()) && 
                !"".equals(this.apellidoPersona)&& 
                !"".equals(super.getContrasenia())&& 
                !"".equals(this.emailPersona) ) 
        {                     
            try {
                //Seteo autocommit false para que todo se ejecute como una transaccion
                conDB.getConnect().setAutoCommit(false);           
                //Me quedo con el id de entidad si se ejecuto correctamente
                //Agrego la entidad con la contrasena, username y rol que viene del form
                Entidad e = new Entidad(super.getNombreEntidad(),
                        super.getContrasenia(),
                        super.getRol());
                int entidadId = e.AgregarEntidad();
                
                //Si se agrego correctamente la entidad, agrego la persona con el id de entidad guardado
                  String queryPersona = "INSERT INTO \"SysmanexSch1\".\"Persona\"(\"personaCi\", \"personaNombre\","
                          + " \"personaApellido\", \"personaEntidadId\", \"personaEmail\")" 
                    + "   VALUES ('" + this.ciPersona + "', '" + this.nombrePersona + "', " +
                     " '" + this.apellidoPersona + "', " + entidadId +"', " + this.emailPersona + ");";
                conDB.hacerConsultaIUD(queryPersona);
                
//                ArrayList<Persona> listaAutorizados = new ArrayList<>();
//                listaAutorizados.add(this);
//                //Agrego la empresa con el nombre y rut que viene del Form
//                Empresa emp = new Empresa(rutEmpresa,listaAutorizados, nombreEmpresa);
                //Ahora agrego la persona a la unidad en la tabla UnidadTienePersona con el valor 
                // de entidadId que viene del form
                 String queryPersonaEnUnidad = "INSERT INTO \"SysmanexSch1\".\"EmpresaTienePersona\"(\n"
                    + "\"empresaRut\", \"personaCi\")\n"
                    + "   VALUES ('" + rutEmpresa + "', " +this.ciPersona+");";
                conDB.hacerConsultaIUD(queryPersonaEnUnidad);
                
                conDB.getConnect().commit();
                resultado = 1;

            } catch (SQLException e) {

                if (conDB.getConnect() != null) {
                    try {
                        System.err.print("Ocurrio un error ingresando la persona a la Empresa");
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
            System.err.print("Los campos en Nombre, Apellido CI, Email no pueden ser vacios.\n");
            resultado = 2;
        }
        return resultado;
    }

    //TODO: Definir que datos se tienen que modificar
    protected int ModificarPersona(String ciPersona) throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado;

        if (!"".equals(super.getNombreEntidad()) && !"".equals(this.apellidoPersona) && this.getEntidadId() > 0) {
            String query = "UPDATE \"SysmanexSch1\".\"Persona\"\n"
                    + "	SET \"personaNombre\"=\'" + this.nombrePersona+ "\',"
                    + " \"personaApellido\"='" + this.apellidoPersona + "\',\"personaEntidadId\"=" + this.getEntidadId() + "\\n"
                    + "	WHERE \"entidadId\"=" + this.getEntidadId() + ";";
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

    //TODO:Definir que valores retorno
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
