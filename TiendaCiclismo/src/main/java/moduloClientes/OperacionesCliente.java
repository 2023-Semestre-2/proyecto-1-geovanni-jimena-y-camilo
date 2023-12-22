
package moduloClientes;

import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
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
            if(listaClientes.get(listaClientes.size()-1).getCodigo()>codigo){
                codigo=listaClientes.get(listaClientes.size()-1).getCodigo()+1;
                if (codigo==(listaClientes.get(listaClientes.size()-1).getCodigo())){
                    codigo++;
            }}
        }
        
        
        
        // Crear el objeto Cliente
        Cliente objeto = new Cliente(codigo,nombre.trim(),apellidos.trim(),telefono.trim(),correo.trim(),provincia.trim(),canton.trim(),distrito.trim(),fecha.trim());
        listaClientes.add(objeto);
        ArchivosClientes reg= new ArchivosClientes();
        reg.escribirEnArchivo(objeto, "Clientes.csv");
        
    }
     
     public void modificarCliente(int codigo,String nombre, String apellidos,String telefono, String correo,String provincia, String canton, String distrito,
             String fecha){
         
        for (Cliente objeto:listaClientes){
            int codigoExiste=objeto.getCodigo();
            if (codigoExiste==codigo){
                //Modificarlo en la lista
                String lineaReemplazada=objeto.getCodigo()+","+objeto.getNombre()+","+objeto.getApellidos()+","+objeto.getTelefono()+","+objeto.getCorreo()+","+
                        objeto.getProvincia()+","+objeto.getCanton()+","+objeto.getDistrito()+","+objeto.getFechaNacimiento();
                int indice=listaClientes.indexOf(objeto);
                listaClientes.remove(objeto);
                objeto.setNombre(nombre);
                objeto.setApellidos(apellidos);
                objeto.setTelefono(telefono);
                objeto.setCorreo(correo);
                objeto.setProvincia(provincia);
                objeto.setCanton(canton);
                objeto.setDistrito(distrito);
                
                listaClientes.add(indice, objeto);
                String lineaAñadirArchivo= objeto.getCodigo()+","+objeto.getNombre()+","+objeto.getApellidos()+","+objeto.getTelefono()+","+objeto.getCorreo()+","+
                        objeto.getProvincia()+","+objeto.getCanton()+","+objeto.getDistrito()+","+objeto.getFechaNacimiento();
                
                ArchivosClientes registro = new ArchivosClientes();
                registro.modificarEscritura(lineaAñadirArchivo, lineaReemplazada, "Clientes.csv");
                break;
            }
        }      
     }
     
     public void eliminarCliente(int codigo){
        Cliente objetoEliminado=null;
        //Quitar del archivo
        for (Cliente objeto:listaClientes){
            int codigoExiste=objeto.getCodigo();
            if (codigoExiste==codigo){
                objetoEliminado=objeto;
                break;
            }
        }
                
        if (objetoEliminado != null) {
            listaClientes.remove(objetoEliminado);

            String lineaEliminada = objetoEliminado.getCodigo()+","+objetoEliminado.getNombre()+","+objetoEliminado.getApellidos()+","+objetoEliminado.getTelefono()+","+objetoEliminado.getCorreo()+","+
                        objetoEliminado.getProvincia()+","+objetoEliminado.getCanton()+","+objetoEliminado.getDistrito()+","+objetoEliminado.getFechaNacimiento();
            ArchivosClientes registro = new ArchivosClientes();
            registro.eliminarEscritura(lineaEliminada, "Clientes.csv");
        } else {
            System.out.println("No se encontró un cliente con el código proporcionado.");
        }
        
    }
      public ArrayList<Cliente> buscarNombreCliente(String nombre){
        ArrayList<Cliente> clientesBuscados = new ArrayList<>();
        for (Cliente cliente:listaClientes){
            String posibleNombre=cliente.getNombre();
            if(posibleNombre.contains(nombre) || nombre.contains(posibleNombre)){
                clientesBuscados.add(cliente);
            }
        }
        
        return clientesBuscados;
        
    }
      public ArrayList<Cliente> buscarCodigoCliente(int codigo){
        ArrayList<Cliente> clientesBuscados = new ArrayList<>();

        for(Cliente cliente:listaClientes){
            if (cliente.getCodigo()==codigo){
                clientesBuscados.add(cliente);
            }         
        }
        return clientesBuscados;
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