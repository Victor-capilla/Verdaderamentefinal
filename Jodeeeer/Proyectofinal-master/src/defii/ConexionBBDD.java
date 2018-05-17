package defii;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.table.DefaultTableModel;



public class ConexionBBDD {

	
	private String url;
	private String usr;
	private String pwd;
	private String esquema ="";
	private String punto ="";
	private Connection conexion;
	

	public ConexionBBDD()  {
		FicheroINI();
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conexion = DriverManager.getConnection(url, usr, pwd );
			
			if(!conexion.isClosed()) {
				System.out.println("Conexión establecida");
			}
			else
				System.out.println("Fallo en Conexión");	
			

		}catch (Exception e) {
			System.out.println("ERROR en conexión con ORACLE");	
			e.printStackTrace();
		}
		
	}
	
	public void FicheroINI()  {
	Properties propiedades = new Properties();
	InputStream entrada = null; 
	try {
		File miFichero = new File ("Proyectofinal-master//src/defii/ini.ini");
		if (miFichero.exists()) {
			entrada = new FileInputStream(miFichero);
			propiedades.load(entrada);
			url = propiedades.getProperty("dbhost");
			usr = propiedades.getProperty("dbuser");
			pwd = propiedades.getProperty("dbpasswd");
			esquema = propiedades.getProperty("dbname");
			
			comprobar();
			System.out.println("esquema : "+esquema+" punto : "+punto+"");
		}
		else {
			System.err.println("fichero no encontrado");
		}
		}catch (IOException ex) {
			ex.printStackTrace();
		}finally {
			if(entrada != null ) {
				try { 
					entrada.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		}
	

	}public void comprobar () {
		
		if (esquema.equals("") == false || usr.equals("blaca")== false ) {
			punto = ".";
		}
	}
	
	public DefaultTableModel ConsultaTablaEmpleados() {
		String [] columnas={"ID_PRODUCTO","NOMBRE","PRECIO"};
		String [] registro=new String[3];
		
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		System.out.println("SELECT ID_PRODUCTO,NOMBRE,PRECIO FROM "+esquema+""+punto+"PRODUCTOS");
		String query = "SELECT ID_PRODUCTO,NOMBRE,PRECIO FROM "+esquema+""+punto+"PRODUCTOS";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_PRODUCTO");
				 registro[1]=rset.getString("NOMBRE");
		         registro[2]=rset.getString("PRECIO");
		        
		         ModeloTabla.addRow(registro);
		         
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}public DefaultTableModel cobrar(int num) {
		String [] columnas={"NOMBRE","PRECIO","CANTIDAD","SUBTOTAL"};
		String [] registro=new String[4];
		
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "select p.nombre , p.precio , t.cantidad , (p.precio*t.cantidad) from "+esquema+""+punto+"tiene t , "+esquema+""+punto+"productos p where t.id_producto = p.id_producto and id_pedido = "+num+"";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 
				 registro[1]=rset.getString(2);
		         registro[2]=rset.getString(3);
		         registro[0]=rset.getString(1);
		         registro[3]=rset.getString(4);
		        
		         ModeloTabla.addRow(registro);
		         
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
		
	}
	public  String[] categorias() {
		
		String [] registro=new String[3];
		
		
		String query = "SELECT nombre from "+esquema+""+punto+"categoria";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			int m = 0 ;
			while(rset.next()) {
				 registro[m]=rset.getString("nombre");
				 
				 
		       m = m+1; 
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return registro;
		
	}
public  String[] pedidos() {
		ArrayList<String> mi = new ArrayList<>();
		
		
		
		String query = "Select ID_PEDIDO FROM "+esquema+""+punto+"PEDIDO WHERE ID_MESA IN (select id_mesa from "+esquema+""+punto+"mesas where ocupada = 'V')";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				mi.add(rset.getString("ID_PEDIDO"));
				 
				 
		       
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		String [] registro=new String[mi.size()];
		for (int i = 0; i < mi.size(); i++) {
			registro[i] = mi.get(i);
		}
		return registro;
		
	}public  String[] catpedidos(int pedido) {
		ArrayList<String> mi = new ArrayList<>();
		
		
		
		String query = "Select nombre FROM "+esquema+""+punto+"categoria WHERE id_categoria IN (select id_categoria from   "+esquema+""+punto+"productos p ,   "+esquema+""+punto+"tiene t where t.id_producto =p.id_producto and id_pedido = "+pedido+")";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			int m = 0 ;
			while(rset.next()) {
				 mi.add(rset.getString("nombre"));
				 
				 
		       m = m+1; 
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		String [] registro=new String[mi.size()];
		for (int i = 0; i < mi.size(); i++) {
			registro[i] = mi.get(i);
		}
		return registro;
		
	}public  String[] catpropedidos(int pedido, String categoria) {
		ArrayList<String> mi = new ArrayList<>();
		
		
		
		String query = "select nombre from "+esquema+""+punto+"productos where id_producto in (select id_producto from "+esquema+""+punto+"tiene where id_pedido = "+pedido+" ) and id_categoria in (select id_categoria from "+esquema+""+punto+"categoria where nombre ='"+categoria+"')";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			int m = 0 ;
			while(rset.next()) {
				 mi.add(rset.getString("nombre"));
				 
				 
		       m = m+1; 
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		String [] registro=new String[mi.size()];
		for (int i = 0; i < mi.size(); i++) {
			registro[i] = mi.get(i);
		}
		return registro;}
		

	public  String[] productos(String categoria) {
		ArrayList<String> mi = new ArrayList<>();
		
		
		
		String query = "select nombre from "+esquema+""+punto+"productos where id_categoria in (select id_categoria from "+esquema+""+punto+"categoria where nombre = '"+categoria+"')";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				mi.add(rset.getString("NOMBRE"));
				 
				 
		       
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		String [] registro=new String[mi.size()];
		for (int i = 0; i < mi.size(); i++) {
			registro[i] = mi.get(i);
		}
		return registro;
		
	}
	public int conta (int num, int num2) {
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			
			System.out.println("INSERT INTO "+esquema+""+punto+"pedido VALUES("+num+",0,"+num2+")");
			pe = "INSERT INTO "+esquema+""+punto+"pedido VALUES("+num+",0,"+num2+")";
			stmt.executeUpdate(pe);
			stmt.executeUpdate("update "+esquema+""+punto+"mesas set ocupada='V' where id_mesa ="+num2+"");
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int añadirproductocarta (String nombre, String celiaco,String precio , String cantidad,String id ,String id_cat) {
		int r = 0 ;
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("select id_categoria from "+esquema+""+punto+"categoria where nombre = '"+id_cat+"'");
			while (rset.next()) {
				r = Integer.parseInt(rset.getString(1));
			}System.out.println(r);
			rset.close();
			
			
			
			pe = "INSERT INTO "+esquema+""+punto+"productos VALUES("+id+","+r+","+precio+",'"+celiaco+"','"+nombre+"',"+cantidad+")";
			stmt.executeUpdate(pe);
		
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int modificarproductocarta (String nombre, String celiaco,String precio , String cantidad,String id_cat, String productos) {
		int r =0 ;
		int s = 1;
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("select id_producto from "+esquema+""+punto+"productos where nombre = '"+productos+"'");
			
			while (rset.next()) {
				
				r = Integer.parseInt(rset.getString(1));
			
			
			
			}rset.close();
			s = pro(id_cat);
			
			System.out.println("xddd"+r+"ss : "+s);
			
			
			
			if (nombre.length()<1) {
				System.out.println("nada nombre");	
			}else  {
				pe = "update "+esquema+""+punto+"productos set nombre = '"+nombre+"' where id_producto = "+r+" ";
				stmt.executeUpdate(pe);
			}if (celiaco.length()<1) {
				System.out.println("nada celiaco");	
			}else  {
				pe = "update "+esquema+""+punto+"productos set celiaco = '"+celiaco+"' where id_producto = "+r+" ";
				stmt.executeUpdate(pe);
			}if (precio.length() == 0) {
				System.out.println("nada precio");	
			}else  {
				pe = "update "+esquema+""+punto+"productos set precio = "+precio+" where id_producto = "+r+" ";
				stmt.executeUpdate(pe);
			}if (cantidad.length()<1) {
				System.out.println("nada cantidad");	
			}else  {
				pe = "update "+esquema+""+punto+"productos set cantidad = "+cantidad+" where id_producto = "+r+" ";
				stmt.executeUpdate(pe);
			}if (id_cat.length()<1) {
				System.out.println("nada categoria");	
			}else  {
				pe = "update "+esquema+""+punto+"productos set id_categoria = '"+s+"' where id_producto = "+r+" ";
				stmt.executeUpdate(pe);
			}
			
			
			
			
		
			stmt.close();
			
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int COBRar (String num, int num2) {
		int r = 0 ;
		
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery("select id_mesa from "+esquema+""+punto+"pedido where id_pedido = "+num2+"");
			while (rset.next()) {
				r = Integer.parseInt(rset.getString(1));
			}
			rset.close();
			
			
			
			pe = "update "+esquema+""+punto+"pedido set precio_final = "+num+" where id_pedido ="+num2+"";
			stmt.executeUpdate(pe);
			stmt.executeUpdate("update "+esquema+""+punto+"mesas set ocupada='F' where id_mesa ="+r+"");
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public ArrayList<String> productosconcantidad (int pedido) {
		ArrayList<String> mi = new ArrayList<>();
		try {
			Statement stmt = conexion.createStatement();
			
				
					ResultSet rset = stmt.executeQuery("select id_producto from "+esquema+""+punto+"tiene where id_pedido ="+pedido+" ");
					while (rset.next()) {
						mi.add(String.valueOf(rset.getInt(1)));
						
					}
					rset.close();
				}
				
			
		catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	return mi;
		
	}
	
	public int añadirproductosalpedido (int pedido, String[][] producto) {
		ArrayList<Integer> mi = new ArrayList<>();
		
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			for (int i = 0; i < producto.length; i++) {
				if (producto[i][0]!= null) {
					ResultSet rset = stmt.executeQuery("select id_producto from "+esquema+""+punto+"productos where nombre = '"+producto[i][0]+"'");
					while (rset.next()) {
						mi.add(Integer.parseInt(rset.getString(1))) ; 
					}
					rset.close();
				}
				
			}System.out.println("hay : "+mi.size());
			boolean t = false;
			
			for (int i = 0; i < mi.size(); i++) {
				for (int j = 0; j < productosconcantidad(pedido).size(); j++) {
					System.out.println(mi.get(i)+" yyyy" +productosconcantidad(pedido).get(j));
					int c = Integer.parseInt(productosconcantidad(pedido).get(j));
					int u = mi.get(i);
					if (c == u) {
						t = true;
						System.out.println("verdad");
					}
				}
				if (t==true) {
					int can = cantidad(mi.get(i), pedido) + Integer.parseInt(producto[i][1]) ;
					System.out.println("cantidad : "+ can);
					pe = "update "+esquema+""+punto+"tiene set cantidad = "+can+" where id_producto= "+mi.get(i)+" and id_pedido = "+pedido+"";
					stmt.executeUpdate(pe);
					System.out.println("he pasado por aqui");
					
				}else {
					pe = "insert into "+esquema+""+punto+"tiene values("+producto[i][1]+","+mi.get(i)+","+pedido+")";
					stmt.executeUpdate(pe);	
				}t = false;
				
				
				
			}stmt.close();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int  cantidad (int  producto, int pedido) {
		int s = 0 ;
		try {
			Statement stmt = conexion.createStatement();
			
			ResultSet rset = stmt.executeQuery("select cantidad from "+esquema+""+punto+"tiene where id_producto = "+producto+" and id_pedido = "+pedido+"");
			while (rset.next()) {
				s = Integer.parseInt(rset.getString(1));
			}
			rset.close();
		
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return s;}
	public int reducir (String producto, int pedido) {
		int r = 0 ;
		int s = 0 ;
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset_1 = stmt.executeQuery("select id_producto from "+esquema+""+punto+"productos where nombre = '"+producto+"'");
			while (rset_1.next()) {
				r = Integer.parseInt(rset_1.getString(1));
			}
			rset_1.close();
			ResultSet rset = stmt.executeQuery("select cantidad from "+esquema+""+punto+"tiene where id_producto = "+r+" and id_pedido = "+pedido+"");
			while (rset.next()) {
				s = Integer.parseInt(rset.getString(1));
			}
			rset.close();
			if (s==0) {
				pe = "delete from "+esquema+""+punto+"tiene  where id_pedido = "+pedido+" and id_producto = "+r+" " ;
				stmt.executeUpdate(pe);
			}else if (s>0) {
				pe= "update "+esquema+""+punto+"tiene set cantidad = cantidad -1 where id_producto = "+r+" and id_pedido ="+pedido+" " ;
				stmt.executeUpdate(pe);
			}else {
				System.out.println("nada");
			}
			
			
			
			
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int eliminar (String producto, int pedido) {
		int r = 0 ;
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			System.out.println("select id_producto from "+esquema+""+punto+"productos where nombre = '"+producto+"'");
			ResultSet rset_1 = stmt.executeQuery("select id_producto from "+esquema+""+punto+"productos where nombre = '"+producto+"'");
			while (rset_1.next()) {
				r = Integer.parseInt(rset_1.getString(1));
			}
			rset_1.close();
			
			
				pe = "delete from "+esquema+""+punto+"tiene  where id_pedido = "+pedido+" and id_producto = "+r+" " ;
				stmt.executeUpdate(pe);
			
			
			
			
			
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int eliminarpro (String producto) {
		String pe = null;
		try {
			Statement stmt = conexion.createStatement();
			System.out.println("select id_producto from "+esquema+""+punto+"productos where nombre = '"+producto+"'");
			
			
			
				pe = "delete from "+esquema+""+punto+"productos  where nombre = '"+producto+"' ";
				stmt.executeUpdate(pe);
			
			
			
			
			
			
			stmt.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;}
	public int pro (String producto) {
			int r = 0 ;
			try {
				Statement stmt = conexion.createStatement();
				System.out.println("select id_categoria from "+esquema+""+punto+"categoria where nombre = '"+producto+"'");
				
				ResultSet rset = stmt.executeQuery("select id_categoria from "+esquema+""+punto+"categoria where nombre = '"+producto+"'");
				while (rset.next()) {
					
					r = Integer.parseInt(rset.getString(1));
					
				}
					
					
				
				
				
				
				
				
				stmt.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return r;}
	public double precio (int pedido) {
		double r = 0 ;
		String query = "Select sum(p.precio*t.cantidad) from "+esquema+""+punto+"tiene t, "+esquema+""+punto+"productos p where t.id_producto = p.id_producto and id_pedido = "+pedido+" ";
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				r = Double.parseDouble(rset.getString(1));				 
				 
		        
			}
			
			rset.close();
			stmt.close();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return r;}
	public String con () {
		String registro="";
	
	
	String query = "SELECT count(*) from "+esquema+""+punto+"pedido";
	 
	try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()) {
			registro=rset.getString("count(*)");
			 
			 
	        
		}
		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return registro;}
	public String contarproductosdecategorias (String categoria) {
		String registro="";
	
	
	String query = "SELECT count(*) from "+esquema+""+punto+"productos where id_categoria in (select id_categoria from categoria where nombre = '"+categoria+"')";
	 
	try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()) {
			registro=rset.getString("count(*)");
			 
			 
	        
		}
		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return registro;}
	public String countproductos () {
		String registro="";
	
	
	String query = "SELECT count(*) from "+esquema+""+punto+"productos";
	 
	try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()) {
			registro=rset.getString("count(*)");
			 
			 
	        
		}
		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return registro;}
	public int countproductoscat (String categoria) {
		String registro="";
		int r = 0 ;
	
	int id_cat =pro(categoria);
	String query = "SELECT count(*) from "+esquema+""+punto+"productos where id_categoria = "+id_cat+"";
	 
	try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()) {
			registro=rset.getString("count(*)");
			 
			 
	        
		}
		rset.close();
		stmt.close();
		
		
	}catch (SQLException s){
		s.printStackTrace();
	}r = Integer.parseInt(registro);
	
	return r;}
	public DefaultTableModel mesasdis() {
		String [] columnas={"mesas"};
		String [] registro=new String[1];
		
		DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
		String query = "SELECT ID_MESA from "+esquema+""+punto+"MESAS where ocupada = 'F'";
		 
		try {
			Statement stmt = conexion.createStatement();
			ResultSet rset = stmt.executeQuery(query);
			while(rset.next()) {
				 registro[0]=rset.getString("ID_MESA");
				
		        
		         ModeloTabla.addRow(registro);
		         
			}
			rset.close();
			stmt.close();
			
		}catch (SQLException s){
			s.printStackTrace();
		}
		
		return ModeloTabla;
	
	

}
	public DefaultTableModel pedidosdis() {
	String [] columnas={"mesa", "pedido"};
	String [] registro=new String[2];
	
	DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
	String query = "Select ID_MESA , ID_PEDIDO FROM "+esquema+""+punto+"PEDIDO WHERE ID_MESA IN (select id_mesa from "+esquema+""+punto+"mesas where ocupada = 'V')";
	 
	try {
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		while(rset.next()) {
			 registro[0]=rset.getString("ID_MESA");
			 registro[1]=rset.getString("ID_PEDIDO");
	        
	         ModeloTabla.addRow(registro);
	         
		}
		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return ModeloTabla;
	



}public DefaultTableModel propedidosdis(int pedido) {
	String [] columnas={"producto", "cantidad","precio"};
	String [] registro=new String[3];
	
	DefaultTableModel ModeloTabla = new DefaultTableModel(null,columnas);
	String query = "select p.nombre , t.cantidad , (p.precio * t.cantidad) from "+esquema+""+punto+"productos p , "+esquema+""+punto+"tiene t where p.id_producto = t.id_producto and t.id_pedido = "+pedido+"";
	 
	try {
		System.out.println("casi llega");
		Statement stmt = conexion.createStatement();
		ResultSet rset = stmt.executeQuery(query);
		System.out.println("a llega");
		while(rset.next()) {
			 registro[0]=rset.getString(1);
			 registro[1]=rset.getString(2);
			 registro[2]=rset.getString(3);
	         ModeloTabla.addRow(registro);
	         
		}
		rset.close();
		stmt.close();
		
	}catch (SQLException s){
		s.printStackTrace();
	}
	
	return ModeloTabla;


}}
