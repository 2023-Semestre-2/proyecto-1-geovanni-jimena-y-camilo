/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moduloFacturacion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import ejercicio.tiendaciclismo.Archivos;
import moduloProductos.RegistroProductos;
import moduloProductos.Articulo;


/**
 * La clase `RegistroFacturacion` gestiona y mantiene un registro de facturas.
 * Contiene métodos para la manipulación de facturas, como la adición, búsqueda y anulación de facturas.
 * Además, carga y guarda datos relacionados con facturas desde y hacia archivos.
 * Requiere una instancia de `RegistroProductos` y `Archivos` para funcionar correctamente.
 * @author Jimena Mendez
 */
public class RegistroFacturacion {
    // Lista que almacena las facturas
    private ArrayList<Factura> facturas= new ArrayList<>();
    
    // Instancias de clases relacionadas
    private Archivos reg = new Archivos();
    private RegistroProductos registro = new RegistroProductos();

    /**
     * Construye un objeto `RegistroFacturacion` inicializando los productos y artículos del registro.
     */
    public RegistroFacturacion() {
        registro.ProductosArchivo(reg.leer("tiposProductos.csv"));
        registro.ArticulosArchivo(reg.leer("Articulos.csv"));
    }
    
    /**
     * Lee los datos de las facturas desde una cadena y las agrega a la lista de facturas.
     *
     * @param data Cadena que contiene los datos de las facturas.
     */
    public void FacturasArchivo(String data){
        StringReader stringReader = new StringReader(data);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        try {
            if(data.length() > 2){
                String linea;
                while ((linea = bufferedReader.readLine()) != null) {

                    // Dividir cada línea en partes utilizando " " como delimitador.
                    String[] partes = linea.split(","); 
                    int numFactura = Integer.parseInt(partes[0].trim());
                    String nombreCliente= partes[1].trim();

                    String fecha =partes[2].trim();

                    String Estado= partes[3].trim();
                    int codigoArticulo = Integer.parseInt(partes[4].trim());
                    int codigoProducto = Integer.parseInt(partes[5].trim());
                    int cantidad = Integer.parseInt(partes[6].trim());
                    int precio= Integer.parseInt(partes[7].trim());
                    String Tipo= partes[8].trim();


                    // Crear un objeto ObjetoDatos y agregarlo a la lista.
                    Factura objeto = new Factura(numFactura, nombreCliente,fecha,Estado,codigoArticulo,codigoProducto,cantidad,precio,Tipo);
                    facturas.add(objeto);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el StringBuilder: " + e.getMessage());

        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el BufferedReader: " + e.getMessage());
            }
        }
        
    }
    
    /**
     * Agrega una nueva factura al registro con la información proporcionada.
     *
     * @param nombreCliente Nombre del cliente asociado a la factura.
     * @param fecha         Fecha de la factura.
     * @param estado        Estado de la factura.
     * @param cantidad      Cantidad de productos o artículos en la factura.
     * @param articulo      Nombre del artículo (en caso de ser un artículo) o tipo de producto (en caso de ser un producto).
     * @param precio        Precio total de la factura.
     * @param Tipo          Tipo de la factura (puede ser "Articulo" o "Producto").
     */
    public void agregarFactura(String nombreCliente, String fecha, String estado,int cantidad, String articulo,int precio,String Tipo){
        try{
            int numeroFactura = facturas.size() + 1;
            
            if (!facturas.isEmpty()) {
                for(Factura objeto:facturas){
                    int numExiste=objeto.getNumeroFactura();
                    if (numExiste==numeroFactura){
                        numeroFactura++;
                        }
                }
                if(facturas.get(facturas.size()-1).getNumeroFactura()>numeroFactura){//Verificar si el numero de la ultima factura es mayor
                numeroFactura=facturas.get(facturas.size()-1).getNumeroFactura()+1;
                if (numeroFactura==(facturas.get(facturas.size()-1).getNumeroFactura())){
                    numeroFactura++;
                    }
                }
            }

            int codigoArticulo=0;
            int codigoProducto=0;
            
            //Hay que obtener el codigo que tiene ese nombre del articulo
            if ("Articulo".equals(Tipo)){
                System.out.println("Entra");
                for (Articulo objeto:registro.getArticulos()){
                    String nombre=objeto.getNombre();
                    System.out.println(nombre);
                    if(nombre.equals(articulo)){
                        codigoArticulo=objeto.getCodigo();
                        codigoProducto=objeto.getCodigoTipoProducto();
                    }
                }
            }
            
            
        
            // Crear el objeto factura
            Factura factura=new Factura(numeroFactura,nombreCliente, fecha, estado, codigoArticulo,codigoProducto, cantidad,precio,Tipo);
            reg.escrituraFactura(factura, true);
            facturas.add(factura);
            
            
        }catch (Exception e) {
            System.err.println(e.getMessage());
         }
    }
    
    /**
     * Busca y devuelve todas las facturas con el número especificado.
     *
     * @param numero Número de factura a buscar.
     * @return Lista de facturas encontradas con el número especificado.
     */
    public ArrayList<Factura> buscarNumero(int numero){
        ArrayList<Factura> facturasBuscadas=new ArrayList<>();
        //Verificar todos los numeros de factura
        for (Factura factura:facturas){
            int numeroExistente=factura.getNumeroFactura();
            if (numeroExistente==numero){
                facturasBuscadas.add(factura);
            }
        }
        return facturasBuscadas;
    }
    
    /**
     * Busca y devuelve todas las facturas con la fecha especificada.
     *
     * @param fecha Fecha de las facturas a buscar.
     * @return Lista de facturas encontradas con la fecha especificada.
     */
    public ArrayList<Factura> buscarFecha(String fecha){
        ArrayList<Factura> facturasBuscadas=new ArrayList<>();
        //Verificar todos los numeros de factura
        for (Factura factura:facturas){
            String fechaExistente=factura.getFecha();
            if (fechaExistente.equals(fecha)){
                facturasBuscadas.add(factura);
            }
        }
        return facturasBuscadas;
    }
      
    /**
     * Busca y devuelve todas las facturas asociadas al cliente con el nombre especificado.
     *
     * @param nombre Nombre del cliente asociado a las facturas.
     * @return Lista de facturas encontradas asociadas al cliente con el nombre especificado.
     */
    public ArrayList<Factura> buscarCliente(String nombre){
        ArrayList<Factura> facturasBuscadas=new ArrayList<>();
        //Verificar todos los numeros de factura
        for (Factura factura:facturas){
            String posibleNombre=factura.getNombre();
            if (posibleNombre.contains(nombre) || nombre.contains(posibleNombre)){
                facturasBuscadas.add(factura);
            }
        }
        return facturasBuscadas;
    }
    
    /**
     * Anula una factura especificada por su número, cambiando su estado a "Anulado".
     *
     * @param numeroFactura Número de la factura a anular.
     */
    public void anularFactura(int numeroFactura){
        try{
            //Revisar cual factura tiene ese numero
            String lineaPasada = null;
            String lineaActual = null;
            for (Factura factura:facturas){
                int numeroExistente=factura.getNumeroFactura();
                if (numeroExistente==numeroFactura){
                    lineaPasada=factura.toString();
                    factura.setEstado("Anulado");
                    lineaActual=factura.toString();
                    break;
                }
            }
            //Eliminar la linea del archivo
            
            reg.modificarEscritura(lineaActual, lineaPasada, "Facturas.csv");
            
        }catch (Exception e) {
                System.err.println(e.getMessage());
        }
    }
    
    /**
     * Obtiene la lista de facturas.
     *
     * @return Lista de facturas almacenadas.
     */
    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    /**
     * Establece la lista de facturas.
     *
     * @param facturas Nueva lista de facturas a establecer.
     */
    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }  
}


