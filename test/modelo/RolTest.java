/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
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
     * Test of getId method, of class Rol.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Rol instance = new Rol();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Rol.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Rol instance = new Rol();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcion method, of class Rol.
     */
    @Test
    public void testGetDescripcion() {
        System.out.println("getDescripcion");
        Rol instance = new Rol();
        String expResult = "";
        String result = instance.getDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcion method, of class Rol.
     */
    @Test
    public void testSetDescripcion() {
        System.out.println("setDescripcion");
        String descripcion = "";
        Rol instance = new Rol();
        instance.setDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRolDB method, of class Rol.
     */
    @Test
    public void testGetRolDB() {
        System.out.println("getRolDB");
        int rolId = 0;
        Rol instance = new Rol();
        String expResult = "";
        String result = instance.getRolDB(rolId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarRol method, of class Rol.
     */
    @Test
    public void testAgregarRol() throws Exception {
        System.out.println("AgregarRol");
        Rol instance = new Rol();
        int expResult = 0;
        int result = instance.AgregarRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarRol method, of class Rol.
     */
    @Test
    public void testModificarRol() throws Exception {
        System.out.println("ModificarRol");
        int id = 0;
        String descripcionRol = "";
        int expResult = 0;
        int result = Rol.ModificarRol(id, descripcionRol);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarRoles method, of class Rol.
     */
    @Test
    public void testBuscarRoles() {
        System.out.println("BuscarRoles");
        ResultSet expResult = null;
        ResultSet result = Rol.BuscarRoles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
