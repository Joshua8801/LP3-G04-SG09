package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Producto> catalogo = new ArrayList<>();
        catalogo.add(new Producto("Laptop", 3500));
        catalogo.add(new Producto("Mouse", 50));
        catalogo.add(new Producto("Teclado", 120));

        Carrito carrito = new Carrito();
        Historial historial = new Historial();
        CarritoVista vista = new CarritoVista();

        CarritoControlador controlador = new CarritoControlador(catalogo, carrito, historial, vista);
        controlador.iniciar();
    }
}
