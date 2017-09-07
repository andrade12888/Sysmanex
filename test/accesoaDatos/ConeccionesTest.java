/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesoaDatos;

import java.sql.Connection;
import java.sql.ResultSet;
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
public class ConeccionesTest {             

    /**
     * Test of hacerConsulta method, of class Conecciones.
     */
    @Test
    public void testHacerConsulta() throws Exception {
        System.out.println("hacerConsulta");
        String query = "select * from \"SysmanexSch1\".\"Empresa\" where \"empresaNombre\" ='LUGRA';";
        Conecciones instance = new Conecciones();
        String expResult = "LUGRA";
        ResultSet results = instance.hacerConsulta(query);
        String result="";
        while(results.next())
        {result =results.getString("empresaNombre");}
        assertEquals(expResult, result);        
    }

    /**
     * Test of hacerConsultaIUD method, of class Conecciones.
     */
    @Test
    public void testHacerConsultaIUD() throws Exception {
        System.out.println("hacerConsultaIUD");
        String query = "INSERT INTO \"SysmanexSch1\".\"Empresa\" (\"empresaRut\", \"empresaNombre\") \n" +
"	VALUES ('1234567', 'TEST')";
        Conecciones instance = new Conecciones();
        int expResult = 1;
        int result = instance.hacerConsultaIUD(query);
        assertEquals(expResult, result);
    }
    
}
