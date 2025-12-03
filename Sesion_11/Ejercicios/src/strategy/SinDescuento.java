package strategy;

public class SinDescuento implements DescuentoStrategy {
    @Override
    public double aplicarDescuento(double precio, int cantidad) {
        return precio * cantidad;
    }
}
