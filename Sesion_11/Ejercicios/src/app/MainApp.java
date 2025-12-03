package app;

import java.util.Scanner;
import observer.Notificacion;
import observer.Usuario;
import strategy.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // --- Observer ---
        Notificacion sistema = new Notificacion();
        Usuario juan = new Usuario("Juan");
        Usuario maria = new Usuario("Maria");
        sistema.suscribirse(juan);
        sistema.suscribirse(maria);

        // --- Strategy ---
        Producto prod = new Producto("Camiseta", 100);

        CalculadoraDePrecios calc = new CalculadoraDePrecios();
        System.out.println("Seleccione estrategia de descuento:");
        System.out.println("1. Sin descuento");
        System.out.println("2. Descuento fijo 10%");
        System.out.println("3. Descuento 30% por 2 productos");
        System.out.println("4. Descuento 50% a partir de 3 productos");
        int opcion = sc.nextInt();
        System.out.println("Cantidad de productos:");
        int cantidad = sc.nextInt();

        switch(opcion) {
            case 1: calc.setEstrategia(new SinDescuento()); break;
            case 2: calc.setEstrategia(new DescuentoFijo()); break;
            case 3: calc.setEstrategia(new DescuentoPorcentual()); break;
            case 4: calc.setEstrategia(new DescuentoPorcentualAcumulado()); break;
            default: System.out.println("Opción inválida"); return;
        }

        double precioFinal = calc.calcularPrecio(prod, cantidad);

        // --- Notificación ---
        sistema.notificar("Promoción: " + prod.getNombre() + " Precio final: " + precioFinal);

        // Permitir desuscribirse dinámicamente
        System.out.println("Maria se desuscribe...");
        sistema.desuscribirse(maria);
        sistema.notificar("Nueva promoción disponible!");

        sc.close();
    }
}
