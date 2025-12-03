package strategy;

public class RiegoPorHumedad implements RiegoStrategy {

    private int humedad;

    public RiegoPorHumedad(int humedad) {
        this.humedad = humedad;
    }

    @Override
    public boolean debeRegar() {
        System.out.println("[Estrategia: Humedad] Humedad actual: " + humedad + "%");
        return humedad < 40;
    }

    @Override
    public String mensaje() {
        if (humedad < 40)
            return "Humedad baja (" + humedad + "%). Se recomienda regar.";
        else
            return "Humedad suficiente (" + humedad + "%). No es necesario regar.";
    }
}
