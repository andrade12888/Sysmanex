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
     * Test of getMisExpedientes method, of class Entidad.
     */
    @Test
    public void testGetMisExpedientes() {
        System.out.println("getMisExpedientes");
        Entidad instance = new Entidad();
        ArrayList<Expediente> expResult = null;
        ArrayList<Expediente> result = instance.getMisExpedientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMisExpedientes method, of class Entidad.
     */
    @Test
    public void testSetMisExpedientes() {
        System.out.println("setMisExpedientes");
        ArrayList<Expediente> misExpedientes = null;
        Entidad instance = new Entidad();
        instance.setMisExpedientes(misExpedientes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNombreEntidad method, of class Entidad.
     */
    @Test
    public void testGetNombreEntidad() {
        System.out.println("getNombreEntidad");
        Entidad instance = new Entidad();
        String expResult = "";
        String result = instance.getNombreEntidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNombreEntidad method, of class Entidad.
     */
    @Test
    public void testSetNombreEntidad() {
        System.out.println("setNombreEntidad");
        String nombreEntidad = "";
        Entidad instance = new Entidad();
        instance.setNombreEntidad(nombreEntidad);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getContrasenia method, of class Entidad.
     */
    @Test
    public void testGetContrasenia() {
        System.out.println("getContrasenia");
        Entidad instance = new Entidad();
        String expResult = "";
        String result = instance.getContrasenia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContrasenia method, of class Entidad.
     */
    @Test
    public void testSetContrasenia() {
        System.out.println("setContrasenia");
        String contrasenia = "";
        Entidad instance = new Entidad();
        instance.setContrasenia(contrasenia);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntidadId method, of class Entidad.
     */
    @Test
    public void testGetEntidadId() {
        System.out.println("getEntidadId");
        Entidad instance = new Entidad();
        int expResult = 0;
        int result = instance.getEntidadId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEntidadIdLargo method, of class Entidad.
     */
    @Test
    public void testGetEntidadIdLargo() {
        System.out.println("getEntidadIdLargo");
        Entidad instance = new Entidad();
        String expResult = "";
        String result = instance.getEntidadIdLargo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEntidadId method, of class Entidad.
     */
    @Test
    public void testSetEntidadId() {
        System.out.println("setEntidadId");
        int entidadId = 0;
        Entidad instance = new Entidad();
        instance.setEntidadId(entidadId);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getRol method, of class Entidad.
     */
    @Test
    public void testGetRol() {
        System.out.println("getRol");
        Entidad instance = new Entidad();
        Rol expResult = null;
        Rol result = instance.getRol();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setRol method, of class Entidad.
     */
    @Test
    public void testSetRol() {
        System.out.println("setRol");
        Rol rol = null;
        Entidad instance = new Entidad();
        instance.setRol(rol);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of Autenticar method, of class Entidad.
     */
    @Test
    public void testAutenticar() throws Exception {
        System.out.println("Autenticar");
        String nombre = "";
        String pass = "";
        Entidad instance = new Entidad();
        instance.Autenticar(nombre, pass);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ExpedientesDB method, of class Entidad.
     */
    @Test
    public void testExpedientesDB() {
        System.out.println("ExpedientesDB");
        Entidad instance = new Entidad();
        ResultSet expResult = null;
        ResultSet result = instance.ExpedientesDB();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of TablaExpedientes method, of class Entidad.
     */
    @Test
    public void testTablaExpedientes() {
        System.out.println("TablaExpedientes");
        Entidad instance = new Entidad();
        String expResult = "";
        String result = instance.TablaExpedientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AgregarEntidad method, of class Entidad.
     */
    @Test
    public void testAgregarEntidad() throws Exception {
        System.out.println("AgregarEntidad");
        Entidad instance = new Entidad();
        int expResult = 0;
        int result = instance.AgregarEntidad();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ModificarEntidad method, of class Entidad.
     */
    @Test
    public void testModificarEntidad() throws Exception {
        System.out.println("ModificarEntidad");
        String idEntidad = "";
        Entidad instance = new Entidad();
        int expResult = 0;
        int result = instance.ModificarEntidad(idEntidad);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEntidad method, of class Entidad.
     */
    @Test
    public void testBuscarEntidad_String() {
        System.out.println("BuscarEntidad");
        String nombre = "";
        ResultSet expResult = null;
        ResultSet result = Entidad.BuscarEntidad(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEntidadNombre method, of class Entidad.
     */
    @Test
    public void testBuscarEntidadNombre() {
        System.out.println("BuscarEntidadNombre");
        String nombre = "";
        Entidad instance = new Entidad();
        instance.BuscarEntidadNombre(nombre);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarEntidadId method, of class Entidad.
     */
    @Test
    public void testBuscarEntidadId() {
        System.out.println("buscarEntidadId");
        int id = 0;
        Entidad instance = new Entidad();
        instance.buscarEntidadId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of buscarEntidad method, of class Entidad.
     */
    @Test
    public void testBuscarEntidad_int() {
        System.out.println("buscarEntidad");
        int id = 0;
        String expResult = "";
        String result = Entidad.buscarEntidad(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarEntidades method, of class Entidad.
     */
    @Test
    public void testBuscarEntidades() throws Exception {
        System.out.println("BuscarEntidades");
        ResultSet expResult = null;
        ResultSet result = Entidad.BuscarEntidades();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enviarExpediente method, of class Entidad.
     */
    @Test
    public void testEnviarExpediente() {
        System.out.println("enviarExpediente");
        String expedienteNumero = "";
        Entidad destino = null;
        int idMotivo = 0;
        String obs = "";
        Entidad instance = new Entidad();
        int expResult = 0;
        int result = instance.enviarExpediente(expedienteNumero, destino, idMotivo, obs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of reEnviarExpediente method, of class Entidad.
     */
    @Test
    public void testReEnviarExpediente() {
        System.out.println("reEnviarExpediente");
        String expedienteNumero = "";
        Entidad destino = null;
        int idMotivo = 0;
        String obs = "";
        Entidad instance = new Entidad();
        int expResult = 0;
        int result = instance.reEnviarExpediente(expedienteNumero, destino, idMotivo, obs);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of queSoy method, of class Entidad.
     */
    @Test
    public void testQueSoy() {
        System.out.println("queSoy");
        Entidad instance = new Entidad();
        int expResult = 0;
        int result = instance.queSoy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ExpedientesRecibidos method, of class Entidad.
     */
    @Test
    public void testExpedientesRecibidos() throws Exception {
        System.out.println("ExpedientesRecibidos");
        Entidad instance = new Entidad();
        ResultSet expResult = null;
        ResultSet result = instance.ExpedientesRecibidos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of tablaTramitados method, of class Entidad.
     */
    @Test
    public void testTablaTramitados() {
        System.out.println("tablaTramitados");
        String exp = "";
        Entidad instance = new Entidad();
        String expResult = "";
        String result = instance.tablaTramitados(exp);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastExpediente method, of class Entidad.
     */
    @Test
    public void testGetLastExpediente() {
        System.out.println("getLastExpediente");
        Entidad instance = new Entidad();
        String expResult = "";
        String result = instance.getLastExpediente();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
