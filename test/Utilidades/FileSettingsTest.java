/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import static org.junit.Assert.*;
import org.junit.Test;

/**
 *
 * @author SG0891660
 */
public class FileSettingsTest {

//    /**
//     * Test of GuardarArchivoEndDisco method, of class FileSettings.//     */
//    @Test
//    public void testGuardarArchivoEndDisco() throws Exception {
//        System.out.println("GuardarArchivoEndDisco");
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        factory.setSizeThreshold(FileSettings.getMaxMemSize());
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        HttpServletRequest request = null;
//
//        List fileItems = upload.parseRequest(request);
//        Iterator i = fileItems.iterator();
//        String url = "c:\\";
//        String expResult = "";
//        String result = FileSettings.GuardarArchivoEndDisco(i, url);
//        assertEquals(expResult, result);
//    }

    @Test
    public void testDoPost() throws Exception {

        System.out.println("GuardarArchivoEndDisco");
        String result="";
        String filePath = "c:";
       
             
        DiskFileItemFactory factory = new DiskFileItemFactory();               
        factory.setSizeThreshold(FileSettings.getMaxMemSize());                                
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setSizeMax( FileSettings.getMaxFileSize() );       
        List fileItems =  new ArrayList<>();        
        FileItem fi = factory.createItem("formFieldName", "application/text", false, "c:\\eula3052.txt");                             
        fi.getOutputStream();
        fileItems.add(fi);
        Iterator i = fileItems.iterator();   
        
       // final File TEST_FILE = new File("src/test/resources/test.jpg");
        //final DiskFileItem diskFileItem = new DiskFileItem("file", "image/jpeg", true, TEST_FILE.getName(), 100000000, TEST_FILE.getParentFile());
        
        
        result=FileSettings.GuardarArchivoEndDisco(i,filePath+"\\");                
        String url = "c:\\";
        String expResult = "c:\\eula3052.txt";
        

        assertEquals(expResult, result);
    }
    
    

}
