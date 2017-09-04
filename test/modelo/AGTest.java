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
public class AGTest {
    
    public AGTest() {
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
     * Test of getRaiz method, of class AG.
     */
    @Test
    public void testGetRaiz() {
        System.out.println("getRaiz");
        AG instance = null;
        NodoAG expResult = null;
        NodoAG result = instance.getRaiz();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantHojas method, of class AG.
     */
    @Test
    public void testCantHojas() {
        System.out.println("cantHojas");
        AG instance = null;
        int expResult = 0;
        int result = instance.cantHojas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cantNodos method, of class AG.
     */
    @Test
    public void testCantNodos() {
        System.out.println("cantNodos");
        AG instance = null;
        int expResult = 0;
        int result = instance.cantNodos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of altura method, of class AG.
     */
    @Test
    public void testAltura() {
        System.out.println("altura");
        AG instance = null;
        int expResult = 0;
        int result = instance.altura();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscar method, of class AG.
     */
    @Test
    public void testBuscar() {
        System.out.println("buscar");
        int id = 0;
        AG instance = null;
        NodoAG expResult = null;
        NodoAG result = instance.buscar(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertarVago method, of class AG.
     */
    @Test
    public void testInsertarVago() {
        System.out.println("insertarVago");
        int padre = 0;
        int id = 0;
        String dato = "";
        AG instance = null;
        instance.insertarVago(padre, id, dato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertar method, of class AG.
     */
    @Test
    public void testInsertar() {
        System.out.println("insertar");
        int padre = 0;
        int id = 0;
        String dato = "";
        AG instance = null;
        instance.insertar(padre, id, dato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrar method, of class AG.
     */
    @Test
    public void testMostrar() {
        System.out.println("mostrar");
        AG instance = null;
        String expResult = "";
        String result = instance.mostrar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
