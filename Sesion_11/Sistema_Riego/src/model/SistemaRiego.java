package model;


import observer.SistemaNotificaciones;


public class SistemaRiego {

	private boolean valvulaAbierta = false;
	private boolean riegoActivo = false;
	private int presion = 50; 
	
	private SistemaNotificaciones notificador;
	
	
	public SistemaRiego(SistemaNotificaciones notificador) {
		this.notificador = notificador;
	}
	
	
	public void abrirValvula() {
		valvulaAbierta = true;
		notificador.notificar("La válvula de riego ha sido abierta.");
	}
	
	
	public void cerrarValvula() {
		valvulaAbierta = false;
		notificador.notificar("La válvula de riego ha sido cerrada.");
	}
	
	
	public void iniciarRiego() {
		if (valvulaAbierta) {
			riegoActivo = true;
			notificador.notificar("El riego ha iniciado.");
		} else {
			notificador.notificar("No se puede iniciar el riego, la válvula está cerrada.");
		}
	}
	
	
	public void detenerRiego() {
		riegoActivo = false;
		notificador.notificar("El riego ha sido detenido.");
	}
	
	
	public void ajustarPresion(int nuevaPresion) {
		this.presion = nuevaPresion;
		notificador.notificar("La presión del agua se ajustó a: " + nuevaPresion + "%");
	}
	
	
	public boolean isValvulaAbierta() {
		return valvulaAbierta;
	}
	
	
	public boolean isRiegoActivo() {
		return riegoActivo;
	}
	
	
	public int getPresion() {
		return presion;
	}
}