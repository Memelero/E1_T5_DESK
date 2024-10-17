package Main;

import com.google.cloud.firestore.Firestore;

import DB.Konexioa;

public class Main {

	public static void main(String[] args) {
		try {
			Firestore db = Konexioa.conectar();
			
			if(db != null) {
				System.out.println("FUNCIONA");
			} else {
				System.out.println("NO FUNCIONA");
			}
		}catch (Exception e) {
			System.out.println("NO FUNCIONA");
			e.printStackTrace();
		}

	}

}
