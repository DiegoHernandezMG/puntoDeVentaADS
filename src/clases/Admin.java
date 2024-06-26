/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import VISTAS.AgregarNuevoEmpleado;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author lucas
 */
public class Admin extends Empleado {
    
    public Admin(int id, String usuario, String contrasenia, char turno, String nombre, String apePaterno, String apeMaterno, char estatusEmpleado,int tipo) {
        super(id, usuario, contrasenia, turno, nombre, apePaterno, apeMaterno, estatusEmpleado,tipo);
    }
    
 
    public void crearNuevoEmpleado() {
        
        String query = "INSERT INTO empleado (\"nombresEmpleado\", \"apellidoPaternoEmpleado\", \"apellidoMaternoEmpleado\", \"usuarioEmpleado\", \"contraseniaEmpleado\", \"turnoEmpleado\", \"estatusEmpleado\") VALUES (?, ?, ?, ?, ?, ?, ?)";
        String query2 = "SELECT nextval('empleado_id_seq') AS id";
         String query3 = "INSERT INTO \"tipoEmpleado_empleados\" (\"tipoempleado_id\", \"empleado_id\") VALUES (?, ?)";

        
        try (Connection conn = establecerConexion();) {
             PreparedStatement pst = conn.prepareStatement(query);
             PreparedStatement pst2 = conn.prepareStatement(query2);
             ResultSet rs = pst2.executeQuery();
             int identity = -1;
             if (rs.next()) {
                identity = rs.getInt("id")+1;
            }
             
            String usuario= nombre.substring(0, 1).toUpperCase() + apePaterno.substring(0, 1).toUpperCase() + "01"+ String.format("%05d", identity);
             
         
             
          
            pst.setString(1, nombre);
            pst.setString(2, apePaterno);
            pst.setString(3, apeMaterno);
            pst.setString(4, usuario);
            pst.setString(5, contrasenia);
            pst.setString(6, String.valueOf(turno));  // Convertimos char a String
            pst.setString(7, String.valueOf(estatusEmpleado));  // Convertimos char a String
            
            
            int rowsAffected = pst.executeUpdate();
            PreparedStatement pst3 = conn.prepareStatement(query3);
            pst3.setInt(1, tipo);
            pst3.setInt(2, identity);
            int rowsAffected2 = pst3.executeUpdate();
            
            if (rowsAffected > 0 && rowsAffected2>0) {
                JOptionPane.showMessageDialog(null, "Empleado creado exitosamente");
            }
            
            
            rs.close();
            pst.close();
            pst2.close();
            pst3.close();
            conn.close();
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e); // Registrar la excepción para depuración
        }
        
        
    }
}
