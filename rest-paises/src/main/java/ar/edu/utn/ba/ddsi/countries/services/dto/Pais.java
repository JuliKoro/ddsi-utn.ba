package ar.edu.utn.ba.ddsi.countries.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

/**
 * DTO (Data Transfer Object) que representa un país.
 * Esta clase se utiliza para mapear los datos JSON recibidos de la API a un objeto Java.
 */

/**
 * @JsonIgnoreProperties(ignoreUnknown = true) le dice a Jackson (la librería de mapeo JSON)
 * que ignore cualquier propiedad en el JSON que no corresponda a un campo en esta clase.
 * Esto evita errores si la API añade nuevos campos que no nos interesan.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
/**
 * @Data es una anotación de Lombok que genera getters, setters, toString, equals y hashCode.
 */
@Data
/**
 * @NoArgsConstructor es una anotación de Lombok que genera un constructor sin argumentos.
 * Jackson lo necesita para instanciar el objeto antes de rellenar sus campos.
 */
@NoArgsConstructor
/**
 * @AllArgsConstructor es una anotación de Lombok que genera un constructor con un argumento para cada campo en la clase.
 * Es útil para crear instancias de prueba o para la inmutabilidad.
 */
@AllArgsConstructor
public class Pais {

    /**
     * @JsonProperty("name") le dice a Jackson que el campo 'nombre' en esta clase
     * corresponde a la propiedad 'name' en el JSON. Esto permite usar nombres de campo
     * diferentes en Java y en el JSON.
     */
    @JsonProperty("name")
    private NombrePais nombre;

    @JsonProperty("capital")
    private List<String> capitales;

    @JsonProperty("region")
    private String region;

    @JsonProperty("subregion")
    private String subregion;

    @JsonProperty("area")
    private Double superficie;

    @JsonProperty("population")
    private Long poblacion;

    /**
     * El campo 'currencies' en el JSON es un objeto donde las claves son los códigos de moneda (ej. "USD")
     * y los valores son objetos con los detalles de la moneda. Un Map<String, DetalleMoneda> es la
     * estructura de datos perfecta para representar esto.
     */
    @JsonProperty("currencies")
    private Map<String, DetalleMoneda> monedas;

    @JsonProperty("languages")
    private Map<String, String> idiomas;

    /**
     * Códigos de país ISO 3166-1 alpha-2 y alpha-3.
     */
    @JsonProperty("cca2")
    private String cca2;

    @JsonProperty("cca3")
    private String cca3;
}
