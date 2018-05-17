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

public class BEBIDAS extends JFrame {

	/*
	private static final long serialVersionUID = 8511742837127838651L;
	private JPanel contentPane;
	private JTable table;
	int pedido= 0 ;
	String categoria= "";
	int coca = 0;
	int cerve = 0;
	int fantu = 0;
	int aguaa = 0 ;
	int posic = 0 ;
	int poa = 9;
	int pofa = 9;
	int poce= 9;
	int poco= 9;
	
	
	ConexionBBDD Prueba = new ConexionBBDD();
	String [][] productos = new String [Prueba.countproductoscat("bebidas")][2];

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BEBIDAS frame = new BEBIDAS();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public BEBIDAS() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 682, 418);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(125, 258, 445, 82);
		
		JPanel panel = new JPanel();
		panel.setBounds(33, 11, 602, 128);
		
		JButton btnAadir = new JButton("POSTRE");
		btnAadir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Postres mi = new Postres();
				mi.setVisible(true);
			}
		});
		btnAadir.setBackground(new Color(255, 255, 255));
		btnAadir.setFont(new Font("Arial", Font.BOLD, 14));
		btnAadir.setBounds(33, 189, 93, 40);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prueba.añadirproductosalpedido(pedido, productos);
				cancelar();
				
			}
		});
		btnOk.setBackground(new Color(255, 255, 255));
		btnOk.setFont(new Font("Arial", Font.BOLD, 14));
		btnOk.setBounds(168, 189, 84, 40);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					cancelar();
			}
		});
		btnCancelar.setBackground(new Color(255, 255, 255));
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setBounds(289, 189, 103, 40);
		
		JButton btnAtras = new JButton("ATRAS");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Bar mi = new Bar();
				mi.setVisible(true);
			}
		});
		btnAtras.setBackground(new Color(255, 255, 255));
		btnAtras.setFont(new Font("Arial", Font.BOLD, 14));
		btnAtras.setBounds(424, 189, 86, 40);
		
		JButton btnComida = new JButton("COMIDA");
		btnComida.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Comidas mi = new Comidas();
				mi.setVisible(true);
			}
		});
		btnComida.setBackground(new Color(255, 255, 255));
		btnComida.setFont(new Font("Arial", Font.BOLD, 14));
		btnComida.setBounds(542, 189, 93, 40);
		panel.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton cerveza = new JButton("CERVERZA");
		cerveza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posic ==0 ) {
					poce = posic ;
					posic++;
				}else if(posic!= 0 && poce ==9){
					
					poce = posic;
					posic++;
				}
				if (cerve == 0 ) {
					for (int i = 0; i < productos.length; i++) {
						for (int j = 0; j < 2; j++) {
							if (productos[i][0]== null) {
								
								productos[i][0] = "cerveza";
								productos[i][1] = "1";
							    cerve++ ;
								break ;
							}
							
						}if (cerve == 1) {
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
							if (productos[poce][0].equals("cerveza")) {
							int c = cerve;
							p = c ;
							
							cerve++;
							System.out.println(productos[i][1]);
							productos[poce][1] = String.valueOf(cerve);
							table.setModel(new DefaultTableModel(
									productos,
									new String[] {
										"CANTIDAD", "NOMBRE"
									}
								));
							break;
							
							}
							
							
						}if (cerve - p > 0) {
							break;
						}
					}
				}
			}
		});
		cerveza.setFont(new Font("Arial", Font.BOLD, 15));
		cerveza.setBackground(new Color(255, 215, 0));
		panel.add(cerveza);
		
		JButton cocacola = new JButton("COCACOLA");
		cocacola.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posic ==0 ) {
					poco = posic ;
					posic++;
				}else if(posic!= 0 && poco ==9){
					
					poco = posic;
					posic++;
				}
				if (coca == 0 ) {
					for (int i = 0; i < productos.length; i++) {
						for (int j = 0; j < 2; j++) {
							if (productos[i][0]== null) {
								
								productos[i][0] = "cocacola";
								productos[i][1] = "1";
								coca++ ;
								break ;
							}
							
						}if (coca == 1) {
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
							if (productos[poco][0].equals("cocacola")) {
							int c = coca;
							p = c ;
							
							coca++;
							System.out.println(productos[i][1]);
							productos[poco][1] = String.valueOf(coca);
							table.setModel(new DefaultTableModel(
									productos,
									new String[] {
										"CANTIDAD", "NOMBRE"
									}
								));
							break;
							
							}
							
							
						}if (coca - p > 0) {
							break;
						}
					}
				}
			}
		});
		cocacola.setFont(new Font("Arial", Font.BOLD, 15));
		cocacola.setBackground(new Color(220, 20, 60));
		cocacola.setForeground(new Color(0, 0, 0));
		panel.add(cocacola);
		
		JButton fanta = new JButton("FANTA");
		fanta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posic ==0 ) {
					pofa = posic ;
					posic++;
				}else if(posic!= 0 && pofa ==9){
					
					pofa = posic;
					posic++;
				}
				
				if (fantu == 0 ) {
					
					for (int i = 0; i < productos.length; i++) {
						for (int j = 0; j < 2; j++) {
							if (productos[i][0]== null) {
								
								productos[i][0] = "fanta";
								productos[i][1] = "1";
								fantu++ ;
								break ;
							}
							
						}if (fantu == 1) {
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
							System.out.println("casi llega");
							System.out.println(i);
							System.out.println(productos.length);
							if (productos[pofa][0].equals("fanta")) {
								System.out.println("ha llegado");	
							int c = fantu;
							p = c ;
							
							fantu++;
							
							System.out.println(productos[i][1]);
							productos[pofa][1] = String.valueOf(fantu);
							System.out.println(productos[i][1]);
							table.setModel(new DefaultTableModel(
									productos,
									new String[] {
										"CANTIDAD", "NOMBRE"
									}
								));
							break;
							
							}
							
							
						}if (fantu - p > 0) {
							break;
						}
					}
				}
			}
		});
		fanta.setFont(new Font("Arial", Font.BOLD, 15));
		fanta.setBackground(new Color(255, 165, 0));
		panel.add(fanta);
		
		JButton agua = new JButton("AGUA");
		agua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (posic ==0 ) {
					poa = posic ;
					posic++;
				}else if(posic!= 0 && poa ==9){
					
					poa = posic;
					posic++;
				}
				if (aguaa == 0 ) {
				
					for (int i = 0; i < productos.length; i++) {
						for (int j = 0; j < 2; j++) {
							if (productos[i][0]== null) {
								
								productos[i][0] = "agua";
								productos[i][1] = "1";
								aguaa++ ;
								break ;
							}
							
						}if (aguaa == 1) {
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
							if (productos[poa][0].equals("agua")) {
							int c = aguaa;
							p = c ;
							
							aguaa++;
							System.out.println(productos[i][1]);
							productos[poa][1] = String.valueOf(aguaa);
							table.setModel(new DefaultTableModel(
									productos,
									new String[] {
										"CANTIDAD", "NOMBRE"
									}
								));
							break;
							
							}
							
							
						}if (aguaa - p > 0) {
							break;
						}
					}
				}
			}
		});
		agua.setFont(new Font("Arial", Font.BOLD, 15));
		agua.setBackground(new Color(135, 206, 250));
		panel.add(agua);
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
			
		} poce = 9; poa = 9 ; poco = 9 ; pofa = 9; coca = 0 ; cerve = 0 ; fantu = 0; aguaa = 0;
		}*/
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
	int countcat = Integer.parseInt(Prueba.contarproductosdecategorias("bebidas"));
	
