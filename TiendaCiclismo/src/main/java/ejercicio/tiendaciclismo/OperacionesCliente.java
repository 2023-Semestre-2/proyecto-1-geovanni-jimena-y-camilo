
package ejercicio.tiendaciclismo;

import java.util.ArrayList;
import java.util.List;
import ejercicio.tiendaciclismo.AgregarClienteVentana;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import ejercicio.tiendaciclismo.Cliente;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.StringReader;

public class OperacionesCliente  {
    
    public  ArrayList<Cliente> listaClientes = new ArrayList<>();

    public OperacionesCliente() {
        
    }
     public void ClientesArchivo(String data){
         System.out.println(data);
        StringReader stringReader = new StringReader(data);
        BufferedReader bufferedReader = new BufferedReader(stringReader);

        try {
            if (!",".equals(data)){
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                // Dividir cada línea en partes utilizando " " como delimitador.
                {
                String[] partes = linea.split(","); 
                int codigo = Integer.parseInt(partes[0]);
                String nombre= partes[1].trim();
                String apellidos= partes[2].trim();
                String telefono= partes[3].trim();
                String correo= partes[4].trim();
                String provincia= partes[5].trim();
                String canton= partes[6].trim();
                String distrito= partes[7].trim();
                String fecha= partes[8].trim();

                // Crear un objeto ObjetoDatos y agregarlo a la lista.
                Cliente objeto = new Cliente(codigo,nombre,apellidos,telefono,correo,provincia,canton,distrito,fecha);
                listaClientes.add(objeto);
            }}
            }} catch (IOException e) {
            System.err.println("Error al leer el StringBuilder: " + e.getMessage());
                    } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el BufferedReader: " + e.getMessage());
                }
                   }

    }
     public void AgregarCliente(String nombre, String apellidos,String telefono, String correo,String provincia, String canton, String distrito,
             String fecha) {
        int codigo=listaClientes.size()+1;
        System.out.println(listaClientes.size());
        
        for(Cliente cliente:listaClientes){
            int codigoExiste=cliente.getCodigo();
            if (codigoExiste==codigo){
                codigo++;
            }
        }
        if (!listaClientes.isEmpty()){
            if(listaClientes.getLast().getCodigo()>codigo){
                codigo=listaClientes.getLast().getCodigo()+1;
                if (codigo==(listaClientes.getLast().getCodigo())){
                    codigo++;
            }}
        }
        
        
        
        // Crear el objeto Cliente
        Cliente objeto = new Cliente(codigo,nombre.trim(),apellidos.trim(),telefono.trim(),correo.trim(),provincia.trim(),canton.trim(),distrito.trim(),fecha.trim());
        listaClientes.add(objeto);
        Archivos reg= new Archivos();
        reg.escribirEnArchivo(objeto, "Clientes.txt");
        
    }
     
     public void modificarfCliente(int codigo){
         
     }
     public void agregarClienteLista (Cliente clienteNuevo){
         listaClientes.add(clienteNuevo);
     }
     public Cliente obtenerClienteLista (int posicion){
         return listaClientes.get(posicion);
     }
     
     public int tamañoLista (){
         return listaClientes.size();
     }
  
     public ArrayList<Cliente> getClientes(){
         return listaClientes;
     }
    
 
    
     
}
