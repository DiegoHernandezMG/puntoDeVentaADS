/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VISTAS;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author lucas
 */
public class Funciones {
    public static void CargarLogo(JLabel lbl_logo) {
        
        ImageIcon icono = new ImageIcon(Funciones.class.getResource("/img/logo.jpeg"));
        if (icono != null) {
            int ancho = lbl_logo.getWidth();
            int alto = lbl_logo.getHeight();
            ImageIcon iconoEscalado = new ImageIcon(icono.getImage().getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH));
            lbl_logo.setIcon(iconoEscalado);
        } else {
            System.err.println("Error: No se pudo cargar la imagen /img/logo.jpeg");
        }
    }
    public static void CargarNombre(JLabel lbl_LibroNetStore){
        
             
            lbl_LibroNetStore.setText("<html><span style='color: black;'>Libro</span><span style='color: #D13B53;'>Net</span><span style='color: black;'>Store</span></html>");


         
        
    
    } 
}
