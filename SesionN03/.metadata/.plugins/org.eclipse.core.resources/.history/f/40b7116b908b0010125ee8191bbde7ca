package app;

import model.habitaciones.Habitacion;
import gestor.GestorDisponibilidadHabitacion;
import model.servicios.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<model.Reserva> reservas = new ArrayList<>();
        GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion(reservas);

        Habitacion habitacionIndividual = new Habitacion("101", "Individual", 100.0, gestor);
        Habitacion habitacionDoble = new Habitacion("102", "Doble", 150.0, gestor);
        Habitacion habitacionSuite = new Habitacion("103", "Suite", 250.0, gestor);

        ServicioLimpieza limpieza = new Limpieza();
        ServicioComida comida = new Comida();
        ServicioLavanderia lavanderia = new Lavanderia();

        aplicarServicios(habitacionIndividual, limpieza, null, null);
        aplicarServicios(habitacionDoble, limpieza, comida, null);
        aplicarServicios(habitacionSuite, limpieza, comida, lavanderia);
    }

    public static void aplicarServicios(Habitacion habitacion, 
                                        ServicioLimpieza limpieza, 
                                        ServicioComida comida, 
                                        ServicioLavanderia lavanderia) {
        System.out.println("\nServicios para habitación " + habitacion.getTipo() + ":");

        if (limpieza != null) limpieza.solicitarLimpieza();
        if (comida != null) comida.solicitarComida();
        if (lavanderia != null) lavanderia.solicitarLavanderia();
    }
}

