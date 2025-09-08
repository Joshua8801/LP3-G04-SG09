package model.habitaciones;

import gestor.GestorDisponibilidadHabitacion;

public class HabitacionSuite extends Habitacion {
    public HabitacionSuite(String numero, double precio, GestorDisponibilidadHabitacion gestorDisponibilidad) {
        super(numero, "Suite", precio, gestorDisponibilidad);
    }
    
    @Override
    public double getPrecio() {
        return super.getPrecio() + 50.0; 
    }
}