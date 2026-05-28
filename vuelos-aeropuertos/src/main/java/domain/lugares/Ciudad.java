package domain.lugares;

import domain.viajes.Vuelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Clase
public class Ciudad { // Por default siempre son públicas
    // Atributos: modificador_de_acceso tipo_de_dato nombre;
    private String nombre; // si tipo_de_dato es una clase, la primer letra con Mayúscula
    private Pais pais; // nombre: siempre en minúscula, con lowerCamelCase
    private List<Aeropuerto> aeropuertos; // Coleccion Lista que contiene Aeropuertos (Clase) -> Siempre debo inicializarla

    // Constructor
    public Ciudad(String nombre, Pais pais) {
        this.aeropuertos = new ArrayList<>(); // Inicializa la Coleccion
        this.pais = pais;
        this.nombre = nombre;
        pais.agregarCiudades(this);
    }

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Pais getPais() {
        return pais;
    }

    // Métodos
    // Para agregar varios elementos a mi coleccion (generalizados)
    public void agregarAeropuertos(Aeropuerto ... aeropuertos) {
        Collections.addAll(this.aeropuertos, aeropuertos);
    }

    // Cantidad de elementos de una Colección
    public Integer cantDeAeropuertos() {
        return this.aeropuertos.size();
    }

    public Integer cantPasajerosQueLlegaronElDia(LocalDate dia) { //LocalDate: Clase usada solamente para fecha
        List<Vuelo> vuelosQueLlegaronEseDia = this.aeropuertos // Coleccion: List (Coleccion de vuelos)
                .stream()
                .flatMap(a -> a.vuelosQueLlegaronElDia(dia).stream()) // Mapeo en una sola Coleccion plana
                .collect(Collectors.toList()); // Transformo el stream en una Coleccion (Lista)

        return vuelosQueLlegaronEseDia //Coleccion de vuelos
                .stream()
                .mapToInt(v -> v.cantPasajeros()) // .mapToInt(Vuelo::cantPasajeros) -> Otra forma de llamarlo
                .sum(); // Sumo todos los vuelas de la Coleccion que mappee
    }
}
