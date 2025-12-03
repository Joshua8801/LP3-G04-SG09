package strategy;

public class DescuentoFijo implements DescuentoStrategy {
    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        return precio * cantidad * 0.9; // 10% de descuento fijo
    }
}
