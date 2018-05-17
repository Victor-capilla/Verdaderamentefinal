package defii;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Añadirpedido extends JFrame {

	
	private static final long serialVersionUID = -2378505659579628413L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtSdxc;
	private JTextField textField_1;
	private JTable table_1;
	ConexionBBDD Prueba = new ConexionBBDD();
	Bar mibar =null;


	public Añadirpedido() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 754, 467);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(428, 28, 269, 216);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Añadirpedido.class.getResource("/defii/OK.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				añadirpedido(Integer.parseInt(textField_1.getText()), Integer.parseInt(txtSdxc.getText()));
				table.setModel(Prueba.pedidosdis());
				table_1.setModel(Prueba.mesasdis());
			}
		});
		btnNewButton.setBounds(23, 309, 124, 61);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblMesa = new JLabel("MESA");
		lblMesa.setBounds(23, 34, 45, 15);
		lblMesa.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblPedido = new JLabel("PEDIDO");
		lblPedido.setBounds(25, 208, 43, 15);
		lblPedido.setFont(new Font("Arial", Font.BOLD, 12));
		ConexionBBDD Prueba = new ConexionBBDD();
		
		txtSdxc = new JTextField();
		txtSdxc.setBounds(86, 32, 86, 20);
		txtSdxc.setText("sdxc");
		txtSdxc.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(104, 206, 86, 20);
		textField_1.setText(Prueba.con());
		textField_1.setColumns(10);
		
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(Añadirpedido.class.getResource("/defii/atras.png")));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Bar mibar = new Bar();
				mibar.setVisible(true);
			}
		});
		btnAtras.setBounds(190, 309, 124, 60);
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setFont(new Font("Arial", Font.BOLD, 14));
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"m", "MESA"
			}
		) {
			
			private static final long serialVersionUID = 2402026930000477753L;
			
		});
		table.setModel(Prueba.pedidosdis());
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(250, 28, 145, 254);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"MESAS_DISPONIBLES"
			}
			
		));
		table_1.setModel(Prueba.mesasdis());
		scrollPane_1.setViewportView(table_1);
		contentPane.setLayout(null);
		contentPane.add(lblMesa);
		contentPane.add(txtSdxc);
		contentPane.add(scrollPane);
		contentPane.add(lblPedido);
		contentPane.add(textField_1);
		contentPane.add(btnNewButton);
		contentPane.add(btnAtras);
		contentPane.add(scrollPane_1);
	}
	
	public void añadirpedido (int num , int num2) {
		Prueba.conta(num, num2);
	}public void inicializa(Bar miva) {
		mibar=miva;
	}

	
}
