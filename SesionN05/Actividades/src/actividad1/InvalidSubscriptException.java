package actividad1;

public class InvalidSubscriptException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
    public InvalidSubscriptException(String mensaje) {
        super(mensaje);
    }
}
