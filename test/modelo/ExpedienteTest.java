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
        Expediente instance = new Expediente();
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
        int entidadId = 0;
        Expediente instance = new Expediente();
        instance.setNumeroExpediente(numeroExpediente, entidadId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFechaExpediente method, of class Expediente.
     */
    @Test
    public void testGetFechaExpediente() {
        System.out.println("getFechaExpediente");
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
        instance.setListaDestinariosExpediente(listaDestinariosExpediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaDetalle method, of class Expediente.
     */
    @Test
    public void testGetListaDetalle() {
        System.out.println("getListaDetalle");
        Expediente instance = new Expediente();
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.getListaDetalle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListaDetalle method, of class Expediente.
     */
    @Test
    public void testSetListaDetalle() {
        System.out.println("setListaDetalle");
        ArrayList<String> listaDetalle = null;
        Expediente instance = new Expediente();
        instance.setListaDetalle(listaDetalle);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntidadOrigien method, of class Expediente.
     */
    @Test
    public void testGetEntidadOrigien() {
        System.out.println("getEntidadOrigien");
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
        instance.setEntidadOrigien(entidadOrigien);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTramiteExpediente method, of class Expediente.
     */
    @Test
    public void testGetTramiteExpediente() {
        System.out.println("getTramiteExpediente");
        Expediente instance = new Expediente();
        Tramite expResult = null;
        Tramite result = instance.getTramiteExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTramiteExpediente method, of class Expediente.
     */
    @Test
    public void testSetTramiteExpediente() {
        System.out.println("setTramiteExpediente");
        Tramite TramiteExpediente = null;
        Expediente instance = new Expediente();
        instance.setTramiteExpediente(TramiteExpediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListaArchivosExpediente method, of class Expediente.
     */
    @Test
    public void testGetListaArchivosExpediente() {
        System.out.println("getListaArchivosExpediente");
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
        instance.setMotivoExpediente(motivoExpediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isExpedienteBaja method, of class Expediente.
     */
    @Test
    public void testIsExpedienteBaja() {
        System.out.println("isExpedienteBaja");
        Expediente instance = new Expediente();
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
        Expediente instance = new Expediente();
        instance.setExpedienteBaja(expedienteBaja);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarExpediente method, of class Expediente.
     */
    @Test
    public void testAgregarExpediente() {
        System.out.println("AgregarExpediente");
        Expediente instance = new Expediente();
        int expResult = 0;
        int result = instance.AgregarExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarArchivoExpediente method, of class Expediente.
     */
    @Test
    public void testAgregarArchivoExpediente() {
        System.out.println("AgregarArchivoExpediente");
        String url = "";
        Expediente instance = new Expediente();
        int expResult = 0;
        int result = instance.AgregarArchivoExpediente(url);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarExpedientePorNumero method, of class Expediente.
     */
    @Test
    public void testBuscarExpedientePorNumero() {
        System.out.println("BuscarExpedientePorNumero");
        String numeroExpediente = "";
        Expediente instance = new Expediente();
        ResultSet expResult = null;
        ResultSet result = instance.BuscarExpedientePorNumero(numeroExpediente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarDetalle method, of class Expediente.
     */
    @Test
    public void testAgregarDetalle() {
        System.out.println("AgregarDetalle");
        String detalle = "";
        int entidadId = 0;
        Expediente instance = new Expediente();
        instance.AgregarDetalle(detalle, entidadId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of traerExpediente method, of class Expediente.
     */
    @Test
    public void testTraerExpediente() {
        System.out.println("traerExpediente");
        String numeroExpediente = "";
        Expediente instance = new Expediente();
        instance.traerExpediente(numeroExpediente);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Destinos method, of class Expediente.
     */
    @Test
    public void testDestinos() throws Exception {
        System.out.println("Destinos");
        String numeroExpediente = "";
        ResultSet expResult = null;
        ResultSet result = Expediente.Destinos(numeroExpediente);
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
        Expediente instance = new Expediente();
        int expResult = 0;
        int result = instance.BorrarExpediente(numeroExpediente);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ExpedienteTramitado method, of class Expediente.
     */
    @Test
    public void testExpedienteTramitado() {
        System.out.println("ExpedienteTramitado");
        Expediente instance = new Expediente();
        ResultSet expResult = null;
        ResultSet result = instance.ExpedienteTramitado();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostrarSeguimiento method, of class Expediente.
     */
    @Test
    public void testMostrarSeguimiento() {
        System.out.println("mostrarSeguimiento");
        String nume = "";
        Expediente instance = new Expediente();
        String expResult = "";
        String result = instance.mostrarSeguimiento(nume);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of seguimientoExpedientes method, of class Expediente.
     */
    @Test
    public void testSeguimientoExpedientes() {
        System.out.println("seguimientoExpedientes");
        String nume = "";
        Expediente instance = new Expediente();
        AG expResult = null;
        AG result = instance.seguimientoExpedientes(nume);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarExpedientePorTramite method, of class Expediente.
     */
    @Test
    public void testBuscarExpedientePorTramite() {
        System.out.println("BuscarExpedientePorTramite");
        int tramiteId = 0;
        int expResult = 0;
        int result = Expediente.BuscarExpedientePorTramite(tramiteId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of traerArchivos method, of class Expediente.
     */
    @Test
    public void testTraerArchivos() {
        System.out.println("traerArchivos");
        Expediente instance = new Expediente();
        instance.traerArchivos();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of leerExpediente method, of class Expediente.
     */
    @Test
    public void testLeerExpediente() {
        System.out.println("leerExpediente");
        int entidadId = 0;
        Expediente instance = new Expediente();
        instance.leerExpediente(entidadId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of traerDetalle method, of class Expediente.
     */
    @Test
    public void testTraerDetalle() {
        System.out.println("traerDetalle");
        Expediente instance = new Expediente();
        instance.traerDetalle();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TablaReportesVencidos method, of class Expediente.
     */
    @Test
    public void testTablaReportesVencidos() {
        System.out.println("TablaReportesVencidos");
        String expResult = "";
        String result = Expediente.TablaReportesVencidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ExpedientesVencidosPorAno method, of class Expediente.
     */
    @Test
    public void testExpedientesVencidosPorAno() {
        System.out.println("ExpedientesVencidosPorAno");
        String year = "";
        ResultSet expResult = null;
        ResultSet result = Expediente.ExpedientesVencidosPorAno(year);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
