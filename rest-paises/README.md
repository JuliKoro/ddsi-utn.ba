# rest-paises

Ejemplo educativo de **consumo de una API REST** pública: [REST Countries](https://restcountries.com/). Los datos se obtienen de la versión documentada del sitio (por ejemplo `v3.1`), que expone información sobre países vía HTTP.

## Objetivo

Centralizar en un componente **`BuscadorDePaises`** una interfaz de uso en código para consultar países según distintos criterios alineados con la API:

- listado de todos los países (con filtro de campos requerido por el servicio),
- búsqueda por nombre,
- búsqueda por código de moneda,
- búsqueda por región,
- búsqueda por capital.

La URL base y el prefijo de configuración se parametrizan con propiedades Spring (`rest-countries.*`).

## Alcance de la demo

Este proyecto **no** incluye controladores REST propios ni interfaz de usuario: **solo pretende mostrar el uso del buscador mediante pruebas automatizadas** en `src/test`. Allí se levanta el contexto de Spring y se ejecutan las consultas contra el servicio externo (comportamiento típico de test de integración con API real).

## Tecnologías

| Tecnología | Uso |
|------------|-----|
| **Java 21** | Lenguaje y runtime |
| **Spring Boot** (Web MVC) | Aplicación, inyección de dependencias y cliente HTTP |
| **`RestTemplate`** | Llamadas GET y deserialización a DTOs |
| **`UriComponentsBuilder`** | Construcción de URIs con query params (p. ej. `fields=…`) |
| **Lombok** | Reducción de boilerplate en DTOs y propiedades (`@Data`, etc.) |
| **`@ConfigurationProperties`** | Configuración tipada (`RestCountriesProperties`) |
| **JUnit 5** | Tests |
| **Spring Boot Test** (`@SpringBootTest`) | Contexto Spring en tests |
| **AssertJ** | Aserciones legibles en tests |

## Consideraciones

Las pruebas dependen de **conectividad** hacia la API de REST Countries.
