package domain.suscripciones;

// Clase Abstracta Plan
public abstract class Plan {
    protected double tarifaBase; // Atributo

    // Constructor
    public Plan(double tarifaBase) {
        this.tarifaBase = tarifaBase;
    }

    // Lógica de Negocio (Contrato)
    // Define QUÉ debe hacerse, pero deja el CÓMO a las subclases
    public abstract double calcularMonto(Cliente cliente);
}