/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
    public void testAgregarEmpresaSuccess() {
        System.out.println("AgregarEmpresayPersonasSuccess");
        ArrayList<Persona> ap = new ArrayList<>();
        Persona p = new Persona("123456798", "", null);
        ap.add(p);
        p = new Persona("321654987", "", null);
        ap.add(p);
        Empresa instance = new Empresa("5678",ap ,"Primer Empresa");
        int expResult = 1;
        int result = instance.AgregarEmpresa();
        assertEquals(expResult, result);

    }

    
}
