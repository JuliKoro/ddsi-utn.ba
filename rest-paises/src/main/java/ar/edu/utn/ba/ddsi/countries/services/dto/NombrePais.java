package ar.edu.utn.ba.ddsi.countries.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para el objeto anidado 'name' dentro de la respuesta de la API de países.
 * Representa los nombres común y oficial de un país.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NombrePais {

    /**
     * Mapea la propiedad 'common' del JSON al campo 'comun' de esta clase.
     */
    @JsonProperty("common")
    private String comun;

    /**
     * Mapea la propiedad 'official' del JSON al campo 'oficial' de esta clase.
     */
    @JsonProperty("official")
    private String oficial;
}
