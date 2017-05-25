/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Nova
 */
public class Estado {

    private int id;
    private String nombre;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Estado(String nombre) {
        this.nombre = nombre;
    }
       

    public int AgregarEstado(int id) {
        return 0;
    }
    
    public int ActualizarEstado(int id){
        return 0;
    }

    public int EliminarEstado(int id) {
        return 0;
    }
    
    public void BuscarEstado(String nombre){}
    
    public void BuscarEstado(int id){}

    @Override
    public String toString() {
        return nombre;
    }
    
    

}
