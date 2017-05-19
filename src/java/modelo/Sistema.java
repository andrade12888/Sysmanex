/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author andra
 */
public class Sistema {

    private ArrayList<Documento> listaDocumentos;

    public ArrayList<Documento> getListaDocumentos() {
        return listaDocumentos;
    }

    public void setListaDocumentos(ArrayList<Documento> listaDocumentos) {
        this.listaDocumentos = listaDocumentos;
    }

    public boolean AgregarDocumento(String nombre, String plazo) {
        Documento unDoc = new Documento(nombre, plazo, false);
        if (unDoc.AgregarDocumento()) {
            listaDocumentos.add(unDoc);
            return true;
        } else {
            return false;
        }

    }

}
