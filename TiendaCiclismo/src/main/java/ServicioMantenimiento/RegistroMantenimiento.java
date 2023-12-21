/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicioMantenimiento;

import com.toedter.calendar.JDateChooser;
import ejercicio.tiendaciclismo.Cliente;
import ejercicio.tiendaciclismo.FileManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author luisc
 */
public class RegistroMantenimiento {
    private ArrayList<Mantenimiento> taller;
    private final MantenimientoVentana refVentana;
    private ArrayList<Cliente> clientes = new ArrayList<>();

    public RegistroMantenimiento(MantenimientoVentana refVentana, ArrayList<Cliente> clientes) {
        this.taller = new ArrayList<>();
        this.refVentana = refVentana;
        this.clientes = clientes;
    }
    
    
    
    public ArrayList<Mantenimiento> inicializarArreglo(){
        try {
            return leerArchivoArreglo("mantenimiento.csv", taller);
        } 
        catch (IOException ex) {
            System.out.println("No se ha cargado el archivo");
        }
        catch (ParseException ex) {
            System.out.println("No hizo los parse a Date");
        }
        return taller;
    }
    
    public int calcularCodigoServicio(){
        int max = 0;
        for (int i = 0; i < taller.size(); i++) {
            if (taller.get(i).getCodigo_servicio() > max) {
                max = taller.get(i).getCodigo_servicio();
            }
        }
        return max + 1;
    }
    
    public void convertirMantenimiento(int codigoServicio, JTextField txfCodigoCliente, JTextField txfMarca, JTextField txfDescripcion, 
        JTextField ftfPrecio, JDateChooser dcsFechaRecibido, JDateChooser dcsFechaEntrega, 
        JTextField txfObservaciones, JComboBox cmbEstado, JComboBox cmbClientes)
    {
        int codigoCliente = Integer.parseInt(txfCodigoCliente.getText());
        String marca = txfMarca.getText();
        String descripcion = txfDescripcion.getText();
        int precio = Integer.parseInt(ftfPrecio.getText());
        Date fechaRecibido = dcsFechaRecibido.getDate();
        Date fechaEntrega = dcsFechaEntrega.getDate();
        String observaciones = txfObservaciones.getText();
        String estado = cmbEstado.getSelectedItem().toString();
        String nombre = cmbClientes.getSelectedItem().toString();
        Mantenimiento m1 = new Mantenimiento(codigoServicio, codigoCliente, marca, descripcion, precio, fechaRecibido, fechaEntrega, observaciones, estado, nombre);
        agregarCliente(m1);
        try {
            FileManager.writeFile("mantenimiento.csv", m1.toString());
        } catch (IOException ex) {
            System.out.println("NO se ha podido escribir el archivo");
        }
    }
    
    public boolean verificarDatos(JDateChooser dcsFechaRecibido, JDateChooser dcsFechaEntrega, JTextField ftfPrecio)
    {
       if((ftfPrecio.getText().isEmpty()) || 
        (dcsFechaRecibido.getDate() == null) || (dcsFechaEntrega.getDate() == null))
       {
        JOptionPane.showMessageDialog(null, "Error, formato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);   
        return false;
       }
       else{
           return true;
       }
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
    private void buscarClienteCodigo(int codigo_buscar){
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
    
    public void modificarMantenimiento(int codigoServicio, JTextField txfCodigoCliente, JTextField txfMarca, JTextField txfDescripcion, 
        JTextField ftfPrecio, JDateChooser dcsFechaRecibido, 
        JDateChooser dcsFechaEntrega, JTextField txfObservaciones, JComboBox cmbEstado, JComboBox cmbClientes,
        Mantenimiento miembroModificar)
    {
        int codigoCliente = Integer.parseInt(txfCodigoCliente.getText());
        String marca = txfMarca.getText();
        String descripcion = txfDescripcion.getText();
        int precio = Integer.parseInt(ftfPrecio.getText());
        Date fechaRecibido = dcsFechaRecibido.getDate();
        Date fechaEntrega = dcsFechaEntrega.getDate();
        String observaciones = txfObservaciones.getText();
        String estado = cmbEstado.getSelectedItem().toString();
        String nombre = cmbClientes.getSelectedItem().toString();
        
        miembroModificar.setCodigo_cliente(codigoCliente);
        miembroModificar.setCodigo_servicio(codigoServicio);
        miembroModificar.setMarca_bicicleta(marca);
        miembroModificar.setDescripcion(descripcion);
        miembroModificar.setPrecio(precio);
        miembroModificar.setFecha_recibido(fechaRecibido);
        miembroModificar.setFecha_entrega(fechaEntrega);
        miembroModificar.setObservaciones(observaciones);
        miembroModificar.setEstado(estado);
        miembroModificar.setNombre(nombre);
        
        FileManager.deleteFile("mantenimiento.csv");
        
        for (int i = 0; i < taller.size(); i++) {
            try {
                FileManager.writeFile("mantenimiento.csv", taller.get(i).toString());
            } catch (IOException ex) {
                System.out.println("Pos no se pudo gg");
            }
        }
    
    }
    
private ArrayList<Mantenimiento> leerArchivoArreglo (String path, ArrayList<Mantenimiento> arreglo) throws FileNotFoundException, IOException, ParseException
    {
        String patronFecha = "dd/MM/yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(patronFecha);
        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            String line = br.readLine();

            while (line != null) {
               Mantenimiento m1 = new Mantenimiento();
               String[] mantenimiento = line.split(",");
               System.out.println(line);
               m1.setCodigo_servicio(Integer.parseInt(mantenimiento[0]));
               m1.setCodigo_cliente(Integer.parseInt(mantenimiento[1]));
               m1.setMarca_bicicleta(mantenimiento[2]);
               m1.setDescripcion(mantenimiento[3]);
               m1.setPrecio(Integer.parseInt(mantenimiento[4]));
               m1.setFecha_recibido(sdf.parse(mantenimiento[5]));
               m1.setFecha_entrega(sdf.parse(mantenimiento[6]));
               m1.setObservaciones(mantenimiento[7]);
               m1.setEstado(mantenimiento[8]);
               m1.setNombre(mantenimiento[9]);
               line = br.readLine();
               arreglo.add(m1); 
            }
            
        }
        return arreglo;
    }
    
    
    public void agregarCliente(Mantenimiento m1){
        taller.add(m1);
    }


    public ArrayList<Mantenimiento> getListaMantenimiento() {
        return taller;
    }
    
    
}
