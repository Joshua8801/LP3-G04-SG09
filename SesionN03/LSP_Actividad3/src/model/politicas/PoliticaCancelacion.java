package model.politicas;

import model.Reserva;

public interface PoliticaCancelacion {
    boolean puedeCancelar(Reserva reserva);
}