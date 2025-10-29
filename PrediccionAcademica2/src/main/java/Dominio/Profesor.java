package Dominio;

import java.util.ArrayList;
import util.RolUsuario;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import servicio.ServicioProfesor;
import util.RolUsuario;
public class Profesor extends Usuario {
   private String departamento;
    
    // La lista de secciones que este profesor imparte
    private List<Seccion> seccionesImpartidas;

    public Profesor(int id, String nombre, String apellido, String email, String password, String departamento) {
        super(id, nombre, apellido, email, password, RolUsuario.PROFESOR);
        this.departamento = departamento;
        this.seccionesImpartidas = new ArrayList<>();
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Profesor: " + getNombre() + " " + getApellido() + " | Departamento: " + departamento);
    }
    
    /**
     * Asigna una sección a este profesor. Este método asegura la consistencia
     * en ambos sentidos de la relación.
     * @param seccion La sección a asignar.
     */
    public void asignarSeccion(Seccion seccion) {
        if (seccion != null && !this.seccionesImpartidas.contains(seccion)) {
            this.seccionesImpartidas.add(seccion);
            // ¡Paso crucial! También le decimos a la sección quién es su profesor.
            seccion.setProfesor(this);
        }
    }
    
    /**
     * Obtiene la lista de estudiantes de todas las secciones que imparte este profesor.
     * @return Una lista única de estudiantes.
     */
//    public List<Estudiante> getTodosMisEstudiantes() {
//        return this.seccionesImpartidas.stream()
//                .flatMap(seccion -> seccion.getEstudiantesMatriculados().stream())
//                .distinct() // Asegura que no haya estudiantes repetidos
//                .collect(Collectors.toList());
//    }
//
//    /**
//     * Obtiene las secciones que imparte un profesor en un semestre específico.
//     * @param semestre El semestre a filtrar (ej: "2024-2").
//     * @return Lista de secciones del semestre.
//     */
//    public List<Seccion> getSeccionesPorSemestre(String semestre) {
//        return this.seccionesImpartidas.stream()
//                .filter(seccion -> seccion.getSemestre().equals(semestre))
//                .collect(Collectors.toList());
//    }

    // Getters y Setters
    public String getDepartamento() { return departamento; }
    public List<Seccion> getSeccionesImpartidas() { return seccionesImpartidas; }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }


}


