/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTAS;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
/**
 *
 * @author diego
 */
public class Ingreso extends javax.swing.JFrame {

    /**
     * Creates new form ingresoVendedor
     */
    public Ingreso() {
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
                try {
            Font OpenSauceOneBold = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/OpenSauceOne-Bold.ttf")).deriveFont(30f);
            lbl_inciosesion.setFont(OpenSauceOneBold);
            Font OpenSauceOne = Font.createFont(Font.TRUETYPE_FONT, new File("src/fonts/OpenSauceOne-Regular.ttf")).deriveFont(18f);
            lbl_usuario.setFont(OpenSauceOne);lbl_contraseña.setFont(OpenSauceOne);
            } catch (FontFormatException | IOException e) {
             System.err.println("Error: " + e.getMessage());
             e.printStackTrace();
             }
                
                
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

        jLabel2 = new javax.swing.JLabel();
        Panel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        lbl_usuario = new javax.swing.JLabel();
        lbl_contraseña = new javax.swing.JLabel();
        txt_usuario = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btn_salir = new javax.swing.JButton();
        txt_contraseña = new javax.swing.JPasswordField();
        lbl_inciosesion = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();
        btn_iniciarsesion = new javax.swing.JButton();

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.jpeg"))); // NOI18N

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Panel.setBackground(new java.awt.Color(255, 255, 255));
        Panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        Panel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, -1, -1));

        lbl_usuario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_usuario.setText("Nombre de usuario:");
        Panel.add(lbl_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, -1, -1));

        lbl_contraseña.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lbl_contraseña.setText("Contraseña:");
        Panel.add(lbl_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 190, -1, -1));
        Panel.add(txt_usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, 190, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(153, 153, 255));
        jLabel1.setText("¿Olvidaste tu contraseña?");
        Panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 170, -1));

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
        Panel.add(btn_salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, 40, 30));
        Panel.add(txt_contraseña, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, 190, 30));

        lbl_inciosesion.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        lbl_inciosesion.setText("INICIO DE SESION");
        Panel.add(lbl_inciosesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, -1, -1));

        lbl_logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/logo.jpeg"))); // NOI18N
        lbl_logo.setToolTipText("");
        Panel.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 100, 80));

        btn_iniciarsesion.setBackground(new java.awt.Color(209, 59, 83));
        btn_iniciarsesion.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_iniciarsesion.setForeground(new java.awt.Color(255, 255, 255));
        btn_iniciarsesion.setText("INICIAR SESIÓN");
        btn_iniciarsesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_iniciarsesionActionPerformed(evt);
            }
        });
        Panel.add(btn_iniciarsesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 200, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Panel, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_salirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_salirActionPerformed
   System.exit(0);
   
   
    }//GEN-LAST:event_btn_salirActionPerformed

    private void btn_iniciarsesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_iniciarsesionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_iniciarsesionActionPerformed

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
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingreso.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingreso().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel;
    public javax.swing.JButton btn_iniciarsesion;
    public javax.swing.JButton btn_salir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lbl_contraseña;
    private javax.swing.JLabel lbl_inciosesion;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JLabel lbl_usuario;
    public javax.swing.JPasswordField txt_contraseña;
    public javax.swing.JTextField txt_usuario;
    // End of variables declaration//GEN-END:variables
}
