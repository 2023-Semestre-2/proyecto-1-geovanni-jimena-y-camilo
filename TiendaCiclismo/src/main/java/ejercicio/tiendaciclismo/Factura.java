/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.util.Date;


public class Factura {
    private int numeroFactura;
    private int codigoCliente;
    private Date fecha;
    private String Estado;
    private int codigoArticulo;
    private int codigoProducto;
    private int cantidad;
    private Archivos reg = new Archivos();
    private RegistroProductos registro = new RegistroProductos();

    public Factura() {
    }



    public Factura(int numeroFactura, int codigoCliente, Date fecha, String Estado, int codigoArticulo,int codigoProducto, int cantidad) {
        this.numeroFactura = numeroFactura;
        this.codigoCliente = codigoCliente;
        this.fecha = fecha;
        this.Estado = Estado;
        this.codigoArticulo = codigoArticulo;
        this.codigoProducto=codigoProducto;
        this.cantidad = cantidad;
        registro.ProductosArchivo(reg.leer("tiposProductos"));
        registro.ArticulosArchivo(reg.leer("Articulos"));
        
    }


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
            
    public int calculaSubtotal(){
        int precio=precioUnitario();
        int subtotal= precio*cantidad;
        return subtotal;
    }
    
    public int calculaImpuesto(){
        double subtotal=calculaSubtotal();
        double impuesto= subtotal*0.13 ;
        int res= (int) impuesto;
        return res;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(int codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
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
    
    
    
    @Override
    public String toString() {
        return numeroFactura + "," + codigoCliente + "," + fecha + "," + Estado + "," + codigoArticulo + ","+ codigoProducto +","+ cantidad + "," ;
    }
      
}
