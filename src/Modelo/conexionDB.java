/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author diego
 */
public class conexionDB {
    public Connection establecerConexion(){
        String user = "postgres";
        String password = "ItDontMatter1$";
        String db = "libStoreDB";
        String ip = "localhost";
        String puerto = "5432";

        String cadena = "jdbc:postgresql://" + ip + ":" + puerto + "/" + db;
        Connection conn =  null;
        
        try{
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(cadena, user, password);
            //JOptionPane.showMessageDialog(null, "Se conecto correctamente la base de datos.");
            System.out.println("Se conecto correctamente la base de datos.");
        }catch(Exception e){
            //JOptionPane.showMessageDialog(null, "No se conecto correctamente la base de datos." + e.toString());
            System.out.println("No se conecto correctamente la base de datos." + e.toString());
        }
        System.out.println(conn);
        return conn;
    }
    
    public void mostrarDatos(){
        Connection conn = establecerConexion();
        
        if(conn!=null){
            try {
                String query = "SELECT \"estatusEmpleado\" FROM \"public\".empleado";
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(query);
                
                while (rs.next()) {
                    System.out.println(rs.getString("estatusEmpleado"));
                }
                
                rs.close();
                stmt.close();
                conn.close();
            } catch (Exception e) {
                System.out.println("Error al consultar los datos: " + e.toString());
            }
        }
    }
}
