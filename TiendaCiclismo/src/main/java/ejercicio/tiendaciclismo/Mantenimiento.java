/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.util.Date;

/**
 *
 * @author luisc
 */
public class Mantenimiento {
    private int codigo_servicio;
    private int codigo_cliente;
    private String marca_bicicleta;
    private String descripcion;
    private int precio;
    private String fecha_recibido;
    private String fecha_entrega;
    private String observaciones;
    private String estado;
   
    // aparte de los atributos, necesita de la referencia al menu y al arreglo
    private Menu menu;

    public Mantenimiento(int codigo_servicio, int codigo_cliente, String marca_bicicleta, String descripcion, int precio, String fecha_recibido, String fecha_entrega, String observaciones, String estado) {
        this.codigo_servicio = codigo_servicio;
        this.codigo_cliente = codigo_cliente;
        this.marca_bicicleta = marca_bicicleta;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_recibido = fecha_recibido;
        this.fecha_entrega = fecha_entrega;
        this.observaciones = observaciones;
        this.estado = estado;
        
        
        
    }
    
    
        
        
      
}
