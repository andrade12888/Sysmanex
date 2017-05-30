/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
     * Test of getRolDB method, of class Rol.
     */
    @Test
    public void testGetRolDB() {
        System.out.println("getRolDB");
        int rolId = 1;
        Rol instance = new Rol();
        String expResult = "SysAdmin";
        String result = instance.getRolDB(rolId);
        assertEquals(expResult, result);

    }

    /**
     * Test of AgregarRol method, of class Rol.
     */
    @Test
    public void testAgregarRol() {
        System.out.println("AgregarRol");
        Rol instance = new Rol("TestingRol2");
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
        Rol instance = new Rol("TestingRol");
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
        int id = 8;
        String descripcionRol = "RolMod";
        int expResult = 1;
        int result = Rol.ModificarRol(id, descripcionRol);
        assertEquals(expResult, result);
       
    }
    
}
