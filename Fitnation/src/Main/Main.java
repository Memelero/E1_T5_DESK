package Main;

import com.google.cloud.firestore.Firestore;

import DB.DatuakAtera;
import DB.Konexioa;
import Modelo.Usuario;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        try {
            Firestore db = Konexioa.conectar();

            if (db != null) {
                System.out.println("FUNCIONA");
                
                // Instanciar DatuakAtera y cargar usuarios
                DatuakAtera datuakAtera = new DatuakAtera();
                datuakAtera.mCargarPersonas("CARGAR"); // Puedes pasar un valor adecuado para 'accion'

                // Obtener la lista de usuarios y mostrarlos
                ArrayList<Usuario> usuarios = datuakAtera.getListaUsuarios(); // Asegúrate de tener este método en DatuakAtera

                // Imprimir los usuarios
                for (Usuario usuario : usuarios) {
                    System.out.println("Nombre: " + usuario.getNombre() + ", Apellido: " + usuario.getApellido() +
                                       ", Email: " + usuario.getEmail() + ", Fecha de Nacimiento: " + usuario.getFNacimiento());
                }

            } else {
                System.out.println("NO FUNCIONA");
            }
        } catch (Exception e) {
            System.out.println("NO FUNCIONA");
            e.printStackTrace();
        }
    }
}
