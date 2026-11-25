package GameZone.GameZone.dto;

import GameZone.GameZone.model.VideoJuego;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class VideoJuegoDetalleDto {
    private Long id;
    private String sku;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private int stock;
    private String imagenUrl;
    private boolean activo;
    private boolean destacado;
    private LocalDateTime fechaAlta;
    private String generoNombre;
    private String plataforma;
    private String desarrolladora;

    public VideoJuegoDetalleDto() {
    }

    public VideoJuegoDetalleDto(VideoJuego v) {
        this.id = v.getId();
        this.sku = v.getSku();
        this.nombre = v.getNombre();
        this.descripcion = v.getDescripcion();
        this.precio = v.getPrecio();
        this.stock = v.getStock();
        this.imagenUrl = v.getImagenUrl();
        this.activo = v.isActivo();
        this.destacado = v.isDestacado();
        this.fechaAlta = v.getFechaAlta();
        this.generoNombre = v.getGenero() != null ? v.getGenero().getNombre() : null;
        this.plataforma = v.getPlataforma();
        this.desarrolladora = v.getDesarrolladora();
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getGeneroNombre() {
        return generoNombre;
    }

    public void setGeneroNombre(String generoNombre) {
        this.generoNombre = generoNombre;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }
}