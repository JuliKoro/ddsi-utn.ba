package ar.edu.utn.ba.ddsi.countries.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * La anotación @Configuration indica que una clase declara uno o más métodos @Bean y puede ser procesada por el contenedor de Spring
 * para generar definiciones de beans y solicitudes de servicio para esos beans en tiempo de ejecución.
 */
@Configuration
public class RestTemplateConfig {

    /**
     * La anotación @Bean le dice a Spring que este métod_o producirá un bean para ser administrado por el contenedor de Spring.
     * RestTemplate es el cliente HTTP síncrono central de Spring para realizar solicitudes HTTP.
     * Este bean ahora se puede inyectar en cualquier otro componente de Spring.
     * @return una nueva instancia de RestTemplate
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
