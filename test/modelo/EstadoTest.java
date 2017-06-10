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
public class EstadoTest {
    
    public EstadoTest() {
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
     * Test of getEstadoDB method, of class Estado.
     */
    @Test
    public void testGetEstadoDB() {
        System.out.println("getEstadoDB");
        int estadoId = 1;
        String expResult = "En Tramite";
        String result = Estado.getEstadoDB(estadoId);
        assertEquals(expResult, result);
    }

    /**
     * Test of AgregarEstado method, of class Estado.
     */
    @Test
    public void testAgregarEstado() throws SQLException {
        System.out.println("AgregarEstado");
        Estado instance = new Estado("Negado");
        int expResult = 1;
        int result = instance.AgregarEstado();
        assertEquals(expResult, result);
    }

    /**
     * Test of ModificarEstado method, of class Estado.
     */
    @Test
    public void testModificarEstado() {
//        System.out.println("ModificarEstado");
//        int idEstadi = 4;
//        String descripcionEstado = "Denegado";
//        boolean nuevoEstadoBaja = false;
//        int expResult = 1;
//        int result = Estado.ModificarEstado(idEstadi, descripcionEstado, nuevoEstadoBaja);
//        assertEquals(expResult, result);
    }

    /**
     * Test of BuscarEstados method, of class Estado.
     */
    @Test
    public void testBuscarEstados() throws SQLException {
        System.out.println("BuscarEstados");
        int expResult = 3;
        ResultSet result = Estado.BuscarEstados();
        result.next();
        int rs = result.getInt("estadoId");
        assertEquals(expResult, rs);
    }
    
}
