package ar.edu.utn.ba.ddsi.countries.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * La anotación @ConfigurationProperties se utiliza para vincular y validar un archivo de configuración (por ejemplo, application.yml) con un objeto.
 * En este caso, todas las propiedades con el prefijo "rest-countries" se vincularán a los campos de esta clase.
 */
@ConfigurationProperties(prefix = "rest-countries")
/**
 * @Data es una anotación de Lombok que genera automáticamente el código repetitivo para las clases Java:
 * getters para todos los campos, setters para todos los campos no finales y el método toString, equals y hashCode apropiado.
 */
@Data
public class RestCountriesProperties {

    /**
     * Esta propiedad se vinculará a 'rest-countries.base-url' en el archivo de propiedades.
     * Spring Boot maneja la conversión de kebab-case (base-url) a camelCase (baseUrl).
     */
    private String baseUrl;
}
