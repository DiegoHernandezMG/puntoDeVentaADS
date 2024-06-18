/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.M_Ingreso;
import VISTAS.Ingreso;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author lucas
 */
public class C_ingreso implements ActionListener {
      private Ingreso vista;
    private M_Ingreso modelo;
    
     public C_ingreso(Ingreso vista,M_Ingreso modelo){
         this.vista=vista;
         this.modelo=modelo;
         this.vista.btn_iniciarsesion.addActionListener(this);
         }
     
     public void actionPerformed(ActionEvent e){
         modelo.setUsuario(vista.txt_usuario.getText());
         modelo.setContraseña(vista.txt_contraseña.getText());
         modelo.IniciarSesion();
         
     }
     public void Iniciar(){
         vista.setLocationRelativeTo(null);
     }
     
    
}
