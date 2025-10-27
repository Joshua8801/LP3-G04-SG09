package ejercicio2;

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
			GestorPersona gestor = new GestorPersona();

			while (true) {
			    System.out.println("\n--- MENÚ DE CONSULTAS ---");
			    System.out.println("1. Mostrar registros personalizados");
			    System.out.println("2. Salir");
			    System.out.print("Seleccione una opción: ");
			    int opcion = sc.nextInt(); sc.nextLine();

			    switch (opcion) {
			        case 1 -> {
			            gestor.cargarDesdeBD();

			            System.out.print("Campos a mostrar (id,nombre,edad,correo separados por coma): ");
			            List<String> campos = Arrays.asList(sc.nextLine().split(","));

			            System.out.print("¿Deseas aplicar una condición? (campo o ENTER): ");
			            String campoCond = sc.nextLine();
			            String valorCond = null;
			            if (!campoCond.isBlank()) {
			                System.out.print("Valor para " + campoCond + ": ");
			                valorCond = sc.nextLine();
			            }

			            System.out.print("¿Ordenar por algún campo? (id,nombre,edad o ENTER): ");
			            String campoOrden = sc.nextLine();
			            boolean asc = true;
			            if (!campoOrden.isBlank()) {
			                System.out.print("¿Ascendente? (true/false): ");
			                asc = Boolean.parseBoolean(sc.nextLine());
			            }

			            System.out.print("¿Limitar cantidad de resultados? (número o 0): ");
			            int limite = Integer.parseInt(sc.nextLine());

			            List<Persona> resultado = gestor.consultar(campos, campoCond, valorCond, campoOrden, asc, limite);
			            System.out.println("\n--- RESULTADOS ---");
			            gestor.mostrarConsulta(resultado, campos);
			        }
			        case 2 -> {
			            System.out.println("¡Hasta luego!");
			            return;
			        }
			        default -> System.out.println("Opción inválida.");
			    }
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
    }
}