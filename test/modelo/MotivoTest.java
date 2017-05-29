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
public class MotivoTest {
    
    public MotivoTest() {
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
     * Test of getMotivoId method, of class Motivo.
     */
    @Test
    public void testGetMotivoId() {
        System.out.println("getMotivoId");
        Motivo instance = null;
        int expResult = 0;
        int result = instance.getMotivoId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMotivoId method, of class Motivo.
     */
    @Test
    public void testSetMotivoId() {
        System.out.println("setMotivoId");
        int motivoId = 0;
        Motivo instance = null;
        instance.setMotivoId(motivoId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMotivoDescripcion method, of class Motivo.
     */
    @Test
    public void testGetMotivoDescripcion() {
        System.out.println("getMotivoDescripcion");
        Motivo instance = null;
        String expResult = "";
        String result = instance.getMotivoDescripcion();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMotivoDescripcion method, of class Motivo.
     */
    @Test
    public void testSetMotivoDescripcion() {
        System.out.println("setMotivoDescripcion");
        String motivoDescripcion = "";
        Motivo instance = null;
        instance.setMotivoDescripcion(motivoDescripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
