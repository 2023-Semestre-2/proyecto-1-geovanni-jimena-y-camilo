/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.tiendaciclismo;



import ServicioMantenimiento.Mantenimiento;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;



/**
 * Clase estatica para la lectura y escritura de archivos
 *
 * @author sap1
 */
public class FileManager {
 
    
    /**
     * Metodo que se encarga de modificar una linea de un archivo dado
     * 
     * @param lineaNueva es un String con la nueva linea
     * @param lineaReemplazar es el String con la linea a reemplazar
     * @param path es la ruta del archivo a modificar
     */
    
    public static void modificarEscritura(String lineaNueva,String lineaReemplazar, String path){
        try {
            // Leer el archivo original
            StringBuilder contenidoNuevo=new StringBuilder();
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String lineaActual;

            while ((lineaActual = reader.readLine()) != null) {
                if (lineaActual.equals(lineaReemplazar)) {
                    // Reemplazar la línea específica
                    contenidoNuevo.append(lineaNueva).append("\n");
                } else {
                    contenidoNuevo.append(lineaActual).append("\n");
                }
            }
            FileWriter writer = new FileWriter(path);
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
     * Metodo estatico que se encarga de escribir un string en un archivo 
     * 
     * 
     * @param path Es la ruta del archivo que se quiere escribir
     * @param value Es el valor que se quiere escribir dentro del archivo del path
     * @throws IOException Cuando no puede escribir el archivo
     */
    public static void writeFile (String path, String value) throws IOException 
    {


        try(BufferedWriter bw = new BufferedWriter (new FileWriter(path, true))) 
        {
            bw.write(value);
            bw.close();
        }
        
    }
    
    /**
     * Metodo que se encarga de escribir en el archivo como Truncade, es decir, lo sobreescribe
     * @param path
     * @param value
     * @throws IOException 
     */
    public static void writeFileTruncade (String path, String value) throws IOException 
    {
        try(BufferedWriter bw = new BufferedWriter (new FileWriter(path, false))) 
        {
            bw.write(value);
            bw.close();
        }
        
    }
    
    public static void deleteFile(String path){
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
        
}// fin clase
