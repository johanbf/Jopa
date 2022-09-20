/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.jopa.Clases;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author buitr
 */
public class TablaSimplex {
    
    private int filas;
    private int columnas;

    public TablaSimplex(int filas, int columnas) {
        this.filas = filas;
        this.columnas = columnas;
    }

    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getColumnas() {
        return columnas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }
    
    public void generarTabla(){
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tabla.getModel();
        int fila = Integer.parseInt(filas.getText());
        int columna = Integer.parseInt(columnas.getText());
        int columna1 = columna;
        for (int i = 0; i < columna; i++) {
            model.addColumn("x" + (i + 1));
        }
        columna = fila + columna;

        model.setRowCount(fila);
        model.setColumnCount(columna);
        for (int j = columna1; j < columna; j++) {
            tabla.setValueAt(0, 0, j);
        }
        int i1 = 1, j1 = columna1;
        for (int i = 1; i < fila; i++) {
            for (int j = columna1; j < columna - 1; j++) {
                if (i1 == i && j1 == j) {
                    tabla.setValueAt(1, i, j);
                } else {
                    tabla.setValueAt(0, i, j);
                }
            }
            j1++;
            i1++;
        }
    }
    
}
