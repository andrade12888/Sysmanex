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
    public Persona() {
    }

    public Persona(String ciPersona, String nombrePerona, String apellidoPersona) {
        this.nombrePersona = nombrePerona;
        this.ciPersona = ciPersona;
        this.apellidoPersona = apellidoPersona;
    }

    public Persona(String ciPersona, String personaNombre, String apellidoPersona, String userId, String contrasenia, Rol rol, String personaEmail) {
        super(userId, contrasenia, rol);
        this.ciPersona = ciPersona;
        this.nombrePersona = personaNombre;
        this.apellidoPersona = apellidoPersona;
        this.emailPersona = personaEmail;
    }

    //</editor-fold>
    public int AgregarPersona(int entidadDePersona) {
        try {
            Conecciones conDB = new Conecciones();

            String queryPersona = "INSERT INTO \"SysmanexSch1\".\"Persona\"(\"personaCi\", \"personaNombre\","
                    + " \"personaApellido\", \"personaEntidadId\", \"personaEmail\")"
                    + "   VALUES ('" + this.ciPersona + "', '" + this.nombrePersona + "', "
                    + " '" + this.apellidoPersona + "', " + entidadDePersona + ", '" + this.emailPersona + "');";

            conDB.hacerConsultaIUD(queryPersona);
        } catch (SQLException ex) {
            return -1;
        }
        return 1;
    }

    //TODO: Ver refactor de los metods de Agregar PersonaEnUnidad y Empresa
    //Segun lo enviado desde el form, persona debe :
    //1: Agregar entidad(user)
    //2: Agregar persona con el id de Entiad que capturo del insert anterior
    //3: Agregar en UnidadArmada dicha persona 
    //TODO: Se puede devolver un numero diferente para cada transsaccion que falle
    //TODO: Como llegan los valores, por parametros o por objetos?
    //PRE: La unidad existe dado que viene del Form
    public int AgregarPersonaEnUnidad(int unidadId) {
        Conecciones conDB = new Conecciones();
        int resultado = -1;

        //Controlo que los valores necesario para inrgesar una persona y el usuario no sean vacios
        if (!"".equals(this.ciPersona)
                && !"".equals(super.getNombreEntidad())
                && // Nombre de Usuario para loggearse
                !"".equals(this.apellidoPersona)
                && !"".equals(super.getContrasenia())
                && !"".equals(this.nombrePersona)
                && !"".equals(this.emailPersona)) {
            try {
                //Seteo autocommit false para que todo se ejecute como una transaccion
                conDB.getConnect().setAutoCommit(false);

                //Agrego la entidad con la contrasena, username y rol que viene del form
                Entidad e = new Entidad(super.getNombreEntidad(),
                        super.getContrasenia(),
                        super.getRol());
                //Me quedo con el id de entidad si se ejecuto correctamente
                int entidadId = e.AgregarEntidad();
                e.setEntidadId(entidadId);

                //Si se agrego correctamente la entidad, agrego la persona con el id de entidad guardado
                String queryPersona = "INSERT INTO \"SysmanexSch1\".\"Persona\"(\"personaCi\", \"personaNombre\","
                        + " \"personaApellido\", \"personaEntidadId\", \"personaEmail\")"
                        + "   VALUES ('" + this.ciPersona + "', '" + this.nombrePersona + "', "
                        + " '" + this.apellidoPersona + "', " + entidadId + ", '" + this.emailPersona + "');";

                conDB.hacerConsultaIUD(queryPersona);

                //Ahora agrego la persona a la unidad en la tabla UnidadTienePersona con el valor 
                // de unidad que viene del form
                String queryPersonaEnUnidad = "INSERT INTO \"SysmanexSch1\".\"UnidadTienePersona\"(\n"
                        + "\"unidadId\", \"personaCi\")\n"
                        + "   VALUES ('" + unidadId + "', " + this.ciPersona + ");";
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
                        return -1;
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
    public int AgregarPersonaEnEmpresa(String rutEmpresa) {
        Conecciones conDB = new Conecciones();
        int resultado = -1;

        //Controlo que los valores necesario para inrgesar una persona no sean vacios
        if (!"".equals(this.ciPersona) && !"".equals(super.getNombreEntidad())
                && !"".equals(this.apellidoPersona)
                && !"".equals(this.nombrePersona)
                && !"".equals(super.getContrasenia())
                && !"".equals(this.emailPersona)) {
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
                        + "   VALUES ('" + this.ciPersona + "', '" + this.nombrePersona + "', "
                        + " '" + this.apellidoPersona + "', " + entidadId + ", '" + this.emailPersona + "');";
                conDB.hacerConsultaIUD(queryPersona);

                //Ahora agrego la persona a la tabla EmpresadTienePersona con el valor 
                // la ci de la persona agregada y el RUT del form
                String queryPersonaEnUnidad = "INSERT INTO \"SysmanexSch1\".\"EmpresaTienePersona\"(\n"
                        + "\"empresaRut\", \"personaCi\")\n"
                        + "   VALUES ('" + rutEmpresa + "', " + this.ciPersona + ");";
                conDB.hacerConsultaIUD(queryPersonaEnUnidad);

                conDB.getConnect().commit();
                resultado = 1;

            } catch (SQLException e) {

                if (conDB.getConnect() != null) {
                    try {
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
                        return -1;
                    }
                }
            }
        } else {
            resultado = 3;
        }
        return resultado;
    }

    public static int BorrarPersona(String ci) {
        Conecciones conDB = new Conecciones();
        int resultado = -1;

        if (!"".equalsIgnoreCase(ci)) {
            try {
                conDB.getConnect().setAutoCommit(false);
                String query1 = "DELETE FROM \"SysmanexSch1\".\"UnidadTienePersona\" WHERE \"personaCi\" = '" + ci + "';";
                resultado = conDB.hacerConsultaIUD(query1);
                if (resultado == 1) {
                    String query = "DELETE FROM \"SysmanexSch1\".\"Persona\" WHERE \"personaCi\" = '" + ci + "';";
                    resultado = conDB.hacerConsultaIUD(query);
                }
                if (resultado == 1) {
                    conDB.getConnect().commit();
                } else {
                    conDB.getConnect().rollback();
                }
            } catch (SQLException ex) {
                if ("23503".equalsIgnoreCase(ex.getSQLState())) {
                    return Integer.parseInt(ex.getSQLState());
                }
                return -1;
            }
        } else {
            resultado = 2;
        }
        return resultado;
    }

    public int ModificarPersona(String ciPersona) {
        Conecciones conDB = new Conecciones();
        int resultado = -1;

        if (!"".equals(super.getNombreEntidad()) && !"".equals(this.apellidoPersona)) {
            try {
                String query = "UPDATE \"SysmanexSch1\".\"Persona\"\n"
                        + "	SET \"personaNombre\"=\'" + this.nombrePersona + "\',"
                        + " \"personaApellido\"=\'" + this.apellidoPersona + "\',"
                        + "\"personaEmail\"=\'" + this.emailPersona + "\'\n"
                        + "	WHERE \"personaCi\"=\'" + ciPersona + "\';";
                resultado = conDB.hacerConsultaIUD(query);
            } catch (SQLException ex) {
                return resultado;
            }
        } else {
            resultado = 2;
        }
        return resultado;
    }

    public void BuscarPersonaPorNombre(String nombre) {
        try {
            Conecciones conDB = new Conecciones();
            ResultSet rs;

            String query = "SELECT * FROM \"SysmanexSch1\".\"Persona\""
                    + " WHERE \"personaNombre\" LIKE \'%" + nombre + "\'"
                    + " ORDER BY \"personaNombre\" ASC;";
            rs = conDB.hacerConsulta(query);
            while (rs.next()) {
                this.setEntidadId(rs.getInt("entidadId"));
                this.setNombrePersona(rs.getString("personaNombre"));
                this.setApellidoPersona(rs.getString("personaApellido"));
                this.setCiPersona(rs.getString("personaCi"));
                this.setEmailPersona(rs.getString("personaEmail"));
            }

        } catch (SQLException ex) {

        }

    }

    public void BuscarPersonaPorId(int id) {
        Conecciones conDB = new Conecciones();

        String query = "SELECT * FROM \"SysmanexSch1\".\"Persona\""
                + " WHERE \"personaEntidadId\" = " + id + ";";
        try {
            ResultSet rs = conDB.hacerConsulta(query);
            while (rs.next()) {
                this.setEntidadId(rs.getInt("personaEntidadId"));
                this.setNombrePersona(rs.getString("personaNombre"));
                this.setApellidoPersona(rs.getString("personaApellido"));
                this.setCiPersona(rs.getString("personaCi"));
                this.setEmailPersona(rs.getString("personaEmail"));
            }
        } catch (SQLException ex) {
            if ("23503".equalsIgnoreCase(ex.getSQLState())) {

            }

        }
    }

    public static ResultSet BuscarPersonas() {
        try {
            Conecciones conDB = new Conecciones();
            ResultSet rs;

            String query = "SELECT * FROM \"SysmanexSch1\".\"Persona\""
                    + " ORDER BY \"personaNombre\" ASC;";
            rs = conDB.hacerConsulta(query);

            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String TablaPersonas() //TODO: Le faltarian los cabezales Nombre Apellido y Email
    {
        try {
            ResultSet rs = BuscarPersonas();
            String tabla = "<form name=\"frmBorrar\" action=\"CUsuarios.do\" method=\"POST\">"
                    + "<table class=\"table table-striped\">"
                    + "<th>Personas</th>"
                    + "<th> </th>"
                    + "<th> </th>"
                    + "<th>Opciones</th>";
            if (rs != null) {
                while (rs.next()) {
                    tabla += "<tr><td><input type=\"hidden\" id=\"id" + rs.getString("personaCi") + "\" name=\"txtIdPersona\" value=\"" + rs.getString("personaCi") + "\">"
                            + "<span id=\"tdd" + rs.getString("personaCi") + "\">" + rs.getString("personaNombre") + "</span></td>"
                            + "<td><span id=\"apellido" + rs.getString("personaCi") + "\">" + rs.getString("personaApellido") + "</span></td>"
                            + "<td><span id=\"email" + rs.getString("personaCi") + "\">" + rs.getString("personaEmail") + "</span></td>"
                            + "<td><button onclick=\"modalPersonas(" + rs.getString("personaCi") + ")\" id=\"" + rs.getString("personaCi") + "\" "
                            + "type=\"button\" class=\"btn glyphicon glyphicon-pencil\" data-toggle=\"modal\" data-target=\"#myModal\">\n"
                            + "</button><button onclick=\"modalEliminarPersona(" + rs.getString("personaCi") + ")\" name=\"btnPersona\" value=\"Delete" + rs.getString("personaCi") + "\" type=\"button\" class=\"btn glyphicon glyphicon-trash\" data-toggle=\"modal\" data-target=\"#modalPersonaEliminar\"></button></td>";
                }
            }
            tabla += "</table></form>";
            return tabla;
        } catch (SQLException ex) {
            return "";
        }
    }

}
