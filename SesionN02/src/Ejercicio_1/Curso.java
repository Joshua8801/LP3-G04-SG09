package Ejercicio_1;

import java.util.ArrayList;
import java.util.List;

public class Curso {
    private String nombre;
    private String categoria;
    private Profesor profesor;
    private List<Estudiante> estudiantes;

    public Curso(String nombre, String categoria, Profesor profesor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.profesor = profesor;
        this.estudiantes = new ArrayList<>();
    }

    public void inscribirEstudiante(Estudiante e) {
        estudiantes.add(e);
    }

    public void mostrarCurso() {
        System.out.println("Curso: " + nombre + " | Categoría: " + categoria);
        profesor.mostrarInformacion();
        System.out.println("Estudiantes inscritos:");
        for (Estudiante e : estudiantes) {
            e.mostrarInformacion();
        }
    }
}

