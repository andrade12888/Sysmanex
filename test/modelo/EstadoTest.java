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
public class EstadoTest {
    
    public EstadoTest() {
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
     * Test of getIdEstado method, of class Estado.
     */
    @Test
    public void testGetIdEstado() {
        System.out.println("getIdEstado");
        Estado instance = null;
        int expResult = 0;
        int result = instance.getIdEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdEstado method, of class Estado.
     */
    @Test
    public void testSetIdEstado() {
        System.out.println("setIdEstado");
        int idEstado = 0;
        Estado instance = null;
        instance.setIdEstado(idEstado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescripcionEstado method, of class Estado.
     */
    @Test
    public void testGetDescripcionEstado() {
        System.out.println("getDescripcionEstado");
        Estado instance = null;
        String expResult = "";
        String result = instance.getDescripcionEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescripcionEstado method, of class Estado.
     */
    @Test
    public void testSetDescripcionEstado() {
        System.out.println("setDescripcionEstado");
        String descripcionEstado = "";
        Estado instance = null;
        instance.setDescripcionEstado(descripcionEstado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
