/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author diego
 */
public class Empleado {
    String usuario;
    String password;
    Boolean turno;
    String nombre;
    String apePaterno;
    String apeMaterno;
    Boolean estatusEmpleado;
    
    Conexion conexion;
    Connection conn = null;

    public Empleado(String usuario, String password) {
        this.usuario = usuario;
        this.password = password;
    }
    
    public Connection establecerConexion(){
        this.conexion = new Conexion();
        conn = this.conexion.establecerConexion();
        
        return conn;
    }
    
    
    
}
