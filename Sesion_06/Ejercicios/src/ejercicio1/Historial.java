package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Historial {
    private List<List<Producto>> comprasRealizadas;

    public Historial() {
        comprasRealizadas = new ArrayList<>();
    }

    public void registrarCompra(List<Producto> compra) {
        comprasRealizadas.add(new ArrayList<>(compra));
    }

    public List<List<Producto>> getHistorial() {
        return comprasRealizadas;
    }
}
