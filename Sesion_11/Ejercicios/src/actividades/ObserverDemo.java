package actividades;

import java.util.ArrayList;
import java.util.List;

// Interfaz Observer
interface Observer {
    void update(String message);
}

// Clase concreta Observer
class User implements Observer {
    private String username;

    public User(String username) {
        this.username = username;
    }

    @Override
    public void update(String message) {
        System.out.println(username + " recibió: " + message);
    }
}

// Clase Subject
class NotificationSystem {
    private List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notifyAllObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Main para probar
public class ObserverDemo {
    public static void main(String[] args) {
        NotificationSystem system = new NotificationSystem();

        Observer user1 = new User("Juan");
        Observer user2 = new User("Maria");
        Observer user3 = new User("Carlos");

        system.subscribe(user1);
        system.subscribe(user2);
        system.subscribe(user3);

        system.notifyAllObservers("Nuevo mensaje en la plataforma!");
    }
}
