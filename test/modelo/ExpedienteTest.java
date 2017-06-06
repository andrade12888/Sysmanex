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
     * Test of getNumeroExpediente method, of class Expediente.
     */
    @Test
    public void testGetNumeroExpediente() {
        System.out.println("getNumeroExpediente");
        Expediente instance = null;
        String expResult = "";
        String result = instance.getNumeroExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNumeroExpediente method, of class Expediente.
     */
    @Test
    public void testSetNumeroExpediente() {
        System.out.println("setNumeroExpediente");
        String numeroExpediente = "";
        Expediente instance = null;
        instance.setNumeroExpediente(numeroExpediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaExpediente method, of class Expediente.
     */
    @Test
    public void testGetFechaExpediente() {
        System.out.println("getFechaExpediente");
        Expediente instance = null;
        String expResult = "";
        String result = instance.getFechaExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFechaExpediente method, of class Expediente.
     */
    @Test
    public void testSetFechaExpediente() {
        System.out.println("setFechaExpediente");
        String fechaExpediente = "";
        Expediente instance = null;
        instance.setFechaExpediente(fechaExpediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAsuntoExpediente method, of class Expediente.
     */
    @Test
    public void testGetAsuntoExpediente() {
        System.out.println("getAsuntoExpediente");
        Expediente instance = null;
        String expResult = "";
        String result = instance.getAsuntoExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAsuntoExpediente method, of class Expediente.
     */
    @Test
    public void testSetAsuntoExpediente() {
        System.out.println("setAsuntoExpediente");
        String asuntoExpediente = "";
        Expediente instance = null;
        instance.setAsuntoExpediente(asuntoExpediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isExpedientePublico method, of class Expediente.
     */
    @Test
    public void testIsExpedientePublico() {
        System.out.println("isExpedientePublico");
        Expediente instance = null;
        boolean expResult = false;
        boolean result = instance.isExpedientePublico();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExpedientePublico method, of class Expediente.
     */
    @Test
    public void testSetExpedientePublico() {
        System.out.println("setExpedientePublico");
        boolean expedientePublico = false;
        Expediente instance = null;
        instance.setExpedientePublico(expedientePublico);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaDestinariosExpediente method, of class Expediente.
     */
    @Test
    public void testGetListaDestinariosExpediente() {
        System.out.println("getListaDestinariosExpediente");
        Expediente instance = null;
        ArrayList<Entidad> expResult = null;
        ArrayList<Entidad> result = instance.getListaDestinariosExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaDestinariosExpediente method, of class Expediente.
     */
    @Test
    public void testSetListaDestinariosExpediente() {
        System.out.println("setListaDestinariosExpediente");
        ArrayList<Entidad> listaDestinariosExpediente = null;
        Expediente instance = null;
        instance.setListaDestinariosExpediente(listaDestinariosExpediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntidadOrigien method, of class Expediente.
     */
    @Test
    public void testGetEntidadOrigien() {
        System.out.println("getEntidadOrigien");
        Expediente instance = null;
        Entidad expResult = null;
        Entidad result = instance.getEntidadOrigien();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEntidadOrigien method, of class Expediente.
     */
    @Test
    public void testSetEntidadOrigien() {
        System.out.println("setEntidadOrigien");
        Entidad entidadOrigien = null;
        Expediente instance = null;
        instance.setEntidadOrigien(entidadOrigien);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDocumentoExpediente method, of class Expediente.
     */
    @Test
    public void testGetDocumentoExpediente() {
        System.out.println("getDocumentoExpediente");
        Expediente instance = null;
        Tramite expResult = null;
        Tramite result = instance.getDocumentoExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDocumentoExpediente method, of class Expediente.
     */
    @Test
    public void testSetDocumentoExpediente() {
        System.out.println("setDocumentoExpediente");
        Tramite documentoExpediente = null;
        Expediente instance = null;
        instance.setDocumentoExpediente(documentoExpediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaArchivosExpediente method, of class Expediente.
     */
    @Test
    public void testGetListaArchivosExpediente() {
        System.out.println("getListaArchivosExpediente");
        Expediente instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getListaArchivosExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaArchivosExpediente method, of class Expediente.
     */
    @Test
    public void testSetListaArchivosExpediente() {
        System.out.println("setListaArchivosExpediente");
        ArrayList<String> listaArchivosExpediente = null;
        Expediente instance = null;
        instance.setListaArchivosExpediente(listaArchivosExpediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEstadoExpediente method, of class Expediente.
     */
    @Test
    public void testGetEstadoExpediente() {
        System.out.println("getEstadoExpediente");
        Expediente instance = null;
        Estado expResult = null;
        Estado result = instance.getEstadoExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEstadoExpediente method, of class Expediente.
     */
    @Test
    public void testSetEstadoExpediente() {
        System.out.println("setEstadoExpediente");
        Estado estadoExpediente = null;
        Expediente instance = null;
        instance.setEstadoExpediente(estadoExpediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMotivoExpediente method, of class Expediente.
     */
    @Test
    public void testGetMotivoExpediente() {
        System.out.println("getMotivoExpediente");
        Expediente instance = null;
        Motivo expResult = null;
        Motivo result = instance.getMotivoExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMotivoExpediente method, of class Expediente.
     */
    @Test
    public void testSetMotivoExpediente() {
        System.out.println("setMotivoExpediente");
        Motivo motivoExpediente = null;
        Expediente instance = null;
        instance.setMotivoExpediente(motivoExpediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarExpediente method, of class Expediente.
     */
    @Test
    public void testAgregarExpediente() {
        System.out.println("AgregarExpediente");
        Expediente instance = null;
        int expResult = 0;
        int result = instance.AgregarExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarExpedientes method, of class Expediente.
     */
    @Test
    public void testBuscarExpedientes() throws Exception {
        System.out.println("BuscarExpedientes");
        ResultSet expResult = null;
        ResultSet result = Expediente.BuscarExpedientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarExpedientePorNumero method, of class Expediente.
     */
    @Test
    public void testBuscarExpedientePorNumero() throws Exception {
        System.out.println("BuscarExpedientePorNumero");
        String numeroExpediente = "";
        ResultSet expResult = null;
        ResultSet result = Expediente.BuscarExpedientePorNumero(numeroExpediente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BorrarExpediente method, of class Expediente.
     */
    @Test
    public void testBorrarExpediente() {
        System.out.println("BorrarExpediente");
        String numeroExpediente = "";
        int expResult = 0;
        int result = Expediente.BorrarExpediente(numeroExpediente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isExpedienteBaja method, of class Expediente.
     */
    @Test
    public void testIsExpedienteBaja() {
        System.out.println("isExpedienteBaja");
        Expediente instance = null;
        boolean expResult = false;
        boolean result = instance.isExpedienteBaja();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setExpedienteBaja method, of class Expediente.
     */
    @Test
    public void testSetExpedienteBaja() {
        System.out.println("setExpedienteBaja");
        boolean expedienteBaja = false;
        Expediente instance = null;
        instance.setExpedienteBaja(expedienteBaja);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
