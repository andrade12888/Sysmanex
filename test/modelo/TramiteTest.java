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
public class TramiteTest {
    
    public TramiteTest() {
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
     * Test of getId method, of class Tramite.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Tramite instance = new Tramite();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Tramite.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Tramite instance = new Tramite();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Tramite.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Tramite instance = new Tramite();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlazo method, of class Tramite.
     */
    @Test
    public void testGetPlazo() {
        System.out.println("getPlazo");
        Tramite instance = new Tramite();
        int expResult = 0;
        int result = instance.getPlazo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlazo method, of class Tramite.
     */
    @Test
    public void testSetPlazo() {
        System.out.println("setPlazo");
        int plazo = 0;
        Tramite instance = new Tramite();
        instance.setPlazo(plazo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBaja method, of class Tramite.
     */
    @Test
    public void testIsBaja() {
        System.out.println("isBaja");
        Tramite instance = new Tramite();
        boolean expResult = false;
        boolean result = instance.isBaja();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBaja method, of class Tramite.
     */
    @Test
    public void testSetBaja() {
        System.out.println("setBaja");
        boolean baja = false;
        Tramite instance = new Tramite();
        instance.setBaja(baja);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarTramite method, of class Tramite.
     */
    @Test
    public void testAgregarTramite() {
        System.out.println("AgregarTramite");
        Tramite instance = new Tramite();
        int expResult = 0;
        int result = instance.AgregarTramite();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarTramite method, of class Tramite.
     */
    @Test
    public void testModificarTramite() {
        System.out.println("ModificarTramite");
        String id = "";
        Tramite instance = new Tramite();
        int expResult = 0;
        int result = instance.ModificarTramite(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BorrarTramite method, of class Tramite.
     */
    @Test
    public void testBorrarTramite() {
        System.out.println("BorrarTramite");
        String id = "";
        int expResult = 0;
        int result = Tramite.BorrarTramite(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarTramiteNombre method, of class Tramite.
     */
    @Test
    public void testBuscarTramiteNombre() throws Exception {
        System.out.println("BuscarTramiteNombre");
        String nombre = "";
        Tramite instance = new Tramite();
        instance.BuscarTramiteNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarTramite method, of class Tramite.
     */
    @Test
    public void testBuscarTramite() {
        System.out.println("BuscarTramite");
        int id = 0;
        Tramite instance = new Tramite();
        instance.BuscarTramite(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tramitesDB method, of class Tramite.
     */
    @Test
    public void testTramitesDB() throws Exception {
        System.out.println("tramitesDB");
        ResultSet expResult = null;
        ResultSet result = Tramite.tramitesDB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TablaTramites method, of class Tramite.
     */
    @Test
    public void testTablaTramites_ResultSet() throws Exception {
        System.out.println("TablaTramites");
        ResultSet rs = null;
        Tramite instance = new Tramite();
        String expResult = "";
        String result = instance.TablaTramites(rs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TablaTramites method, of class Tramite.
     */
    @Test
    public void testTablaTramites_0args() throws Exception {
        System.out.println("TablaTramites");
        Tramite instance = new Tramite();
        String expResult = "";
        String result = instance.TablaTramites();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Tramite.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Tramite instance = new Tramite();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
