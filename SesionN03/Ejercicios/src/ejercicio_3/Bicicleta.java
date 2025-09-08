package ejercicio_3;

public class Bicicleta extends Vehiculo {

    public Bicicleta(String modelo) {
        super(modelo);
    }

    @Override
    public void acelerar() {
        System.out.println("La bicicleta " + modelo + " acelera pedaleando.");
    }
}

