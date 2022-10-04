/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.utp.jopa.Clases;

import java.text.DecimalFormat;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

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
    
    public void simplex(JTextArea Consola,JTable TableSimplex){
        int fila = getFilas();
        int columna = getColumnas();
        int columna1 = columna;
        columna = fila + columna;
        double v[][] = new double[fila][columna];
        int y1 = 1;
        DecimalFormat l = new DecimalFormat("0.000");
        boolean consolaInicial = MostrarTablaConsola(Consola, TableSimplex, columna, columna1, y1, fila, v, l);
        if(consolaInicial){
            String v2[] = new String[getFilas()];
            int v3[] = new int[getFilas()];
            int v4[] = new int[getFilas()];
            int co = 0;   
            int f = 0, c = 0;
            double negativo = 0;
            c = buscarMaximoNegativo(Consola, fila, columna, columna1, negativo, v, c);
            buscarPivote(Consola, getFilas(), getColumnas(), c, v, v2, v3, v4, f, y1, columna1, l);            
        }
    }
    
    public boolean MostrarTablaConsola(JTextArea Consola, JTable TableSimplex, int columna, int columna1, int y1, int fila, double v[][], DecimalFormat l){
         
        Consola.append("=============================================\n\n");
        Consola.append("METODO SIMPLEX\n\n");      
       
        for (int i = 0; i < columna; i++) {
            if (i < columna1) {
                Consola.append("\t x" + (i + 1));
            } else if (i >= columna1 && i < columna - 1) {
                Consola.append("\t d" + (y1));
                y1++;

            } else {
                Consola.append("\t resultado");
            }
        }
        
        Consola.append("\n");
        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                v[i][j] = Double.parseDouble(TableSimplex.getValueAt(i, j).toString());
            }
        }

        for (int i = 0; i < fila; i++) {
            if(i!=0){
                Consola.append("d"+i);
            }
            for (int j = 0; j < columna; j++) {
                Consola.append("\t " + l.format(v[i][j]));
            }
            Consola.append("\n");
        }
        Consola.append("\n\n");
        
        return true;
    }
    
    public int buscarMaximoNegativo(JTextArea Consola, int fila, int columna, int columna1, double negativo, double v[][], int c){
        
        for (int i = 0; i < columna1; i++) {
            if (v[0][i] < negativo) {
                negativo = v[0][i];
                c = i;
            }
        }
        Consola.append("EL MAXIMO NEGATIVO ES\n" + getColumnas());
        Consola.append(" " + negativo + "\nla columna es \n");
        
        for (int i = 0; i < fila; i++) {
            Consola.append(" " + v[i][c] + "\n");
        }
        
        return c;
    }
    
    public void buscarPivote(JTextArea Consola, int fila, int columna, int c, double v[][], String v2[], int v3[], int v4[], int f, int y1, int columna1, DecimalFormat l){
            Consola.append("\n dividiendo con la columna\n");
            double menor = 0;
            double v1[] = new double[fila - 1];
            int h = 0;
            for (int i = 1; i < fila; i++) {
                v1[h] = v[i][columna - 1] / v[i][c];
                Consola.append(" " + v[i][columna - 1] + " / " + v[i][c] + " = " + v1[h] + " \n");
                h++;
            }
            menor = v1[0];
            for (int i = 0; i < fila - 1; i++) {
                if (v1[i] <= menor) {
                    menor = v1[i];
                    f = i + 1;
                }
            }
            Consola.append("el menor de la division es: " + menor + "\n");
            double pivo = v[f][c];
            Consola.append("el pivote es:" + pivo);
            
            convertirPivoteUno(Consola, fila, columna, v, f, c, pivo, v2, v3, v4, y1, columna1, l);
    }
    
    public void convertirPivoteUno(JTextArea Consola,int fila, int columna, double v[][], int f, int c, double pivo, String v2[], int v3[], int v4[], int y1, int columna1, DecimalFormat l ){
       Consola.append("\nproceso de convertir el pivote en 1\n dividiendo toda la fila con el pivote\n");
            for (int i = 0; i < columna; i++) {
                double va = v[f][i];
                v[f][i] = v[f][i] / pivo;
                Consola.append("" + va + " / " + pivo + " = " + v[f][i] + "\n");
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
        convertirColumnaPrivoteCero(Consola, fila, columna, v, f, c);
        resultado(Consola, y1, columna, columna1, fila, v2, v4, v, l);
    }
    
    public void convertirColumnaPrivoteCero(JTextArea Consola, int fila, int columna, double v[][], int f, int c){
        Consola.append("\n proceso \n ");
            for (int i = 0; i < fila; i++) {
                if (i != f) {
                    Consola.append("Convertiendo la columna del pivote en cero, en fila" + (i + 1) + "\n\n");

                    double guar = 0;
                    guar = -v[i][c];
                    for (int j = 0; j < columna; j++) {
                        double vaa = v[i][j];
                        v[i][j] = guar * v[f][j] + v[i][j];
                        Consola.append(" " + guar + "*" + v[f][j] + " + " + vaa + " = " + v[i][j] + "\n");
                    }
                }
            }
    }
    
    public void resultado(JTextArea Consola, int y1, int columna, int columna1, int fila, String v2[], int v4[], double v[][], DecimalFormat l){
        y1=1;
            for (int i = 0; i < columna; i++) {
                if (i < columna1) {
                    Consola.append("\t x" + (i + 1));
                } else if (i >= columna1 && i < columna - 1) {
                    Consola.append("\t d" + (y1));
                    y1++;

                } else {
                    Consola.append("\t resul");

                }
            }
            Consola.append("\n");
           
            for (int i = 0; i < fila; i++) {
           if(i!=0){
           Consola.append(v2[i]);
           }
                for (int j = 0; j < columna; j++) {
                    Consola.append("\t " + l.format(v[i][j]));
                }
                Consola.append("\n");
            }
            Consola.append("\n\n");
            
        Consola.append("RESULTADO\n");
        Consola.append("z = "+v[0][columna-1]+"\n");
        for (int i = 1; i<fila; i++) {
            char m1[]=v2[i].toCharArray();
            if(m1[0]=='x'){
            Consola.append(" "+v2[i]+" = "+v[v4[i]][columna-1]+"\n");
            }
        }
    }
}
