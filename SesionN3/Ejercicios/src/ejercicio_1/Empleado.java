package ejercicio_1;

public class Empleado {
    private String nombre;
    private double salarioAnual;
    private String departamento;

    public Empleado(String nombre, double salarioAnual, String departamento) {
        this.nombre = nombre;
        this.salarioAnual = salarioAnual;
        this.departamento = departamento;
    }

    public String getNombre() {
        return nombre;
    }

    public double getSalarioAnual() {
        return salarioAnual;
    }

    public String getDepartamento() {
        return departamento;
    }
    
    @Override
    public String toString() {
        return "Empleado{" +
               "nombre='" + nombre + '\'' +
               ", salarioAnual=" + salarioAnual +
               ", departamento='" + departamento + '\'' +
               '}';
    }
}
