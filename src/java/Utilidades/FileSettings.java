/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;


import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author SG0891660
 */
public abstract class FileSettings {

    private static boolean isMultipart;
    private static final int maxFileSize = 1 * 1024 * 1024; //1MB
    private static final int maxMemSize = 4 * 1024 * 1024; //1MB

    private static final String MultipartConfiglocation = "/tmp";
    private static final int MultipartConfigfileSizeThreshold = 1024 * 1024;
    private static final int MultipartConfigmaxFileSize = 1024 * 1024 * 5;
    private static final int MultipartConfigmaxRequestSize = 1024 * 1024 * 5 * 5;
    private static File file;

    /**
     * @return the isMultipart
     */
    public static boolean isIsMultipart() {
        return isMultipart;
    }

    public static void setIsMultipart(boolean ismultipart) {
        isMultipart = ismultipart;
    }


    /**
     * @return the maxFileSize
     */
    public static int getMaxFileSize() {
        return maxFileSize;
    }

    /**
     * @return the maxMemSize
     */
    public static int getMaxMemSize() {
        return maxMemSize;
    }

    /**
     * @return the MultipartConfiglocation
     */
    public static String getMultipartConfiglocation() {
        return MultipartConfiglocation;
    }

    /**
     * @return the MultipartConfigfileSizeThreshold
     */
    public static int getMultipartConfigfileSizeThreshold() {
        return MultipartConfigfileSizeThreshold;
    }

    /**
     * @return the MultipartConfigmaxFileSize
     */
    public static int getMultipartConfigmaxFileSize() {
        return MultipartConfigmaxFileSize;
    }

    /**
     * @return the MultipartConfigmaxRequestSize
     */
    public static int getMultipartConfigmaxRequestSize() {
        return MultipartConfigmaxRequestSize;
    }

    
public static String GuardarArchivoEndDisco(Iterator items, String url) throws Exception {
        String filename=""; 
        String fileName="";
        int cont=0;
        FileItem fi2=null;
        FileItem  fi=null;
        boolean flag=false;
        
        while ( items.hasNext () ) {            
          if(cont==0)
            fi  = (FileItem)items.next();
          else fi2 = (FileItem)items.next();
          cont++;
            if ( !fi.isFormField () ) {
               // Get the uploaded file parameters
               String fieldName = fi.getFieldName();
               fileName= fi.getName();
               boolean isInMemory = fi.isInMemory();
               long sizeInBytes = fi.getSize();
               InputStream fileContent = fi.getInputStream();
                       
               // Write the file
               if( fileName.lastIndexOf("\\") >= 0 ) {
                  file = new File( url + 
                  fileName.substring( fileName.lastIndexOf("\\"))) ;
               } else {
                  file = new File( url + 
                  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
               }
                    
            }
            if(fi2!=null && "txtNuevoTexto".equals(fi2.getFieldName()) && !"".equals(fi2.getString()))
            {                 
                String fieldName = fi2.getString();
                String[] parts = fileName.split("[.]");
                String part1 = parts[1];
                fileName=fieldName+"."+part1;                  
                
                // Write the file
               if( fileName.lastIndexOf("\\") >= 0 ) {
                  file = new File( url + 
                  fileName.substring( fileName.lastIndexOf("\\"))) ;
               } else {
                  file = new File( url + 
                  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
               } 
                    fi2=fi;
                    fi2.write( file ) ;                                     
                    flag = true;
            }
                        
         } 
        if(!flag && fi!=null)
            fi.write( file ) ;
     filename= fileName ;
     return filename;
    }


}
    