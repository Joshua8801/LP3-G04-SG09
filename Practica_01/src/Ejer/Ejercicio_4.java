package Ejer;

import java.util.Scanner;

public class Ejercicio_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el primer numero: ");
        double a = scanner.nextDouble();
        System.out.print("Ingrese el segundo numero: ");
        double b = scanner.nextDouble();
        System.out.print("Ingrese el tercer numero: ");
        double c = scanner.nextDouble();

        double menor = menor(a, b, c);
        System.out.println("El menor es: " + menor);

        scanner.close();
    }

    public static double menor(double a, double b, double c) {
        double min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }
}

