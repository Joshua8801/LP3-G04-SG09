package app;

import gestor.GestorDisponibilidadHabitacion;
import gestor.GestorEstadoHabitacion;
import model.Cliente;
import model.Habitacion;
import model.Reserva;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        
        List<Reserva> reservas = new ArrayList<>();
        GestorDisponibilidadHabitacion gestorDisponibilidad = new GestorDisponibilidadHabitacion(reservas);
        GestorEstadoHabitacion gestorEstado = new GestorEstadoHabitacion();

        Habitacion habitacion1 = new Habitacion("101", "Simple", 100.0, gestorDisponibilidad);
        Habitacion habitacion2 = new Habitacion("102", "Doble", 180.0, gestorDisponibilidad);
        Cliente cliente1 = new Cliente("Juan", "999292929");

        Reserva reservaExistente = new Reserva(habitacion1, "2025-09-10", "2025-09-12");
        reservas.add(reservaExistente);
        gestorEstado.marcarReservada(habitacion1);

        System.out.println("=== Verificación de Disponibilidad ===");
        System.out.println("Cliente: " + cliente1.getNombre());

        boolean disponible1 = habitacion1.verificarDisponibilidad("2025-09-10", "2025-09-12");
        System.out.println("Habitación 101 (10 al 12 sep 2025): " + (disponible1 ? "Disponible " : "No disponible "));

        boolean disponible2 = habitacion1.verificarDisponibilidad("2025-09-15", "2025-09-17");
        System.out.println("Habitación 101 (15 al 17 sep 2025): " + (disponible2 ? "Disponible " : "No disponible "));

        boolean disponible3 = habitacion2.verificarDisponibilidad("2025-09-10", "2025-09-12");
        System.out.println("Habitación 102 (10 al 12 sep 2025): " + (disponible3 ? "Disponible " : "No disponible "));
    }
}
