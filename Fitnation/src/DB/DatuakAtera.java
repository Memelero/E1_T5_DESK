package DB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import Modelo.Usuario;

public class DatuakAtera {
	
	private Firestore db;
	private ArrayList<Usuario> listaUsuarios; 
	
	public DatuakAtera(){
		try {
			this.db = Konexioa.conectar();
			this.listaUsuarios = new ArrayList<>(); 
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void mCargarPersonas(String accion) {
		mLimpiarUsuarios(); 

		listaUsuarios = mObtenerUsuarios(); 

		String matrizInfo[][] = new String[listaUsuarios.size()][4];

		for (int i = 0; i < listaUsuarios.size(); i++) {
			matrizInfo[i][0] = listaUsuarios.get(i).getNombre();
			matrizInfo[i][1] = listaUsuarios.get(i).getApellido();
			matrizInfo[i][2] = listaUsuarios.get(i).getEmail();
			matrizInfo[i][3] = (listaUsuarios.get(i).getFNacimiento() != null) ? listaUsuarios.get(i).getFNacimiento().toString() : "No hay datos";
			//lo que hace la anterior linea es: Primero verifica si el valor no es null (en esa posicion)
			// si esa condicion es verdadera, se ejecutara la parte antes de ":", k basicamente convierte Date a String
			// si fNacimiento es null se ejecutara lo de despues de ":" y saldra un mensaje diciendo ese dato esta vacio
		
		} 

		/*	
		switch (accion) {
			case CARGAR_PANEL_CONSULTA:
				this.vistaPrincipal.getPanelConsultar().getDefaultTableModel().addRow(matrizInfo[i]);
				break;
		}
		*/
	}
	
	private ArrayList<Usuario> mObtenerUsuarios() {
		ArrayList<Usuario> listaUsuarios = new ArrayList<>();
		try {
			ApiFuture<QuerySnapshot> query = db.collection("usuarios").get();
			QuerySnapshot querySnapshot = query.get();
			for (QueryDocumentSnapshot doc : querySnapshot.getDocuments()) { //para cada documento pilla los campos correspondientes a Usuario
				String nombre = doc.getString("nombre");
				String apellido = doc.getString("apellido");
				String contraseña = doc.getString("contraseña"); 
				String email = doc.getString("email");
				Date fNacimiento = doc.getDate("fNacimiento");

				// Objetu bat sortu eta zerrendara gehitu
				Usuario usuario = new Usuario(nombre, apellido, contraseña, email, fNacimiento);
				listaUsuarios.add(usuario);
			}   
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listaUsuarios;
	}
	
	private void mLimpiarUsuarios() {
		listaUsuarios.clear(); 
	}

	public ArrayList<Usuario> getListaUsuarios() {
		
		return listaUsuarios;
	}
}
