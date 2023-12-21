/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ServicioMantenimiento;

import ServicioMantenimiento.MantenimientoVentana;
import ServicioMantenimiento.Mantenimiento;
import com.toedter.calendar.JDateChooser;
import ejercicio.tiendaciclismo.Cliente;
import ejercicio.tiendaciclismo.FileManager;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.chrono.Era;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisc
 */
public class AgregarClienteMantenimientoVentana extends javax.swing.JFrame {

    /**
     * Creates new form AgregarClienteMantenimientoVentana
     */
    
    private ArrayList<Mantenimiento> clienteMantenimiento;
    private MantenimientoVentana refVentana;
    private ArrayList<Cliente> clientes;
    private RegistroMantenimiento registroMantenimiento;
    private int codigo_servicio;
    private String patronFecha = "dd/MM/yyyy";
    private SimpleDateFormat sdf = new SimpleDateFormat(patronFecha);
    
    public AgregarClienteMantenimientoVentana(ArrayList<Cliente> clientes, ArrayList<Mantenimiento> clientesMantenimiento, MantenimientoVentana refVentana, RegistroMantenimiento registroMantenimiento) {
        initComponents();
        this.clientes = clientes;
        this.clienteMantenimiento = clientesMantenimiento;
        this.refVentana = refVentana;
        this.registroMantenimiento = registroMantenimiento;
        loadClientes();
        setLocationRelativeTo(null);
    }

