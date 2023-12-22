/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicioMantenimiento;

import com.toedter.calendar.JDateChooser;
import ejercicio.tiendaciclismo.FileManager;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Clase que se encarga de controlar el registro de mantenimiento
 *
 * @author luisc
 */
public class RegistroMantenimiento {
    
    // Atributos de la clase, el arreglo del servicio de mantenimiento junto con la referencia a su ventana
    private ArrayList<Mantenimiento> taller = new ArrayList<>();
    private final MantenimientoVentana refVentana;
    private final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public RegistroMantenimiento(MantenimientoVentana refVentana) {
        this.taller = inicializarArreglo();
        this.refVentana = refVentana;
    }
    /**
     * Funcion que inicializa el arreglo, lo lee del archivo primero
     * No recibe ningun parametro
     * @return El arreglo de tipo mantenimiento cargado 
     * @see #leerArchivoArreglo(java.lang.String) que sirve para leer el archivo y colocar sus atributos en los objetos
     */
    
    private ArrayList<Mantenimiento> inicializarArreglo(){
        try {
            return leerArchivoArreglo("mantenimiento.csv");
        } 
        catch (IOException ex) {
            System.out.println("No se ha cargado el archivo");
        }
        catch (ParseException ex) {
            System.out.println("No hizo los parse a Date");
        }
        // si retorna el taller es que no habia nada guardado y por ende solo devuelve un arrayList inicializado
        return taller;
    }
    
    /**
     * Metodo que se encarga de calcular el codigo de servicio de acuerdo
     * Al codigo maximo que contiene un elemento del arrayList
     *
     * @return retorna el codigo con el elemento mayor + 1 ya que queremos que el codigo de servicio sea uno mayor al anterior
     */
    
    public int calcularCodigoServicio(){
        int max = 1;
        for (int i = 0; i < taller.size(); i++) {
            // verifica el elemento con el codigo mayor
            if (taller.get(i).getCodigo_servicio() > max) {
                max = taller.get(i).getCodigo_servicio();
            }
        }
        return max + 1; // retorna uno mayor al codigo maximo del archivo
    }
    
    
    /**
     * Metodo que sirve para convertir los parametros seleccionados a atributos para modificar el 
     * objeto de mantenimiento
     * 
     * @param codigoServicio
     * @param txfCodigoCliente
     * @param txfMarca
     * @param txfDescripcion
     * @param ftfPrecio
     * @param dcsFechaRecibido
     * @param dcsFechaEntrega
     * @param txfObservaciones
     * @param cmbEstado
     * @param cmbClientes 
     */
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
    
    /**
     * Metodo que permite verifcar los datos a la hora de agregar o modificar un elemento 
     * Los unicos datos que no se permiten dejar vacios o sin formato son el precio y las fechas
     * @param dcsFechaRecibido es la fecha de recibido
     * @param dcsFechaEntrega
     * @param ftfPrecio
     * @return 
     */
    public boolean verificarDatos(JDateChooser dcsFechaRecibido, JDateChooser dcsFechaEntrega, JTextField ftfPrecio)
    {
       if((ftfPrecio.getText().isEmpty()) || 
        (dcsFechaRecibido.getDate() == null) || (dcsFechaEntrega.getDate() == null))
       {
        JOptionPane.showMessageDialog(null, "Error, formato incorrecto", "Error", JOptionPane.ERROR_MESSAGE);   
        return false;
       }
       else if(dcsFechaRecibido.getDate().after(dcsFechaEntrega.getDate())){
           JOptionPane.showMessageDialog(null, "Error, la fecha de recibido no puede ser mayor a la fecha de entrega", "Error", JOptionPane.ERROR_MESSAGE);   
        return false;
       }
       else{
           return true;
       }
    }
    
