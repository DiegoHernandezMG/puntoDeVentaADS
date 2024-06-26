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
public class Empleado extends Conexion {
    int id;
    String usuario;
    String contrasenia;
    char turno;
    String nombre;
    String apePaterno;
    String apeMaterno;
    char estatusEmpleado;
    int tipo;
 

 public Empleado(int id, String usuario, String contrasenia, char turno, String nombre, String apePaterno, String apeMaterno, char estatusEmpleado,int tipo) {
        this.id = id;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.turno = turno;
        this.nombre = nombre;
        this.apePaterno = apePaterno;
        this.apeMaterno = apeMaterno;
        this.estatusEmpleado = estatusEmpleado;
        this.tipo=tipo;
        
    }
    

    
    
    
}
