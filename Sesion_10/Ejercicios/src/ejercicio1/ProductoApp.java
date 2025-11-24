
package ejercicio1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ProductoApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductoForm::new);
    }
}

/** Modelo de datos: Producto */
class Producto {
    private String nombre;
    private double precio;
    private int cantidadStock;
    private String categoria;

    public Producto(String nombre, double precio, int cantidadStock, String categoria) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadStock = cantidadStock;
        this.categoria = categoria;
    }

    // Getters / Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getCantidadStock() { return cantidadStock; }
    public void setCantidadStock(int cantidadStock) { this.cantidadStock = cantidadStock; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    /** Representación estructurada para mostrar en la interfaz */
    public String toDisplayString() {
        return String.format(
            "<html><b>Producto:</b> %s<br><b>Precio:</b> S/ %.2f<br><b>Stock:</b> %d<br><b>Categoría:</b> %s</html>",
            nombre, precio, cantidadStock, categoria
        );
    }
}

/** Interfaz Swing para capturar y actualizar datos del Producto */
class ProductoForm extends JFrame {
    private final JTextField txtNombre = new JTextField(15);
    private final JTextField txtPrecio = new JTextField(10);
    private final JTextField txtStock  = new JTextField(10);
    private final JComboBox<String> cboCategoria = new JComboBox<>(
            new String[] {"Electrónica", "Ropa", "Alimentos", "Otros"}
    );

    private final JButton btnActualizar = new JButton("Actualizar Producto");
    private final JLabel lblResumen = new JLabel("Producto actual: —");

    private final Producto producto = new Producto("Sin nombre", 0.0, 0, "Otros");

    ProductoForm() {
        super("Ejercicio 1 - Gestión de Producto (Binding manual)");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(520, 260);
        setLocationRelativeTo(null);

        // Panel de formulario
        JPanel form = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Fila 1: Nombre
        gbc.gridx = 0; gbc.gridy = 0; form.add(new JLabel("Nombre:"), gbc);
        gbc.gridx = 1; gbc.gridy = 0; form.add(txtNombre, gbc);

        // Fila 2: Precio
        gbc.gridx = 0; gbc.gridy = 1; form.add(new JLabel("Precio (S/):"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; form.add(txtPrecio, gbc);

        // Fila 3: Stock
        gbc.gridx = 0; gbc.gridy = 2; form.add(new JLabel("Stock:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; form.add(txtStock, gbc);

        // Fila 4: Categoría
        gbc.gridx = 0; gbc.gridy = 3; form.add(new JLabel("Categoría:"), gbc);
        gbc.gridx = 1; gbc.gridy = 3; form.add(cboCategoria, gbc);

        // Fila 5: Botón
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        form.add(btnActualizar, gbc);

        // Resumen (JLabel) abajo
        lblResumen.setBorder(BorderFactory.createEmptyBorder(8, 12, 8, 12));

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(form, BorderLayout.CENTER);
        getContentPane().add(lblResumen, BorderLayout.SOUTH);

        // Validaciones simples: permitir solo números/decimal
        txtPrecio.addKeyListener(onlyNumericWithDot());
        txtStock.addKeyListener(onlyNumericInt());

        // Acción del botón: binding manual vista -> modelo
        btnActualizar.addActionListener(e -> actualizarProducto());

        // Mostrar ventana
        setVisible(true);
    }

    /** Actualiza el modelo desde los campos y refresca el resumen */
    private void actualizarProducto() {
        try {
            String nombre = txtNombre.getText().trim();
            double precio = Double.parseDouble(txtPrecio.getText().trim());
            int stock = Integer.parseInt(txtStock.getText().trim());
            String categoria = (String) cboCategoria.getSelectedItem();

            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCantidadStock(stock);
            producto.setCategoria(categoria);

            lblResumen.setText(producto.toDisplayString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Verifica:\n• Precio: número decimal\n• Stock: número entero",
                    "Datos inválidos", JOptionPane.WARNING_MESSAGE);
        }
    }

    /** Permite solo números y punto decimal */
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

    /** Permite solo números enteros */
    private KeyAdapter onlyNumericInt() {
        return new KeyAdapter() {
            @Override public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) {
                    e.consume();
                }
            }
        };
    }
}
