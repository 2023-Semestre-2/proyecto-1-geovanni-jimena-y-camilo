/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.awt.List;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class RegistroProductos{
    private ArrayList<TipoProducto> tiposProductos= new ArrayList<TipoProducto>();
    private ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    

    public void agregarTipoProducto(String nombre) {
        int codigo = tiposProductos.size() + 1;
        String nombreSinEspacios = nombre.trim();

        // Crear el objeto TipoProducto
        TipoProducto tipoProducto = new TipoProducto(codigo, nombreSinEspacios);
        tiposProductos.add(tipoProducto);
        guardarTipoProductoEnCSV(tipoProducto);
        
    } 
    
    private void guardarTipoProductoEnCSV(TipoProducto tipoProducto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tiposProductos.csv", true))) {
            // Agregar el nuevo tipo de producto al archivo CSV
            writer.write(tipoProducto.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir" + e.getMessage());
        }
    }

    public void agregarArticulo(int codigoTipoProducto, String nombre, String tipo, int tamaño, String marca, double precio, int cantidad) {
        System.out.println(articulos);
        System.out.println("Artículo agregado con éxito.");
    }

    public void mostrarTiposProductos() {
        for (TipoProducto tipoProducto : tiposProductos) {
            System.out.println("Código: " + tipoProducto.getCodigo() + ", Nombre: " + tipoProducto.getNombre());
        }
    }

    public void mostrarArticulos() {
        for (Articulo articulo : articulos) {
            System.out.println("Código: " + articulo.getCodigo() + ", Nombre: " + articulo.getNombre() + ", Tipo: " + articulo.getTipo() + ", Precio: " + articulo.getPrecio());
        }
        
    
    }


}
