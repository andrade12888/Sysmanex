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
public class EntidadTest {
    
    public EntidadTest() {
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
     * Test of getNombre method, of class Entidad.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Entidad instance = new Entidad();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Entidad.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Entidad instance = new Entidad();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContrasenia method, of class Entidad.
     */
    @Test
    public void testGetContrasenia() {
        System.out.println("getContrasenia");
        Entidad instance = new Entidad();
        String expResult = "";
        String result = instance.getContrasenia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContrasenia method, of class Entidad.
     */
    @Test
    public void testSetContrasenia() {
        System.out.println("setContrasenia");
        String contrasenia = "";
        Entidad instance = new Entidad();
        instance.setContrasenia(contrasenia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class Entidad.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Entidad instance = new Entidad();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRol method, of class Entidad.
     */
    @Test
    public void testGetRol() {
        System.out.println("getRol");
        Entidad instance = new Entidad();
        Rol expResult = null;
        Rol result = instance.getRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRol method, of class Entidad.
     */
    @Test
    public void testSetRol() {
        System.out.println("setRol");
        Rol rol = null;
        Entidad instance = new Entidad();
        instance.setRol(rol);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Autenticar method, of class Entidad.
     */
    @Test
    public void testAutenticar() throws Exception {
        System.out.println("Autenticar");
        String userId = "";
        String password = "";
        Entidad instance = new Entidad();
        int expResult = 0;
        int result = instance.Autenticar(userId, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
