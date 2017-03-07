/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author franciscocr
 */
public class partido {
    private String acronimo;
    private String nombre;
    private String imagen;
    private int numVotos;

    public partido() {
    }

    public partido(String acronimo, String nombre, String imagen, int numVotos) {
        this.acronimo = acronimo;
        this.nombre = nombre;
        this.imagen = imagen;
        this.numVotos = numVotos;
    }
    

    public String getAcronimo() {
        return acronimo;
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getNumVotos() {
        return numVotos;
    }

    public void setNumVotos(int numVotos) {
        this.numVotos = numVotos;
    }
    

    @Override
    public String toString() {
        return "partido{" + "acronimo=" + acronimo + ", nombre=" + nombre + ", imagen=" + imagen + '}';
    }
    
    
}
