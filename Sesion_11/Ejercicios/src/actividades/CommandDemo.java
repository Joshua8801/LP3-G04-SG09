package actividades;

//Interfaz Command
interface Command {
 void execute();
}

//Receptor
class TV {
 public void turnOn() { System.out.println("TV encendida"); }
 public void turnOff() { System.out.println("TV apagada"); }
 public void volumeUp() { System.out.println("Volumen subido"); }
 public void volumeDown() { System.out.println("Volumen bajado"); }
 public void changeChannel() { System.out.println("Canal cambiado"); }
}

//Comandos concretos
class TurnOnCommand implements Command {
 private TV tv;
 public TurnOnCommand(TV tv) { this.tv = tv; }
 public void execute() { tv.turnOn(); }
}

class TurnOffCommand implements Command {
 private TV tv;
 public TurnOffCommand(TV tv) { this.tv = tv; }
 public void execute() { tv.turnOff(); }
}

class VolumeUpCommand implements Command {
 private TV tv;
 public VolumeUpCommand(TV tv) { this.tv = tv; }
 public void execute() { tv.volumeUp(); }
}

class VolumeDownCommand implements Command {
 private TV tv;
 public VolumeDownCommand(TV tv) { this.tv = tv; }
 public void execute() { tv.volumeDown(); }
}

class ChangeChannelCommand implements Command {
 private TV tv;
 public ChangeChannelCommand(TV tv) { this.tv = tv; }
 public void execute() { tv.changeChannel(); }
}

//Invocador
class RemoteControl {
 private Command command;

 public void setCommand(Command command) {
     this.command = command;
 }

 public void pressButton() {
     command.execute();
 }
}

//Main para probar
public class CommandDemo {
 public static void main(String[] args) {
     TV tv = new TV();
     RemoteControl remote = new RemoteControl();

     remote.setCommand(new TurnOnCommand(tv));
     remote.pressButton();

     remote.setCommand(new VolumeUpCommand(tv));
     remote.pressButton();

     remote.setCommand(new ChangeChannelCommand(tv));
     remote.pressButton();

     remote.setCommand(new VolumeDownCommand(tv));
     remote.pressButton();

     remote.setCommand(new TurnOffCommand(tv));
     remote.pressButton();
 }
}
