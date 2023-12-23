/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package moduloProductos;


import ejercicio.tiendaciclismo.Archivos;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import moduloFacturacion.Factura;
import moduloFacturacion.RegistroFacturacion;

/**
 * Clase que representa la interfaz gráfica para editar productos en un sistema de facturación.
 * Permite agregar, modificar y eliminar productos.
 * 
 * La clase utiliza un DefaultTableModel para mostrar los productos en una tabla.
 * Se comunica con las clases Archivos, RegistroProductos, TipoProducto, Articulo, RegistroFacturacion y Factura.
 * 
 * @author Jimena Mendez
 */
public class EditarProducto extends javax.swing.JFrame {
    /**
     * Modelo de tabla predeterminado para mostrar la información de los productos.
     */
    DefaultTableModel tablaProducto=new DefaultTableModel();
    /**
     * Instancia de la clase Archivos para manejar la lectura y escritura de archivos.
     */
    private Archivos reg = new Archivos();
    
    /**
     * Instancia de la clase RegistroProductos para gestionar la información de los productos.
     */
    private RegistroProductos registro = new RegistroProductos();
    
    
    /**
     * Crea una nueva instancia de la clase EditarProducto.
     * Inicializa la interfaz gráfica y carga la información de productos desde archivos.
     */
    public EditarProducto() {
        // Carga la información de productos desde archivos
        registro.ProductosArchivo(reg.leer("tiposProductos.csv"));
        registro.ArticulosArchivo(reg.leer("Articulos.csv"));
        
        // Inicializa la interfaz gráfica
        initComponents();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Configura la tabla de productos
        String productos[]={"Código","Nombre"};
        
        tablaProducto.setColumnIdentifiers(productos);
        
        jTable1.setModel(tablaProducto);
        
        jTable1.setDefaultEditor(Object.class, null);
        
        // Inicia la tabla con la información de los productos
        iniciarTabla();
        
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
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1031, 556));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        jLabel1.setText("Editar productos");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(34, 140, -1, -1));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Código", "Nombre"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(492, 80, 580, -1));
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 69, -1, -1));
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(201, 134, -1, -1));

        jTextField1.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField1KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 257, 223, 37));

        jLabel3.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel3.setText("Nombre del producto");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 216, -1, -1));

        jButton1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton1.setText("Agregar producto");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 333, -1, -1));

        jButton2.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton2.setText("Modificar producto");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 404, -1, -1));

        jButton3.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton3.setText("Eliminar producto");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 461, -1, -1));

        jButton4.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jButton4.setText("Regresar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1095, 21, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1491, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    /**
     * Maneja el evento de clic en el botón "Modificar producto".
     * Intenta modificar el nombre del producto seleccionado en la tabla.
     * Si no se ha seleccionado un producto, muestra un mensaje de advertencia.
     * 
     * @param evt Evento de acción que desencadena este método (clic en el botón).
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try{
            if (!jTextField1.getText().isEmpty()){
                DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                int fila=jTable1.getSelectedRow();
                registro.modificarProducto(registro.getTiposProductos().get(fila).getCodigo(), jTextField1.getText());
                model.setValueAt(jTextField1.getText(),fila , 1);
                jTextField1.setText("");
                JOptionPane.showMessageDialog(null, "Se ha modificado el producto", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                jButton2.setEnabled(false);
                jButton3.setEnabled(false);
            }else{
                   JOptionPane.showMessageDialog(jPanel1, "Debe ingresar el nombre del producto que desea modificar."); 
            }
            
        }catch (Exception e){
            JOptionPane.showMessageDialog(jPanel1, "Debe seleccionar una fila.");
        
        }
        
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * Maneja el evento de clic en el botón "Agregar producto".
     * Intenta agregar un nuevo tipo de producto con el nombre ingresado.
     * Si el nombre ya existe, muestra un mensaje de advertencia.
     * 
     * @param evt Evento de acción que desencadena este método (clic en el botón).
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTextField1.getText().trim().isEmpty()){
            for (TipoProducto producto:registro.getTiposProductos()){
                String nombreGuardado=producto.getNombre();
                if (nombreGuardado.equalsIgnoreCase(jTextField1.getText())){
                    JOptionPane.showMessageDialog(jPanel1, "Debe agregar un producto que no exista.");
                    return;
                }
            }
            
            registro.agregarTipoProducto(jTextField1.getText());
            iniciarTabla();
            JOptionPane.showMessageDialog(null, "Se ha agregado el producto", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            jButton2.setEnabled(false);
            jButton3.setEnabled(false);
            jTextField1.setText("");
            
        }else{
            JOptionPane.showMessageDialog(jPanel1, "Debe ingresar el nombre del producto que desea agregar.");
        }   
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Maneja el evento de clic en el botón "Eliminar producto".
     * Pide confirmación al usuario antes de eliminar un producto.
     * Si se confirma y no hay artículos facturados, elimina el producto seleccionado.
     * 
     * @param evt Evento de acción que desencadena este método (clic en el botón).
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (confirmacion()){
            try{
                int filaSeleccionada=jTable1.getSelectedRow();
                if(!articulosFacturados(registro.getTiposProductos().get(filaSeleccionada).getCodigo())){
                    DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                    registro.deleteProducto(registro.getTiposProductos().get(filaSeleccionada).getCodigo());
                    jTextField1.setText("");
                    model.removeRow(filaSeleccionada);
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el producto", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    jButton2.setEnabled(false);
                    jButton3.setEnabled(false);
                }else{
                    JOptionPane.showMessageDialog(jPanel1, "Hay articulos que se encuentran facturados dentro de este producto"); 
                }
            }catch (Exception e){
                JOptionPane.showMessageDialog(jPanel1, "Debe seleccionar una fila.");
            }
        }else{
            JOptionPane.showMessageDialog(jPanel1, "No se elimino el producto.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    /**
     * Maneja el evento de clic en el botón "Regresar".
     * Cierra la ventana actual y abre la ventana principal de productos.
     * 
     * @param evt Evento de acción que desencadena este método (clic en el botón).
     */
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ProductosVentana v1=new ProductosVentana();
        v1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * Maneja el evento de clic en la tabla.
     * Al hacer clic en una fila de la tabla, muestra el nombre del producto en un campo de texto.
     * 
     * @param evt Evento de ratón que desencadena este método (clic en la tabla).
     */
    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
        int filaSeleccionada=jTable1.getSelectedRow();     
        jTextField1.setText((String) model.getValueAt(filaSeleccionada, 1));
        
    }//GEN-LAST:event_jTable1MouseClicked

    private void jTextField1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyTyped
        char letra = evt.getKeyChar();
        if (!(Character.isLetter(letra) || letra == ' ' || letra == KeyEvent.VK_BACK_SPACE || letra == KeyEvent.VK_DELETE)){
            evt.consume();
        }          
    }//GEN-LAST:event_jTextField1KeyTyped

    /**
     * Verifica si el usuario confirma una acción.
     * Muestra un cuadro de diálogo de confirmación y devuelve true si se confirma, false en caso contrario.
     * 
     * @return True si el usuario confirma la acción, false si cancela.
     */
    private boolean confirmacion(){
        int opcion = JOptionPane.showConfirmDialog(jPanel1,
                    "¿Desea realizar la acción?",
                    "Confirmación",
                    JOptionPane.OK_CANCEL_OPTION);

            if (opcion == JOptionPane.OK_OPTION) {
                return true;
            } else {
                return false;
            }
    }
    
    
    
    /**
     * Verifica si hay artículos facturados asociados a un producto.
     * 
     * @param codigo Código del producto a verificar.
     * @return True si hay artículos facturados, false si no los hay.
     */
    private boolean articulosFacturados(int codigo){
        ArrayList<Articulo> articulosProducto= registro.obtenerArticulos(codigo);
        
        for (Articulo articulo:articulosProducto){
            int codigoArticulo=articulo.getCodigo();
            if (articuloFacturado(codigoArticulo,codigo)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Verifica si un artículo está facturado dentro de un producto.
     * 
     * @param codigo Código del artículo a verificar.
     * @param codigoProducto Código del producto al que pertenece el artículo.
     * @return True si el artículo está facturado, false si no lo está.
     */
    private boolean articuloFacturado(int codigo,int codigoProducto){
        RegistroFacturacion registroFacturas=new RegistroFacturacion();
        registroFacturas.FacturasArchivo(reg.leer("Facturas"));
        
        for(Factura factura:registroFacturas.getFacturas()){
            int codigoExiste= factura.getCodigoArticulo();
            int codigoProductoExiste=factura.getCodigoProducto();
            if (codigoExiste==codigo && codigoProductoExiste==codigoProducto){
                return true;
            }
        }
        return false;
    }
    
    

    
    
    /**
     * Inicializa la tabla de productos con los datos de la lista de tipos de productos.
     */
    private void iniciarTabla(){
        tablaProducto.setRowCount(0);
        for (TipoProducto producto:registro.getTiposProductos()){
            Object[] fila={producto.getCodigo(),producto.getNombre()};
            tablaProducto.addRow(fila);
        }
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
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
            java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarProducto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarProducto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

}