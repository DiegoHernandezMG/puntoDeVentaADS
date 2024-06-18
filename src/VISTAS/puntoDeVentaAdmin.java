/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTAS;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author diego
 */
public class puntoDeVentaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form puntoDeVentaAdmin
     */
    public puntoDeVentaAdmin() {
        initComponents();
        
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
        jLabel12 = new javax.swing.JLabel();
        jButtonListaDeVenta = new javax.swing.JButton();
        jButtonBuscador = new javax.swing.JButton();
        jButtonInventario = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jButtonAgregarEmpleado = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel12.setText("NOMBRE DE LA LIBRERIA");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jButtonListaDeVenta.setBackground(new java.awt.Color(204, 204, 255));
        jButtonListaDeVenta.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonListaDeVenta.setForeground(new java.awt.Color(255, 255, 255));
        jButtonListaDeVenta.setText("LISTA DE VENTA");
        jButtonListaDeVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaDeVentaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonListaDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 220, 40));

        jButtonBuscador.setBackground(new java.awt.Color(204, 204, 255));
        jButtonBuscador.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonBuscador.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscador.setText("BUSCADOR");
        jButtonBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscadorActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 220, 40));

        jButtonInventario.setBackground(new java.awt.Color(204, 204, 255));
        jButtonInventario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonInventario.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInventario.setText("INVENTARIO");
        jButtonInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInventarioActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 220, 40));

        jButtonSalir.setBackground(new java.awt.Color(153, 153, 153));
        jButtonSalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(255, 255, 255));
        jButtonSalir.setText("SALIR");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 350, 120, 40));

        jButtonAgregarEmpleado.setBackground(new java.awt.Color(204, 204, 255));
        jButtonAgregarEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButtonAgregarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregarEmpleado.setText("AGREGAR EMPLEADO");
        jButtonAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 220, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 402, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonListaDeVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonListaDeVentaActionPerformed
        this.setVisible(false);
        new listaDeVenta().setVisible(true);
    }//GEN-LAST:event_jButtonListaDeVentaActionPerformed

    private void jButtonBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscadorActionPerformed
        this.setVisible(false);
        new buscador().setVisible(true);
    }//GEN-LAST:event_jButtonBuscadorActionPerformed

    private void jButtonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInventarioActionPerformed
        this.setVisible(false);
        new Inventario().setVisible(true);
    }//GEN-LAST:event_jButtonInventarioActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        this.dispose();  // Cerrar el formulario actual
        System.exit(0);  // Finalizar la aplicación
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarEmpleadoActionPerformed
        this.setVisible(false);
        new AgregarNuevoEmpleado().setVisible(true);
    }//GEN-LAST:event_jButtonAgregarEmpleadoActionPerformed

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
            java.util.logging.Logger.getLogger(puntoDeVentaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(puntoDeVentaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(puntoDeVentaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(puntoDeVentaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new puntoDeVentaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregarEmpleado;
    private javax.swing.JButton jButtonBuscador;
    private javax.swing.JButton jButtonInventario;
    private javax.swing.JButton jButtonListaDeVenta;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
