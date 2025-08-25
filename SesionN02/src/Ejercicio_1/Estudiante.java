package Ejercicio_1;

public class Estudiante extends Persona {
    private String codigoEstudiante;

    public Estudiante(String nombre, String dni, String codigoEstudiante) {
        super(nombre, dni);
        this.codigoEstudiante = codigoEstudiante;
    }

    public String getCodigoEstudiante() {
        return codigoEstudiante;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Estudiante: " + nombre + " | DNI: " + dni + " | Código: " + codigoEstudiante);
    }
}


