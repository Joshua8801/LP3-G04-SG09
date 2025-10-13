package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Carrito {
    private List<Producto> productos;

    public Carrito() {
        productos = new ArrayList<>();
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }

    public void eliminarProducto(int id) {
        productos.removeIf(p -> p.getId() == id);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public double calcularTotal(double costoEnvio) {
        double total = 0;
        for (Producto p : productos) {
            total += p.getPrecioFinal();
        }
        return total + costoEnvio;
    }

    public void vaciar() {
        productos.clear();
    }
}