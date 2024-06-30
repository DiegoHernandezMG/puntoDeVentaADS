/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTAS;
import clases.Admin;
import clases.Almacenista;
import clases.Empleado;
import javax.swing.*;
import java.awt.*;
import clases.Libro;import java.util.List;

/**
 *
 * @author lucas
 */
public class AgregarNuevoLibro extends javax.swing.JFrame {

     private Almacenista almacenista;
     private Admin admin;
     private Libro libro;
     
    public AgregarNuevoLibro() {
        initComponents();
   llenarListaEditorial();
                llenarListaAutores();
                llenarListaCategoria();
                
        lst_autores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

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
        public void setAdmin(Admin admin) {
        this.admin = admin;
    }
       public void setAlmacenista(Almacenista almacenista) {
        this.almacenista = almacenista;
    }
         public void setLibro(Libro libro) {
        this.libro = libro;
    }
  private void llenarListaAutores() {
        // Crear una instancia de la clase Libro para acceder al método autores()
        Libro libro = new Libro();

        // Obtener la lista de autores
        List<String> listaAutores = libro.autores();

        // Crear un DefaultListModel
        DefaultListModel<String> listModel = new DefaultListModel<>();

        // Añadir los elementos de la lista de autores al DefaultListModel
        for (String autor : listaAutores) {
            listModel.addElement(autor);
        }
           listModel.addElement("Nuevo...");

        // Establecer el DefaultListModel como el modelo de datos del JList
        lst_autores.setModel(listModel);
        lst_autores.addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting()) {
            String selected = lst_autores.getSelectedValue();
            if ("Nuevo...".equals(selected)) {
                String nuevoAutor = JOptionPane.showInputDialog(null, "Ingrese nuevo autor:", "Nuevo Autor", JOptionPane.PLAIN_MESSAGE);
                if (nuevoAutor != null && !nuevoAutor.trim().isEmpty()) {
                   if (admin.nuevoAutor(nuevoAutor)) {
                        listModel.add(listModel.getSize() - 1, nuevoAutor); // Añadir antes de "Nuevo..."
                         lst_autores.clearSelection();
                        lst_autores.setModel(listModel);
                        lst_autores.setSelectedValue(nuevoAutor, true);
                   
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al insertar el nuevo autor en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                   
                }
            }
        }
    });
    }
    private void llenarListaEditorial() {
      // Crear una instancia de la clase Libro para acceder al método autores()
        Libro libro = new Libro();

            // Obtener la lista de autores
            List<String> listaEditorial = libro.editorial();

            // Crear un DefaultListModel
          

           // Crear un DefaultComboBoxModel
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

             for (String editorial : listaEditorial) {
             comboBoxModel.addElement(editorial);
    }

    // Añadir la opción "Nuevo..." al final
    comboBoxModel.addElement("Nuevo...");

    // Establecer el DefaultComboBoxModel como el modelo de datos del JComboBox
    cmb_editorial.setModel(comboBoxModel);
    
    
        cmb_editorial.addActionListener(e -> {
        if ("Nuevo...".equals(cmb_editorial.getSelectedItem())) {
            String nuevaEditorial = JOptionPane.showInputDialog(null, "Ingrese nueva editorial:", "Nueva Editorial", JOptionPane.PLAIN_MESSAGE);
            if (nuevaEditorial != null && !nuevaEditorial.trim().isEmpty()) {
               if (admin.nuevaEditorial(nuevaEditorial)) {
                    comboBoxModel.insertElementAt(nuevaEditorial, comboBoxModel.getSize() - 1); // Añadir antes de "Nuevo..."
                    cmb_editorial.setSelectedItem(nuevaEditorial);
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Error al insertar la nueva editorial en la base de datos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
               
            }
        }
    });
        }
        
        
          private void llenarListaCategoria() {
            // Crear una instancia de la clase Libro para acceder al método autores()
            Libro libro = new Libro();

            // Obtener la lista de autores
            List<String> listaCategoria = libro.categoria();

            // Crear un DefaultListModel
          

           // Crear un DefaultComboBoxModel
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>();

        // Añadir los elementos de la lista de categoriaes al DefaultComboBoxModel
        for (String categoria : listaCategoria) {
            comboBoxModel.addElement(categoria);
        }
                cmb_categoria.setModel(comboBoxModel);

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
        txt_tituloLib = new javax.swing.JTextField();
        txt_reusmenlib = new javax.swing.JTextField();
        txt_precioLib = new javax.swing.JTextField();
        txt_stockLib = new javax.swing.JTextField();
        txt_isbnLib = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        cmb_editorial = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lst_autores = new javax.swing.JList<>();
        jLabel7 = new javax.swing.JLabel();
        btn_agregarLibro = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        lbl_logo = new javax.swing.JLabel();
        txt_descuentoLib = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_categoria = new javax.swing.JComboBox<>();
        btn_editarLibro = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_tituloLib.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txt_tituloLib, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 150, -1));

        txt_reusmenlib.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txt_reusmenlib, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 310, -1));

        txt_precioLib.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txt_precioLib, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, 150, -1));

        txt_stockLib.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txt_stockLib, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 280, 150, -1));

        txt_isbnLib.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txt_isbnLib, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 150, -1));

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel12.setText("AGREGAR NUEVO");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, -1, 40));

        cmb_editorial.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(cmb_editorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 120, 150, -1));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Titulo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Autor");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Editorial");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 160, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Precio");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, -1, -1));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("ISBN");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Resumen");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 390, -1, -1));

        lst_autores.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        lst_autores.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lst_autores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 170, 180));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Stock");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        btn_agregarLibro.setBackground(new java.awt.Color(209, 59, 83));
        btn_agregarLibro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_agregarLibro.setForeground(new java.awt.Color(255, 255, 255));
        btn_agregarLibro.setText("Agregar Libro");
        btn_agregarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarLibroActionPerformed(evt);
            }
        });
        jPanel1.add(btn_agregarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, 150, -1));

        jButton3.setBackground(new java.awt.Color(209, 59, 83));
        jButton3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Cancelar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 460, 97, -1));

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 30)); // NOI18N
        jLabel13.setText("LIBRO");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, -1, 40));

        lbl_logo.setText("logo");
        lbl_logo.setToolTipText("");
        jPanel1.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, 70));

        txt_descuentoLib.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jPanel1.add(txt_descuentoLib, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 150, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Descuento");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, -1, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Categoria");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        cmb_categoria.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        cmb_categoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "novedad" }));
        cmb_categoria.setEnabled(false);
        jPanel1.add(cmb_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, 150, -1));

        btn_editarLibro.setBackground(new java.awt.Color(209, 59, 83));
        btn_editarLibro.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_editarLibro.setForeground(new java.awt.Color(255, 255, 255));
        btn_editarLibro.setText("Editar Libro");
        btn_editarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editarLibroActionPerformed(evt);
            }
        });
        jPanel1.add(btn_editarLibro, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 460, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 519, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarLibroActionPerformed
       String titulo = txt_tituloLib.getText();
    String editorial = cmb_editorial.getSelectedItem().toString().trim();
    String precioStr = txt_precioLib.getText();
    String stockStr = txt_stockLib.getText();
    String descuentoStr = txt_precioLib.getText();
    String isbn = txt_isbnLib.getText();
    String resumen = txt_reusmenlib.getText();
   List<String> autores = lst_autores.getSelectedValuesList();
   
    double precio = Double.parseDouble(precioStr);
    int stock = Integer.parseInt(stockStr);
    
    String categoria = "novedad"; 
    String portada="";
    double descuento = Double.parseDouble(descuentoStr);
        Libro nuevoLibro = new Libro(0, titulo, precio, stock, resumen, isbn, editorial, categoria, descuento, autores,portada);
        
        if (almacenista==null) {
            admin.agregarNuevoLibro(nuevoLibro);
        }
        else{
            almacenista.agregarNuevoLibro(nuevoLibro);
            

        }      
    
    
    }//GEN-LAST:event_btn_agregarLibroActionPerformed

    
    public void setAutores(String autores) {
    DefaultListModel<String> model = (DefaultListModel<String>) lst_autores.getModel();
    String[] autoresArray = autores.split(", ");
    for (String autor : autoresArray) {
        int index = model.indexOf(autor);
        if (index != -1) {
            lst_autores.setSelectedIndex(index);
        }
    }
}
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
    this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btn_editarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editarLibroActionPerformed
    int id=libro.getId();
    String titulo = txt_tituloLib.getText();
    String editorial = cmb_editorial.getSelectedItem().toString().trim();
    String precioStr = txt_precioLib.getText();
    String stockStr = txt_stockLib.getText();
    String descuentoStr = txt_precioLib.getText();
    String isbn = txt_isbnLib.getText();
    String resumen = txt_reusmenlib.getText();
   List<String> autores = lst_autores.getSelectedValuesList();
   
    double precio = Double.parseDouble(precioStr);
    int stock = Integer.parseInt(stockStr);
    
    String categoria = "novedad"; 
    String portada="";
    double descuento = Double.parseDouble(descuentoStr);
        Libro nuevoLibro = new Libro(id, titulo, precio, stock, resumen, isbn, editorial, categoria, descuento, autores,portada);
          
        if (almacenista==null) {
              admin.editarLibro(nuevoLibro);
              
            
        }
        else{
            almacenista.editarLibro(nuevoLibro);
        
        }
          
   
    this.dispose();

        if (almacenista==null) {
            VistaInventario vistaInventario = new VistaInventario(null);
            
          vistaInventario.setAdmin(admin);
         vistaInventario.setVisible(true);
            
        }
        else{
           VistaInventario vistaInventario = new VistaInventario(almacenista);
         
         vistaInventario.setVisible(true);
            
        }
    
        
        
        
        
    }//GEN-LAST:event_btn_editarLibroActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarNuevoLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarNuevoLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarNuevoLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarNuevoLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarNuevoLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_agregarLibro;
    public javax.swing.JButton btn_editarLibro;
    public javax.swing.JComboBox<String> cmb_categoria;
    public javax.swing.JComboBox<String> cmb_editorial;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JList<String> lst_autores;
    public javax.swing.JTextField txt_descuentoLib;
    public javax.swing.JTextField txt_isbnLib;
    public javax.swing.JTextField txt_precioLib;
    public javax.swing.JTextField txt_reusmenlib;
    public javax.swing.JTextField txt_stockLib;
    public javax.swing.JTextField txt_tituloLib;
    // End of variables declaration//GEN-END:variables
}
