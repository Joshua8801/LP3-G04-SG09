package actividad3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese el primer valor: ");
        String valor1 = sc.nextLine();

        System.out.print("Ingrese el segundo valor: ");
        String valor2 = sc.nextLine();

        boolean resultado = IgualGenerico.esIgualA(valor1, valor2);

        System.out.println("¿Son iguales? " + resultado);

        sc.close();
    }
}

