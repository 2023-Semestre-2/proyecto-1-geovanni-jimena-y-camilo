/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio.tiendaciclismo;



import ServicioMantenimiento.Mantenimiento;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author sap1
 */
public class FileManager {
 
    private static ArrayList<Mantenimiento> arreglo1 = new ArrayList<>();
    
    
    
    // read txt file, para ller el query
    public static String readFile (String path) throws FileNotFoundException, IOException
    {
       
        String everything;

        try(BufferedReader br = new BufferedReader(new FileReader(path))) 
        {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
        everything = sb.toString();
        }   

        return everything;
    }
    
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
        System.out.println(arreglo1.size());
        return arreglo1;
    }
    
    
        // read txt file, para ller el query
    public static void writeFile (String path, String value) throws IOException 
    {


        try(BufferedWriter bw = new BufferedWriter (new FileWriter(path, true))) 
        {
            bw.write(value);
            bw.close();
        }
        
    }
    
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
    
    
    // escribe un objeto
    public static void writeObject (Object obj, String filePath)
    {
        try{
            //use buffering
            OutputStream file = new FileOutputStream(filePath);
            OutputStream buffer = new BufferedOutputStream(file);
            ObjectOutput output = new ObjectOutputStream(buffer);
            try{
                // escribe el objeto
              output.writeObject(obj);
            }
            finally{
              output.close();
            }
          }  
          catch(IOException ex){
              
          }
        
    }
    
      // escribe un objeto
    public static Object readObject(String filePath)
    {
        try{
            //use buffering
            InputStream file = new FileInputStream(filePath);
            InputStream buffer = new BufferedInputStream(file);
            ObjectInput input = new ObjectInputStream (buffer);
            try{
              //deserialize the List
              return input.readObject();
            }
            finally{
              input.close();
            }
          }
          catch(ClassNotFoundException ex){
           
          }
          catch(IOException ex){
            
          }
        return null;
    }  
    
    
    
}// fin clase
