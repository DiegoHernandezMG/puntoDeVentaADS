/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author lucas
 */
public class conexion {
    
      public Connection getConnection(){
        
         Connection conn=null;
         try{
            Class.forName("org.postgresql.Driver");
             conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/libStoreDB","lucas","lucas");
       
         }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
        return conn;
        
}}

