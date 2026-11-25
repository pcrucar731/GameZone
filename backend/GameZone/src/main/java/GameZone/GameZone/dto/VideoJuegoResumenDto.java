package GameZone.GameZone.dto;

import GameZone.GameZone.model.VideoJuego;
import java.math.BigDecimal;

public class VideoJuegoResumenDto {
    private Long id;
    private String sku;
    private String nombre;
    private BigDecimal precio;
    private int stock;
    private String imagenUrl;
    private boolean destacado;
    private String plataforma;

    public VideoJuegoResumenDto() {
    }

    public VideoJuegoResumenDto(VideoJuego v) {
        this.id = v.getId();
        this.sku = v.getSku();
        this.nombre = v.getNombre();
        this.precio = v.getPrecio();
        this.stock = v.getStock();
        this.imagenUrl = v.getImagenUrl();
        this.destacado = v.isDestacado();
        this.plataforma = v.getPlataforma();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }
}