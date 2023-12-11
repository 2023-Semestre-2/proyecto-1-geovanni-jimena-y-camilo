/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

/**
 *
 * @author geova
 */
public class Cliente {
    
    int codigo;
    String nombre;
    String apellidos;
    String telefono;
    String correo;
    String provincia;
    String canton;
    String distrito;
    String fechaNacimiento;

    public Cliente(int codigo, String nombre, String apellidos, String telefono, String correo, String provincia, String canton, String distrito, String fechaNacimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
        this.provincia = provincia;
        this.canton = canton;
        this.distrito = distrito;
        this.fechaNacimiento = fechaNacimiento;
    }
    
    
    
}
