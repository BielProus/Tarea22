package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Consulta {

static String BD="ta14_ejercicio8";
	
	public String inicializacionTabla() { 
		Connection conexion = connect(BD);
		Statement statement = null;
		String missatge;
		
		try {
			statement = conexion.createStatement();
			String sql="DROP TABLE IF EXISTS suministra;";
			statement.execute(sql);
   			sql="CREATE TABLE suministra (idPieza int, idProveedor char(4), Precio int, PRIMARY KEY (idPieza,idProveedor), FOREIGN KEY (idPieza) REFERENCES Piezas(idPieza), FOREIGN KEY (idProveedor) REFERENCES Proveedores(idProveedor));";
   			statement.execute(sql);
   			missatge="Tabla creada";
   			
		}
		catch(SQLException e) {
			missatge=e.toString();
		}
		finally {
			try {
				conexion.close();
			}
			catch (SQLException e) {
				missatge=e.toString();
			}
		}
		return missatge;
	}
	
	public String inserirDatos() { 
		Connection conexion = connect(BD);
		Statement statement = null;
		String missatge;
		try {
			statement = conexion.createStatement();
			//TABLAS------------------------------
			String sql="INSERT INTO suministra VALUES(1,1,'10');";
			statement.execute(sql);
   			sql="INSERT INTO suministra VALUES(2,2,'20');";
   			statement.execute(sql);
   			sql="INSERT INTO suministra VALUES(3,3,'30');";
   			statement.execute(sql);
   			sql="INSERT INTO suministra VALUES(4,4,'40');";
   			statement.execute(sql);
   			sql="INSERT INTO suministra VALUES(5,5,'50');";
   			statement.execute(sql);
   			
   			missatge="Registros creados";
   			
		} 
		catch(SQLException e) {
			missatge=e.toString();
		} 
		finally {
			try {
				conexion.close();
			}
			catch (SQLException e) {
				missatge=e.toString();
			}
		}
		return missatge;
	}
			
	public String registrar (Suministra suministra) {
		Connection conexion = connect(BD);
		PreparedStatement statement= null;
		String missatge;
		String sql="INSERT INTO suministra VALUES(?,?,?);";
		
		try {
			statement=conexion.prepareStatement(sql);
			statement.setInt(1, suministra.getIdPieza());
			statement.setString(2, String.valueOf(suministra.getIdProveedor()));
			statement.setInt(3, suministra.getPrecio());
			statement.execute();
   			
			missatge="Suministro registrado";
   			
		}
		catch(SQLException e) {
			missatge=e.toString();
		}
		finally {
			try {
				conexion.close();
			}
			catch (SQLException e) {
				missatge=e.toString();
			}
		}
		return missatge;
	}

	public String[][] mostrarTabla() {
		Connection conexion = connect(BD);
		PreparedStatement missatge= null;
		int registro=0;
		
		try {
			missatge=conexion.prepareStatement("SELECT COUNT(*) AS total FROM suministra;");
   			ResultSet rs = missatge.executeQuery();
   			rs.next();
   			registro= rs.getInt("total");
   			rs.close();
		}
		catch(SQLException e) {
			System.err.println(e);
		}

		String[][] data = new String[registro][3];
		try {
			missatge=conexion.prepareStatement("SELECT * FROM suministra;");
   			ResultSet rs = missatge.executeQuery(); 
   			int i=0;
   			
   			while (rs.next()) {
   				data[i][0] = rs.getString("IdPieza");
   				data[i][1] = rs.getString("IdProveedor");
   				data[i][2] = rs.getString("Precio");
   				i++;
   	        }
   			rs.close();
   			
		}
		catch(SQLException e) {
			System.err.println(e);
		}
		finally {
			try {
				conexion.close();
			}
			catch (SQLException e) {
				System.err.println(e);
			}
		}
		return data;
	}
	
	public String[][] buscar(int Precio) {
		Connection conexion = connect(BD);
		PreparedStatement missatge= null;
		int registro=0;
		
		try {
			missatge=conexion.prepareStatement("SELECT count(*) as total FROM suministra WHERE Precio="+Precio+";");
   			ResultSet rs = missatge.executeQuery();
   			rs.next();
   			registro = rs.getInt("total");
   			rs.close();
		}
		catch(SQLException e) {
			System.err.println(e);
		}
		
		String[][] data = new String[registro][3];
		try {
			missatge=conexion.prepareStatement("SELECT * FROM suministra WHERE Precio="+Precio+";");
   			ResultSet rs = missatge.executeQuery(); 
   			int i=0;
   			
   			while (rs.next()) {
   				data[i][0] = rs.getString("IdPieza");
   				data[i][1] = rs.getString("IdProveedor");
   				data[i][2] = rs.getString("Precio");
   				i++;
   	        }
   			rs.close();
   			
		}
		catch(SQLException e) {
			System.err.println(e);
		}
		finally {
			try {
				conexion.close();
			}
			catch (SQLException e) {
				System.err.println(e);
			}
		}
		return data;
	}
	
	public String actualizar (Suministra suministra, int idPieza2, char idProveedor2) {
		Connection conexion = connect(BD);
		PreparedStatement missatge2= null;
		String missatge;
		
		String sql="UPDATE suministra SET idPieza=?, idProveedor=?, Precio=? WHERE idPieza=? AND idProveedor=?;";
		
		try {
			missatge2=conexion.prepareStatement(sql);
			missatge2.setInt(1, suministra.getIdPieza());
			missatge2.setString(2, String.valueOf(suministra.getIdProveedor()));
			missatge2.setInt(3, suministra.getPrecio());
			missatge2.setInt(4, idPieza2);
			missatge2.setString(5, String.valueOf(idProveedor2));
			missatge2.executeUpdate();
			missatge="Registro actualizado";
   			
		}
		catch(SQLException e) {
			missatge=e.toString();
		}
		finally {
			try {
				conexion.close();
			}
			catch (SQLException e) {
				missatge=e.toString();
			}
		}
		return missatge;
	}
	
	public String eliminar (int idPieza2, char idProveedor2) {
		Connection conexion = connect(BD);
		PreparedStatement missatge2= null;
		String missatge;
		
		String sql="DELETE FROM suministra WHERE idPieza=? AND idProveedor=?;";
		
		try {
			missatge2=conexion.prepareStatement(sql);
			missatge2.setInt(1, idPieza2);
			missatge2.setString(2, String.valueOf(idProveedor2)); 
			missatge2.executeUpdate();
	   			
			missatge="Registro eliminado";
	   	
		}
		catch(SQLException e) {
			missatge=e.toString();
		}
		finally {
			try {
				conexion.close();
			}
			catch (SQLException e) {
				missatge=e.toString();
			}
		}
		return missatge;
	}

	public String borrarTabla() { 
		Connection conexion = connect(BD);
		Statement statement = null;
		String missatge;
		
		try {
			statement = conexion.createStatement();
			String sql="DROP TABLE IF EXISTS suministra;";
			statement.execute(sql);
			missatge="Tabla eliminada";
   			
		}
		catch(SQLException e) {
			missatge=e.toString();
		}
		finally {
			try {
				conexion.close();
			}
			catch (SQLException e) {
				missatge=e.toString();
			}
		}
		return missatge;
	}
}
