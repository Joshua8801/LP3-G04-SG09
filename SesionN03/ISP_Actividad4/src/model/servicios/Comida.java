package model.servicios;

public class Comida implements ServicioComida {
    @Override
    public void solicitarComida() {
        System.out.println("Servicio de comida solicitado.");
    }
}

