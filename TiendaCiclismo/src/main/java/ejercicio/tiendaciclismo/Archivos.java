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
import java.nio.Buffer;
import javax.swing.JOptionPane;

/** Manipula las operaciones de escribir,modificar, y eliminar el contenido de los archivos
 *
 * @author geova
 */
public class Archivos {
    
    
    
    /**
     * Añade los atributos del objeto del cliente al archivo 
     * @param cliente Objeto de cliente
     * @param nombreArchivo Nombre del archivo
     */
    public void escribirEnArchivo(Cliente cliente,String nombreArchivo){
        try{
            
            FileWriter escribir = new FileWriter(nombreArchivo,true);
            escribir.write(String.valueOf(cliente.getCodigo())+","+cliente.getNombre()+","+cliente.getApellidos()+","+cliente.getTelefono()+","+
                    cliente.getCorreo()+","+cliente.getProvincia()+","+cliente.getCanton()+","+cliente.getDistrito()+","+
                    cliente.getFechaNacimiento()+"\r\n");
            escribir.close();
            
        }catch(IOException e){
            System.out.println(e);
        }
    }

    /**
     * Lee todo el contenido de un archivo
     * @param document nombre del documento
     * @return retorna todo el contenido del archivo en una string
     */
    public String leer(String document) {
        StringBuilder data = new StringBuilder();

        try {
            FileReader archivo = new FileReader(document);
            BufferedReader flujo = new BufferedReader(archivo);
            String salida;

            while ((salida = flujo.readLine()) != null) {
                String[] partes = salida.split(","); 
                for (String parte : partes) {
                    
                    if (!parte.equals(partes[partes.length-1])){
                    data.append(parte.trim()).append(",");
                }else{
                        data.append(parte.trim());
                    }
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
     * Remplaza una linea de un archivo
     * @param lineaNueva Linea que se va a agregar
     * @param lineaReemplazar Linea que se va a reemplazar
     * @param doc Nombre del documento
     */
    public void modificarEscritura(String lineaNueva,String lineaReemplazar, String doc){
        try {
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
     * Elimina una linea del archivo
     * @param linea Linea que se va  a eliminar
     * @param doc Nombre del archivo
     */
    public void eliminarEscritura(String linea, String doc){
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

}

 
