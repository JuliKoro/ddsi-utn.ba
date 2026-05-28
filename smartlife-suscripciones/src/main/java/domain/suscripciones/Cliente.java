package domain.suscripciones;

// Clase Cliente
public class Cliente {
    // Atributos
    private Plan plan;
    private int cantidadDispositivos;

    // Constructor
    public Cliente(Plan plan, int cantidadDispositivos) {
        this.plan = plan;
        this.cantidadDispositivos = cantidadDispositivos;
    }

    // Getters
    public Plan getPlan() {
        return plan;
    }

    public int getCantidadDispositivos() {
        return cantidadDispositivos;
    }

    // Setter
    // Si quisiéramos cambiar el plan de un cliente en tiempo de ejecución (Opcional)
    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}