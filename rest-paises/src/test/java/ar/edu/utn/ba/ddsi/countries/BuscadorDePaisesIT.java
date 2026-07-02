package ar.edu.utn.ba.ddsi.countries;

import ar.edu.utn.ba.ddsi.countries.services.BuscadorDePaises;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * La anotación @SpringBootTest le dice a Spring Boot que busque una clase de configuración principal
 * (una con @SpringBootApplication, por ejemplo) y la use para iniciar un contexto de aplicación de Spring.
 * Esta es una prueba de integración que carga todo el contexto de la aplicación.
 */
@SpringBootTest
class BuscadorDePaisesIT {

    /**
     * @Autowired se utiliza para la inyección automática de dependencias.
     * Spring inyectará una instancia de BuscadorDePaises (que es un @Component) en este campo.
     */
    @Autowired
    private BuscadorDePaises buscadorDePaises;

    /**
     * @Test es una anotación de JUnit 5 que marca un método como un método de prueba.
     * Esta prueba verifica que el método buscarTodos() devuelve una lista no vacía de países.
     */
    @Test
    void buscarTodosDevuelveVariosPaises() {
        // Llamamos al método del servicio
        var lista = buscadorDePaises.buscarTodos();
        // AssertJ se utiliza para las aserciones. Es una biblioteca de aserciones fluida.
        // Verificamos que la lista no esté vacía.
        assertThat(lista).isNotEmpty();
        // Verificamos que el nombre común del primer país no esté en blanco.
        assertThat(lista.getFirst().getNombre().getComun()).isNotBlank();
    }

    /**
     * Prueba que al buscar por el nombre "peru", se obtiene el país correcto.
     */
    @Test
    void buscarPorNombrePeruDevuelvePeru() {
        var opt = buscadorDePaises.buscarPorNombre("peru");
        // Verificamos que el Optional contenga un valor.
        assertThat(opt).isPresent();
        // Verificamos que el nombre común del país sea "Peru".
        assertThat(opt.get().getNombre().getComun()).isEqualTo("Peru");
        // Verificamos que el código de país sea "PE".
        assertThat(opt.get().getCca2()).isEqualTo("PE");
    }

    /**
     * Prueba que al buscar por la moneda "ars", la lista de resultados incluye a "Argentina".
     */
    @Test
    void buscarPorMonedaARSincluyeArgentina() {
        var lista = buscadorDePaises.buscarPorMoneda("ars");
        // 'extracting' nos permite extraer una propiedad de cada elemento de la lista.
        // Luego verificamos que la lista de nombres comunes contenga "Argentina".
        assertThat(lista).extracting(p -> p.getNombre().getComun()).contains("Argentina");
    }

    /**
     * Prueba que la búsqueda por región "europe" devuelve una lista no vacía y que todos los países son de esa región.
     */
    @Test
    void buscarPorRegionEuropeNoVacia() {
        var lista = buscadorDePaises.buscarPorRegion("europe");
        assertThat(lista).isNotEmpty();
        // 'allMatch' verifica que todos los elementos de la lista cumplan con el predicado.
        assertThat(lista).allMatch(p -> "Europe".equals(p.getRegion()));
    }

    /**
     * Prueba que al buscar por la capital "buenos aires", se obtiene Argentina.
     */
    @Test
    void buscarPorCapitalBuenosAiresDevuelveArgentina() {
        var lista = buscadorDePaises.buscarPorCapital("buenos aires");
        assertThat(lista).isNotEmpty();
        assertThat(lista.getFirst().getCca2()).isEqualTo("AR");
    }
}
