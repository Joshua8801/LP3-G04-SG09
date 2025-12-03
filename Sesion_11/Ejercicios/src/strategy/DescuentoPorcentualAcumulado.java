package strategy;

public class DescuentoPorcentualAcumulado implements DescuentoStrategy {
    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        double total = precio * cantidad;
        if (cantidad >= 3) {
            total -= precio * 0.5; // 50% sobre un producto
        }
        return total;
    }
}
