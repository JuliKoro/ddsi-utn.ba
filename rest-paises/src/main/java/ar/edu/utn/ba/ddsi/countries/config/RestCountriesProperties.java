package ar.edu.utn.ba.ddsi.countries.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "rest-countries")
@Data
public class RestCountriesProperties {

    private String baseUrl;
}
