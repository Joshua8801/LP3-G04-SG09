package app;

import notificaciones.*;

public class Main {
    public static void main(String[] args) {
        CanalNotificacion correo = new EnviadorCorreo();
        CanalNotificacion sms = new EnviadorSMS();
        CanalNotificacion slack = new NotificadorSlack();

        NotificadorReserva notificadorCorreo = new NotificadorReserva(correo);
        NotificadorReserva notificadorSMS = new NotificadorReserva(sms);
        NotificadorReserva notificadorSlack = new NotificadorReserva(slack);

        notificadorCorreo.notificar("Reserva confirmada por correo.");
        notificadorSMS.notificar("Reserva confirmada por SMS.");
        notificadorSlack.notificar("Reserva confirmada por Slack.");
    }
}
