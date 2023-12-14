package ejercicio.tiendaciclismo;

public class Articulo {

    private int codigo;
    private int codigoTipoProducto;
    private String nombre;
    private String tipo;
    private int tamano;
    private String marca;
    private double precio;
    private int cantidad;

    public Articulo() {
    }

    public Articulo(String nombre, String tipo, int tamano, String marca, double precio, int cantidad) {
        this.codigo = 1;
        this.codigoTipoProducto = 1;
        this.nombre = nombre.trim();
        this.tipo = tipo;
        this.tamano = tamano;
        this.marca = marca.trim();
        this.precio = precio;
        this.cantidad = cantidad;
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCodigoTipoProducto(int codigoTipoProducto) {
        this.codigoTipoProducto = codigoTipoProducto;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCodigoTipoProducto() {
        return codigoTipoProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getTamano() {
        return tamano;
    }

    public String getMarca() {
        return marca;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return codigo++ + "," + codigoTipoProducto++ + "," + nombre + "," + tipo + "," + tamano + "," + marca + "," + precio + "," + cantidad;
    }
    
    

}