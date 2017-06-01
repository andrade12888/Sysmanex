/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SG0891660
 */
public class RolTest {
    
    public RolTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

 
    /**
     * Test of AgregarRol method, of class Rol.
     */
    @Test
    public void testAgregarRol() {
        System.out.println("AgregarRol");
        Rol instance = new Rol("UsuarioLimitado");
        int expResult = 1;
        int result = instance.AgregarRol();
        assertEquals(expResult, result);
    }    
    /**
     * Test of AgregarRol method, of class Rol. Check UNIQUE ID rolDescripcion
     */
    @Test
    public void testAgregarRolError() {
        System.out.println("AgregarRol");
        Rol instance = new Rol("UsuarioLimitado");
        int expResult = -1;
        int result = instance.AgregarRol();
        assertEquals(expResult, result);
    }
    /**
     * Test of ModificarRol method, of class Rol.
     */
    @Test
    public void testModificarRol() {
        System.out.println("ModificarRol");
        int id = 25;
        String descripcionRol = "RolLimitado";
        int expResult = 1;
        int result = Rol.ModificarRol(id, descripcionRol);
        assertEquals(expResult, result);
       
    }
    /**
     * Test of BuscarRoles method, of class Rol.
     */
    @Test
    public void testBuscarRoles() throws SQLException {
        System.out.println("BuscarRoles");
        String expResult = "Bloqueado";
        ResultSet result = Rol.BuscarRoles();
        result.next();
        String rs = result.getString("rolDescripcion");
        assertEquals(expResult, rs);
    }
}
