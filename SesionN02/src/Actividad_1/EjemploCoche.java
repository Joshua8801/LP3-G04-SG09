package Actividad_1;

public class EjemploCoche {
    public static void main(String[] args) {
        Coche cocheDeportivo = new Coche("Tesla", "Y", 2005, 20000);
        Coche cocheTodoTerreno = new Coche("Honda", "PILOT", 2019, 10000);

        cocheDeportivo.encender();
        cocheTodoTerreno.encender();

        cocheDeportivo.acelerar();
        cocheDeportivo.frenar();

        cocheTodoTerreno.acelerar();
        cocheTodoTerreno.frenar();

        cocheDeportivo.apagar();
        cocheTodoTerreno.apagar();

        cocheDeportivo.aplicarDescuento(1000);
        cocheTodoTerreno.aplicarDescuento(1000);
    }
}

