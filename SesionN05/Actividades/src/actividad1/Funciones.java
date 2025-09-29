package actividad1;

public class Funciones {

    public static <T> void imprimirArreglo(T[] arreglo) {
        for (T elemento : arreglo) {
            System.out.print(elemento + " ");
        }
        System.out.println();
    }

    public static <T> int imprimirArreglo(T[] arreglo, int subindiceInferior, int subindiceSuperior) throws InvalidSubscriptException {
        if (subindiceInferior < 0 || subindiceSuperior >= arreglo.length || subindiceSuperior <= subindiceInferior) {
            throw new InvalidSubscriptException("Índices inválidos: fuera de rango o mal ordenados.");
        }

        int cantidad = 0;
        for (int i = subindiceInferior; i <= subindiceSuperior; i++) {
            System.out.print(arreglo[i] + " ");
            cantidad++;
        }
        System.out.println();
        return cantidad;
    }
}

