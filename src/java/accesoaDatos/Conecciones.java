/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoaDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Conecciones {

    private final String server = "jdbc:postgresql://localhost:5432/SysmanexDB2";
    private final String user = "postgres";
    private final String pass = "gabrielsebastian";
    
//    private final String server = "jdbc:postgresql://sysmanexdb2.ckaqxoyghbj6.us-west-2.rds.amazonaws.com:5400/SysmanexDB2";
//    private final String user = "SebaGabo";
//    private final String pass = "sebastiangabriel";  
    
    private static Connection conn = null;

    private Connection PostgreJDBC() {
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(server, user, pass);

        } catch (ClassNotFoundException e) {
        } catch (SQLException e) {
            System.out.println("ConnectDB " + e.getMessage());
        }
        return conn;
    }
       
    public void Disconnet() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println("ConnectDB " + ex.getMessage());
            }
        }
    }

    public Connection getConnect() {
        if (conn != null) {
            return conn;
        } else {
            return PostgreJDBC();
        }
    }

    public ResultSet hacerConsulta(String query) throws SQLException {
        Connection con = this.getConnect();
        ResultSet rs;
        try {
            Statement sta = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
            rs = sta.executeQuery(query);
            
        } catch (SQLException ex) {
          throw ex;
        }

        return rs;
    }
    
    public int hacerConsultaIUD(String query) throws SQLException {
        Connection con = this.getConnect();
        int resultado = -1;
        try {
            Statement sta = con.createStatement();
            resultado = sta.executeUpdate(query);
            
        } catch (SQLException ex) {
            throw ex;
        }

        return resultado;
    }        
    
}
