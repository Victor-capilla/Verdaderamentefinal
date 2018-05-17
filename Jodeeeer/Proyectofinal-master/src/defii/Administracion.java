package defii;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;
import java.awt.Font;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Administracion extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1609758312532941493L;
	private JPanel contentPane;
	private JTable table;
	JComboBox<Object> comboBox_1 = new JComboBox<Object>();
	JComboBox<Object> comboBox = new JComboBox<Object>();
	

	
	public Administracion() {
	//	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ConexionBBDD Prueba = new ConexionBBDD();
		setBounds(100, 100, 545, 408);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setIcon(new ImageIcon(Administracion.class.getResource("/defii/a\u00F1adir.png")));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 15));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				añadir aña = new añadir();
				aña.setVisible(true);
			}
		});
		
		
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		JButton btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(Administracion.class.getResource("/defii/modificar.png")));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setFont(new Font("Arial", Font.BOLD, 15));
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				modificar modi = new modificar();
				modi.setVisible(true);
				modi.eje(String.valueOf(comboBox.getSelectedItem()));
				
				
				
			}
		});
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(Administracion.class.getResource("/defii/eliminar.png")));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 15));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Eliminar eli = new Eliminar();
				eli.setVisible(true);
				eli.eje(String.valueOf(comboBox_1.getSelectedItem()));
			}
		});
		
		String[] pep=Prueba.categorias();
		comboBox.setModel(new DefaultComboBoxModel<Object>(pep));
		
		
		comboBox_1.setModel(new DefaultComboBoxModel<Object>(pep));
		
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnAt = new JButton("");
		btnAt.setIcon(new ImageIcon(Administracion.class.getResource("/defii/atras.png")));
		btnAt.setBackground(Color.WHITE);
		btnAt.setFont(new Font("Arial", Font.BOLD, 15));
		btnAt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(30)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(39)
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, 54, GroupLayout.PREFERRED_SIZE))))
						.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAt, GroupLayout.PREFERRED_SIZE, 118, GroupLayout.PREFERRED_SIZE))
					.addGap(48)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 209, GroupLayout.PREFERRED_SIZE)
					.addGap(46))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 266, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(btnModificar, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 69, GroupLayout.PREFERRED_SIZE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addComponent(btnAt)))
					.addContainerGap(49, Short.MAX_VALUE))
		);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "NOMBRE", "PRECIO"
			}
		) {
			
			private static final long serialVersionUID = 2458558759049749860L;
			
			
		});
		
		table.setModel(Prueba.ConsultaTablaEmpleados());
		
		
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
	}
}
