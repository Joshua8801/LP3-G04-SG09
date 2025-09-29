package model.habitaciones;

import gestor.GestorDisponibilidadHabitacion;

public class HabitacionIndividual extends Habitacion {
    public HabitacionIndividual(String numero, double precio, GestorDisponibilidadHabitacion gestorDisponibilidad) {
        super(numero, "Individual", precio, gestorDisponibilidad);
    }
}

