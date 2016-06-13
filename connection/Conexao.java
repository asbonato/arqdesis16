package com.aula_05_arquidesis.connection;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	Connection conn = null;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}

	public Connection conectar() throws SQLException {
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/conect", "root", "1234");
		return conn;
	}
	
	public void desconectar(){
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
