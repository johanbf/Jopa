
package com.utp.jopa.Conexion;

import java.sql.*; //importando todas las librerias
import javax.swing.JOptionPane;
public class Conexion {
    
    //constructor
    private Conexion(){
        
    }
    
    //variables que guardarán la conexión a la BD
    private static Connection conexion;
    
    //variable para crear una sola instancia
    private static Conexion instancia;
    
    //variable para conectar a la BD
    private static final String URL = "jdbc:mysql://localhost/bd_jopa";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    //método para conectar a BD
    public Connection conectar(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            JOptionPane.showMessageDialog(null, "Conexión exitosa!!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error : " + e);
        }
         return conexion;
    }
    
    //método para cerrar conexión a BD.
    
    public void cerrarConexion() throws SQLException{
        try{
            conexion.close();
            JOptionPane.showMessageDialog(null, "Se desconectó de la BD exitosamente!!");
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error :  " + e);
            conexion.close();
        }finally{ //en caso hubo problemas para cerrar conexión ejem: apagones
            conexion.close();
        }
    }
    
    //patron singleton
    public static Conexion getInstance(){
        if(instancia == null){
            instancia = new Conexion();
        }
        return instancia;
        
    }
}
