package ar.edu.utn.ba.ddsi.countries.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetalleMoneda {

    @JsonProperty("name")
    private String nombre;

    @JsonProperty("symbol")
    private String simbolo;
}
