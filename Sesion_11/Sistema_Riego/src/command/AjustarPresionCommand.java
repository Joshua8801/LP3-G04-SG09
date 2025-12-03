package command;
import model.SistemaRiego;


public class AjustarPresionCommand implements Command {
	private SistemaRiego sistema;
	private int presion;
	
	
	public AjustarPresionCommand(SistemaRiego s, int presion) {
		this.sistema = s;
		this.presion = presion;
	}
	
	
	@Override
	public void ejecutar() {
		sistema.ajustarPresion(presion);
	}
}