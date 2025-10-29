package Dominio;

import java.time.LocalDate;
import util.NivelRiesgo;
public class PrediccionRendimiento {
    private int id;
    private Estudiante estudiante;
    private Curso curso;
    private LocalDate fechaPrediccion;
    private double puntajeRiesgo; // 0 - 100
    private NivelRiesgo nivelRiesgo;
    private String recomendacion;

    public PrediccionRendimiento(int id, Estudiante estudiante, Curso curso) {
        this.id = id;
        this.estudiante = estudiante;
        this.curso = curso;
        this.fechaPrediccion = LocalDate.now();
    }

    // Getters y Setters
    public double getPuntajeRiesgo() { return puntajeRiesgo; }
    public void setPuntajeRiesgo(double puntajeRiesgo) { this.puntajeRiesgo = puntajeRiesgo; }
    public NivelRiesgo getNivelRiesgo() { return nivelRiesgo; }
    public void setNivelRiesgo(NivelRiesgo nivelRiesgo) { this.nivelRiesgo = nivelRiesgo; }
    public String getRecomendacion() { return recomendacion; }
    public void setRecomendacion(String recomendacion) { this.recomendacion = recomendacion; }
    
    public void mostrarDetalles() {
        System.out.println("--- PREDICCIÓN DE RENDIMIENTO ---");
        System.out.println("Estudiante: " + estudiante.getNombre());
        System.out.println("Curso: " + curso.getNombre());
        System.out.println("Fecha: " + fechaPrediccion);
        System.out.println("Puntaje de Riesgo: " + String.format("%.2f", puntajeRiesgo));
        System.out.println("Nivel de Riesgo: " + nivelRiesgo);
        System.out.println("Recomendación: " + recomendacion);
        System.out.println("---------------------------------");
    }
}
