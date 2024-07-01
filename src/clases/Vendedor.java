/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class Vendedor extends Empleado{
    
    Connection conn = null;
    int idEmpleado;
    
    public Vendedor(int id, String usuario, String contrasenia, char turno, String nombre, String apePaterno, String apeMaterno, char estatusEmpleado, int tipo) {
        super(id, usuario, contrasenia, turno, nombre, apePaterno, apeMaterno, estatusEmpleado, tipo);
    }
    
    public void agregarALista(String idLibro){
        conn = establecerConexion();
        
        if(conn != null) {
            try {
                String query = "SELECT \"id\" FROM \"public\".\"empleado\" WHERE \"id\" = '" + idLibro + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    this.idEmpleado = rs.getInt("id");
                }
                
                System.out.println("El id encontrado es: " + this.idEmpleado);

                rs.close();
                stmt.close();

            } catch (Exception e) {
                System.out.println("Datos incorrectos o usuario inexistente.");
                JOptionPane.showMessageDialog(null,"Datos incorrectos o usuario inexistente.");
            }
        }
    }
    
    public void cobrar(){
        
    }
    
    public void hacerDevolucion(){
        
    }
    
    public void imprimirTicket(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public char getTurno() {
        return turno;
    }

    public void setTurno(char turno) {
        this.turno = turno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApePaterno() {
        return apePaterno;
    }

    public void setApePaterno(String apePaterno) {
        this.apePaterno = apePaterno;
    }

    public String getApeMaterno() {
        return apeMaterno;
    }

    public void setApeMaterno(String apeMaterno) {
        this.apeMaterno = apeMaterno;
    }

    public char getEstatusEmpleado() {
        return estatusEmpleado;
    }

    public void setEstatusEmpleado(char estatusEmpleado) {
        this.estatusEmpleado = estatusEmpleado;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    
    
}
