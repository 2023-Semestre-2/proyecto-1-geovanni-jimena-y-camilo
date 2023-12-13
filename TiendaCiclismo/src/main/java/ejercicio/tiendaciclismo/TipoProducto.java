/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.io.Serializable;

/**
 *
 * @author luisc
 */
public class TipoProducto implements Serializable {
    private String nombre;
    private int codigo;

    public TipoProducto(String nombre, int codigo) {
        this.nombre = nombre.trim();
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "TipoProducto{" + "nombre=" + nombre + ", codigo=" + codigo + '}';
    }
    
   
    
    
    
    
}
