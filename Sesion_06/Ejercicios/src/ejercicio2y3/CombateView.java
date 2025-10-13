package ejercicio2y3;

public class CombateView {

    public void mostrarEstadoCombate(Jugador jugador, Enemigo enemigo) {
        System.out.println("\n--- Estado del Combate ---");
        System.out.println("Jugador: " + jugador.getNombre() + " | Salud: " + jugador.getSalud() + " | Nivel: " + jugador.getNivel());
        System.out.println("Enemigo: " + enemigo.getNombre() + " | Salud: " + enemigo.getSalud() + " | Nivel: " + enemigo.getNivel());
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}