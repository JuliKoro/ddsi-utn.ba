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

@Component
public class BuscadorDePaises {

    private static final String CAMPOS =
            "name,capital,region,subregion,population,currencies,languages,area,cca2,cca3";

    private final RestTemplate restTemplate;
    private final RestCountriesProperties propiedades;

    public BuscadorDePaises(RestTemplate restTemplate, RestCountriesProperties propiedades) {
        this.restTemplate = restTemplate;
        this.propiedades = propiedades;
    }

    public List<Pais> buscarTodos() {
        URI uri =
                UriComponentsBuilder.fromUriString(propiedades.getBaseUrl())
                        .path("/all")
                        .queryParam("fields", CAMPOS)
                        .build()
                        .toUri();
        Pais[] cuerpo = restTemplate.getForObject(uri, Pais[].class);
        return cuerpo == null || cuerpo.length == 0 ? List.of() : Arrays.asList(cuerpo);
    }

    public Optional<Pais> buscarPorNombre(String nombre) {
        URI uri =
                UriComponentsBuilder.fromUriString(propiedades.getBaseUrl())
                        .path("/name/{nombre}")
                        .queryParam("fields", CAMPOS)
                        .buildAndExpand(nombre)
                        .toUri();
        Pais[] cuerpo = restTemplate.getForObject(uri, Pais[].class);
        if (cuerpo == null || cuerpo.length == 0) {
            return Optional.empty();
        }
        return Optional.of(cuerpo[0]);
    }

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
