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
public class ExpedienteTest {
    
    public ExpedienteTest() {
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
     TODO: Test of AgregarExpediente method, of class Expediente.
     */
    @Test
    public void testAgregarExpediente() {
        System.out.println("AgregarExpediente");
        Expediente instance = null;
        int expResult = 0;
        int result = instance.AgregarExpediente();
        assertEquals(expResult, result);
    
        fail("The test case is a prototype.");
    }

    /**
     TODO: Test of BuscarExpedientes method, of class Expediente.
     */
    @Test
    public void testBuscarExpedientes() throws Exception {
        System.out.println("BuscarExpedientes");
        ResultSet expResult = null;
        ResultSet result = Expediente.BuscarExpedientes();
        assertEquals(expResult, result);        
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarExpedientePorNumero method, of class Expediente.
     */
    @Test
    public void testBuscarExpedientePorNumero() throws Exception {
        System.out.println("BuscarExpedientePorNumero");
        String numeroExpediente = "";
        ResultSet expResult = null;
        ResultSet result = Expediente.BuscarExpedientePorNumero(numeroExpediente);
        assertEquals(expResult, result);
        
        fail("The test case is a prototype.");
    }

    /**
      TODO: Test of BorrarExpediente method, of class Expediente.
     */
    @Test
    public void testBorrarExpediente() {
        System.out.println("BorrarExpediente");
        String numeroExpediente = "";
        int expResult = 0;
        int result = Expediente.BorrarExpediente(numeroExpediente);
        assertEquals(expResult, result);
     
        fail("The test case is a prototype.");
    }
    
}
