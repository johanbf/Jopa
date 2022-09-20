/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.jopa.Clases;

import java.text.DecimalFormat;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author buitr
 */
public class TablaSimplex {

    private static void append(String metodo_simplex) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private static Object getValueAt(int i, int j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int filas;
    private int columnas;
    private javax.swing.JTable tablaSimplex;

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
        
        DefaultTableModel model = (DefaultTableModel) tablaSimplex.getModel();
        int fila = 2;
        int columna = 3;
        int columna1 = columna;
        for (int i = 0; i < columna; i++) {
            model.addColumn("x" + (i + 1));
        }
        columna = fila + columna;

        model.setRowCount(fila);
        model.setColumnCount(columna);
        for (int j = columna1; j < columna; j++) {
            tablaSimplex.setValueAt(0, 0, j);
        }
        int i1 = 1, j1 = columna1;
        for (int i = 1; i < fila; i++) {
            for (int j = columna1; j < columna - 1; j++) {
                if (i1 == i && j1 == j) {
                    tablaSimplex.setValueAt(1, i, j);
                } else {
                    tablaSimplex.setValueAt(0, i, j);
                }
            }
            j1++;
            i1++;
        }
    }
    
    public void Calcular(){
    
        TablaSimplex.append("METODO SIMPLEX\n");
        DecimalFormat l = new DecimalFormat("0.000");
        int fila = Integer.parseInt(String.valueOf(filas));
        int columna = Integer.parseInt(String.valueOf(columnas));
        int columna1 = columna;
        columna = fila + columna;
        double v[][] = new double[fila][columna];
        int y1 = 1;
        for (int i = 0; i < columna; i++) {
            if (i < columna1) {
                TablaSimplex.append("\t x" + (i + 1));
            } else if (i >= columna1 && i < columna - 1) {
                TablaSimplex.append("\t d" + (y1));
                y1++;

            } else {
                TablaSimplex.append("\t resul");

            }
        }
        TablaSimplex.append("\n");
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                v[i][j] = Double.parseDouble(TablaSimplex.getValueAt(i, j).toString());
            }
        }

        for (int i = 0; i < fila; i++) {
            if(i!=0){
                TablaSimplex.append("d"+i);
            }
            for (int j = 0; j < columna; j++) {
                TablaSimplex.append("\t " + l.format(v[i][j]));
            }
            TablaSimplex.append("\n");
        }
        TablaSimplex.append("\n\n");
        String v2[] = new String[fila];
        int v3[] = new int[fila];
        int v4[] = new int[fila];
        int co = 0;
        while (true) {
            if (co == columna1) {
                break;
            }

            int f = 0, c = 0;
            double negativo = 0;
            for (int i = 0; i < columna1; i++) {
                if (v[0][i] < negativo) {
                    negativo = v[0][i];
                    c = i;
                }
            }
            TablaSimplex.append("EL MAXIMO NEGATIVO ES\n");
            TablaSimplex.append(" " + negativo + "\nla columna es \n");
            for (int i = 0; i < fila; i++) {
                TablaSimplex.append(" " + v[i][c] + "\n");
            }
            TablaSimplex.append("\n");
            TablaSimplex.append("\n dividiendo con la columna\n");
            double menor = 0;
            double v1[] = new double[fila - 1];
            int h = 0;
            for (int i = 1; i < fila; i++) {
                v1[h] = v[i][columna - 1] / v[i][c];
                TablaSimplex.append(" " + v[i][columna - 1] + " / " + v[i][c] + " = " + v1[h] + " \n");
                h++;
            }
            menor = v1[0];
            for (int i = 0; i < fila - 1; i++) {
                if (v1[i] <= menor) {
                    menor = v1[i];
                    f = i + 1;
                }
            }
            TablaSimplex.append("el menor de la division es: " + menor + "\n");
            double pivo = v[f][c];
            TablaSimplex.append("el pivote es:" + pivo);

            TablaSimplex.append("\nproceso de convertir el pivote en 1\n dividiendo toda la fila con el pivote\n");
            for (int i = 0; i < columna; i++) {
                double va = v[f][i];
                v[f][i] = v[f][i] / pivo;
                TablaSimplex.append("" + va + " / " + pivo + " = " + v[f][i] + "\n");
            }
            for (int i = 1; i < fila; i++) {
                if (i == f) {
                    v2[i] = "x" + (c + 1);
                    v3[i] = c + 1;
                    v4[i] = i;
                }
                if (v3[i] <= 0) {

                    v2[i] = "d" + (i);
                }
            }

            TablaSimplex.append("\n proceso \n ");
            for (int i = 0; i < fila; i++) {
                if (i != f) {
                    TablaSimplex.append("Convertiendo la columna del pivote en cero, en fila" + (i + 1) + "\n\n");

                    double guar = 0;
                    guar = -v[i][c];
                    for (int j = 0; j < columna; j++) {
                        double vaa = v[i][j];
                        v[i][j] = guar * v[f][j] + v[i][j];
                        TablaSimplex.append(" " + guar + "*" + v[f][j] + " + " + vaa + " = " + v[i][j] + "\n");
                    }
                }
            }
            co = 0;
            for (int i = 0; i < columna1; i++) {
                if (v[0][i] >= 0) {
                    co++;
                }
            }
            y1=1;
            for (int i = 0; i < columna; i++) {
                if (i < columna1) {
                    TablaSimplex.append("\t x" + (i + 1));
                } else if (i >= columna1 && i < columna - 1) {
                    TablaSimplex.append("\t d" + (y1));
                    y1++;

                } else {
                    TablaSimplex.append("\t resul");

                }
            }
            TablaSimplex.append("\n");
           
            for (int i = 0; i < fila; i++) {
           if(i!=0){
           TablaSimplex.append(v2[i]);
           }
                for (int j = 0; j < columna; j++) {
                    TablaSimplex.append("\t " + l.format(v[i][j]));
                }
                TablaSimplex.append("\n");
            }
            TablaSimplex.append("\n\n");

        }
        int y2 = 0;
        TablaSimplex.append("RESULTADO\n");
        TablaSimplex.append("z = "+v[0][columna-1]+"\n");
        for (int i = 1; i<fila; i++) {
            char m1[]=v2[i].toCharArray();
            if(m1[0]=='x'){
            TablaSimplex.append(" "+v2[i]+" = "+v[v4[i]][columna-1]+"\n");
            }
        }
    
    }
    
}
