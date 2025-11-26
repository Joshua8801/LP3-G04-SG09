
package ejercicio2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TemperaturaSemanaApp extends JFrame {
    private final String[] dias = {"Lunes","Martes","Miércoles","Jueves","Viernes","Sábado","Domingo"};
    private final JTextField[] campos = new JTextField[dias.length];
    private final JButton btnMostrar = new JButton("Mostrar Gráfico");
    private final PanelGrafico panelGrafico = new PanelGrafico();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TemperaturaSemanaApp().setVisible(true));
    }

    public TemperaturaSemanaApp() {
        super("Temperaturas Semana - Gráfico de Líneas");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 480);
        setLocationRelativeTo(null);

        // Panel de entrada (formulario de 7 días)
        JPanel panelEntrada = new JPanel(new GridBagLayout());
        panelEntrada.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(4, 4, 4, 4);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        for (int i = 0; i < dias.length; i++) {
            campos[i] = new JTextField(6);
            campos[i].setToolTipText("Temperatura de " + dias[i] + " (°C)");
            campos[i].addKeyListener(onlyNumericWithDot());
            gbc.gridx = 0; gbc.gridy = i;
            panelEntrada.add(new JLabel(dias[i] + ":"), gbc);
            gbc.gridx = 1;
            panelEntrada.add(campos[i], gbc);
        }

        // Botón para actualizar gráfico
        gbc.gridx = 0; gbc.gridy = dias.length; gbc.gridwidth = 2;
        panelEntrada.add(btnMostrar, gbc);

        // Acción del botón: leer campos y actualizar el panel de gráfico
        btnMostrar.addActionListener(e -> {
            double[] valores = leerTemperaturas();
            if (valores != null) {
                panelGrafico.setDatos(valores);
                panelGrafico.repaint();
            }
        });

        // Layout principal
        setLayout(new BorderLayout());
        add(panelEntrada, BorderLayout.WEST);
        add(panelGrafico, BorderLayout.CENTER);
    }

    /** Lee temperaturas desde los campos; valida números (double). */
    private double[] leerTemperaturas() {
        double[] vals = new double[dias.length];
        try {
            for (int i = 0; i < dias.length; i++) {
                String txt = campos[i].getText().trim();
                if (txt.isEmpty()) {
                    throw new NumberFormatException("Campo vacío: " + dias[i]);
                }
                vals[i] = Double.parseDouble(txt);
            }
            return vals;
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Verifica que todos los días tengan un número válido (usa punto para decimales).\n"
                    + "Detalle: " + ex.getMessage(),
                    "Datos inválidos", JOptionPane.WARNING_MESSAGE);
            return null;
        }
    }

    /** Permite solo dígitos, punto decimal y backspace. */
    private KeyAdapter onlyNumericWithDot() {
        return new KeyAdapter() {
            @Override public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        };
    }
}

/** Panel que dibuja el gráfico de líneas (domingo a lunes). */
class PanelGrafico extends JPanel {
    private double[] datos = new double[7]; // por defecto 7 puntos

    public PanelGrafico() {
        setBackground(Color.WHITE);
    }

    public void setDatos(double[] nuevos) {
        if (nuevos != null && nuevos.length == 7) {
            this.datos = nuevos.clone();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Preparar Graphics2D y antialiasing
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Márgenes y área de dibujo
        int w = getWidth();
        int h = getHeight();
        int left = 70, right = w - 30, top = 40, bottom = h - 60;

        // Fondo del área del gráfico
        g2.setColor(new Color(245, 245, 245));
        g2.fillRect(left, top, right - left, bottom - top);

        // Ejes
        g2.setColor(Color.DARK_GRAY);
        g2.drawLine(left, bottom, right, bottom); // X
        g2.drawLine(left, bottom, left, top);     // Y

        // Etiquetas en eje X (días)
        String[] etiquetas = {"L","M","M","J","V","S","D"};
        int stepX = (right - left) / (etiquetas.length - 1);
        g2.setColor(Color.GRAY);
        for (int i = 0; i < etiquetas.length; i++) {
            int x = left + i * stepX;
            g2.drawString(etiquetas[i], x - 4, bottom + 20);
        }
        g2.drawString("°C", left - 25, top);

        // Calcular escala vertical según datos
        double max = 0, min = Double.MAX_VALUE;
        for (double v : datos) { if (v > max) max = v; if (v < min) min = v; }
        if (min == Double.MAX_VALUE) { min = 0; }
        // Amortiguar límites para que no pegue al borde
        double padding = Math.max(1, (max - min) * 0.1);
        double maxPlot = max + padding;
        double minPlot = Math.max(0, min - padding);

        // Grid horizontal (opcional)
        g2.setColor(new Color(220, 220, 220));
        for (int i = 0; i <= 4; i++) {
            int y = top + i * (bottom - top) / 4;
            g2.drawLine(left, y, right, y);
        }

        // Conversión a coordenadas
        double range = (maxPlot - minPlot);
        if (range <= 0) range = 1; // evitar división por cero

        // Línea principal
        g2.setColor(new Color(70, 130, 180)); // steel blue
        g2.setStroke(new BasicStroke(2f));

        int prevX = left;
        int prevY = bottom - (int) ((datos[0] - minPlot) / range * (bottom - top));
        for (int i = 1; i < datos.length; i++) {
            int x = left + i * stepX;
            int y = bottom - (int) ((datos[i] - minPlot) / range * (bottom - top));
            g2.drawLine(prevX, prevY, x, y);
            prevX = x; prevY = y;
        }

        // Puntos y etiquetas de valor
        g2.setColor(new Color(220, 20, 60)); // crimson
        for (int i = 0; i < datos.length; i++) {
            int x = left + i * stepX;
            int y = bottom - (int) ((datos[i] - minPlot) / range * (bottom - top));
            g2.fillOval(x - 3, y - 3, 6, 6);
            g2.drawString(String.valueOf((int)Math.round(datos[i])), x - 8, y - 8);
        }

        // Título
        g2.setColor(Color.BLACK);
        g2.setFont(getFont().deriveFont(Font.BOLD, 13f));
        g2.drawString("Temperaturas diarias (L-D)", left, top - 10);
    }
}