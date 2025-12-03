package strategy;

import java.time.LocalTime;

public class RiegoPorHorario implements RiegoStrategy {

    private LocalTime ahora = LocalTime.now();

    @Override
    public boolean debeRegar() {
        boolean dentroHorario = ahora.isAfter(LocalTime.of(6, 0)) 
                && ahora.isBefore(LocalTime.of(8, 0));

        System.out.println("[Estrategia: Horario] Hora actual: " + ahora);

        return dentroHorario;
    }

    @Override
    public String mensaje() {
        if (debeRegar())
            return "Hora adecuada para regar (" + ahora + ").";
        else
            return "Fuera del horario (6:00–8:00 AM). No se recomienda regar.";
    }
}
