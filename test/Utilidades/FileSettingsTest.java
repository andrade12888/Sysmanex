/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.Iterator;
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
public class FileSettingsTest {
    
    public FileSettingsTest() {
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
     * Test of isIsMultipart method, of class FileSettings.
     */
    @Test
    public void testIsIsMultipart() {
        System.out.println("isIsMultipart");
        boolean expResult = false;
        boolean result = FileSettings.isIsMultipart();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsMultipart method, of class FileSettings.
     */
    @Test
    public void testSetIsMultipart() {
        System.out.println("setIsMultipart");
        boolean ismultipart = false;
        FileSettings.setIsMultipart(ismultipart);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxFileSize method, of class FileSettings.
     */
    @Test
    public void testGetMaxFileSize() {
        System.out.println("getMaxFileSize");
        int expResult = 0;
        int result = FileSettings.getMaxFileSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMaxMemSize method, of class FileSettings.
     */
    @Test
    public void testGetMaxMemSize() {
        System.out.println("getMaxMemSize");
        int expResult = 0;
        int result = FileSettings.getMaxMemSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMultipartConfiglocation method, of class FileSettings.
     */
    @Test
    public void testGetMultipartConfiglocation() {
        System.out.println("getMultipartConfiglocation");
        String expResult = "";
        String result = FileSettings.getMultipartConfiglocation();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMultipartConfigfileSizeThreshold method, of class FileSettings.
     */
    @Test
    public void testGetMultipartConfigfileSizeThreshold() {
        System.out.println("getMultipartConfigfileSizeThreshold");
        int expResult = 0;
        int result = FileSettings.getMultipartConfigfileSizeThreshold();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMultipartConfigmaxFileSize method, of class FileSettings.
     */
    @Test
    public void testGetMultipartConfigmaxFileSize() {
        System.out.println("getMultipartConfigmaxFileSize");
        int expResult = 0;
        int result = FileSettings.getMultipartConfigmaxFileSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMultipartConfigmaxRequestSize method, of class FileSettings.
     */
    @Test
    public void testGetMultipartConfigmaxRequestSize() {
        System.out.println("getMultipartConfigmaxRequestSize");
        int expResult = 0;
        int result = FileSettings.getMultipartConfigmaxRequestSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of GuardarArchivoEndDisco method, of class FileSettings.
     */
    @Test
    public void testGuardarArchivoEndDisco() throws Exception {
        System.out.println("GuardarArchivoEndDisco");
        Iterator items = null;
        String url = "";
        String expResult = "";
        String result = FileSettings.GuardarArchivoEndDisco(items, url);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
