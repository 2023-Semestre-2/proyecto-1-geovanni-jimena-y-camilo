/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio.tiendaciclismo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


/**
 *
 * @author Eliecer Fitoria
 */
public class LeerUsuario {
    
      private ArrayList<String> arrayUsers;

       public LeerUsuario() {
        arrayUsers = new ArrayList<>();
    }

    public boolean verifyUser(String usuario, String password) {
        for (String userCredentials : arrayUsers) {
            String[] usersCredentials = userCredentials.split(",");
            if (usersCredentials.length == 2 && usersCredentials[0].equals(usuario) && usersCredentials[1].equals(password)) {
                return true;
            }
        }
        return false;
    }

    public void readFileLine(String path) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line = br.readLine();

            while (line != null) {
                arrayUsers.add(line);
                line = br.readLine();
            }
        }
    }

    public void initializeUsers(String filePath) throws IOException {
        readFileLine(filePath);
    }
    
}