package servicio;

import Dominio.Profesor;
import Dominio.Seccion;
import Dominio.Usuario;
import Repositorio.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import util.RolUsuario;

public class ServicioProfesor {
    private final UsuarioRepositorio usuarioRepo;

    public ServicioProfesor(UsuarioRepositorio usuarioRepo) {
        this.usuarioRepo = usuarioRepo;
    }

    
    public void agregarProfesor(Profesor profesor) {
        if (profesor == null) {
            throw new IllegalArgumentException("Profesor no puede ser null");
        }
        if (profesor.getRol() != RolUsuario.PROFESOR) {
            throw new IllegalArgumentException("El usuario debe tener rol PROFESOR");
        }
        usuarioRepo.agregarUsuario(profesor);
    }

    
    public boolean eliminarProfesor(int id) {
        Usuario usuario = usuarioRepo.buscarId(id);
        if (usuario instanceof Profesor) {
            return usuarioRepo.eliminarUsuario(id);
        }
        return false;
    }

    
    public Profesor buscarProfesor(int id) {
        Usuario usuario = usuarioRepo.buscarId(id);
        if (usuario instanceof Profesor) {
            return (Profesor) usuario;
        }
        return null;
    }

    
    public boolean modificarProfesor(int id, String nuevoNombre, String nuevoApellido, String nuevoEmail, String nuevoDepartamento) {
        Profesor prof = buscarProfesor(id);
        if (prof != null) {
            if (nuevoNombre != null) 
                prof.setNombre(nuevoNombre);
            if (nuevoApellido != null) 
                prof.setApellido(nuevoApellido);
            if (nuevoEmail != null) 
                prof.setEmail(nuevoEmail);
            if (nuevoDepartamento != null) 
                prof.setDepartamento(nuevoDepartamento); // Asegúrate de tener setter
            return usuarioRepo.actualizarUsuario(prof);
        }
        return false;
    }

    
    public void asignarSeccion(int idProfesor, Seccion seccion) {
        Profesor profesor = buscarProfesor(idProfesor);
        if (profesor == null) {
            throw new IllegalArgumentException("Profesor con ID " + idProfesor + " no existe");
        }
        if (seccion == null) {
            throw new IllegalArgumentException("Sección no puede ser null");
        }
        if (seccion.getProfesor() != null && seccion.getProfesor().getId() != idProfesor) {
            throw new IllegalStateException("La sección ya tiene un profesor asignado");
        }

        profesor.asignarSeccion(seccion); // Usa método del modelo
        seccion.setProfesor(profesor);    // Bidireccional
        usuarioRepo.actualizarUsuario(profesor);
    }

    // Obtener todas las secciones impartidas por el profesor
    public List<Seccion> getSeccionesImpartidas(int idProfesor) {
        Profesor profesor = buscarProfesor(idProfesor);
        if (profesor != null) {
            return profesor.getSeccionesImpartidas(); // Asume getter inmutable
        }
        return List.of();
    }

    // Obtener todos los profesores
    public List<Profesor> getAllProfesores() {
        return usuarioRepo.findAll().stream()
                .filter(u -> u.getRol() == RolUsuario.PROFESOR)
                .map(u -> (Profesor) u)
                .collect(Collectors.toList());
    } 
    public void registrarNotas(){
        
    }
    public void asignarAula(){
        
    }
    
}
