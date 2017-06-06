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
public class FormularioTest {
    
    public FormularioTest() {
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
     * Test of getNombreFormulario method, of class Formulario.
     */
    @Test
    public void testGetNombreFormulario() {
        System.out.println("getNombreFormulario");
        Formulario instance = null;
        String expResult = "";
        String result = instance.getNombreFormulario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreFormulario method, of class Formulario.
     */
    @Test
    public void testSetNombreFormulario() {
        System.out.println("setNombreFormulario");
        String nombreFormulario = "";
        Formulario instance = null;
        instance.setNombreFormulario(nombreFormulario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRutaRormulario method, of class Formulario.
     */
    @Test
    public void testGetRutaRormulario() {
        System.out.println("getRutaRormulario");
        Formulario instance = null;
        String expResult = "";
        String result = instance.getRutaRormulario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRutaRormulario method, of class Formulario.
     */
    @Test
    public void testSetRutaRormulario() {
        System.out.println("setRutaRormulario");
        String rutaRormulario = "";
        Formulario instance = null;
        instance.setRutaRormulario(rutaRormulario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaCreacionFormulario method, of class Formulario.
     */
    @Test
    public void testGetFechaCreacionFormulario() {
        System.out.println("getFechaCreacionFormulario");
        Formulario instance = null;
        String expResult = "";
        String result = instance.getFechaCreacionFormulario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaCreacionFormulario method, of class Formulario.
     */
    @Test
    public void testSetFechaCreacionFormulario() {
        System.out.println("setFechaCreacionFormulario");
        String fechaCreacionFormulario = "";
        Formulario instance = null;
        instance.setFechaCreacionFormulario(fechaCreacionFormulario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreadorFormulario method, of class Formulario.
     */
    @Test
    public void testGetCreadorFormulario() {
        System.out.println("getCreadorFormulario");
        Formulario instance = null;
        Persona expResult = null;
        Persona result = instance.getCreadorFormulario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreadorFormulario method, of class Formulario.
     */
    @Test
    public void testSetCreadorFormulario() {
        System.out.println("setCreadorFormulario");
        Persona creadorFormulario = null;
        Formulario instance = null;
        instance.setCreadorFormulario(creadorFormulario);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFormulario method, of class Formulario.
     */
    @Test
    public void testGetFormulario() {
        System.out.println("getFormulario");
        String nombreFormulario = "";
        String expResult = "";
        String result = Formulario.getFormulario(nombreFormulario);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarFormularios method, of class Formulario.
     */
    @Test
    public void testBuscarFormularios() {
        System.out.println("BuscarFormularios");
        ResultSet expResult = null;
        ResultSet result = Formulario.BuscarFormularios();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarFormulario method, of class Formulario.
     */
    @Test
    public void testAgregarFormulario() {
        System.out.println("AgregarFormulario");
        Formulario instance = null;
        int expResult = 0;
        int result = instance.AgregarFormulario();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
