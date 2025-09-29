package notificaciones;

public class NotificadorSlack implements CanalNotificacion {
    @Override
    public void enviarNotificacion(String mensaje) {
        System.out.println("Mensaje enviado a Slack: " + mensaje);
    }
}

