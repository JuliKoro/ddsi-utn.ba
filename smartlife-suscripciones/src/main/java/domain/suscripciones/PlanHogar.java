package domain.suscripciones;

// Implementación Plan Hogar (Subclase): Tarifa base fija
public class PlanHogar extends Plan {

    // Constructor
    public PlanHogar(double tarifaBase) {
        super(tarifaBase); // Pasa la tarifa a la clase abstracta padre
    }

    // Lógica de Negocio
    @Override // Reescribe la lógica del Padre (Polimorfismo)
    // Regla: Retorna solo la tarifa base. Ignora la cantidad de dispositivos.
    public double calcularMonto(Cliente cliente) {
        return this.tarifaBase;
    }
}