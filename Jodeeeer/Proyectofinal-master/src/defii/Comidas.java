package defii;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class Comidas extends JFrame {

	
	private static final long serialVersionUID = -8842474838288883484L;
	private JPanel contentPane;
	private JTable table;
	int pedido= 0 ;
	String categoria = "";
	ConexionBBDD Prueba = new ConexionBBDD();
	JPanel panel ;
	JButton [] bo = new JButton[30];
	ArrayList<JButton> bo2 ;
	ArrayList<Integer> product = new	ArrayList<Integer>();
	ArrayList<Integer> posiciones = new	ArrayList<Integer>();
	int z = 0;
	 String [] xd ;
	int posic = 0 ; 
	int countcat = Integer.parseInt(Prueba.contarproductosdecategorias("comida"));
	
	String [][] productos = new String [Prueba.countproductoscat("comida")][2];

	
	public Comidas() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 737, 424);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		arr();
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(26, 270, 618, 104);
		
		 panel = new JPanel();
		panel.setBounds(15, 11, 646, 128);
		
		JButton btnAadir = new JButton("");
		btnAadir.setIcon(new ImageIcon(Comidas.class.getResource("/defii/postre.png")));
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {setVisible(false);
			Postres mi = new Postres();
			mi.setVisible(true);
			mi.cate("postres");
			mi.pedido(pedido);
			mi.botones();
			mi.list();
			}
		});
		btnAadir.setBackground(Color.WHITE);
		btnAadir.setFont(new Font("Arial", Font.BOLD, 13));
		btnAadir.setBounds(15, 171, 130, 61);
		
		JButton btnOk = new JButton("");
		btnOk.setIcon(new ImageIcon(Comidas.class.getResource("/defii/OK.png")));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prueba.añadirproductosalpedido(pedido, productos);
				cancelar();
			}
		});
		btnOk.setBackground(Color.WHITE);
		btnOk.setFont(new Font("Arial", Font.BOLD, 13));
		btnOk.setBounds(149, 171, 132, 61);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(Comidas.class.getResource("/defii/cancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setBounds(291, 171, 130, 61);
		
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(Comidas.class.getResource("/defii/atras.png")));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Bar mi = new Bar();
				mi.setVisible(true);
			}
		});
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setFont(new Font("Arial", Font.BOLD, 13));
		btnAtras.setBounds(429, 171, 136, 61);
		
		JButton btnComida = new JButton("");
		btnComida.setIcon(new ImageIcon(Comidas.class.getResource("/defii/bebida.png")));
		btnComida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BEBIDAS mi = new BEBIDAS();
				mi.setVisible(true);
				mi.cate("bebidas");
				mi.pedido(pedido);
				mi.botones();
				mi.list();
			}
		});
		btnComida.setBackground(Color.WHITE);
		btnComida.setFont(new Font("Arial", Font.BOLD, 13));
		btnComida.setBounds(575, 171, 136, 61);
		
		
		int r = 0 ;
		
		
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
			},
			new String[] {
				"CANTIDAD", "NOMBRE"
			}
		));
		scrollPane_1.setViewportView(table);
		contentPane.add(scrollPane_1);
		contentPane.add(btnAadir);
		contentPane.add(btnOk);
		contentPane.add(btnCancelar);
		contentPane.add(btnAtras);
		contentPane.add(btnComida);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		/*JButton btnEnsalada = new JButton("ENSALADA");
		btnEnsalada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boton(poen, ensalada, "ensalada");
			}
		});
		btnEnsalada.setBackground(new Color(50, 205, 50));
		btnEnsalada.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(btnEnsalada);
		
		JButton btnAlmeja = new JButton("ALMEJA");
		btnAlmeja.setBackground(new Color(255, 248, 220));
		btnAlmeja.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(btnAlmeja);
		btnAlmeja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boton(poal, almeja, "almeja");
			}
		});
		
		JButton btnCordero = new JButton("CORDERO");
		btnCordero.setBackground(new Color(205, 133, 63));
		btnCordero.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(btnCordero);
		btnCordero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boton(pocor, cordero, "cordero");
			}
		});
		
		JButton btnSolomillo = new JButton("SOLOMILLO");
		btnSolomillo.setBackground(new Color(220, 20, 60));
		btnSolomillo.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(btnSolomillo);
		btnSolomillo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boton(poso, solomillo, "solomillo");
			}
		});
		
		
		JButton btnQueso = new JButton("QUESO");
		btnQueso.setBackground(new Color(245, 245, 220));
		btnQueso.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(btnQueso);
		btnQueso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boton(poque, queso, "queso");
			}
		});
		
		JButton btnGula = new JButton("GULA");
		btnGula.setBackground(new Color(220, 220, 220));
		btnGula.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(btnGula);
		btnGula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boton(pogu, gula, "gula");
			}
		});
		
		JButton btnJamon = new JButton("JAMON");
		btnJamon.setBackground(new Color(255, 0, 0));
		btnJamon.setFont(new Font("Arial", Font.BOLD, 12));
		panel.add(btnJamon);
		btnJamon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boton(poja, jamon, "jamon");
			}
		});*/
		
	}public void cancelar () {	table.setModel(new DefaultTableModel(
			new Object[posic][2] ,
			new String[] {
				"CANTIDAD", "NOMBRE"
			}
		));posic= 0;
		for (int i = 0; i < productos.length; i++) {
			for (int j = 0; j < 2; j++) {
				productos[i][j]= null;
			}
			
		} for (int i = 0; i < posiciones.size(); i++) {
			posiciones.set(i, 9);
			product.set(i, 0);
			
		}
		}
	public void cate (String categoria) {
		this.categoria = categoria;
		
	}public void arr() {
		for (int i = 0; i < countcat; i++) {
			product.add(0);
			posiciones.add(9); // he modificado esto 
			
		}
		
		
	}
	public void pedido (int pedido) {
		this.pedido = pedido;
	}public void botones() {
		System.out.println("YA SOLO PIDO TERMINAAAAAR CONTADOR "+Prueba.contarproductosdecategorias(categoria)+"");
		int s  = Prueba.productos(categoria).length;
		 xd = Prueba.productos(categoria);
		for (int i = 0; i < xd.length; i++) {
			System.out.println(xd[i]);
		}
		System.out.println(categoria+"xd "+  Prueba.countproductoscat(categoria));
		bo2 = new ArrayList<JButton>();
		for (int i = 0; i < s; i++) {
		System.out.println(categoria+"xd "+i);
		System.out.println(xd[i]);
		JButton bot3 = new JButton(xd[i]);
		 bot3.setFont(new Font("Arial", Font.BOLD, 15));
		 bot3.setBackground(new Color(255, 182, 193));
		 
		 panel.add(bot3);
		bo2.add(bot3);
		
			
			
			
			
		}
		
		
		 
		
		 
		 
		
		 
			
			
			
		}
		
		
	public void boton(int posi , int producto,String nombre) {
	System.out.println("1- posicion local :  "+posi+" posicion global : "+posic+" producto : "+xd[z]+" posicion de los arrays product , posiciones y xd : "+z+" cantidad : "+product.get(z)+" oo "+producto+"");
				if (posic ==0 ) {
					posiciones.set(z, posic) ;
					posic++;
				}else if(posic!= 0 && posiciones.get(z) ==9){
					
					posiciones.set(z, posic) ;
					posic++;
				}
				if (product.get(z)== 0 ) {
					System.out.println("2- posicion local :  "+posi+" posicion global : "+posic+" producto : "+xd[z]+" posicion de los arrays product , posiciones y xd : "+z+" cantidad : "+product.get(z)+" oo "+producto+"");
					for (int i = 0; i < productos.length; i++) {
						for (int j = 0; j < 2; j++) {
							if (productos[i][0]== null) {
								
								productos[i][0] = xd[z];
								productos[i][1] = "1";
								product.set(z,product.get(z)+1 ) ;
							    System.out.println("3- posicion local :  "+posi+" posicion global : "+posic+" producto : "+xd[z]+" posicion de los arrays product , posiciones y xd : "+z+" cantidad : "+product.get(z)+" oo "+producto+"");
								break ;
							}
							
						}if ( product.get(z)== 1) {
							break;
						}
					}
					table.setModel(new DefaultTableModel(
							productos,
							new String[] {
								"CANTIDAD", "NOMBRE"
							}
						));
				}else {
					int p = 0;
					for (int i = 0; i < productos.length; i++) {
						for (int j = 0; j < 2; j++) {
							if (productos[posiciones.get(z)][0].equals(xd[z])) {
							int c =product.get(z);
							p = c ;
							
							product.set(z,product.get(z)+1 ) ;
							System.out.println(productos[i][1]);
							productos[posiciones.get(z)][1] = String.valueOf(product.get(z));
							table.setModel(new DefaultTableModel(
									productos,
									new String[] {
										"CANTIDAD", "NOMBRE"
									}
								));
							break;
							
							}
							
							
						}if (product.get(z) - p > 0) {
							break;
						}
					}
				}
			
		
	}public void list () {
		int j = 0;
		
		while (j < countcat) {
			final Integer innerJ = new Integer(j);
			System.out.println(j);
			System.out.println(" el nombre : "+xd[j]+" estoy arto : "+j+" long posi : "+posiciones.size()+" long posi "+product.size()+"");
			//System.out.println("la posicion : "+posiciones.get(j)+" el producto : "+product.get(j)+" el nombre : "+xd[j]+"");
			bo2.get(j).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					z = innerJ ;
					boton(posiciones.get(innerJ), product.get(innerJ) , xd[innerJ]);
					
					
				}
			});
			
			j++;
		}
		
	}
}
