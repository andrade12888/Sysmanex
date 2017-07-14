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
    public int AgregarUnidadUser(Entidad e) {
    
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

                if (entidadId >0)
                {       
                    // conDB.getConnect().commit();
                    //Si se agrego correctamente la entidad, agrego la persona con el id de entidad guardado
                      String queryPersona = "INSERT INTO \"SysmanexSch1\".\"Unidad\"(\"unidadSigla\", \"unidadEntidadId\")" 
                        + "   VALUES ('" + this.getSigla() + "', " + entidadId +");";                   
                    conDB.hacerConsultaIUD(queryPersona);                                

                    conDB.getConnect().commit();
                    resultado = 1;
                }

            } catch (SQLException ex) {

                if (conDB.getConnect() != null) {
                    try {
                        System.err.print("Ocurrio un error ingresando la Unidad");
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
            System.err.print("Los campos Usuraio, Contrasena, Sigla y Rol no pueden ser vacios.\n");
            resultado = 2;
        }
        return resultado;
}
    //PRE: La entidad debe existir        
    protected int AgregarUnidad() throws SQLException {
        Conecciones conDB = new Conecciones();
        int resultado = -1;
        String queryInsertUnidad = "INSERT INTO \"SysmanexSch1\".\"Unidad\"(\n"
                + "\"unidadSigla\", \"unidadEntidadId\")\n"
                + "   VALUES ('" + this.sigla + "', '" + this.getEntidadId() + "');";

        if (!"".equals(this.sigla) && !"".equals(this.getEntidadId())) {
            resultado = conDB.hacerConsultaIUD(queryInsertUnidad);

        } else {            
            resultado = 2;
        }
        return resultado;
    }

    public static ResultSet BuscarUnidades() throws SQLException {
        Conecciones conDB = new Conecciones();
        ResultSet rs;
        String query = "SELECT * FROM \"SysmanexSch1\".\"Unidad\" ORDER BY \"unidadSigla\" ASC;";
        rs = conDB.hacerConsulta(query);

        return rs;
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
            Logger.getLogger(UnidadArmada.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }

    //TODO: Delete o baja logica
    public static int BorrarUnidadArmada(String sigla) {
//        Conecciones conDB = new Conecciones();
        int resultado = 0;

        return resultado;
    }

}
