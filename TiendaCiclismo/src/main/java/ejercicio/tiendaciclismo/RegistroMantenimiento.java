/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author luisc
 */
public class RegistroMantenimiento {
    private ArrayList<Mantenimiento> taller = new ArrayList<>();
    private final MantenimientoVentana refVentana;
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private final DefaultTableModel model;
    private int codigo_servicio;

    public RegistroMantenimiento(ArrayList<Mantenimiento> taller, MantenimientoVentana refVentana, ArrayList<Cliente> clientes) {
        this.taller = taller;
        this.refVentana = refVentana;
        this.clientes = clientes;
        model = (DefaultTableModel)refVentana.getTblTablaMantenimiento().getModel();
    }
    
    
    public void buscarCliente(String texto){
        String seleccionado = refVentana.getCmbBuscar().getSelectedItem().toString();
        System.out.println("text");
        System.out.println(texto);
        if(texto.isBlank()){
                refVentana.eraseTable();
                refVentana.reloadClientes();
        }
        else if(seleccionado.equals("Codigo")){
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
    public void buscarClienteCodigo(int codigo_buscar){
        boolean buscado = false;
        int contador = 0;
        for (int i = 0; i < taller.size(); i++) {
            if(taller.get(i).getCodigo_cliente() == codigo_buscar){
                if(contador == 0){
                   refVentana.eraseTable();
                }
                System.out.println("Cliente encontrado: ");
                agregarCliente(taller.get(i));
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
    
    public void agregarCliente(Mantenimiento m1){
        model.addRow(new Object[]{m1.getCodigo_servicio(), m1.getCodigo_cliente(), m1.getMarca_bicicleta(), 
            m1.getDescripcion(), m1.getPrecio(), m1.getFecha_recibido(), m1.getFecha_entrega(), m1.getObservaciones(),
            m1.getEstado()});
        refVentana.repaint();
    }
    
    public void agregarClientes(){
        for (int i = 0; i < taller.size(); i++) {
            model.addRow(new Object[]{taller.get(i).getCodigo_servicio(), taller.get(i).getCodigo_cliente(), 
            taller.get(i).getMarca_bicicleta(), taller.get(i).getDescripcion(), taller.get(i).getPrecio(), 
            taller.get(i).getFecha_recibido(), taller.get(i).getFecha_entrega(), taller.get(i).getObservaciones(),
            taller.get(i).getEstado()});
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
            JOptionPane.showMessageDialog(null, "No se ha encontrado al cliente", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }
    
}
