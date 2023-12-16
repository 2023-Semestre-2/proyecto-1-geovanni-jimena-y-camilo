/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Set;
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
    
    /**
     * Creates new form MantenimientoVentana
     */
    public MantenimientoVentana() {
        initComponents();
        clientes = new ArrayList<>();
        taller = new ArrayList<>();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        m1 = new Mantenimiento(1, 1, "Yamaha", "All good", 100, "23", "293", "Mal estado", "Abierto");
        
        clientes.add(new Cliente(0, "Camilo", "Oro", 8596, "dlf@gmail.com", "Cartago", "Cartago", "Oriental", "12/03/03"));
        clientes.add(new Cliente(1, "Pepe", "Mati", 605, "az@gmail.com", "Cartago", "Cartago", "Occidental", "12/03/207"));
        
        //esto debe ser una clase aparte 
         tblTablaMantenimiento.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Obtiene la fila clicada
                    int filaClicada = tblTablaMantenimiento.rowAtPoint(e.getPoint());
                    // Realiza alguna acción con la fila clicada
                    System.out.println("Clic en la fila: " + filaClicada);
                    
                    
                    cambiarColorFondoFila(filaClicada);
                }
            });
        
        
        
    }
    
    private void buscarCliente(String texto){
        String seleccionado = cmbBuscar.getSelectedItem().toString();
        
        if(seleccionado.equals("Codigo")){
            // expresion regular para buscar si es solo numero
            if(texto.matches("\\d+")){
                buscarClienteCodigo(Integer.parseInt(texto)); 
            }
            else{
                JOptionPane.showMessageDialog(null, "Error, contiene caracteres invalidos", "Error", JOptionPane.ERROR_MESSAGE);   
            }
        }
        else{
            buscarClienteNombre(texto);
        }
    }
    
    private void agregarMantenimiento(Cliente cliente){
    
    
    }
    
    private void eliminarMantenimiento(Mantenimiento clienteMantenimiento){
        clientes.remove(clienteMantenimiento);
    }
    
    
    private void buscarClienteCodigo(int codigo_buscar){
        boolean buscado = false;
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getCodigo() == codigo_buscar){
                System.out.println("Cliente encontrado: ");
                System.out.println(clientes.get(i).toString());
                buscado = true;
            }
        }
        if(buscado == false){
            System.out.println("No se ha encontrado el cliente");
              
        }
          
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
            System.out.println("No se ha encontrado el cliente");    
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
    
    private void cambiarColorFondoFila(int fila) {
        int columnas = tblTablaMantenimiento.getColumnCount();
        for (int columna = 0; columna < 9; columna++) {
            tblTablaMantenimiento.getCellRenderer(fila, columna).getTableCellRendererComponent(tblTablaMantenimiento, null, true, true, fila, columna).setBackground(Color.CYAN);
       
        }
        repaint();
      
        
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
        tblTablaMantenimiento.setEnabled(false);
        jScrollPane1.setViewportView(tblTablaMantenimiento);

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnModificar.setText("Modificar");
        btnModificar.setEnabled(false);

        btnEliminar.setText("Eliminar");
        btnEliminar.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txfBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscar)
                        .addContainerGap(516, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnModificar)
                            .addComponent(btnAgregar)
                            .addComponent(btnEliminar))
                        .addGap(41, 41, 41))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(63, 63, 63)
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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEliminar))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        buscarCliente(txfBuscar.getText());
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tblTablaMantenimiento.getModel();
        model.addRow(new Object[]{m1.getCodigo_servicio(), m1.getCodigo_cliente(), m1.getMarca_bicicleta(), 
            m1.getDescripcion(), m1.getPrecio(), m1.getFecha_recibido(), m1.getFecha_entrega(), m1.getObservaciones(),
            m1.getEstado()});
        taller.add(m1);
        centrarCeldas();
        AgregarClienteMantenimientoVentana m1 = new AgregarClienteMantenimientoVentana();
        m1.setVisible(true);
    }//GEN-LAST:event_btnAgregarActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTablaMantenimiento;
    private javax.swing.JTextField txfBuscar;
    // End of variables declaration//GEN-END:variables
}
