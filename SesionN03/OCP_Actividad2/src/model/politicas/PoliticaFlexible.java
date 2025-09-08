package model.politicas;

import model.Reserva;

public class PoliticaFlexible implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        System.out.println("Cancelación permitida hasta 24 horas antes sin penalización.");
        return true;
    }
}
