package ejercicio3;

import java.util.Scanner;

public class Main {

    public static <F, S> void imprimirPar(Par<F, S> par) {
        System.out.println("Par: " + par);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Ingrese la clave (String): ");
        String clave = sc.nextLine();
        System.out.print("Ingrese el valor (String): ");
        String valor = sc.nextLine();

        Par<String, String> par = new Par<>(clave, valor);

        imprimirPar(par);

        sc.close();
    }
}


