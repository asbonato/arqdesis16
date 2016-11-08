package com.aula_05_arquidesis.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aula_05_arquidesis.connection.Conexao;
import com.aula_05_arquidesis.model.Cliente;

public class ClienteDao {
	
	private Conexao conn;
	
	public ClienteDao() {
		// TODO Auto-generated constructor stub
		conn = new Conexao();
	}
	
	public Cliente consultarCliente(Cliente cliente) {
		String sqlSelect = "SELECT * FROM cliente WHERE cliente.id_cliente = ? ";
		PreparedStatement stm = null;
		ResultSet rs = null;
		try {
			stm = conn.conectar().prepareStatement(sqlSelect);
			stm.setInt(1, cliente.getIdCliente());
			rs = stm.executeQuery();
			if (rs.next()) {
				cliente.setNome(rs.getString("atmNome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					e1.getStackTrace();
				}
			}
		}
		conn.desconectar();
		return cliente;
	}
}
