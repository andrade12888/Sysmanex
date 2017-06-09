/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    public void testAgregarUnidad() throws SQLException {
        System.out.println("AgregarUnidad");
        UnidadArmada instance = new UnidadArmada("Unidad Naval",5);       
        ArrayList<Persona> pers = new ArrayList<>();

        instance.setPersonas(pers);
        
        int expResult = 1;
        int result = instance.AgregarUnidad();
        assertEquals(expResult, result);

    }

    /**
     Test of BuscarUnidades method, of class UnidadArmada.
     * @throws java.lang.Exception
     */
    @Test
    public void testBuscarUnidades() throws Exception {
        System.out.println("BuscarUnidades");
        String expResult = "SMA";
        String unidad="";
        ResultSet result = UnidadArmada.BuscarUnidades();
        while(result.next())
        {
            if(result.getString("unidadSigla").equalsIgnoreCase("SMA"))                        
            {
                expResult=result.getString("unidadSigla");
                unidad = result.getString("unidadSigla");            
            }
        }
        
        assertEquals(expResult,unidad);

    }

    /**
     Test of BuscarUnidadPorNombre method, of class UnidadArmada.
     */
    @Test
    public void testBuscarUnidadPorNombre() throws Exception {
        System.out.println("BuscarUnidadPorNombre");
        String nombre = "Artilleros";
        int expResult = 5;
        int result=-1;
        ResultSet rs = UnidadArmada.BuscarUnidadPorNombre(nombre);
         while(rs.next())
        {
            if(rs.getString("unidadSigla").equalsIgnoreCase(nombre))                        
            {
               result=rs.getInt("unidadEntidadId");                           
            }
        }
        assertEquals(expResult, result);
    }

    /**
     Test of BuscarUnidadPorSigla method, of class UnidadArmada.
     */
    @Test
    public void testBuscarUnidadPorSigla() throws Exception {
        System.out.println("BuscarUnidadPorNombre");
        int entidad = 3;
        String expResult = "Servicio de Gestion Informatica y Telecomunicaciones";
        ResultSet rs = UnidadArmada.BuscarUnidadPorEntidadId(entidad);
        rs.next();

        String result=rs.getString(2);
        assertEquals(expResult, result);
    }

   
}
