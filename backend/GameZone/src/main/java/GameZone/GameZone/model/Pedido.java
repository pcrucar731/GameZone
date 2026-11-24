package GameZone.GameZone.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Pedido {

    private Long id;
    private String codigo;
    private Usuario usuario;
    private LocalDateTime fecha;
    private EstadoPedido estado;
    private String direccionEnvio;
    private BigDecimal subtotal;
    private BigDecimal gastosEnvio;
    private BigDecimal total;
    private List<LineaPedido> lineas;

    public Pedido() {
        this.fecha = LocalDateTime.now();
        this.estado = EstadoPedido.PENDIENTE;
        this.subtotal = BigDecimal.ZERO;
        this.gastosEnvio = BigDecimal.ZERO;
        this.total = BigDecimal.ZERO;
        this.lineas = new ArrayList<>();
    }

    public Pedido(Long id, String codigo, Usuario usuario,
                  String direccionEnvio, BigDecimal gastosEnvio) {

        this.id = id;
        this.codigo = codigo;
        this.usuario = usuario;
        this.fecha = LocalDateTime.now();
        this.estado = EstadoPedido.PENDIENTE;
        this.direccionEnvio = direccionEnvio;
        this.subtotal = BigDecimal.ZERO;
        this.gastosEnvio = gastosEnvio;
        this.total = BigDecimal.ZERO;
        this.lineas = new ArrayList<>();
    }

    public void calcularTotales() {
        subtotal = BigDecimal.ZERO;

        for (LineaPedido linea : lineas) {
            subtotal = subtotal.add(linea.getSubtotal());
        }

        total = subtotal.add(gastosEnvio);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getDireccionEnvio() {
        return direccionEnvio;
    }

    public void setDireccionEnvio(String direccionEnvio) {
        this.direccionEnvio = direccionEnvio;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public BigDecimal getGastosEnvio() {
        return gastosEnvio;
    }

    public void setGastosEnvio(BigDecimal gastosEnvio) {
        this.gastosEnvio = gastosEnvio;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaPedido> lineas) {
        this.lineas = lineas;
    }
}