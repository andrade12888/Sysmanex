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
 * @author sg0891660
 */
public class PersonaTest {
    
    public PersonaTest() {
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

    @Test
    public void testAgregarPersona() {
        System.out.println("AgregarPersona");
        Persona instance = new Persona("91827364", "Pablo", "Almeida");
        int expResult = 0;
        int result = instance.AgregarPersona();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarPersona method, of class Persona.
     */
    @Test
    public void testModificarPersona() {
        System.out.println("ModificarPersona");
        String ciPersona = "";
        Persona instance = null;
        int expResult = 0;
        int result = instance.ModificarPersona(ciPersona);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BorrarPersona method, of class Persona.
     */
    @Test
    public void testBorrarPersona() {
        System.out.println("BorrarPersona");
        String ci = "";
        int expResult = 0;
        int result = Persona.BorrarPersona(ci);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarPersona method, of class Persona.
     */
    @Test
    public void testBuscarPersona() throws Exception {
        System.out.println("BuscarPersona");
        String nombre = "";
        ResultSet expResult = null;
        ResultSet result = Persona.BuscarPersona(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarPersonas method, of class Persona.
     */
    @Test
    public void testBuscarPersonas() throws Exception {
        System.out.println("BuscarPersonas");
        ResultSet expResult = null;
        ResultSet result = Persona.BuscarPersonas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
