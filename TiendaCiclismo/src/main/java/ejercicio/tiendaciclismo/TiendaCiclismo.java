/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ejercicio.tiendaciclismo;

/**
 *
 * @author luisc
 */
public class TiendaCiclismo {

    public static void main(String[] args) {
        RegistroProductos reg1= new RegistroProductos();
        
        reg1.agregarTipoProducto("Jimena");
        
        System.out.println(reg1.toString());
        
        ProductosVentana v1 = new ProductosVentana();
        v1.setVisible(true);
        
    
    }
}
