/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

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
    
    Articulo a;
    
    
    
    
    public Archivos() {
        a = new Articulo();
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
    
    
    public void escrituraArticulo(String nombre, String apellido, int edad, String marca, double precio, int cantidad, String doc, boolean sobreescritura) {
        try {
            FileWriter archivo = new FileWriter(doc + ".acc", sobreescritura);
            BufferedWriter flujo = new BufferedWriter(archivo);
            PrintWriter escribir = new PrintWriter(flujo);
            escribir.println(new Articulo(nombre, apellido, edad, marca, precio, cantidad));
            escribir.flush();

        } catch (Exception e) {
            System.err.println("Error al escribir" + e.getMessage());
            
        }
            
    }
        
}

 
