
package moduloClientes;
import java.io.Serializable; //Libreria para serializar objeto

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

    public Cliente() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCanton() {
        return canton;
    }

    public void setCanton(String canton) {
        this.canton = canton;
    }

    public String getDistrito() {
        return distrito;
    }

    public void setDistrito(String distrito) {
        this.distrito = distrito;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public boolean isFacturado() {
        return facturado;
    }

    public void setFacturado(boolean facturado) {
        this.facturado = facturado;
    }
    
    
    
}
