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

public class Postres extends JFrame {

	
	private static final long serialVersionUID = 8168475267269234237L;
	/*
	private JPanel contentPane;
	private JTable table;
	int pedido= 0 ;
	String categoria = "";
	JButton [] bo = new JButton[30];
	int flan = 0; // coca
	int tarta = 0; // cerve
	int tiramisu = 0; // fanta
	int cafe = 0 ; // agua
	
	int posic = 0 ; 
	int pofl = 9;
	int potar = 9;
	int poti= 9;
	int poca= 9;
	
	ConexionBBDD Prueba = new ConexionBBDD();
	String [][] productos = new String [Prueba.countproductoscat("postres")][2];
	
	

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Postres frame = new Postres();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public Postres() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 425);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(40, 250, 584, 109);
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
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 646, 128);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton btnTiramisu = new JButton("TIRAMISU");
		btnTiramisu.setFont(new Font("Arial", Font.BOLD, 15));
		btnTiramisu.setBackground(new Color(139, 69, 19));
		panel.add(btnTiramisu);
		btnTiramisu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posic ==0 ) {
					poti = posic ;
					posic++;
				}else if(posic!= 0 && poti ==9){
					
					poti = posic;
					posic++;
				}
				if (tiramisu == 0 ) {
					for (int i = 0; i < productos.length; i++) {
						for (int j = 0; j < 2; j++) {
							if (productos[i][0]== null) {
								
								productos[i][0] = "tiramisu";
								productos[i][1] = "1";
							    tiramisu++ ;
								break ;
							}
							
						}if (tiramisu == 1) {
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
							if (productos[poti][0].equals("tiramisu")) {
							int c = tiramisu;
							p = c ;
							
							tiramisu++;
							System.out.println(productos[i][1]);
							productos[poti][1] = String.valueOf(tiramisu);
							table.setModel(new DefaultTableModel(
									productos,
									new String[] {
										"CANTIDAD", "NOMBRE"
									}
								));
							break;
							
							}
							
							
						}if (tiramisu - p > 0) {
							break;
						}
					}
				}
			}
		});
		
		JButton btnFlan = new JButton("FLAN");
		btnFlan.setFont(new Font("Arial", Font.BOLD, 15));
		btnFlan.setBackground(new Color(255, 250, 205));
		panel.add(btnFlan);
		btnFlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posic ==0 ) {
					pofl = posic ;
					posic++;
				}else if(posic!= 0 && pofl ==9){
					
					pofl = posic;
					posic++;
				}
				if (flan == 0 ) {
					for (int i = 0; i < productos.length; i++) {
						for (int j = 0; j < 2; j++) {
							if (productos[i][0]== null) {
								
								productos[i][0] = "flan";
								productos[i][1] = "1";
							    flan++ ;
								break ;
							}
							
						}if (flan == 1) {
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
							if (productos[pofl][0].equals("flan")) {
							int c = flan;
							p = c ;
							
							flan++;
							System.out.println(productos[i][1]);
							productos[pofl][1] = String.valueOf(flan);
							table.setModel(new DefaultTableModel(
									productos,
									new String[] {
										"CANTIDAD", "NOMBRE"
									}
								));
							break;
							
							}
							
							
						}if (flan - p > 0) {
							break;
						}
					}
				}
			}
		});
		
		JButton btnCafe = new JButton("CAFE");
		btnCafe.setFont(new Font("Arial", Font.BOLD, 15));
		btnCafe.setBackground(new Color(160, 82, 45));
		panel.add(btnCafe);
		btnCafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posic ==0 ) {
					poca = posic ;
					posic++;
				}else if(posic!= 0 && poca ==9){
					
					poca = posic;
					posic++;
				}
				if (cafe == 0 ) {
					for (int i = 0; i < productos.length; i++) {
						for (int j = 0; j < 2; j++) {
							if (productos[i][0]== null) {
								
								productos[i][0] = "cafe";
								productos[i][1] = "1";
							    cafe++ ;
								break ;
							}
							
						}if (cafe == 1) {
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
							if (productos[poca][0].equals("cafe")) {
							int c = cafe;
							p = c ;
							
							cafe++;
							System.out.println(productos[i][1]);
							productos[poca][1] = String.valueOf(cafe);
							table.setModel(new DefaultTableModel(
									productos,
									new String[] {
										"CANTIDAD", "NOMBRE"
									}
								));
							break;
							
							}
							
							
						}if (cafe - p > 0) {
							break;
						}
					}
				}
			}
		});
		
		JButton btnTarta = new JButton("TARTA");
		btnTarta.setFont(new Font("Arial", Font.BOLD, 15));
		btnTarta.setBackground(new Color(255, 182, 193));
		panel.add(btnTarta);
		btnTarta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posic ==0 ) {
					potar = posic ;
					posic++;
				}else if(posic!= 0 && potar ==9){
					
					potar = posic;
					posic++;
				}
				if (tarta == 0 ) {
					for (int i = 0; i < productos.length; i++) {
						for (int j = 0; j < 2; j++) {
							if (productos[i][0]== null) {
								
								productos[i][0] = "tarta";
								productos[i][1] = "1";
							    tarta++ ;
								break ;
							}
							
						}if (tarta == 1) {
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
							if (productos[potar][0].equals("tarta")) {
							int c = tarta;
							p = c ;
							
							tarta++;
							System.out.println(productos[i][1]);
							productos[potar][1] = String.valueOf(tarta);
							table.setModel(new DefaultTableModel(
									productos,
									new String[] {
										"CANTIDAD", "NOMBRE"
									}
								));
							break;
							
							}
							
							
						}if (tarta - p > 0) {
							break;
						}
					}
				}
			}
		});
		
		JButton button_4 = new JButton("COMIDA");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Comidas mi = new Comidas();
				mi.setVisible(true);
			}
		});
		button_4.setBackground(new Color(255, 255, 255));
		button_4.setFont(new Font("Arial", Font.BOLD, 13));
		button_4.setBounds(25, 189, 88, 40);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("OK");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prueba.añadirproductosalpedido(pedido, productos);
				cancelar();
			}
		});
		button_5.setBackground(new Color(255, 255, 255));
		button_5.setFont(new Font("Arial", Font.BOLD, 13));
		button_5.setBounds(140, 189, 88, 40);
		contentPane.add(button_5);
		
		JButton button_6 = new JButton("CANCELAR");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		button_6.setBackground(new Color(255, 255, 255));
		button_6.setFont(new Font("Arial", Font.BOLD, 13));
		button_6.setBounds(272, 189, 103, 40);
		contentPane.add(button_6);
		
		JButton button_7 = new JButton("ATRAS");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Bar mi = new Bar();
				mi.setVisible(true);
			}
		});
		button_7.setBackground(new Color(255, 255, 255));
		button_7.setFont(new Font("Arial", Font.BOLD, 13));
		button_7.setBounds(419, 189, 88, 40);
		contentPane.add(button_7);
		
		JButton button_8 = new JButton("BEBIDA");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				BEBIDAS mi = new BEBIDAS();
				mi.setVisible(true);
			}
		});
		button_8.setBackground(new Color(255, 255, 255));
		button_8.setFont(new Font("Arial", Font.BOLD, 13));
		button_8.setBounds(547, 189, 86, 40);
		contentPane.add(button_8);
	}public void cate (String categoria) {
		this.categoria = categoria;
	}public void pedido (int pedido) {
		this.pedido = pedido;
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
			
		} poca = 9; pofl = 9 ; poti = 9 ; potar = 9; tarta = 0 ; cafe = 0 ; tiramisu = 0; flan = 0;
		}*/
  
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
	int countcat = Integer.parseInt(Prueba.contarproductosdecategorias("postres"));
	
