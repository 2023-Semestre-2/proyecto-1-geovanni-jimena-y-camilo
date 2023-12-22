
package ejercicio.tiendaciclismo;
import java.io.Serializable; //Libreria para serializar objeto

/**
 * Clase cliente
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
    
    /**
     * Construira el objeto
     * @param codigo codgio del cleinte
     * @param nombre nombre del cliente
     * @param apellidos apellido del cliente
     * @param telefono telefono del cliente
     * @param correo correo del cliente
     * @param provincia provincia del cliente
     * @param canton canton del client
     * @param distrito dstrito del cliente
     * @param fechaNacimiento fecha de nacimiento del cliente
     */
    public Cliente(int codigo,String nombre, String apellidos, String telefono, String correo, String provincia, String canton, String distrito, String fechaNacimiento) {
      
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
     * Devolvera el codigo
     * @return Retorna el codigo del cliente
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     *Modifica el codigo del cliente
     * @param codigo Codigo nuevo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     *Devolvera el nombre
     * @return Retorna el nombre del cliente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     *Modifica el nombre del cliente
     * @param nombre Nombre nuevo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     *Devolvera los apellidos
     * @return retorna los apellidos del cliente
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     *Modifica los apellidos del cliente
     * @param apellidos  apellidos nuevos
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     *Devolcera el telefono
     * @return retorna el numero de telefono del cliente
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     *Modifica el numero de telefono
     * @param telefono nuemero de telefono nuevo
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     *Devolvera el correo
     * @return retorna el correo del cliente
     */
    public String getCorreo() {
        return correo;
    }

    /**
     *Modifica el correo
     * @param correo correo electronico del cliente
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devolvera la provincia
     * @return retorna la provincia del liente
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Modifica la provincia del cliente
     * @param provincia nueva provincia 
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    /**
     *Devolvera el canton
     * @return retorna el canton del cliente
     */
    public String getCanton() {
        return canton;
    }

    /**
     * Modifica el canton del cliente
     * @param canton nuevo canton
     */
    public void setCanton(String canton) {
        this.canton = canton;
    }

    /**
     *Devolvera el distrito
     * @return retorna el distrito del cliente
     */
    public String getDistrito() {
        return distrito;
    }

    /**
     * Modifica el distrito del cliente
     * @param distrito nuevo distrito
     */
    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    /**
     *Devolvera la fecha de nacimiento
     * @return retorna la fecha de nacimiento del cliente
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Modifica la fecha de nacimiento
     * @param fechaNacimiento nueva fecha de nacimiento
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
}
