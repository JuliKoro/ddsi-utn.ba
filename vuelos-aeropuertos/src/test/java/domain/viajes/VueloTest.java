package domain.viajes;

import domain.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class VueloTest extends BaseTest { // Hereda de la Clase Abstracta con la memoria ya cargada

    @Test //indica al IDE que ese bloque de código es una prueba ejecutable independiente
    public void vueloOcupadoAl10() {
        // Arrange: Fase de Preparación
        Vuelo vueloArgMad = new Vuelo();
        vueloArgMad.setAvion(super.buscarAvionPorcantAsientos(40));
        vueloArgMad.setOrigen(super.buscarAeropuerto("EZE"));
        vueloArgMad.setDestino(super.buscarAeropuerto("MAD"));
        vueloArgMad.agregarPasajeros(
                super.buscarPasajero("Angie", "Rodriguez"),
                super.buscarPasajero("Carlos", "Polanco"),
                super.buscarPasajero("Laura", "Puerto"),
                super.buscarPasajero("Jorge", "Marin")
                );
        // Act & Assert: Fase de Actuación y Afirmación
        //Assert.assertEquals(valorEsperado, valorReal, delta_margenError);
        Assert.assertEquals(10.00, vueloArgMad.capacidadRealOcupadaPorPasajeros(), 0.0);
    }
}
