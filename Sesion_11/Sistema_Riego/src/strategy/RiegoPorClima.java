package strategy;

public class RiegoPorClima implements RiegoStrategy {

    private String clima;

    public RiegoPorClima(String clima) {
        this.clima = clima;
    }

    @Override
    public boolean debeRegar() {
        System.out.println("[Estrategia: Clima] Clima actual: " + clima);
        return !clima.equalsIgnoreCase("lluvia");
    }

    @Override
    public String mensaje() {
        if (clima.equalsIgnoreCase("lluvia"))
            return "Está lloviendo. No se debe regar.";
        else
            return "Clima " + clima + ". Se permite regar.";
    }
}
