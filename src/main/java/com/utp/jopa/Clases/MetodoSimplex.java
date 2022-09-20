/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.jopa.Clases;

/**
 *
 * @author buitr
 */
public class MetodoSimplex extends TablaSimplex{
    
    private double resultad;
    private int operacion;

    public MetodoSimplex(int filas, int columnas) {
        super(filas, columnas);
    }

    public MetodoSimplex(double resultad, int operacion, int filas, int columnas) {
        super(filas, columnas);
        this.resultad = resultad;
        this.operacion = operacion;
    }

    public double getResultad() {
        return resultad;
    }

    public void setResultad(double resultad) {
        this.resultad = resultad;
    }

    public int getOperacion() {
        return operacion;
    }

    public void setOperacion(int operacion) {
        this.operacion = operacion;
    }
    
    public void simplex(){
        
    }
    
    public void buscarMaximoNegativo(){
        
    }
    
    public void buscarPivote(){
        
    }
    
    public void convertirPivoteUno(){
       
    }
    
    public void convertirColumnaPrivoteCero(){
        
    }
}
