/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author lucas
 */
public class Vendedor extends Empleado{
    
    Connection conn = null;
    int idLibro;
    String tituloLibro;
    String isbnLibro;
    double precioLibro;
    int stockLibro;
    double descuentoLibro;
    
    public Vendedor(int id, String usuario, String contrasenia, char turno, String nombre, String apePaterno, String apeMaterno, char estatusEmpleado, int tipo) {
        super(id, usuario, contrasenia, turno, nombre, apePaterno, apeMaterno, estatusEmpleado, tipo);
    }
    
    public void agregarALista(String idLibro, int cantidad){
        conn = establecerConexion();
        int numero = Integer.parseInt(idLibro);
        
        if(conn != null) {
            try {
                String query = "SELECT \"id\", \"tituloLibro\", \"isbnLibro\", \"precioLibro\", \"stockLibro\", \"descuento\" FROM \"public\".\"libro\" WHERE \"id\" = '" + numero + "'";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    this.idLibro = rs.getInt("id");
                    this.tituloLibro = rs.getString("tituloLibro");
                    this.isbnLibro = rs.getString("isbnLibro");
                    this.precioLibro = rs.getDouble("precioLibro");
                    this.stockLibro = rs.getInt("stockLibro");
                    this.descuentoLibro = rs.getDouble("descuento");
                }
                
                System.out.println("El id encontrado es: " + this.idLibro);
                System.out.println("El nombre del id encontrado es: " + this.tituloLibro);
                System.out.println("El isbn del id encontrado es: " + this.isbnLibro);
                System.out.println("El precio del id encontrado es: " + this.precioLibro);
                System.out.println("El stock del id encontrado es: " + this.stockLibro);
                System.out.println("El descuento del id encontrado es: " + this.descuentoLibro);
                
                int stockLibro1 = this.stockLibro - cantidad;
                
                //String query1 = "UPDATE \"public\".\"libro\" SET \"stockLibro\" = + '" + stockLibro1 + "' + WHERE \"id\" = '" + this.idLibro + "'";
                String query1 = "UPDATE \"public\".\"libro\" SET \"stockLibro\" = ? WHERE \"id\" = ?";
                
                try (PreparedStatement pstmt = conn.prepareStatement(query1)) {
                    pstmt.setInt(1, stockLibro1); // 'stockLibro1' es el nuevo valor para stockLibro
                    pstmt.setInt(2, this.idLibro); // 'this.idLibro' es el ID del libro
                    // Ejecutar la actualización
                    int filasActualizadas = pstmt.executeUpdate();
                    System.out.println("Filas actualizadas: " + filasActualizadas);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                rs.close();
                stmt.close();

            } catch (Exception e) {
                System.out.println("No se encontro libro con el id dado.");
                //JOptionPane.showMessageDialog(null,"Datos incorrectos o usuario inexistente.");
            }
        }
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
