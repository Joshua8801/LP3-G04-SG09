package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<List<Producto>> compras;

    public Historial() {
        compras = new ArrayList<>();
    }

    public void agregarCompra(List<Producto> productos) {
        compras.add(new ArrayList<>(productos));
    }

    public List<List<Producto>> getCompras() {
        return compras;
    }
}