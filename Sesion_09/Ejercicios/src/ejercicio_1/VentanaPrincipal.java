package ejercicio_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrincipal frame = new VentanaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel titulo = new JLabel("Calculadora");
		titulo.setFont(new Font("Times New Roman", Font.BOLD, 24));
		titulo.setBounds(145, 11, 149, 29);
		contentPane.add(titulo);
		
		textField1 = new JTextField();
		textField1.setBounds(182, 54, 86, 20);
		contentPane.add(textField1);
		textField1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(182, 82, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Numero 2");
		lblNewLabel.setBounds(69, 85, 77, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Numero 1");
		lblNewLabel_1.setBounds(69, 57, 77, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("SUMA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(57, 140, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("RESTA");
		btnNewButton_1.setBounds(57, 203, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnMultiplicacion = new JButton("MULTIPLICACION");
		btnMultiplicacion.setBounds(159, 140, 135, 23);
		contentPane.add(btnMultiplicacion);
		
		JButton btnNewButton_1_1 = new JButton("DIVISION");
		btnNewButton_1_1.setBounds(159, 203, 89, 23);
		contentPane.add(btnNewButton_1_1);

	}
}
