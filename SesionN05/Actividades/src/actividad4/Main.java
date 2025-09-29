package actividad4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Pila<String> pila1 = new Pila<>();
        Pila<String> pila2 = new Pila<>();

        System.out.print("Ingrese la cantidad de elementos para la pila 1: ");
        int n1 = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n1; i++) {
            System.out.print("Elemento " + (i + 1) + " de la pila 1: ");
            pila1.push(sc.nextLine());
        }

        System.out.print("\nIngrese la cantidad de elementos para la pila 2: ");
        int n2 = sc.nextInt();
        sc.nextLine();
        for (int i = 0; i < n2; i++) {
            System.out.print("Elemento " + (i + 1) + " de la pila 2: ");
            pila2.push(sc.nextLine());
        }

        System.out.println("\n¿Son iguales? " + pila1.esIgual(pila2));

    }
}

