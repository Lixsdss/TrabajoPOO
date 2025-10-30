package Dominio;

import util.RolUsuario;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Estudiante extends Usuario {
    // --- Atributos Específicos del Estudiante ---
    

    private String matricula;
    private Date fechaIngreso;
    
    // Relaciones con otras entidades (composición)
    private HistorialAcademico historialAcademico;
    private List<Matricula> matriculas;

    // --- Factores para el Modelo Predictivo (Atributos concretos y tipados) ---
    private double horasEstudioSemanales;
    private int nivelParticipacionClase; // Escala 1-10


    // --- Constructor ---
    public Estudiante(int id, String nombre, String apellido, String email, String password, String matricula, Date fechaIngreso) {
        // Llamada al constructor de la clase padre (Usuario)
        super(id, nombre, apellido, email, password, RolUsuario.ESTUDIANTE);
        this.matricula = matricula;
        this.fechaIngreso = fechaIngreso;
        
        // Inicialización de objetos complejos
        this.historialAcademico = new HistorialAcademico(this);
        this.matriculas= new ArrayList<>();
        
        // Valores por defecto para los factores
        this.horasEstudioSemanales = 0.0;
        this.nivelParticipacionClase = 5;

    }

    // --- Getters y Setters ---
    
    public List<Matricula> getMatriculas() { return matriculas; }
    public String getMatricula() { return matricula; }
    public Date getFechaIngreso() { return fechaIngreso; }
    public HistorialAcademico getHistorialAcademico() { return historialAcademico; }
      
    public double getHorasEstudioSemanales() { return horasEstudioSemanales; }
    public void setHorasEstudioSemanales(double horasEstudioSemanales) { this.horasEstudioSemanales = horasEstudioSemanales; }
    
    public int getNivelParticipacionClase() { return nivelParticipacionClase; }
    public void setNivelParticipacionClase(int nivelParticipacionClase) { this.nivelParticipacionClase = nivelParticipacionClase; }
    // --- Métodos de Comportamiento ---
    @Override
    public void mostrarInformacion() {
        System.out.println("Estudiante: " + getNombre() + " " + getApellido() + " | Matrícula: " + matricula);
    }

    /**
     * Calcula el promedio general del estudiante delegando la tarea a su historial académico.
     * Este valor no se almacena, se calcula cada vez que se necesita para asegurar la consistencia.
     * @return El promedio de todas las calificaciones registradas.
     */
    public double getPromedioGeneral() {
        return this.historialAcademico.calcularPromedioHistorico();
    }
     public void agregarMatricula(Matricula matricula) {
        this.matriculas.add(matricula);
    }
}