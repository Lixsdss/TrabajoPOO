package servicio;
import Dominio.Estudiante;
import Dominio.Matricula;
import Dominio.Seccion;
import Dominio.Usuario;
import Repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.RolUsuario;

public class ServicioEstudiante {
    private final UsuarioRepositorio usuarioRepo; // Inyecta el repo central (única lista)

    public ServicioEstudiante(UsuarioRepositorio usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    public void agregarAlumno(Estudiante est) {
        if (est == null) {
            throw new IllegalArgumentException("Estudiante no puede ser null");
        }
        if (est.getRol() != RolUsuario.ESTUDIANTE) {
            throw new IllegalArgumentException("El usuario debe tener rol ESTUDIANTE");
        }
        usuarioRepo.agregarUsuario(est); // Agrega al repo único
    }

    // Eliminar estudiante por ID (usa el repo central)
    public boolean eliminarAlumno(int id) {
        Usuario usuario = usuarioRepo.buscarId(id);
        if (usuario instanceof Estudiante) {
            return usuarioRepo.eliminarUsuario(id);
        }
        return false; // No es estudiante
    }

    // Buscar estudiante por ID (filtra del repo central)
    public Estudiante buscarAlumno(int id) {
        Usuario usuario = usuarioRepo.buscarId(id);
        if (usuario instanceof Estudiante) {
            return (Estudiante) usuario;
        }
        return null;
    }

    // Modificar estudiante: Actualiza campos específicos (usa el repo central para actualizar)
    public boolean modificarEstudiante(int id, String nuevoNombre, String nuevoApellido, String nuevoEmail, double nuevasHorasEstudio, int nuevoNivelParticipacion) {
        Estudiante est = buscarAlumno(id);
        if (est != null) {
            if (nuevoNombre != null) est.setNombre(nuevoNombre); // Asume setters en Estudiante
            if (nuevoApellido != null) est.setApellido(nuevoApellido);
            if (nuevoEmail != null) est.setEmail(nuevoEmail);
            est.setHorasEstudioSemanales(nuevasHorasEstudio);
            est.setNivelParticipacionClase(nuevoNivelParticipacion);
            return usuarioRepo.actualizarUsuario(est); // Actualiza en el repo único
        }
        return false;
    }

    // Agregar/Actualizar datos predictivos (actualiza en el repo central)
    public void agregarDatosPredictivos(int id, double horasEstudioSemanales, int nivelParticipacionClase) {
        Estudiante est = buscarAlumno(id);
        if (est == null) {
            throw new IllegalArgumentException("Estudiante con ID " + id + " no existe");
        }
        est.setHorasEstudioSemanales(horasEstudioSemanales);
        est.setNivelParticipacionClase(nivelParticipacionClase);
        usuarioRepo.actualizarUsuario(est); // Actualiza en el repo único
    }

    // Matricular estudiante en una sección (usa métodos del modelo)
    public void matricularseCurso(int idEstudiante, Seccion seccion) {
        Estudiante est = buscarAlumno(idEstudiante);
        if (est == null) {
            throw new IllegalArgumentException("Estudiante con ID " + idEstudiante + " no existe");
        }
        if (seccion == null) {
            throw new IllegalArgumentException("Sección no puede ser null");
        }
        if (seccion.estaLleno()) {
            throw new IllegalStateException("Sección llena");
        }
        Matricula matricula = new Matricula(est, seccion);
        est.agregarMatricula(matricula);
        seccion.getMatriculas().add(matricula); // Asume acceso; mejor inyecta ServicioSeccion si existe
        usuarioRepo.actualizarUsuario(est); // Actualiza en el repo único
    }

    // Obtener todos los estudiantes (filtra del repo central)
    public List<Estudiante> getAllEstudiantes() {
        return usuarioRepo.findAll().stream()
                .filter(u -> u.getRol() == RolUsuario.ESTUDIANTE)
                .map(u -> (Estudiante) u)
                .collect(Collectors.toList());
    }
//    private Estudiante[] estudiante;
//    public static int ind=0;
//    
//    public ServicioEstudiante(){
//        estudiante=new Estudiante[30];
//    }
//
//    public boolean agregarAlumno(Estudiante est){
//        for (int i = 0; i < estudiante.length; i++) {
//            if (estudiante[i] == null) {
//                estudiante[i] = est;
//                ind++;
//                return true;
//            }
//        }
//        return false;
//    } 
//    public boolean eliminarAlumno(int id){
//          for (int i = 0; i < estudiante.length; i++) {
//            if (estudiante[i] != null && estudiante[i].getId()== id) {
//                estudiante[i] = null;
//                ind--;
//                return true;
//            }
//        }    
//        return false;
//    }
//     public Estudiante buscarAlumno(int id){
//         for (int i = 0; i < estudiante.length; i++) {
//            if (estudiante[i] != null && estudiante[i].getId() == id) {
//                return estudiante[i];
//            }
//        }
//        return null;
//    }
//// ❌ Pierde la referencia original - ¿y si solo quieres modificar algunos campos?
//    public boolean ModificarEstudiante(Estudiante est, int id){
//            for (int i = 0; i < estudiante.length; i++) {
//                if (estudiante[i] != null && estudiante[i].getId() == id) {
//                    estudiante[i] = est;
//                    return true;
//                }
//            }
//        return false;
//    }
//     public boolean agregarDatosPredictivos(Estudiante est){
//        for (int i = 0; i < estudiante.length; i++) {
//            if (estudiante[i] == null) {
//                estudiante[i] = est;
//                ind++;
//                return true;
//            }
//        }
//        return false;
//    } 
//    public void matricularseCurso(){
//        
//    }
    
}
