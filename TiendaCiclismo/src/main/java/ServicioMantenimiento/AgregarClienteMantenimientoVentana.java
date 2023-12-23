/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ServicioMantenimiento;

import ServicioMantenimiento.MantenimientoVentana;
import com.toedter.calendar.JDateChooser;
import moduloClientes.Cliente;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase que contiene la ventana para agregar un servicio de mantenimiento
 * 
 * @author luisc
 */
public class AgregarClienteMantenimientoVentana extends javax.swing.JFrame {

    /**
     * Creates new form AgregarClienteMantenimientoVentana
     */
    
    private MantenimientoVentana refVentana;
    private ArrayList<Cliente> clientes;
    private RegistroMantenimiento registroMantenimiento;
    private int codigo_servicio;
    private String patronFecha = "dd/MM/yyyy";
    private SimpleDateFormat sdf = new SimpleDateFormat(patronFecha);
    
    /**
     *
     * @param clientes
     * @param refVentana
     * @param registroMantenimiento
     */
    public AgregarClienteMantenimientoVentana(ArrayList<Cliente> clientes, MantenimientoVentana refVentana, RegistroMantenimiento registroMantenimiento) {
        initComponents();
        this.clientes = clientes;
        this.refVentana = refVentana;
        this.registroMantenimiento = registroMantenimiento;
        codigo_servicio = registroMantenimiento.calcularCodigoServicio();
        loadClientes();
        setLocationRelativeTo(null);
    }

    private AgregarClienteMantenimientoVentana() {
        initComponents();
    }
    
    /**
     * Metodo que se encarga de cargar los nombres de los clientes dentro del combobox y 
     * setea el codigo del servicio y cliente en sus respectivos textfields
     */
    private void loadClientes(){
        for (int i = 0; i < clientes.size(); i++) {
            cmbClientes.addItem(clientes.get(i).getNombre());
        }
        txfCodigoCliente.setText("" + clientes.get(0).getCodigo());
        ftfCodigoServicio.setText("" + codigo_servicio);
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
        cmbEstado = new javax.swing.JComboBox<>();
        ftfCodigoServicio = new javax.swing.JFormattedTextField();
        lblCodigoServicio = new javax.swing.JLabel();
        lblNombreCliente = new javax.swing.JLabel();
        cmbClientes = new javax.swing.JComboBox<>();
        txfObservaciones = new javax.swing.JTextField();
        btRegresar = new javax.swing.JButton();
        dcsFechaEntrega = new com.toedter.calendar.JDateChooser();
        dcsFechaRecibido = new com.toedter.calendar.JDateChooser();
        ftfPrecio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        txfCodigoCliente.setEditable(false);
        txfCodigoCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCodigoClienteActionPerformed(evt);
            }
        });

        txfMarca.setText("Marca");

        txfDescripcion.setText("Descripcion");

        btnGuardar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Abierto", "Cerrado" }));
        cmbEstado.setEnabled(false);

        ftfCodigoServicio.setEditable(false);
        ftfCodigoServicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfCodigoServicioActionPerformed(evt);
            }
        });

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

        ftfPrecio.setText("1");
        ftfPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ftfPrecioKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(81, 81, 81)
                                .addComponent(lblDescripcion)))
                        .addContainerGap(663, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblPrecio)
                                .addComponent(txfDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addComponent(txfCodigoCliente, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                .addComponent(lblCodigoCliente)
                                .addComponent(ftfCodigoServicio))
                            .addComponent(lblCodigoServicio)
                            .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblEstado))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(txfObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblObservaciones)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(txfMarca, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblMarca, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNombreCliente, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cmbClientes, 0, 239, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(dcsFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(dcsFechaRecibido, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblFechaEntrega)
                                    .addComponent(lblFechaRecibido))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRegresar)
                        .addGap(301, 301, 301))))
            .addGroup(layout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblFechaEntrega)
                    .addComponent(lblPrecio))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dcsFechaEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblObservaciones)
                    .addComponent(lblEstado))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txfObservaciones, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(67, 67, 67)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfCodigoClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCodigoClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCodigoClienteActionPerformed
/**
 *  Boton tiene la funcion de guardar los datos del servicio
 * @param evt 
 */
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        
        
        if(registroMantenimiento.verificarDatos(dcsFechaRecibido, dcsFechaEntrega, ftfPrecio))
        {
            registroMantenimiento.convertirMantenimiento(codigo_servicio, txfCodigoCliente, txfMarca, txfDescripcion, ftfPrecio, dcsFechaRecibido, dcsFechaEntrega, txfObservaciones, cmbEstado, cmbClientes);
            refVentana.eraseTable();
            refVentana.reloadClientes();
            refVentana.setVisible(true);
            JOptionPane.showMessageDialog(null, "Se ha guardado el cliente", "Confirmacion", JOptionPane.INFORMATION_MESSAGE);   
            dispose();
        }
    }//GEN-LAST:event_btnGuardarActionPerformed
 
    private void cmbClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbClientesActionPerformed
        txfCodigoCliente.setText("" + clientes.get(cmbClientes.getSelectedIndex()).getCodigo());
    }//GEN-LAST:event_cmbClientesActionPerformed
/**
 * Regresa a la ventana de servicio de mantenimiento
 * @param evt 
 */
    private void btRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegresarActionPerformed
        refVentana.setVisible(true);
        dispose();
    }//GEN-LAST:event_btRegresarActionPerformed
/**
 * Verifica que solo se ingresen numeros
 * @param evt 
 */
    private void ftfPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ftfPrecioKeyTyped
        char numero = evt.getKeyChar();
        if (!(Character.isDigit(numero)) || (numero == KeyEvent.VK_BACK_SPACE) || (numero == KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_ftfPrecioKeyTyped

    private void ftfCodigoServicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfCodigoServicioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfCodigoServicioActionPerformed

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

    /**
     *
     * @return
     */
    public int getCodigo_servicio() {
        return codigo_servicio;
    }

    /**
     *
     * @return
     */
    public JComboBox<String> getCmbEstado() {
        return cmbEstado;
    }

    /**
     *
     * @return
     */
    public JDateChooser getDcsFechaEntrega() {
        return dcsFechaEntrega;
    }

    /**
     *
     * @return
     */
    public JDateChooser getDcsFechaRecibido() {
        return dcsFechaRecibido;
    }

    /**
     *
     * @return
     */
    public JFormattedTextField getFtfCodigoServicio() {
        return ftfCodigoServicio;
    }

    /**
     *
     * @return
     */
    public JTextField getFtfPrecio() {
        return ftfPrecio;
    }

    /**
     *
     * @return
     */
    public JTextField getTxfCodigoCliente() {
        return txfCodigoCliente;
    }

    /**
     *
     * @return
     */
    public JTextField getTxfDescripcion() {
        return txfDescripcion;
    }

    /**
     *
     * @return
     */
    public JTextField getTxfMarca() {
        return txfMarca;
    }

    /**
     *
     * @return
     */
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
    private javax.swing.JTextField ftfPrecio;
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

