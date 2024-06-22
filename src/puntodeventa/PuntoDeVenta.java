/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package puntodeventa;

import Controlador.C_ingreso;
import Modelo.M_Ingreso;
import VISTAS.Ingreso;

/**
 *
 * @author diego
 */
public class PuntoDeVenta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
         Ingreso ingreso= new Ingreso();
        M_Ingreso m_ingreso=new M_Ingreso();
        C_ingreso c_ingreso = new C_ingreso(ingreso, m_ingreso);
        c_ingreso.Iniciar();
        ingreso.setVisible(true);
        
        // TODO code application logic here
    }
    
}
