
package moduloClientes;
import java.io.Serializable; //Libreria para serializar objeto

/**
 *Clase de cliente
 * @author geova
 */
public class Cliente implements Serializable {
    
    private int codigo;
    private String nombre;
    private String apellidos;
    private String telefono;
    private String correo;
    private String provincia;
    private String canton;
    private String distrito;
    private String fechaNacimiento;
    private boolean facturado;
    
    /**
     * Constructor del cliente
     * @param codigo codigo del cliente
     * @param nombre nombre del cliente
     * @param apellidos apellidos del cliente
     * @param telefono telefono del cliente
     * @param correo correo del cliente
     * @param provincia provincia del clinete
     * @param canton canton del cliente
     * @param distrito distrito del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     * @param facturado Verifica que si el cliente esta facturado o no (TRUE O FALSE)
     */
    public Cliente(int codigo,String nombre, String apellidos, String telefono, String correo, String provincia, String canton, String distrito, String fechaNacimiento, boolean facturado) {
        this.facturado=facturado;
        this.codigo =codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.fechaNacimiento = fechaNacimiento;
        
    
    }

    /**
     *
     */
    public Cliente() {
    }

    /**
     *
     * @return retorna el codigo del cliente
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *modifica el codigo del cliente
     * @param codigo modifica el codigo del client
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *
     * @return reotrna el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *modifica el nombre del cliente
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *
     * @return retorna los apellidos del ciente
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *modifica los apellidos del cliente
     * @param apellidos 
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *
     * @return retorna el telefono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *modifica el telefono del cliente
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *
     * @return reotrna el correo del cliente
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *Modifica el correo del cliente
     * @param correo 
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     *
     * @return retorna la provincia del cliente
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     *Modifica la provincia del cliente
     * @param provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     *
     * @return retorna el canton del cliente
     */
    public String getCanton() {
        return canton;
    }

    /**
     *Modifica el canton del cliente
     * @param canton
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }

    /**
     *
     * @return retorna el distrito del cliente
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     *Modifica el distrito del cliente
     * @param distrito
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     *
     * @return retorna la fecha de nacimiento del cliente
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     *Modifica la fecha de nacimiento del cliente
     * @param fechaNacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     *
     * @return retorna el estado del cliente
     */
    public boolean isFacturado() {
        return facturado;
    }

    /**
     *Modifica el estado del cliente
     * @param facturado
     */
    public void setFacturado(boolean facturado) {
        this.facturado = facturado;
    }
    
    
    
}
