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
     * Test of AgregarDocumento method, of class Tramite.
     */
    @Test
    public void testAgregarDocumentoSuccess() throws SQLException {
        System.out.println("AgregarDocumento");
        Tramite instance = new Tramite("Licencia", 200);
        int expResult = 1;
        int result = instance.AgregarTramite();
        assertEquals(expResult, result);

    }

    /**
     * Test of ModificarDocumento method, of class Tramite.
     */
    @Test
    public void testModificarDocumento() throws SQLException {
        System.out.println("ModificarDocumento");
        String id = "4";
        Tramite instance = new Tramite("Documento notarial", 100);
        instance.setBaja(false);
        int expResult = 1;
        int result = instance.ModificarTramite(id);
        assertEquals(expResult, result);
        
    }

    /**
     TODO: Test of BorrarDocumento method, of class Tramite.
     */
    @Test
    public void testBorrarDocumento() {
        System.out.println("BorrarDocumento");
//        String id = "";
//        Tramite instance = new Tramite();
//        int expResult = 0;
//        int result = instance.BorrarDocumento(id);
//        assertEquals(expResult, result);
        
        fail("The test case is a prototype.");
    }

}
