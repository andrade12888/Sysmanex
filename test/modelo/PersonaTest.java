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
 * @author sg0891660
 */
public class PersonaTest {
    
    public PersonaTest() {
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
     Test of testAgregarPersona method, of class Persona.
     */
//    @Test
//    public void testAgregarPersona() throws SQLException {
//        System.out.println("AgregarPersona");       
//        Rol r = new Rol();        
//        r.setId(5);        
//        Persona instance = new Persona("91827364", "Pablo", "Almeida","newUser","abc1234",r);
//        Entidad e = new Entidad();
//        e.setRol(r);
//        int expResult = 1;
//        int result = instance.AgregarPersonaEnUnidad(2);
//        assertEquals(expResult, result);        
//
//    }

    /**
     TODO: Test of ModificarPersona method, of class Persona.
     */
    @Test
    public void testModificarPersona() throws SQLException {
        System.out.println("ModificarPersona");
        String ciPersona = "";
        Persona instance = null;
        int expResult = 0;
//        int result = instance.ModificarPersona(ciPersona);
//        assertEquals(expResult, result);
        
        fail("The test case is a prototype.");
    }

    /**
     TODO: Test of BorrarPersona method, of class Persona.
     */
    @Test
    public void testBorrarPersona() {
        System.out.println("BorrarPersona");
        String ci = "";
        int expResult = 0;
//        int result = Persona.BorrarPersona(ci);
//       assertEquals(expResult, result);
       
   fail("The test case is a prototype.");
    }

    /**
     Test of BuscarPersona method, of class Persona.
     */
    @Test
    public void testBuscarPersona() throws Exception {
        System.out.println("BuscarPersona");
        String nombre = "Jorge";
        String expResult ="123456798";
        String rs="";
        ResultSet result =null;
        while(result.next() && result.getString("personaNombre").equalsIgnoreCase(nombre))
        {
             rs= result.getString("personaCi");
        }
        assertEquals(expResult, rs);

    }

    /**
     Test of BuscarPersonas method, of class Persona.
     */
    @Test
    public void testBuscarPersonas() throws Exception {
        System.out.println("BuscarPersonas");
           
        int c=0;
        ResultSet result = Persona.BuscarPersonas();        
        
        int expResult = result.getRow();

        while(result.next())
        {
           c++;
           expResult = result.getRow();
        }
  
   
        assertEquals(expResult, c);

    }
    
}
