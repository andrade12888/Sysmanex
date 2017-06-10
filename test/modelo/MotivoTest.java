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
     * Test of getMotivoDB method, of class Motivo.
     */
    @Test
    public void testGetMotivoDB() {
        System.out.println("getMotivoDB");
        int motivoId = 1;
        String expResult = "Conocimiento";
        String result = Motivo.getMotivoDB(motivoId);
        assertEquals(expResult, result);

    }

    /**
     * Test of BuscarMotivos method, of class Motivo.
     */
    @Test
    public void testBuscarMotivos() throws SQLException {
        System.out.println("BuscarMotivos");
        String expResult = "Archivar";
        ResultSet result = Motivo.BuscarMotivos();
        result.next();
        String motivo = result.getString("motivoDescripcion");
        assertEquals(expResult, motivo);

    }

    /**
     * Test of AgregarMotivo method, of class Motivo.
     */
    @Test
    public void testAgregarMotivo() throws SQLException {
        System.out.println("AgregarMotivo");
        Motivo instance = new Motivo("Sancion");
        int expResult = 1;
        int result = instance.AgregarMotivo();
        assertEquals(expResult, result);

    }
   
    
}
