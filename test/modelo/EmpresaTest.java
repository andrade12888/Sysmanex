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
     PRE:La persona ya debe existir en la base de datos
     POST: Retorna 1 si se ejecuta con exito, 0 si no reotorna nada, 2 si alguna de las variables
    //      es nula (Rut o persona autorizada) o -1 si existe algun error en la secuancia SQL
     */
    @Test
    public void testAgregarEmpresaSuccess() {
        System.out.println("AgregarEmpresayPersonasSuccess");
        ArrayList<Persona> ap = new ArrayList<>();
        Persona p = new Persona("11223344", "", null);
        ap.add(p);
        p = new Persona("321654987", "", null);
        ap.add(p);
        Empresa instance = new Empresa("9876654",ap ,"LUGRA");
        int expResult = 1;
        int result = instance.AgregarEmpresa();
        assertEquals(expResult, result);

    }

    /**
     * Test of BuscarEmpresas method, of class Empresa.
     */
    @Test
    public void testBuscarEmpresas() throws Exception {
        System.out.println("BuscarEmpresas");
        String expResult = "CYMACO";
        ResultSet result = Empresa.BuscarEmpresas();
        result.next();
        String rs =result.getString("empresaNombre");      
        
        assertEquals(expResult, rs);

    }

    /**
     * Test of BuscarEmpresaPorNombre method, of class Empresa.
     */
    @Test
    public void testBuscarEmpresaPorNombre() throws Exception {
        System.out.println("BuscarEmpresaPorNombre");
        String nombre = "CYMACO";
        String expResult = "5678";
        ResultSet result = Empresa.BuscarEmpresaPorNombre(nombre);
        result.next();
        String rs = result.getString("empresaRut");
        assertEquals(expResult, rs);

    }

    /**
     * Test of BuscarEmpresaPorRUT method, of class Empresa.
     */
    @Test
    public void testBuscarEmpresaPorRUT() throws Exception {
        System.out.println("BuscarEmpresaPorRUT");
        String rutEmpresa = "12345678";
        String expResult = "Primer Empresa";
        ResultSet result = Empresa.BuscarEmpresaPorRUT(rutEmpresa);
         result.next();
        String rs = result.getString("empresaNombre");
        assertEquals(expResult, rs);

    }

    /**
     * Test of BorrarEmpresa method, of class Empresa.
     */
    @Test
    public void testBorrarEmpresa() {
//        System.out.println("BorrarEmpresa");
//        String RUT = "";
//        int expResult = 0;
//        int result = Empresa.BorrarEmpresa(RUT);
//        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    
}
