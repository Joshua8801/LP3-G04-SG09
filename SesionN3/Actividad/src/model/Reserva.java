package model;

import model.politicas.PoliticaCancelacion;
import model.politicas.PoliticaFlexible;
import model.habitaciones.Habitacion;

public class Reserva {
    private Habitacion habitacion;
    private String fechaInicio;
    private String fechaFin;
    private PoliticaCancelacion politica;

    public Reserva(Habitacion habitacion, String fechaInicio, String fechaFin, PoliticaCancelacion politica) {
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.politica = (politica != null) ? politica : new PoliticaFlexible();
    }

    public Habitacion getHabitacion() { return habitacion; }
    public String getFechaInicio() { return fechaInicio; }
    public String getFechaFin() { return fechaFin; }

    public boolean seTraslapaCon(String inicio, String fin) {
        return this.fechaInicio.equals(inicio) || this.fechaFin.equals(fin);
    }

    public boolean cancelar() {
        return politica.puedeCancelar(this);
    }
}