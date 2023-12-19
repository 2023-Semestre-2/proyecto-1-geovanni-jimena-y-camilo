/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.text.SimpleDateFormat;
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
    private Date fecha_recibido;
    private Date fecha_entrega;
    private String observaciones;
    private String estado;
    private String nombre;
    String patronFecha = "dd/MM/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(patronFecha);
   
    // aparte de los atributos, necesita de la referencia al menu y al arreglo
    private Menu menu;

    public Mantenimiento(int codigo_servicio, int codigo_cliente, String marca_bicicleta, String descripcion, int precio, Date fecha_recibido, Date fecha_entrega, String observaciones, String estado, String nombre) {
        this.codigo_servicio = codigo_servicio;
        this.codigo_cliente = codigo_cliente;
        this.marca_bicicleta = marca_bicicleta.trim();
        this.descripcion = descripcion.trim();
        this.precio = precio;
        this.fecha_recibido = fecha_recibido;
        this.fecha_entrega = fecha_entrega;
        this.observaciones = observaciones.trim();
        this.estado = estado;
        this.nombre = nombre.trim();
    }

    public Mantenimiento() {
    }
    
    

    @Override
    public String toString() {
        return codigo_servicio + "," + codigo_cliente + "," + marca_bicicleta + "," + descripcion + "," + precio + "," + sdf.format(fecha_recibido) + "," + sdf.format(fecha_entrega) + "," + observaciones + "," + estado + ',' + nombre + '\n';
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Date getFecha_recibido() {
        
        return fecha_recibido;
    }

    public void setFecha_recibido(Date fecha_recibido) {
        this.fecha_recibido = fecha_recibido;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
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
