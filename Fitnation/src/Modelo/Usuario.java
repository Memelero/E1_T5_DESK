package Modelo;

import java.util.Objects;

import com.google.cloud.Date;

public class Usuario {
	
	private static int contadorUsuarios = 0; // Contador estático para llevar el control de los usuarios
	private String idUsuario; // ID único del usuario
	private String nombre;
	private String apellido;
	private int contraseña;
	private String email;
	private Date FNacimiento;
	
	public Usuario() {
		 contadorUsuarios++; // Incrementar el contador cada vez que se crea un nuevo usuario
	     this.idUsuario = String.format("%02d", contadorUsuarios); // Formato de 2 dígitos
		
	}
	
	
	public Usuario(String pNombre, String pApellido, int pContraseña, String pEmail, Date pFNacimiento) {
		this(); //llamo al constructor sin parametros para asignar el ID
		this.nombre = pNombre;
		this.apellido = pApellido;
		this.contraseña = pContraseña;
		this.email = pEmail;
		this.FNacimiento = pFNacimiento;
		
	}
	
	



	 @Override
	    public boolean equals(Object obj) {
	        if (this == obj) return true;
	        if (obj == null) return false;
	        if (getClass() != obj.getClass()) return false;
	        Usuario other = (Usuario) obj;
	        return Objects.equals(FNacimiento, other.FNacimiento) && Objects.equals(apellido, other.apellido)
	                && contraseña == other.contraseña && Objects.equals(email, other.email)
	                && Objects.equals(nombre, other.nombre);
	    }

	    public int getContraseña() {
	        return contraseña;
	    }

	    public void setContraseña(int contraseña) {
	        this.contraseña = contraseña;
	    }

	    public String getNombre() {
	        return nombre;
	    }

	    public void setNombre(String nombre) {
	        this.nombre = nombre;
	    }

	    public String getApellido() {
	        return apellido;
	    }

	    public void setApellido(String apellido) {
	        this.apellido = apellido;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public Date getFNacimiento() {
	        return FNacimiento;
	    }

	    public void setFNacimiento(Date fNacimiento) {
	        FNacimiento = fNacimiento;
	    }
	    
	    public String getIdUsuario() {
	        return idUsuario; // Método para obtener el ID del usuario
	    }

	    @Override
	    public String toString() {
	        return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido 
	                + ", contraseña=" + contraseña + ", email=" + email + ", FNacimiento=" + FNacimiento + "]";
	    }
	}