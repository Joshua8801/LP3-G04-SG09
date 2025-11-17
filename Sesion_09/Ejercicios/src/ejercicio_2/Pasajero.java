package ejercicio_2;

public class Pasajero {
    private String nombre;
    private String dni;
    private String fechaViaje;
    private String origen;
    private String destino;
    private String piso;
    private String servicio;
    private String calidad;

    public Pasajero(String nombre, String dni, String fechaViaje, String origen, String destino,
                    String piso, String servicio, String calidad) {
        this.nombre = nombre;
        this.dni = dni;
        this.fechaViaje = fechaViaje;
        this.origen = origen;
        this.destino = destino;
        this.piso = piso;
        this.servicio = servicio;
        this.calidad = calidad;
    }

    public String resumen() {
        return String.format("Nombre: %s\nDNI: %s\nFecha: %s\nOrigen: %s\nDestino: %s\nPiso: %s\nServicios: %s\nCalidad: %s",
                nombre, dni, fechaViaje, origen, destino, piso, servicio, calidad);
    }
}