	String [][] productos = new String [Prueba.countproductoscat("bebidas")][2];

	
	public BEBIDAS() {
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
		btnAadir.setIcon(new ImageIcon(BEBIDAS.class.getResource("/defii/postre.png")));
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
		btnAadir.setBounds(15, 170, 130, 67);
		
		JButton btnOk = new JButton("");
		btnOk.setIcon(new ImageIcon(BEBIDAS.class.getResource("/defii/OK.png")));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Prueba.añadirproductosalpedido(pedido, productos);
				cancelar();
			}
		});
		btnOk.setBackground(Color.WHITE);
		btnOk.setFont(new Font("Arial", Font.BOLD, 13));
		btnOk.setBounds(155, 170, 130, 67);
		
		JButton btnCancelar = new JButton("");
		btnCancelar.setIcon(new ImageIcon(BEBIDAS.class.getResource("/defii/cancelar.png")));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cancelar();
			}
		});
		btnCancelar.setBackground(Color.WHITE);
		btnCancelar.setFont(new Font("Arial", Font.BOLD, 13));
		btnCancelar.setBounds(292, 170, 134, 67);
		
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(BEBIDAS.class.getResource("/defii/atras.png")));
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Bar mi = new Bar();
				mi.setVisible(true);
			}
		});
		btnAtras.setBackground(Color.WHITE);
		btnAtras.setFont(new Font("Arial", Font.BOLD, 13));
		btnAtras.setBounds(436, 170, 129, 67);
		
		JButton btnComida = new JButton("");
		btnComida.setIcon(new ImageIcon(BEBIDAS.class.getResource("/defii/comida.png")));
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
		btnComida.setBounds(575, 170, 125, 67);
		
		
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
