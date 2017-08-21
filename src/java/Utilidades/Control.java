package Utilidades;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Empresa;


public abstract class Control {

    private static Pattern pattern;
    private static Matcher matcher;

    private static final String EMAIL_PATTERN
            = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String CEL_PATTERN = "^[0][9][0-9]{7}$";

    private static final String CI_PATTERN = "^[0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9]$";
    
    //Ejemplo: 25/01/2018
    private static final String DATE_PATTERN= "(0[1-9]|[12][0-9]|3[01])[/](0[1-9]|1[012])[/](19|20)[0-9]{2}";
    
    //Ejemplo: 01/25/2018
    private static final String DATE_PATTERNEXTENDED= "(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)[0-9]{2}";

                        // <editor-fold defaultstate="collapsed" desc="My Control Functions"> 
    public static boolean ControlarCedula(String cedula) {
        return cedula.matches("([0-9].[0-9][0-9][0-9].[0-9][0-9][0-9]-[0-9])");
    }

    public static boolean ControlarCelular(String celular) {
        return celular.matches("([0][9][0-9][0-9][0-9][0-9][0-9][0-9][0-9])");
    }

    public static boolean ControlarNombre(String nombre) {
        if (nombre == null || nombre.equals("")) {
            return false;
        }

        /*  Validates the followin pattern
         Peter Müller
         François Hollande
         Patrick O'Brian
         Silvana Koch-Mehrin
         */
        if (!nombre.matches("^[\\p{L} .'-]+$")) {
            return false;
        }
        return true;
    }

    public static boolean ControlarEmail(String email) {
        return email.matches("^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$");
    }

    // </editor-fold>
                        // <editor-fold defaultstate="collapsed" desc="REGEX Functions">
    public static boolean ValidateEmail(String email) {

        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean ValidateCel(String celular) {

        pattern = Pattern.compile(CEL_PATTERN);
        matcher = pattern.matcher(celular);
        return matcher.matches();
    }

    public static boolean ValidateCI(String ci) {

        pattern = Pattern.compile(CI_PATTERN);
        matcher = pattern.matcher(ci);
        return matcher.matches();
    }
    
    public static boolean ValidateDate(String date) {

        pattern = Pattern.compile(DATE_PATTERN);
        matcher = pattern.matcher(date);
        return matcher.matches();
    }
    

    // </editor-fold> 
    
    
      // Metodo que reotorna al JSP gestionUsuario true si la empresa con el rut y nombre ya se encuentran en el sistema, sino false    
    public static boolean ControlEmpresaExistente(Empresa e, HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            if(Empresa.BuscarEmpresaPorNombre(e.getNombreEmpresa()).next() ||
                    Empresa.BuscarEmpresaPorRUT(e.getRutEmpresa()).next())
                return true;
            else return false;
        } catch (SQLException ex) {
            return false;
        }
    }
}
