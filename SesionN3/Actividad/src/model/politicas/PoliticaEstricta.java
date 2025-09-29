package model.politicas;

import model.Reserva;

public class PoliticaEstricta implements PoliticaCancelacion {
    @Override
    public boolean puedeCancelar(Reserva reserva) {
        System.out.println("No se permite la cancelación después de realizar la reserva.");
        return false;
    }
}

