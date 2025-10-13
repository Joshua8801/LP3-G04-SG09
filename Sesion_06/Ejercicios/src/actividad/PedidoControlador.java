package actividad;

public class PedidoControlador {
    private PedidoModelo modelo;
    private PedidoVista vista;

    public PedidoControlador(PedidoModelo modelo, PedidoVista vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    public void iniciar() {
        String opcion;
        do {
            vista.mostrarMenu();
            opcion = vista.solicitarOpcion();
            switch (opcion) {
                case "1":
                    String nombre = vista.solicitarNombrePlato();
                    String tipo = vista.solicitarTipoPlato();
                    modelo.agregarPedido(new Pedido(nombre, tipo));
                    vista.mostrarMensaje("Pedido agregado.");
                    break;
                case "2":
                    vista.mostrarPedidos(modelo.getPedidos());
                    break;
                case "3":
                    String nombreEliminar = vista.solicitarNombrePlato();
                    if (modelo.eliminarPedido(nombreEliminar)) {
                        vista.mostrarMensaje("Pedido marcado como eliminado.");
                    } else {
                        vista.mostrarMensaje("Pedido no encontrado.");
                    }
                    break;
                case "4":
                    String nombreAntiguo = vista.solicitarNombrePlato();
                    String nuevoNombre = vista.solicitarNombrePlato();
                    String nuevoTipo = vista.solicitarTipoPlato();
                    if (modelo.actualizarPedido(nombreAntiguo, nuevoNombre, nuevoTipo)) {
                        vista.mostrarMensaje("Pedido actualizado.");
                    } else {
                        vista.mostrarMensaje("Pedido no encontrado.");
                    }
                    break;
                case "5":
                    String nombreCompletar = vista.solicitarNombrePlato();
                    if (modelo.marcarComoCompleto(nombreCompletar)) {
                        vista.mostrarMensaje("Pedido marcado como completo.");
                    } else {
                        vista.mostrarMensaje("Pedido no encontrado o ya está completo.");
                    }
                    break;
                case "6":
                    String estado = vista.solicitarEstado();
                    vista.mostrarPedidos(modelo.buscarPorEstado(estado));
                    break;
                case "7":
                    vista.mostrarMensaje("Pedidos pendientes: " + modelo.contarPendientes());
                    break;
                case "8":
                    vista.mostrarPedidos(modelo.obtenerHistorial());
                    break;
                case "9":
                    vista.mostrarMensaje("Saliendo...");
                    break;
                default:
                    vista.mostrarMensaje("Opción no válida.");
            }
        } while (!opcion.equals("9"));
        vista.cerrarScanner();
    }
}
