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
        int expResult = 0;
        int result = instance.getNumeroExpediente();
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
        int numeroExpediente = 0;
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
     * Test of getEntidadDestino method, of class Expediente.
     */
    @Test
    public void testGetEntidadDestino() {
        System.out.println("getEntidadDestino");
        Expediente instance = null;
        Entidad expResult = null;
        Entidad result = instance.getEntidadDestino();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEntidadDestino method, of class Expediente.
     */
    @Test
    public void testSetEntidadDestino() {
        System.out.println("setEntidadDestino");
        Entidad entidadDestino = null;
        Expediente instance = null;
        instance.setEntidadDestino(entidadDestino);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaDocumentosExpediente method, of class Expediente.
     */
    @Test
    public void testGetListaDocumentosExpediente() {
        System.out.println("getListaDocumentosExpediente");
        Expediente instance = null;
        ArrayList<Documento> expResult = null;
        ArrayList<Documento> result = instance.getListaDocumentosExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaDocumentosExpediente method, of class Expediente.
     */
    @Test
    public void testSetListaDocumentosExpediente() {
        System.out.println("setListaDocumentosExpediente");
        ArrayList<Documento> listaDocumentosExpediente = null;
        Expediente instance = null;
        instance.setListaDocumentosExpediente(listaDocumentosExpediente);
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
    
}
