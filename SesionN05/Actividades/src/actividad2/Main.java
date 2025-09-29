package actividad2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pila<String> pila = new Pila<>();

        System.out.print("Ingrese la cantidad de elementos para la pila: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        for (int i = 0; i < n; i++) {
            System.out.print("Ingrese el elemento " + (i + 1) + ": ");
            String valor = sc.nextLine();
            pila.push(valor);
        }

        System.out.print("\nIngrese un elemento a verificar si está en la pila: ");
        String buscar1 = sc.nextLine();
        System.out.println("¿Contiene '" + buscar1 + "'? " + pila.contains(buscar1));

        sc.close();
    }
}
