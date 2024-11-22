package co.edu.poli.proyecto.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import co.edu.poli.proyecto.modelo.Refugio;

public class Tarea_dao {

	  private  static Conexion fabricaConexion;
		static ResultSet  resultado;
		static Statement sentencia;
		  //private TextField buscar_porM;
		 private Conexion ideas;

		public Tarea_dao() {
			Tarea_dao.fabricaConexion=new Conexion();

		}

public List<Refugio> listar() {
	List<Refugio> listar_prestamo=new ArrayList<>();
	try {

		String sql ="select * from paradigmas_crud.mascota";
		Connection connection = Conexion.getConnection();
		PreparedStatement sentencia = connection.prepareStatement(sql);
		ResultSet data2 =sentencia.executeQuery();

		while (data2.next()) {
			Refugio prestamo=new Refugio();
			prestamo.setID(data2.getInt(1));
			prestamo.setRaza(data2.getString(2));
			prestamo.setProxima_vacuna(data2.getString(3));
			prestamo.setNombre_de_mascota(data2.getString(4));
			prestamo.setSexo(data2.getString(5));
			prestamo.setNombre_usuario(data2.getString(6));
			prestamo.setMayor_edad(data2.getString(7));
			prestamo.setTelefono(data2.getString(8));




			listar_prestamo.add(prestamo);
			System.out.println(prestamo);


		}
		data2.close();
		sentencia.close();


	} catch (Exception e) {
		System.err.println("Ocurrió un error al listar los prestamos");
        System.err.println("Mensaje del error: " + e.getMessage());
        System.err.println("Detalle del error:");
        e.printStackTrace();


		// TODO: handle exception
	}
	return listar_prestamo;
}



public boolean registrar2(Refugio prestamo) {
    try {
        // Consulta sin incluir el campo 'id'
        String sql = "INSERT INTO mascota (id, raza, proxima_vacuna, nombres_de_mascota, sexo, nombre_usuario, mayor_edad, contacto) VALUES (?,?, ?, ?, ?, ?, ?, ?)";
        Connection connection = Conexion.getConnection();

        if (connection == null) {
            System.out.println("Conexión fallida. Verifique la configuración.");
            return false;
        }

        PreparedStatement sentencia = connection.prepareStatement(sql);

        // Asignación de valores
        sentencia.setInt(1, prestamo.getID());
        sentencia.setString(2, prestamo.getRaza());
        sentencia.setString(3, prestamo.getFecha());
        sentencia.setString(4, prestamo.getNombre_de_mascota());
        sentencia.setString(5, prestamo.getSexo());
        sentencia.setString(6, prestamo.getNombre_usuario());
        sentencia.setString(7, prestamo.getMayor_edad());
        sentencia.setString(8, prestamo.getTelefono());

        // Ejecutar sentencia
        sentencia.executeUpdate();
        sentencia.close();

        return true; // Registro exitoso
    } catch (SQLException e) {
        System.err.println("Error al registrar préstamo: " + e.getMessage());
        return false;
    }
}

public boolean editar(Refugio prestamo) {
    try {
        String sql = "UPDATE mascota SET raza=?, proxima_vacuna=?, nombres_de_mascota=?, sexo=?, nombre_usuario=?, mayor_edad=?, contacto=?  WHERE id=?";
        Connection connection = Conexion.getConnection();
        PreparedStatement sentencia = connection.prepareStatement(sql);


        sentencia.setString(1, prestamo.getRaza());
        sentencia.setString(2, prestamo.getFecha());
        sentencia.setString(3, prestamo.getNombre_de_mascota());
        sentencia.setString(4, prestamo.getSexo());
        sentencia.setString(5, prestamo.getNombre_usuario());
        sentencia.setString(6, prestamo.getMayor_edad());
        sentencia.setString(7, prestamo.getTelefono());
        sentencia.setInt(8, prestamo.getID());

        /*    sentencia.setInt(1, prestamo.getID());
	        sentencia.setString(2, prestamo.getRaza());
	        sentencia.setString(3, prestamo.getFecha());
	        sentencia.setString(4, prestamo.getNombre_de_mascota());
	        sentencia.setString(5, prestamo.getSexo());
	        sentencia.setString(6, prestamo.getNombre_usuario());
	        sentencia.setString(7, prestamo.getMayor_edad());
	        sentencia.setString(8, prestamo.getTelefono());*/








        sentencia.executeUpdate();
        sentencia.close();
        return true;
    } catch (Exception e) {
        System.err.println("Ocurrió un error al editar los préstamos");
        System.err.println("Mensaje del error: " + e.getMessage());
        e.printStackTrace();
        return false;
    }
}
public static Refugio buscar_regur(String nombre_usuario) {
	  Refugio prestamo = null;
      String query = "SELECT * FROM paradigmas_crud.mascota WHERE nombre_usuario = ?";

      try (Connection connection = fabricaConexion.getConnection1();
           PreparedStatement stmt = connection.prepareStatement(query)) {

          if (connection == null || connection.isClosed()) {
              System.err.println("Error: la conexión no es válida.");
              return null;
          }

          stmt.setString(1, nombre_usuario);

          try (ResultSet rs = stmt.executeQuery()) {
              if (rs.next()) {
                  prestamo = new Refugio();
                  prestamo.setID(rs.getInt("id"));
                  prestamo.setRaza(rs.getString("raza"));
                  prestamo.setProxima_vacuna(rs.getString("proxima_vacuna"));
                  prestamo.setNombre_de_mascota(rs.getString("nombres_y_apellidos"));
                  prestamo.setTelefono(rs.getString("telefono"));
                  prestamo.setSexo(rs.getString("sexo"));
                  prestamo.setNombre_usuario(rs.getString("nombre_usuario"));
                  prestamo.setMayor_edad(rs.getString("mayor_edad"));
                  prestamo.setTelefono(rs.getString("nombre_del_operador"));
              } else {
                  System.out.println("No se encontró un préstamo con ese nombre.");
              }
          }
      } catch (SQLException e) {
          System.err.println("Error al ejecutar la consulta: " + e.getMessage());
          e.printStackTrace();
      }

      return prestamo;
  }
public boolean eliminar_dato(int id) {
	try {
		String SQL ="delete from  mascota where id=? ";
		Connection connection =Conexion.getConnection();
		PreparedStatement sentencia =connection.prepareStatement(SQL);
		sentencia.setInt(1, id);
		sentencia.executeUpdate();
		return true;


	} catch (Exception e) {
		 System.err.println("Ocurrió un error al eliminar el préstamo");
		    System.err.println("Mensaje del error: " + e.getMessage());
		    System.err.println("Detalle del error:");
		    e.printStackTrace(); // Esto imprime el stack trace completo para más detalles
		    return false;
		}
	}

}



