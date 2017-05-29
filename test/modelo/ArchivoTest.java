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
 * @author SG0891660
 */
public class ArchivoTest {
    
    public ArchivoTest() {
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
     * Test of getIdArchivo method, of class Archivo.
     */
    @Test //AgregarArchivo()
    public void testGetIdArchivoSuccess() {
        System.out.println("testGetIdArchivoSuccess\n");
        Archivo instance = new Archivo("otro archivo", 1024,"c\\root\\veinte");
       // @return either (1) the row count for SQL Data Manipulation Language (DML) statements
       //         or (2) 0 for SQL statements that return nothing
        int expResult = 1;
        int result = instance.AgregarArchivo();
        assertEquals(expResult, result);   
    }
    
     @Test //Test UNIQUE KEY ruta de archivo: se espera retorner fail code -1
    public void testGetIdArchivoError() {
        System.out.println("testGetIdArchivoError\n");
        Archivo instance = new Archivo("Primer archivo", 1024,"c\\root");
       // @return either (1) the row count for SQL Data Manipulation Language (DML) statements
       //         or (2) 0 for SQL statements that return nothing
        int expResult = -1;
        int result = instance.AgregarArchivo();
        assertEquals(expResult, result);   
    }

    @Test //BuscarArchivos()
    public void testBuscarArchivosSuccess() throws SQLException {
        System.out.println("testBuscarArchivosSuccess\n");  
        System.out.println("===================\n"); 
       
        int expResult = 5;
        ResultSet idArchivo = Archivo.BuscarArchivos();
        idArchivo.next();
        //1: ArchivoRuta
        //2: ArchivoNombre
        //3: ArchivoId
        //4: ArchivoTamano
        int result =idArchivo.getInt(3);
        assertEquals(expResult, result);   
    }
    
        
     @Test //BuscarArchivoPorNombre()
    public void testBuscarArchivosPorNombreSuccess() throws SQLException {
        System.out.println("testBuscarArchivos por nombre - Success\n");  
        System.out.println("===================\n"); 
       
        int expResult = 5;
        ResultSet idArchivo = Archivo.BuscarArchivoPorNombre("Primer archivo");
        idArchivo.next();
        //1: ArchivoRuta
        //2: ArchivoNombre
        //3: ArchivoId
        //4: ArchivoTamano
        int result =idArchivo.getInt(3);
        assertEquals(expResult, result);   
    }
    
      @Test //BuscarArchivoPorNombre()
    public void testBuscarArchivosPorNombreError() throws SQLException {
        System.out.println("testBuscarArchivos por nombre - Error\n");  
        System.out.println("===================\n"); 
       
        boolean expResult = false;
        ResultSet idArchivo = Archivo.BuscarArchivoPorNombre("Pimer achivo");
        
        //1: ArchivoRuta
        //2: ArchivoNombre
        //3: ArchivoId
        //4: ArchivoTamano
        boolean result =idArchivo.next();
        assertEquals(expResult, result);   
    }
   
    @Test
    public void testBuscarArchivoPorIdSuccess() throws Exception {
        System.out.println("BuscarArchivoPorId\n");
        System.out.println("==================");
        int idArchivo = 5;
        ResultSet rs = Archivo.BuscarArchivoPorId(idArchivo);
        rs.next();
        String result = rs.getString(2);
        String expResult="Primer archivo";
        assertEquals(expResult, result);

    }
    
}
