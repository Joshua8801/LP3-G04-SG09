package ejercicio_4;

public class ImpresoraMultifuncional implements ImpresoraBasica, Escaner {
    private String modelo;

    public ImpresoraMultifuncional(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public void imprimir(String documento) {
        System.out.println("La multifuncional " + modelo + " imprime: " + documento);
    }

    @Override
    public void escanear(String documento) {
        System.out.println("La multifuncional " + modelo + " escanea: " + documento);
    }
}