package modelo;

import accesoaDatos.Conecciones;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nova
 */
public class Entidad {

    private String nombreEntidad;
    private int entidadId;
    private String contrasenia;
    private Rol rol;
    private ArrayList<Expediente> misExpedientes;

    public ArrayList<Expediente> getMisExpedientes() {
        return misExpedientes;
    }

    public void setMisExpedientes(ArrayList<Expediente> misExpedientes) {
        this.misExpedientes = misExpedientes;
    }

    public String getNombreEntidad() {
        return nombreEntidad;
    }

    public void setNombreEntidad(String nombreEntidad) {
        this.nombreEntidad = nombreEntidad;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getEntidadId() {
        return entidadId;
    }
    
    public String getEntidadIdLargo(){
        if(entidadId>999){
            return Integer.toString(entidadId);
        }else if(entidadId>99){
            return "0"+entidadId;
        }else if(entidadId>9){
            return "00"+entidadId;
        }else{
            return "000"+entidadId;
        }
    }

    public void setEntidadId(int entidadId) {
        this.entidadId = entidadId;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Entidad() {
        this.misExpedientes = new ArrayList<Expediente>();
    }

    public Entidad(String nombreEntidad, String contrasenia) {
        this.nombreEntidad = nombreEntidad;
        this.contrasenia = contrasenia;
        this.misExpedientes = new ArrayList<Expediente>();
    }

    public Entidad(String nombre, String contrasenia, Rol rolEntidad) {
        this.nombreEntidad = nombre;
        this.contrasenia = contrasenia;
        this.rol = rolEntidad;
        this.misExpedientes = new ArrayList<Expediente>();
    }

    public void Autenticar(String nombre, String pass) throws ClassNotFoundException, SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        Rol unRol = new Rol();

        try {
            Connection conect = conDB.getConnect();
            PreparedStatement query = conect.prepareStatement("Select \"entidadId\",\"entidadNombre\",\"rolId\" FROM \"SysmanexSch1\".\"Entidad\""
                    + " WHERE \"entidadNombre\" = ? AND \"entidadPassword\" = ?;");
            query.setString(1, nombre);
            query.setString(2, pass);

            rs = query.executeQuery();

            while (rs.next()) {
                unRol.setDescripcion(unRol.getRolDB(rs.getInt(3)));
                unRol.setId(rs.getInt(3));
                this.setRol(unRol);
                this.setEntidadId(rs.getInt("entidadId"));
                this.setContrasenia(pass);
                this.setNombreEntidad(rs.getString(2));
            }
            rs.close();

        } catch (SQLException ex) {
            throw ex;
        } catch (Exception e) {
            throw e;
        }
    }

    public ResultSet ExpedientesDB() {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Expediente\""
                + " WHERE \"expedienteEntidadId\" = " + this.getEntidadId()
                + " AND \"expedienteBaja\" = false"
                + " ORDER BY \"expedienteNumero\" DESC;";
        try {
            rs = conDB.hacerConsulta(query);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String TablaExpedientes() {

        ResultSet rs = this.ExpedientesDB();
        String tabla = "<form style=\"height: 400px;overflow: scroll;\" name=\"frmMisExpedientes\" action=\"CExpediente.do\" "
                + "method=\"POST\"><table id=\"tableData\" class=\"table table-striped\"><tr><th>"
                + "Numero</th><th>Asunto</th><th>Fecha</th><th>Tipo de Tramite</th><th>Opciones</th><th></th></tr>";
        try {
            while (rs.next()) {
                String exp = rs.getString("expedienteNumero");
                Tramite unDoc = new Tramite();
                unDoc.BuscarTramite(rs.getInt("expedienteTramiteId"));
                tabla += "<tr><td><input type=\"hidden\" id=\"id" + exp + "\" value=\"" + rs.getString("expedienteNumero") + "\">"
                        + " <span id=\"enum" + exp + "\">" + rs.getString("expedienteNumero") + "</span></td>"
                        + "<td><span id=\"easu" + rs.getString("expedienteAsunto") + "\">" + rs.getString("expedienteAsunto") + "</span></td>"
                        + "<td><span id=\"efec" + rs.getDate("expedienteFecha") + "\">" + rs.getDate("expedienteFecha") + "</span></td>"
                        + "<td><span id=\"edoc" + unDoc.getId() + "\">" + unDoc.getNombre() + "</span></td>"
                        + "<td><button onclick=\"modalEnvio('" + exp + "')\" id=\"" + exp + "\" "
                        + "type=\"button\" class=\"btn glyphicon glyphicon-send\">"
                        + "</button><button onclick=\"modalEliminarExpediente(" + rs.getString("expedienteNumero") + ")\" name=\"btnEliminarExpediente\" value=\"" + exp + "\" type=\"button\" class=\"btn glyphicon glyphicon-trash\" data-toggle=\"modal\" data-target=\"#modalExpedienteEliminar\"></button></td>";
                Expediente unExpediente = new Expediente();
                unExpediente.traerExpediente(exp);
                ResultSet rs2 = unExpediente.ExpedienteTramitado();
                if (rs2 != null && rs2.next()) {
                    String tabla2 = "<td><input type=\"button\" id=\"m" + exp + "\"  onclick=\"mostrar(" + exp + ");\" value=\"+\"/>"
                            + "<input type=\"button\" id=\"o" + exp + "\" style=\"display: none;\" onclick=\"ocultar(" + exp + ");\" value=\"-\"/></td></tr>"
                            + "<tr><td colspan=\"5\" id=\"oculto" + exp + "\" name=\"oculto\"><table class=\"table table-striped\"><tr><th>"
                            + "Destino Actual</th><th>Fecha de Envio</th><th>Motivo</th><th>Observacion</th><th>Estado</th></tr>";
                    rs2.beforeFirst();
                    while (rs2.next()) {
                        String destinatario = "";
                        Entidad unaEntidad = new Entidad();
                        unaEntidad.buscarEntidadId(rs2.getInt("idEntidad"));
                        if (unaEntidad.queSoy() == 2) {
                            Persona unaPersona = new Persona();
                            unaPersona.BuscarPersonaPorId(unaEntidad.getEntidadId());
                            destinatario = unaPersona.getNombrePersona() + " " + unaPersona.getApellidoPersona();
                        } else {
                            UnidadArmada unaUnidad = new UnidadArmada();
                            unaUnidad.BuscarUnidadEntidadId(unaEntidad.getEntidadId());
                            destinatario = unaUnidad.getSigla();
                        }
                        tabla2 += "<tr><td>" + destinatario + "</td><td>" + rs2.getString("ExpedienteEntidadFechaRecibido") + "</td><td>" + rs2.getString("motivoDescripcion")
                                + "</td><td>" + rs2.getString("ExpedienteEntidadObservacion") + "</td><td>" + rs2.getString("estadoDescripcion")
                                + "</td></tr>";
                    }
                    rs2.close();
                    if (!tabla2.equals("<td><button id=\"m" + exp + "\"  onclick=\"mostrar(" + exp + ");\" class=\"btn glyphicon glyphicon-triangle-bottom\"></button>"
                            + "<button id=\"o" + exp + "\"  class=\" btn glyphicon glyphicon-triangle-top\" style=\"display: none;\" onclick=\"ocultar(" + exp + ");\"></button></td></tr>"
                            + "<tr><td colspan=\"5\" id=\"oculto" + exp + "\" name=\"oculto\"><table class=\"table table-striped\"><tr><th>"
                            + "Origen</th><th>Fecha de Envio</th><th>Motivo</th><th>Observacion</th><th>Estado</th></tr>")) {
                        tabla2 += "</table>";
                        tabla += tabla2 + "</td></tr>";
                    }
                } else {
                    tabla += "<th></th></tr>";
                    if (rs2 != null) {
                        rs2.close();
                    }
                }
            }
        } catch (SQLException ex) {
            tabla += "<tr><td> No se encontraron resultados o hubo un error. </td></tr>";
        }
        tabla += "</table></form>";

        return tabla;
    }

    //TODO: Resultado 2 podria dar error o conflicto si estoy inrgesando el segundo user
    //PRE: El rol debe existir en la base de datos
    protected int AgregarEntidad() throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado;
        if (!"".equals(this.nombreEntidad) && !"".equals(this.contrasenia) && this.rol != null) {

            try {
                Connection conect = conDB.getConnect();
                PreparedStatement query = conect.prepareStatement("INSERT INTO \"SysmanexSch1\".\"Entidad\"(\n"
                        + "\"entidadNombre\", \"entidadPassword\", \"rolId\") VALUES (?, ? ,? ) RETURNING \"entidadId\";");

                query.setString(1, this.nombreEntidad);
                query.setString(2, this.contrasenia);
                query.setInt(3, this.rol.getId());

                ResultSet rs = query.executeQuery();
                rs.next();
                resultado = rs.getInt(1);
            } catch (SQLException sqlex) {
                resultado = Integer.parseInt(sqlex.getSQLState());
            } catch (Exception ex) {
                return -1;
            }
        } else {
            resultado = 2;
        }

        return resultado;
    }

    protected int ModificarEntidad(String idEntidad) throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado;

        if (!"".equals(this.nombreEntidad) && !"".equals(this.contrasenia) && this.rol != null) {
            String query = "UPDATE \"SysmanexSch1\".\"Entidad\"\n"
                    + "	SET \"entidadNombre\"=\'" + this.nombreEntidad + "\', \"entidadPassword\"='" + this.contrasenia + "',\"rolId\"=" + this.rol.getId() + "\n"
                    + "	WHERE \"entidadId\"=" + Integer.parseInt(idEntidad) + ";";
            resultado = conDB.hacerConsultaIUD(query);
        } else {
            resultado = 2;
        }

        return resultado;
    }

    //TODO: Borrar entidad. Discutir si se da de baja o se agrega la baja Logica
    public int BorrarEntidad(String id) {
//        Conecciones conDB = new Conecciones();
        int resultado = 0;

        return resultado;
    }

    //TODO: Cambiar el ingreso de la variable a un prepared statement
    protected static ResultSet BuscarEntidad(String nombre) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Entidad\""
                + " WHERE \"entidadNombre\" LIKE \'%" + nombre + "\'"
                + " ORDER BY \"entidadNombre\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    public void BuscarEntidadNombre(String nombre) {

        Rol unRol = new Rol();

        try {
            ResultSet rs = BuscarEntidad(nombre);
            while (rs.next()) {
                unRol.setDescripcion(unRol.getRolDB(rs.getInt("rolId")));
                unRol.setId(rs.getInt(3));
                this.setRol(unRol);
                this.setEntidadId(rs.getInt("entidadId"));
                this.setContrasenia(rs.getString(3));
                this.setNombreEntidad(rs.getString(2));
            }
            rs.close();
        } catch (SQLException ex) {

        }

    }

