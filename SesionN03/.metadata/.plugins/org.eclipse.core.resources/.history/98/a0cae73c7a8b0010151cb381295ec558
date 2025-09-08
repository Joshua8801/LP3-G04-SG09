package model;

public class Reserva {
    private Habitacion habitacion;
    private String fechaInicio;
    private String fechaFin;

    public Reserva(Habitacion habitacion, String fechaInicio, String fechaFin) {
        this.habitacion = habitacion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
    }

    public Habitacion getHabitacion() { return habitacion; }
    public String getFechaInicio() { return fechaInicio; }
    public String getFechaFin() { return fechaFin; }

    public boolean seTraslapaCon(String inicio, String fin) {
        return this.fechaInicio.equals(inicio) || this.fechaFin.equals(fin);
    }
}
