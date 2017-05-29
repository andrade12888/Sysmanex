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
public class DocumentoTest {
    
    public DocumentoTest() {
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
     * Test of getId method, of class Documento.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Documento instance = new Documento();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombre method, of class Documento.
     */
    @Test
    public void testGetNombre() {
        System.out.println("getNombre");
        Documento instance = new Documento();
        String expResult = "";
        String result = instance.getNombre();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombre method, of class Documento.
     */
    @Test
    public void testSetNombre() {
        System.out.println("setNombre");
        String nombre = "";
        Documento instance = new Documento();
        instance.setNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlazo method, of class Documento.
     */
    @Test
    public void testGetPlazo() {
        System.out.println("getPlazo");
        Documento instance = new Documento();
        String expResult = "";
        String result = instance.getPlazo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlazo method, of class Documento.
     */
    @Test
    public void testSetPlazo() {
        System.out.println("setPlazo");
        String plazo = "";
        Documento instance = new Documento();
        instance.setPlazo(plazo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isBaja method, of class Documento.
     */
    @Test
    public void testIsBaja() {
        System.out.println("isBaja");
        Documento instance = new Documento();
        boolean expResult = false;
        boolean result = instance.isBaja();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBaja method, of class Documento.
     */
    @Test
    public void testSetBaja() {
        System.out.println("setBaja");
        boolean baja = false;
        Documento instance = new Documento();
        instance.setBaja(baja);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarDocumento method, of class Documento.
     */
    @Test
    public void testAgregarDocumento() {
        System.out.println("AgregarDocumento");
        Documento instance = new Documento();
        int expResult = 0;
        int result = instance.AgregarDocumento();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarDocumento method, of class Documento.
     */
    @Test
    public void testModificarDocumento() {
        System.out.println("ModificarDocumento");
        String id = "";
        Documento instance = new Documento();
        int expResult = 0;
        int result = instance.ModificarDocumento(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BorrarDocumento method, of class Documento.
     */
    @Test
    public void testBorrarDocumento() {
        System.out.println("BorrarDocumento");
        String id = "";
        Documento instance = new Documento();
        int expResult = 0;
        int result = instance.BorrarDocumento(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarDocumento method, of class Documento.
     */
    @Test
    public void testBuscarDocumento_String() throws Exception {
        System.out.println("BuscarDocumento");
        String nombre = "";
        Documento instance = new Documento();
        String expResult = "";
        String result = instance.BuscarDocumento(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarDocumento method, of class Documento.
     */
    @Test
    public void testBuscarDocumento_int() {
        System.out.println("BuscarDocumento");
        int id = 0;
        Documento instance = new Documento();
        instance.BuscarDocumento(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TablaDocumentos method, of class Documento.
     */
    @Test
    public void testTablaDocumentos_ResultSet() throws Exception {
        System.out.println("TablaDocumentos");
        ResultSet rs = null;
        Documento instance = new Documento();
        String expResult = "";
        String result = instance.TablaDocumentos(rs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TablaDocumentos method, of class Documento.
     */
    @Test
    public void testTablaDocumentos_0args() throws Exception {
        System.out.println("TablaDocumentos");
        Documento instance = new Documento();
        String expResult = "";
        String result = instance.TablaDocumentos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
