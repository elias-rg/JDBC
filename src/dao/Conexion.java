package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.firs.jdbc.T_ficha;

public class Conexion {
	protected Connection conexion;
	// jdbc url
	// jdbc userName
	// jdbc password
	private final String url = "jdbc:postgresql://localhost/xestion_fichas_clientes";
	private final String user = "me";
	private final String password = "Abc123..";
	
	Logger loger  = LoggerFactory.getLogger(Conexion.class);
	
	public void conectar() throws SQLException {
		try {
			conexion = DriverManager.getConnection(url, user, password);
		}catch(SQLException e) {
			throw e ; 
		}
	}
	
	public void cerrar() throws SQLException {
		if (conexion != null) {
			if(!conexion.isClosed()) {
				conexion.close();
			}
		}
	}

	
}
