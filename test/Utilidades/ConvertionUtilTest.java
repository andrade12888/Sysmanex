/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.Date;
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
public class ConvertionUtilTest {
    
    public ConvertionUtilTest() {
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
     * Test of StringToInteger method, of class ConvertionUtil.
     */
    @Test
    public void testStringToInteger() {
        System.out.println("StringToInteger");
        String valor = "";
        int expResult = 0;
        int result = ConvertionUtil.StringToInteger(valor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of StringToDate method, of class ConvertionUtil.
     */
    @Test
    public void testStringToDate() throws Exception {
        System.out.println("StringToDate");
        String fecha = "";
        Date expResult = null;
        Date result = ConvertionUtil.StringToDate(fecha);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of CurrentDate method, of class ConvertionUtil.
     */
    @Test
    public void testCurrentDate() {
        System.out.println("CurrentDate");
        String expResult = "";
        String result = ConvertionUtil.CurrentDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
