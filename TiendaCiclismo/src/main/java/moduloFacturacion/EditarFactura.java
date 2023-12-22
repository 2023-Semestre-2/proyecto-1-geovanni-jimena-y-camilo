/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package moduloFacturacion;

import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import ejercicio.tiendaciclismo.Archivos;
import moduloProductos.RegistroProductos;
import moduloProductos.TipoProducto;
import moduloProductos.Articulo;

/**
 * Esta clase representa la interfaz gráfica para editar facturas.
 * Permite agregar, anular y visualizar facturas.
 * Utiliza la clase Archivos para la manipulación de archivos y la
 * clase RegistroFacturacion para gestionar las facturas.
 * También utiliza la clase RegistroProductos para obtener información
 * sobre los productos relacionados con las facturas.
 * La interfaz gráfica incluye una tabla para mostrar las facturas y
 * varios campos y controles para la edición de facturas.
 *
 * @author Jimena Mendez
 */
public class EditarFactura extends javax.swing.JFrame {
    DefaultTableModel tablaFactura=new DefaultTableModel();
    private Archivos reg=new Archivos();
    private RegistroFacturacion registro= new RegistroFacturacion();
    private RegistroProductos registroProductos= new RegistroProductos();
    /**
     * Constructor de la clase EditarFactura.
     * Inicializa la interfaz gráfica y carga datos iniciales.
     */
    public EditarFactura() {
        registro.FacturasArchivo(reg.leer("Facturas"));
        registroProductos.ProductosArchivo(reg.leer("tiposProductos"));
        registroProductos.ArticulosArchivo(reg.leer("Articulos"));
        
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String facturas[]={"Numero","Nombre Cliente","Fecha","Estado","Subtotal","Impuesto","Total"};
        
        tablaFactura.setColumnIdentifiers(facturas);
        
        jTable1.setModel(tablaFactura);
        
        jTable1.setDefaultEditor(Object.class, null);
        
        IniciarTabla();
    }

    
    /**
     * Inicia la tabla de facturas con los datos actuales.
     * Actualiza la información mostrada en la tabla.
     */
    public void IniciarTabla(){
        tablaFactura.setRowCount(0);
        //Datos de las facturas
        for (Factura factura:registro.getFacturas()){
            
            if (factura.getTipo().equals("Articulo")){
                Object[] fila={factura.getNumeroFactura(),factura.getNombre(),factura.getFecha(),factura.getEstado(),factura.calculaSubtotal(),factura.calculaImpuestoArticulo(),factura.calculaImpuestoArticulo()+factura.calculaSubtotal()};
                tablaFactura.addRow(fila);
            }else{
                Object[] fila={factura.getNumeroFactura(),factura.getNombre(),factura.getFecha(),factura.getEstado(),factura.getPrecio(),factura.calculaImpuestoServicio(),factura.getPrecio()+factura.calculaImpuestoServicio()};
                tablaFactura.addRow(fila);
            } 
        }
        asignaProductos();
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    
    /**
     * Asigna productos al JComboBox para la selección.
     * Utiliza la información de la clase RegistroProductos.
     */
    public void asignaProductos(){
        jComboBox3.removeAllItems();
        for(TipoProducto producto:registroProductos.getTiposProductos()){
            String nombre= producto.getNombre();
            jComboBox3.addItem(nombre);     
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Numero", "Nombre cliente", "Fecha de recibido", "Estado", "Subtotal", "Impuesto", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Anular");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButton1.setText("Regresar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Editar Facturas");

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lana", "Sofia", "Cory", "Mina", "Lola", "Roberto" }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Nombre del cliente:");

        jDateChooser1.setDateFormatString("dd/MM/yyyy");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Fecha de recibido:");

        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Producto:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Articulo" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Artículo:");

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("Cantidad:");

