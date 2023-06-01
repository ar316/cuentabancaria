
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Gui extends JFrame {

	private JPanel contentPane;
	Banco bancop = new Banco("bancolombia");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui frame = new Gui();
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
	public Gui() {
		this.setTitle("Banco de pruebas");
		this.setLocationRelativeTo(null);
		this.setResizable( false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 229, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAgregar = new JButton("Agregar Cliente");
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String nombre =JOptionPane.showInputDialog(null,  "nombre");
			String ncuenta =  JOptionPane.showInputDialog(null,  "numero de cuenta");
			String balance =  JOptionPane.showInputDialog(null,  "Balance");
			double monto =Double.parseDouble(balance) ;	
			Cliente client = new Cliente(nombre,ncuenta,monto);
			bancop.AgregarCliente(client);

			}
		});
		btnAgregar.setBounds(24, 41, 172, 27);
		contentPane.add(btnAgregar);
		
		JLabel lblBanco = new JLabel("banco");
		lblBanco.setBounds(83, 12, 60, 17);
		contentPane.add(lblBanco);
		
		JButton btnMostrarInfoClientes = new JButton("Mostrar info clientes");
		btnMostrarInfoClientes.setBounds(24, 80, 172, 27);
		contentPane.add(btnMostrarInfoClientes);
		btnMostrarInfoClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bancop.info();

			}
		});

	}
}
