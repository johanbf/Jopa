
package com.utp.jopa.Dto;

public class Persona {
    private String nombre;
    private int valor;
    private int id;

    
    public Persona(String nombre, int valor, int id) {
        this.nombre = nombre;
        this.valor = valor;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