    /**
     * Metodo que se llama cuando el cliente le da click al boton de buscar
     * Verifica si selecciono el cuadro de Nombre o Codigo
     * 
     * @param texto es el texto que se escribe en el textfield de buscar
     */
    public void buscarCliente(String texto){
        String seleccionado = refVentana.getCmbBuscar().getSelectedItem().toString();
        // si el texto 
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
    
    
    /**
     * Metodo que se encarga de buscar el cliente por codigo de servicio
     * 
     * @param codigo_buscar Es el codigo escrito en la barra de buscar
     */
    private void buscarClienteCodigo(int codigo_buscar){
        boolean buscado = false;
        int contador = 0;
        for (int i = 0; i < taller.size(); i++) {
            if(taller.get(i).getCodigo_servicio()== codigo_buscar){
                if(contador == 0){
                   refVentana.eraseTable();
                }
                agregarClienteTabla(taller.get(i));
                buscado = true;
                contador++;
               // break;
            }
        }
        if(buscado == false){
            JOptionPane.showMessageDialog(null, "No se ha encontrado al cliente", "Error", JOptionPane.ERROR_MESSAGE);   
        } 
    }
    
    /**
     * Metodo que busca el cliente dentro del arrayList por su nombre de cliente
     * @param nombre_buscar es el nombre escrito en la barra de buscar
     */
    private void buscarClienteNombre(String nombre_buscar){
        boolean buscado = false;
        int contador = 0;
        for (int i = 0; i < taller.size(); i++) {
            if(taller.get(i).getNombre().equals(nombre_buscar)){
                if(contador == 0){
                   refVentana.eraseTable();
                }
                agregarClienteTabla(taller.get(i));
                contador++;
                buscado = true;
            }
        }
        if(buscado == false){
            JOptionPane.showMessageDialog(null, "No se ha encontrado al cliente", "Error", JOptionPane.ERROR_MESSAGE);   
        }
    }
    
    /**
     * Metodo que se encarga de modificar los atributos de dicho objeto mediante las selecciones
     * En el textfield de dichos atributos
     * Cuando lo hace elimina el archivo asociado para reescribirlo
     * 
     * 
     * @param codigoServicio
     * @param txfCodigoCliente
     * @param txfMarca
     * @param txfDescripcion
     * @param ftfPrecio
     * @param dcsFechaRecibido
     * @param dcsFechaEntrega
     * @param txfObservaciones
     * @param cmbEstado
     * @param cmbClientes
     * @param miembroModificar 
     */
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
   /**
    * Metodo que sirve para agregar un cliente especifico en la tabla de mantenimiento
    * 
    * @param m1 es el objeto de tipo mantenimiento que se agrega en la tabla
    */ 
    private void agregarClienteTabla(Mantenimiento m1){
        // agrega el cliente a la tabla
        refVentana.getModel().addRow(new Object[]{m1.getCodigo_servicio(), m1.getCodigo_cliente(), 
            m1.getMarca_bicicleta(), m1.getDescripcion(), m1.getPrecio(), 
            sdf.format(m1.getFecha_recibido()), sdf.format(m1.getFecha_entrega()), m1.getObservaciones(),
            m1.getEstado()});
    }
    
    /**
     * Metodo que cierra el estado de un objeto de mantenimiento
     * 
     * @param m1 es el objeto de mantenimiento
     * @param posicion  es la posicion de dicho objeto en el arrayList
     */
    public void cerrarEstado(Mantenimiento m1, int posicion){
        taller.remove(taller.get(posicion));
        m1.setEstado("Cerrado");
        refVentana.eraseTable();
        refVentana.reloadClientes();
        verificarArregloVacio();
        
    }
    
    /**
     * Funcion que verifica si el arreglo se encuentra vacio
     * Si esta vacio elimina el archivo asociado de mantenimiento
     * Sino esta vacio lo reescribe
     * 
     */
    private void verificarArregloVacio(){
     if(taller.isEmpty()){
            FileManager.deleteFile("mantenimiento.csv");
        }
    else{
        
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
        }
    }
    
    /**
     * Funcion que lee un archivo y divide sus lineas y coloca sus strings como atributos para crear
     * un objeto de tipo mantenimiento
     * 
     * @param path  Es la ruta de dicho archivo 
     * @return ArrayList<Mantenimiento>   retorna el arrayList de mantenimiento ya cargagado
     * @throws FileNotFoundException      Cuando el archivo no existe
     * @throws IOException                Cuando el archivo no se puede leer
     * @throws ParseException             Cuando no se pueden convertir los Strings a los objetos especificos
     */
    
    
    private ArrayList<Mantenimiento> leerArchivoArreglo (String path) throws FileNotFoundException, IOException, ParseException
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
               taller.add(m1); 
            }
            
        }
        return taller;
    }
    
    
    /**
     * Metodo que se encarga de agregar un objeto al arrayList
     * @param m1 es el objeto a agregar 
     */
    public void agregarCliente(Mantenimiento m1){
        taller.add(m1);
    }


    public ArrayList<Mantenimiento> getListaMantenimiento() {
        return taller;
    }
}
