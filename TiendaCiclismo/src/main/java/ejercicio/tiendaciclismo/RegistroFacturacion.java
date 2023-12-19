/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class RegistroFacturacion {
    private ArrayList<Factura> facturas= new ArrayList<>();
    private Archivos reg = new Archivos();
    private RegistroProductos registro = new RegistroProductos();
    
    
    public void FacturasArchivo(String data) throws ParseException{
        StringReader stringReader = new StringReader(data);
        BufferedReader bufferedReader = new BufferedReader(stringReader);
        
        try {
            String linea;
            while ((linea = bufferedReader.readLine()) != null) {
                // Dividir cada línea en partes utilizando " " como delimitador.
                String[] partes = linea.split(","); 
                int numFactura = Integer.parseInt(partes[0].trim());
                int codigoCliente= Integer.parseInt(partes[1].trim());
                
                SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
                Date fecha = formatoFecha.parse(partes[2].trim());
                
                String Estado= partes[3].trim();
                int codigoArticulo = Integer.parseInt(partes[4].trim());
                int codigoProducto = Integer.parseInt(partes[5].trim());
                int cantidad = Integer.parseInt(partes[6].trim());
                        
                        
                
                // Crear un objeto ObjetoDatos y agregarlo a la lista.
                Factura objeto = new Factura(numFactura, codigoCliente,fecha,Estado,codigoArticulo,codigoProducto,cantidad,0);
                facturas.add(objeto);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el StringBuilder: " + e.getMessage());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar el BufferedReader: " + e.getMessage());
            }
        }
        
    }
    
    public void agregarFactura(int codigoCliente, String fecha, String estado,int cantidad, String articulo){
        try{
            int numeroFactura = facturas.size() + 1;
        
            for(Factura objeto:facturas){
                int numExiste=objeto.getNumeroFactura();
                if (numExiste==numeroFactura){
                    numeroFactura++;
                }
            }
        
            if(facturas.getLast().getNumeroFactura()>numeroFactura){
                numeroFactura=facturas.getLast().getNumeroFactura()+1;
                if (numeroFactura==(facturas.getLast().getNumeroFactura())){
                    numeroFactura++;
                }
            }
        
            int codigoArticulo=0;
            int codigoProducto=0;
            //Hay que obtener el codigo que tiene ese nombre del articulo
            for (Articulo objeto:registro.getArticulos()){
                String nombre=objeto.getNombre();
                if(nombre.equals(articulo)){
                    codigoArticulo=objeto.getCodigo();
                    codigoProducto=objeto.getCodigoTipoProducto();
                }
            }
            
            SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yy");
            Date fechaBuena = formatoFecha.parse(fecha);
        
            // Crear el objeto factura
            Factura factura=new Factura(numeroFactura,codigoCliente, fechaBuena, estado, codigoArticulo,codigoProducto, cantidad,0);
            reg.escrituraFactura(factura, true);
            facturas.add(factura);
            
            
            }catch (ParseException e) {
                System.err.println(e.getMessage());
         }
    }
    
    public void anularFactura(int numeroFactura){
        try{
            //Revisar cual factura tiene ese numero
            String lineaPasada = null;
            String lineaActual = null;
            for (Factura factura:facturas){
                int numeroExistente=factura.getNumeroFactura();
                if (numeroExistente==numeroFactura){
                    lineaPasada=factura.toString();
                    factura.setEstado("Anulado");
                    lineaActual=factura.toString();
                    break;
                }
            }
            
            //Eliminar la linea del archivo
            
            reg.modificarEscritura(lineaActual, lineaPasada, "Facturas");
            
        }catch (Exception e) {
                System.err.println(e.getMessage());
        }
    }

    public ArrayList<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(ArrayList<Factura> facturas) {
        this.facturas = facturas;
    }
    
    
    
    
}