    private AgregarClienteMantenimientoVentana() {
        initComponents();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCalendar1 = new com.toedter.calendar.JCalendar();
        jDayChooser1 = new com.toedter.calendar.JDayChooser();
        txfCodigoCliente = new javax.swing.JTextField();
        txfMarca = new javax.swing.JTextField();
        txfDescripcion = new javax.swing.JTextField();
        btnGuardar = new javax.swing.JButton();
        lblCodigoCliente = new javax.swing.JLabel();
        lblMarca = new javax.swing.JLabel();
        lblEstado = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        lblPrecio = new javax.swing.JLabel();
        lblObservaciones = new javax.swing.JLabel();
        lblFechaRecibido = new javax.swing.JLabel();
        lblFechaEntrega = new javax.swing.JLabel();
        ftfPrecio = new javax.swing.JFormattedTextField();
        cmbEstado = new javax.swing.JComboBox<>();
        ftfCodigoServicio = new javax.swing.JFormattedTextField();
        lblCodigoServicio = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        cmbClientes = new javax.swing.JComboBox<>();
        txfObservaciones = new javax.swing.JTextField();
        btRegresar = new javax.swing.JButton();
        dcsFechaEntrega = new com.toedter.calendar.JDateChooser();
        dcsFechaRecibido = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txfCodigoCliente.setEditable(false);
        txfCodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCodigoClienteActionPerformed(evt);
            }
        });

        txfMarca.setText("Marca");

        txfDescripcion.setText("Descripcion");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        lblCodigoCliente.setText("CODIGO DEL CLIENTE");

        lblMarca.setText("MARCA");

        lblEstado.setText("ESTADO");

        lblDescripcion.setText("DESCRIPCION");

        lblPrecio.setText("PRECIO");

        lblObservaciones.setText("OBSERVACIONES");

        lblFechaRecibido.setText("FECHA DE RECIBIDO");

        lblFechaEntrega.setText("FECHA DE ENTREGA");

        ftfPrecio.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        ftfPrecio.setText("1");
        ftfPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfPrecioActionPerformed(evt);
            }
        });
        ftfPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ftfPrecioKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftfPrecioKeyTyped(evt);
            }
        });

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abierto", "Cerrado" }));

        ftfCodigoServicio.setEditable(false);

        lblCodigoServicio.setText("CODIGO DEL SERVICIO");

        lblNombreCliente.setText("NOMBRE DEL CLIENTE");

        cmbClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbClientesActionPerformed(evt);
            }
        });

        txfObservaciones.setText("Observaciones");

        btRegresar.setText("REGRESAR");
        btRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegresarActionPerformed(evt);
            }
        });

        dcsFechaEntrega.setDateFormatString("dd/MM/yyyy");

        dcsFechaRecibido.setDateFormatString("dd/MM/yyyy");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(lblDescripcion)
                        .addGap(119, 119, 119)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblFechaRecibido)
                            .addComponent(dcsFechaRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(dcsFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(398, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(ftfPrecio, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addComponent(lblPrecio)
                        .addComponent(txfDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addComponent(txfCodigoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                        .addComponent(lblCodigoCliente)
                        .addComponent(ftfCodigoServicio))
                    .addComponent(lblCodigoServicio)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEstado))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txfMarca, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblMarca, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblNombreCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbClientes, 0, 239, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txfObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblObservaciones))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRegresar)
                        .addGap(301, 301, 301))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblFechaEntrega)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoServicio)
                    .addComponent(lblNombreCliente)
                    .addComponent(btRegresar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftfCodigoServicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMarca)
                    .addComponent(lblCodigoCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFechaRecibido)
                    .addComponent(lblDescripcion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txfDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcsFechaRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(lblFechaEntrega))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ftfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dcsFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblObservaciones)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCodigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCodigoClienteActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if(registroMantenimiento.verificarDatos(codigo_servicio, txfCodigoCliente, txfMarca, txfDescripcion, 
                ftfPrecio, dcsFechaRecibido, dcsFechaEntrega, txfObservaciones, cmbEstado, cmbClientes)){
        refVentana.eraseTable();
        refVentana.reloadClientes();
        refVentana.setVisible(true);
        dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    public void loadClientes(){
        for (int i = 0; i < clientes.size(); i++) {
            cmbClientes.addItem(clientes.get(i).getNombre());
        }
        txfCodigoCliente.setText("" + clientes.get(0).getCodigo());
        ftfCodigoServicio.setText("" + codigo_servicio);
    }
    
    private void ftfPrecioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfPrecioKeyPressed
        char numero = evt.getKeyChar();
        if (!(Character.isDigit(numero)) || (numero == KeyEvent.VK_BACK_SPACE) || (numero == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_ftfPrecioKeyPressed

    private void ftfPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfPrecioActionPerformed

    private void ftfPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfPrecioKeyTyped
        char numero = evt.getKeyChar();
        if (!(Character.isDigit(numero)) || (numero == KeyEvent.VK_BACK_SPACE) || (numero == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_ftfPrecioKeyTyped
 
    private void cmbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClientesActionPerformed
        String cliente = cmbClientes.getSelectedItem().toString();
        
        txfCodigoCliente.setText("" + clientes.get(cmbClientes.getSelectedIndex()).getCodigo());

                /*
        for (int i = 0; i < clientes.size(); i++) {
            if(clientes.get(i).getNombre().equals(cliente)){
                txfCodigoCliente.setText("" + clientes.get(i).getCodigo());
                break;
            }
        }
        */
    }//GEN-LAST:event_cmbClientesActionPerformed

    private void btRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegresarActionPerformed
        refVentana.setVisible(true);
        dispose();
    }//GEN-LAST:event_btRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(AgregarClienteMantenimientoVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarClienteMantenimientoVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarClienteMantenimientoVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarClienteMantenimientoVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarClienteMantenimientoVentana().setVisible(true);
            }
        });
    }

    public int getCodigo_servicio() {
        return codigo_servicio;
    }

    public JComboBox<String> getCmbEstado() {
        return cmbEstado;
    }

    public JDateChooser getDcsFechaEntrega() {
        return dcsFechaEntrega;
    }

    public JDateChooser getDcsFechaRecibido() {
        return dcsFechaRecibido;
    }

    public JFormattedTextField getFtfCodigoServicio() {
        return ftfCodigoServicio;
    }

    public JFormattedTextField getFtfPrecio() {
        return ftfPrecio;
    }

    public JTextField getTxfCodigoCliente() {
        return txfCodigoCliente;
    }

    public JTextField getTxfDescripcion() {
        return txfDescripcion;
    }

    public JTextField getTxfMarca() {
        return txfMarca;
    }

    public JTextField getTxfObservaciones() {
        return txfObservaciones;
    }
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btRegresar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> cmbClientes;
    private javax.swing.JComboBox<String> cmbEstado;
    private com.toedter.calendar.JDateChooser dcsFechaEntrega;
    private com.toedter.calendar.JDateChooser dcsFechaRecibido;
    private javax.swing.JFormattedTextField ftfCodigoServicio;
    private javax.swing.JFormattedTextField ftfPrecio;
    private com.toedter.calendar.JCalendar jCalendar1;
    private com.toedter.calendar.JDayChooser jDayChooser1;
    private javax.swing.JLabel lblCodigoCliente;
    private javax.swing.JLabel lblCodigoServicio;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblEstado;
    private javax.swing.JLabel lblFechaEntrega;
    private javax.swing.JLabel lblFechaRecibido;
    private javax.swing.JLabel lblMarca;
    private javax.swing.JLabel lblNombreCliente;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JTextField txfCodigoCliente;
    private javax.swing.JTextField txfDescripcion;
    private javax.swing.JTextField txfMarca;
    private javax.swing.JTextField txfObservaciones;
    // End of variables declaration//GEN-END:variables
}

