package GameZone.GameZone.model;

import java.util.ArrayList;
import java.util.List;

public class Carrito {

    private Usuario usuario;
    private List<LineaCarrito> lineas;

    public Carrito() {
        this.lineas = new ArrayList<>();
    }

    public Carrito(Usuario usuario) {
        this.usuario = usuario;
        this.lineas = new ArrayList<>();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<LineaCarrito> getLineas() {
        return lineas;
    }

    public void setLineas(List<LineaCarrito> lineas) {
        this.lineas = lineas;
    }
}