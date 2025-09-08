package model.servicios;

public class Limpieza implements ServicioLimpieza {
    @Override
    public void solicitarLimpieza() {
        System.out.println("Servicio de limpieza solicitado.");
    }
}
