package Utilidades;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public abstract class ConvertionUtil {
    
    public static int StringToInteger(String valor)
    {      
        String Aux ="";
        int o = 0; 
       
        String [] comp = valor.split("[.^-]");       
        
        for(int i=0; i < comp.length ; i++)
        {
            Aux = Aux+comp[i];            
        }                           
        return Integer.parseInt(Aux);
        
    }    
    
    //PRE: El formato de la fecha ya fue controlado
    public static Date StringToDate(String fecha) throws ParseException
    {           
        Date fechaConvertida = new SimpleDateFormat("dd/mm/yyyy").parse(fecha);
        return fechaConvertida; 
    }
    
    public static String CurrentDate() 
   {    
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        String fechaConvertida = formatoFecha.format(today);                              

        return fechaConvertida;
    }
}
