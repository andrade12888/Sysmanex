/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
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
     * Test of AgregarDocumento method, of class Documento.
     */
    @Test
    public void testAgregarDocumentoSuccess() {
        System.out.println("AgregarDocumento");
        Documento instance = new Documento("Licencia", 200);
        int expResult = 1;
        int result = instance.AgregarDocumento();
        assertEquals(expResult, result);

    }

    /**
     * Test of ModificarDocumento method, of class Documento.
     */
    @Test
    public void testModificarDocumento() {
        System.out.println("ModificarDocumento");
        String id = "4";
        Documento instance = new Documento("Documento notarial", 100);
        instance.setBaja(false);
        int expResult = 1;
        int result = instance.ModificarDocumento(id);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of BorrarDocumento method, of class Documento.
     */
    @Test
    public void testBorrarDocumento() {
        System.out.println("BorrarDocumento");
//        String id = "";
//        Documento instance = new Documento();
//        int expResult = 0;
//        int result = instance.BorrarDocumento(id);
//        assertEquals(expResult, result);
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
    public void testBuscarDocumento_int() throws SQLException {
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
