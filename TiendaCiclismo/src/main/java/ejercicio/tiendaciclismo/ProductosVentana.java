/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Pattern;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jimen
 */
public class ProductosVentana extends javax.swing.JFrame{
    DefaultTableModel tablaProducto=new DefaultTableModel();
    DefaultTableModel tablaArticulo=new DefaultTableModel();
    private Archivos reg = new Archivos();
    private RegistroProductos registro = new RegistroProductos();
    

    /**
     * Creates new form ProductosVentana
     */
    public ProductosVentana() {
        registro.ArticulosArchivo(reg.leer("Articulos"));
        registro.ProductosArchivo(reg.leer("tiposProductos"));
        
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String productos[]={"Código","Nombre"};
        String articulos[]={"Código","Producto","Nombre","Tipo","Tamaño","Marca","Precio","Cantidad"};
        
        tablaProducto.setColumnIdentifiers(productos);
        tablaArticulo.setColumnIdentifiers(articulos);
        
        jTable1.setModel(tablaArticulo);
        jTable2.setModel(tablaProducto);
        
        jTable1.setDefaultEditor(Object.class, null);
        jTable2.setDefaultEditor(Object.class, null);
        
        iniciarTablas();
        
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
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Registro de productos");

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Producto", "Nombre", "Tipo", "Tamaño", "Marca", "Precio", "Cantidad"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Codigo", "Nombre"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel4.setText("Productos");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel5.setText("Opciones");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jLabel6.setText("Artículos");

        jButton2.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton2.setText("Editar Productos");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jButton3.setText("Editar Artículos");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });

        jLabel2.setText("Código:");

        jLabel7.setText("Nombre:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(396, 396, 396)
                .addComponent(jLabel1)
                .addGap(57, 57, 57))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton3))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addComponent(jButton2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabel5)))))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel7))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(21, 21, 21)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (!jTextField3.getText().isEmpty() && !jTextField1.getText().isEmpty()){
            ArrayList<Articulo> articulosBuscados=new ArrayList<>();
            ArrayList<TipoProducto> productosBuscados=new ArrayList<>();
            if (verificarNombre(jTextField3.getText())){
                articulosBuscados=registro.buscarNombreArticulo(jTextField3.getText());
                productosBuscados=registro.buscarNombreProducto(jTextField3.getText());
           
            }else{
                JOptionPane.showMessageDialog(jPanel1, "El nombre contiene caracteres no permitidos.");
                return;
            }
                
            if(esEntero(jTextField1.getText())){
                articulosBuscados.addAll(registro.buscarCodigoArticulo(Integer.parseInt(jTextField1.getText())));
                productosBuscados.addAll(registro.buscarCodigoProducto(Integer.parseInt(jTextField1.getText())));
                
            }else{
                    JOptionPane.showMessageDialog(jPanel1, "Debe ingresar el codigo como un numero entero.");
                    return;
            }
            
            if (articulosBuscados==null && productosBuscados==null){
                JOptionPane.showMessageDialog(jPanel1, "Los datos no se encuentran entre los productos o artículos.");
                return;
            }else{
                if(articulosBuscados!=null){
                    seleccionaArticulos(articulosBuscados);
                }
                if (productosBuscados!=null){
                    seleccionaProductos(productosBuscados);
                } 
            }
        }else{
            if (!jTextField3.getText().isEmpty()){
                if (verificarNombre(jTextField3.getText())){
                    ArrayList<Articulo> articulosBuscados=new ArrayList<>();
                    ArrayList<TipoProducto> productosBuscados=new ArrayList<>();
                    articulosBuscados=registro.buscarNombreArticulo(jTextField3.getText());
                    productosBuscados=registro.buscarNombreProducto(jTextField3.getText());
                    if (articulosBuscados==null && productosBuscados==null){
                        JOptionPane.showMessageDialog(jPanel1, "El nombre no se encuentra entre los productos o artículos.");
                        return;
                    }else{
                        if(articulosBuscados!=null){
                            seleccionaArticulos(articulosBuscados);
                        }
                        if (productosBuscados!=null){
                            seleccionaProductos(productosBuscados);
                        } 
                    }
                }else{
                    JOptionPane.showMessageDialog(jPanel1, "El nombre contiene caracteres no permitidos.");
                }
            }else{
                if (!jTextField1.getText().isEmpty()){
                if (esEntero(jTextField1.getText())){
                    ArrayList<Articulo> articulosBuscados=new ArrayList<>();
                    ArrayList<TipoProducto> productosBuscados=new ArrayList<>();
                    articulosBuscados=registro.buscarCodigoArticulo(Integer.parseInt(jTextField1.getText()));
                    productosBuscados=registro.buscarCodigoProducto(Integer.parseInt(jTextField1.getText()));
                    if (articulosBuscados==null && productosBuscados==null){
                        JOptionPane.showMessageDialog(jPanel1, "El nombre no se encuentra entre los productos o artículos.");
                    }else{
                        if(articulosBuscados!=null){
                            seleccionaArticulos(articulosBuscados);
                        }
                        if (productosBuscados!=null){
                            seleccionaProductos(productosBuscados);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(jPanel1, "Debe ingresar el codigo como un numero entero.");
                }
                }else{
                    tablaArticulo.setRowCount(0);
                    tablaProducto.setRowCount(0);
                    iniciarTablas();            
            
            }
        }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void seleccionaArticulos(ArrayList<Articulo> articulos){
        tablaArticulo.setRowCount(0);
        for (Articulo art:articulos){
            Object[] filaArt={art.getCodigo(),art.getCodigoTipoProducto(),art.getNombre(),art.getTipo(),art.getTamano(),art.getMarca(),art.getPrecio(),art.getCantidad()};
            tablaArticulo.addRow(filaArt);
        }
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    private void seleccionaProductos(ArrayList<TipoProducto> productos){
        tablaProducto.setRowCount(0);
        for (TipoProducto producto:productos){
            Object[] fila={producto.getCodigo(),producto.getNombre()};
            tablaProducto.addRow(fila);
        }
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    
    /**
     *
     * @param listaConDuplicados
     * @return
     */

    
    private boolean verificarNombre(String nombre) {
        // Utilizar una expresión regular para verificar que el nombre solo tenga letras
        String regex = "^[a-zA-Z]+$";
        return Pattern.matches(regex, nombre);
    }
    
    public static boolean esEntero(String cadena) {
        try {
            // Intentar convertir la cadena a un entero
            Integer.parseInt(cadena);
            // Si la conversión es exitosa, la cadena es un entero
            return true;
        } catch (NumberFormatException e) {
            // Si ocurre una excepción, la cadena no es un entero
            return false;
        }
    }
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        EditarProducto ventanaProducto=new EditarProducto();
        ventanaProducto.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        EditarArticulo ventanaArticulo=new EditarArticulo();
        ventanaArticulo.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed
    
    
    
    private void iniciarTablas(){//En esta funcion se agregan los datos del arraylist a la tabla
        
        //Datos de los productos
        for (TipoProducto producto:registro.getTiposProductos()){
            Object[] fila={producto.getCodigo(),producto.getNombre()};
            tablaProducto.addRow(fila);
        }
            
        for (Articulo art:registro.getArticulos()){
            Object[] filaArt={art.getCodigo(),art.getCodigoTipoProducto(),art.getNombre(),art.getTipo(),art.getTamano(),art.getMarca(),art.getPrecio(),art.getCantidad()};
            tablaArticulo.addRow(filaArt);
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
            java.util.logging.Logger.getLogger(ProductosVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ProductosVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ProductosVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ProductosVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProductosVentana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration//GEN-END:variables

    static class setVisible {

        public setVisible() {
        }
    }
}
