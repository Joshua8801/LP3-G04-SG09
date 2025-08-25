package Actividad_5;

import java.util.Scanner;
import java.util.ArrayList;

public class AppBanco {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<CuentaBancaria> cuentas = new ArrayList<>();
        cuentas.add(new CuentaAhorros("001", 1000, 0.02));
        cuentas.add(new CuentaCorriente("002", 2000));

        String opcion;
        do {
            System.out.println("\n=== Menú Banco ===");
            System.out.println("D) Depositar");
            System.out.println("R) Retirar");
            System.out.println("C) Consultar");
            System.out.println("S) Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.next().toUpperCase();

            switch (opcion) {
                case "D":
                    System.out.print("Número de cuenta: ");
                    String ncD = sc.next();
                    System.out.print("Monto a depositar: ");
                    double montoD = sc.nextDouble();
                    for (CuentaBancaria c : cuentas) {
                        if (c.getNumeroCuenta().equals(ncD)) {
                            c.depositar(montoD);
                        }
                    }
                    break;
                case "R":
                    System.out.print("Número de cuenta: ");
                    String ncR = sc.next();
                    System.out.print("Monto a retirar: ");
                    double montoR = sc.nextDouble();
                    for (CuentaBancaria c : cuentas) {
                        if (c.getNumeroCuenta().equals(ncR)) {
                            c.retirar(montoR);
                        }
                    }
                    break;
                case "C":
                    System.out.println("=== Consultando todas las cuentas ===");
                    for (CuentaBancaria c : cuentas) {
                        c.consultar();
                    }
                    break;
                case "S":
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (!opcion.equals("S"));

        sc.close();
    }
}
