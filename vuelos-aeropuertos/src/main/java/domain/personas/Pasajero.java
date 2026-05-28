package domain.personas;

import domain.lugares.Ciudad;
import domain.lugares.Pais;
import domain.viajes.Vuelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pasajero extends Persona {
    private List<Vuelo> vuelos;
    private Integer nroDePasaporte;
    private Pais nacionalidad;

    public Pasajero(String nombre, String apellido) {
        super.setNombre(nombre);
        super.setApellido(apellido);
        this.vuelos = new ArrayList<>();
    }

    public Integer getNroDePasaporte() {
        return nroDePasaporte;
    }

    public void setNroDePasaporte(Integer nroDePasaporte) {
        this.nroDePasaporte = nroDePasaporte;
    }

    public Pais getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Pais nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Vuelo> getVuelos() {
        return vuelos;
    }

    public void agregarVuelos(Vuelo ... vuelos) {
        Collections.addAll(this.vuelos, vuelos);
    }

    public Integer cantVuelosTotales() {
        return this.vuelos.size();
    }

    // Metodo para contar la cantidad de veces en base a un filtro
    public Integer cantVecesQueVisitaste(Ciudad unaCiudad) {
        return (int) this.vuelos // casteo a (int) ya que count() devuelve un long
                .stream()
                .filter(v -> v.tuDestinoEs(unaCiudad)) // utiliza una funcion lambda
                .count(); // para contar
    }
}
