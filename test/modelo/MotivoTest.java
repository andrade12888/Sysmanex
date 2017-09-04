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
        Motivo instance = new Motivo();
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
        Motivo instance = new Motivo();
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
        Motivo instance = new Motivo();
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
        Motivo instance = new Motivo();
        instance.setMotivoDescripcion(motivoDescripcion);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMotivoDB method, of class Motivo.
     */
    @Test
    public void testGetMotivoDB() {
        System.out.println("getMotivoDB");
        int motivoId = 0;
        String expResult = "";
        String result = Motivo.getMotivoDB(motivoId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarMotivos method, of class Motivo.
     */
    @Test
    public void testBuscarMotivos() {
        System.out.println("BuscarMotivos");
        ResultSet expResult = null;
        ResultSet result = Motivo.BuscarMotivos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarMotivo method, of class Motivo.
     */
    @Test
    public void testAgregarMotivo() throws Exception {
        System.out.println("AgregarMotivo");
        Motivo instance = new Motivo();
        int expResult = 0;
        int result = instance.AgregarMotivo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarMotivo method, of class Motivo.
     */
    @Test
    public void testModificarMotivo() throws Exception {
        System.out.println("ModificarMotivo");
        int idMotivo = 0;
        String motivoDescripcion = "";
        int expResult = 0;
        int result = Motivo.ModificarMotivo(idMotivo, motivoDescripcion);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TablaMotivos method, of class Motivo.
     */
    @Test
    public void testTablaMotivos() throws Exception {
        System.out.println("TablaMotivos");
        Motivo instance = new Motivo();
        String expResult = "";
        String result = instance.TablaMotivos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BorrarMotivo method, of class Motivo.
     */
    @Test
    public void testBorrarMotivo() {
        System.out.println("BorrarMotivo");
        int idMotivo = 0;
        int expResult = 0;
        int result = Motivo.BorrarMotivo(idMotivo);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarMotivo method, of class Motivo.
     */
    @Test
    public void testBuscarMotivo() {
        System.out.println("BuscarMotivo");
        int id = 0;
        Motivo instance = new Motivo();
        instance.BuscarMotivo(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
