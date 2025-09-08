package app;

import gestor.GestorDisponibilidadHabitacion;
import model.habitaciones.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GestorDisponibilidadHabitacion gestor = new GestorDisponibilidadHabitacion(new ArrayList<>());

        List<Habitacion> habitaciones = new ArrayList<>();
        habitaciones.add(new HabitacionIndividual("101", 80.0, gestor));
        habitaciones.add(new HabitacionDoble("102", 120.0, gestor));
        habitaciones.add(new HabitacionSuite("103", 200.0, gestor));

        System.out.println("Lista de habitaciones disponibles:");
        for (Habitacion h : habitaciones) {
            System.out.println(h.toString() + " | Precio final: $" + h.getPrecio());
        }
    }
}
