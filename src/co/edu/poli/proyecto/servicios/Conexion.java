package co.edu.poli.proyecto.servicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static Connection  connection;
	private String usuario="root";
	private String password="kevin123";
	private String servidor="localhost";
	private String puerto="3306";
	private String nombre_bd="paradigmas_crud";
	private String url="jdbc:mysql://"+servidor+":"+puerto+"/"+nombre_bd+"?serverTimezone=UTC";
	private String driver="com.mysql.cj.jdbc.Driver";

	public Conexion() {
		try {
			Class.forName(driver);
			connection=DriverManager.getConnection(url,usuario,password);
			if (connection!=null) {
				System.out.println("conexion realizada correctamente");
			}




		} catch (Exception e) {
			System.err.println("ocurrio un error en la conexion");
			System.err.println("mensaje del error"+ e.getMessage());
			System.err.println(" detalle del error");
			e.printStackTrace();
		}


	}

 public static Connection getConnection() {
		return connection;
	}

 public Connection getConnection1() throws SQLException {
     return DriverManager.getConnection(url, usuario, password);
 }


public static void main(String[] args) {
	Conexion conexion =new Conexion();
}



}


