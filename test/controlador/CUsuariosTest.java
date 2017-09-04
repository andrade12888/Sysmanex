/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
public class CUsuariosTest {
    
    public CUsuariosTest() {
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
     * Test of processRequest method, of class CUsuarios.
     */
    @Test
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CUsuarios instance = new CUsuarios();
        instance.processRequest(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of modificarUsuarios method, of class CUsuarios.
     */
    @Test
    public void testModificarUsuarios() throws Exception {
        System.out.println("modificarUsuarios");
        String tipoUser = "";
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CUsuarios instance = new CUsuarios();
        instance.modificarUsuarios(tipoUser, request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of borrarUsuarios method, of class CUsuarios.
     */
    @Test
    public void testBorrarUsuarios() throws Exception {
        System.out.println("borrarUsuarios");
        String tipoUser = "";
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CUsuarios instance = new CUsuarios();
        instance.borrarUsuarios(tipoUser, request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CargarDatos method, of class CUsuarios.
     */
    @Test
    public void testCargarDatos() throws Exception {
        System.out.println("CargarDatos");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CUsuarios.CargarDatos(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doGet method, of class CUsuarios.
     */
    @Test
    public void testDoGet() throws Exception {
        System.out.println("doGet");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CUsuarios instance = new CUsuarios();
        instance.doGet(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doPost method, of class CUsuarios.
     */
    @Test
    public void testDoPost() throws Exception {
        System.out.println("doPost");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        CUsuarios instance = new CUsuarios();
        instance.doPost(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getServletInfo method, of class CUsuarios.
     */
    @Test
    public void testGetServletInfo() {
        System.out.println("getServletInfo");
        CUsuarios instance = new CUsuarios();
        String expResult = "";
        String result = instance.getServletInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
