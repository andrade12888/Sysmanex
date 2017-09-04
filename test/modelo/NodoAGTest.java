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
public class NodoAGTest {
    
    public NodoAGTest() {
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
     * Test of getId method, of class NodoAG.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        NodoAG instance = null;
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDato method, of class NodoAG.
     */
    @Test
    public void testGetDato() {
        System.out.println("getDato");
        NodoAG instance = null;
        String expResult = "";
        String result = instance.getDato();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDato method, of class NodoAG.
     */
    @Test
    public void testSetDato() {
        System.out.println("setDato");
        String dato = "";
        NodoAG instance = null;
        instance.setDato(dato);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class NodoAG.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        NodoAG instance = null;
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHijo method, of class NodoAG.
     */
    @Test
    public void testGetHijo() {
        System.out.println("getHijo");
        NodoAG instance = null;
        NodoAG expResult = null;
        NodoAG result = instance.getHijo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHijo method, of class NodoAG.
     */
    @Test
    public void testSetHijo() {
        System.out.println("setHijo");
        NodoAG hijo = null;
        NodoAG instance = null;
        instance.setHijo(hijo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHermano method, of class NodoAG.
     */
    @Test
    public void testGetHermano() {
        System.out.println("getHermano");
        NodoAG instance = null;
        NodoAG expResult = null;
        NodoAG result = instance.getHermano();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHermano method, of class NodoAG.
     */
    @Test
    public void testSetHermano() {
        System.out.println("setHermano");
        NodoAG hermano = null;
        NodoAG instance = null;
        instance.setHermano(hermano);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class NodoAG.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        NodoAG instance = null;
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
