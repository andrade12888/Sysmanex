/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author SG0891660
 */
public class OrderClassTest {
    
    @Test
    public void testQSort() {
        System.out.println("QSort");
        int[] inputArr = new int[]{1,7,3,5,0};       
        OrderClass.QSort(inputArr);    
        String result="";
        for(int x=0; x<inputArr.length;x++)
            result += inputArr[x]+"";
        String expResult = "01357";
        

        assertEquals(expResult, result);
    }
    
}
