package model.habitaciones;

import gestor.GestorDisponibilidadHabitacion;

public class HabitacionDoble extends Habitacion {
    public HabitacionDoble(String numero, double precio, GestorDisponibilidadHabitacion gestorDisponibilidad) {
        super(numero, "Doble", precio, gestorDisponibilidad);
    }
}

