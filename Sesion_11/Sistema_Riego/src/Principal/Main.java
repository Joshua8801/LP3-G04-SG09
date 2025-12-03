package Principal;

import model.SistemaRiego;
import observer.SistemaNotificaciones;
import ui.RiegoGUI;

public class Main {
    public static void main(String[] args) {

        // Sistema que enviará notificaciones (Observer)
        SistemaNotificaciones notificador = new SistemaNotificaciones();

        // Sistema de riego central
        SistemaRiego sistema = new SistemaRiego(notificador);

        // Interfaz gráfica
        RiegoGUI gui = new RiegoGUI(sistema, notificador);
        gui.setVisible(true);
    }
}


