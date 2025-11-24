
package ejemplos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GraficosSimplesYAvanzadosApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame f = new JFrame("Gráficos con Swing");
            f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            f.setSize(720, 480);
            f.setLocationRelativeTo(null);

            JTabbedPane tabs = new JTabbedPane();
            tabs.addTab("Simples", new PanelSimples());
            tabs.addTab("Avanzados (líneas)", new PanelLineChart());

            f.add(tabs);
            f.setVisible(true);
        });
    }
}

/** Panel de gráficos básicos (Graphics) */
class PanelSimples extends JPanel {
    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);   g.drawLine(20, 20, 220, 140);
        g.setColor(Color.RED);    g.drawRect(50, 50, 120, 70);
        g.setColor(Color.GREEN);  g.drawOval(220, 40, 120, 80);
        g.setColor(Color.ORANGE); g.fillOval(380, 160, 80, 80);
        g.setColor(Color.BLACK);  g.drawString("Gráficos simples con Graphics", 20, 260);
    }
}

/** Panel de gráfico de líneas con Graphics2D y antialiasing */
class PanelLineChart extends JPanel {
    private double[] data = {18, 21, 22, 19, 24, 20, 23}; // L-D (temperaturas)
    private final Random rnd = new Random();

    PanelLineChart() {
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JButton btnNuevosDatos = new JButton("Nuevos datos");
        btnNuevosDatos.addActionListener(e -> {
            for (int i = 0; i < data.length; i++) data[i] = 15 + rnd.nextInt(12);
            repaint();
        });
        top.add(new JLabel("Gráfico de líneas (temperaturas semana)"));
        top.add(btnNuevosDatos);
        add(top, BorderLayout.NORTH);
    }

    @Override protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth(), h = getHeight();
        int left = 60, right = w - 30, top = 40, bottom = h - 60;

        // Ejes
        g2.setColor(Color.DARK_GRAY);
        g2.drawLine(left, bottom, right, bottom); // X
        g2.drawLine(left, bottom, left, top);     // Y
        g2.drawString("°C", left - 25, top);
        g2.drawString("L  M  M  J  V  S  D", left + 8, bottom + 22);

        // Escala vertical
        double max = 0; for (double v : data) if (v > max) max = v;
        double scaleY = (bottom - top) / (max <= 0 ? 1 : max);

        // Líneas y puntos
        int n = data.length;
        int stepX = (right - left) / (n - 1);

        int prevX = left;
        int prevY = bottom - (int)(data[0] * scaleY);
        g2.setStroke(new BasicStroke(2f));
        g2.setColor(new Color(70,130,180)); // steel blue

        for (int i = 1; i < n; i++) {
            int x = left + i * stepX;
            int y = bottom - (int)(data[i] * scaleY);
            g2.drawLine(prevX, prevY, x, y);
            prevX = x; prevY = y;
        }

        // Puntos y etiquetas
        g2.setColor(new Color(220,20,60)); // crimson
        for (int i = 0; i < n; i++) {
            int x = left + i * stepX;
            int y = bottom - (int)(data[i] * scaleY);
            g2.fillOval(x - 3, y - 3, 6, 6);
            g2.drawString(String.valueOf((int)data[i]), x - 6, y - 8);
        }
    }
}
