/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author andra
 */
public class Documento {

    private int id;
    private String nombre;
    private String plazo;
    private boolean baja;

    public Documento() {
    }

    public Documento(String nombre, String plazo, boolean baja) {

        this.nombre = nombre;
        this.plazo = plazo;
        this.baja = baja;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public boolean isBaja() {
        return baja;
    }

    public void setBaja(boolean baja) {
        this.baja = baja;
    }

    public boolean AgregarDocumento() {
        if (!"".equals(this.nombre) && !"".equals(this.plazo)) {

            return true;
        } else {
            return false;
        }
    }

}
