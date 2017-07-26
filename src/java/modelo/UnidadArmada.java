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
    private int unidadId;

    public UnidadArmada() {
    }

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
    
  
    //Segun lo enviado desde el form, Unidad debe :
    //1: Agregar entidad(user)
    //2: Agregar unidad con el id de Entiad que capturo del insert anterior
    //3: Agregar en UnidadArmada dicho user 
    
    //TODO: Se puede devolver un numero diferente para cada transsaccion que falle
    //TODO: Como llegan los valores, por parametros o por objetos?
    
    //PRE: La unidad existe dado que viene del Form
    //POST: Si lo que intento agregar es una persona en una nueva unidad ejecuta : Agregar Entidad, Agregar Persona, Agregar Unidad y Agregar UnidadTienePersona
    
    public int AgregarUnidadUserPersona(Entidad e, Persona p) {
    
    Conecciones conDB = new Conecciones();
    int resultado =-1;

        //Controlo que los valores necesario para inrgesar una persona no sean vacios
        if (!"".equals(this.getSigla())) 
        {                     
            try {
                //Seteo autocommit false para que todo se ejecute como una transaccion
                conDB.getConnect().setAutoCommit(false);
            
                //Me quedo con el id de entidad si se ejecuto correctamente
                int entidadId = e.AgregarEntidad();
                e.setEntidadId(entidadId);
                
                if(entidadId == 23503)
                    return entidadId;
//TODO: VERIFICAR VALOR DE RETORNO
                if (entidadId >0)
                {                          
                   this.setEntidadId(entidadId);
                   //Agrego la Unidad
                   int unidad =AgregarUnidad();
                   this.setUnidadId(unidad);                        
                   //Ingreso la persona si es necesario
                   if(p!=null && unidad >0)
                   {
                    //Ingreso la Persona asociada
                     p.AgregarPersona(e.getEntidadId());
                     //ingreso la persona a la unidad
                     this.AgregarPersonaEnUnidad(p.getCiPersona());                     
                   }
                   

                   //Una Vez que todo se ejecuta correctamente hago el commit                  
                    conDB.getConnect().commit();
                    resultado = 1;
                }

            } catch (SQLException ex) {

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
            resultado = 2;
        }
        return resultado;
}
    //PRE: La entidad debe existir        
    private int AgregarUnidad() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        int resultado =-1;
        String queryInsertUnidad = "INSERT INTO \"SysmanexSch1\".\"Unidad\"(\n"
                + "\"unidadSigla\", \"unidadEntidadId\")\n"
                + "   VALUES ('" + this.sigla + "', " + this.getEntidadId() + ") RETURNING \"unidadId\";";

        if (!"".equals(this.sigla) && !"".equals(this.getEntidadId())) {
            rs = conDB.hacerConsulta(queryInsertUnidad);
            rs.next();
            resultado = Integer.parseInt(rs.getString("unidadId"));

        } else {            
            resultado = 2;
        }
        return resultado;
    }
    
    private int AgregarPersonaEnUnidad(String ciPersona) throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado = -1;                       
        String queryPersonaEnUnidad = "INSERT INTO \"SysmanexSch1\".\"UnidadTienePersona\"(\n"
                    + "\"unidadId\", \"personaCi\")\n"
                    + "   VALUES ('" + this.getUnidadId() + "', " +ciPersona+");";                     

        if (!"".equals(this.sigla) && !"".equals(this.getEntidadId())) {
            try {
                resultado = conDB.hacerConsultaIUD(queryPersonaEnUnidad);
            } catch (SQLException ex) {
                throw ex;
            }

        } else {            
            resultado = 2;
        }
        return resultado;
    }

    public static ResultSet BuscarUnidades() {
        try {
            Conecciones conDB = new Conecciones();
            ResultSet rs;
            String query = "SELECT * FROM \"SysmanexSch1\".\"Unidad\" ORDER BY \"unidadSigla\" ASC;";
            rs = conDB.hacerConsulta(query);
            
            return rs;
        } catch (SQLException ex) {
           return null;
        }
    }

    public static ResultSet BuscarUnidadPorNombre(String nombre) throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String query = "SELECT * FROM \"SysmanexSch1\".\"Unidad\""
                + " WHERE \"unidadSigla\" LIKE \'%" + nombre + "\'"
                + " ORDER BY \"unidadSigla\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
    }

    public static ResultSet BuscarUnidadPorEntidadId(int entidad) {
        Conecciones conDB = new Conecciones();
        ResultSet rs;

        String query = "SELECT * FROM \"SysmanexSch1\".\"Unidad\""
                + " WHERE \"unidadEntidadId\" = " + entidad + ";";
        try {
            rs = conDB.hacerConsulta(query);
            return rs;
        } catch (SQLException ex) {
            return null;
        }
    }

    public int BuscarUnidadPorId(int unidad) {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        int resultado = 0;
        String query = "SELECT * FROM \"SysmanexSch1\".\"Unidad\""
                + " WHERE \"unidadId\" = " + unidad + ";";
        try {
            rs = conDB.hacerConsulta(query);
            while (rs.next()) {
                this.setEntidadId(rs.getInt("unidadEntidadId"));
                this.setSigla(rs.getString("unidadSigla"));
                resultado = 1;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UnidadArmada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public int BuscarUnidadEntidadId(int id) {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        int resultado = 0;
        String query = "SELECT * FROM \"SysmanexSch1\".\"Unidad\""
                + " WHERE \"unidadEntidadId\" = " + id + ";";
        try {
            rs = conDB.hacerConsulta(query);
            while (rs.next()) {
                this.setEntidadId(rs.getInt("unidadEntidadId"));
                this.setSigla(rs.getString("unidadSigla"));
                resultado = 1;
            }
            
        } catch (SQLException ex) {
            return -1;
        }
        return resultado;
    }
   
    public static int BorrarUnidadArmada(int unidadId) {
        Conecciones conDB = new Conecciones();
        int resultado;

         if (unidadId>0) {
            try {
                String query = "DELETE FROM \"SysmanexSch1\".\"Unidad\" WHERE \"unidadId\" = "+unidadId+";";
                resultado = conDB.hacerConsultaIUD(query);
            } catch (SQLException ex) {
               if("23503".equalsIgnoreCase(ex.getSQLState()))
                return Integer.parseInt(ex.getSQLState());
            return -1;
            }
        } else {
            resultado = 2;
        }
        
        return resultado;
    }
    
    public static int ModificarUnidadArmada(int unidadId, String unidadNombre) {
        Conecciones conDB = new Conecciones();
        int resultado;

        String query = "UPDATE \"SysmanexSch1\".\"Unidad\""
                + " SET \"unidadSigla\" = '"+unidadNombre+"'"
                + "WHERE \"unidadId\" = '"+unidadId+"';";
        try {
            resultado = conDB.hacerConsultaIUD(query);
        } catch (SQLException ex) {
            if("23503".equalsIgnoreCase(ex.getSQLState()))
                return Integer.parseInt(ex.getSQLState());
            return -1;
        }       
        return resultado;
    }
    
    public String TablaUnidades() 
    {
        try {
            ResultSet rs = BuscarUnidades();
            
            String tabla = "<form name=\"frmBorrar\" action=\"CUsuarios.do\" method=\"POST\">"
                    + "<table class=\"table table-striped\">"
                    + "<th>Unidades</th>" 
                    + "<th>Entidad</th>" 
                    + "<th>Opciones</th>";
            if(rs!=null)
            {
                while (rs.next()) {
                    tabla += "<tr><td><input type=\"hidden\" id=\"id" + rs.getInt("unidadId") + "\" name=\"txtIdUnidad\" value=\"" + rs.getInt("unidadId") + "\">"
                            + "<span id=\"tdd" + rs.getInt("unidadId") + "\">" + rs.getString("unidadSigla") + "</span></td>"
                            + "<td><span id=\"entidad"+ rs.getInt("unidadId") +"\">" + buscarEntidad(rs.getInt("unidadId")) + "</span></td>"                            
                            + "<td><button onclick=\"modalUnidades(" + rs.getInt("unidadId") + ")\" id=\"" + rs.getInt("unidadId") + "\" "
                            + "type=\"button\" class=\"btn glyphicon glyphicon-pencil\" data-toggle=\"modal\" data-target=\"#myModal\">\n"
                            + "</button><button name=\"btnUnidad\" value=\"Delete\" type=\"submit\" class=\"btn glyphicon glyphicon-trash\"></button></td>";
                }                
            }    
            tabla += "</table></form>";
            return tabla;
        } catch (SQLException ex) {
            return "";
        }
    }

    /**
     * @return the unidadId
     */
    public int getUnidadId() {
        return unidadId;
    }

    /**
     * @param unidadId the unidadId to set
     */
    public void setUnidadId(int unidadId) {
        this.unidadId = unidadId;
    }

}
