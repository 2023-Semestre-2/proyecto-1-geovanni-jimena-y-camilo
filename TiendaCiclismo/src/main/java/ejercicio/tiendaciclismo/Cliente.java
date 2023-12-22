
package ejercicio.tiendaciclismo;
import java.io.Serializable; //Libreria para serializar objetos

public class Cliente implements Serializable {
    
    int codigo = 1;
    String nombre;
    String apellidos;
    int telefono;
    String correo;
    String provincia;
    String canton;
    String distrito;
    String fechaNacimiento;

    public Cliente(int codigo, String nombre, String apellidos, int telefono, String correo, String provincia, String canton, String distrito, String fechaNacimiento) {
        this.codigo = codigo++;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.fechaNacimiento = fechaNacimiento;
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

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
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

    @Override
    public String toString() {
        return "Cliente{" + "codigo=" + codigo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono=" + telefono + ", correo=" + correo + ", provincia=" + provincia + ", canton=" + canton + ", distrito=" + distrito + ", fechaNacimiento=" + fechaNacimiento + '}';
    }
    
    public String toNameCode(){
        return codigo + '/' + nombre;
    }
    
    
}
