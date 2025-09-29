package ejercicio4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Contenedor<String, String> contenedor = new Contenedor<>();
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar par");
            System.out.println("2. Mostrar pares");
            System.out.println("3. Obtener par por índice");
            System.out.println("0. Salir");
            System.out.print("Elija una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la clave (String): ");
                    String clave = sc.nextLine();
                    System.out.print("Ingrese el valor (String): ");
                    String valor = sc.nextLine();
                    contenedor.agregarPar(clave, valor);
                    break;
                case 2:
                    contenedor.mostrarPares();
                    break;
                case 3:
                    System.out.print("Ingrese el índice: ");
                    int indice = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Par en índice " + indice + ": " + contenedor.obtenerPar(indice));
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }
}