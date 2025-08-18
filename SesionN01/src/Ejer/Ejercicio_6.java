package Ejer;

import java.util.Scanner;

public class Ejercicio_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese las horas: ");
        int horas = scanner.nextInt();

        System.out.print("Ingrese los minutos: ");
        int minutos = scanner.nextInt();

        System.out.print("Ingrese los segundos: ");
        int segundos = scanner.nextInt();

        int totalSegundos = convertirASegundos(horas, minutos, segundos);
        System.out.println("Segundos totales: " + totalSegundos);

        scanner.close();
    }

    public static int convertirASegundos(int horas, int minutos, int segundos) {
        return horas * 3600 + minutos * 60 + segundos;
    }
}

