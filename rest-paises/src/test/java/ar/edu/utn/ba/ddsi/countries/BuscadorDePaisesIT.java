package ar.edu.utn.ba.ddsi.countries;

import ar.edu.utn.ba.ddsi.countries.services.BuscadorDePaises;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BuscadorDePaisesIT {

    @Autowired
    private BuscadorDePaises buscadorDePaises;

    @Test
    void buscarTodosDevuelveVariosPaises() {
        var lista = buscadorDePaises.buscarTodos();
        assertThat(lista).isNotEmpty();
        assertThat(lista.getFirst().getNombre().getComun()).isNotBlank();
    }

    @Test
    void buscarPorNombrePeruDevuelvePeru() {
        var opt = buscadorDePaises.buscarPorNombre("peru");
        assertThat(opt).isPresent();
        assertThat(opt.get().getNombre().getComun()).isEqualTo("Peru");
        assertThat(opt.get().getCca2()).isEqualTo("PE");
    }

    @Test
    void buscarPorMonedaARSincluyeArgentina() {
        var lista = buscadorDePaises.buscarPorMoneda("ars");
        assertThat(lista).extracting(p -> p.getNombre().getComun()).contains("Argentina");
    }

    @Test
    void buscarPorRegionEuropeNoVacia() {
        var lista = buscadorDePaises.buscarPorRegion("europe");
        assertThat(lista).isNotEmpty();
        assertThat(lista).allMatch(p -> "Europe".equals(p.getRegion()));
    }

    @Test
    void buscarPorCapitalBuenosAiresDevuelveArgentina() {
        var lista = buscadorDePaises.buscarPorCapital("buenos aires");
        assertThat(lista).isNotEmpty();
        assertThat(lista.getFirst().getCca2()).isEqualTo("AR");
    }
}
