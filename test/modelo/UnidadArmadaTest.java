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
 * @author sg0891660
 */
public class UnidadArmadaTest {
    
    public UnidadArmadaTest() {
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
     * Test of AgregarUnidad method, of class UnidadArmada Agrega solo la unidad.
     */
    @Test
    public void testAgregarUnidad() {
        System.out.println("AgregarUnidad");
        UnidadArmada instance = new UnidadArmada("Artilleros",5);
        Persona p = new Persona("11223344", null, null);
        Persona p2 = new Persona("123456798", null, null);
        ArrayList<Persona> pers = new ArrayList<>();
        pers.add(p);
        pers.add(p2);
        instance.setPersonas(pers);
        
        int expResult = 1;
        int result = instance.AgregarUnidad();
        assertEquals(expResult, result);

    }

    /**
     * Test of BuscarUnidades method, of class UnidadArmada.
     */
    @Test
    public void testBuscarUnidades() throws Exception {
        System.out.println("BuscarUnidades");
        ResultSet expResult = null;
        ResultSet result = UnidadArmada.BuscarUnidades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarUnidadPorNombre method, of class UnidadArmada.
     */
    @Test
    public void testBuscarUnidadPorNombre() throws Exception {
        System.out.println("BuscarUnidadPorNombre");
        String nombre = "";
        ResultSet expResult = null;
        ResultSet result = UnidadArmada.BuscarUnidadPorNombre(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarUnidadPorSigla method, of class UnidadArmada.
     */
    @Test
    public void testBuscarUnidadPorSigla() throws Exception {
        System.out.println("BuscarUnidadPorSigla");
        String sigla = "";
        ResultSet expResult = null;
        ResultSet result = UnidadArmada.BuscarUnidadPorSigla(sigla);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

   
}
