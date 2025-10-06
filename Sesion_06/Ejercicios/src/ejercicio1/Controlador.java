package ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Controlador {
    private List<Producto> catalogo;
    private Carrito carrito;
    private Historial historial;
    private VistaConsola vista;

    public Controlador() {
        catalogo = new ArrayList<>();
        carrito = new Carrito();
        historial = new Historial();
        vista = new VistaConsola();

        // Productos de ejemplo
        catalogo.add(new Producto(1, "Laptop", 3000, 10));
        catalogo.add(new Producto(2, "Mouse", 50, 5));
        catalogo.add(new Producto(3, "Teclado", 150, 0));
    }

    public void iniciar() {
        int opcion;
        do {
            opcion = vista.mostrarMenu();
            switch (opcion) {
                case 1 -> vista.mostrarProductos(catalogo);
                case 2 -> {
                    int id = vista.pedirIdProducto();
                    catalogo.stream()
                        .filter(p -> p.getId() == id)
                        .findFirst()
                        .ifPresent(carrito::agregarProducto);
                }
                case 3 -> vista.mostrarProductos(carrito.getProductos());
                case 4 -> {
                    int id = vista.pedirIdProducto();
                    carrito.eliminarProducto(id);
                }
                case 5 -> {
                    double envio = 20.0;
                    double total = carrito.calcularTotal(envio);
                    vista.mostrarMensaje("Total compra (con envío): $" + total);
                    historial.agregarCompra(carrito.getProductos());
                    carrito.vaciar();
                }
                case 6 -> {
                    int n = 1;
                    for (List<Producto> compra : historial.getCompras()) {
                        vista.mostrarMensaje("Compra " + n++);
                        vista.mostrarProductos(compra);
                    }
                }
                case 0 -> vista.mostrarMensaje("Saliendo...");
                default -> vista.mostrarMensaje("Opción no válida.");
            }
        } while (opcion != 0);
    }
}