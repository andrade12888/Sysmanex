/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empresa;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author SG0891660
 */
public class ControlTest {        

    /**
     * Test of ControlarCedula method, of class Control.
     */
    @Test
    public void testControlarCedula() {
        System.out.println("ControlarCedula Test ERROR");
        String cedula = "36548-8";
        boolean expResult = false;
        boolean result = Control.ControlarCedula(cedula);
        assertEquals(expResult, result);      
    }
        /**
     * Test of ControlarCedula method, of class Control.
     */
    @Test
    public void testControlarCedula2() {
        System.out.println("ControlarCedula Test OK");
        String cedula = "3.760.536-0";
        boolean expResult = true;
        boolean result = Control.ControlarCedula(cedula);
        assertEquals(expResult, result);      
    }

    /**
     * Test of ControlarCelular method, of class Control.
     */
    @Test
    public void testControlarCelular() {
        System.out.println("ControlarCelular Test ERROR");
        String celular = "0994561564";
        boolean expResult = false;
        boolean result = Control.ControlarCelular(celular);
        assertEquals(expResult, result);        
    }
    
        /**
     * Test of ControlarCelular method, of class Control.
     */
    @Test
    public void testControlarCelular2() {
        System.out.println("ControlarCelular Test OK");
        String celular = "099456156";
        boolean expResult = true;
        boolean result = Control.ControlarCelular(celular);
        assertEquals(expResult, result);        
    }
    

    /**
     * Test of ControlarNombre method, of class Control.
     *   Validates the followin pattern
         Peter Müller
         François Hollande
         Patrick O'Brian
         Silvana Koch-Mehrin
         
     */
    @Test
    public void testControlarNombre() {
        System.out.println("ControlarNombre TEST OK");
        String nombre = "Test Gabriel";
        boolean expResult = true;
        boolean result = Control.ControlarNombre(nombre);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ControlarNombre method, of class Control.
     *   Validates the followin pattern
         Peter Müller
         François Hollande
         Patrick O'Brian
         Silvana Koch-Mehrin
         
     */
    @Test
    public void testControlarNombre2() {
        System.out.println("ControlarNombre TEST ERROR");
        String nombre = "Test  5 Gabriel";
        boolean expResult = false;
        boolean result = Control.ControlarNombre(nombre);
        assertEquals(expResult, result);
    }

    /**
     * Test of ControlarEmail method, of class Control.
     */
    @Test
    public void testControlarEmail() {
        System.out.println("ControlarEmail TEST OK");
        String email = "TEST@gmail.com";
        boolean expResult = true;
        boolean result = Control.ControlarEmail(email);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of ControlarEmail method, of class Control.
     */
    @Test
    public void testControlarEmail2() {
        System.out.println("ControlarEmail TEST ERROR");
        String email = "TESTgmail.com";
        boolean expResult = false;
        boolean result = Control.ControlarEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of ValidateEmail method, of class Control.
     */
    @Test
    public void testValidateEmail() {
        System.out.println("ValidateEmail TEST OK");
        String email = "email@correo.com";
        boolean expResult = true;
        boolean result = Control.ValidateEmail(email);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ValidateEmail method, of class Control.
     */
    @Test
    public void testValidateEmail2() {
        System.out.println("ValidateEmail TEST ERROR");
        String email = "email@correo.";
        boolean expResult = false;
        boolean result = Control.ValidateEmail(email);
        assertEquals(expResult, result);
    }

    /**
     * Test of ValidateCel method, of class Control.
     */
    @Test
    public void testValidateCel() {
        System.out.println("ValidateCel TEST OK");
        String celular = "098456888";
        boolean expResult = true;
        boolean result = Control.ValidateCel(celular);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ValidateCel method, of class Control.
     */
    @Test
    public void testValidateCel2() {
        System.out.println("ValidateCel TEST ERROR");
        String celular = "098456787888";
        boolean expResult = false;
        boolean result = Control.ValidateCel(celular);
        assertEquals(expResult, result);
    }

    /**
     * Test of ValidateCI method, of class Control.
     */
    @Test
    public void testValidateCI() {
        System.out.println("ValidateCI TEST OK");
        String ci = "1.787.111-3";
        boolean expResult = true;
        boolean result = Control.ValidateCI(ci);
        assertEquals(expResult, result);      
    }
    
    /**
     * Test of ValidateCI method, of class Control.
     */
    @Test
    public void testValidateCI2() {
        System.out.println("ValidateCI TEST OK");
        String ci = "1.787-111.3";
        boolean expResult = false;
        boolean result = Control.ValidateCI(ci);
        assertEquals(expResult, result);      
    }

    /**
     * Test of ValidateDate method, of class Control.
     */
    @Test
    public void testValidateDate() {
        System.out.println("ValidateDate TEST OK");
        String date = "11/08/2001";
        boolean expResult = true;
        boolean result = Control.ValidateDate(date);
        assertEquals(expResult, result);
    }
    

    @Test
    public void testValidateDate2() {
        System.out.println("ValidateDate TEST ERROR");
        String date = "1-08-2001";
        boolean expResult = false;
        boolean result = Control.ValidateDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of ControlEmpresaExistente method, of class Control.
     */
    @Test
    public void testControlEmpresaExistente() throws Exception {
        System.out.println("ControlEmpresaExistente");
        Empresa e = new Empresa();
        e.setNombreEmpresa("LUGRA");
        boolean expResult = true;
        boolean result = Control.ControlEmpresaExistente(e, null,null);
        assertEquals(expResult, result);
        
    }
    
}
