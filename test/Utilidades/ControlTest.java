/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empresa;
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
public class ControlTest {
    
    public ControlTest() {
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
     * Test of ControlarCedula method, of class Control.
     */
    @Test
    public void testControlarCedula() {
        System.out.println("ControlarCedula");
        String cedula = "";
        boolean expResult = false;
        boolean result = Control.ControlarCedula(cedula);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ControlarCelular method, of class Control.
     */
    @Test
    public void testControlarCelular() {
        System.out.println("ControlarCelular");
        String celular = "";
        boolean expResult = false;
        boolean result = Control.ControlarCelular(celular);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ControlarNombre method, of class Control.
     */
    @Test
    public void testControlarNombre() {
        System.out.println("ControlarNombre");
        String nombre = "";
        boolean expResult = false;
        boolean result = Control.ControlarNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ControlarEmail method, of class Control.
     */
    @Test
    public void testControlarEmail() {
        System.out.println("ControlarEmail");
        String email = "";
        boolean expResult = false;
        boolean result = Control.ControlarEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValidateEmail method, of class Control.
     */
    @Test
    public void testValidateEmail() {
        System.out.println("ValidateEmail");
        String email = "";
        boolean expResult = false;
        boolean result = Control.ValidateEmail(email);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValidateCel method, of class Control.
     */
    @Test
    public void testValidateCel() {
        System.out.println("ValidateCel");
        String celular = "";
        boolean expResult = false;
        boolean result = Control.ValidateCel(celular);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValidateCI method, of class Control.
     */
    @Test
    public void testValidateCI() {
        System.out.println("ValidateCI");
        String ci = "";
        boolean expResult = false;
        boolean result = Control.ValidateCI(ci);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValidateDate method, of class Control.
     */
    @Test
    public void testValidateDate() {
        System.out.println("ValidateDate");
        String date = "";
        boolean expResult = false;
        boolean result = Control.ValidateDate(date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ControlEmpresaExistente method, of class Control.
     */
    @Test
    public void testControlEmpresaExistente() throws Exception {
        System.out.println("ControlEmpresaExistente");
        Empresa e = null;
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        boolean expResult = false;
        boolean result = Control.ControlEmpresaExistente(e, request, response);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
