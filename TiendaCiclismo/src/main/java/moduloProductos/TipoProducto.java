
package moduloProductos;

/**
 *
 * @author geova
 */
public class TipoProducto {
    private int codigo;
    private String nombre;

    /**
     *
     * @param codigo
     * @param nombre
     */
    public TipoProducto(int codigo,String nombre) {
        this.codigo = codigo;
        this.nombre = nombre.trim();
    }

    /**
     *
     * @param codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
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
     * @return
     */
    public int getCodigo() {
        return codigo;
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
    @Override
    public String toString() {
        return codigo + ","+ nombre+ ",";
    }
}
