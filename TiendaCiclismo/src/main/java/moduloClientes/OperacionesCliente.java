
package moduloClientes;

import ejercicio.tiendaciclismo.Archivos;
import java.util.ArrayList;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.StringReader;

/**
 *
 * @author geova
 */
public class OperacionesCliente  {
    
    /**
     *Array de clientes
     */
    public ArrayList<Cliente> listaClientes = new ArrayList<>();

    /**
     *
     */
    public OperacionesCliente() {
        
    }

    /**
     *Transforma la string de clientes en objetos y los añade a la lista
     * @param data string 
     */
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
                boolean facturado= Boolean.parseBoolean(partes[9].trim());

                // Crear un objeto ObjetoDatos y agregarlo a la lista.
                Cliente objeto = new Cliente(codigo,nombre,apellidos,telefono,correo,provincia,canton,distrito,fecha,facturado);
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

    /**
     * Agrega el cliente al array y al archivo
     * @param nombre nombre del cliente
     * @param apellidos apellidos del cliente
     * @param telefono telefono del cliente
     * @param correo correo del cliente
     * @param provincia provincia del cliente
     * @param canton cantond del cliente
     * @param distrito distrito del cliente
     * @param fecha fecha de nacimineto del cliente
     */
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
        Cliente objeto = new Cliente(codigo,nombre.trim(),apellidos.trim(),telefono.trim(),correo.trim(),provincia.trim(),canton.trim(),distrito.trim(),fecha.trim(),true);
        listaClientes.add(objeto);
        Archivos reg= new Archivos();
        reg.escribirEnArchivo(objeto, "Clientes.csv");
        
    }
     
    /**
     *Modifica los datos del cliente
     * @param codigo codigo del cliente
     * @param nombre nombre del cliente
     * @param apellidos apellidos del cliente
     * @param telefono telefono del cliente
     * @param correo correo del cliente
     * @param provincia provincia del cliente
     * @param canton cantond del cliente
     * @param distrito distrito del cliente
     * @param fecha fecha de nacimineto del cliente
     * @param facturado estado del cliente
     */
    public void modificarCliente(int codigo,String nombre, String apellidos,String telefono, String correo,String provincia, String canton, String distrito,
             String fecha, boolean  facturado){
         
        for (Cliente objeto:listaClientes){
            int codigoExiste=objeto.getCodigo();
            if (codigoExiste==codigo){
                //Modificarlo en la lista
                String lineaReemplazada=objeto.getCodigo()+","+objeto.getNombre()+","+objeto.getApellidos()+","+objeto.getTelefono()+","+objeto.getCorreo()+","+
                        objeto.getProvincia()+","+objeto.getCanton()+","+objeto.getDistrito()+","+objeto.getFechaNacimiento() + "," +String.valueOf(objeto.isFacturado()) + ",";
                System.out.println("Prueba linea reemplazar");
                System.out.println(lineaReemplazada);
                int indice=listaClientes.indexOf(objeto);
                listaClientes.remove(objeto);
                objeto.setNombre(nombre);
                objeto.setApellidos(apellidos);
                objeto.setTelefono(telefono);
                objeto.setCorreo(correo);
                objeto.setProvincia(provincia);
                objeto.setCanton(canton);
                objeto.setDistrito(distrito);
                objeto.setFacturado(facturado);
                
                listaClientes.add(indice, objeto);
                String lineaAñadirArchivo= objeto.getCodigo()+","+objeto.getNombre()+","+objeto.getApellidos()+","+objeto.getTelefono()+","+objeto.getCorreo()+","+
                        objeto.getProvincia()+","+objeto.getCanton()+","+objeto.getDistrito()+","+objeto.getFechaNacimiento()+","+String.valueOf(objeto.isFacturado()) + ",";
                System.out.println("Prueba linea añadir");
                System.out.println(lineaAñadirArchivo);
                
                Archivos registro = new Archivos();
                registro.modificarEscritura(lineaAñadirArchivo, lineaReemplazada, "Clientes.csv");
                break;
            }
        }      
     }
     
    /**
     * Elimina el cliente de la lista y del archivo
     * @param codigo codigo del cliente a eliminar
     */
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
                        objetoEliminado.getProvincia()+","+objetoEliminado.getCanton()+","+objetoEliminado.getDistrito()+","+objetoEliminado.getFechaNacimiento() + ','+objetoEliminado.isFacturado()+",";
            Archivos registro = new Archivos();
            registro.eliminarEscritura(lineaEliminada, "Clientes.csv");
        } else {
            System.out.println("No se encontró un cliente con el código proporcionado.");
        }
        
    }

    /**
     * busca por nombre al cliente y las coincidencias las añade a un array
     * @param nombre nombre del cliente
     * @return retorna el array
     */
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
      
    /**
     * Verifica si el cliente ha sido facturado
     * @param nombre nombre del clinete
     */
    public void Clientefacturado(String nombre){
        for(Cliente cliente:listaClientes){
            String nombreGuardado=cliente.getNombre();
            System.out.println("Prueba cliente facturado");
            System.out.println(nombreGuardado);
            if (nombreGuardado.equals(nombre)){
                modificarCliente(cliente.getCodigo(),cliente.getNombre(),cliente.getApellidos(),cliente.getTelefono(),cliente.getCorreo(),cliente.getProvincia(),cliente.getCanton(),cliente.getDistrito(),cliente.getFechaNacimiento(),false);
            }
        }
    } 
      
    /**
     *Busca por codigo el cliente y lo añade a una array
     * @param codigo codigo a buscar
     * @return retorna el array de coincidencias
     */
    public ArrayList<Cliente> buscarCodigoCliente(int codigo){
        ArrayList<Cliente> clientesBuscados = new ArrayList<>();

        for(Cliente cliente:listaClientes){
            if (cliente.getCodigo()==codigo){
                clientesBuscados.add(cliente);
            }         
        }
        return clientesBuscados;
    }
     /**
      * Agrega un cliente a la lista de clientes
      * @param clienteNuevo cliente a añadir
      */
     public void agregarClienteLista (Cliente clienteNuevo){
         listaClientes.add(clienteNuevo);
     }
     /**
      * Retorna un cliente de la lista segun el indice ingresado
      * @param posicion indice del cliente que se quiere obtener
      * @return Retorna el cliente
      */
     public Cliente obtenerClienteLista (int posicion){
         return listaClientes.get(posicion);
     }
     
    /**
     *
     * @return retorna el tamaño de la lista de clientes
     */
    public int tamañoLista (){
         return listaClientes.size();
     }
  
    /**
     *
     * @return retorna la lista de clientes actuales
     */
    public ArrayList<Cliente> getClientes(){
         return listaClientes;
     }
    
 
    
     
}
