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
public class PuntoDeVentaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form puntoDeVentaAdmin
     */
    public PuntoDeVentaAdmin() {
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
        Funciones.CargarLogo(lbl_logo);
        Funciones.CargarNombre(lbl_LibroNetStore);
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
        lbl_LibroNetStore = new javax.swing.JLabel();
        jButtonListaDeVenta = new javax.swing.JButton();
        jButtonBuscador = new javax.swing.JButton();
        jButtonInventario = new javax.swing.JButton();
        jButtonAgregarEmpleado = new javax.swing.JButton();
        lbl_logo = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_LibroNetStore.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lbl_LibroNetStore.setText("NOMBRE ");
        jPanel1.add(lbl_LibroNetStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));

        jButtonListaDeVenta.setBackground(new java.awt.Color(209, 59, 83));
        jButtonListaDeVenta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonListaDeVenta.setForeground(new java.awt.Color(255, 255, 255));
        jButtonListaDeVenta.setText("Lista de venta");
        jButtonListaDeVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonListaDeVentaActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonListaDeVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 220, 40));

        jButtonBuscador.setBackground(new java.awt.Color(209, 59, 83));
        jButtonBuscador.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonBuscador.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscador.setText("Buscador");
        jButtonBuscador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscadorActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonBuscador, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 220, 40));

        jButtonInventario.setBackground(new java.awt.Color(209, 59, 83));
        jButtonInventario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonInventario.setForeground(new java.awt.Color(255, 255, 255));
        jButtonInventario.setText("Inventario");
        jButtonInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInventarioActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonInventario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 220, 220, 40));

        jButtonAgregarEmpleado.setBackground(new java.awt.Color(209, 59, 83));
        jButtonAgregarEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAgregarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregarEmpleado.setText("Agregar empleado");
        jButtonAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 220, 40));

        lbl_logo.setText("logo");
        lbl_logo.setToolTipText("");
        jPanel1.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 80, 70));

        btn_salir.setBackground(new java.awt.Color(209, 59, 83));
        btn_salir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_salir.setForeground(new java.awt.Color(255, 255, 255));
        btn_salir.setText("X");
        btn_salir.setMargin(new java.awt.Insets(2, 2, 3, 2));
        btn_salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_salirActionPerformed(evt);
            }
        });
        jPanel1.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, 30, 30));

        jLabel1.setText("Administrador");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, -1));

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
        new ListaDeVenta().setVisible(true);
    }//GEN-LAST:event_jButtonListaDeVentaActionPerformed

    private void jButtonBuscadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscadorActionPerformed
        this.setVisible(false);
        new Buscador().setVisible(true);
    }//GEN-LAST:event_jButtonBuscadorActionPerformed

    private void jButtonInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInventarioActionPerformed
        this.setVisible(false);
        new Inventario().setVisible(true);
    }//GEN-LAST:event_jButtonInventarioActionPerformed

    private void jButtonAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarEmpleadoActionPerformed
        this.setVisible(false);
        new AgregarNuevoEmpleado().setVisible(true);
    }//GEN-LAST:event_jButtonAgregarEmpleadoActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

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
            java.util.logging.Logger.getLogger(PuntoDeVentaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PuntoDeVentaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PuntoDeVentaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PuntoDeVentaAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PuntoDeVentaAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_salir;
    private javax.swing.JButton jButtonAgregarEmpleado;
    private javax.swing.JButton jButtonBuscador;
    private javax.swing.JButton jButtonInventario;
    private javax.swing.JButton jButtonListaDeVenta;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_LibroNetStore;
    private javax.swing.JLabel lbl_logo;
    // End of variables declaration//GEN-END:variables
}
