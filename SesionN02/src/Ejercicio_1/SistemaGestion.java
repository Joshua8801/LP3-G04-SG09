package Ejercicio_1;

import java.util.ArrayList;
import java.util.List;

public class SistemaGestion {
    private List<Curso> cursos;

    public SistemaGestion() {
        cursos = new ArrayList<>();
    }

    public void agregarCurso(Curso curso) {
        cursos.add(curso);
    }

    public void mostrarCursos() {
        for (Curso c : cursos) {
            c.mostrarCurso();
            System.out.println("------------");
        }
    }
}

