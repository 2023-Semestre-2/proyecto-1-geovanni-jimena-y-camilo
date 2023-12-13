
package ejercicio.tiendaciclismo;


public class TipoProducto {
    private int codigo;
    private String nombre;

    public TipoProducto(int codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre.trim();
    }


    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }
    @Override
    public String toString() {
        return codigo++ + ","+ nombre;
    }
}
