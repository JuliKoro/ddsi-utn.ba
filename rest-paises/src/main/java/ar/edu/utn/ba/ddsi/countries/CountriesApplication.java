package ar.edu.utn.ba.ddsi.countries;

import ar.edu.utn.ba.ddsi.countries.config.RestCountriesProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * La anotación @SpringBootApplication es una anotación de conveniencia que agrega tod0 lo siguiente:
 * @Configuration: etiqueta la clase como una fuente de definiciones de beans para el contexto de la aplicación.
 * @EnableAutoConfiguration: le dice a Spring Boot que comience a agregar beans basados en la configuración de la ruta de clases, otros beans y varias configuraciones de propiedades.
 * @ComponentScan: le dice a Spring que busque otros componentes, configuraciones y servicios en el paquete 'ar.edu.utn.ba.ddsi.countries', permitiéndole encontrar los controladores.
 */
@SpringBootApplication
// La anotación @EnableConfigurationProperties se utiliza para habilitar el soporte para @ConfigurationProperties.
// Las clases @ConfigurationProperties son una forma de vincular jerárquicamente las propiedades de configuración a objetos.
@EnableConfigurationProperties(RestCountriesProperties.class)
public class CountriesApplication {

	/**
	 * El métod0 main utiliza el métod0 de ayuda SpringApplication.run para iniciar una aplicación Spring Boot.
	 * @param args argumentos de línea de comandos
	 */
	public static void main(String[] args) {
		SpringApplication.run(CountriesApplication.class, args);
	}

}
