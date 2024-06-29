/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VISTAS;
import clases.Admin;
import clases.Almacenista;
import clases.Empleado;
import clases.Inventario;
import clases.Libro;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableRowSorter;
/**
 *
 * @author lucas
 */
public class VistaInventario extends javax.swing.JFrame {

    private Admin admin;
    private Almacenista almacenista;
    /**
     * Creates new form Inventario
     */
    public VistaInventario( Almacenista almacenista) {
        this.almacenista=almacenista;
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
        llenarTablaInventario();
        configurarTabla();
    }
    public void setAdmin(Admin admin) {
    this.admin = admin;
    }
  
    
    
    private void llenarTablaInventario() {
        Inventario inventario = new Inventario();
        List<Libro> libros = inventario.inventario();

        DefaultTableModel model = (DefaultTableModel) tabla_inventario.getModel();
        model.setRowCount(0); // Limpiar el modelo de tabla existente

        for (Libro libro : libros) {
            model.addRow(new Object[]{libro.getId(), libro.getTituloLibro(), String.join(", ", libro.getAutores()), libro.getEditorial(), libro.getPrecioLibro(), libro.getStockLibro(),"edtiar","eliminar"});
        }
        
        // Ordenar por la primera columna (id)
    }
    
    
    private void configurarTabla() {
        // Configurar renderizador y editor para las columnas "Editar" y "Eliminar"
        TableColumn editColumn = tabla_inventario.getColumnModel().getColumn(6);
        editColumn.setCellRenderer(new ButtonRenderer());
        editColumn.setCellEditor(new ButtonEditor(new JButton("Editar"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   int row = tabla_inventario.getSelectedRow();
                    Inventario inventario = new Inventario();
                    List<Libro> libros = inventario.inventario();

                   
                     Libro libro = libros.get(row); // Obtener el libro de la lista usando el índice de la fila
                    abrirFormularioAgregarNuevoLibro(libro);
            }
        }));
               TableColumn deleteColumn = tabla_inventario.getColumnModel().getColumn(7);
        deleteColumn.setCellRenderer(new ButtonRenderer());
        deleteColumn.setCellEditor(new ButtonEditor(new JButton("Eliminar"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Eliminar clickeado");
            }
        }));
    }
        private void abrirFormularioAgregarNuevoLibro(Libro libro) {
        AgregarNuevoLibro agregarNuevoLibro = new AgregarNuevoLibro();
        if (almacenista == null) {
           
            agregarNuevoLibro.setAdmin(admin);
        } else {
            agregarNuevoLibro.setAlmacenista(almacenista);
        }
           agregarNuevoLibro.txt_tituloLib.setText(libro.getTituloLibro());
           agregarNuevoLibro.txt_isbnLib.setText(libro.getIsbnLibro());
           agregarNuevoLibro.txt_reusmenlib.setText(libro.getResumenLibro());
           agregarNuevoLibro.cmb_editorial.setSelectedItem(libro.getEditorial());
           agregarNuevoLibro.cmb_categoria.setSelectedItem(libro.getCategoria()); 
           agregarNuevoLibro.txt_precioLib.setText(String.valueOf(libro.getPrecioLibro()));
           agregarNuevoLibro.txt_stockLib.setText(String.valueOf(libro.getStockLibro()));
           agregarNuevoLibro.txt_descuentoLib.setText(String.valueOf(libro.getDescuento()));
        // Ocultar el botón "Agregar nuevo libro"
           agregarNuevoLibro.btn_agregarLibro.setVisible(false);
           agregarNuevoLibro.setAutores(libro.getAutores());
           agregarNuevoLibro.setLibro(libro);
           agregarNuevoLibro.setVisible(true);
        
        
      
    }
    
    
    

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
              setMargin(new Insets(2, 0, 2, 0)); // Ajustar los márgenes del botón
            setOpaque(true);
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    class ButtonEditor extends AbstractCellEditor implements TableCellEditor, ActionListener {
        private JButton button;
        private String label;
        private boolean isPushed;
        private ActionListener actionListener;

        public ButtonEditor(JButton button, ActionListener actionListener) {
            this.button = button;
            this.actionListener = actionListener;
            this.button.addActionListener(this);
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            return button;
        }

        @Override
        public Object getCellEditorValue() {
            isPushed = false;
            return label;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (isPushed) {
                actionListener.actionPerformed(e);
            }
            fireEditingStopped();
        }

        @Override
        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }
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
        jButton2 = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();
        lbl_logo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_inventario = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("INVENTARIO");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        jButton2.setBackground(new java.awt.Color(209, 59, 83));
        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Agregar nuevo libro");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jButtonRegresar.setBackground(new java.awt.Color(209, 59, 83));
        jButtonRegresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButtonRegresar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });
        jPanel1.add(jButtonRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 150, 40));

        lbl_logo.setText("logo");
        lbl_logo.setToolTipText("");
        jPanel1.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 80, 70));

        tabla_inventario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Titulo", "Autor", "Editorial", "Precio", "Stock", "Editar", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(tabla_inventario);
        if (tabla_inventario.getColumnModel().getColumnCount() > 0) {
            tabla_inventario.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabla_inventario.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 620, 170));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 651, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        this.setVisible(false);
        new PuntoDeVenta(null).setVisible(true);
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (almacenista==null) {
            
        AgregarNuevoLibro agregarNuevoLibro= new AgregarNuevoLibro();
        agregarNuevoLibro.setAdmin(admin);
        agregarNuevoLibro.setVisible(true);
            
        }
        else{
         AgregarNuevoLibro agregarNuevoLibro= new AgregarNuevoLibro();
        agregarNuevoLibro.setAlmacenista(almacenista);
        agregarNuevoLibro.setVisible(true);
        }
       
        
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaInventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaInventario(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JTable tabla_inventario;
    // End of variables declaration//GEN-END:variables
}
