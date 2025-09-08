package ejercicio_3;


public class Main {
    public static void main(String[] args) {
        Vehiculo bici = new Bicicleta("Urbana");
        Vehiculo coche = new Coche("Nissan");

        bici.acelerar();  
        coche.acelerar(); 
    }
}
