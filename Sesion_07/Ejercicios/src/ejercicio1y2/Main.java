package ejercicio1y2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ DE PERSONAJES ===");
            System.out.println("1. Agregar personaje");
            System.out.println("2. Listar personajes");
            System.out.println("3. Eliminar personaje");
            System.out.println("4. Salir");
            System.out.println("5. Filtrar por atributo");
            System.out.println("6. Cargar personajes aleatorios");
            System.out.println("7. Actualizar atributo de personaje");
            System.out.println("8. Mostrar estadísticas");
            System.out.println("9. Subir nivel de personaje");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("Vida: ");
                    int vida = sc.nextInt();
                    System.out.print("Ataque: ");
                    int ataque = sc.nextInt();
                    System.out.print("Defensa: ");
                    int defensa = sc.nextInt();
                    System.out.print("Alcance: ");
                    int alcance = sc.nextInt();
                    sc.nextLine();
                    gestor.agregar(new Personaje(nombre, vida, ataque, defensa, alcance));
                    break;

                case 2:
                    System.out.println("\n--- Lista de personajes ---");
                    for (Personaje p : gestor.listar()) System.out.println(p);
                    break;

                case 3:
                    System.out.print("Nombre del personaje a eliminar: ");
                    String eliminar = sc.nextLine();
                    gestor.eliminar(eliminar);
                    System.out.println("Eliminado (si existía).");
                    break;

                case 5:
                    System.out.print("Atributo (vida, ataque, defensa, alcance): ");
                    String attr = sc.nextLine();
                    for (Personaje p : gestor.filtrarPor(attr)) System.out.println(p);
                    break;

                case 6:
                    gestor.cargarAleatorios();
                    System.out.println("Personajes aleatorios cargados.");
                    break;

                case 7:
                    System.out.print("Nombre del personaje: ");
                    String nom = sc.nextLine();
                    System.out.print("Atributo a actualizar: ");
                    String at = sc.nextLine();
                    System.out.print("Nuevo valor: ");
                    int val = sc.nextInt();
                    sc.nextLine();
                    gestor.actualizarAtributo(nom, at, val);
                    break;

                case 8:
                    gestor.mostrarEstadisticas();
                    break;
                case 9:
                    System.out.print("Nombre del personaje a subir de nivel: ");
                    String nombreNivel = sc.nextLine();
                    for (Personaje p : gestor.listar()) {
                        if (p.getNombre().equalsIgnoreCase(nombreNivel)) {
                            p.subirNivel();
                            System.out.println("Nivel subido a " + p.getNivel());
                            gestor.guardarEnArchivo();
                            break;
                        }
                    }
                    break;
            }
        } while (opcion != 4);
        sc.close();
    }
}
