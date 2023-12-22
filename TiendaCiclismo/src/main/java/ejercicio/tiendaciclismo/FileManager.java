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
 
    private static ArrayList<Mantenimiento> arreglo1 = new ArrayList<>();
    
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
     * Metodo que se encarga de leer el archivo y lo
     * 
     * @param path Es la ruta del archivo a modificar
     * @return El arreglo de tipo Mantenimiento ya cargado
     * @throws FileNotFoundException Cuando no encuentra el archivo
     * @throws IOException Cuando no puede leer el archivo
     * @throws ParseException Cuando no puede convertir los strings a los respectivos atributos
     */
    public static ArrayList<Mantenimiento> readFileToArray (String path) throws FileNotFoundException, IOException, ParseException
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
               arreglo1.add(m1); 
            }
            
        }
        return arreglo1;
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
