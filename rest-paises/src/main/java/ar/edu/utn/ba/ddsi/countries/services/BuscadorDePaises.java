package ar.edu.utn.ba.ddsi.countries.services;

import ar.edu.utn.ba.ddsi.countries.config.RestCountriesProperties;
import ar.edu.utn.ba.ddsi.countries.services.dto.Pais;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @Component indica que una clase es un "componente de SW".
 * Estas clases son consideradas como candidatas para la auto-detección cuando se utiliza la configuración basada en anotaciones y el escaneo de classpath.
 * En este caso, Spring creará una instancia de esta clase (un bean) y la gestionará.
 */
@Component
public class BuscadorDePaises {

    // Constante para definir los campos que queremos que la API nos devuelva.
    // Esto reduce la cantidad de datos transferidos y hace la respuesta más ligera.
    private static final String CAMPOS =
            "name,capital,region,subregion,population,currencies,languages,area,cca2,cca3";

    private final RestTemplate restTemplate;
    private final RestCountriesProperties propiedades;

    /**
     * Inyección de dependencias a través del constructor.
     * Spring ve que BuscadorDePaises necesita un RestTemplate y un RestCountriesProperties.
     * Como ambos son beans gestionados por Spring (definidos en RestTemplateConfig y habilitados en CountriesApplication),
     * Spring los inyecta automáticamente cuando crea la instancia de BuscadorDePaises.
     * @param restTemplate el cliente HTTP para hacer las peticiones.
     * @param propiedades las propiedades de configuración de la API de países.
     */
    public BuscadorDePaises(RestTemplate restTemplate, RestCountriesProperties propiedades) {
        this.restTemplate = restTemplate;
        this.propiedades = propiedades;
    }

    /**
     * Busca todos los países.
     * @return una lista de todos los países.
     */
    public List<Pais> buscarTodos() {
        // UriComponentsBuilder es una clase de ayuda para construir y codificar URIs.
        URI uri =
                UriComponentsBuilder.fromUriString(propiedades.getBaseUrl()) // Empezamos con la URL base de la configuración
                        .path("/all") // Añadimos el path para buscar todos los países (path params)
                        .queryParam("fields", CAMPOS) // Añadimos los campos que queremos que nos devuelva
                        .build() // Construimos el UriComponents
                        .toUri(); // Lo convertimos a un objeto URI
        // restTemplate.getForObject hace una petición GET a la URI y mapea la respuesta a un array de Pais.
        Pais[] cuerpo = restTemplate.getForObject(uri, Pais[].class);
        // Si el cuerpo es nulo o está vacío, devolvemos una lista vacía. Si no, convertimos el array a una lista.
        return cuerpo == null || cuerpo.length == 0 ? List.of() : Arrays.asList(cuerpo);
    }

    /**
     * Busca un país por su nombre.
     * @param nombre el nombre del país a buscar.
     * @return un Optional que puede contener el país si se encuentra.
     */
    public Optional<Pais> buscarPorNombre(String nombre) {
        URI uri =
                UriComponentsBuilder.fromUriString(propiedades.getBaseUrl())
                        .path("/name/{nombre}") // El path contiene una variable {nombre}
                        .queryParam("fields", CAMPOS)
                        .buildAndExpand(nombre) // Reemplazamos la variable {nombre} con el valor del parámetro
                        .toUri();
        Pais[] cuerpo = restTemplate.getForObject(uri, Pais[].class);
        if (cuerpo == null || cuerpo.length == 0) {
            return Optional.empty(); // Si no se encuentra, devolvemos un Optional vacío.
        }
        // La API de nombre puede devolver varios resultados, pero generalmente el primero es el más relevante.
        return Optional.of(cuerpo[0]);
    }

    /**
     * Busca países por su código de moneda.
     * @param codigoMoneda el código de la moneda (ej. "ARS").
     * @return una lista de países que usan esa moneda.
     */
    public List<Pais> buscarPorMoneda(String codigoMoneda) {
        URI uri =
                UriComponentsBuilder.fromUriString(propiedades.getBaseUrl())
                        .path("/currency/{codigo}")
                        .queryParam("fields", CAMPOS)
                        .buildAndExpand(codigoMoneda)
                        .toUri();
        Pais[] cuerpo = restTemplate.getForObject(uri, Pais[].class);
        return cuerpo == null || cuerpo.length == 0 ? List.of() : Arrays.asList(cuerpo);
    }

    /**
     * Busca países por su región.
     * @param region la región a buscar (ej. "Europe").
     * @return una lista de países en esa región.
     */
    public List<Pais> buscarPorRegion(String region) {
        URI uri =
                UriComponentsBuilder.fromUriString(propiedades.getBaseUrl())
                        .path("/region/{region}")
                        .queryParam("fields", CAMPOS)
                        .buildAndExpand(region)
                        .toUri();
        Pais[] cuerpo = restTemplate.getForObject(uri, Pais[].class);
        return cuerpo == null || cuerpo.length == 0 ? List.of() : Arrays.asList(cuerpo);
    }

    /**
     * Busca países por su capital.
     * @param capital la capital a buscar.
     * @return una lista de países con esa capital.
     */
    public List<Pais> buscarPorCapital(String capital) {
        URI uri =
                UriComponentsBuilder.fromUriString(propiedades.getBaseUrl())
                        .path("/capital/{capital}")
                        .queryParam("fields", CAMPOS)
                        .buildAndExpand(capital)
                        .toUri();
        Pais[] cuerpo = restTemplate.getForObject(uri, Pais[].class);
        return cuerpo == null || cuerpo.length == 0 ? List.of() : Arrays.asList(cuerpo);
    }
}
