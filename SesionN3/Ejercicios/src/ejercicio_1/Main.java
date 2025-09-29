package ejercicio_1;

public class Main {
    public static void main(String[] args) {
        Empleado emp = new Empleado("Ana", 24000.0, "Sistemas");
        CalculadoraPago calc = new CalculadoraPago();

        System.out.println("Empleado: " + emp.getNombre());
        System.out.println("Departamento: " + emp.getDepartamento());
        System.out.println("Salario anual: " + emp.getSalarioAnual());
        System.out.printf("Pago mensual: %.2f%n", calc.calcularPagoMensual(emp));
    }
}

