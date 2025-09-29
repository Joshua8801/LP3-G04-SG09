package model.servicios;

public class Lavanderia implements ServicioLavanderia {
    @Override
    public void solicitarLavanderia() {
        System.out.println("Servicio de lavandería solicitado.");
    }
}
