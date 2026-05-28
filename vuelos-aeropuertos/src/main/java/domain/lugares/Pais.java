package domain.lugares;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pais {
    private String nombre;
    private Continente continente;
    private List<Ciudad> ciudades; // Es un Enumerador (enum)

    public Pais(String nombre, Continente continente) {
        this.ciudades = new ArrayList<>();
        this.nombre = nombre;
        this.continente = continente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Continente getContinente() {
        return continente;
    }

    public void setContinente(Continente continente) {
        this.continente = continente;
    }

    // Para agregar varios elementos a mi coleccion (generalizados)
    // Ciudad ... ciudades: Son parametros variables (puede llamar al metodo con n cosas)
    public void agregarCiudades(Ciudad ... ciudades) {
        Collections.addAll(this.ciudades, ciudades);
    }
}
