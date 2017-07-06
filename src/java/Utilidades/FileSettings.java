/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades;


import java.io.File;
import static java.lang.System.out;
import java.util.Iterator;
import org.apache.commons.fileupload.FileItem;

/**
 *
 * @author SG0891660
 */
public abstract class FileSettings {

    private static boolean isMultipart;
    private static final String filePathWeb = "\\Sysmanex\\upload\\";
    private static final String filePathLocal = "C:\\Users\\sg0891660\\Documents\\ORT\\Proyecto Integrador\\BkupSysmanexx\\Sysmanex\\web\\upload\\";
    private static final int maxFileSize = 50 * 1024;
    private static final int maxMemSize = 4 * 1024;

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

    
    public static String GuardarArchivoEndDisco(Iterator items) throws Exception {
        
        String filename="";
        while ( items.hasNext () ) {
            FileItem fi = (FileItem)items.next();
            if ( !fi.isFormField () ) {
               // Get the uploaded file parameters
               String fieldName = fi.getFieldName();
               String fileName = fi.getName();
               boolean isInMemory = fi.isInMemory();
               long sizeInBytes = fi.getSize();
            
               // Write the file
               if( fileName.lastIndexOf("\\") >= 0 ) {
                  file = new File( filePathLocal + 
                  fileName.substring( fileName.lastIndexOf("\\"))) ;
               } else {
                  file = new File( filePathLocal + 
                  fileName.substring(fileName.lastIndexOf("\\")+1)) ;
               }
               fi.write( file ) ;
              
              filename= fileName ;
            }
         } 
     return filename;
    }

    /**
     * @return the filePathWeb
     */
    public static String getFilePathWeb() {
        return filePathWeb;
    }

    /**
     * @return the filePathLocal
     */
    public static String getFilePathLocal() {
        return filePathLocal;
    }

}
