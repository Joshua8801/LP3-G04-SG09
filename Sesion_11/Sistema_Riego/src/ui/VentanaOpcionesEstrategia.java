package ui;

import javax.swing.*;
import java.awt.*;
import strategy.*;

public class VentanaOpcionesEstrategia extends JDialog {

    private RiegoStrategy estrategiaElegida;

    public VentanaOpcionesEstrategia(JFrame parent, int tipoEstrategia) {
        super(parent, "Opciones de Estrategia", true);
        setSize(350, 300);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JLabel titulo = new JLabel("Configurar Estrategia", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 16));
        add(titulo, BorderLayout.NORTH);

        switch (tipoEstrategia) {

            // 0 = HUMEDAD
            case 0:
                panel.add(new JLabel("Nivel de humedad (%):"));
                JSlider humedad = new JSlider(0, 100, 30);
                humedad.setMajorTickSpacing(20);
                humedad.setPaintLabels(true);
                panel.add(humedad);

                JButton btnHumedad = new JButton("Aceptar");
                btnHumedad.addActionListener(e -> {
                    estrategiaElegida = new RiegoPorHumedad(humedad.getValue());
                    dispose();
                });
                add(panel, BorderLayout.CENTER);
                add(btnHumedad, BorderLayout.SOUTH);
                break;

            // 1 = HORARIO
            case 1:
                JLabel lblHorario = new JLabel("Esta estrategia solo permite regar entre 6 a 8 AM.");
                lblHorario.setHorizontalAlignment(SwingConstants.CENTER);
                panel.add(lblHorario);

                JButton btnHorario = new JButton("Aceptar");
                btnHorario.addActionListener(e -> {
                    estrategiaElegida = new RiegoPorHorario();
                    dispose();
                });

                add(panel, BorderLayout.CENTER);
                add(btnHorario, BorderLayout.SOUTH);
                break;

            // 2 = CLIMA
            case 2:
                panel.add(new JLabel("Condición del clima:"));
                String[] listaClima = {"soleado", "nublado", "lluvia"};
                JComboBox<String> clima = new JComboBox<>(listaClima);
                panel.add(clima);

                JButton btnClima = new JButton("Aceptar");
                btnClima.addActionListener(e -> {
                    estrategiaElegida = new RiegoPorClima(clima.getSelectedItem().toString());
                    dispose();
                });

                add(panel, BorderLayout.CENTER);
                add(btnClima, BorderLayout.SOUTH);
                break;

            // 3 = PREDICTIVO
            case 3:
                panel.add(new JLabel("Nivel de humedad (%):"));
                JSlider humedad2 = new JSlider(0, 100, 40);
                humedad2.setPaintLabels(true);
                humedad2.setMajorTickSpacing(20);
                panel.add(humedad2);

                panel.add(new JLabel("Clima:"));
                JComboBox<String> clima2 = new JComboBox<>(new String[]{"soleado", "nublado", "lluvia"});
                panel.add(clima2);

                JButton btnPred = new JButton("Aceptar");
                btnPred.addActionListener(e -> {
                    estrategiaElegida = new RiegoInteligentePredictivo(
                            humedad2.getValue(),
                            clima2.getSelectedItem().toString()
                    );
                    dispose();
                });

                add(panel, BorderLayout.CENTER);
                add(btnPred, BorderLayout.SOUTH);
                break;
        }

        setLocationRelativeTo(parent);
    }

    public RiegoStrategy getEstrategia() {
        return estrategiaElegida;
    }
}
