/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.util.ArrayList;

/**
 *
 * @author luisc
 */
public class Producto {
    private int codigo;
    private String nombre;
    private int codigo_articulo;
    private int codigo_tipo_producto;
    private String nombre_articulo;
    private Tipo tipo;
    private int tamaño;
    private String marca;
    private int precio;
    private int cantidad;
    ArrayList<Producto> productos = new ArrayList<>();

    public Producto(int codigo, String nombre, int codigo_articulo, int codigo_tipo_producto, String nombre_articulo, Tipo tipo, int tamaño, String marca, int precio, int cantidad) {
        
        this.codigo = codigo;
        this.nombre = nombre;
        this.codigo_articulo = codigo_articulo;
        this.codigo_tipo_producto = codigo_tipo_producto;
        this.nombre_articulo = nombre_articulo;
        this.tipo = tipo;
        this.tamaño = tamaño;
        this.marca = marca;
        this.precio = precio;
        this.cantidad = cantidad;
        
        
        
        
    }
    
    
    
    public void deleteProducto(Producto producto){
        productos.remove(producto);
    }
    
    public void agregarProducto(Producto producto){
        productos.add(producto);
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo=" + codigo + ", nombre=" + nombre + ", codigo_articulo=" + codigo_articulo + ", codigo_tipo_producto=" + codigo_tipo_producto + ", nombre_articulo=" + nombre_articulo + ", tipo=" + tipo + ", tama\u00f1o=" + tamaño + ", marca=" + marca + ", precio=" + precio + ", cantidad=" + cantidad + '}';
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo_articulo() {
        return codigo_articulo;
    }

    public void setCodigo_articulo(int codigo_articulo) {
        this.codigo_articulo = codigo_articulo;
    }

    public int getCodigo_tipo_producto() {
        return codigo_tipo_producto;
    }

    public void setCodigo_tipo_producto(int codigo_tipo_producto) {
        this.codigo_tipo_producto = codigo_tipo_producto;
    }

    public String getNombre_articulo() {
        return nombre_articulo;
    }

    public void setNombre_articulo(String nombre_articulo) {
        this.nombre_articulo = nombre_articulo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
}

enum Tipo {
    BICICLETA,
    ACCESORIOS,
    SUPLEMENTOS_ALIMENTICIOS;

    public static Tipo getBICICLETA() {
        return BICICLETA;
    }

    public static Tipo getACCESORIOS() {
        return ACCESORIOS;
    }

    public static Tipo getSUPLEMENTOS_ALIMENTICIOS() {
        return SUPLEMENTOS_ALIMENTICIOS;
    }
    
    
}