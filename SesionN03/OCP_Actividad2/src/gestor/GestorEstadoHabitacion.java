package gestor;

import model.Habitacion;

public class GestorEstadoHabitacion {

    public void marcarReservada(Habitacion habitacion) {
        habitacion.setDisponible(false);
    }

    public void marcarDisponible(Habitacion habitacion) {
        habitacion.setDisponible(true);
    }
}
