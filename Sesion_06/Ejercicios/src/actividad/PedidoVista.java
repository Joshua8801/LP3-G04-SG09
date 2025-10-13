package actividad;

import java.util.List;
import java.util.Scanner;

public class PedidoVista {
    private Scanner scanner;

    public PedidoVista() {
        scanner = new Scanner(System.in);
    }

    public String solicitarNombrePlato() {
        System.out.print("Introduce el nombre del plato: ");
        return scanner.nextLine();
    }

    public String solicitarTipoPlato() {
        System.out.print("Introduce el tipo del plato: ");
        return scanner.nextLine();
    }

    public void mostrarPedidos(List<Pedido> pedidos) {
        if (pedidos.isEmpty()) {
            System.out.println("No hay pedidos para mostrar.");
        } else {
            System.out.println("Pedidos:");
            for (Pedido p : pedidos) {
                System.out.println("- " + p.getNombrePlato() + " (" + p.getTipo() + ") - Estado: " + p.getEstado());
            }
        }
    }

    public void mostrarMenu() {
        System.out.println("\nMenú de Opciones:");
        System.out.println("1. Agregar Pedido");
        System.out.println("2. Mostrar Todos los Pedidos");
        System.out.println("3. Eliminar Pedido");
        System.out.println("4. Actualizar Pedido");
        System.out.println("5. Marcar Pedido como Completo");
        System.out.println("6. Mostrar Pedidos por Estado");
        System.out.println("7. Contador de Pedidos Pendientes");
        System.out.println("8. Ver Historial de Pedidos");
        System.out.println("9. Salir");
    }

    public String solicitarOpcion() {
        System.out.print("Selecciona una opción: ");
        return scanner.nextLine();
    }

    public String solicitarEstado() {
        System.out.print("Introduce el estado (pendiente/completo/eliminado): ");
        return scanner.nextLine();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void cerrarScanner() {
        scanner.close();
    }
}