    public void buscarEntidadId(int id) {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        Rol unRol = new Rol();

        String query = "SELECT * FROM \"SysmanexSch1\".\"Entidad\""
                + " WHERE \"entidadId\" = " + id;
        try {
            rs = conDB.hacerConsulta(query);
            while (rs.next()) {
                unRol.setDescripcion(unRol.getRolDB(rs.getInt("rolId")));
                unRol.setId(rs.getInt("rolId"));
                this.setRol(unRol);
                this.setEntidadId(rs.getInt("entidadId"));
                this.setContrasenia(rs.getString(3));
                this.setNombreEntidad(rs.getString(2));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(Entidad.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static String buscarEntidad(int id) {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String nombreEntidad = "";
        String query = "SELECT \"entidadNombre\" FROM \"SysmanexSch1\".\"Entidad\""
                + " WHERE \"entidadId\" = " + id;
        try {
            rs = conDB.hacerConsulta(query);
            while (rs.next()) {
                nombreEntidad = rs.getString(1);
            }
            rs.close();
        } catch (SQLException ex) {
            return "";
        }
        return nombreEntidad;
    }

    protected static ResultSet BuscarEntidades() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Entidad\""
                + " ORDER BY \"entidadNombre\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    public int enviarExpediente(String expedienteNumero, Entidad destino, int idMotivo, String obs) {
        Conecciones conDB = new Conecciones();
        int resultado;

        String query = "INSERT INTO \"SysmanexSch1\".\"ExpedienteEntidad\""
                + "(\"ExpedienteNumero\",\"idEntidad\", \"ExpedienteEntidadFechaEnvio\", \"ExpedienteEntidadFechaRecibido\", \"ExpedienteMotivoId\",\"ExpedienteEntidadObservacion\",\"ExpedienteEstadoId\")"
                + "	VALUES"
                + "('" + expedienteNumero + "'," + destino.getEntidadId() + ",null,CURRENT_DATE," + idMotivo + ",'" + obs + "',2)";
        try {
            resultado = conDB.hacerConsultaIUD(query);
        } catch (SQLException ex) {
            resultado = 2;
        }
        return resultado;

    }

    public int reEnviarExpediente(String expedienteNumero, Entidad destino, int idMotivo, String obs) {
        Conecciones conDB = new Conecciones();
        int resultado;
        String query1 = "UPDATE \"SysmanexSch1\".\"ExpedienteEntidad\"\n"
                + "SET \"ExpedienteEntidadFechaEnvio\" = CURRENT_DATE, \"ExpedienteEstadoId\"=6\n"
                + "WHERE \"ExpedienteNumero\" = '" + expedienteNumero + "'\n"
                + "AND \"idEntidad\" = " + this.getEntidadId() + "\n"
                + "AND \"ExpedienteEntidadFechaRecibido\" = (SELECT MIN(\"ExpedienteEntidadFechaRecibido\")\n"
                + "	FROM \"SysmanexSch1\".\"ExpedienteEntidad\"\n"
                + "    WHERE \"ExpedienteNumero\" = '" + expedienteNumero + "'\n"
                + "	AND \"idEntidad\" = " + this.getEntidadId() + ")";
        String query = "INSERT INTO \"SysmanexSch1\".\"ExpedienteEntidad\""
                + "(\"ExpedienteNumero\",\"idEntidad\", \"ExpedienteEntidadFechaEnvio\", \"ExpedienteEntidadFechaRecibido\", \"ExpedienteMotivoId\",\"ExpedienteEntidadObservacion\",\"ExpedienteEstadoId\")"
                + "	VALUES"
                + "('" + expedienteNumero + "'," + destino.getEntidadId() + ",null,CURRENT_DATE," + idMotivo + ",'" + obs + "',2)";
        try {
            resultado = conDB.hacerConsultaIUD(query1);
            if (resultado == 1) {
                resultado = conDB.hacerConsultaIUD(query);
            }
        } catch (SQLException ex) {
            resultado = 2;
        }
        return resultado;

    }

    public int queSoy() {
        UnidadArmada uni = new UnidadArmada();
        int soyUni = uni.BuscarUnidadEntidadId(this.getEntidadId());
        if (soyUni == 1) {
            return 1;
        } else {
            return 2;
        }
    }

    public ResultSet ExpedientesRecibidos() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT e.\"expedienteNumero\",e.\"expedienteAsunto\", t.\"tramiteNombre\", e.\"expedienteEntidadId\", t.\"tramitePlazo\"-(CURRENT_DATE - ee.\"ExpedienteEntidadFechaRecibido\") as restante, es.\"estadoDescripcion\"\n"
                + "FROM \"SysmanexSch1\".\"Expediente\" e, \"SysmanexSch1\".\"Tramite\" t, \"SysmanexSch1\".\"ExpedienteEntidad\" ee, \"SysmanexSch1\".\"Estado\" es\n"
                + "WHERE e.\"expedienteNumero\" = ee.\"ExpedienteNumero\"\n"
                + "AND es.\"estadoId\" = ee.\"ExpedienteEstadoId\"\n"
                + "AND e.\"expedienteTramiteId\" = t.\"tramiteId\"\n"
                + "AND ee.\"idEntidad\" =" + this.getEntidadId()
                + " ORDER BY CASE es.\"estadoId\" WHEN 1 THEN 2\n"
                + "WHEN 2 THEN 1\n"
                + "WHEN 3 THEN 5\n"
                + "WHEN 4 THEN 4\n"
                + "WHEN 5 THEN 3\n"
                + "END\n"
                + "ASC";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    public String tablaTramitados(String exp) {

        Expediente unExpediente = new Expediente();
        unExpediente.traerExpediente(exp);
        ResultSet rs2 = unExpediente.ExpedienteTramitado();
        String tabla = "";
        try {
            if (rs2 != null && rs2.next()) {
                tabla += "<table class=\"table table-striped\"><tr><th>"
                        + "Destino Actual</th><th>Fecha de Envio</th><th>Motivo</th><th>Observacion</th><th>Estado</th></tr>";
                rs2.beforeFirst();
                while (rs2.next()) {
                    String destinatario = "";
                    Entidad unaEntidad = new Entidad();
                    unaEntidad.buscarEntidadId(rs2.getInt("idEntidad"));
                    if (unaEntidad.queSoy() == 2) {
                        Persona unaPersona = new Persona();
                        unaPersona.BuscarPersonaPorId(unaEntidad.getEntidadId());
                        destinatario = unaPersona.getNombrePersona() + " " + unaPersona.getApellidoPersona();
                    } else {
                        UnidadArmada unaUnidad = new UnidadArmada();
                        unaUnidad.BuscarUnidadEntidadId(unaEntidad.getEntidadId());
                        destinatario = unaUnidad.getSigla();
                    }
                    tabla += "<tr><td>" + destinatario + "</td><td>" + rs2.getString("ExpedienteEntidadFechaRecibido") + "</td><td>" + rs2.getString("motivoDescripcion")
                            + "</td><td>" + rs2.getString("ExpedienteEntidadObservacion") + "</td><td>" + rs2.getString("estadoDescripcion")
                            + "</td></tr>";
                }
                rs2.close();
                if (!tabla.equals("<td><button id=\"m" + exp + "\"  onclick=\"mostrar(" + exp + ");\" class=\"btn glyphicon glyphicon-triangle-bottom\"></button>"
                        + "<button id=\"o" + exp + "\"  class=\" btn glyphicon glyphicon-triangle-top\" style=\"display: none;\" onclick=\"ocultar(" + exp + ");\"></button></td></tr>"
                        + "<tr><td colspan=\"5\" id=\"oculto" + exp + "\" name=\"oculto\"><table class=\"table table-striped\"><tr><th>"
                        + "Origen</th><th>Fecha de Envio</th><th>Motivo</th><th>Observacion</th><th>Estado</th></tr>")) {
                    tabla += "</table>";
                }
            }
        } catch (SQLException ex) {
            return tabla;
        }
        return tabla;
    }

    public String getLastExpediente() {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT \"expedienteNumero\" \n"
                + "FROM \"SysmanexSch1\".\"Expediente\"\n"
                + "WHERE \"expedienteNumero\" LIKE concat(EXTRACT(YEAR FROM now()),'"+this.getEntidadIdLargo()+"%')\n"
                + "ORDER BY \"expedienteNumero\" DESC\n"
                + "LIMIT 1";
        try {
            rs = conDB.hacerConsulta(query);
            int numeroInt = -1;
            while(rs.next()){
                String numero = rs.getString("expedienteNumero");
                String numeroSub = numero.substring(numero.length() - 5);
                numeroInt = Integer.parseInt(numeroSub);
                numeroInt++;
            }
            if(numeroInt != -1)
                return Integer.toString(numeroInt);
            else
                return "";            
        } catch (SQLException ex) {
            return "";
        }

    }

}
