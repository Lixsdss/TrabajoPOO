package Dominio;

import java.time.LocalDate;

public class Calificacion {
    private double valor;
    private LocalDate fecha;
    private String descripcion; // Ej: "Parcial 1", "Examen Final"

    public Calificacion(double valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
        this.fecha = LocalDate.now();
    }

    // Getters
    public double getValor() { return valor; }
    public LocalDate getFecha() { return fecha; }
    public String getDescripcion() { return descripcion; }
}
