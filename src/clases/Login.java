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
public class Login {
    String usuario;
    String contrasenia;
    
    String statusEmpleado;
    Empleado empleadoActivo;
    Connection conn = null;

    public Login(String usuario, String contrasenia) {
        this.usuario = usuario;
        this.contrasenia = contrasenia;
    }

    public Login() {
    }
    
    public Boolean iniciarSesion(){
        if(usuario.isEmpty() || contrasenia.isEmpty()){
            System.out.println("No hay datos completos.");
            return false;
            
        }else{
            this.empleadoActivo = new Empleado(usuario, contrasenia);
            conn = empleadoActivo.establecerConexion();
            
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
                    conn.close();
                    
                    if(statusEmpleado.equals("A")){
                        System.out.println("Se inicio sesion correctamente.");
                        return true;
                    }else{
                        System.out.println("El empleado esta inactivo.");
                        return false;
                    }
                } catch (Exception e) {
                    System.out.println("Datos incorrectos o usuario inexistente.");
                    return false;
                }
            }
            return false;
        }
    }
}
