/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

/**
 *
 * @author luisc
 */
public class Productos {
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

    public Productos(int codigo, String nombre, int codigo_articulo, int codigo_tipo_producto, String nombre_articulo, Tipo tipo, int tamaño, String marca, int precio, int cantidad) {
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