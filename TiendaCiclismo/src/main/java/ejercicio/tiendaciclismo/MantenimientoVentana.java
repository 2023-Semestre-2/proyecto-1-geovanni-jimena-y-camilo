/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author luisc
 */
public class MantenimientoVentana extends javax.swing.JFrame {

    private ArrayList<Cliente> clientes;
    private ArrayList<Mantenimiento> taller;
    private Mantenimiento m1;
    private DefaultTableModel model;
    
    /**
     * Creates new form MantenimientoVentana
     */
    public MantenimientoVentana() {
        initComponents();
        clientes = new ArrayList<>();
        taller = new ArrayList<>();
        model = (DefaultTableModel)tblTablaMantenimiento.getModel();
        loadFileToArray();
        loadClientes();
        centrarCeldas();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        m1 = new Mantenimiento(1, 1, "Yamaha", "All good", 100, "23", "293", "Mal estado", "Abierto", "Camilo");

        
        clientes.add(new Cliente(0, "Camilo", "Oro", 8596, "dlf@gmail.com", "Cartago", "Cartago", "Oriental", "12/03/03"));
        clientes.add(new Cliente(1, "Pepe", "Mati", 605, "az@gmail.com", "Cartago", "Cartago", "Occidental", "12/03/207"));
        clientes.add(new Cliente(2, "Pepe", "Mati", 605, "az@gmail.com", "Cartago", "Cartago", "Occidental", "12/03/207"));

    }
    
    private void loadFileToArray(){
        try {
            taller = FileManager.readFileToArray("mantenimiento.csv");
            System.out.println(taller.size());
        } catch (IOException ex) {
            System.out.println("No funciono");
        }
    }
    
    private void buscarCliente(String texto){
        String seleccionado = cmbBuscar.getSelectedItem().toString();
        
        if(seleccionado.equals("Codigo")){
            // expresion regular para buscar si es solo numero
            if(texto.matches("\\d+")){
                buscarClienteCodigo(Integer.parseInt(texto)); 
            }
            else if(texto.isBlank()){
                eraseTable();
                loadClientes();
            
            }
            else{
                JOptionPane.showMessageDialog(null, "Error, contiene caracteres invalidos", "Error", JOptionPane.ERROR_MESSAGE);   
            }
        }
        else{
            buscarClienteNombre(texto);
        }
    }
    
    private void loadClientes(){
        for (int i = 0; i < taller.size(); i++) {
            model.addRow(new Object[]{taller.get(i).getCodigo_servicio(), taller.get(i).getCodigo_cliente(), 
            taller.get(i).getMarca_bicicleta(), taller.get(i).getDescripcion(), taller.get(i).getPrecio(), 
            taller.get(i).getFecha_recibido(), taller.get(i).getFecha_entrega(), taller.get(i).getObservaciones(),
            taller.get(i).getEstado()});
        }
        repaint();
    }
    
    
    private void buscarClienteCodigo(int codigo_buscar){
        boolean buscado = false;
        int contador = 0;
        for (int i = 0; i < taller.size(); i++) {
            if(taller.get(i).getCodigo_cliente() == codigo_buscar){
                if(contador == 0){
                   eraseTable();
                }
                System.out.println("Cliente encontrado: ");
                mostrarClientes(taller.get(i));
                System.out.println(taller.get(i).toString());
                buscado = true;
                contador++;
               // break;
            }
        }
        if(buscado == false){
            JOptionPane.showMessageDialog(null, "No se ha encontrado al cliente", "Error", JOptionPane.ERROR_MESSAGE);   
        } 
    }
    
    private void mostrarClientes(Mantenimiento m1){
        DefaultTableModel model = (DefaultTableModel)tblTablaMantenimiento.getModel();
        model.addRow(new Object[]{m1.getCodigo_servicio(), m1.getCodigo_cliente(), m1.getMarca_bicicleta(), 
            m1.getDescripcion(), m1.getPrecio(), m1.getFecha_recibido(), m1.getFecha_entrega(), m1.getObservaciones(),
            m1.getEstado()});
        repaint();
    
    }
    
