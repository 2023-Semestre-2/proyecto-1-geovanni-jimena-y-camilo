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
    private String nombre;
   
    // aparte de los atributos, necesita de la referencia al menu y al arreglo
    private Menu menu;

    public Mantenimiento(int codigo_servicio, int codigo_cliente, String marca_bicicleta, String descripcion, int precio, String fecha_recibido, String fecha_entrega, String observaciones, String estado, String nombre) {
        this.codigo_servicio = codigo_servicio;
        this.codigo_cliente = codigo_cliente;
        this.marca_bicicleta = marca_bicicleta;
        this.descripcion = descripcion;
        this.precio = precio;
        this.fecha_recibido = fecha_recibido;
        this.fecha_entrega = fecha_entrega;
        this.observaciones = observaciones;
        this.estado = estado;
        this.nombre = nombre;
        
        
        
    }

    @Override
    public String toString() {
        return codigo_servicio + "," + codigo_cliente + "," + marca_bicicleta + "," + descripcion + "," + precio + "," + fecha_recibido + "," + fecha_entrega + "," + observaciones + "," + estado + ',' + nombre + '\n';
    }

    public int getCodigo_servicio() {
        return codigo_servicio;
    }

    public void setCodigo_servicio(int codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getMarca_bicicleta() {
        return marca_bicicleta;
    }

    public void setMarca_bicicleta(String marca_bicicleta) {
        this.marca_bicicleta = marca_bicicleta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getFecha_recibido() {
        return fecha_recibido;
    }

    public void setFecha_recibido(String fecha_recibido) {
        this.fecha_recibido = fecha_recibido;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
    
    
        
    
        
      
}
