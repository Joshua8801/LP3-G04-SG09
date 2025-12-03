package command;
import model.SistemaRiego;


public class CerrarValvulaCommand implements Command {
private SistemaRiego sistema;
public CerrarValvulaCommand(SistemaRiego s) { this.sistema = s; }
@Override public void ejecutar() { sistema.cerrarValvula(); }
}
