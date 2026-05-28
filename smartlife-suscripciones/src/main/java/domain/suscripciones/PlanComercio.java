package domain.suscripciones;

// Implementación Plan Comercio (Subclase): Tarifa base + adicional por dispositivo
public class PlanComercio extends Plan {
    private double adicionalPorDispositivo; // Atributo

    // Constructor
    public PlanComercio(double tarifaBase, double adicionalPorDispositivo) {
        super(tarifaBase);
        this.adicionalPorDispositivo = adicionalPorDispositivo;
    }

    // Lógica de Negocio
    // Regla: Tarifa base + (adicional * cantidad de dispositivos del cliente)
    @Override
    public double calcularMonto(Cliente cliente) {
        return this.tarifaBase + (this.adicionalPorDispositivo * cliente.getCantidadDispositivos());
    }
}