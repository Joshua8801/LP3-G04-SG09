package observer;

import java.util.ArrayList;
import java.util.List;

public class Notificacion {
    private List<Observer> usuarios = new ArrayList<>();

    public void suscribirse(Observer usuario) {
        usuarios.add(usuario);
    }

    public void desuscribirse(Observer usuario) {
        usuarios.remove(usuario);
    }

    public void notificar(String mensaje) {
        for (Observer usuario : usuarios) {
            usuario.update(mensaje);
        }
    }
}

// Interfaz Observer
interface Observer {
    void update(String mensaje);
}
