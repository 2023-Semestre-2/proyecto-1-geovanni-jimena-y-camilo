/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import moduloClientes.Cliente;
import moduloFacturacion.Factura;
import moduloProductos.Articulo;
import moduloProductos.TipoProducto;

/**
 *
 * @author Jimena Mendez
 */

public class Archivos {
    
    /**
     * Constructor predeterminado de la clase Archivos.
     */
    public Archivos() {
        
    }
    /**
     * Escribe la información de un artículo en el archivo "Articulos.acc".
     *
     * @param codigo            El código del artículo.
     * @param codigoProducto   El código del producto asociado al artículo.
     * @param nombre            El nombre del artículo.
     * @param tipo              El tipo del artículo.
     * @param tamano            El tamaño del artículo.
     * @param marca             La marca del artículo.
     * @param precio            El precio del artículo.
     * @param cantidad          La cantidad disponible del artículo.
     * @param sobreescritura    Indica si se debe sobrescribir el archivo existente.
     */

    public void escrituraArticulo(int codigo, int codigoProducto,String nombre, String tipo, int tamano, String marca, int precio, int cantidad, boolean sobreescritura) {
        try {
            FileWriter archivo = new FileWriter("Articulos.csv", sobreescritura);
            BufferedWriter flujo = new BufferedWriter(archivo);
            PrintWriter escribir = new PrintWriter(flujo);
            escribir.println(new Articulo(codigo,codigoProducto,nombre, tipo, tamano, marca, precio, cantidad));
            escribir.flush();

        } catch (IOException e) {
            System.err.println("Error al escribir" + e.getMessage());
            
        }      
    }
    
    /**
     * Escribe la información de un tipo de producto en el archivo "tiposProductos.acc".
     *
     * @param producto         El objeto TipoProducto a escribir en el archivo.
     * @param sobreescritura   Indica si se debe sobrescribir el archivo existente.
     */
    public void escrituraProducto(TipoProducto producto, boolean sobreescritura) {
        try {
            FileWriter archivo = new FileWriter("tiposProductos.csv", sobreescritura);
            BufferedWriter flujo = new BufferedWriter(archivo);
            PrintWriter escribir = new PrintWriter(flujo);
            escribir.println(producto);
            escribir.flush();

        } catch (IOException e) {
            System.err.println("Error al escribir" + e.getMessage());
            
        }      
    }
    
    /**
     * Escribe en un archivo una string
     * @param path Direccion del archivo
     * @param value String que se va a escribir
     * @throws IOException
     */
    public static void escribirArchivo (String path, String value) throws IOException 
    {


        try(BufferedWriter bw = new BufferedWriter (new FileWriter(path, true))) 
        {
            bw.write(value);
            bw.close();
        }
        
    }
    
    /**
     * Escribe la información de una factura en el archivo "Facturas.acc".
     *
     * @param factura           El objeto Factura a escribir en el archivo.
     * @param sobreescritura    Indica si se debe sobrescribir el archivo existente.
     */
    public void escrituraFactura(Factura factura,boolean sobreescritura){
        try {
            FileWriter archivo = new FileWriter("Facturas.csv", sobreescritura);
            BufferedWriter flujo = new BufferedWriter(archivo);
            PrintWriter escribir = new PrintWriter(flujo);
            escribir.println(factura);
            escribir.flush();

        } catch (IOException e) {
            System.err.println("Error al escribir" + e.getMessage());
            
        } 
    }
    
  
    
    
    /**
     * Lee el contenido de un archivo y lo devuelve como una cadena.
     *
     * @param document   El nombre del archivo a leer.
     * @return           Una cadena que representa el contenido del archivo.
     */
    public static String leer(String document) {
        System.out.println(document);
        StringBuilder data = new StringBuilder();

        try {
            FileReader archivo = new FileReader(document);
            BufferedReader flujo = new BufferedReader(archivo);
            String salida;

            while ((salida = flujo.readLine()) != null) {
                String[] partes = salida.split(","); 
                for (String parte : partes) {
                    data.append(parte.trim()).append(",");
                }
                data.append("\n");
            }
            flujo.close(); 
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }

        return data.toString();
    }
    
    
    
    /**
     * Elimina una línea específica del archivo y actualiza el contenido.
     *
     * @param linea   La línea a eliminar.
     * @param doc     El nombre del archivo.
     */
    public void eliminarEscritura(String linea, String doc){
        System.out.println(doc);
        String contenido=leer(doc);
        StringBuilder contenidoNuevo=new StringBuilder();
        StringReader stringReader = new StringReader(contenido);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        try {
            String salida;
            while ((salida = bufferedReader.readLine()) != null) {
                if (salida != null && !salida.equals(linea)){
                    contenidoNuevo.append(salida).append("\n");
                }
            }
                
            FileWriter writer = new FileWriter(doc);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(contenidoNuevo.toString());

            // Cierra los recursos
            bufferWriter.close();
            writer.close();

        }catch(IOException e){
            System.err.println("Error al leer: " + e.getMessage());
            
        }
    }
    
    /**
     *
     * @param cliente
     * @param nombreArchivo
     */
    public void escribirEnArchivo(Cliente cliente,String nombreArchivo){
        try{
            
            FileWriter escribir = new FileWriter(nombreArchivo,true);
            escribir.write(String.valueOf(cliente.getCodigo())+","+cliente.getNombre()+","+cliente.getApellidos()+","+cliente.getTelefono()+","+
                    cliente.getCorreo()+","+cliente.getProvincia()+","+cliente.getCanton()+","+cliente.getDistrito()+","+
                    cliente.getFechaNacimiento()+","+String.valueOf(cliente.isFacturado())+ ","+"\r\n");
            escribir.close();
            
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    
    
    /**
     * Modifica una línea específica del archivo y actualiza el contenido.
     *
     * @param lineaNueva         La nueva línea a agregar.
     * @param lineaReemplazar    La línea a reemplazar.
     * @param doc                El nombre del archivo.
     */
    public void modificarEscritura(String lineaNueva,String lineaReemplazar, String doc){
        try {
            System.out.println(doc);
            // Leer el archivo original
            StringBuilder contenidoNuevo=new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(doc));
            String lineaActual;

            while ((lineaActual = reader.readLine()) != null) {
                if (lineaActual.equals(lineaReemplazar)) {
                    // Reemplazar la línea específica
                    contenidoNuevo.append(lineaNueva).append("\n");
                } else {
                    contenidoNuevo.append(lineaActual).append("\n");
                }
            }
            FileWriter writer = new FileWriter(doc);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(contenidoNuevo.toString());

            // Cierra los recursos
            bufferWriter.close();
            writer.close();
        }catch(IOException e){
            System.err.println("Error al leer: " + e.getMessage());

        }
    }
    
    /**
     *Elimina el archivo
     * @param path nombre del archivo
     */
    public static void eliminarArchivo(String path){
        File archivo = new File(path);
        
        if (archivo.exists()) {
            // Intentar eliminar el archivo
            if (archivo.delete()) {
                System.out.println("El archivo ha sido eliminado correctamente.");
            } else {
                System.out.println("No se pudo eliminar el archivo.");
            }
        } else {
            System.out.println("El archivo no existe en la ruta especificada.");
        }
    }
        

}
    
    
        


 
