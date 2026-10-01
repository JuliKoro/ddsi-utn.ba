package tests;

import cuidandonos.Ubicacion;
import cuidandonos.Viaje;
import cuidandonos.demora.CalculadorDeDemora;
import cuidandonos.distancia.CalculadorDeDistancia;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Importación estática de métodos de Mockito
// * -> de la clase Mockito, importo absolutamnte todos sus metodos estaticos (todos los metodos de clase de la clase Mockito)
import static org.mockito.Mockito.*;

public class ViajeTest {

    @Test
    public void demoraDe10MinsEnViaje() {
        // --- 1. CONFIGURACIÓN DEL ESCENARIO REAL (FIXTURE) ---
        Ubicacion medrano = new Ubicacion(-34.598450F, -58.420065F, "UTN BA Medrano");
        Ubicacion campus = new Ubicacion(-34.659277F, -58.4673392F, "UTN BA Campus");

        Viaje viajeDeSedeASede = new Viaje();
        viajeDeSedeASede.setPuntoDePartida(medrano);
        viajeDeSedeASede.setDestino(campus);

        // --- 2. CREACIÓN DE LOS OBJETOS MOCK (IMPOSTORES) ---
        // Me genera una instancia que cumpla con la Interfaz CalculadorDeDistancia
        CalculadorDeDistancia calculadorDeDistancia = mock(CalculadorDeDistancia.class);

        // --- 3. DEFINICIÓN DE COMPORTAMIENTO (STUBBING con WHEN/THEN) ---
        // "Cuando le pidan la distancia entre Medrano y Campus, debe devolver 10100 metros"
        when(calculadorDeDistancia.distanciaEnMetrosEntre(medrano, campus)).thenReturn(10100F);

        CalculadorDeDemora calculadorDeDemora = mock(CalculadorDeDemora.class);
        // "Cuando le pidan la demora para 10100 metros, debe devolver 30 minutos"
        when(calculadorDeDemora.demoraAproximadaEnMinsParaRecorrer(10100F)).thenReturn(30.0);

        // --- 4. EJECUCIÓN DEL MÉTODO A TESTEAR ---
        viajeDeSedeASede.calcularDemoraAproximadaEnMins(calculadorDeDistancia, calculadorDeDemora);
        // Le pasamos los objetos mockeados

        // --- 5. ASERCIÓN (VERIFICACIÓN DEL RESULTADO) ---
        Assertions.assertEquals(30.0, viajeDeSedeASede.getDemoraAproximadaEnMins());
    }
}
