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
        Estado instance = new Estado();
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
        Estado instance = new Estado();
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
        Estado instance = new Estado();
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
        Estado instance = new Estado();
        instance.setDescripcionEstado(descripcionEstado);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEstadoBaja method, of class Estado.
     */
    @Test
    public void testIsEstadoBaja() {
        System.out.println("isEstadoBaja");
        Estado instance = new Estado();
        boolean expResult = false;
        boolean result = instance.isEstadoBaja();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoBaja method, of class Estado.
     */
    @Test
    public void testSetEstadoBaja() {
        System.out.println("setEstadoBaja");
        boolean estadoBaja = false;
        Estado instance = new Estado();
        instance.setEstadoBaja(estadoBaja);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadoDB method, of class Estado.
     */
    @Test
    public void testGetEstadoDB() {
        System.out.println("getEstadoDB");
        int estadoId = 0;
        String expResult = "";
        String result = Estado.getEstadoDB(estadoId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarEstado method, of class Estado.
     */
    @Test
    public void testAgregarEstado() throws Exception {
        System.out.println("AgregarEstado");
        Estado instance = new Estado();
        int expResult = 0;
        int result = instance.AgregarEstado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarEstado method, of class Estado.
     */
    @Test
    public void testModificarEstado() throws Exception {
        System.out.println("ModificarEstado");
        int idEstadi = 0;
        String descripcionEstado = "";
        boolean nuevoEstadoBaja = false;
        int expResult = 0;
        int result = Estado.ModificarEstado(idEstadi, descripcionEstado, nuevoEstadoBaja);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEstados method, of class Estado.
     */
    @Test
    public void testBuscarEstados() {
        System.out.println("BuscarEstados");
        ResultSet expResult = null;
        ResultSet result = Estado.BuscarEstados();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEstado method, of class Estado.
     */
    @Test
    public void testBuscarEstado() {
        System.out.println("BuscarEstado");
        int id = 0;
        Estado instance = new Estado();
        instance.BuscarEstado(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEstadoDescripcion method, of class Estado.
     */
    @Test
    public void testBuscarEstadoDescripcion() {
        System.out.println("BuscarEstadoDescripcion");
        String descripcion = "";
        Estado instance = new Estado();
        instance.BuscarEstadoDescripcion(descripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
