/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTAS;
import javax.swing.*;
import java.awt.*;
import clases.Admin;
import clases.Empleado;
/**
 *
 * @author diego
 */
public class PuntoDeVentaAdmin extends javax.swing.JFrame {

    /**
     * Creates new form puntoDeVentaAdmin
     */
    Admin admin;
    
    public PuntoDeVentaAdmin(Admin admin) {
        this.admin = admin;
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
        /*if(admin==null){
            JOptionPane.showMessageDialog(null, "admin es null");            
        }*/
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
        jButtonAgregarEmpleado = new javax.swing.JButton();
        lbl_logo = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonAgregarEmpleado1 = new javax.swing.JButton();
        jButtonAgregarEmpleado2 = new javax.swing.JButton();
        jButtonAgregarEmpleado3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbl_LibroNetStore.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lbl_LibroNetStore.setText("NOMBRE ");
        jPanel1.add(lbl_LibroNetStore, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, -1));

        jButtonAgregarEmpleado.setBackground(new java.awt.Color(209, 59, 83));
        jButtonAgregarEmpleado.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAgregarEmpleado.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregarEmpleado.setText("Agregar empleado");
        jButtonAgregarEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarEmpleadoActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregarEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 120, 220, 40));

        lbl_logo.setText("logo");
        lbl_logo.setToolTipText("");
        jPanel1.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 80, 70));

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
        jPanel1.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 30, 30));

        jLabel1.setText("Administrador");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, -1, -1));

        jButtonAgregarEmpleado1.setBackground(new java.awt.Color(209, 59, 83));
        jButtonAgregarEmpleado1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAgregarEmpleado1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregarEmpleado1.setText("Reporte de ventas");
        jButtonAgregarEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarEmpleado1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregarEmpleado1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 220, 40));

        jButtonAgregarEmpleado2.setBackground(new java.awt.Color(209, 59, 83));
        jButtonAgregarEmpleado2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAgregarEmpleado2.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregarEmpleado2.setText("Editar empleado");
        jButtonAgregarEmpleado2.setToolTipText("");
        jButtonAgregarEmpleado2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarEmpleado2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregarEmpleado2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 180, 220, 40));

        jButtonAgregarEmpleado3.setBackground(new java.awt.Color(209, 59, 83));
        jButtonAgregarEmpleado3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonAgregarEmpleado3.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregarEmpleado3.setText("Añadir descuento");
        jButtonAgregarEmpleado3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarEmpleado3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonAgregarEmpleado3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 300, 220, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 423, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 404, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonAgregarEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarEmpleadoActionPerformed
        this.setVisible(false);
        new AgregarNuevoEmpleado(admin).setVisible(true);
        
        AgregarNuevoEmpleado agregarEmpleado = new AgregarNuevoEmpleado(admin);
        agregarEmpleado.btn_EditarEmpleado.setVisible(false);
    }//GEN-LAST:event_jButtonAgregarEmpleadoActionPerformed

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btn_salirActionPerformed

    private void jButtonAgregarEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarEmpleado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAgregarEmpleado1ActionPerformed

    private void jButtonAgregarEmpleado2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarEmpleado2ActionPerformed
    new VistaEmpleados(admin).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAgregarEmpleado2ActionPerformed

    private void jButtonAgregarEmpleado3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarEmpleado3ActionPerformed
    new Descuento(admin).setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAgregarEmpleado3ActionPerformed

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
               new PuntoDeVentaAdmin(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_salir;
    private javax.swing.JButton jButtonAgregarEmpleado;
    private javax.swing.JButton jButtonAgregarEmpleado1;
    private javax.swing.JButton jButtonAgregarEmpleado2;
    private javax.swing.JButton jButtonAgregarEmpleado3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_LibroNetStore;
    private javax.swing.JLabel lbl_logo;
    // End of variables declaration//GEN-END:variables
}
