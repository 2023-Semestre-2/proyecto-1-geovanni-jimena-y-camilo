
package ejercicio.tiendaciclismo;

import java.util.ArrayList;
import java.util.List;
import ejercicio.tiendaciclismo.AgregarClienteVentana;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OperacionesCliente  {
    
    private ArrayList<Cliente> listaClientes = new ArrayList<Cliente>();

    public OperacionesCliente() {
    }
     
     
     
    public void guardarClienteCSV(Cliente cliente){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Clientes.csv", true))) {
            // Agregar el nuevo cliente al archivo CSV
            writer.write(cliente.toString());
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error al escribir" + e.getMessage());
        }
    }
    
 
    
     
}
