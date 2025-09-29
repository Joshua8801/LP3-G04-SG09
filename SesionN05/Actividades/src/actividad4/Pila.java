package actividad4;

public class Pila<E> {
    private final int tamanio;
    private int superior;
    private E[] elementos;

    public Pila() {
        this(10);
    }

    public Pila(int s) {
        tamanio = s > 0 ? s : 10;
        superior = -1;
        elementos = (E[]) new Object[tamanio];
    }

    public void push(E valorAMeter) {
        if (superior == tamanio - 1)
            throw new ExcepcionPilaLlena("La Pila está llena, no se puede meter " + valorAMeter);
        elementos[++superior] = valorAMeter;
    }

    public E pop() {
        if (superior == -1)
            throw new ExcepcionPilaVacia("Pila vacía, no se puede sacar");
        return elementos[superior--];
    }

    public boolean esIgual(Pila<E> otraPila) {
        if (this.superior != otraPila.superior) {
            return false;
        }

        for (int i = 0; i <= superior; i++) {
            if (!this.elementos[i].equals(otraPila.elementos[i])) {
                return false;
            }
        }

        return true;
    }

}