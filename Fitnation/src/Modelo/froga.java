package Modelo;

public class froga {
	
	public Contacto mObtenerUsuario(int idContacto) {
		Firestore co =null;
		
		try {			
			co= Conexion.conectar();
			
			DocumentSnapshot contacto = co.collection(collectionName).document(String.valueOf(idContacto)).get().get();
			
			setIdContacto(contacto.getId());
			setNombre(contacto.getString(fieldNombre));
			setTelefono(contacto.getDouble(fieldTelefono));
			setEmail(contacto.getString(fieldEmail));
			
			
		} catch ( InterruptedException | ExecutionException e) {
			System.out.println("Error: Clase Contacto, metodo mObtenerContactos");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return this;
	}

}
