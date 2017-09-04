/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoaDatos;

import java.sql.Connection;
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
public class ConeccionesTest {
    
    public ConeccionesTest() {
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
     * Test of Disconnet method, of class Conecciones.
     */
    @Test
    public void testDisconnet() {
        System.out.println("Disconnet");
        Conecciones instance = new Conecciones();
        instance.Disconnet();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getConnect method, of class Conecciones.
     */
    @Test
    public void testGetConnect() {
        System.out.println("getConnect");
        Conecciones instance = new Conecciones();
        Connection expResult = null;
        Connection result = instance.getConnect();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hacerConsulta method, of class Conecciones.
     */
    @Test
    public void testHacerConsulta() throws Exception {
        System.out.println("hacerConsulta");
        String query = "";
        Conecciones instance = new Conecciones();
        ResultSet expResult = null;
        ResultSet result = instance.hacerConsulta(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hacerConsultaIUD method, of class Conecciones.
     */
    @Test
    public void testHacerConsultaIUD() throws Exception {
        System.out.println("hacerConsultaIUD");
        String query = "";
        Conecciones instance = new Conecciones();
        int expResult = 0;
        int result = instance.hacerConsultaIUD(query);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
