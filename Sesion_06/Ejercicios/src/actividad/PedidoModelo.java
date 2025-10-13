package actividad;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PedidoModelo {
    private List<Pedido> pedidos;

    public PedidoModelo() {
        pedidos = new ArrayList<>();
    }

    public void agregarPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    public boolean eliminarPedido(String nombrePlato) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombrePlato) && !p.getEstado().equals("eliminado")) {
                p.setEstado("eliminado");
                return true;
            }
        }
        return false;
    }

    public boolean actualizarPedido(String nombreAntiguo, String nuevoNombre, String nuevoTipo) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombreAntiguo) && !p.getEstado().equals("eliminado")) {
                p.setNombrePlato(nuevoNombre);
                p.setTipo(nuevoTipo);
                return true;
            }
        }
        return false;
    }

    public boolean marcarComoCompleto(String nombrePlato) {
        for (Pedido p : pedidos) {
            if (p.getNombrePlato().equalsIgnoreCase(nombrePlato) && p.getEstado().equals("pendiente")) {
                p.setEstado("completo");
                return true;
            }
        }
        return false;
    }

    public List<Pedido> buscarPorEstado(String estado) {
        return pedidos.stream()
                .filter(p -> p.getEstado().equalsIgnoreCase(estado))
                .collect(Collectors.toList());
    }

    public int contarPendientes() {
        return (int) pedidos.stream()
                .filter(p -> p.getEstado().equalsIgnoreCase("pendiente"))
                .count();
    }

    public List<Pedido> obtenerHistorial() {
        return pedidos.stream()
                .filter(p -> p.getEstado().equalsIgnoreCase("completo") || p.getEstado().equalsIgnoreCase("eliminado"))
                .collect(Collectors.toList());
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
