/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class RegistroProductos{
    private ArrayList<TipoProducto> tiposProductos= new ArrayList<>();
    private ArrayList<Articulo> articulos = new ArrayList<>();
    
    
    public void ProductosArchivo(String data){
        StringReader stringReader = new StringReader(data);
        BufferedReader bufferedReader = new BufferedReader(stringReader);

        try {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                // Dividir cada línea en partes utilizando " " como delimitador.
                String[] partes = linea.split(","); 
                int codigo = Integer.parseInt(partes[0].trim());
                // Crear un objeto ObjetoDatos y agregarlo a la lista.
                TipoProducto objeto = new TipoProducto(codigo, partes[1].trim());
                tiposProductos.add(objeto);
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
        
    
    @SuppressWarnings("empty-statement")
    public void agregarTipoProducto(String nombre) {
        int codigo = tiposProductos.size() + 1;
        
        for(TipoProducto producto:tiposProductos){//En caso de que un producto se elimine
            int codigoExiste=producto.getCodigo();
            if (codigoExiste==codigo){
                codigo++;
            }
        }
        
        
        if (!tiposProductos.isEmpty()){
            if(tiposProductos.getLast().getCodigo()>codigo){
                codigo=tiposProductos.getLast().getCodigo()+1;
                if (codigo==(tiposProductos.getLast().getCodigo())){
                    codigo++;
                }
            }
        }
        
        
        String nombreSinEspacios = nombre.trim();
        
        // Crear el objeto TipoProducto
        TipoProducto tipoProducto = new TipoProducto(codigo,nombreSinEspacios);
        tiposProductos.add(tipoProducto);
        Archivos reg= new Archivos();
        reg.escrituraProducto(tipoProducto, true);
        
    } 
    
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
                Articulo ultimoArticulo=articulosProducto.getLast();
                if (ultimoArticulo.getCodigo()>=codigo){
                    codigo=ultimoArticulo.getCodigo()+1;
                }
            }
          
   
            String nombreSinEspacios = nombre.trim();
            String marca1= marca.trim();
          
        
            // Crear el objeto TipoProducto
            Articulo art = new Articulo(codigo,codigoTipoProducto,nombreSinEspacios,tipo,tamano,marca1,precio,cantidad);
        
            articulos.add(art);
            Archivos reg= new Archivos();
            reg.escrituraArticulo(codigo, codigoTipoProducto,nombreSinEspacios,tipo,tamano,marca1,precio,cantidad, true);
        }catch (Exception e){
            System.err.println("Error al leer: " + e.getMessage());
        }
    }
   
    
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
        ArrayList<Articulo> articulosProducto = new ArrayList<>();
        for (Articulo objeto:articulos){
            int codigoExiste=objeto.getCodigoTipoProducto();
            if (codigo==codigoExiste){
                articulosProducto.add(objeto);
            }
        }
        
        if (!articulosProducto.isEmpty()) {
            Archivos registro = new Archivos();
            for (Articulo objeto:articulosProducto){
                String lineaEliminada=objeto.toString();
                registro.eliminarEscritura(lineaEliminada, "Articulos");
            }
        }
        
        
        if (objetoEliminado != null) {
            tiposProductos.remove(objetoEliminado);

            String lineaEliminada = objetoEliminado.toString();
            Archivos registro = new Archivos();
            registro.eliminarEscritura(lineaEliminada, "tiposProductos");
        } else {
            System.out.println("No se encontró un TipoProducto con el código proporcionado.");
        }
        
    }
    
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
            Archivos registro = new Archivos();
            registro.eliminarEscritura(lineaEliminada, "Articulos");
        } else {
            System.out.println("No se encontró un articulo con el código proporcionado.");
        }
    }
    
    
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
                registro.modificarEscritura(objeto.toString(), lineaReemplazada, "tiposProductos");
                break;
            }
        }      
    }
    
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
                Archivos registro = new Archivos();
                registro.modificarEscritura(objeto.toString(), lineaReemplazada, "Articulos");
                break;
                
            }
        }
    }

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
    

 
 
    public ArrayList<TipoProducto> getTiposProductos() {
        return tiposProductos;
    }

    public void setTiposProductos(ArrayList<TipoProducto> tiposProductos) {
        this.tiposProductos = tiposProductos;
    }

    public ArrayList<Articulo> getArticulos() {
        return articulos;
    }

    public void setArticulos(ArrayList<Articulo> articulos) {
        this.articulos = articulos;
    }
    
    


}
