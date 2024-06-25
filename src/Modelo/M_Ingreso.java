/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;


import VISTAS.PuntoDeVenta;
import VISTAS.Ingreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class M_Ingreso extends conexion {
        private String usuario;
    private  String contraseña;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
     public void IniciarSesion() {
        
        Connection conn=getConnection();
             try{
           
            String query = "SELECT * FROM puntodeventa.empleado WHERE \"usuarioEmp\"='"+this.usuario+"'AND \"passEmp\"='"+this.contraseña+"'";

            PreparedStatement pst= conn.prepareStatement(query);
            ResultSet rs = pst.executeQuery();  
            if (!rs.next()) {
                JOptionPane.showMessageDialog(null,"invalid username or password");
          }else{
                
                
                new PuntoDeVenta().show();
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        } 

    }
    
    
}
