/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import VISTAS.Ingreso;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import VISTAS.VistaInventario;
import VISTAS.PuntoDeVenta;
import VISTAS.PuntoDeVentaAdmin;
import java.sql.PreparedStatement;
import java.util.HashSet;

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
        } else {
            conn = establecerConexion();

            if(conn != null) {
                try {
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
                            int tipoEmpleadoId = -1;
                            if (rs.next()) {
                                tipoEmpleadoId = rs.getInt("tipoempleado_id");
                                System.out.println("Tipo de Empleado ID: " + tipoEmpleadoId);
                            }

                            rs.close();
                            stmt.close();

                            String query4 = "SELECT \"id\", \"nombresEmpleado\", \"apellidoPaternoEmpleado\", \"apellidoMaternoEmpleado\", \"usuarioEmpleado\", \"contraseniaEmpleado\", \"turnoEmpleado\", \"estatusEmpleado\" FROM \"public\".\"empleado\" WHERE \"id\" = ?";
                            PreparedStatement pst = conn.prepareStatement(query4);
                            pst.setInt(1, id);
                            rs = pst.executeQuery();

                            Vendedor vendedor=null;
                            Almacenista almacenista=null;
                            Admin admin = null;
                            
                            if (rs.next()) {
                                switch (tipoEmpleadoId) {
                                    case 1:
                                        // Admin
                                        admin = new Admin(
                                                rs.getInt("id"),
                                                rs.getString("usuarioEmpleado"),
                                                rs.getString("contraseniaEmpleado"),
                                                rs.getString("turnoEmpleado").charAt(0),
                                                rs.getString("nombresEmpleado"),
                                                rs.getString("apellidoPaternoEmpleado"),
                                                rs.getString("apellidoMaternoEmpleado"),
                                                rs.getString("estatusEmpleado").charAt(0),
                                                tipoEmpleadoId
                                                
                                        );  PuntoDeVentaAdmin puntoDeVentaAdmin = new PuntoDeVentaAdmin(admin);
                                        puntoDeVentaAdmin.setVisible(true);
                                        JOptionPane.showMessageDialog(null, "admin no es null: " + admin.getNombre());
                                        break;
                                    case 2:
                                        vendedor = new Vendedor(
                                                
                                                rs.getInt("id"),
                                                rs.getString("usuarioEmpleado"),
                                                rs.getString("contraseniaEmpleado"),
                                                rs.getString("turnoEmpleado").charAt(0),
                                                rs.getString("nombresEmpleado"),
                                                rs.getString("apellidoPaternoEmpleado"),
                                                rs.getString("apellidoMaternoEmpleado"),
                                                rs.getString("estatusEmpleado").charAt(0),
                                                tipoEmpleadoId
                                        );  PuntoDeVenta puntoDeVenta = new PuntoDeVenta(vendedor);
                                        puntoDeVenta.setVisible(true);
                                        break;
                                    case 3:
                                        almacenista = new Almacenista(
                                                
                                                rs.getInt("id"),
                                                rs.getString("usuarioEmpleado"),
                                                rs.getString("contraseniaEmpleado"),
                                                rs.getString("turnoEmpleado").charAt(0),
                                                rs.getString("nombresEmpleado"),
                                                rs.getString("apellidoPaternoEmpleado"),
                                                rs.getString("apellidoMaternoEmpleado"),
                                                rs.getString("estatusEmpleado").charAt(0),
                                                tipoEmpleadoId
                                        );  
                                        
                                        VistaInventario vistaInventario = new VistaInventario(almacenista);
                                        vistaInventario.setVisible(true);                                       
                                        break;
                                    default:
                                        break;
                                }
                               
                            }
                            rs.close();
                            pst.close();

                          
                        }
                    } else {
                        System.out.println("El empleado está inactivo.");
                    }
                } catch (Exception e) {
                    System.out.println("Datos incorrectos o usuario inexistente.");
                    JOptionPane.showMessageDialog(null,"Datos incorrectos o usuario inexistente.");
                }
            }
        }
    }
}
