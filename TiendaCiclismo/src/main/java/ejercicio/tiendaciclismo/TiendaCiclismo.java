/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ejercicio.tiendaciclismo;

import java.text.ParseException;



/**
 *
 * @author luisc
 */
public class TiendaCiclismo {

    public static void main(String[] args) throws ParseException{
        //UsuarioVentana ventana=new UsuarioVentana();
        //ventana.setVisible(true);
       
        Archivos file=new Archivos();
        RegistroFacturacion registro=new RegistroFacturacion();
        
        registro.FacturasArchivo(file.leer("Facturas"));
        
        registro.agregarFactura(5, "11/06/25", "Válido", 0, "");
        
        System.out.println(file.leer("Facturas"));
    }
}
