package Dominio;
public class Aula {
    private String codigo; // Ej: "A205", "Lab-301"
    private int capacidad;
    private String edificio; // Opcional, pero útil

    public Aula(String codigo, int capacidad) {
        this.codigo = codigo;
        this.capacidad = capacidad;
    }

    // Getters
    public String getCodigo() { return codigo; }
    public int getCapacidad() { return capacidad; }
}
