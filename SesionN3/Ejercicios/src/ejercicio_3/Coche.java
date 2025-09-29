package ejercicio_3;

public class Coche extends Vehiculo {

    public Coche(String modelo) {
        super(modelo);
    }

    @Override
    public void acelerar() {
        System.out.println("El coche " + modelo + " acelera usando el motor.");
    }
}
