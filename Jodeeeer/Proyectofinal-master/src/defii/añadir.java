package defii;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class a�adir extends JFrame {


	private static final long serialVersionUID = 2835302046942774291L;
	private JPanel contentPane;
	private JTextField txtnombre;
	private JTextField txtid;
	private JTextField txtcategoria;
	private JTextField txtcantidad;
	private JTextField txtprecio;
	
	JCheckBox checkBox = new JCheckBox("");

	ConexionBBDD Prueba = new ConexionBBDD();
	private JTextField textField;


	public a�adir() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 536, 388);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel nombre = new JLabel("NOMBRE");
		nombre.setFont(new Font("Arial", Font.BOLD, 12));
		nombre.setBounds(35, 20, 59, 14);
		
		JLabel ID = new JLabel("ID");
		ID.setFont(new Font("Arial", Font.BOLD, 12));
		ID.setBounds(68, 70, 11, 14);
		
		JLabel celiaco = new JLabel("CELIACO");
		celiaco.setFont(new Font("Arial", Font.BOLD, 12));
		celiaco.setBounds(35, 121, 59, 14);
		
		JLabel categoria = new JLabel("CATEGORIA");
		categoria.setFont(new Font("Arial", Font.BOLD, 12));
		categoria.setBounds(25, 174, 69, 14);
		
		JLabel cantidad = new JLabel("CANTIDAD");
		cantidad.setFont(new Font("Arial", Font.BOLD, 12));
		cantidad.setBounds(25, 215, 69, 14);
		
		txtnombre = new JTextField();
		txtnombre.setBounds(119, 17, 86, 20);
		txtnombre.setColumns(10);
		
		txtid = new JTextField();
		txtid.setBounds(119, 67, 86, 20);
		txtid.setColumns(10);
		txtid.setText(Prueba.countproductos());
		
		txtcategoria = new JTextField();
		txtcategoria.setBounds(119, 172, 86, 20);
		txtcategoria.setColumns(10);
		
		txtcantidad = new JTextField();
		txtcantidad.setBounds(119, 213, 86, 20);
		txtcantidad.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(a�adir.class.getResource("/defii/a\u00F1adir.png")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBounds(274, 16, 130, 68);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ce = "F";
				int a = 0 ;
				int i = 0 ;
				if (checkBox.isSelected()) {
					ce= "V";
				}a =Integer.valueOf(Prueba.countproductos()) ;
				Prueba.a�adirproductocarta(txtnombre.getText(), ce, txtprecio.getText(), txtcantidad.getText(), txtid.getText(), txtcategoria.getText());
				i = Integer.valueOf(Prueba.countproductos()) ;
				if (i >a) {
					textField.setText("OK");
					txtid.setText(Prueba.countproductos());
					txtnombre.setText("");
					
					 txtcategoria.setText("");
					 txtcantidad.setText("");
					 txtprecio.setText("");
				}else {
					textField.setText("ERROR");
					txtnombre.setText("");
					
					 txtcategoria.setText("");
					 txtcantidad.setText("");
					 txtprecio.setText("");
				}
				
				
			}
		});
		
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(a�adir.class.getResource("/defii/atras.png")));
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setFont(new Font("Arial", Font.BOLD, 15));
		btnAtras.setBounds(274, 98, 130, 62);
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Administracion mi = new Administracion();
				mi.setVisible(true);
			}
		});
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(a�adir.class.getResource("/defii/cancelar.png")));
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 15));
		btnCancelar.setBounds(274, 174, 130, 58);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtnombre.setText("");
				txtid.setText("");
				 txtcategoria.setText("");
				 txtcantidad.setText("");
				 txtprecio.setText("");
			}
		});
		
				checkBox.setBounds(184, 114, 21, 21);
		contentPane.setLayout(null);
		contentPane.add(nombre);
		contentPane.add(ID);
		contentPane.add(celiaco);
		contentPane.add(categoria);
		contentPane.add(cantidad);
		contentPane.add(txtnombre);
		contentPane.add(txtcantidad);
		contentPane.add(txtcategoria);
		contentPane.add(txtid);
		contentPane.add(checkBox);
		contentPane.add(btnNewButton);
		contentPane.add(btnAtras);
		contentPane.add(btnCancelar);
		
		JLabel precio = new JLabel("PRECIO");
		precio.setFont(new Font("Arial", Font.BOLD, 12));
		precio.setBounds(25, 254, 69, 14);
		contentPane.add(precio);
		
		txtprecio = new JTextField();
		txtprecio.setColumns(10);
		txtprecio.setBounds(119, 252, 86, 20);
		contentPane.add(txtprecio);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		textField.setBounds(274, 252, 113, 57);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}