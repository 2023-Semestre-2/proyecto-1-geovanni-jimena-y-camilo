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
import java.nio.Buffer;
import javax.swing.JOptionPane;


public class Archivos {
    
    File archivo;
    
   
  
    
    public Archivos() {
       
    }
    
    public void crearArchivo(String nombreArchivo){
        
        try{
            archivo = new File(nombreArchivo);
            if (archivo.createNewFile()){
                JOptionPane.showMessageDialog(null, "Archivo creado");
            }
            
        }catch(IOException e){
            System.out.println(e);
        }
    }
    
    public void actualizarCodigoCliente(String nombreArchivo,int codigoActualizado){
      try{           
            FileWriter escribir = new FileWriter(nombreArchivo,false);
            escribir.write(String.valueOf(codigoActualizado));
            escribir.close();
            
        }catch(IOException e){
            System.out.println(e);
        }
    }  
    
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
    public String leer(String document) {
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
            FileWriter writer = new FileWriter(doc+".acc");
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

 
