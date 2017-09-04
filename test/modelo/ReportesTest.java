/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.sql.ResultSet;
import javax.swing.JPanel;
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
public class ReportesTest {
    
    public ReportesTest() {
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
     * Test of createDemoPanel method, of class Reportes.
     */
    @Test
    public void testCreateDemoPanel() {
        System.out.println("createDemoPanel");
        ResultSet rs = null;
        String opc = "";
        JPanel expResult = null;
        JPanel result = Reportes.createDemoPanel(rs, opc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuildReport method, of class Reportes.
     */
    @Test
    public void testBuildReport() {
        System.out.println("BuildReport");
        String nombreReporte = "";
        ResultSet rs = null;
        String opc = "";
        Reportes.BuildReport(nombreReporte, rs, opc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of LineChart method, of class Reportes.
     */
    @Test
    public void testLineChart() {
        System.out.println("LineChart");
        ResultSet rs = null;
        String opc = "";
        Reportes.LineChart(rs, opc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
