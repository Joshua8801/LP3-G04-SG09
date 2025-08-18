package Ejer;

import java.util.Scanner;

public class Ejercicio_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[10]; 

        System.out.println("Ingrese 10 números, cada uno mayor que el anterior:");

        
        System.out.print("Número 1: ");
        numeros[0] = scanner.nextInt();

      
        for (int i = 1; i < numeros.length; i++) {
            int num;
            do {
                System.out.print("Número " + (i + 1) + ": ");
                num = scanner.nextInt();

                if (num <= numeros[i - 1]) {
                    System.out.println("⚠️ El número debe ser mayor que " + numeros[i - 1]);
                }
            } while (num <= numeros[i - 1]); 

            numeros[i] = num;
        }

        System.out.println("\nNúmeros ingresados:");
        for (int n : numeros) {
            System.out.print(n + " ");
        }

        scanner.close(); 
    }
}
