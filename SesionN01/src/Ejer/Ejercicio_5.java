package Ejer;

import java.util.Scanner;

public class Ejercicio_5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el numero de horas: ");
        int horas = scanner.nextInt();

        double cargo = calcularC(horas);
        System.out.println("El cargo por " + horas + " horas es: S/" + cargo);

        scanner.close();
    }

    public static double calcularC(int horas) {
        if (horas <= 0) {
            return 0.0;
        }

        double cargo = 3.0;
        if (horas > 1) {
            cargo += (horas - 1) * 0.5;
        }

        if (cargo > 12.0) {
            cargo = 12.0;
        }

        return cargo;
    }
}

