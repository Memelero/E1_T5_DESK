package Modelo;

import java.util.Date; 
import java.util.Objects;

public class Usuario {

    private static int contadorUsuarios = 0;
    private String idUsuario;
    private String nombre;
    private String apellido;
    private String contraseña; 
    private String email;
    private Date FNacimiento; 

    public Usuario() {
        contadorUsuarios++;
        this.idUsuario = String.format("%02d", contadorUsuarios); 
    }

    public Usuario(String pNombre, String pApellido, String pContraseña, String pEmail, Date pFNacimiento) {
        this(); // Eraikiltzailea parametro gabe ID bat asignatzeko
        this.nombre = pNombre;
        this.apellido = pApellido;
        this.contraseña = pContraseña;
        this.email = pEmail;
        this.FNacimiento = pFNacimiento;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Date getFNacimiento() {
        return FNacimiento;
    }

    public void setFNacimiento(Date fNacimiento) {
        this.FNacimiento = fNacimiento;
    }

    @Override
    public String toString() {
        return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", apellido=" + apellido 
                + ", contraseña=" + contraseña + ", email=" + email + ", FNacimiento=" + FNacimiento + "]";
    }
}
