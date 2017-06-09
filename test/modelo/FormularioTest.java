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
public class FormularioTest {
    
    public FormularioTest() {
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
     TODO: Test of getFormulario method, of class Formulario.
     */
    @Test
    public void testGetFormulario() {
        System.out.println("getFormulario");
        String nombreFormulario = "";
        String expResult = "";
        String result = Formulario.getFormulario(nombreFormulario);
        assertEquals(expResult, result);    
        fail("The test case is a prototype.");
    }

    /**
     TODO: Test of BuscarFormularios method, of class Formulario.
     */
    @Test
    public void testBuscarFormularios() {
        System.out.println("BuscarFormularios");
        ResultSet expResult = null;
        ResultSet result = Formulario.BuscarFormularios();
        assertEquals(expResult, result);
        
        fail("The test case is a prototype.");
    }

    /**
     TODO: Test of AgregarFormulario method, of class Formulario.
     */
    @Test
    public void testAgregarFormulario() throws SQLException {
        System.out.println("AgregarFormulario");
        Formulario instance = null;
        int expResult = 0;
        int result = instance.AgregarFormulario();
        assertEquals(expResult, result);
        
        fail("The test case is a prototype.");
    }
    
}
