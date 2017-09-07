/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SG0891660
 */
public class ConvertionUtilTest {
    
    /**
     * Test of StringToInteger method, of class ConvertionUtil.
     */
    @Test
    public void testStringToInteger() {
        System.out.println("StringToInteger TEST OK");
        String valor = "161";
        int expResult = 161;
        int result = ConvertionUtil.StringToInteger(valor);
        assertEquals(expResult, result);
    }
    
    @Test
    public void testStringToInteger2() {
        System.out.println("StringToInteger TEST ERROR");
        String valor = "hola";
        String result="";
        String expResult = "NumberFormatException";

        try{
       ConvertionUtil.StringToInteger(valor);
        } catch (NumberFormatException nfe)
        {
            result="NumberFormatException";
            assertEquals(expResult, result);
        }
      
    }

    /**
     * Test of StringToDate method, of class ConvertionUtil.
     */
    @Test
    public void testStringToDate() throws Exception {
        System.out.println("StringToDate TEST ERROR");
        String fecha = Date.from(Instant.now()).toString();
        String expResult = "Unparseable date";
        String result="";
        try{
            ConvertionUtil.StringToDate(fecha);   
           
               result="TODO OK";
        }catch(Exception  ex)
           { 
             result="Unparseable date";
             assertEquals(expResult, result);            
           } 
    }
    
    @Test
    public void testStringToDate2() throws Exception {
        System.out.println("StringToDate TEST OK");
        String fecha = "04/05/2017/";
        Date expResult = new SimpleDateFormat("dd/mm/yyyy").parse(fecha);
        Date result = ConvertionUtil.StringToDate(fecha);
        assertEquals(expResult, result);
    }

    /**
     * Test of CurrentDate method, of class ConvertionUtil.
     */
    @Test
    public void testCurrentDate() {
        System.out.println("CurrentDate");
        String expResult = "06/09/2017";
        String result = ConvertionUtil.CurrentDate();
        assertEquals(expResult, result);
    }
    
}
