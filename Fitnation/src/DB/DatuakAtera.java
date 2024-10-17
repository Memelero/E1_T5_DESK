package DB;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;

import com.google.api.core.ApiFuture;
import java.util.Date;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

import Modelo.Usuario;

public class DatuakAtera {
	
	private Firestore db;
	
	
	public DatuakAtera(){
		try {
			this.db = Konexioa.conectar();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void mCargarPersonas(String accion) {

		mLimpiarUsuarios();
		

		ArrayList<Usuario> listaUsuarios = mObtenerUsuarios();

		String matrizInfo[][] = new String[listaUsuarios.size()][4];

		for (int i = 0; i < listaUsuarios.size(); i++) {
			matrizInfo[i][0] = listaUsuarios.get(i).getNombre();
			matrizInfo[i][1] = listaUsuarios.get(i).getApellido();
			matrizInfo[i][2] = listaUsuarios.get(i).getEmail();
			matrizInfo[i][3] = listaUsuarios.get(i).getFNacimiento() != null ? listaUsuarios.get(i).getFNacimiento().toString() : "N/A";;

			
		// aqui logica para agregar filas nuevas
			switch (accion) {
			case CARGAR_PANEL_CONSULTA:
				this.vistaPrincipal.getPanelConsultar().getDefaultTableModel().addRow(matrizInfo[i]);
				break;
			
			}
		}

	}
	
		private ArrayList<Usuario> mObtenerUsuarios(){
			ArrayList<Usuario> listaUsuarios = new ArrayList<>();
			try {
				ApiFuture<QuerySnapshot> query = db.collection("usuarios").get();
				QuerySnapshot querySnapshot = query.get();
				for(QueryDocumentSnapshot doc : querySnapshot.getDocuments()) {
					String nombre = doc.getString("nombre");
					String apellido = doc.getString("apellido");
					int contraseña = doc.getLong("contraseña").intValue();
					String email = doc.getString("email");
					
					Date fNacimiento = doc.getDate("fNacimiento");
				
					Usuario usuario = new Usuario(nombre, apellido, contraseña, email, fNacimiento);
					listaUsuarios.add(usuario);
				
				
				}	
			}catch (Exception e) {
				e.printStackTrace();
			}
			return listaUsuarios;
		}
		
		private void mLimpiarUsuarios() {
			
		}
			
		

}