    private void buscarClienteNombre(String nombre_buscar){
        boolean buscado = false;
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getNombre().equals(nombre_buscar)){
                System.out.println("Cliente encontrado: ");
                System.out.println(clientes.get(i).toString());
                buscado = true;
            }
        }
        if(buscado == false){
            JOptionPane.showMessageDialog(null, "No se ha encontrado al cliente", "Error", JOptionPane.ERROR_MESSAGE);   
   
        }
    }
    
    private void centrarCeldas(){
    // funcion que centra todas las celdas
    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
    centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        for (int i = 0; i < tblTablaMantenimiento.getColumnCount(); i++) {
           tblTablaMantenimiento.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
    }
    
    private void eraseTable(){
        DefaultTableModel model = (DefaultTableModel)tblTablaMantenimiento.getModel();
        int rowCount = tblTablaMantenimiento.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
                model.removeRow(i);
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

        btnBuscar = new javax.swing.JButton();
        cmbBuscar = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTablaMantenimiento = new javax.swing.JTable();
        txfBuscar = new javax.swing.JTextField();
        btnAgregar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        lblServicioMantenimiento = new javax.swing.JLabel();
        lblFiltro = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nombre", "Codigo" }));

        tblTablaMantenimiento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo del servicio", "Codigo del cliente", "Marca", "Descripcion", "Precio", "Fecha de recibido", "Fecha de entrega", "Observaciones", "Estado"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTablaMantenimiento.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblTablaMantenimiento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaMantenimientoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTablaMantenimiento);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        lblServicioMantenimiento.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        lblServicioMantenimiento.setText("Servicio de Mantenimiento");

        lblFiltro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblFiltro.setText("Filtro");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnModificar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(41, 41, 41))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                        .addComponent(btnBuscar)
                        .addGap(152, 152, 152))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(lblFiltro))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(328, 328, 328)
                        .addComponent(lblServicioMantenimiento)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblServicioMantenimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblFiltro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscar))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarCliente(txfBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        centrarCeldas();
        AgregarClienteMantenimientoVentana m1 = new AgregarClienteMantenimientoVentana(clientes, taller, this);
        m1.setVisible(true);
        System.out.println(taller.size());
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void tblTablaMantenimientoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaMantenimientoMouseClicked
        // TODO add your handling code here:
        btnModificar.setEnabled(true);
        btnEliminar.setEnabled(true);
    }//GEN-LAST:event_tblTablaMantenimientoMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        DefaultTableModel model = (DefaultTableModel)tblTablaMantenimiento.getModel();
        taller.remove(taller.get(tblTablaMantenimiento.getSelectedRow()));
        model.removeRow(tblTablaMantenimiento.getSelectedRow());
        repaint();
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
        System.out.println(taller.size());
        
        if(taller.size() == 0){
            FileManager.deleteFile("mantenimiento.csv");
        }
        
        for (int i = 0; i < taller.size(); i++) {
            try {
                if(i == 0){
                   FileManager.writeFileTruncade("mantenimiento.csv", taller.get(i).toString());
                }
                else
                    FileManager.writeFile("mantenimiento.csv", taller.get(i).toString());
            } catch (IOException ex) {
                Logger.getLogger(MantenimientoVentana.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        btnEliminar.setEnabled(false);
        btnModificar.setEnabled(false);
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(MantenimientoVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MantenimientoVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MantenimientoVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MantenimientoVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MantenimientoVentana().setVisible(true);
            }
        });
    }

    public JTable getTblTablaMantenimiento() {
        return tblTablaMantenimiento;
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JLabel lblServicioMantenimiento;
    private javax.swing.JTable tblTablaMantenimiento;
    private javax.swing.JTextField txfBuscar;
    // End of variables declaration//GEN-END:variables
}
