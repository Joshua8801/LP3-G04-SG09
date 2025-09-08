package app;

import java.util.Scanner;
import model.Habitacion;
import model.Reserva;
import model.politicas.*;
import gestor.GestorDisponibilidadHabitacion;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion(new ArrayList<>());
        Habitacion habitacion = new Habitacion("101", "Suite", 150.0, gestor);

        System.out.println("Seleccione una política de cancelación:");
        System.out.println("1. Flexible (hasta 24h antes sin penalización)");
        System.out.println("2. Moderada (hasta 72h antes con 50% de penalización)");
        System.out.println("3. Estricta (no se permite cancelación)");
        System.out.print("Opción: ");
        int opcion = sc.nextInt();

        PoliticaCancelacion politica;
        switch (opcion) {
            case 1: politica = new PoliticaFlexible(); break;
            case 2: politica = new PoliticaModerada(); break;
            case 3: politica = new PoliticaEstricta(); break;
            default: 
                System.out.println("Opción inválida, se usará Flexible por defecto.");
                politica = new PoliticaFlexible();
        }
        Reserva reserva = new Reserva(habitacion, "2025-09-10", "2025-09-12", politica);
        System.out.println("\nIntentando cancelar la reserva...");
        boolean resultado = reserva.cancelar();
        System.out.println("¿Se pudo cancelar? " + resultado);

        sc.close();
    }
}
