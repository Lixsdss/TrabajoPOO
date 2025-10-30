package Dominio;

import util.RolUsuario;


public class Admin extends Usuario {
    private String NivelAceceso;
    public Admin(int id, String nombre, String apellido, String email, String password) {
        super(id, nombre,apellido, email, password, RolUsuario.ADMIN);
    }

    

    @Override
    public void mostrarInformacion() {
        System.out.println("Administrador: " + getNombre());
        System.out.println("");
    }

   
//    
//    // 1. ✅ CORAZÓN del sistema
//public void registrarUsuario() { 
//}
//public void matricularEstudiante(){   
//}
//// 3. ✅ FEATURE único de tu sistema
//public void generarReporteEstudiantesRiesgoAlto(){    
//}
//// 4. ✅ SEGURIDAD básica
//public void resetearPassword(){    
//}
//// 5. ✅ MANTENIMIENTO esencial
//public void realizarRespaldoBaseDatos(){
//    
//}
//    
    



}    
    
    
    
    
    
    
    
    
    
    
    
    
    
 