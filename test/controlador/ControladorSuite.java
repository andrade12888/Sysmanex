/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

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
@Suite.SuiteClasses({controlador.CReportesTest.class, controlador.CVisualizarExpedienteTest.class, controlador.CFormulariosTest.class, controlador.CUsuariosTest.class, controlador.ProcesarTest.class, controlador.CEmpresasTest.class, controlador.CTramitesTest.class, controlador.CReEnvioTest.class, controlador.CExternoTest.class, controlador.CEditarExpedienteTest.class, controlador.CMotivosTest.class, controlador.CExpedienteTest.class, controlador.CEnvioTest.class})
public class ControladorSuite {

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
