/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class MensajesTest {
    
    public MensajesTest() {
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
     * Test of mensajeSuccessError method, of class Mensajes.
     */
    @Test
    public void testMensajeSuccessError() {
        System.out.println("mensajeSuccessError");
        String mensaje = "";
        String paginaEnvio = "";
        String color = "";
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        Mensajes.mensajeSuccessError(mensaje, paginaEnvio, color, request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GetNombreJSP method, of class Mensajes.
     */
    @Test
    public void testGetNombreJSP() {
        System.out.println("GetNombreJSP");
        HttpServletRequest request = null;
        String expResult = "";
        String result = Mensajes.GetNombreJSP(request);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
