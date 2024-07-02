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
import clases.ListaEmpleados;
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
public class VistaEmpleados extends javax.swing.JFrame {

    private Admin admin;
   
    /**
     * Creates new form Inventario
     */
    public VistaEmpleados(Admin admin) {
        this.admin=admin;
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
        llenarTablaEmpleados();
        configurarTabla();
           if(admin==null){
        JOptionPane.showMessageDialog(null, "admin es null");
            
        }
    }
  
  
    
    
    private void llenarTablaEmpleados() {
    ListaEmpleados listaEmpleados = new ListaEmpleados();
    List<Empleado> empleados = listaEmpleados.Empleados();

    DefaultTableModel model = (DefaultTableModel) tabla_empleados.getModel();
    model.setRowCount(0); // Limpiar el modelo de tabla existente

    for (Empleado empleado : empleados) {
        // Filtrar solo los empleados cuyo atributo tipo sea 2 o 3
        if (empleado.getTipo() == 2 || empleado.getTipo() == 3) {
            model.addRow(new Object[]{
                empleado.getUsuario(),
                empleado.getNombre(),
                empleado.getApeMaterno(),
                empleado.getApePaterno(),
                empleado.getTipo(),
                empleado.getEstatusEmpleado(),
                "editar",
                "eliminar"
            });
        }
    }
}
    
    
    private void configurarTabla() {
        // Configurar renderizador y editor para las columnas "Editar" y "Eliminar"
        TableColumn editColumn = tabla_empleados.getColumnModel().getColumn(6);
        editColumn.setCellRenderer(new ButtonRenderer());
        editColumn.setCellEditor(new ButtonEditor(new JButton("Editar"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   int row = tabla_empleados.getSelectedRow();
                    ListaEmpleados listaEmpleados = new ListaEmpleados();
                    List<Empleado> empleados = listaEmpleados.Empleados();

                   
                     Empleado empleado = empleados.get(row); 
                
                    abrirFormularioAgregarNuevoEmpleado(empleado);
            }
        }));
               TableColumn deleteColumn = tabla_empleados.getColumnModel().getColumn(7);
        deleteColumn.setCellRenderer(new ButtonRenderer());
        deleteColumn.setCellEditor(new ButtonEditor(new JButton("Eliminar"), new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
             int row = tabla_empleados.getSelectedRow();
            int confirm = JOptionPane.showConfirmDialog(null, "¿Está seguro que desea eliminar este libro?", "Confirmación de eliminación", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                  ListaEmpleados listaEmpleados = new ListaEmpleados();
                  List<Empleado> empleados = listaEmpleados.Empleados();

                   
                  Empleado empleado = empleados.get(row); 
                  admin.eliminarEmpleado(empleado);
              
                }else{
                
            }
            llenarTablaEmpleados();
            
            }
        }));
    }
     private void abrirFormularioAgregarNuevoEmpleado(Empleado empleado) {
       AgregarNuevoEmpleado agregarNuevoEmpleado= new AgregarNuevoEmpleado(admin);
       agregarNuevoEmpleado.setEmpleado(empleado);
       agregarNuevoEmpleado.txt_nombreEmp.setText(empleado.getNombre());
       agregarNuevoEmpleado.txt_patEmp.setText(empleado.getApePaterno());
       agregarNuevoEmpleado.txt_matEmp.setText(empleado.getApeMaterno());
       agregarNuevoEmpleado.cmb_tipoEmp.setSelectedItem(empleado.getTipo());
       agregarNuevoEmpleado.cmb_turnoEmp.setSelectedItem(empleado.getTurno());
       agregarNuevoEmpleado.setVisible(true);
          
        
        
      
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
        btn_regresar = new javax.swing.JButton();
        lbl_logo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla_empleados = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel12.setText("Empleados");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 20, -1, -1));

        btn_regresar.setBackground(new java.awt.Color(209, 59, 83));
        btn_regresar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btn_regresar.setForeground(new java.awt.Color(255, 255, 255));
        btn_regresar.setText("Regresar");
        btn_regresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_regresarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_regresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 150, 40));

        lbl_logo.setText("logo");
        lbl_logo.setToolTipText("");
        jPanel1.add(lbl_logo, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 80, 70));

        tabla_empleados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Usuario", "Nombres", "Paterno", "Materno", "Tipo", "Status", "Editar", "Eliminar"
            }
        ));
        jScrollPane1.setViewportView(tabla_empleados);
        if (tabla_empleados.getColumnModel().getColumnCount() > 0) {
            tabla_empleados.getColumnModel().getColumn(6).setPreferredWidth(100);
            tabla_empleados.getColumnModel().getColumn(7).setPreferredWidth(100);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 620, 170));

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

    private void btn_regresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_regresarActionPerformed
        this.setVisible(false);
        
            new PuntoDeVentaAdmin(admin).setVisible(true);
            
        
            
        
    
        
    }//GEN-LAST:event_btn_regresarActionPerformed

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
            java.util.logging.Logger.getLogger(VistaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaEmpleados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaEmpleados(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btn_regresar;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_logo;
    private javax.swing.JTable tabla_empleados;
    // End of variables declaration//GEN-END:variables
}
