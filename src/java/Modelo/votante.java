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
public class votante {
    private String dni;
    private String nombre;
    private String contraseña;
    private boolean voto;

    public votante() {
    }

    public votante(String dni, String nombre, String contraseña) {
        this.dni = dni;
        this.nombre = nombre;
        this.voto = false;
        this.contraseña = contraseña;
    }

    public votante(String dni, String nombre, boolean voto) {
        this.dni = dni;
        this.contraseña = "";
        this.nombre = nombre;
        this.voto = voto;
    }
    
    

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    

    public boolean isVoto() {
        return voto;
    }

    public void setVoto(boolean voto) {
        this.voto = voto;
    }

    @Override
    public String toString() {
        return "votante{" + "dni=" + dni + ", nombre=" + nombre + ", voto=" + voto + '}';
    }
}
