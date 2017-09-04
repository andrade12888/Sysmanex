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
public class EmpresaTest {
    
    public EmpresaTest() {
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
     * Test of getRutEmpresa method, of class Empresa.
     */
    @Test
    public void testGetRutEmpresa() {
        System.out.println("getRutEmpresa");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getRutEmpresa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRutEmpresa method, of class Empresa.
     */
    @Test
    public void testSetRutEmpresa() {
        System.out.println("setRutEmpresa");
        String rutEmpresa = "";
        Empresa instance = new Empresa();
        instance.setRutEmpresa(rutEmpresa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaPersonasAutorizadas method, of class Empresa.
     */
    @Test
    public void testGetListaPersonasAutorizadas() {
        System.out.println("getListaPersonasAutorizadas");
        Empresa instance = new Empresa();
        ArrayList<Persona> expResult = null;
        ArrayList<Persona> result = instance.getListaPersonasAutorizadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaPersonasAutorizadas method, of class Empresa.
     */
    @Test
    public void testSetListaPersonasAutorizadas() {
        System.out.println("setListaPersonasAutorizadas");
        ArrayList<Persona> listaPersonasAutorizadas = null;
        Empresa instance = new Empresa();
        instance.setListaPersonasAutorizadas(listaPersonasAutorizadas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreEmpresa method, of class Empresa.
     */
    @Test
    public void testGetNombreEmpresa() {
        System.out.println("getNombreEmpresa");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.getNombreEmpresa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreEmpresa method, of class Empresa.
     */
    @Test
    public void testSetNombreEmpresa() {
        System.out.println("setNombreEmpresa");
        String nombreEmpresa = "";
        Empresa instance = new Empresa();
        instance.setNombreEmpresa(nombreEmpresa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarEmpresa method, of class Empresa.
     */
    @Test
    public void testAgregarEmpresa() {
        System.out.println("AgregarEmpresa");
        Empresa instance = new Empresa();
        int expResult = 0;
        int result = instance.AgregarEmpresa();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEmpresas method, of class Empresa.
     */
    @Test
    public void testBuscarEmpresas() throws Exception {
        System.out.println("BuscarEmpresas");
        ResultSet expResult = null;
        ResultSet result = Empresa.BuscarEmpresas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEmpresaPorNombre method, of class Empresa.
     */
    @Test
    public void testBuscarEmpresaPorNombre() {
        System.out.println("BuscarEmpresaPorNombre");
        String nombre = "";
        ResultSet expResult = null;
        ResultSet result = Empresa.BuscarEmpresaPorNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEmpresaPorRUT method, of class Empresa.
     */
    @Test
    public void testBuscarEmpresaPorRUT() {
        System.out.println("BuscarEmpresaPorRUT");
        String rutEmpresa = "";
        ResultSet expResult = null;
        ResultSet result = Empresa.BuscarEmpresaPorRUT(rutEmpresa);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BorrarEmpresa method, of class Empresa.
     */
    @Test
    public void testBorrarEmpresa() throws Exception {
        System.out.println("BorrarEmpresa");
        String RUT = "";
        int expResult = 0;
        int result = Empresa.BorrarEmpresa(RUT);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarEmpresa method, of class Empresa.
     */
    @Test
    public void testModificarEmpresa() throws Exception {
        System.out.println("ModificarEmpresa");
        Empresa emp = null;
        String rut = "";
        int expResult = 0;
        int result = Empresa.ModificarEmpresa(emp, rut);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TablaEmpresas method, of class Empresa.
     */
    @Test
    public void testTablaEmpresas() throws Exception {
        System.out.println("TablaEmpresas");
        Empresa instance = new Empresa();
        String expResult = "";
        String result = instance.TablaEmpresas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
