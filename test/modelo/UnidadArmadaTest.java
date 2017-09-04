/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.util.ArrayList;
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
public class UnidadArmadaTest {
    
    public UnidadArmadaTest() {
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
     * Test of getPersonas method, of class UnidadArmada.
     */
    @Test
    public void testGetPersonas() {
        System.out.println("getPersonas");
        UnidadArmada instance = new UnidadArmada();
        ArrayList<Persona> expResult = null;
        ArrayList<Persona> result = instance.getPersonas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPersonas method, of class UnidadArmada.
     */
    @Test
    public void testSetPersonas() {
        System.out.println("setPersonas");
        ArrayList<Persona> personas = null;
        UnidadArmada instance = new UnidadArmada();
        instance.setPersonas(personas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSigla method, of class UnidadArmada.
     */
    @Test
    public void testGetSigla() {
        System.out.println("getSigla");
        UnidadArmada instance = new UnidadArmada();
        String expResult = "";
        String result = instance.getSigla();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSigla method, of class UnidadArmada.
     */
    @Test
    public void testSetSigla() {
        System.out.println("setSigla");
        String sigla = "";
        UnidadArmada instance = new UnidadArmada();
        instance.setSigla(sigla);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarUnidadUserPersona method, of class UnidadArmada.
     */
    @Test
    public void testAgregarUnidadUserPersona() {
        System.out.println("AgregarUnidadUserPersona");
        Entidad e = null;
        Persona p = null;
        UnidadArmada instance = new UnidadArmada();
        int expResult = 0;
        int result = instance.AgregarUnidadUserPersona(e, p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarUnidades method, of class UnidadArmada.
     */
    @Test
    public void testBuscarUnidades() {
        System.out.println("BuscarUnidades");
        ResultSet expResult = null;
        ResultSet result = UnidadArmada.BuscarUnidades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarUnidadPorNombre method, of class UnidadArmada.
     */
    @Test
    public void testBuscarUnidadPorNombre() {
        System.out.println("BuscarUnidadPorNombre");
        String nombre = "";
        ResultSet expResult = null;
        ResultSet result = UnidadArmada.BuscarUnidadPorNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarUnidadPorEntidadId method, of class UnidadArmada.
     */
    @Test
    public void testBuscarUnidadPorEntidadId() {
        System.out.println("BuscarUnidadPorEntidadId");
        int entidad = 0;
        ResultSet expResult = null;
        ResultSet result = UnidadArmada.BuscarUnidadPorEntidadId(entidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarUnidadPorId method, of class UnidadArmada.
     */
    @Test
    public void testBuscarUnidadPorId() {
        System.out.println("BuscarUnidadPorId");
        int unidad = 0;
        UnidadArmada instance = new UnidadArmada();
        int expResult = 0;
        int result = instance.BuscarUnidadPorId(unidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarUnidadEntidadId method, of class UnidadArmada.
     */
    @Test
    public void testBuscarUnidadEntidadId() {
        System.out.println("BuscarUnidadEntidadId");
        int id = 0;
        UnidadArmada instance = new UnidadArmada();
        int expResult = 0;
        int result = instance.BuscarUnidadEntidadId(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BorrarUnidadArmada method, of class UnidadArmada.
     */
    @Test
    public void testBorrarUnidadArmada() {
        System.out.println("BorrarUnidadArmada");
        int unidadEntidadId = 0;
        int expResult = 0;
        int result = UnidadArmada.BorrarUnidadArmada(unidadEntidadId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarUnidadArmada method, of class UnidadArmada.
     */
    @Test
    public void testModificarUnidadArmada() {
        System.out.println("ModificarUnidadArmada");
        int unidadId = 0;
        String unidadNombre = "";
        int expResult = 0;
        int result = UnidadArmada.ModificarUnidadArmada(unidadId, unidadNombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TablaUnidades method, of class UnidadArmada.
     */
    @Test
    public void testTablaUnidades() {
        System.out.println("TablaUnidades");
        UnidadArmada instance = new UnidadArmada();
        String expResult = "";
        String result = instance.TablaUnidades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUnidadId method, of class UnidadArmada.
     */
    @Test
    public void testGetUnidadId() {
        System.out.println("getUnidadId");
        UnidadArmada instance = new UnidadArmada();
        int expResult = 0;
        int result = instance.getUnidadId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUnidadId method, of class UnidadArmada.
     */
    @Test
    public void testSetUnidadId() {
        System.out.println("setUnidadId");
        int unidadId = 0;
        UnidadArmada instance = new UnidadArmada();
        instance.setUnidadId(unidadId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
