package ejercicio_1;

import java.util.Scanner;

public class Calculadora{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Calculadora ===");
        System.out.print("Ingrese el primer número: ");
        double num1 = sc.nextDouble();

        System.out.print("Ingrese el segundo número: ");
        double num2 = sc.nextDouble();

        System.out.println("Seleccione la operación (+, -, *, /): ");
        char operacion = sc.next().charAt(0);

        double resultado = 0;
        boolean operacionValida = true;

        switch (operacion) {
            case '+':
                resultado = num1 + num2;
                break;
            case '-':
                resultado = num1 - num2;
                break;
            case '*':
                resultado = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    resultado = num1 / num2;
                } else {
                    System.out.println("Error: División por cero no permitida.");
                    operacionValida = false;
                }
                break;
            default:
                System.out.println("Operación no válida.");
                operacionValida = false;
        }

        if (operacionValida) {
            System.out.println("Resultado: " + resultado);
        }

        sc.close();
    }
}