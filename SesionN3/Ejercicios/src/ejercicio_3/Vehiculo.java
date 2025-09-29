package ejercicio_3;

public abstract class Vehiculo {
    protected String modelo;

    public Vehiculo(String modelo) {
        this.modelo = modelo;
    }

    public abstract void acelerar();
}
