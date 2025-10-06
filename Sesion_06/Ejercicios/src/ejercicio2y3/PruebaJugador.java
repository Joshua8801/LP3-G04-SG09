package ejercicio2y3;


public class PruebaJugador {
    public static void main(String[] args) {
        
        Jugador jugador = new Jugador("Heroe", 100, 5);
        jugador.getInventario().agregarItem(new Item("Espada", 1, "Arma", "Una espada afilada"));

        Enemigo enemigo = new Enemigo("Goblin", 50, 3, "Criatura");

        CombateModel combateModel = new CombateModel(jugador, enemigo);
        CombateView combateView = new CombateView();
        CombateController combateController = new CombateController(combateModel, combateView);

        combateController.iniciarCombate();
    }
}
