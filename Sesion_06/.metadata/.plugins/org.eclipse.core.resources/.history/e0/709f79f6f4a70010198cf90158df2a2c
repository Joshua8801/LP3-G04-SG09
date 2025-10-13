package ejercicio1;

import java.util.List;
import java.util.Scanner;

public class VistaConsola {
    private Scanner sc = new Scanner(System.in);

    public int mostrarMenu() {
        System.out.println("\n--- MENÚ CARRITO DE COMPRAS ---");
        System.out.println("1. Listar productos");
        System.out.println("2. Agregar producto al carrito");
        System.out.println("3. Ver carrito");
        System.out.println("4. Eliminar producto del carrito");
        System.out.println("5. Realizar compra");
        System.out.println("6. Ver historial de compras");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
        return sc.nextInt();
    }

    public void mostrarProductos(List<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
        } else {
            for (Producto p : productos) {
                System.out.println(p);
            }
        }
    }

    public int pedirIdProducto() {
        System.out.print("Ingrese ID del producto: ");
        return sc.nextInt();
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}
