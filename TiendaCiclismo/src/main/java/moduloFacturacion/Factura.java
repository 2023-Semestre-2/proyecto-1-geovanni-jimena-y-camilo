/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package moduloFacturacion;

import ejercicio.tiendaciclismo.Archivos;
import moduloProductos.Articulo;
import moduloProductos.RegistroProductos;

/**
 * Clase que representa una factura en el sistema.
 * Almacena información sobre una transacción de compra, incluyendo detalles del artículo, cantidad y precios.
 * También realiza cálculos relacionados con el precio, impuestos y subtotal.
 * 
 * @author Jimena Mendez
 */
public class Factura {
    private int numeroFactura;
    private String nombre;
    private String fecha;
    private String Estado;
    private int codigoArticulo;
    private int codigoProducto;
    private int cantidad;
    private int precio;
    private String Tipo;
    private Archivos reg = new Archivos();
    private RegistroProductos registro = new RegistroProductos();

    
    /**
     * Constructor por defecto de la clase Factura.
     * Inicializa los atributos de la factura y carga datos de productos desde archivos.
     */
    public Factura() {
    }


    /**
     * Constructor de la clase Factura con parámetros.
     * Inicializa los atributos de la factura con los valores proporcionados.
     * Además, carga datos de productos desde archivos.
     * 
     * @param numeroFactura Número de la factura.
     * @param nombre Nombre del cliente.
     * @param fecha Fecha de la factura.
     * @param Estado Estado de la factura.
     * @param codigoArticulo Código del artículo.
     * @param codigoProducto Código del producto.
     * @param cantidad Cantidad de artículos.
     * @param precio Precio unitario.
     * @param Tipo Tipo de factura.
     */
    public Factura(int numeroFactura, String nombre, String fecha, String Estado, int codigoArticulo,int codigoProducto, int cantidad, int precio,String Tipo) {
        this.numeroFactura = numeroFactura;
        this.nombre = nombre;
        this.fecha = fecha;
        this.Estado = Estado;
        this.codigoArticulo = codigoArticulo;
        this.codigoProducto=codigoProducto;
        this.cantidad = cantidad;
        this.precio=precio;
        this.Tipo=Tipo;
        registro.ProductosArchivo(reg.leer("tiposProductos"));
        registro.ArticulosArchivo(reg.leer("Articulos"));
        
    }

    /**
     * Calcula el precio unitario del artículo basado en el código del artículo.
     * 
     * @return Precio unitario del artículo.
     */
    public int precioUnitario(){
        int precio=0;
        for(Articulo articulo:registro.getArticulos()){
            int codigoExiste= articulo.getCodigo();
            if (codigoExiste==codigoArticulo){
                precio=articulo.getPrecio();
            }
        }
        return precio;
    }
     
    /**
     * Calcula el subtotal de la factura multiplicando la cantidad por el precio unitario.
     * 
     * @return Subtotal de la factura.
     */
    public int calculaSubtotal(){
        int precio=precioUnitario();
        int subtotal= precio*cantidad;
        return subtotal;
    }
    
    /**
     * Calcula el impuesto sobre el artículo en la factura.
     * Utiliza el subtotal y aplica una tasa de impuesto fija.
     * 
     * @return Impuesto sobre el artículo.
     */
    public int calculaImpuestoArticulo(){
        double subtotal=calculaSubtotal();
        double impuesto= subtotal*0.13 ;
        int res= (int) impuesto;
        return res;
    }
    
    /**
     * Calcula el impuesto sobre el servicio en la factura.
     * Utiliza el precio del servicio y aplica una tasa de impuesto fija.
     * 
     * @return Impuesto sobre el servicio.
     */
    public int calculaImpuestoServicio(){
        double impuesto ;
        impuesto = precio*0.13;
        return (int) impuesto;
    }

    // Getters y setters para los atributos
    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String codigoCliente) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getCodigoArticulo() {
        return codigoArticulo;
    }

    public void setCodigoArticulo(int codigoArticulo) {
        this.codigoArticulo = codigoArticulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Archivos getReg() {
        return reg;
    }

    public void setReg(Archivos reg) {
        this.reg = reg;
    }

    public RegistroProductos getRegistro() {
        return registro;
    }

    public void setRegistro(RegistroProductos registro) {
        this.registro = registro;
    }

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }
    
    /**
     * Representación en cadena de la factura.
     * Devuelve una cadena que representa la factura en formato CSV.
     * 
     * @return Cadena que representa la factura.
     */
    @Override
    public String toString() {
        return numeroFactura + "," + nombre + "," + fecha + "," + Estado + "," + codigoArticulo + ","+ codigoProducto +","+ cantidad + "," +precio + ","+Tipo+ ",";
    }
      
}
