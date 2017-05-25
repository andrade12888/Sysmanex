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
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Usuario;

/**
 *
 * @author SG0891660
 */
public abstract class ManejadorDeConecciones {
    
    static Connection con;
    static Properties props;
    static Statement stmt;
    static ResultSet rs;

    private static Connection getCon() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "root");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    private static Connection getPostgreCon() throws SQLException, ClassNotFoundException {
        props = new Properties();
        props.setProperty("user", "postgres");
        props.setProperty("password", "gabrielsebastian");
        props.setProperty("ssl", "true");       
        String url = "jdbc:postgresql://localhost:5432/SysmanexDB1";

        Class.forName("org.postgresql.Driver");
        con = DriverManager.getConnection(url, props);

        return con;
    }
 
   private static Connection PostgreJDBC() {
   
      try {
         Class.forName("org.postgresql.Driver");
         con = DriverManager
            .getConnection("jdbc:postgresql://localhost:5432/SysmanexDB1",
            "postgres", "gabrielsebastian");
      } catch (ClassNotFoundException | SQLException e) {
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      return con;
   }

    public static ResultSet Autenticar(String userId, String password) throws ClassNotFoundException
    {
        
        try {
            stmt = PostgreJDBC().createStatement();                               
            rs = stmt.executeQuery("SELECT \"personaUsr\", \"personaPsw\" FROM \"SysmanexSch1\".\"Persona\" WHERE \"personaUsr\"=\'"+userId+"\' AND \"personaPsw\"=\'"+password+"\'; ");   
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorDeConecciones.class.getName()).log(Level.SEVERE, null,ex);      
        }
        finally
        {
       // try { rs.close(); } catch (Exception e) { /* ignored */ }
        //try { ps.close(); } catch (Exception e) { /* ignored */ }
        try { con.close(); } catch (Exception e) { /* ignored */ }
        }
       return null;
     
    }
    
    public static void CloseConnection() throws SQLException
    {
        if(con!= null)
            con.close();
        if(rs!=null)
            rs.close();
    }
        
}