	String [][] productos = new String [Prueba.countproductoscat("postres")][2];

	public Postres() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 726, 424);
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
		btnAadir.setIcon(new ImageIcon(Postres.class.getResource("/defii/comidas.png")));
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {setVisible(false);
			Comidas mi = new Comidas();
			mi.setVisible(true);
			mi.cate("comida");
			mi.pedido(pedido);
			mi.botones();
			mi.list();
			}
		});
		btnAadir.setBackground(Color.WHITE);
		btnAadir.setFont(new Font("Arial", Font.BOLD, 13));
		btnAadir.setBounds(15, 171, 130, 61);
		
		JButton btnOk = new JButton("");
		btnOk.setIcon(new ImageIcon(Postres.class.getResource("/defii/OK.png")));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prueba.añadirproductosalpedido(pedido, productos);
				cancelar();
			}
		});
		btnOk.setBackground(Color.WHITE);
		btnOk.setFont(new Font("Arial", Font.BOLD, 13));
		btnOk.setBounds(155, 171, 130, 61);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(Postres.class.getResource("/defii/cancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setBounds(291, 171, 130, 61);
		
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(Postres.class.getResource("/defii/atras.png")));
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
		btnComida.setIcon(new ImageIcon(Postres.class.getResource("/defii/comida.png")));
		btnComida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Comidas mi = new Comidas();
				mi.setVisible(true);
				mi.cate("comida");
				mi.pedido(pedido);
				mi.botones();
				mi.list();
			}
		});
		btnComida.setBackground(Color.WHITE);
		btnComida.setFont(new Font("Arial", Font.BOLD, 13));
		btnComida.setBounds(575, 171, 125, 60);
		
		
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
