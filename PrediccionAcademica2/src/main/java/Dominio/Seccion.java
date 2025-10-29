package Dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Seccion {
     private int id;
    private String nombreSeccion;
    private String semestre;
    private Curso curso;
    private Profesor profesor;
    private Aula aula;
    
    // ¡Cambio clave! Ahora guardamos las matrículas, no solo los estudiantes.
    private List<Matricula> matriculas;

    public Seccion(int id, String nombreSeccion, String semestre, Curso curso, Profesor profesor, Aula aula) {
        this.id = id;
        this.nombreSeccion = nombreSeccion;
        this.semestre = semestre;
        this.curso = curso;
        this.profesor = profesor;
        this.aula = aula;
        this.matriculas = new ArrayList<>();
    }

    public void matricularEstudiante(Estudiante estudiante) {
        if (!estaLleno()) {
            Matricula nuevaMatricula = new Matricula(estudiante, this);
            this.matriculas.add(nuevaMatricula);
            estudiante.agregarMatricula(nuevaMatricula); // También se lo notificamos al estudiante
        }
    }
    
    public boolean estaLleno() {
        return matriculas.size() >= aula.getCapacidad();
    }

    // Método de ayuda para obtener la lista de estudiantes si se necesita
    public List<Estudiante> getEstudiantesMatriculados() {
        return matriculas.stream()
                         .map(Matricula::getEstudiante)
                         .collect(Collectors.toList());
    }
    
    // Getters...
    public Curso getCurso() { return curso; }
    public Aula getAula() { return aula; }
    public List<Matricula> getMatriculas() { return matriculas; }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String getSemestre() {
        return semestre;
    }

    public Profesor getProfesor() {
        return profesor;
    }
    
    
}

