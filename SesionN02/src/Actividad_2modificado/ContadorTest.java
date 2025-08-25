package Actividad_2modificado;

public class ContadorTest {
    public static void main(String[] args) {
        System.out.println("Acumulador inicial: " + Contador.acumulador());
        System.out.println("Número de contadores: " + Contador.getNContadores());

        Contador c1 = new Contador();
        Contador c2 = new Contador(7);
        Contador c3 = new Contador(15);

        System.out.println("Valor de c1: " + c1.getValor());
        System.out.println("Valor de c2: " + c2.getValor());
        System.out.println("Valor de c3: " + c3.getValor());

        System.out.println("Acumulador global: " + Contador.acumulador());
        System.out.println("Número de contadores creados: " + Contador.getNContadores());
        System.out.println("Último valor inicial usado: " + Contador.getUltimoContador());

        c1.inc();
        c2.inc();

        System.out.println("Valor de c1 después de inc: " + c1.getValor());
        System.out.println("Valor de c2 después de inc: " + c2.getValor());
        System.out.println("Acumulador final: " + Contador.acumulador());
    }
}

