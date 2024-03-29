/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ServicioMantenimiento;

import java.text.SimpleDateFormat;
import java.util.Date;

/** Clase que se encarga de crear el objeto de Mantenimiento con sus respectivos atributos
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
    
    // Estos atributos son para darle formato a las variables de tipo Date en forma de dd/MM/yyyy
    String patronFecha = "dd/MM/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(patronFecha);
   
    /**
     * Constructor de la clase
     * @param codigo_servicio
     * @param codigo_cliente
     * @param marca_bicicleta
     * @param descripcion
     * @param precio
     * @param fecha_recibido
     * @param fecha_entrega
     * @param observaciones
     * @param estado
     * @param nombre
     */
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

    /**
     *
     */
    public Mantenimiento() {
    }
    
    /**
     *
     * @return
     */
    @Override
    /** retorna el objeto a tipo string con dicho separado por comas (,)
     * 
     */
    public String toString() {
        return codigo_servicio + "," + codigo_cliente + "," + marca_bicicleta + "," + descripcion + "," + precio + "," + sdf.format(fecha_recibido) + "," + sdf.format(fecha_entrega) + "," + observaciones + "," + estado + ',' + nombre + ',' + '\n';
    }
    
    /**
     * 
     * @return el codigo de servicio
     */
    public int getCodigo_servicio() {
        return codigo_servicio;
    }

    /**
     *
     * @param codigo_servicio
     */
    public void setCodigo_servicio(int codigo_servicio) {
        this.codigo_servicio = codigo_servicio;
    }

    /**
     *
     * @return retorna el codigo del cliente
     */
    public int getCodigo_cliente() {
        return codigo_cliente;
    }

    /**
     *
     * @return retorna el nombre 
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     *
     * @param codigo_cliente
     */
    public void setCodigo_cliente(int codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    /**
     *
     * @return
     */
    public String getMarca_bicicleta() {
        return marca_bicicleta;
    }

    /**
     *
     * @param marca_bicicleta
     */
    public void setMarca_bicicleta(String marca_bicicleta) {
        this.marca_bicicleta = marca_bicicleta;
    }

    /**
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     *
     * @param descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     *
     * @return
     */
    public int getPrecio() {
        return precio;
    }

    /**
     *
     * @param precio
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     *
     * @return
     */
    public Date getFecha_recibido() {
        
        return fecha_recibido;
    }

    /**
     *
     * @param fecha_recibido
     */
    public void setFecha_recibido(Date fecha_recibido) {
        this.fecha_recibido = fecha_recibido;
    }

    /**
     *
     * @return
     */
    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    /**
     *
     * @param fecha_entrega
     */
    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    /**
     *
     * @return
     */
    public String getObservaciones() {
        return observaciones;
    }

    /**
     *
     * @param observaciones
     */
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     *
     * @return
     */
    public String getEstado() {
        return estado;
    }

    /**
     *
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }      
      
}
