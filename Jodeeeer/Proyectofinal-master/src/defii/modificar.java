package defii;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class modificar extends JFrame {
	
	private static final long serialVersionUID = 1546540406336926914L;
	ConexionBBDD Prueba = new ConexionBBDD();
	private JPanel contentPane;
	private JTextField nombre;
	private JTextField cantidad;
	private JTextField cate;
	private String categoria;
	JComboBox<Object> comboBox = new JComboBox<Object>();
	private JTextField precio;
	boolean t = false;

	
	
	public modificar() {
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 639, 463);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(26, 16, 176, 28);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblNewLabel_1 = new JLabel("cantidad");
		lblNewLabel_1.setBounds(26, 74, 176, 25);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel celiaco = new JLabel("celiaco");
		celiaco.setBounds(26, 194, 48, 27);
		celiaco.setFont(new Font("Arial", Font.BOLD, 12));
		
		nombre = new JTextField();
		nombre.setBounds(202, 21, 86, 20);
		nombre.setColumns(10);
		
		cantidad = new JTextField();
		cantidad.setBounds(206, 77, 86, 20);
		cantidad.setColumns(10);
		
		cate = new JTextField();
		cate.setBounds(206, 139, 86, 20);
		cate.setColumns(10);
		
		JCheckBox chnombre = new JCheckBox("");
		chnombre.setBackground(Color.WHITE);
		chnombre.setBounds(329, 16, 21, 21);
		
		JCheckBox chcantidad = new JCheckBox("");
		chcantidad.setBackground(Color.WHITE);
		chcantidad.setBounds(329, 74, 21, 21);
		
		JCheckBox chcategoria = new JCheckBox("");
		chcategoria.setBackground(Color.WHITE);
		chcategoria.setBounds(329, 134, 21, 21);
		
		JCheckBox chceliaco = new JCheckBox("");
		chceliaco.setBackground(Color.WHITE);
		chceliaco.setBounds(329, 194, 21, 21);
		JCheckBox chprecio = new JCheckBox("");
		JCheckBox chtrue = new JCheckBox("true");
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(modificar.class.getResource("/defii/cambiar.png")));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(26, 312, 140, 61);
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(String.valueOf(comboBox.getSelectedItem())+"ahhhhhhhhhhhhhhhhhhhhhhhh");
				String nombree="", precio0="" , cantidadd="" , catt = "", celiaco0 = "";
				if (chnombre.isSelected()) {
					nombree = nombre.getText(); 
				}if (chcantidad.isSelected()) {
					cantidadd = cantidad.getText();
				} if (chprecio.isSelected()) {
					precio0 = precio.getText();
				} if (chcategoria.isSelected()) {
					catt = cate.getText();
				}
				if (chceliaco.isSelected()) {
					if (chtrue.isSelected()) {
						celiaco0 = "V";
					}else {
						celiaco0 = "F";
					} System.out.println(String.valueOf(comboBox.getSelectedItem()));
				}Prueba.modificarproductocarta(nombree, celiaco0, precio0, cantidadd, catt, String.valueOf(comboBox.getSelectedItem()));
				eje(categoria);
				
				nombre.setText("");
				precio.setText("");
				chtrue.setSelected(false);
				cate.setText("");
				cantidad.setText("");
			}
		});
		
		JButton btnVisibles = new JButton("");
		btnVisibles.setIcon(new ImageIcon(modificar.class.getResource("/defii/visibles.png")));
	
		btnVisibles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (t == false) {
					chnombre.setSelected(true);
					chcantidad.setSelected(true);
					chcategoria.setSelected(true);
					chceliaco.setSelected(true);
					chprecio.setSelected(true);
					t = true;
				}else {
					chnombre.setSelected(false);
					chcantidad.setSelected(false);
					chcategoria.setSelected(false);
					chceliaco.setSelected(false);
					chprecio.setSelected(false);
					t = false;
					
				}
				
			}
		});
		btnVisibles.setBackground(Color.WHITE);
		btnVisibles.setBounds(231, 312, 140, 61);
		btnVisibles.setFont(new Font("Arial", Font.BOLD, 15));
		
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(modificar.class.getResource("/defii/atras.png")));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Administracion miad = new Administracion();
				miad.setVisible(true);
			}
		});
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setBounds(449, 312, 140, 61);
		btnAtras.setFont(new Font("Arial", Font.BOLD, 14));
		
		
		chtrue.setBackground(Color.WHITE);
		chtrue.setBounds(247, 197, 45, 23);
		
		
		comboBox.setFont(new Font("Arial", Font.BOLD, 12));
		
		
		comboBox.setBounds(492, 21, 68, 20);
		
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		contentPane.add(btnVisibles);
		contentPane.add(btnAtras);
		contentPane.add(celiaco);
		
		JLabel lblNewLabel_2 = new JLabel("categoria");
		lblNewLabel_2.setBounds(26, 134, 86, 28);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 12));
		contentPane.add(lblNewLabel_2);
		contentPane.add(lblNewLabel_1);
		contentPane.add(lblNewLabel);
		contentPane.add(cantidad);
		contentPane.add(cate);
		contentPane.add(chtrue);
		contentPane.add(nombre);
		contentPane.add(chnombre);
		contentPane.add(comboBox);
		contentPane.add(chceliaco);
		contentPane.add(chcategoria);
		contentPane.add(chcantidad);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Arial", Font.BOLD, 12));
		lblPrecio.setBounds(26, 244, 48, 27);
		contentPane.add(lblPrecio);
		
		precio = new JTextField();
		precio.setColumns(10);
		precio.setBounds(206, 244, 86, 20);
		contentPane.add(precio);
		
		
		chprecio.setBackground(Color.WHITE);
		chprecio.setBounds(329, 244, 21, 21);
		contentPane.add(chprecio);
		
	}
//	modiii1
	public void eje (String categoria) {		
		this.categoria = categoria;
		comboBox.setModel(new DefaultComboBoxModel<Object>(Prueba.productos(categoria)));
	}
}
