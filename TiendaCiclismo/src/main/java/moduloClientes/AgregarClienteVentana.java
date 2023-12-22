
package moduloClientes;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/** Ventana para agregar clientes nuevo
 * @author geova
 */
public class AgregarClienteVentana extends javax.swing.JFrame {


    OperacionesCliente operacion= new OperacionesCliente();
    
    /**Inicializa la ventana de agregar los clientes
     *
     */
    public AgregarClienteVentana() {
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    /**
     * Verifica que el numero de telefono comience con alguno de los siguientes numeros(2,4,6,8)
     * @param texto String de numeros
     * @return Regresa True o False
     */
    private static boolean verificarNumero(String texto) {
        // Verificar si el texto comienza con 2, 4, 6 u 8
        return texto.startsWith("2") || texto.startsWith("4") || texto.startsWith("6") || texto.startsWith("8");
    }
    
    /**
     *Valida que el correo ingresado tenga el formato correcto (unejemplo@mail.com)
     * @param correo Correo electronico
     * @return True o False
     */
    public static boolean validarCorreo(String correo) {
        // Expresión regular simple para validar direcciones de correo electrónico
        String regex = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(correo);

        return matcher.matches();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        textApellidos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        textTelefono = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        textCorreo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        comboxProvincia = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        comboxCanton = new javax.swing.JComboBox<>();
        comboxDistrito = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        botonTerminar = new javax.swing.JButton();
        dateNacimiento = new com.toedter.calendar.JDateChooser();
        botonVolver = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("NOMBRE");

        textNombre.setForeground(new java.awt.Color(153, 153, 153));
        textNombre.setText("Ingrese su nombre");
        textNombre.setToolTipText("Ingrese su nombre (solo letras)");
        textNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textNombreFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textNombreFocusLost(evt);
            }
        });
        textNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNombreActionPerformed(evt);
            }
        });
        textNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textNombreKeyTyped(evt);
            }
        });

        jLabel2.setText("APELLIDOS");

        textApellidos.setForeground(new java.awt.Color(153, 153, 153));
        textApellidos.setText("Ingrese sus apellidos");
        textApellidos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textApellidosFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textApellidosFocusLost(evt);
            }
        });
        textApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textApellidosKeyTyped(evt);
            }
        });

        jLabel3.setText("TELEFONO");

        textTelefono.setForeground(new java.awt.Color(153, 153, 153));
        textTelefono.setText("Solo inicia (2,4,6,8)");
        textTelefono.setToolTipText("El numero debe iniciar con (2,4,6,8)");
        textTelefono.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textTelefonoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textTelefonoFocusLost(evt);
            }
        });
        textTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textTelefonoActionPerformed(evt);
            }
        });
        textTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textTelefonoKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textTelefonoKeyTyped(evt);
            }
        });

        jLabel4.setText("CORREO");

        textCorreo.setForeground(new java.awt.Color(153, 153, 153));
        textCorreo.setText("un@ejemplo.com");
        textCorreo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                textCorreoFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                textCorreoFocusLost(evt);
            }
        });
        textCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textCorreoActionPerformed(evt);
            }
        });

        jLabel5.setText("PROVINCIA");

        comboxProvincia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Alajuela", "Cartago", "Guanacaste", "Heredia", "Limón", "Puntarenas", "San José" }));
        comboxProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxProvinciaActionPerformed(evt);
            }
        });

        jLabel6.setText("CANTON");

        jLabel7.setText("DISTRITO");

        comboxCanton.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        comboxCanton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxCantonActionPerformed(evt);
            }
        });

        comboxDistrito.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        comboxDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboxDistritoActionPerformed(evt);
            }
        });

        jLabel8.setText("FECHA DE NACIMIENTO");

        botonTerminar.setText("TERMINAR");
        botonTerminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonTerminarActionPerformed(evt);
            }
        });

        dateNacimiento.setDateFormatString("dd/MM/yyyy");
        dateNacimiento.setMaxSelectableDate(new java.util.Date(253370790068000L));

        botonVolver.setText("Volver");
        botonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonVolverActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botonTerminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(textNombre, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                            .addComponent(textApellidos, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textTelefono, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textCorreo, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(dateNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboxCanton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(comboxDistrito, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(47, 47, 47))))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonVolver)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboxProvincia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textApellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboxCanton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboxDistrito, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(textCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateNacimiento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botonTerminar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    /**
     * Crea el cliente y lo añade a la tabla
     * @param evt Evento
     */
    private void botonTerminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonTerminarActionPerformed
        
        ArchivosClientes arch= new ArchivosClientes();

        
        SimpleDateFormat fecha= new SimpleDateFormat("dd/MM/yyyy");
     
        //Se asignan las variables
        String nombreCliente= textNombre.getText();
        String apellidosCliente= textApellidos.getText();
        String telefono=textTelefono.getText();
        String correo=textCorreo.getText();
        String provincia=(String) comboxProvincia.getSelectedItem();
        String canton= (String)comboxCanton.getSelectedItem();
        String distrito= (String)comboxDistrito.getSelectedItem();    
        String fechaNacimiento ;
        fechaNacimiento=fecha.format(dateNacimiento.getDate());
        
        if ("Ingrese su nombre".equals(nombreCliente) || "Ingrese sus apellidos".equals(apellidosCliente) || "Solo inicia (2,4,6,8)".equals(telefono) || "un@ejemplo.com".equals(correo) || "Seleccione".equals(provincia) 
                || "Seleccione".equals(canton) || "Seleccione".equals(distrito)||fechaNacimiento.isEmpty()){
            JOptionPane.showMessageDialog(null, "Por favor llenar todas las casillas correctamente", "Error", JOptionPane.ERROR_MESSAGE);
            }else {
                   if ( telefono.length() < 8 ){
                       JOptionPane.showMessageDialog(null, "El numero debe ser de 8 digitos", "Error", JOptionPane.ERROR_MESSAGE);
                        
                   }else{
                        if (!verificarNumero(telefono)){
                               JOptionPane.showMessageDialog(null, "El numero de telefono debe empezar con (2,4,6,8)", "Error", JOptionPane.ERROR_MESSAGE);
                            }else{
                                if (nombreCliente!=nombreCliente.trim()){
                                JOptionPane.showMessageDialog(null, "Hay espacios vacios en los extremos del nombre", "Error", JOptionPane.ERROR_MESSAGE);

                                }else{
                                    if (apellidosCliente != apellidosCliente.trim()){
                                    JOptionPane.showMessageDialog(null, "Hay espacios vacios en los extremos de los apellidos", "Error", JOptionPane.ERROR_MESSAGE);
                       
                                    }else{
                                        if (correo != correo.trim()){
                                        JOptionPane.showMessageDialog(null, "Hay espacios vacios en los extremos de el correo", "Error", JOptionPane.ERROR_MESSAGE);
                                        }else{
                                            if (!validarCorreo(correo)){
                                            JOptionPane.showMessageDialog(null, "Formato invalido del correo", "Error", JOptionPane.ERROR_MESSAGE);

                                            }else{
                                                try {
                                            
                                            operacion.ClientesArchivo(arch.leer("Clientes.csv"));
                                            operacion.AgregarCliente(nombreCliente, apellidosCliente, telefono, correo, provincia, canton, distrito, fechaNacimiento);
                                            System.out.println("El tamaño de la lista de los clientes es :"+Integer.toString(operacion.listaClientes.size()));
                                            
                                            
                    
                                            ClientesVentana ventana = new ClientesVentana();
                                            JTable tabla= ventana.obtenerTabla();
                                            ventana.limpiarTabla(tabla);
                                            ventana.iniciarTablas(operacion.listaClientes);
                                            ventana.setVisible(true);
                                            this.setVisible(false);
                                            
                                            } catch (IOException ex) {
                                            Logger.getLogger(AgregarClienteVentana.class.getName()).log(Level.SEVERE, null, ex);
                                            }
                                            }
        
                                        }
                                    }
                                }
                        }
                   }
        }
                   
                        
        
    }//GEN-LAST:event_botonTerminarActionPerformed

    private void textCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textCorreoActionPerformed

    private void comboxDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxDistritoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboxDistritoActionPerformed
    
    /**
     * Selecciona la provincia del cliente
     * @param evt Evento
     */
    private void comboxProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxProvinciaActionPerformed
       String provincia = (String) comboxProvincia.getSelectedItem();
       
       if ("Limón".equals(provincia)){
           String [] listaCantonesLimon = {"Pococí","Guácimo","Siquirres","Matina","Limón","Talamanca"};
           comboxCanton.removeAllItems();
           for (int indice=0 ; listaCantonesLimon.length != indice; indice++)
               comboxCanton.addItem(listaCantonesLimon[indice]);
       }
       if ("San José".equals(provincia)){
           String [] listaCantonesSanJose = {"San José","Escazú","Desamparados",
                                           "Puriscal","Tarrazú","Aserrí","Mora","Goicoechea",
                                           "Santa Ana", "Alajuelita","Vásquez de Coronado",
                                            "Acosta","Tibás","Montes de Oca","Turrubares","Dota",
                                              "Curridabat","Pérez Zeledón","León Cortés Castro"};
            comboxCanton.removeAllItems();
           for (int indice=0 ; listaCantonesSanJose.length != indice; indice++)
               comboxCanton.addItem(listaCantonesSanJose[indice]);
       }
       if ("Alajuela" == provincia){
           String [] listaCantonesAlajuela = {"Alajuela", "San Ramón", "Grecia", "San Mateo", "Atenas", "Naranjo", "Palmares", "Poás", "Orotina", "Sarchí", "Upala", "Los Chiles", "Guatuso"};
           comboxCanton.removeAllItems();
           for (int indice=0 ; listaCantonesAlajuela.length != indice; indice++)
               comboxCanton.addItem(listaCantonesAlajuela[indice]);
       }
       if ("Cartago" == provincia){
           String [] listaCantonesCartago = {"Cartago", "Paraíso", "La Unión", "Jiménez", "Turrialba", "Alvarado", "Oreamuno", "El Guarco"};
            comboxCanton.removeAllItems();
           for (int indice=0 ; listaCantonesCartago.length != indice; indice++)
               comboxCanton.addItem(listaCantonesCartago[indice]);
       }
       if ("Heredia" == provincia){
           String [] listaCantonesHeredia = {"Heredia", "Barva", "Santo Domingo", "Santa Bárbara", "San Rafael"};
            comboxCanton.removeAllItems();
           for (int indice=0 ; listaCantonesHeredia.length != indice; indice++)
               comboxCanton.addItem(listaCantonesHeredia[indice]);
       }
       if ("Guanacaste" == provincia){
           String [] listaCantonesGuanacaste = {"Liberia", "Nicoya", "Santa Cruz", "Bagaces", "Carrillo", "Cañas", "Abangares", "Tilarán", "Nandayure", "La Cruz", "Hojancha"};
            comboxCanton.removeAllItems();
           for (int indice=0 ; listaCantonesGuanacaste.length != indice; indice++)
               comboxCanton.addItem(listaCantonesGuanacaste[indice]);
       }
       if ("Puntarenas" == provincia){
           String [] listaCantonesPuntarenas = {"Puntarenas", "Esparza", "Buenos Aires", "Montes de Oro", "Osa", "Quepos", "Golfito", "Coto Brus", "Parrita"};
            comboxCanton.removeAllItems();
           for (int indice=0 ; listaCantonesPuntarenas.length != indice; indice++)
               comboxCanton.addItem(listaCantonesPuntarenas[indice]);
       }
       
       
    }//GEN-LAST:event_comboxProvinciaActionPerformed
    
    /**
     * Selecciona el cantón del cliente
     * @param evt Evento
     */
    private void comboxCantonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboxCantonActionPerformed
       String canton = (String) comboxCanton.getSelectedItem();
       if ("Limón" == canton){
           String [] listaDistritosLimon = {"Limón", "Valle La Estrella", "Río Blanco", "Matama"};
            comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosLimon.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosLimon[indice]);
       }
       if ("Pococí" == canton){
           String [] listaDistritosPococi = {"Guápiles", "Jiménez", "La Colonia", "Rita", "Roxana", "Cariari", "Colorado"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosPococi.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosPococi[indice]);
       }
       if ("Siquirres" == canton){
           String [] listaDistritosSiquirres = {"Siquirres", "Pacuarito", "Florida", "Germania", "Cairo"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosSiquirres.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosSiquirres[indice]);
       }
       if ("Talamanca" == canton){
           String [] listaDistritosTalamanca = {"Bribri", "Sixaola", "Cahuita", "Bratsi"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosTalamanca.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosTalamanca[indice]);
       }
       if ("Matina" == canton){
           String [] listaDistritosMatina = {"Matina", "Batán", "Carrandí"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosMatina.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosMatina [indice]);
       }
       
       if ("Guácimo" == canton){
           String [] listaDistritosGuacimo = {"Guácimo", "Duacarí", "Jiménez", "Río Jiménez", "Rita", "Colorado"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosGuacimo.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosGuacimo [indice]);
       }
       if ("San José" == canton){
           String [] listaDistritosSanJose = {"Carmen", "Merced", "Hospital", "Catedral", "Zapote", "San Francisco de Dos Ríos", "Uruca", "Mata Redonda", "Pavas", "Hatillo", "San Sebastián"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosSanJose.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosSanJose [indice]);
       }
       if ("Escazú" == canton){
           String [] listaDistritosEscazú = {"Escazú", "San Antonio", "San Rafael"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosEscazú.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosEscazú [indice]);
       }
       if ("Desamparados" == canton){
           String [] listaDistritosDesamparados = {"Desamparados", "San Miguel", "San Juan de Dios", "San Rafael Arriba", "San Antonio", "Frailes", "Patarrá", "San Cristóbal", "Rosario", "Damas", "San Rafael Abajo", "Gravilias", "Los Guido"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosDesamparados.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosDesamparados [indice]);
       }
       if ("Puriscal" == canton){
           String [] listaDistritosPuriscal = {"Santiago", "Mercedes Sur", "Barbacoas", "Grifo Alto", "San Rafael", "Candelarita", "Desamparaditos", "San Antonio", "Chires"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosPuriscal.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosPuriscal [indice]);
       }
       if ("Tarrazú" == canton){
           String [] listaDistritosTarrazú = {"San Marcos", "San Lorenzo", "San Carlos"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosTarrazú.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosTarrazú [indice]);
       }
       if ("Aserrí" == canton){
           String [] listaDistritosAserrí = {"Aserrí", "Tarbaca", "Vuelta de Jorco", "San Gabriel", "Legua", "Monterrey", "Salitrillos"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosAserrí.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosAserrí [indice]);
        }
       if ("Mora" == canton){
           String [] listaDistritosMora = {"Carmen", "Merced", "Hospital", "Catedral", "Zapote", "San Francisco de Dos Ríos", "Uruca", "Mata Redonda", "Pavas", "Hatillo", "San Sebastián"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosMora.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosMora [indice]);
        }
            if ("Santa Ana" == canton){
           String [] listaDistritosSantaAna = {"Santa Ana", "Salitral", "Pozos", "Uruca", "Piedades", "Brasil"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosSantaAna.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosSantaAna [indice]);
        }
       if ("Goicoechea" == canton){
           String [] listaDistritosGoicoechea = {"Guadalupe", "San Francisco", "Calle Blancos", "Mata de Plátano", "Ipís", "Rancho Redondo", "Purral"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosGoicoechea.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosGoicoechea [indice]);
        }
       if ("Alajuelita" == canton){
           String [] listaDistritosAlajuelita = {"Alajuelita", "San Josecito", "San Antonio", "Concepción", "San Felipe"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosAlajuelita.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosAlajuelita [indice]);
       }
       if ("Vásquez de Coronado" == canton){
           String [] listaDistritosVásquez = {"San Isidro", "San Rafael", "Dulce Nombre de Jesús", "Patalillo", "Cascajal"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosVásquez.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosVásquez [indice]);
       }
       if ("Acosta" == canton){
           String [] listaDistritosAcosta = {"San Ignacio", "Guaitil", "Palmichal", "Cangrejal", "Sabanillas"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosAcosta.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosAcosta [indice]);
       }
       if ("Tibás" == canton){
           String [] listaDistritosTibás = {"San Juan", "Cinco Esquinas", "Anselmo Llorente", "León XIII", "Colima"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosTibás.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosTibás [indice]);
       }
       if ("Moravia" == canton){
           String [] listaDistritosMoravia = {"San Vicente", "San Jerónimo", "La Trinidad"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosMoravia.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosMoravia [indice]);
       }
       if ("Montes de Oca" == canton){
           String [] listaDistritosMontes = {"San Pedro", "Sabanilla", "Mercedes", "San Rafael"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosMontes.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosMontes [indice]);
       }
       if ("Turrubares" == canton){
           String [] listaDistritosTurrubares = {"San Pablo", "San Pedro", "San Juan de Mata", "San Luis", "Carara"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosTurrubares.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosTurrubares [indice]);
       }
       if ("Dota" == canton){
           String [] listaDistritosDota = {"Santa María", "Jardín", "Copey"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosDota.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosDota [indice]);
       }if ("Curridabat" == canton){
           String [] listaDistritosCurridabat = {"Curridabat", "Granadilla", "Sánchez", "Tirrases"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosCurridabat.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosCurridabat [indice]);
       }
       if ("Pérez Zeledón" == canton){
           String [] listaDistritosPérez = {"San Isidro de El General", "General", "Daniel Flores", "Rivas", "San Pedro", "Platanares", "Pejibaye", "Cajón", "Barú", "Río Nuevo", "Páramo", "La Amistad"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosPérez.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosPérez [indice]);
       }
       if ("León Cortés Castro" == canton){
           String [] listaDistritosLeón = {"San Pablo", "San Andrés", "Llano Bonito", "San Isidro", "Santa Cruz", "San Antonio"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosLeón.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosLeón [indice]);
       }
       if ("Alajuela" == canton){
           String [] listaDistritosAlajuela = {"Alajuela", "San José", "Carrizal", "San Antonio", "Guácima", "San Isidro", "Sabanilla", "San Rafael", "Río Segundo", "Desamparados", "Turrúcares", "Tambor", "Garita", "Sarapiquí"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosAlajuela.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosAlajuela [indice]);
       }
       if ("San Ramón" == canton){
           String [] listaDistritosRamón = {"San Ramón", "Santiago", "San Juan", "Piedades Norte", "Piedades Sur", "San Rafael", "San Isidro", "Ángeles", "Alfaro", "Volio", "Concepción", "Zapotal", "Peñas Blancas"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosRamón.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosRamón [indice]);
       }
       if ("Grecia" == canton){
           String [] listaDistritosGrecia = {"Grecia", "San Isidro", "San José", "San Roque", "Tacares", "Río Cuarto", "Puente de Piedra", "Bolívar"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosGrecia.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosGrecia [indice]);
       }
       if ("San Mateo" == canton){
           String [] listaDistritosMateo = {"San Mateo", "Desmonte", "Jesús María", "Labrador"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosMateo.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosMateo [indice]);
       }
       if ("Atenas" == canton){
           String [] listaDistritosTarrazú = {"Atenas", "Jesús", "Mercedes", "San Isidro", "Concepción", "San José", "Santa Eulalia", "Escobal"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosTarrazú.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosTarrazú [indice]);
       }
       if ("Naranjo" == canton){
           String [] listaDistritosNaranjo = {"Naranjo", "San Miguel", "San José", "Cirrí Sur", "San Jerónimo", "San Juan", "El Rosario", "Palmitos"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosNaranjo.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosNaranjo [indice]);
       }
       if ("Palmares" == canton){
           String [] listaDistritosPalmares = {"Palmares", "Zaragoza", "Buenos Aires", "Santiago", "Candelaria", "Esquipulas", "La Granja"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosPalmares.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosPalmares [indice]);
       }
       if ("Poás" == canton){
           String [] listaDistritosPoás = {"San Pedro", "San Juan", "San Rafael", "Carrillos", "Sabana Redonda"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosPoás.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosPoás [indice]);
       }
       if ("Orotina" == canton){
           String [] listaDistritosOrotina = {"Orotina", "El Mastate", "Hacienda Vieja", "Coyolar", "La Ceiba"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosOrotina.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosOrotina [indice]);
       }
       if ("San Carlos" == canton){
           String [] listaDistritosCarlos = {"Quesada", "Florencia", "Buenavista", "Aguas Zarcas", "Venecia", "Pital", "La Fortuna", "La Tigra", "La Palmera", "Venado", "Cutris", "Monterrey", "Pocosol"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosCarlos.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosCarlos [indice]);
       }
       if ("Zarcero" == canton){
           String [] listaDistritosZarcero = {"Zarcero", "Laguna", "Tapezco", "Guadalupe", "Palmira", "Zapote", "Brisas"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosZarcero.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosZarcero [indice]);
       }
       if ("Valverde Vega" == canton){
           String [] listaDistritosValverde = {"Sarchí Norte", "Sarchí Sur", "Toro Amarillo", "San Pedro", "Rodríguez"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosValverde.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosValverde [indice]);
       }
       if ("Upala" == canton){
           String [] listaDistritosUpala = {"Upala", "Aguas Claras", "San José o Pizote", "Bijagua", "Delicias", "Dos Ríos", "Yolillal", "Canalete"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosUpala.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosUpala [indice]);
       }
       if ("Los Chiles" == canton){
           String [] listaDistritosChiles = {"Los Chiles", "Caño Negro", "El Amparo", "San Jorge"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosChiles.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosChiles [indice]);
       }
       if ("Guatuso" == canton){
           String [] listaDistritosGuatuso = {"San Rafael", "Buenavista", "Cote", "Katira"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosGuatuso.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosGuatuso [indice]);
       }if ("Río Cuarto" == canton){
           String [] listaDistritosRío = {"Río Cuarto", "Santa Isabel", "Santa Rita", "Muelle"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosRío.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosRío [indice]);
       }
       if ("Cartago" == canton){
           String [] listaDistritosCartago = {"Oriental", "Occidental", "Carmen", "San Nicolás", "Aguacaliente", "Guadalupe", "Corralillo", "Tierra Blanca", "Dulce Nombre", "Llano Grande", "Quebradilla"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosCartago.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosCartago [indice]);
       }
       if ("Paraíso" == canton){
           String [] listaDistritosParaíso = {"Paraíso", "Santiago", "Orosi", "Cachí", "Llanos de Santa Lucía"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosParaíso.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosParaíso [indice]);
       }
       if ("La Unión" == canton){
           String [] listaDistritosUnión = {"Tres Ríos", "San Diego", "San Juan", "San Rafael", "Concepción", "Dulce Nombre", "San Ramón", "Río Azul"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosUnión.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosUnión [indice]);
       }
       if ("Jiménez" == canton){
           String [] listaDistritosJiménez = {"Juan Viñas", "Tucurrique", "Pejibaye"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosJiménez.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosJiménez [indice]);
       }
       if ("Turrialba" == canton){
           String [] listaDistritosTurrialba = {"Turrialba", "La Suiza", "Peralta", "Santa Cruz", "Santa Teresita", "Pavones", "Tuis", "Tayutic", "Santa Rosa", "Tres Equis", "La Isabel", "Chirripó"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosTurrialba.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosTurrialba [indice]);
       }
       if ("Alvarado" == canton){
           String [] listaDistritosAlvarado = {"Pacayas", "Cervantes", "Capellades"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosAlvarado.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosAlvarado [indice]);
       }
       if ("Oreamuno" == canton){
           String [] listaDistritosOreamuno = {"San Rafael", "Cot", "Potrero Cerrado", "Cipreses", "Santa Rosa"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosOreamuno.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosOreamuno [indice]);
       }
       if ("El Guarco" == canton){
           String [] listaDistritosGuarco = {"El Tejar", "San Isidro", "Tobosi", "Patio de Agua"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosGuarco.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosGuarco [indice]);
       }
       if ("Heredia" == canton){
           String [] listaDistritosHeredia = {"Heredia", "Mercedes", "San Francisco", "Ulloa", "Varablanca"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosHeredia.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosHeredia [indice]);
       }
       if ("Barva" == canton){
           String [] listaDistritosBarva = {"Barva", "San Pedro", "San Pablo", "San Roque", "Santa Lucía", "San José de la Montaña"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosBarva.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosBarva [indice]);
       }
       if ("Santo Domingo" == canton){
           String [] listaDistritosDomingo = {"Santo Domingo", "San Vicente", "San Miguel", "Paracito", "Santo Tomás", "Santa Rosa", "Tures", "Pará"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosDomingo.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosDomingo [indice]);
       }
       if ("Santa Bárbara" == canton){
           String [] listaDistritosBárbara = {"Santa Bárbara", "San Pedro", "San Juan", "Jesús", "Santo Domingo", "Purabá"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosBárbara.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosBárbara [indice]);
       }
       if ("San Rafael" == canton){
           String [] listaDistritosRafael = {"San Rafael", "San Josecito", "Santiago", "Ángeles", "Concepción"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosRafael.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosRafael [indice]);
       }
       if ("San Isidro" == canton){
           String [] listaDistritosIsidro = {"San Isidro", "San José", "Concepción", "San Francisco"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosIsidro.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosIsidro [indice]);
       }
       if ("Belén" == canton){
           String [] listaDistritosBelén = {"San Antonio", "La Ribera", "La Asunción"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosBelén.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosBelén [indice]);
       }
       if ("Flores" == canton){
           String [] listaDistritosFlores = {"San Joaquín", "Barrantes", "Llorente"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosFlores.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosFlores [indice]);
       }
       if ("San Pablo" == canton){
           String [] listaDistritosPablo = {"San Pablo", "Rincón de Sabanilla"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosPablo.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosPablo [indice]);
       }
       if ("Sarapiquí" == canton){
           String [] listaDistritosSarapiquí = {"Puerto Viejo", "La Virgen", "Horquetas", "Llanuras del Gaspar", "Cureña"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosSarapiquí.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosSarapiquí [indice]);
       }
       if ("Liberia" == canton){
           String [] listaDistritosLiberia = {"Liberia", "Cañas Dulces", "Mayorga", "Nacascolo", "Curubandé"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosLiberia.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosLiberia [indice]);
       }
       if ("Nicoya" == canton){
           String [] listaDistritosNicoya = {"Nicoya", "Mansión", "San Antonio", "Quebrada Honda", "Sámara", "Nosara", "Belén de Nosarita"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosNicoya.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosNicoya [indice]);
       }
       if ("Santa Cruz" == canton){
           String [] listaDistritosCruz = {"Santa Cruz", "Bolsón", "Veintisiete de Abril", "Tempate", "Cartagena", "Cuajiniquil", "Diriá", "Cabo Velas", "Tamarindo"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosCruz.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosCruz [indice]);
       }
       if ("Bagaces" == canton){
           String [] listaDistritosBagaces = {"Bagaces", "La Fortuna", "Mogote", "Río Naranjo"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosBagaces.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosBagaces [indice]);
       }
       if ("Carrillo" == canton){
           String [] listaDistritosCarrillo = {"Filadelfia", "Palmira", "Sardinal", "Belén"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosCarrillo.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosCarrillo [indice]);
       }
       if ("Cañas" == canton){
           String [] listaDistritosCañas = {"Cañas", "Palmira", "San Miguel", "Bebedero", "Porozal"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosCañas.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosCañas [indice]);
       }
       if ("Abangares" == canton){
           String [] listaDistritosAbangares = {"Las Juntas", "Sierra", "San Juan", "Colorado"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosAbangares.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosAbangares [indice]);
       }
       if ("Tilarán" == canton){
           String [] listaDistritosTilarán = {"Tilarán", "Quebrada Grande", "Tronadora", "Santa Rosa", "Líbano", "Tierras Morenas", "Arenal", "Cabeceras"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosTilarán.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosTilarán [indice]);
       }
       if ("Nandayure" == canton){
           String [] listaDistritosNandayure = {"Carmona", "Santa Rita", "Zapotal", "San Pablo", "Porvenir", "Bejuco"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosNandayure.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosNandayure [indice]);
       }
       if ("La Cruz" == canton){
           String [] listaDistritosLaCruz = {"La Cruz", "Santa Cecilia", "La Garita", "Santa Elena"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosLaCruz.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosLaCruz [indice]);
       }
       if ("Hojancha" == canton){
           String [] listaDistritosHojancha = {"Hojancha", "Monte Romo", "Puerto Carrillo", "Huacas", "Matambú"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosHojancha.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosHojancha [indice]);
       }
       if ("Puntarenas" == canton){
           String [] listaDistritosPuntarenas = {"Puntarenas", "Pitahaya", "Chomes", "Lepanto", "Paquera", "Manzanillo", "Guacimal", "Barranca", "Monteverde", "Isla del Coco", "Cóbano", "Chacarita", "Chira", "Acapulco", "El Roble", "Arancibia"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosPuntarenas.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosPuntarenas [indice]);
       }
       if ("Esparza" == canton){
           String [] listaDistritosEsparza = {"Espíritu Santo", "San Juan Grande", "Macacona", "San Rafael", "San Jerónimo", "Caldera"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosEsparza.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosEsparza [indice]);
       }
       if ("Buenos Aires" == canton){
           String [] listaDistritosAires = {"Buenos Aires", "Volcán", "Potrero Grande", "Boruca", "Pilas", "Colinas", "Changuena", "Biolley", "Brunka"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosAires.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosAires [indice]);
       }
       if ("Montes de Oro" == canton){
           String [] listaDistritosOro = {"Miramar", "La Unión", "San Isidro"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosOro.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosOro [indice]);
       }
       if ("Osa" == canton){
           String [] listaDistritosOsa = {"Puerto Cortés", "Palmar", "Sierpe", "Bahía Ballena", "Piedras Blancas", "Bahía Drake"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosOsa.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosOsa [indice]);
       }
       if ("Quepos" == canton){
           String [] listaDistritosQuepos = {"Quepos", "Savegre", "Naranjito"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosQuepos.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosQuepos [indice]);
       }
       if ("Golfito" == canton){
           String [] listaDistritosGolfito = {"Golfito", "Guaycará", "Pavón"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosGolfito.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosGolfito [indice]);
       }
       if ("Coto Brus" == canton){
           String [] listaDistritosBrus = {"San Vito", "Sabalito", "Aguabuena", "Limoncito", "Pittier", "Gutiérrez Braun"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosBrus.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosBrus [indice]);
       }
       if ("Parrita" == canton){
           String [] listaDistritosParrita = {"Parrita"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosParrita.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosParrita [indice]);
       }
       if ("Corredores" == canton){
           String [] listaDistritosCorredores = {"Corredor", "La Cuesta", "Canoas", "Laurel"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosCorredores.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosCorredores [indice]);
       }
       if ("Garabito" == canton){
           String [] listaDistritosGarabito = {"Jacó", "Tárcoles"};
           comboxDistrito.removeAllItems();
           for (int indice=0 ; listaDistritosGarabito.length != indice; indice++)
               comboxDistrito.addItem(listaDistritosGarabito [indice]);
       }
       
       
    }//GEN-LAST:event_comboxCantonActionPerformed

    private void textNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNombreActionPerformed

    private void textTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textTelefonoActionPerformed

    private void textTelefonoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTelefonoKeyPressed
        
    }//GEN-LAST:event_textTelefonoKeyPressed
   
    /**
     * Verifica que se permita ingresar solamente digitos
     * @param evt Evento
     */
    private void textTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textTelefonoKeyTyped
        char numero = evt.getKeyChar();
        if (!(Character.isDigit(numero)) || (numero == KeyEvent.VK_BACK_SPACE) || (numero == KeyEvent.VK_DELETE)){
            evt.consume();
        }
         if (textTelefono.getText().length()==8){
        evt.consume();}
         
         
    }//GEN-LAST:event_textTelefonoKeyTyped

    /**
     * Verifica que se permita ingresar solamente letras
     * @param evt Evento
     */
    private void textNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textNombreKeyTyped
        char letra = evt.getKeyChar();
        if ((Character.isDigit(letra)) || (letra == KeyEvent.VK_BACK_SPACE) || (letra == KeyEvent.VK_DELETE)){
            evt.consume();        }
    }//GEN-LAST:event_textNombreKeyTyped

    /**
     * Verifica que se permita ingresar solamente letras
     * @param evt Evento
     */
    private void textApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textApellidosKeyTyped
        char letra = evt.getKeyChar();
        if ((Character.isDigit(letra)) || (letra == KeyEvent.VK_BACK_SPACE) || (letra == KeyEvent.VK_DELETE)){
            evt.consume();        }
    }//GEN-LAST:event_textApellidosKeyTyped
    /**
     * Cuando se enfoca se vacia la caja de texto del telefono
     * @param evt Evento
     */
    private void textTelefonoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textTelefonoFocusGained
        if (textTelefono.getText().equals("Solo inicia (2,4,6,8)")){
        textTelefono.setText("");
        textTelefono.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_textTelefonoFocusGained

    /**
    * Cuando se desenfoca la caja de texto, aparece un mensaje en la caja (Solo inicia (2,4,6,8)
    * @param evt Evento
    */
    private void textTelefonoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textTelefonoFocusLost
        if (textTelefono.getText().equals("")){
            textTelefono.setText("Solo inicia (2,4,6,8)");
            textTelefono.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_textTelefonoFocusLost
    /**
     * Cuando se enfoca se vacia la caja de texto del nombre
     * @param evt Evento
     */
    private void textNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textNombreFocusGained
        if (textNombre.getText().equals("Ingrese su nombre")){
        textNombre.setText("");
        textNombre.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_textNombreFocusGained

    /**
    * Cuando se desenfoca la caja de texto, aparece un mensaje en la caja (Ingrese su nombre)
    * @param evt Evento
    */
    private void textNombreFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textNombreFocusLost
    if (textNombre.getText().equals("")){
        textNombre.setText("Ingrese su nombre");
        textNombre.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_textNombreFocusLost

    /**
    * Cuando se enfoca se vacia la caja de texto del apellido
    * @param evt Evento
    */
    private void textApellidosFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textApellidosFocusGained
       if (textApellidos.getText().equals("Ingrese sus apellidos")){
        textApellidos.setText("");
        textApellidos.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_textApellidosFocusGained

    /**
    * Cuando se desefoca la caja de texto, aparece un mensaje en la caja (ingrese sus apellidos)
    * @param evt Evento
    */
    private void textApellidosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textApellidosFocusLost
        if (textApellidos.getText().equals("")){
        textApellidos.setText("Ingrese sus apellidos");
        textApellidos.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_textApellidosFocusLost

    /**
    * Cuando se enfoca el correo se vacia la caja de texto del correo
    * @param evt Evento
    */
    private void textCorreoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textCorreoFocusGained
        if (textCorreo.getText().equals("un@ejemplo.com")){
        textCorreo.setText("");
        textCorreo.setForeground(new Color(0,0,0));
        }
    }//GEN-LAST:event_textCorreoFocusGained

    /**
    * Cuando se desenfoca la caja de texto, aparece un mensaje (unejemplo@gmail)
    * @param evt Evento
    */
    private void textCorreoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_textCorreoFocusLost
        if (textCorreo.getText().equals("")){
        textCorreo.setText("un@ejemplo.com");
        textCorreo.setForeground(new Color(153,153,153));
        }
    }//GEN-LAST:event_textCorreoFocusLost

    /**
    * Retorna la ventana de clientes
    * @param evt Evento
    */
    private void botonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonVolverActionPerformed
        try {
            ClientesVentana ventana = new ClientesVentana();
            ventana.setVisible(true);
            this.setVisible(false);
        } catch (IOException ex) {
            Logger.getLogger(AgregarClienteVentana.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_botonVolverActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AgregarClienteVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AgregarClienteVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AgregarClienteVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AgregarClienteVentana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AgregarClienteVentana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonTerminar;
    private javax.swing.JButton botonVolver;
    private javax.swing.JComboBox<String> comboxCanton;
    private javax.swing.JComboBox<String> comboxDistrito;
    private javax.swing.JComboBox<String> comboxProvincia;
    private com.toedter.calendar.JDateChooser dateNacimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField textApellidos;
    private javax.swing.JTextField textCorreo;
    private javax.swing.JTextField textNombre;
    private javax.swing.JTextField textTelefono;
    // End of variables declaration//GEN-END:variables
}
