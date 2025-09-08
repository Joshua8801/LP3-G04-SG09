package ejercicio_1;

public class CalculadoraPago {
    // Esta clase se encarga únicamente del cálculo del pago
    public double calcularPagoMensual(Empleado empleado) {
        return empleado.getSalarioAnual() / 12.0;
    }
}

