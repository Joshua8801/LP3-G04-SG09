package ejercicio_2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormularioPasaje extends JFrame {
    private JTextField txtNombre, txtDNI, txtFecha;
    private JComboBox<String> comboOrigen, comboDestino;
    private JRadioButton piso1, piso2;
    private JCheckBox chkAudifonos, chkManta, chkRevistas;
    private JList<String> listaCalidad;
    private JButton btnMostrar, btnReiniciar;

    public FormularioPasaje() {
        super("Compra de Pasajes");
        setLayout(new GridLayout(9, 2, 5, 5));

        // Etiquetas y campos de texto
        add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        add(txtNombre);

        add(new JLabel("DNI:"));
        txtDNI = new JTextField();
        add(txtDNI);

        add(new JLabel("Fecha de viaje:"));
        txtFecha = new JTextField();
        add(txtFecha);

        // ComboBox para origen y destino
        add(new JLabel("Origen:"));
        comboOrigen = new JComboBox<>(new String[]{"Arequipa", "Lima", "Cusco"});
        add(comboOrigen);

        add(new JLabel("Destino:"));
        comboDestino = new JComboBox<>(new String[]{"Arequipa", "Lima", "Cusco"});
        add(comboDestino);

        // Botones de opción para piso
        add(new JLabel("Piso:"));
        JPanel panelPiso = new JPanel();
        piso1 = new JRadioButton("1er Piso");
        piso2 = new JRadioButton("2do Piso");
        ButtonGroup grupoPiso = new ButtonGroup();
        grupoPiso.add(piso1);
        grupoPiso.add(piso2);
        panelPiso.add(piso1);
        panelPiso.add(piso2);
        add(panelPiso);

        // CheckBox para servicios
        add(new JLabel("Servicios opcionales:"));
        JPanel panelServicios = new JPanel();
        chkAudifonos = new JCheckBox("Audífonos");
        chkManta = new JCheckBox("Manta");
        chkRevistas = new JCheckBox("Revistas");
        panelServicios.add(chkAudifonos);
        panelServicios.add(chkManta);
        panelServicios.add(chkRevistas);
        add(panelServicios);

        // Lista para calidad
        add(new JLabel("Calidad de servicio:"));
        listaCalidad = new JList<>(new String[]{"Económico", "Standard", "VIP"});
        add(new JScrollPane(listaCalidad));

        // Botones
        btnMostrar = new JButton("Mostrar Resumen");
        btnReiniciar = new JButton("Reiniciar");
        add(btnMostrar);
        add(btnReiniciar);

        // Eventos
        btnMostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String servicios = "";
                if (chkAudifonos.isSelected()) servicios += "Audífonos ";
                if (chkManta.isSelected()) servicios += "Manta ";
                if (chkRevistas.isSelected()) servicios += "Revistas ";

                String piso = piso1.isSelected() ? "1er Piso" : piso2.isSelected() ? "2do Piso" : "No seleccionado";
                String calidad = listaCalidad.getSelectedValue() != null ? listaCalidad.getSelectedValue() : "No seleccionado";

                Pasajero pasajero = new Pasajero(
                        txtNombre.getText(),
                        txtDNI.getText(),
                        txtFecha.getText(),
                        comboOrigen.getSelectedItem().toString(),
                        comboDestino.getSelectedItem().toString(),
                        piso,
                        servicios,
                        calidad
                );

                JOptionPane.showMessageDialog(FormularioPasaje.this, pasajero.resumen(), "Resumen de Compra", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        btnReiniciar.addActionListener(e -> {
            txtNombre.setText("");
            txtDNI.setText("");
            txtFecha.setText("");
            comboOrigen.setSelectedIndex(0);
            comboDestino.setSelectedIndex(0);
            grupoPiso.clearSelection();
            chkAudifonos.setSelected(false);
            chkManta.setSelected(false);
            chkRevistas.setSelected(false);
            listaCalidad.clearSelection();
        });

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}