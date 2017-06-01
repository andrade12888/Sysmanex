/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
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
public class EntidadTest {
    
    public EntidadTest() {
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
     * Test of AgregarEntidad method, of class Entidad.
     */
    @Test
    public void testAgregarEntidad() {
        System.out.println("AgregarEntidad");
        Rol r = new Rol();
        r.setId(3);
        Entidad instance = new Entidad("usr","pass",r);
        int expResult = 1;
        int result = instance.AgregarEntidad();
        assertEquals(expResult, result);
    }

    /**
     * Test of ModificarEntidad method, of class Entidad.
     */
    @Test
    public void testModificarEntidad() {
        System.out.println("ModificarEntidad");
        Rol r = new Rol();
        r.setId(3);
        String idEntidad = "5";
        Entidad instance = new Entidad("user","user",r);
        int expResult = 1;
        int result = instance.ModificarEntidad(idEntidad);
        assertEquals(expResult, result);
    }

    /**
     * Test of BorrarEntidad method, of class Entidad.
     */
    @Test
    public void testBorrarEntidad() {
//        System.out.println("BorrarEntidad");
//        String id = "";
//        Entidad instance = new Entidad();
//        int expResult = 0;
//        int result = instance.BorrarEntidad(id);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEntidad method, of class Entidad.
     */
    @Test
    public void testBuscarEntidad() throws Exception {
        System.out.println("BuscarEntidad");
        int expResult = 1;
        ResultSet result = Entidad.BuscarEntidad("Administrador");
        result.next();
        int rs = result.getInt("rolId");
        assertEquals(expResult, rs);
    }

    /**
     * Test of BuscarEntidades method, of class Entidad.
     */
    @Test
    public void testBuscarEntidades() throws Exception {
        System.out.println("BuscarEntidades");
        String expResult = "Administrador";
        ResultSet result = Entidad.BuscarEntidades();
        result.next();
        String rs = result.getString("entidadNombre");
        assertEquals(expResult, rs);
    }
  
}
