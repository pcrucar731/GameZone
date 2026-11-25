package GameZone.GameZone.model;

import java.math.BigDecimal;

public class LineaCarrito {

    private Long id;
    private VideoJuego videojuego;
    private int cantidad;
    private BigDecimal precioUnitario;

    public LineaCarrito() {
    }

    public LineaCarrito(Long id, VideoJuego videojuego, int cantidad, BigDecimal precioUnitario) {
        this.id = id;
        this.videojuego = videojuego;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public VideoJuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(VideoJuego videojuego) {
        this.videojuego = videojuego;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    // Método auxiliar para calcular el importe total de esta línea (precio * cantidad)
    public BigDecimal getSubtotal() {
        if (precioUnitario == null) {
            return BigDecimal.ZERO;
        }
        return precioUnitario.multiply(new BigDecimal(cantidad));
    }
}