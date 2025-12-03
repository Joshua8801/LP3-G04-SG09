package strategy;

public class RiegoInteligentePredictivo implements RiegoStrategy {

    private int humedad;
    private String clima;

    public RiegoInteligentePredictivo(int humedad, String clima) {
        this.humedad = humedad;
        this.clima = clima;
    }

    @Override
    public boolean debeRegar() {
        boolean pocaHumedad = humedad < 50;
        boolean buenClima = !clima.equalsIgnoreCase("lluvia");

        System.out.println("[Estrategia: Predictiva] Humedad=" + humedad 
                + "% Clima=" + clima);

        return pocaHumedad && buenClima;
    }

    @Override
    public String mensaje() {
        if (debeRegar())
            return "Predicción indica riego necesario: Humedad=" + humedad 
                   + "%, Clima=" + clima;
        else
            return "Predicción indica que NO se debe regar: Humedad=" + humedad 
                   + "%, Clima=" + clima;
    }
}
