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
    int id;
    String usuario;
    String password;
    Boolean turno;
    String nombre;
    String apePaterno;
    String apeMaterno;
    Boolean estatusEmpleado;
 

 public Empleado(int id, String usuario, String password, Boolean turno, String nombre, String apePaterno, String apeMaterno, Boolean estatusEmpleado) {
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.turno = turno;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.estatusEmpleado = estatusEmpleado;
        
    }
    

    
    
    
}
