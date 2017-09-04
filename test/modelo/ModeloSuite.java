/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author SG0891660
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({modelo.TramiteTest.class, modelo.EmpresaTest.class, modelo.PersonaTest.class, modelo.FormularioTest.class, modelo.UnidadArmadaTest.class, modelo.RolTest.class, modelo.AGTest.class, modelo.NodoAGTest.class, modelo.EstadoTest.class, modelo.MotivoTest.class, modelo.EntidadTest.class, modelo.ExpedienteTest.class, modelo.ReportesTest.class})
public class ModeloSuite {

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
    
}
