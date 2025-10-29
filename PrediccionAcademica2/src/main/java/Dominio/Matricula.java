package Dominio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Matricula {
// Atributos que preservan la información
    private Estudiante estudiante;
    private Seccion seccion; // Ahora se relaciona con Seccion, no con Curso
    private double porcentajeAsistencia;
    private LocalDate fechaMatricula;

    public Matricula(Estudiante estudiante, Seccion seccion) {
        this.estudiante = estudiante;
        this.seccion = seccion;
        this.fechaMatricula = LocalDate.now();
        this.porcentajeAsistencia = 100.0; // Valor inicial

    }


    // ¡No se pierde nada! Todos los datos están aquí.
    public Estudiante getEstudiante() { return estudiante; }
    public Seccion getSeccion() { return seccion; }
    public double getPorcentajeAsistencia() { return porcentajeAsistencia; }
    public void setPorcentajeAsistencia(double porcentajeAsistencia) { this.porcentajeAsistencia = porcentajeAsistencia; }
    
    // Puedes obtener el curso a través de la sección
    public Curso getCurso() {
        return this.seccion.getCurso();
    }
}
