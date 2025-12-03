package strategy;

public class DescuentoPorcentual implements DescuentoStrategy {
    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        double total = precio * cantidad;
        if (cantidad >= 2) {
            total *= 0.7; // 30% de descuento si hay 2 productos
        }
        return total;
    }
}