        jLabel14.setText("----");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel12.setText("Precio unitario:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(91, 91, 91)
                .addComponent(jButton3)
                .addGap(307, 307, 307))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel15)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 837, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(21, 21, 21))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))
                                .addGap(23, 23, 23)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel11))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel14)
                                    .addComponent(jLabel12)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(71, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addGap(27, 27, 27))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    /**
     * Método llamado cuando se presiona el botón "Anular".
     * Anula la factura seleccionada y actualiza la tabla.
     * Muestra un mensaje de confirmación antes de realizar la acción.
     */
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int fila=jTable1.getSelectedRow();
        if (confirmacion()){
            try{
                DefaultTableModel model=(DefaultTableModel)jTable1.getModel();
                int filaSeleccionada=jTable1.getSelectedRow();
                registro.anularFactura(registro.getFacturas().get(filaSeleccionada).getNumeroFactura());

                
                model.removeRow(filaSeleccionada);
                IniciarTabla();
                JOptionPane.showMessageDialog(null, "Se ha anulado la factura", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception e){
                JOptionPane.showMessageDialog(jPanel1, "Debe seleccionar una fila.");
            }
        }else{
            JOptionPane.showMessageDialog(jPanel1, "No se anulo la factura.");
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    
    /**
     * Realiza la confirmación para acciones críticas.
     *
     * @return true si se confirma la acción, false si se cancela
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
    
    
    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        FacturacionVentana v1=new FacturacionVentana();
        v1.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * JComboBox que permite la selección del producto al editar la factura.
     * Se llena con los tipos de productos disponibles.
     */
    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        String nombreProducto = (String) jComboBox3.getSelectedItem();
        jLabel14.setText("----");
        //Buscar el codigo del nombre del grupo asignado
        int codigoProducto=registroProductos.codigoProducto(nombreProducto);
        ArrayList<Articulo> articulosProducto=registroProductos.obtenerArticulos(codigoProducto);//Arraylist con los articulos del producto
        
        if (!articulosProducto.isEmpty()){
            jComboBox1.removeAllItems();
            for (Articulo articulo:articulosProducto){
                jComboBox1.addItem(articulo.getNombre());
            }
        }else{
            jComboBox1.setEditable(false);
            jComboBox1.removeAllItems();
        }
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        char numero = evt.getKeyChar();
        if (!(Character.isDigit(numero)) || (numero == KeyEvent.VK_BACK_SPACE) || (numero == KeyEvent.VK_DELETE)){
            evt.consume();
        } 
    }//GEN-LAST:event_jTextField4KeyTyped

    /**
     * JComboBox que permite la selección del tipo de artículo al agregar una factura.
     * Actualmente, solo permite seleccionar "Articulo".
     */
    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String nombreArticulo = (String) jComboBox1.getSelectedItem();
       

        for(Articulo articulo:registroProductos.getArticulos()){
            String nombreExiste= articulo.getNombre();
            if (nombreExiste.equals(nombreArticulo)){
                int precio=articulo.getPrecio();
                jLabel14.setText(String.valueOf(precio));
                break;
            }
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    /**
     * Método llamado cuando se presiona el botón "Agregar".
     * Agrega una nueva factura con la información proporcionada.
     * Actualiza la tabla de facturas.
     * Si la cantidad de artículos es mayor que la cantidad disponible,
     * muestra un mensaje de error.
     */
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        try{
            DateFormat formato=new SimpleDateFormat(jDateChooser1.getDateFormatString());
            String fecha= formato.format(jDateChooser1.getDate());
        }catch (Exception e){
            JOptionPane.showMessageDialog(jPanel1, "Debes ingresar un formato correcto de fecha");
            return;
        }
        DateFormat formato=new SimpleDateFormat(jDateChooser1.getDateFormatString());
        String fecha= formato.format(jDateChooser1.getDate());
        if (!jTextField4.getText().isEmpty() && jComboBox1.getItemCount()!=0 && !fecha.isEmpty()){
            //Ver si la cantidad que ingresó se excedio de la cantidad de articulos que estan disponibles
            int cantidadIngresada=Integer.parseInt(jTextField4.getText());
            Articulo articulo=null;
            int cantidadDisponible=0;
            for(Articulo articuloExiste:registroProductos.getArticulos()){
                String nombre=articuloExiste.getNombre();
                if(nombre.equals(jComboBox1.getSelectedItem().toString())){
                    cantidadDisponible=articuloExiste.getCantidad();
                    if (cantidadIngresada>cantidadDisponible){
                        JOptionPane.showMessageDialog(jPanel1, "Se excedio de la cantidad de articulos que puede adquirir.");
                        return;
                    }else{
                        articulo=articuloExiste;
                        
                    }
                }
            }
            
            registroProductos.modificarArticulo(articulo.getCodigo(), articulo.getCodigoTipoProducto(), articulo.getNombre(), articulo.getTipo(), articulo.getTamano(), articulo.getMarca(), articulo.getPrecio(), cantidadDisponible-cantidadIngresada);
           
            try{
            
            System.out.println(jComboBox2.getSelectedItem().toString());
            System.out.println(fecha);
            System.out.println(cantidadIngresada);
            System.out.println(jComboBox1.getSelectedItem().toString());
            registro.agregarFactura(jComboBox2.getSelectedItem().toString(),fecha , "Válido", cantidadIngresada, jComboBox1.getSelectedItem().toString(), 0, "Articulo");
            IniciarTabla();
            JOptionPane.showMessageDialog(null, "Se ha agregado la factura", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(jPanel1, "Debes rellenar todos los espacios");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    
    /**
     * JComboBox que permite la selección del nombre del cliente al editar la factura.
     */
    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox2ActionPerformed

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
            java.util.logging.Logger.getLogger(EditarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarFactura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarFactura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
    
