/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ejercicio.tiendaciclismo;

import ServicioMantenimiento.MantenimientoVentana;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import moduloClientes.ClientesVentana;
import moduloFacturacion.FacturacionVentana;
import moduloProductos.ProductosVentana;

/**
 *
 * @author luisc
 */
public class Menu extends javax.swing.JFrame {

    
    
    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblBienvenido = new javax.swing.JLabel();
        btnBicicletas = new javax.swing.JButton();
        btnCliente = new javax.swing.JButton();
        btnServicioTaller = new javax.swing.JButton();
        btnFacturacion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pnlPanelFondo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBienvenido.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        lblBienvenido.setText("Bienvenido a la tienda de ciclismo");
        getContentPane().add(lblBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, -1, -1));

        btnBicicletas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnBicicletas.setText("Registro de productos");
        btnBicicletas.setFocusCycleRoot(true);
        btnBicicletas.setFocusTraversalPolicyProvider(true);
        btnBicicletas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBicicletasActionPerformed(evt);
            }
        });
        getContentPane().add(btnBicicletas, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 190, 253, 38));

        btnCliente.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCliente.setText("Registro de Clientes");
        btnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 300, 253, 38));

        btnServicioTaller.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnServicioTaller.setText("Servicio de Taller");
        btnServicioTaller.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServicioTallerActionPerformed(evt);
            }
        });
        getContentPane().add(btnServicioTaller, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 410, 253, 38));

        btnFacturacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnFacturacion.setText("Facturación de Productos");
        btnFacturacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFacturacionActionPerformed(evt);
            }
        });
        getContentPane().add(btnFacturacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 530, 253, 38));

        jLabel1.setText("");
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("imagenes/menu.jpg")));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, -40, -1, -1));
        getContentPane().add(pnlPanelFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1210, 630));

        pack();
    }// </editor-fold>//GEN-END:initComponents
/**
 * Retorna la ventana del modulo de productos
 * @param evt 
 */
    private void btnBicicletasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBicicletasActionPerformed

        ProductosVentana v1 = new ProductosVentana();
        v1.setVisible(true);
        dispose();
        
    }//GEN-LAST:event_btnBicicletasActionPerformed
/**
 * Retornara la ventana del modulo de clientes
 * @param evt 
 */
    private void btnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClienteActionPerformed
        try {
            ClientesVentana v2 = new ClientesVentana();
            v2.setVisible(true);
            dispose();
        } catch (IOException ex) {
            
        }
    }//GEN-LAST:event_btnClienteActionPerformed
/**
 * Retornara la ventana del modulo de mantenimiento
 * @param evt 
 */
    private void btnServicioTallerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServicioTallerActionPerformed
        MantenimientoVentana m1 = new MantenimientoVentana();
        m1.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnServicioTallerActionPerformed
/**
 * Retornara la ventana de el modulo de facturacion
 * @param evt 
 */
    private void btnFacturacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFacturacionActionPerformed
        try{
            FacturacionVentana f1= new FacturacionVentana();
            f1.setVisible(true);
            dispose();
            }
        catch(ArrayIndexOutOfBoundsException e){
            JOptionPane.showMessageDialog(null, "Error, no hay clientes agregados", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }//GEN-LAST:event_btnFacturacionActionPerformed

    /**
     * 
     *  
     * @return retorna el boton de bicicletas
     */

    public JButton getBtnBicicletas() {
        return btnBicicletas;
    }

    /**
     *
     * @return retorna el boton de clientes
     */
    public JButton getBtnCliente() {
        return btnCliente;
    }

    /**
     *
     * @return retorna el boton de facturacion
     */
    public JButton getBtnFacturacion() {
        return btnFacturacion;
    }

    /**
     * 
     * @return retorna el boton de mantenimiento 
     *
     */
    public JButton getBtnServicioTaller() {
        return btnServicioTaller;
    }

    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBicicletas;
    private javax.swing.JButton btnCliente;
    private javax.swing.JButton btnFacturacion;
    private javax.swing.JButton btnServicioTaller;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JPanel pnlPanelFondo;
    // End of variables declaration//GEN-END:variables
}
