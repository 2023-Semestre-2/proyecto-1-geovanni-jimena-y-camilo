/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moduloProductos;

import ejercicio.tiendaciclismo.Archivos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;


/**
 * La clase `RegistroProductos` gestiona y mantiene un registro de tipos de productos y artículos.
 * Contiene métodos para la manipulación de productos y artículos, como la adición, búsqueda y eliminación.
 * Además, carga y guarda datos relacionados con productos y artículos desde y hacia archivos.
 * Requiere una instancia de `Archivos` para funcionar correctamente.
 * @author Jimena Mendez
 */
public class RegistroProductos{
    // Lista que almacena los tipos de productos
    private ArrayList<TipoProducto> tiposProductos= new ArrayList<>();
    // Lista que almacena los artículos
    private ArrayList<Articulo> articulos = new ArrayList<>();
    // Instancia de la clase que va manejar la lectura y escritura de archivos
    private Archivos reg= new Archivos();

    
   
    /**
     * Lee los datos de los tipos de productos desde una cadena y los agrega a la lista de tipos de productos.
     *
     * @param data Cadena que contiene los datos de los tipos de productos.
     */
    public void ProductosArchivo(String data){
        StringReader stringReader = new StringReader(data);
        BufferedReader bufferedReader = new BufferedReader(stringReader);

        try {
            String linea;
            if(data.length() > 2){
            while ((linea = bufferedReader.readLine()) != null) {
                // Dividir cada línea en partes utilizando " " como delimitador.
                String[] partes = linea.split(","); 
                int codigo = Integer.parseInt(partes[0].trim());
                // Crear un objeto ObjetoDatos y agregarlo a la lista.
                TipoProducto objeto = new TipoProducto(codigo, partes[1].trim());
                tiposProductos.add(objeto);
                }
            }
        } catch (IOException e) {
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
     * Agrega un nuevo tipo de producto al registro con el nombre proporcionado.
     *
     * @param nombre Nombre del tipo de producto a agregar.
     */
    public void agregarTipoProducto(String nombre) {
        int codigo = tiposProductos.size() + 1;
        
        for(TipoProducto producto:tiposProductos){//En caso de que un producto se elimine
            int codigoExiste=producto.getCodigo();
            if (codigoExiste==codigo){
                codigo++;
            }
        }
        
        
        if (!tiposProductos.isEmpty()){
            if(tiposProductos.get(tiposProductos.size()-1).getCodigo()>codigo){
                codigo=tiposProductos.get(tiposProductos.size()-1).getCodigo()+1;
                if (codigo==(tiposProductos.get(tiposProductos.size()-1).getCodigo())){
                    codigo++;
                }
            }
        }
        
        
        String nombreSinEspacios = nombre.trim();
        
        // Crear el objeto TipoProducto
        TipoProducto tipoProducto = new TipoProducto(codigo,nombreSinEspacios);
        tiposProductos.add(tipoProducto);
        
        reg.escrituraProducto(tipoProducto, true);
        
    } 
    
    /**
     * Lee los datos de los artículos desde una cadena y los agrega a la lista de artículos.
     *
     * @param data Cadena que contiene los datos de los artículos.
     */
    public void ArticulosArchivo(String data){
        StringReader stringReader = new StringReader(data);
        BufferedReader bufferedReader = new BufferedReader(stringReader);

        try {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                // Dividir cada línea en partes utilizando " " como delimitador.
                String[] partes = linea.split(",");
                int codigo = Integer.parseInt(partes[0].trim());
                int codigoProducto = Integer.parseInt(partes[1].trim());
                int tamano = Integer.parseInt(partes[4].trim());
                int precio = Integer.parseInt(partes[6].trim());
                int cantidad = Integer.parseInt(partes[7].trim());
                // Crear un objeto ObjetoDatos y agregarlo a la lista.
                Articulo objeto = new Articulo(codigo,codigoProducto,partes[2].trim(),partes[3].trim(),tamano,partes[5].trim(),precio,cantidad);
   
                articulos.add(objeto);
            }
        } catch (IOException e) {
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
     * Agrega un nuevo artículo al registro con la información proporcionada.
     *
     * @param codigoTipoProducto Código del tipo de producto al que pertenece el artículo.
     * @param nombre             Nombre del artículo.
     * @param tipo               Tipo del artículo.
     * @param tamano             Tamaño del artículo.
     * @param marca              Marca del artículo.
     * @param precio             Precio del artículo.
     * @param cantidad           Cantidad disponible del artículo.
     */
    public void agregarArticulo(int codigoTipoProducto, String nombre, String tipo, int tamano, String marca, int precio, int cantidad) {
        try{
            
       
        
            ArrayList<Articulo> articulosProducto = new ArrayList<>();//los articulos que tiene un producto en especifico
            //Revisar si hay articulos con ese producto
            int codigo=1;
            for(Articulo art: articulos){
                int codigoExiste=art.getCodigoTipoProducto();
                if (codigoTipoProducto==codigoExiste){
                    codigo++;
                    articulosProducto.add(art);
                }           
            }
        
            //Revisar que no haya ningun articulo con el codigo del nuevo articulo
            if (!articulosProducto.isEmpty()){
                Articulo ultimoArticulo=articulosProducto.get(articulosProducto.size()-1);
                if (ultimoArticulo.getCodigo()>=codigo){
                    codigo=ultimoArticulo.getCodigo()+1;
                }
            }
          
   
            String nombreSinEspacios = nombre.trim();
            String marca1= marca.trim();
          
        
            // Crear el objeto TipoProducto
            Articulo art = new Articulo(codigo,codigoTipoProducto,nombreSinEspacios,tipo,tamano,marca1,precio,cantidad);
        
            articulos.add(art);
            reg.escrituraArticulo(codigo, codigoTipoProducto,nombreSinEspacios,tipo,tamano,marca1,precio,cantidad, true);
        }catch (Exception e){
            System.err.println("Error al leer: " + e.getMessage());
        }
    }
   
    /**
     * Elimina un tipo de producto del registro por su código.
     *
     * @param codigo Código del tipo de producto a eliminar.
     */
    public void deleteProducto(int codigo){
        TipoProducto objetoEliminado=null;
        //Quitar del archivo
        for (TipoProducto objeto:tiposProductos){
            int codigoExiste=objeto.getCodigo();
            if (codigoExiste==codigo){
                objetoEliminado=objeto;
                break;
            }
        }
        
        //Todos los articulos con el producto eliminado
        ArrayList<Articulo> articulosProducto = obtenerArticulos(objetoEliminado.getCodigo());
        
        if (!articulosProducto.isEmpty()) {
            for (Articulo objeto:articulosProducto){
                String lineaEliminada=objeto.toString();
                reg.eliminarEscritura(lineaEliminada, "Articulos.csv");
                articulos.remove(objeto);
            }
        }
        
        
        if (objetoEliminado != null) {
            tiposProductos.remove(objetoEliminado);

            String lineaEliminada = objetoEliminado.toString();
            reg.eliminarEscritura(lineaEliminada, "tiposProductos.csv");
        } else {
            System.out.println("No se encontró un TipoProducto con el código proporcionado.");
        }
        
    }
    
    /**
     * Elimina un artículo del registro por su código y el código del tipo de producto al que pertenece.
     *
     * @param codigo         Código del artículo a eliminar.
     * @param codigoProducto Código del tipo de producto al que pertenece el artículo.
     */
    public void deleteArticulo(int codigo,int codigoProducto){
        Articulo objetoEliminado = null;
        //Quitar del archivo
        for (Articulo objeto:articulos){
            int codigoExisteProducto=objeto.getCodigoTipoProducto();
            int codigoExisteArticulo=objeto.getCodigo();
            if (codigoExisteArticulo==codigo && codigoExisteProducto==codigoProducto){
                objetoEliminado=objeto;
                break;
            }
        }
        
        if (objetoEliminado != null) {
            articulos.remove(objetoEliminado);

            String lineaEliminada = objetoEliminado.toString();
            reg.eliminarEscritura(lineaEliminada, "Articulos.csv");
        } else {
            System.out.println("No se encontró un articulo con el código proporcionado.");
        }
    }
    
    /**
     * Modifica el nombre de un tipo de producto en el registro por su código.
     *
     * @param codigo Código del tipo de producto a modificar.
     * @param nombre Nuevo nombre para el tipo de producto.
     */
    public void modificarProducto(int codigo,String nombre){
        //Buscar el objeto del producto que se quiere cambiar
        for (TipoProducto objeto:tiposProductos){
            int codigoExiste=objeto.getCodigo();
            if (codigoExiste==codigo){
                //Modificarlo en la lista
                String lineaReemplazada=objeto.toString();
                int indice=tiposProductos.indexOf(objeto);
                tiposProductos.remove(objeto);
                objeto.setNombre(nombre);
                tiposProductos.add(indice, objeto);
                
                Archivos registro = new Archivos();
                registro.modificarEscritura(objeto.toString(), lineaReemplazada, "tiposProductos.csv");
                break;
            }
        }      
    }
    
    /**
     * Modifica la información de un artículo en el registro por su código y el código del tipo de producto al que pertenece.
     *
     * @param codigo         Código del artículo a modificar.
     * @param codigoProducto Código del tipo de producto al que pertenece el artículo.
     * @param nombre         Nuevo nombre para el artículo.
     * @param tipo           Nuevo tipo para el artículo.
     * @param tamano         Nuevo tamaño para el artículo.
     * @param marca          Nueva marca para el artículo.
     * @param precio         Nuevo precio para el artículo.
     * @param cantidad       Nueva cantidad para el artículo.
     */
    public void modificarArticulo(int codigo, int codigoProducto,String nombre, String tipo, int tamano, String marca, int precio, int cantidad){
        for(Articulo objeto:articulos){
            int codigoExisteProducto=objeto.getCodigoTipoProducto();
            int codigoExisteArticulo=objeto.getCodigo();
            if (codigoExisteArticulo==codigo && codigoExisteProducto==codigoProducto){
                String lineaReemplazada=objeto.toString();
                
                int indice=articulos.indexOf(objeto);
                articulos.remove(objeto);
                
                //Actualiza los dato en el objeto
                objeto.setNombre(nombre);
                objeto.setTipo(tipo);
                objeto.setTamano(tamano);
                objeto.setMarca(marca);
                objeto.setPrecio(precio);
                objeto.setCantidad(cantidad);
                
                System.out.println(objeto);
                
                articulos.add(indice, objeto);
                reg.modificarEscritura(objeto.toString(), lineaReemplazada, "Articulos.csv");
                break;
                
            }
        }
    }

    /**
     * Busca y devuelve todos los tipos de productos con el código especificado.
     *
     * @param codigo Código del tipo de producto a buscar.
     * @return Lista de tipos de productos encontrados con el código especificado.
     */
    public ArrayList<TipoProducto> buscarCodigoProducto(int codigo){
        ArrayList<TipoProducto> productosBuscados = new ArrayList<>();
        //Verificar los productos y articulos con ese codigo
        for(TipoProducto producto:tiposProductos){
            if (producto.getCodigo()==codigo){
                productosBuscados.add(producto);
            }         
        }
        return productosBuscados;
    }
    
    /**
     * Busca y devuelve todos los artículos con el código especificado.
     *
     * @param codigo Código del artículo a buscar.
     * @return Lista de artículos encontrados con el código especificado.
     */
    public ArrayList<Articulo> buscarCodigoArticulo(int codigo){
        ArrayList<Articulo> articulosBuscados= new ArrayList<>();
        for(Articulo art:articulos){
            if (art.getCodigo()==codigo){
                articulosBuscados.add(art);
            }else{
                if(art.getCodigoTipoProducto()==codigo){
                    articulosBuscados.add(art);
                }
            }   
        }
        return articulosBuscados;
    }
    
    /**
     * Busca y devuelve todos los tipos de productos con el nombre especificado.
     *
     * @param nombre Nombre del tipo de producto a buscar.
     * @return Lista de tipos de productos encontrados con el nombre especificado.
     */
    public ArrayList<TipoProducto> buscarNombreProducto(String nombre){
        ArrayList<TipoProducto> productosBuscados = new ArrayList<>();
        for (TipoProducto producto:tiposProductos){
            String posibleNombre=producto.getNombre();
            if(posibleNombre.contains(nombre) || nombre.contains(posibleNombre)){
                productosBuscados.add(producto);
            }
        }
        
        return productosBuscados;
        
    }
    
    /**
     * Busca y devuelve todos los artículos con el nombre especificado.
     *
     * @param nombre Nombre del artículo a buscar.
     * @return Lista de artículos encontrados con el nombre especificado.
     */
    public ArrayList<Articulo> buscarNombreArticulo(String nombre){
        ArrayList<Articulo> productosBuscados = new ArrayList<>();
        for (Articulo art:articulos){
            String posibleNombre=art.getNombre();
            if(posibleNombre.contains(nombre) || nombre.contains(posibleNombre)){
                productosBuscados.add(art);
            }
        }
        
        return productosBuscados;
    }
    
    /**
     * Obtiene el código de un tipo de producto por su nombre.
     *
     * @param nombreProducto Nombre del tipo de producto.
     * @return Código del tipo de producto.
     */
    public int codigoProducto(String nombreProducto){
        int codigo=0;
        //Obtener el codigo del producto por medio del nombre
        for (TipoProducto producto:tiposProductos){
            String nombreExiste=producto.getNombre();
            if (nombreExiste.equals(nombreProducto)){
                codigo=producto.getCodigo();
            }
        }
        return codigo;
    }
    
    /**
     * Obtiene el código de un artículo por su nombre.
     *
     * @param nombreArticulo Nombre del artículo.
     * @return Código del artículo.
     */
    public int codigoArticulo(String nombreArticulo){
        int codigo=0;
        //Obtener el codigo del producto por medio del nombre
        for (Articulo articulo:articulos){
            String nombreExiste=articulo.getNombre();
            if (nombreExiste.equals(nombreArticulo)){
                codigo=articulo.getCodigo();
            }
        }
        return codigo;
    }
    
    /**
     * Obtiene todos los artículos asociados a un tipo de producto por su código.
     *
     * @param codigo Código del tipo de producto.
     * @return Lista de artículos asociados al tipo de producto especificado.
     */
    public ArrayList<Articulo> obtenerArticulos(int codigo){
        ArrayList<Articulo> articulosProducto= new ArrayList<>();
        for (Articulo objeto:articulos){
            int codigoExiste=objeto.getCodigoTipoProducto();
            if (codigo==codigoExiste){
                articulosProducto.add(objeto);
            }
        }
        return articulosProducto;
    }
    
    /**
     * Obtiene la lista de tipos de productos.
     *
     * @return Lista de tipos de productos almacenados.
     */
    public ArrayList<TipoProducto> getTiposProductos() {
        return tiposProductos;
    }

    /**
     * Establece la lista de tipos de productos.
     *
     * @param tiposProductos Nueva lista de tipos de productos a establecer.
     */
    public void setTiposProductos(ArrayList<TipoProducto> tiposProductos) {
        this.tiposProductos = tiposProductos;
    }

    /**
     * Obtiene la lista de artículos.
     *
     * @return Lista de artículos almacenados.
     */
    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    /**
     * Establece la lista de artículos.
     *
     * @param articulos Nueva lista de artículos a establecer.
     */
    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }
    
    


}
