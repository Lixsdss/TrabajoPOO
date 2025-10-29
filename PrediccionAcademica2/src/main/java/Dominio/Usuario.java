package Dominio;
import util.RolUsuario;
import java.util.Date;
public abstract class Usuario {
    private int id;
    private String nombre;
    private String email;
    public String apellido;
    private String password;
    private RolUsuario rol;

    public Usuario(int id, String nombre,String apellido, String email, String password, RolUsuario rol) {
        this.id = id;
        this.nombre = nombre;
        this.apellido=apellido;
        this.email = email;
        this.password = password;
        this.rol = rol;
    }

    // Getters y Setters
    
    public String getApellido() { return apellido; }
    public int getId() {  return id;   }
    public String getNombre() { return nombre; }
    public String getEmail() { return email; }
    public RolUsuario getRol() { return rol; }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRol(RolUsuario rol) {
        this.rol = rol;
    }
    
    public abstract void mostrarInformacion();
}