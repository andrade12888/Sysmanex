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

   
}
