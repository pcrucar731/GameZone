package GameZone.GameZone.controller;

import GameZone.GameZone.dto.StockDto;
import GameZone.GameZone.dto.VideoJuegoDetalleDto;
import GameZone.GameZone.dto.VideoJuegoResumenDto;
import GameZone.GameZone.model.VideoJuego;
import GameZone.GameZone.service.VideoJuegoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
public class VideoJuegoController {

    private final VideoJuegoService videoJuegoService;

    public VideoJuegoController(VideoJuegoService videoJuegoService) {
        this.videoJuegoService = videoJuegoService;
    }

    @GetMapping("/api/productos")
    public ResponseEntity<List<VideoJuegoResumenDto>> listarProductos(
            @RequestParam(required = false) Long categoriaId,
            @RequestParam(required = false) String q,
            @RequestParam(required = false) BigDecimal precioMin,
            @RequestParam(required = false) BigDecimal precioMax,
            @RequestParam(required = false) Boolean soloDisponibles,
            @RequestParam(required = false) String orden,
            @RequestParam(required = false) String direccion,
            @RequestParam(required = false) String plataforma) {

        if (precioMin != null && precioMax != null && precioMin.compareTo(precioMax) > 0) {
            return ResponseEntity.badRequest().build();
        }

        List<VideoJuego> listaOriginal = videoJuegoService.listarFiltrados(
                categoriaId, q, precioMin, precioMax, soloDisponibles, orden, direccion, plataforma);

        List<VideoJuegoResumenDto> listaDto = new ArrayList<>();
        for (VideoJuego v : listaOriginal) {
            VideoJuegoResumenDto dto = new VideoJuegoResumenDto(v);
            listaDto.add(dto);
        }

        return ResponseEntity.ok(listaDto);
    }

    @GetMapping("/api/productos/destacados")
    public ResponseEntity<List<VideoJuegoResumenDto>> listarDestacados() {
        List<VideoJuego> listaOriginal = videoJuegoService.listarDestacados();
        List<VideoJuegoResumenDto> listaDto = new ArrayList<>();
        for (VideoJuego v : listaOriginal) {
            listaDto.add(new VideoJuegoResumenDto(v));
        }
        return ResponseEntity.ok(listaDto);
    }

    @GetMapping("/api/productos/{id}")
    public ResponseEntity<VideoJuegoDetalleDto> obtenerPorId(@PathVariable Long id) {
        VideoJuego v = videoJuegoService.buscarPorId(id);
        if (v == null || !v.isActivo()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        VideoJuegoDetalleDto dto = new VideoJuegoDetalleDto(v);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/api/productos/sku/{sku}")
    public ResponseEntity<VideoJuegoDetalleDto> obtenerPorSku(@PathVariable String sku) {
        VideoJuego v = videoJuegoService.buscarPorSku(sku);
        if (v == null || !v.isActivo()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        VideoJuegoDetalleDto dto = new VideoJuegoDetalleDto(v);
        return ResponseEntity.ok(dto);
    }

    @GetMapping("/api/categorias/{id}/productos")
    public ResponseEntity<List<VideoJuegoResumenDto>> listarPorCategoria(@PathVariable Long id) {
        List<VideoJuego> listaOriginal = videoJuegoService.buscarPorGeneroId(id);
        List<VideoJuegoResumenDto> listaDto = new ArrayList<>();
        for (VideoJuego v : listaOriginal) {
            listaDto.add(new VideoJuegoResumenDto(v));
        }
        return ResponseEntity.ok(listaDto);
    }

    @GetMapping("/api/admin/productos")
    public ResponseEntity<List<VideoJuegoDetalleDto>> listarTodosAdmin() {
        List<VideoJuego> listaOriginal = videoJuegoService.listarTodosAdmin();
        List<VideoJuegoDetalleDto> listaDto = new ArrayList<>();
        for (VideoJuego v : listaOriginal) {
            listaDto.add(new VideoJuegoDetalleDto(v));
        }
        return ResponseEntity.ok(listaDto);
    }

    @GetMapping("/api/admin/productos/stock-bajo")
    public ResponseEntity<List<VideoJuegoResumenDto>> stockBajo(@RequestParam(defaultValue = "5") int umbral) {
        List<VideoJuego> listaOriginal = videoJuegoService.listarStockBajo(umbral);
        List<VideoJuegoResumenDto> listaDto = new ArrayList<>();
        for (VideoJuego v : listaOriginal) {
            listaDto.add(new VideoJuegoResumenDto(v));
        }
        return ResponseEntity.ok(listaDto);
    }

    @DeleteMapping("/api/admin/productos/{id}")
    public ResponseEntity<Void> retirarProducto(@PathVariable Long id) {
        VideoJuego v = videoJuegoService.buscarPorId(id);
        if (v == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        v.setActivo(false);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/api/admin/productos/{id}/stock")
    public ResponseEntity<Void> modificarStock(@PathVariable Long id, @RequestBody StockDto stockDto) {
        VideoJuego v = videoJuegoService.buscarPorId(id);
        if (v == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        int nuevoStock = v.getStock() + stockDto.getCantidad();
        if (nuevoStock < 0) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }
        v.setStock(nuevoStock);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/api/admin/productos/{id}/reactivar")
    public ResponseEntity<Void> reactivarProducto(@PathVariable Long id) {
        VideoJuego v = videoJuegoService.buscarPorId(id);
        if (v == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        v.setActivo(true);
        return ResponseEntity.ok().build();
    }
}