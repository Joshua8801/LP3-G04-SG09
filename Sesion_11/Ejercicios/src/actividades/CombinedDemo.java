package actividades;

import java.util.*;

//--- OBSERVER ---
interface Observer {
 void update(String message);
}

class User implements Observer {
 private String name;
 public User(String name) { this.name = name; }
 @Override
 public void update(String message) { System.out.println(name + " recibió: " + message); }
}

class NotificationSystem {
 private List<Observer> observers = new ArrayList<>();
 public void subscribe(Observer o) { observers.add(o); }
 public void notifyAllObservers(String msg) {
     for (Observer o : observers) { o.update(msg); }
 }
}

//--- STRATEGY ---
interface DiscountStrategy { double applyDiscount(double price); }
class NoDiscount implements DiscountStrategy { public double applyDiscount(double price) { return price; } }
class TenPercentDiscount implements DiscountStrategy { public double applyDiscount(double price) { return price * 0.9; } }
class SpecialDiscount implements DiscountStrategy { public double applyDiscount(double price) { return price * 0.8; } }

class PriceCalculator {
 private DiscountStrategy strategy;
 public void setDiscountStrategy(DiscountStrategy strategy) { this.strategy = strategy; }
 public double calculatePrice(double price) { return strategy.applyDiscount(price); }
}

//--- COMMAND ---
interface Command { void execute(); }
class TV {
 public void turnOn() { System.out.println("TV encendida"); }
 public void turnOff() { System.out.println("TV apagada"); }
 public void volumeUp() { System.out.println("Volumen subido"); }
 public void volumeDown() { System.out.println("Volumen bajado"); }
 public void changeChannel() { System.out.println("Canal cambiado"); }
}
class TurnOnCommand implements Command { private TV tv; public TurnOnCommand(TV tv) { this.tv = tv; } public void execute() { tv.turnOn(); } }
class TurnOffCommand implements Command { private TV tv; public TurnOffCommand(TV tv) { this.tv = tv; } public void execute() { tv.turnOff(); } }
class VolumeUpCommand implements Command { private TV tv; public VolumeUpCommand(TV tv) { this.tv = tv; } public void execute() { tv.volumeUp(); } }
class VolumeDownCommand implements Command { private TV tv; public VolumeDownCommand(TV tv) { this.tv = tv; } public void execute() { tv.volumeDown(); } }
class ChangeChannelCommand implements Command { private TV tv; public ChangeChannelCommand(TV tv) { this.tv = tv; } public void execute() { tv.changeChannel(); } }
class RemoteControl { private Command command; public void setCommand(Command c) { this.command = c; } public void pressButton() { command.execute(); } }

//--- MAIN ---
public class CombinedDemo {
 public static void main(String[] args) {
     // Observer
     NotificationSystem notifications = new NotificationSystem();
     User u1 = new User("Juan");
     User u2 = new User("Maria");
     notifications.subscribe(u1);
     notifications.subscribe(u2);

     // Strategy
     PriceCalculator calculator = new PriceCalculator();
     calculator.setDiscountStrategy(new SpecialDiscount());
     double price = 100;
     double finalPrice = calculator.calculatePrice(price);

     // Notificación a usuarios
     notifications.notifyAllObservers("Promoción aplicada! Nuevo precio: " + finalPrice);

     // Command
     TV tv = new TV();
     RemoteControl remote = new RemoteControl();
     remote.setCommand(new TurnOnCommand(tv)); remote.pressButton();
     remote.setCommand(new ChangeChannelCommand(tv)); remote.pressButton();
     remote.setCommand(new VolumeUpCommand(tv)); remote.pressButton();
     remote.setCommand(new VolumeDownCommand(tv)); remote.pressButton();
     remote.setCommand(new TurnOffCommand(tv)); remote.pressButton();
 }
}
