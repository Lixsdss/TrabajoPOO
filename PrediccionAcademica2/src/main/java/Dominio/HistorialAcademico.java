package Dominio;

import java.util.ArrayList;
import java.util.List;

public class HistorialAcademico {
    private Estudiante estudiante;
    private List<Calificacion> todasLasCalificaciones;
    private List<PrediccionRendimiento> historialAlertas;

    public HistorialAcademico(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.todasLasCalificaciones = new ArrayList<>();
        this.historialAlertas = new ArrayList<>();
    }

    
    public void agregarCalificacion(Calificacion calificacion) {
        this.todasLasCalificaciones.add(calificacion);
    }
    
    public double calcularPromedioHistorico() {
        if (todasLasCalificaciones.isEmpty()) {
            return 0.0;
        }
        return todasLasCalificaciones.stream().mapToDouble(Calificacion::getValor).average().orElse(0.0);
    }
    
    public double calcularTendenciaCalificaciones() {
        // Simplificación: compara el promedio de las últimas 2 notas con las 2 anteriores
        if (todasLasCalificaciones.size() < 4) return 0.0; // No hay suficientes datos
        
        int n = todasLasCalificaciones.size();
        double promedioReciente = (todasLasCalificaciones.get(n-1).getValor() + todasLasCalificaciones.get(n-2).getValor()) / 2.0;
        double promedioAnterior = (todasLasCalificaciones.get(n-3).getValor() + todasLasCalificaciones.get(n-4).getValor()) / 2.0;
        
        return promedioReciente - promedioAnterior; // Positivo es mejora, negativo es declive
    }

    public int contarAlertasPrevias() {
        return historialAlertas.size();
    }
    
    // Getters
    public List<Calificacion> getTodasLasCalificaciones() { return todasLasCalificaciones; }
    public List<PrediccionRendimiento> getHistorialAlertas() { return historialAlertas; }
}
