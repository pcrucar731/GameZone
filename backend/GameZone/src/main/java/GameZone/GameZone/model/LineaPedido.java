package GameZone.GameZone.model;

import java.math.BigDecimal;

public class LineaPedido {

    private VideoJuego videojuego;
    private String nombreProducto;
    private BigDecimal precioUnitario;
    private int cantidad;
    private BigDecimal subtotal;

    public LineaPedido() {
    }

    public LineaPedido(VideoJuego videojuego, int cantidad) {
        this.videojuego = videojuego;
        this.nombreProducto = videojuego.getNombre();
        this.precioUnitario = videojuego.getPrecio();
        this.cantidad = cantidad;
        this.subtotal = precioUnitario.multiply(BigDecimal.valueOf(cantidad));
    }

    public VideoJuego getVideojuego() {
        return videojuego;
    }

    public void setVideojuego(VideoJuego videojuego) {
        this.videojuego = videojuego;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public BigDecimal getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(BigDecimal precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }
}