
package ejemplos;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppGraficoBarras extends JPanel {
    // Datos de ejemplo
    private String[] productos = {"Producto A", "Producto B", "Producto C", "Producto D"};
    private int[] ventas = {50, 120, 80, 150}; // Ventas en unidades

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Graphics2D y antialiasing
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dimensiones y colores
        int anchoBarra = 50;
        int espacioBarra = 20;
        int margenIzquierdo = 50;
        int margenInferior = 50;
        int alturaMaxima = 200;

        // Valor máximo para escalar
        int maxVenta = 0;
        for (int venta : ventas) {
            if (venta > maxVenta) maxVenta = venta;
        }

        // Dibujar barras
        for (int i = 0; i < productos.length; i++) {
            int alturaBarra = (int)((double)ventas[i] / maxVenta * alturaMaxima);
            int x = margenIzquierdo + i * (anchoBarra + espacioBarra);
            int y = getHeight() - margenInferior - alturaBarra;

            // Barra
            g2d.setColor(new Color(100, 150, 200));
            g2d.fillRect(x, y, anchoBarra, alturaBarra);

            // Etiqueta de ventas
            g2d.setColor(Color.BLACK);
            g2d.drawString(String.valueOf(ventas[i]), x + (anchoBarra / 4), y - 5);

            // Nombre del producto
            g2d.drawString(productos[i], x, getHeight() - margenInferior + 20);
        }

        // Eje Y y título
        g2d.setColor(Color.DARK_GRAY);
        g2d.drawLine(margenIzquierdo, getHeight() - margenInferior,
                     margenIzquierdo, getHeight() - margenInferior - alturaMaxima);
        g2d.drawString("Ventas", margenIzquierdo - 40,
                       getHeight() - margenInferior - alturaMaxima);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Visualización de Datos - Gráfico de Barras");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.add(new AppGraficoBarras());
        frame.setVisible(true);
    }
}
