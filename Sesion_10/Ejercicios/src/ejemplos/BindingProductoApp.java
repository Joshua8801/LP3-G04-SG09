
package ejemplos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BindingProductoApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(ProductoForm::new);
    }
}

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

    // getters y setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getCantidadStock() { return cantidadStock; }
    public void setCantidadStock(int cantidadStock) { this.cantidadStock = cantidadStock; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    @Override
    public String toString() {
        return String.format("Producto: %s | Precio: S/ %.2f | Stock: %d | Categoría: %s",
                nombre, precio, cantidadStock, categoria);
    }
}

class ProductoForm extends JFrame {
    private final JTextField txtNombre = new JTextField(15);
    private final JTextField txtPrecio = new JTextField(10);
    private final JTextField txtStock = new JTextField(10);
    private final JComboBox<String> cboCategoria =
            new JComboBox<>(new String[]{"Electrónica","Ropa","Alimentos","Otros"});

    private final JLabel lblEstado = new JLabel("Producto actual: —");
    private final JButton btnActualizar = new JButton("Actualizar Producto");

    private final Producto producto = new Producto("Sin nombre", 0.0, 0, "Otros");

    ProductoForm() {
        super("Binding manual - Producto");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(440, 260);
        setLocationRelativeTo(null);

        JPanel form = new JPanel(new GridLayout(5,2,8,8));
        form.add(new JLabel("Nombre:"));        form.add(txtNombre);
        form.add(new JLabel("Precio (S/):"));   form.add(txtPrecio);
        form.add(new JLabel("Stock:"));         form.add(txtStock);
        form.add(new JLabel("Categoría:"));     form.add(cboCategoria);
        form.add(btnActualizar);                form.add(new JLabel()); // espacio

        lblEstado.setBorder(BorderFactory.createEmptyBorder(8,8,8,8));
        getContentPane().add(form, BorderLayout.CENTER);
        getContentPane().add(lblEstado, BorderLayout.SOUTH);

        // Binding manual vista -> modelo
        btnActualizar.addActionListener(e -> actualizarModelo());

        // Validaciones (opcional)
        txtPrecio.addKeyListener(onlyNumericWithDot());
        txtStock.addKeyListener(onlyNumericInt());

        setVisible(true);
    }

    private void actualizarModelo() {
        try {
            producto.setNombre(txtNombre.getText().trim());
            producto.setPrecio(Double.parseDouble(txtPrecio.getText().trim()));
            producto.setCantidadStock(Integer.parseInt(txtStock.getText().trim()));
            producto.setCategoria((String)cboCategoria.getSelectedItem());
            lblEstado.setText(producto.toString());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Verifica Precio (decimal) y Stock (entero).",
                    "Datos inválidos", JOptionPane.WARNING_MESSAGE);
        }
    }

    private KeyAdapter onlyNumericWithDot() {
        return new KeyAdapter() {
            @Override public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.' && c != KeyEvent.VK_BACK_SPACE) e.consume();
            }
        };
    }
    private KeyAdapter onlyNumericInt() {
        return new KeyAdapter() {
            @Override public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != KeyEvent.VK_BACK_SPACE) e.consume();
            }
        };
    }
}

