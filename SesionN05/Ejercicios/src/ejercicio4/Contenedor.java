package ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Contenedor<F, S> {
    private List<Par<F, S>> listaDePares;

    public Contenedor() {
        listaDePares = new ArrayList<>();
    }

    public void agregarPar(F primero, S segundo) {
        listaDePares.add(new Par<>(primero, segundo));
    }

    public Par<F, S> obtenerPar(int indice) {
        if (indice >= 0 && indice < listaDePares.size()) {
            return listaDePares.get(indice);
        }
        return null;
    }

    public List<Par<F, S>> obtenerTodosLosPares() {
        return listaDePares;
    }

    public void mostrarPares() {
        for (Par<F, S> par : listaDePares) {
            System.out.println(par);
        }
    }
}