package Dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import servicio.ServicioCurso;

public class Curso {
    private int id;
    private String nombre;
    private int creditos;
    private int nivelDificultad; // 1-10
    private List<Seccion> seccionesOfertadas;

    public Curso(int id, String nombre, int creditos, int nivelDificultad) {
        this.id = id;
        this.nombre = nombre;
        this.creditos = creditos;
        this.nivelDificultad = nivelDificultad;
        this.seccionesOfertadas= new ArrayList<>();
    }

    public void agregarSeccion(Seccion seccion) {
        if (seccion != null && !this.seccionesOfertadas.contains(seccion)) {
            this.seccionesOfertadas.add(seccion);
        }
    }

    public List<Estudiante> getTodosLosEstudiantesInscritos() {
        return this.seccionesOfertadas.stream()
                .flatMap(seccion -> seccion.getEstudiantesMatriculados().stream())
                .distinct()
                .collect(Collectors.toList());
    }
    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getCreditos() { return creditos; }
    public int getNivelDificultad() { return nivelDificultad; }
}
