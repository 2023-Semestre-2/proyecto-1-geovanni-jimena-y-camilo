package moduloProductos;



/**
 * Clase que representa un artículo en la aplicación.
 * 
 * <p>Un artículo tiene propiedades como código, tipo, nombre, tamaño, marca, precio y cantidad disponible.</p>
 * 
 * @author Jimena Mendez
 */
public class Articulo {

    private int codigo;
    private int codigoTipoProducto;
    private String nombre;
    private String tipo;
    private int tamano;
    private String marca;
    private int precio;
    private int cantidad;
    
    
    
    /**
     * Constructor predeterminado de la clase Articulo.
     */
    public Articulo() {
    }

    
    /**
     * Constructor que crea un artículo con información específica.
     *
     * @param codigo             El código del artículo.
     * @param codigoTipoProducto El código del tipo de producto asociado al artículo.
     * @param nombre             El nombre del artículo.
     * @param tipo               El tipo del artículo.
     * @param tamano             El tamaño del artículo.
     * @param marca              La marca del artículo.
     * @param precio             El precio del artículo.
     * @param cantidad           La cantidad disponible del artículo.
     */
    public Articulo(int codigo,int codigoTipoProducto,String nombre, String tipo, int tamano, String marca, int precio, int cantidad) {
        this.codigo = codigo;
        this.codigoTipoProducto = codigoTipoProducto;
        this.nombre = nombre.trim();
        this.tipo = tipo;
        this.tamano =  tamano;
        this.marca = marca.trim();
        this.precio = precio;
        this.cantidad = cantidad;
        
    }


    // Métodos de configuración (setters)

    /**
     *
     * @param codigo
     */
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @param codigoTipoProducto
     */
    public void setCodigoTipoProducto(int codigoTipoProducto) {
        this.codigoTipoProducto = codigoTipoProducto;
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
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     *
     * @param tamano
     */
    public void setTamano(int tamano) {
        this.tamano = tamano;
    }

    /**
     *
     * @param marca
     */
    public void setMarca(String marca) {
        this.marca = marca;
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
     * @param cantidad
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    // Métodos de obtención (getters)

    /**
     *
     * @return
     */
    
    public int getCodigo() {
        return codigo;
    }

    /**
     *
     * @return
     */
    public int getCodigoTipoProducto() {
        return codigoTipoProducto;
    }

    /**
     *
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *
     * @return
     */
    public String getTipo() {
        return tipo;
    }

    /**
     *
     * @return
     */
    public int getTamano() {
        return tamano;
    }

    /**
     *
     * @return
     */
    public String getMarca() {
        return marca;
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
     * @return
     */
    public int getCantidad() {
        return cantidad;
    }
    
    /**
     * Convierte el objeto Articulo en una representación de cadena.
     *
     * @return Una cadena que representa el objeto Articulo.
     */
    
    @Override
    public String toString() {
        return codigo + "," + codigoTipoProducto + "," + nombre + "," + tipo + "," + tamano + "," + marca + "," + precio + "," + cantidad+",";
    }
    
    

}
