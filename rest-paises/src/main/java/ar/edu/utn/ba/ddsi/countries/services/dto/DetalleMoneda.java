package ar.edu.utn.ba.ddsi.countries.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO para el objeto anidado que representa los detalles de una moneda.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleMoneda {

    /**
     * Mapea la propiedad 'name' del JSON al campo 'nombre' de esta clase.
     */
    @JsonProperty("name")
    private String nombre;

    /**
     * Mapea la propiedad 'symbol' del JSON al campo 'simbolo' de esta clase.
     */
    @JsonProperty("symbol")
    private String simbolo;
}
