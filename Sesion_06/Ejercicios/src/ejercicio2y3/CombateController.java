package ejercicio2y3;

import java.util.Scanner;

public class CombateController {
    private CombateModel modelo;
    private CombateView vista;
    private Scanner scanner;

    public CombateController(CombateModel modelo, CombateView vista) {
        this.modelo = modelo;
        this.vista = vista;
        this.scanner = new Scanner(System.in);
    }

    public void iniciarCombate() {
        vista.mostrarMensaje("¡Comienza el combate!");
        while (!modelo.combateTerminado()) {
            vista.mostrarEstadoCombate(modelo.getJugador(), modelo.getEnemigo());

            System.out.println("\nAcciones:");
            System.out.println("1. Atacar");
            System.out.println("2. Usar objeto");
            System.out.print("Selecciona una acción: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    int danioJugador = modelo.getJugador().atacar();
                    modelo.getEnemigo().recibirDanio(danioJugador);
                    vista.mostrarMensaje("El jugador ataca y causa " + danioJugador + " de daño.");
                    break;
                case "2":
                    String nombreItem = modelo.getJugador().getInventario().obtenerItems().isEmpty()
                        ? null
                        : modelo.getJugador().getInventario().obtenerItems().get(0).getNombre();
                    if (nombreItem != null) {
                        modelo.getJugador().usarObjeto(nombreItem);
                    } else {
                        vista.mostrarMensaje("No hay objetos para usar.");
                    }
                    break;
                default:
                    vista.mostrarMensaje("Acción no válida.");
            }

            if (modelo.getEnemigo().estaVivo()) {
                int danioEnemigo = modelo.getEnemigo().atacar();
                modelo.getJugador().recibirDanio(danioEnemigo);
                vista.mostrarMensaje("El enemigo ataca y causa " + danioEnemigo + " de daño.");
            }
        }

        vista.mostrarEstadoCombate(modelo.getJugador(), modelo.getEnemigo());
        if (modelo.getJugador().estaVivo()) {
            vista.mostrarMensaje("¡Has ganado el combate!");
        } else {
            vista.mostrarMensaje("Has sido derrotado...");
        }
    }
}