/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testClases;

import Modelo.conexionDB;

/**
 *
 * @author diego
 */
public class mainTest {
    public static void main(String[] args) {
        conexionDB objetoConexion = new conexionDB();
        objetoConexion.mostrarDatos();
        
    }
}
