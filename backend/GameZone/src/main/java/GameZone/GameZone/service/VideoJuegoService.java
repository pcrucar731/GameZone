package GameZone.GameZone.service;

import GameZone.GameZone.model.Genero;
import GameZone.GameZone.model.VideoJuego;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VideoJuegoService {

    private List<Genero> generos = new ArrayList<>();
    private List<VideoJuego> videojuegos = new ArrayList<>();

    public VideoJuegoService() {
        cargarDatosEjemplo();
    }

    private void cargarDatosEjemplo() {
        Genero g1 = new Genero(1L, "RPG", "Juegos de rol y aventura");
        Genero g2 = new Genero(2L, "Acción", "Juegos de combate y velocidad");
        Genero g3 = new Genero(3L, "Estrategia", "Juegos de gestión y táctica");
        generos.add(g1);
        generos.add(g2);
        generos.add(g3);

        videojuegos.add(new VideoJuego(1L, "ZEL-BOTw-01", "The Legend of Zelda: Breath of the Wild", "Aventura épica en mundo abierto.", new BigDecimal("59.99"), 10, "https://images.unsplash.com/photo-1550745165-9bc0b252726f", true, true, LocalDateTime.now().minusDays(15), g1, "SWITCH", "Nintendo"));
        videojuegos.add(new VideoJuego(2L, "W-3-WILD", "The Witcher 3: Wild Hunt", "Rol de fantasía oscura.", new BigDecimal("39.99"), 6, "https://images.unsplash.com/photo-1538481199705-c710c4e965fc", true, true, LocalDateTime.now().minusDays(20), g1, "PC", "CD Projekt Red"));
        videojuegos.add(new VideoJuego(3L, "ELD-RING-03", "Elden Ring", "Acción RPG desafiante.", new BigDecimal("49.99"), 0, "https://images.unsplash.com/photo-1612287233002-ef1d016f561f", true, false, LocalDateTime.now().minusDays(5), g1, "PS5", "FromSoftware"));
        videojuegos.add(new VideoJuego(4L, "CYBER-2077", "Cyberpunk 2077", "RPG futurista en Night City.", new BigDecimal("29.99"), 12, "https://images.unsplash.com/photo-1542751371-adc38448a05e", true, true, LocalDateTime.now().minusDays(10), g1, "PC", "CD Projekt Red"));

        videojuegos.add(new VideoJuego(5L, "GOD-RAGN-01", "God of War Ragnarök", "Acción mitológica nórdica.", new BigDecimal("69.99"), 4, "https://images.unsplash.com/photo-1607604276583-eef5d076aa5f", true, true, LocalDateTime.now().minusDays(25), g2, "PS5", "Santa Monica Studio"));
        videojuegos.add(new VideoJuego(6L, "HALO-INFIN", "Halo Infinite", "Shooter de acción espacial.", new BigDecimal("35.00"), 0, "https://images.unsplash.com/photo-1579373903781-fd5c0c30c4cd", true, false, LocalDateTime.now().minusDays(30), g2, "XBOX", "343 Industries"));
        videojuegos.add(new VideoJuego(7L, "DOOM-ETERN", "Doom Eternal", "Acción frenética contra demonios.", new BigDecimal("19.99"), 15, "https://images.unsplash.com/photo-1552820728-8b83bb6b773f", true, false, LocalDateTime.now().minusDays(8), g2, "PC", "id Software"));
        videojuegos.add(new VideoJuego(8L, "HADES-GAME", "Hades", "Roguelike de acción rápida.", new BigDecimal("24.99"), 20, "https://images.unsplash.com/photo-1511512578047-dfb367046420", true, true, LocalDateTime.now().minusDays(12), g2, "SWITCH", "Supergiant Games"));

        videojuegos.add(new VideoJuego(9L, "CIVIL-VI-01", "Civilization VI", "Estrategia por turnos global.", new BigDecimal("29.99"), 8, "https://images.unsplash.com/photo-1618005182384-a83a8bd57fbe", true, false, LocalDateTime.now().minusDays(18), g3, "PC", "Firaxis Games"));
        videojuegos.add(new VideoJuego(10L, "AGE-EMP-IV", "Age of Empires IV", "Estrategia en tiempo real medieval.", new BigDecimal("49.99"), 5, "https://images.unsplash.com/photo-1534447677768-be436bb09401", true, true, LocalDateTime.now().minusDays(22), g3, "PC", "Relic Entertainment"));
        videojuegos.add(new VideoJuego(11L, "CITIES-SKYL", "Cities: Skylines", "Simulador de construcción de ciudades.", new BigDecimal("27.50"), 14, "https://images.unsplash.com/photo-1508739773434-c26b3d09e071", true, false, LocalDateTime.now().minusDays(3), g3, "PC", "Colossal Order"));

        videojuegos.add(new VideoJuego(12L, "OLD-GAME-99", "Videojuego Descartado Clásico", "Antiguo título retirado del catálogo.", new BigDecimal("9.99"), 0, "https://images.unsplash.com/photo-1550745165-9bc0b252726f", false, false, LocalDateTime.now().minusDays(120), g1, "PC", "Desarrolladora Clásica"));
    }

    public List<VideoJuego> listarTodosAdmin() {
        return videojuegos;
    }

    public List<VideoJuego> listarDestacados() {
        List<VideoJuego> resultado = new ArrayList<>();
        for (VideoJuego v : videojuegos) {
            if (v.isActivo() && v.isDestacado()) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public VideoJuego buscarPorId(Long id) {
        for (VideoJuego v : videojuegos) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        return null;
    }

    public VideoJuego buscarPorSku(String sku) {
        for (VideoJuego v : videojuegos) {
            if (v.getSku().equalsIgnoreCase(sku)) {
                return v;
            }
        }
        return null;
    }

    public List<VideoJuego> buscarPorGeneroId(Long generoId) {
        List<VideoJuego> resultado = new ArrayList<>();
        for (VideoJuego v : videojuegos) {
            if (v.isActivo() && v.getGenero() != null && v.getGenero().getId().equals(generoId)) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public List<VideoJuego> listarStockBajo(int umbral) {
        List<VideoJuego> resultado = new ArrayList<>();
        for (VideoJuego v : videojuegos) {
            if (v.isActivo() && v.getStock() <= umbral) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public List<VideoJuego> listarFiltrados(Long categoriaId, String q, BigDecimal precioMin, BigDecimal precioMax,
                                            Boolean soloDisponibles, String orden, String direccion, String plataforma) {
        List<VideoJuego> resultado = new ArrayList<>();

        for (VideoJuego v : videojuegos) {
            // Solo productos activos
            if (!v.isActivo()) {
                continue;
            }

            // Filtrar por categoría (género)
            if (categoriaId != null) {
                if (v.getGenero() == null || !v.getGenero().getId().equals(categoriaId)) {
                    continue;
                }
            }

            // Filtrar por texto (nombre o descripción)
            if (q != null && !q.isEmpty()) {
                String nombreLower = v.getNombre().toLowerCase();
                String descLower = v.getDescripcion().toLowerCase();
                String queryLower = q.toLowerCase();
                if (!nombreLower.contains(queryLower) && !descLower.contains(queryLower)) {
                    continue;
                }
            }

            // Filtrar por precio mínimo
            if (precioMin != null) {
                if (v.getPrecio().compareTo(precioMin) < 0) {
                    continue;
                }
            }

            // Filtrar por precio máximo
            if (precioMax != null) {
                if (v.getPrecio().compareTo(precioMax) > 0) {
                    continue;
                }
            }

            // Filtrar por disponibilidad (stock > 0)
            if (soloDisponibles != null && soloDisponibles) {
                if (v.getStock() <= 0) {
                    continue;
                }
            }

            // Filtrar por plataforma
            if (plataforma != null && !plataforma.isEmpty()) {
                if (!v.getPlataforma().equalsIgnoreCase(plataforma)) {
                    continue;
                }
            }

            resultado.add(v);
        }

        return resultado;
    }
}