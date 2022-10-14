package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	final String DB_URL = "jdbc:mysql://localhost:3306/";
	final String USERNAME = "root";
	final String PASSWORD = "";
	
	public Connection conexion = null;
	
	public Connection connect(String BD) {
	    try {
	    	conexion = DriverManager.getConnection(DB_URL+BD, USERNAME, PASSWORD);

	    }catch(SQLException ex) {
	    	System.out.println(ex);
	    }
	    return conexion;
	}
	
	public Connection close() {
		if (conexion!=null) {
			try {
		    	conexion.close();
		    	
		    }catch(SQLException ex) {
		    	System.out.println(ex);
		    }
		}
	    return conexion;
	}
}
