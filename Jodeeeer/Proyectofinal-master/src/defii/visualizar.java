package defii;



import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class visualizar extends JFrame {

	private static final long serialVersionUID = -5100822982679113067L;
	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	ConexionBBDD Prueba = new ConexionBBDD();
	int pedido ;
	JComboBox<Object> comboBox = new JComboBox<Object>();
	JComboBox<Object> comboBox_1 = new JComboBox<Object>();

	public visualizar() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 520, 375);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		
		JButton btnReducir = new JButton("");
		btnReducir.setIcon(new ImageIcon(visualizar.class.getResource("/defii/reducir.png")));
		btnReducir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prueba.reducir(String.valueOf(comboBox.getSelectedItem()), pedido);
				tprecio(pedido);
				dificil(pedido);
				cate(pedido);
				eee();
			}
		});
		btnReducir.setBackground(Color.WHITE);
		btnReducir.setFont(new Font("Arial", Font.BOLD, 13));
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(visualizar.class.getResource("/defii/eliminar.png")));
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prueba.eliminar(String.valueOf(comboBox.getSelectedItem()), pedido);
				tprecio(pedido);
				dificil(pedido);
				cate(pedido);
				eee();
				
				
			}
		});
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel lblProducto = new JLabel("PRODUCTO");
		lblProducto.setFont(new Font("Arial", Font.BOLD, 12));
		
		JLabel lblPrecioActual = new JLabel("Precio actual");
		lblPrecioActual.setFont(new Font("Arial", Font.BOLD, 12));
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JLabel lblCategoria = new JLabel("CATEGORIA");
		lblCategoria.setFont(new Font("Arial", Font.BOLD, 12));
		
		
		
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(visualizar.class.getResource("/defii/atras.png")));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Bar mi = new Bar();
				mi.setVisible(true);
				
			}
		});
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setFont(new Font("Arial", Font.BOLD, 14));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(21)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblProducto)
									.addGap(18)
									.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblCategoria, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
										.addComponent(btnReducir, Alignment.LEADING, 0, 0, Short.MAX_VALUE)
										.addComponent(btnAtras, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 124, Short.MAX_VALUE))
									.addGap(29)))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addPreferredGap(ComponentPlacement.UNRELATED)
									.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 237, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(36)
									.addComponent(btnEliminar, GroupLayout.PREFERRED_SIZE, 123, GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblPrecioActual)
							.addGap(18)
							.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addContainerGap(73, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(22)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblProducto))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCategoria))
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(btnAtras))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 169, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPrecioActual))
					.addGap(24)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnEliminar, 0, 0, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED))
						.addComponent(btnReducir, GroupLayout.PREFERRED_SIZE, 55, Short.MAX_VALUE))
					.addGap(31))
		);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ("bebidas".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
					comboBox.setModel(new DefaultComboBoxModel<Object>(Prueba.catpropedidos(pedido, "bebidas")));
					
					
					
				}else if ("comida".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
					comboBox.setModel(new DefaultComboBoxModel<Object>(Prueba.catpropedidos(pedido, "comida")));
				}else if ("postres".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
					comboBox.setModel(new DefaultComboBoxModel<Object>(Prueba.catpropedidos(pedido, "comida")));
				}else {
					comboBox.setModel(new DefaultComboBoxModel<Object>(new String [3]));
				}
			}
		});
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"PRODUCTO", "CANTIDAD", "PRECIO"
			}
		) {
			
			private static final long serialVersionUID = -793433865013592540L;
			
		});
		scrollPane.setViewportView(table);
		contentPane.setLayout(gl_contentPane);
		if ("bebidas".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
			comboBox.setModel(new DefaultComboBoxModel<Object>(Prueba.catpropedidos(pedido, "bebidas")));
			
			
			
		}else if ("comida".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
			comboBox.setModel(new DefaultComboBoxModel<Object>(Prueba.catpropedidos(pedido, "comida")));
		}else if ("postres".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
			comboBox.setModel(new DefaultComboBoxModel<Object>(Prueba.catpropedidos(pedido, "postres")));
		}else {
			comboBox.setModel(new DefaultComboBoxModel<Object>(new String [3]));
		}
	}public void tprecio(int cas) {
		
		textField.setText(String.valueOf(Prueba.precio(cas))+ " €");
		pedido = cas;
	
	


}public void dificil(int cas) {
	
	table.setModel(Prueba.propedidosdis(cas));




}public void cate(int cas) {
	
	comboBox_1.setModel(new DefaultComboBoxModel<Object>(Prueba.catpedidos(cas)));
	pedido = cas;




}public void eee()  {
	if ("bebidas".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
		comboBox.setModel(new DefaultComboBoxModel<Object>(Prueba.catpropedidos(pedido, "bebidas")));
		
		
		
	}else if ("comida".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
		comboBox.setModel(new DefaultComboBoxModel<Object>(Prueba.catpropedidos(pedido, "comida")));
	}else if ("postres".equals(String.valueOf(comboBox_1.getSelectedItem()))) {
		comboBox.setModel(new DefaultComboBoxModel<Object>(Prueba.catpropedidos(pedido, "postres")));
	}else {
		comboBox.setModel(new DefaultComboBoxModel<Object>(new String [3]));
	}
}
}
