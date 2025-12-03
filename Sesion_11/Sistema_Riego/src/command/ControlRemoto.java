package command;

public class ControlRemoto {
	private Command comando;
	public void setCommand(Command c) { comando = c; }
	public void presionar() { comando.ejecutar(); }
}