package model.politicas;

import model.Reserva;

public class PoliticaModerada implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        System.out.println("Cancelación permitida hasta 72 horas antes con 50% de penalización.");
        return true;
    }
}