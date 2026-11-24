# 🎮 GameZone

## Descripción del proyecto

GameZone es una tienda online de videojuegos desarrollada con Spring Boot. La aplicación permitirá consultar videojuegos de diferentes plataformas, buscar productos por género, añadirlos a un carrito y realizar pedidos.

La tienda contará con dos tipos de usuarios: clientes y administradores.

## Integrantes

- Pablo – Rama `Pablo`
- Francisco – Rama `Fran`

## Tecnologías utilizadas

- Java 21
- Spring Boot
- Spring Security
- Maven
- Git y GitHub
- Postman

## Temática de la tienda

La tienda estará especializada en videojuegos para diferentes plataformas:

- PlayStation 5
- Xbox Series X/S
- Nintendo Switch
- PC

Los videojuegos estarán organizados por géneros como deportes, acción, aventura, carreras y terror.

## Modelo de datos

| Clase genérica | Clase GameZone |
|---|---|
| Producto | Videojuego |
| Categoria | Genero |
| Usuario | Usuario |
| Carrito | Carrito |
| LineaCarrito | LineaCarrito |
| Pedido | Pedido |
| LineaPedido | LineaPedido |
| Rol | Rol |
| EstadoPedido | EstadoPedido |

### Atributos propios

La clase Videojuego tendrá dos atributos propios:

- plataforma
- desarrolladora

## Versiones del proyecto

- **Versión 1:** API REST con datos en memoria, autenticación, catálogo, carrito y pedidos.
- **Versión 2:** Incorporación de base de datos con Spring Data JPA.
- **Versión 3:** Interfaz de cliente con Vue.js.
- **Versión 4:** Administración, estadísticas y despliegue.
