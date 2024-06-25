/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import VISTAS.Inventario;
import VISTAS.PuntoDeVenta;
import VISTAS.PuntoDeVentaAdmin;

/**
 *
 * @author diego
 */
public class Login extends Conexion {
    String usuario;
    String contrasenia;
    
    String statusEmpleado;
    
    Connection conn = null;

    public Login(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Login() {
    }
    
    public void iniciarSesion(){
        if(usuario.isEmpty() || contrasenia.isEmpty()){
            System.out.println("No hay datos completos.");
            
            
        }else{
         
            conn = establecerConexion();
            
            if(conn!=null){
                try {
                    //String query = "SELECT \"estatusEmpleado\" FROM \"public\".empleado WHERE \"usuarioEmpleado\" = '" + usuario "';
                    String query = "SELECT \"estatusEmpleado\" FROM \"public\".\"empleado\" WHERE \"usuarioEmpleado\" = '" + usuario + "' AND \"contraseniaEmpleado\" = '" + contrasenia + "'";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    while (rs.next()) {
                        this.statusEmpleado = rs.getString("estatusEmpleado");
                    }
                    
                    rs.close();
                    stmt.close();
                   
                    
                    if(statusEmpleado.equals("A")){
                        String query2 = "SELECT \"id\" FROM \"public\".\"empleado\" WHERE \"usuarioEmpleado\" = '" + usuario + "'";
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery(query2);
                        int id = -1;
                        
                        if (rs.next()) {
                            id = rs.getInt("id");
                        }
                        
                        rs.close();
                        stmt.close();
                        
                        if (id != -1) {
                            String query3 = "SELECT \"tipoempleado_id\" FROM \"public\".\"tipoEmpleado_empleados\" WHERE \"empleado_id\" = " + id;
                            stmt = conn.createStatement();
                            rs = stmt.executeQuery(query3);
                            int tipoEmpleadoId=-1;
                            if (rs.next()) {
                                tipoEmpleadoId= rs.getInt("tipoempleado_id");
                                // Puedes hacer algo con el tipoEmpleadoId si es necesario
                                System.out.println("Tipo de Empleado ID: " + tipoEmpleadoId);
                            }
                            
                            rs.close();
                            stmt.close();
                            if (tipoEmpleadoId==1) {
                                new PuntoDeVentaAdmin().setVisible(true);
                                }
                            else if (tipoEmpleadoId==2) {
                                 new PuntoDeVenta().setVisible(true);
                                
                            }
                            else if (tipoEmpleadoId==3) {
                                 new Inventario().setVisible(true);
                                
                            }
                            
                            System.out.println("Se inició sesión correctamente.");
                            
                        } else {
                            System.out.println("No se encontró el ID del empleado.");
                            
                        }
                    }else{
                        System.out.println("El empleado esta inactivo.");
                        
                    }
                } catch (Exception e) {
                    System.out.println("Datos incorrectos o usuario inexistente.");
                    JOptionPane.showMessageDialog(null, e);
                    
                }
            }
            
        }
    }
}
