package domain.suscripciones;

// Clase FacturaMensual
public class FacturaMensual {
    private Cliente cliente; // Atributo (privado)

    // Constructor
    public FacturaMensual(Cliente cliente) {
        this.cliente = cliente;
    }

    // Logica de Negocio (Método principal)
    public double calcularMonto() {
        // La factura delega el cálculo al plan del cliente,
        // pasándole el cliente como contexto (para saber sus dispositivos).
        // Delega la responsabilidad al plan del cliente.
        return cliente.getPlan().calcularMonto(cliente);
    }
}