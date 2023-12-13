/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.Buffer;

/**
 *
 * @author Eliecer Fitoria
 */
public class Archivos {

    Articulo a;

    public Archivos() {
        a = new Articulo();
    }

    public void escrituraArticulo(String nombre, String apellido, int edad, String marca, double precio, int cantidad, String doc, boolean sobreescritura) {
        try {
            FileWriter archivo = new FileWriter(doc + ".acc", sobreescritura);
            BufferedWriter flujo = new BufferedWriter(archivo);
            PrintWriter escribir = new PrintWriter(flujo);
            escribir.println(new Articulo(nombre, apellido, edad, marca, precio, cantidad));
            escribir.flush();

        } catch (Exception e) {
            System.err.println("Error al escribir" + e.getMessage());
            
        }
            
    }
        
}

 
