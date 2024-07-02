/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTAS;

import clases.Empleado;
import clases.Vendedor;
import clases.Almacenista;
import clases.Admin;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author diego
 */
public class ListaDeVenta extends javax.swing.JFrame {

    Empleado empleado;
    int tipoEmp;
    
    public ListaDeVenta(Empleado empleado) {
        initComponents();
        this.empleado = empleado;         
        
        if (empleado instanceof Vendedor) {
            tipoEmp = 1;
        } else if (empleado instanceof Almacenista) {
            tipoEmp = 2;
        } else if (empleado instanceof Admin) {
            tipoEmp = 3;
        }
        
        PointerInfo pointerInfo = MouseInfo.getPointerInfo();
        GraphicsDevice gd = pointerInfo.getDevice();
        Rectangle bounds = gd.getDefaultConfiguration().getBounds();

        // Obtener las dimensiones del formulario
        int frameWidth = 400;  // Ancho del formulario
        int frameHeight = 430; // Alto del formulario

        // Calcular las coordenadas para centrar el formulario
        int x = bounds.x + (bounds.width - frameWidth) / 2;
        int y = bounds.y + (bounds.height - frameHeight) / 2;

        //this.setSize(frameWidth, frameHeight);
        this.setLocation(x, y);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        
        Funciones.CargarLogo(lbl_logo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButtonRegresar = new javax.swing.JButton();
        jButtonPagoTarjeta = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        lbl_lista = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        lbl_logo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 136, 130));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Pago con:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 113, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel2.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 113, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Su cambio:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 113, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("XXXXXX");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 113, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, 180, 150));

        jPanel3.setBackground(new java.awt.Color(211, 211, 211));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Vendedor:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 113, -1));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("xxxxxxxxxx");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 113, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Tienda:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 80, -1));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("xxxxxxxxxx");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Total a pagar:");
        jPanel3.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 127, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(209, 59, 83));
        jLabel11.setText("$100");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 113, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 300, 150));

        jTextArea1.setBackground(new java.awt.Color(235, 235, 235));
        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setBorder(null);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 300, 190));

        jButtonRegresar.setBackground(new java.awt.Color(209, 59, 83));
        jButtonRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonRegresar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 180, 40));

        jButtonPagoTarjeta.setBackground(new java.awt.Color(209, 59, 83));
        jButtonPagoTarjeta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonPagoTarjeta.setForeground(new java.awt.Color(255, 255, 255));
        jButtonPagoTarjeta.setText("Pago con tarjeta");
        jButtonPagoTarjeta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPagoTarjetaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonPagoTarjeta, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 320, 180, 40));

        jButton3.setBackground(new java.awt.Color(209, 59, 83));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Finalizar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 180, 40));

        lbl_lista.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lbl_lista.setText("LISTA DE VENTA");
        jPanel1.add(lbl_lista, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 10, -1, -1));

        jButton4.setBackground(new java.awt.Color(209, 59, 83));
        jButton4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Pago con efectivo");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, 180, 40));

        lbl_logo.setText("logo");
        lbl_logo.setToolTipText("");
        jPanel1.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 80, 70));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        if(tipoEmp==1 || tipoEmp==2){
            PuntoDeVenta puntoDeVenta = new PuntoDeVenta(empleado);
            puntoDeVenta.setVisible(true);
            this.setVisible(false);
        }
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonPagoTarjetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPagoTarjetaActionPerformed
        this.setVisible(false);
        new PagoTarjeta().setVisible(true);
    }//GEN-LAST:event_jButtonPagoTarjetaActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ListaDeVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaDeVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaDeVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaDeVenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaDeVenta(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonPagoTarjeta;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lbl_lista;
    private javax.swing.JLabel lbl_logo;
    // End of variables declaration//GEN-END:variables
}
