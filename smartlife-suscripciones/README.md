# 🏙️ Ecosistema SmartLife: Módulo de Suscripciones

Este proyecto forma parte de la resolución práctica para la asignatura **Diseño de Sistemas de Información (DDSI) - UTN FRBA**.
Implementa el subdominio de facturación y cálculo de suscripciones mensuales para el ecosistema orientado a servicios **SmartLife**.

## 📄 Enunciado del Ejercicio

El requerimiento detalla el cálculo de cuotas mensuales para distintos tipos de clientes dentro de la plataforma SmartLife (Hogares, Comercios, Corporativos), previendo la extensión futura a nuevos planes.

🔗 **[Ver Enunciado Completo: Cálculo de suscripción mensual - SmartLife](https://docs.google.com/document/d/1hvW6QScrupZhvX1PSHkuat3w4cC8DQshYQWbwKzKN8M/edit?usp=sharing)** 

---

## 🏗️ Diseño Arquitectónico y Patrones

El módulo fue diseñado aplicando fuertemente los principios del **Paradigma Orientado a Objetos (POO)** y las bases de **Clean Architecture**, asegurando bajo acoplamiento y alta cohesión dentro del paquete `domain.suscripciones`.

### Patrón Strategy (GoF)
Para resolver la variación en la lógica de cálculo según el tipo de plan, se aplicó el **Patrón Strategy**.
* **Ventaja Arquitectónica:** La clase `FacturaMensual` (Contexto) delega el cálculo a la abstracción `Plan` (Estrategia). Esto permite agregar nuevos tipos de planes en el futuro (Cumpliendo el principio *Open/Closed* de SOLID) sin modificar la lógica central de facturación y permite a los clientes cambiar de plan dinámicamente en tiempo de ejecución.

### Diagrama de Clases (Modelo de Dominio)
![UML](smartlife-suscripciones/DiagramaDeClases_Suscripciones.png)

---

## 🛠️ Stack Tecnológico

* **Lenguaje:** Java 21 (LTS)
* **Gestor de Dependencias:** Maven 3+
* **Testing:** JUnit 5 (Jupiter)
* **IDE Recomendado:** IntelliJ IDEA

---

## 🚀 Instalación y Ejecución

1. **Clonar el repositorio** o descargar el código fuente.
2. Abrir el proyecto en tu IDE (ej. IntelliJ IDEA) y permitir que Maven descargue las dependencias (JUnit 5) leyendo el archivo `pom.xml`.
3. **Ejecutar las pruebas unitarias:**
   Puedes correr los tests directamente desde la interfaz gráfica de tu IDE, o utilizando la terminal mediante Maven:

   ```bash
   mvn clean test
   ```

### 🧪 Cobertura de Tests
La suite de pruebas (`FacturaMensualTest`) valida las reglas de negocio críticas utilizando el estándar **AAA (Arrange, Act, Assert)**:
1. Retorno de tarifa base estricta para **Plan Hogar**.
2. Sumatoria de dispositivos adicionales para **Plan Comercio**.
3. Cálculo de márgenes porcentuales de descuento para **Plan Corporativo**.
4. Flexibilidad del sistema al inyectar un cambio de plan en tiempo de ejecución.

---
*UTN FRBA - Ingeniería en Sistemas de Información - Diseño de Sistemas de Información*