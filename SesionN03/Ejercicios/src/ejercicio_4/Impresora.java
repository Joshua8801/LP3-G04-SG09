package ejercicio_4;

public class Impresora implements ImpresoraBasica {
    private String modelo;

    public Impresora(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void imprimir(String documento) {
        System.out.println("La impresora " + modelo + " está imprimiendo: " + documento);
    }
}