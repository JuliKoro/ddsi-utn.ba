package domain.suscripciones;

// Implementación Plan Corporativo (Subclase): Tarifa base con descuento porcentual
public class PlanCorporativo extends Plan {
    // Estado (atributos)
    private double descuentoPorcentual; // Ejemplo: 0.15 para 15% de descuento

    // Constructor
    public PlanCorporativo(double tarifaBase, double descuentoPorcentual) {
        super(tarifaBase);
        this.descuentoPorcentual = descuentoPorcentual;
    }

    // Lógica de Negocio
    // Regla: Tarifa base aplicando un descuento (ej. 0.20 para 20%)
    @Override
    public double calcularMonto(Cliente cliente) {
        return this.tarifaBase * (1 - this.descuentoPorcentual);
    }
}