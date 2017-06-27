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
public class ExpedienteTest {
    
    public ExpedienteTest() {
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
    Test of AgregarExpediente method, of class Expediente.
     */
    @Test
    public void testAgregarExpediente() {
        System.out.println("AgregarExpediente");
//        Entidad e = new Entidad();
//        e.setEntidadId(3);
//        Tramite t = new Tramite();
//        t.setId(3);
//        Estado est = new Estado();
//        est.setIdEstado(2);
//        Motivo m = new Motivo();
//        m.setMotivoId(1);
//        Expediente instance = new Expediente("unidad y numero", "23/mar/2020", "primer prueba", true, t, e, est, m);
//        int expResult = 1;
//        int result = instance.AgregarExpediente();
//        assertEquals(expResult, result);
    }
    
    /**
    Test of AgregarExpediente method, of class Expediente con archivos
     */
    
    @Test
     public void testAgregarExpedienteConArchivos() {
//        System.out.println("AgregarExpediente");
//        Entidad e = new Entidad();
//        e.setEntidadId(3);
//        Tramite t = new Tramite();
//        t.setId(3);
//        Estado est = new Estado();
//        est.setIdEstado(2);
//        Motivo m = new Motivo();
//        m.setMotivoId(1);
//        Expediente instance = new Expediente("unidad 2 y numero 3", "23/mar/2020", "primer prueba", true, t, e, est, m);
//        ArrayList<String> archivos = new ArrayList<>();
//        archivos.add("archivo 1");
//        archivos.add("archivo 2");
//        archivos.add("archivo 3");
//        instance.setListaArchivosExpediente(archivos);
//        int expResult = 1;
//        int result = instance.AgregarExpediente();
//        assertEquals(expResult, result);
    }

    /**
     * Test of BuscarExpedientePorNumero method, of class Expediente.
     */
    @Test
    public void testBuscarExpedientePorNumero() throws Exception {
        System.out.println("BuscarExpedientePorNumero");
        String nombreExp = "primer prueba";
        ResultSet result = Expediente.BuscarExpedientePorNumero("unidad y numero");
        result.next();
        String rs = result.getString(2);
        assertEquals(nombreExp, rs);

    }

    /**
      TODO: Test of BorrarExpediente method, of class Expediente.
     */
    @Test
    public void testBorrarExpediente() throws SQLException {
        System.out.println("BorrarExpediente");
//        String numeroExpediente = "";
//        int expResult = 0;
//        int result = Expediente.BorrarExpediente(numeroExpediente);
//        assertEquals(expResult, result);
//     
        fail("The test case is a prototype.");
    }
    
}
