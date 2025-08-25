package Actividad_2;

public class ContadorTest {
    public static void main(String[] args) {
        System.out.println("Acumulador inicial: " + Contador.acumulador());

        Contador c1 = new Contador();
        System.out.println("Valor de c1: " + c1.getValor());
        System.out.println("Acumulador tras crear c1: " + Contador.acumulador());

        Contador c2 = new Contador(5);
        System.out.println("Valor de c2: " + c2.getValor());
        System.out.println("Acumulador tras crear c2: " + Contador.acumulador());

        c1.inc();
        c2.inc();
        System.out.println("Valor de c1 después de inc(): " + c1.getValor());
        System.out.println("Valor de c2 después de inc(): " + c2.getValor());

        System.out.println("Acumulador final: " + Contador.acumulador());
    }
}


