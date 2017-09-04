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

    /**
     * Test of getCiPersona method, of class Persona.
     */
    @Test
    public void testGetCiPersona() {
        System.out.println("getCiPersona");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getCiPersona();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCiPersona method, of class Persona.
     */
    @Test
    public void testSetCiPersona() {
        System.out.println("setCiPersona");
        String ciPersona = "";
        Persona instance = new Persona();
        instance.setCiPersona(ciPersona);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getApellidoPersona method, of class Persona.
     */
    @Test
    public void testGetApellidoPersona() {
        System.out.println("getApellidoPersona");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getApellidoPersona();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setApellidoPersona method, of class Persona.
     */
    @Test
    public void testSetApellidoPersona() {
        System.out.println("setApellidoPersona");
        String apellidoPersona = "";
        Persona instance = new Persona();
        instance.setApellidoPersona(apellidoPersona);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombrePersona method, of class Persona.
     */
    @Test
    public void testGetNombrePersona() {
        System.out.println("getNombrePersona");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getNombrePersona();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombrePersona method, of class Persona.
     */
    @Test
    public void testSetNombrePersona() {
        System.out.println("setNombrePersona");
        String nombrePersona = "";
        Persona instance = new Persona();
        instance.setNombrePersona(nombrePersona);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEmailPersona method, of class Persona.
     */
    @Test
    public void testGetEmailPersona() {
        System.out.println("getEmailPersona");
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.getEmailPersona();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEmailPersona method, of class Persona.
     */
    @Test
    public void testSetEmailPersona() {
        System.out.println("setEmailPersona");
        String emailPersona = "";
        Persona instance = new Persona();
        instance.setEmailPersona(emailPersona);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarPersona method, of class Persona.
     */
    @Test
    public void testAgregarPersona() {
        System.out.println("AgregarPersona");
        int entidadDePersona = 0;
        Persona instance = new Persona();
        int expResult = 0;
        int result = instance.AgregarPersona(entidadDePersona);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarPersonaEnUnidad method, of class Persona.
     */
    @Test
    public void testAgregarPersonaEnUnidad() {
        System.out.println("AgregarPersonaEnUnidad");
        int unidadId = 0;
        Persona instance = new Persona();
        int expResult = 0;
        int result = instance.AgregarPersonaEnUnidad(unidadId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarPersonaEnEmpresa method, of class Persona.
     */
    @Test
    public void testAgregarPersonaEnEmpresa() {
        System.out.println("AgregarPersonaEnEmpresa");
        String rutEmpresa = "";
        Persona instance = new Persona();
        int expResult = 0;
        int result = instance.AgregarPersonaEnEmpresa(rutEmpresa);
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
     * Test of ModificarPersona method, of class Persona.
     */
    @Test
    public void testModificarPersona() {
        System.out.println("ModificarPersona");
        String ciPersona = "";
        Persona instance = new Persona();
        int expResult = 0;
        int result = instance.ModificarPersona(ciPersona);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarPersonaPorNombre method, of class Persona.
     */
    @Test
    public void testBuscarPersonaPorNombre() {
        System.out.println("BuscarPersonaPorNombre");
        String nombre = "";
        Persona instance = new Persona();
        instance.BuscarPersonaPorNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarPersonaPorId method, of class Persona.
     */
    @Test
    public void testBuscarPersonaPorId() {
        System.out.println("BuscarPersonaPorId");
        int id = 0;
        Persona instance = new Persona();
        instance.BuscarPersonaPorId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarPersonaPorCedula method, of class Persona.
     */
    @Test
    public void testBuscarPersonaPorCedula() {
        System.out.println("BuscarPersonaPorCedula");
        String ci = "";
        Persona expResult = null;
        Persona result = Persona.BuscarPersonaPorCedula(ci);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarPersonas method, of class Persona.
     */
    @Test
    public void testBuscarPersonas() {
        System.out.println("BuscarPersonas");
        ResultSet expResult = null;
        ResultSet result = Persona.BuscarPersonas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TablaPersonas method, of class Persona.
     */
    @Test
    public void testTablaPersonas() {
        System.out.println("TablaPersonas");
        int Id = 0;
        Persona instance = new Persona();
        String expResult = "";
        String result = instance.TablaPersonas(Id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
