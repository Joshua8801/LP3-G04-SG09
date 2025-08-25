package Actividad_2;

public class Contador {
    static int acumulador = 0;
    final static int VALOR_INICIAL = 10;
    private int valor;

    public static int acumulador() {
        return acumulador;
    }

    public Contador(int valor) {
        this.valor = valor;
        acumulador += valor;
    }

    public Contador() {
    	new Contador(Contador.VALOR_INICIAL);
    }

    public void inc() {
        valor++;
        acumulador++;
    }

    public int getValor() {
        return this.valor;
    }
}

