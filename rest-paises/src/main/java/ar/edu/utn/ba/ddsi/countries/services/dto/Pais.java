package ar.edu.utn.ba.ddsi.countries.services.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Pais {

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

    @JsonProperty("currencies")
    private Map<String, DetalleMoneda> monedas;

    @JsonProperty("languages")
    private Map<String, String> idiomas;

    @JsonProperty("cca2")
    private String cca2;

    @JsonProperty("cca3")
    private String cca3;
}
