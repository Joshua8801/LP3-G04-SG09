package command;
import model.SistemaRiego;


public class AbrirValvulaCommand implements Command {
	private SistemaRiego sistema;
	
	public AbrirValvulaCommand(SistemaRiego s) { this.sistema = s; }
	
	@Override 
	
	public void ejecutar() { 
		sistema.abrirValvula(); 
	}
}
