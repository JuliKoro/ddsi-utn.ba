package cuidandonos;

import cuidandonos.demora.CalculadorDeDemora;
import cuidandonos.distancia.CalculadorDeDistancia;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Viaje {
    private Ubicacion puntoDePartida;
    private Ubicacion destino;
    private double demoraAproximadaEnMins;

    public void calcularDemoraAproximadaEnMins(CalculadorDeDistancia calculadorDeDistancia, CalculadorDeDemora calculadorDeDemora) {
        // 1. Obtiene la distancia delegando en el calculador de distancia
        float distanciaEnMetros = calculadorDeDistancia.distanciaEnMetrosEntre(this.puntoDePartida, this.destino);
        // 2. Calcula la demora delegando en el calculador de demora
        this.demoraAproximadaEnMins = calculadorDeDemora.demoraAproximadaEnMinsParaRecorrer(distanciaEnMetros);
    }
}
