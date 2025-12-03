package strategy;

public class CalculadoraDePrecios {
    private DescuentoStrategy estrategia;

    public void setEstrategia(DescuentoStrategy estrategia) {
        this.estrategia = estrategia;
    }

    public double calcularPrecio(Producto producto, int cantidad) {
        return estrategia.aplicarDescuento(producto.getPrecio(), cantidad);
    }
}
