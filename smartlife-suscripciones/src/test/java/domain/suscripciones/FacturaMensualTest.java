package domain.suscripciones;

import org.junit.jupiter.api.DisplayName; // Permite dar nombres legibles a los tests
import org.junit.jupiter.api.Test; // Marca un metodo como un caso de prueba
import static org.junit.jupiter.api.Assertions.assertEquals; // Herramienta para verificar resultados

class FacturaMensualTest {

    @Test // Señal para el compilador
    @DisplayName("Plan Hogar: Retorna la tarifa base fija sin importar dispositivos") // Reemplaza el nombre técnico del metodo por una frase de negocio.
    void calculaPlanHogar() {
        // 1. ARRANGE (Preparar): Configuramos el estado inicial y las dependencias.
        // Se instancia un PlanHogar definiendo su tarifa base.
        Plan planHogar = new PlanHogar(1500.0);
        // Se instancia el Cliente inyectando el plan (Composición/Agregación) y estableciendo 5 dispositivos.
        Cliente cliente = new Cliente(planHogar, 5);
        // Se crea el objeto a probar (System Under Test) inyectándole el cliente.
        FacturaMensual factura = new FacturaMensual(cliente);

        // 2. ACT & ASSERT (Actuar y Comprobar):
        // Se ejecuta el metodo calcularMonto(). Como es PlanHogar, delega y retorna la tarifa fija ignorando los dispositivos.
        // El valor 0.01 es el 'delta', un margen de tolerancia necesario al comparar números de punto flotante (double).
        assertEquals(1500.0, factura.calcularMonto(), 0.01);
    }

    @Test
    @DisplayName("Plan Comercio: Retorna tarifa base más adicional por dispositivo")
    void calculaPlanComercio() {
        // ARRANGE:
        // Se configura un PlanComercio con $2000 de base y $300 de adicional por cada dispositivo.
        Plan planComercio = new PlanComercio(2000.0, 300.0);
        // El cliente tiene 4 dispositivos, por lo que el adicional será 4 * 300 = 1200.
        Cliente cliente = new Cliente(planComercio, 4);
        FacturaMensual factura = new FacturaMensual(cliente);

        // ACT & ASSERT:
        // El cálculo esperado es: 2000.0 (base) + 1200.0 (adicional) = 3200.0.
        assertEquals(3200.0, factura.calcularMonto(), 0.01);
    }

    @Test
    @DisplayName("Plan Corporativo: Retorna tarifa base con descuento porcentual")
    void calculaPlanCorporativo() {
        // ARRANGE:
        // Se configura un PlanCorporativo con $5000 de base y un 20% de descuento (representado como 0.20).
        Plan planCorporativo = new PlanCorporativo(5000.0, 0.20);
        // La cantidad de dispositivos (100) no afecta el cálculo en este plan.
        Cliente cliente = new Cliente(planCorporativo, 100);
        FacturaMensual factura = new FacturaMensual(cliente);

        // ACT & ASSERT:
        // El cálculo esperado es: 5000.0 - (5000.0 * 0.20) = 4000.0.
        assertEquals(4000.0, factura.calcularMonto(), 0.01);
    }

    @Test
    @DisplayName("Strategy Pattern: Recalcula el monto al cambiar el plan en tiempo de ejecución")
    void cambiaDePlanEnEjecucion() {
        // ARRANGE: El cliente inicia con un Plan Hogar.
        Plan planHogar = new PlanHogar(1000.0);
        Cliente cliente = new Cliente(planHogar, 2);
        FacturaMensual factura = new FacturaMensual(cliente);

        // ASSERT INICIAL: Comprobamos que el cálculo con el primer plan es correcto.
        assertEquals(1000.0, factura.calcularMonto(), 0.01);

        // ACT (Modificar comportamiento dinámicamente):
        // Reemplazamos el plan del cliente en tiempo de ejecución.
        // Esto demuestra el poder del polimorfismo y el Patrón Strategy.
        cliente.setPlan(new PlanComercio(1000.0, 500.0));

        // ASSERT FINAL: Comprobamos que la factura delega correctamente a la nueva regla de negocio.
        // Nuevo cálculo esperado: 1000.0 (base) + (500.0 * 2 dispositivos) = 2000.0.
        assertEquals(2000.0, factura.calcularMonto(), 0.01);
    }
}