package defii;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Bar extends JFrame {

	
	private static final long serialVersionUID = -4385461384122644652L;
	private JPanel contentPane;
	private JTable table;
	public JComboBox<Object> comboBox_1 = new JComboBox<Object>();
	public JComboBox<Object> comboBox = new JComboBox<Object>();
	public JComboBox<Object> comboBox_2 = new JComboBox<Object>();
	public JComboBox<Object> comboBox_3 = new JComboBox<Object>();
	

	public Bar() {ConexionBBDD Prueba = new ConexionBBDD();
	setBounds(100, 100, 542, 440);
	contentPane = new JPanel();
	contentPane.setBackground(Color.WHITE);
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	
	comboBox.setBounds(109, 167, 72, 20);
	comboBox.setModel(new DefaultComboBoxModel<Object>(Prueba.categorias()));
	
	
	JButton btnNewButton = new JButton("");
	btnNewButton.setIcon(new ImageIcon(Bar.class.getResource("/defii/nuevo.png")));
	btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
	btnNewButton.setBackground(Color.WHITE);
	btnNewButton.setBounds(15, 16, 115, 63);
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Añadirpedido aña =new Añadirpedido();
			aña.setVisible(true);
			
		}
	});
	
	JButton btnAadir = new JButton("");
	btnAadir.setIcon(new ImageIcon(Bar.class.getResource("/defii/a\u00F1adir.png")));
	btnAadir.setBackground(Color.WHITE);
	btnAadir.setFont(new Font("Arial", Font.BOLD, 15));
	btnAadir.setBounds(15, 90, 115, 66);
	btnAadir.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			if (comboBox.getSelectedIndex() == 0) {
				BEBIDAS bebi = new BEBIDAS();
				bebi.setVisible(true);
				bebi.cate(String.valueOf(comboBox.getSelectedItem()));
				bebi.pedido(Integer.parseInt(String.valueOf(comboBox_3.getSelectedItem())));
				bebi.botones();
				bebi.list();
			}else if (comboBox.getSelectedIndex() == 1) {
				Comidas comi = new Comidas();
				comi.setVisible(true);
				comi.cate(String.valueOf(comboBox.getSelectedItem()));
				comi.pedido(Integer.parseInt(String.valueOf(comboBox_3.getSelectedItem())));
				
				comi.botones();
				comi.list();
			}else {
				Postres pos = new Postres();
				pos.setVisible(true);
				pos.cate(String.valueOf(comboBox.getSelectedItem()));
				pos.pedido(Integer.parseInt(String.valueOf(comboBox_3.getSelectedItem())));
				pos.botones();
				pos.list();
			}
			
		}
	});
	
		JButton btnCobrar = new JButton("");
		btnCobrar.setIcon(new ImageIcon(Bar.class.getResource("/defii/cobrar.png")));
		btnCobrar.setBackground(Color.WHITE);
		btnCobrar.setFont(new Font("Arial", Font.BOLD, 15));
		btnCobrar.setBounds(15, 282, 127, 61);
	btnCobrar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			Cobrar ticket = new Cobrar();
			ticket.setVisible(true);
			ticket.dificil(select1());
			ticket.tprecio(select1());
			
		}
	});
	
	
	comboBox_1.setBounds(212, 310, 28, 20);
	comboBox_1.setModel(new DefaultComboBoxModel<Object>(Prueba.pedidos()));
	
	JButton btnModificar = new JButton("");
	btnModificar.setIcon(new ImageIcon(Bar.class.getResource("/defii/modificar.png")));
	btnModificar.setFont(new Font("Arial", Font.BOLD, 15));
	btnModificar.setBackground(Color.WHITE);
	btnModificar.setBounds(15, 210, 127, 61);
	btnModificar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			visualizar modifi = new visualizar();
			modifi.setVisible(true);
			modifi.tprecio(Integer.parseInt(String.valueOf(comboBox_2.getSelectedItem())));
			modifi.dificil(Integer.parseInt(String.valueOf(comboBox_2.getSelectedItem())));
			modifi.cate(select2());
		}
	});
	
	
	comboBox_2.setBounds(212, 230, 28, 20);
	comboBox_2.setModel(new DefaultComboBoxModel<Object>(Prueba.pedidos()));
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(305, 16, 211, 248);
	
	JLabel lblCategorias = new JLabel("categorias");
	lblCategorias.setFont(new Font("Arial", Font.BOLD, 12));
	lblCategorias.setBounds(37, 169, 65, 14);
	
	
	comboBox_3.setBounds(238, 167, 28, 20);
	comboBox_3.setModel(new DefaultComboBoxModel<Object>(Prueba.pedidos()));
	
	table = new JTable();
	table.setModel(new DefaultTableModel(
		new Object[][] {
			{null, null},
			{null, null},
		},
		new String[] {
			"MESA", "PEDIDO"
		}
	) {
		
		private static final long serialVersionUID = -70870886089065819L;
		
	});
	
	table.setModel(Prueba.pedidosdis());
	scrollPane.setViewportView(table);
	contentPane.setLayout(null);
	contentPane.add(btnAadir);
	contentPane.add(btnCobrar);
	contentPane.add(btnModificar);
	contentPane.add(comboBox_1);
	contentPane.add(comboBox_2);
	contentPane.add(comboBox_3);
	contentPane.add(lblCategorias);
	contentPane.add(comboBox);
	contentPane.add(btnNewButton);
	contentPane.add(scrollPane);
	
	JButton btnAtras = new JButton("");
	btnAtras.setIcon(new ImageIcon(Bar.class.getResource("/defii/atras.png")));
	btnAtras.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			setVisible(false);
			
		}
	});
	btnAtras.setBackground(Color.WHITE);
	btnAtras.setFont(new Font("Arial", Font.BOLD, 15));
	btnAtras.setBounds(140, 16, 115, 63);
	contentPane.add(btnAtras);
	
	JLabel lblPedido_1 = new JLabel("pedido");
	lblPedido_1.setFont(new Font("Arial", Font.BOLD, 12));
	lblPedido_1.setBounds(190, 169, 50, 14);
	contentPane.add(lblPedido_1);
	
	JLabel label_1 = new JLabel("pedido");
	label_1.setFont(new Font("Arial", Font.BOLD, 12));
	label_1.setBounds(152, 232, 50, 14);
	contentPane.add(label_1);
	
	JLabel label = new JLabel("pedido");
	label.setFont(new Font("Arial", Font.BOLD, 12));
	label.setBounds(152, 312, 50, 14);
	contentPane.add(label);
}
	
	public int select () {
		String g= String.valueOf(comboBox.getSelectedItem());
		int c = Integer.parseInt(g);
		return c; }
	public int select1 () {
		String g= String.valueOf(comboBox_1.getSelectedItem());
		int c = Integer.parseInt(g);
		return c; }
	public int select2() {
		String g= String.valueOf(comboBox_2.getSelectedItem());
		int c = Integer.parseInt(g);
		return c; }
	public int select3() {
		String g= String.valueOf(comboBox_3.getSelectedItem());
		int c = Integer.parseInt(g);
		return c; }
	
	
	
	
}
