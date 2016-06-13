package com.aula_05_arquidesis.dao;

import java.sql.PreparedStatement;

import java.sql.SQLException;

import com.aula_05_arquidesis.connection.Conexao;
import com.aula_05_arquidesis.model.DebitoAutomatico;

public class DebitoAutomaticoDao {
	
	private Conexao conn;
	
	public DebitoAutomaticoDao() {
		// TODO Auto-generated constructor stub
		conn = new Conexao();
	}
	
	public boolean cadastrar(DebitoAutomatico debito){
		String sqlInsert = "INSERT INTO DebitoAutomatico(idDebitoAutomatico, atmTipoDebito,"
				+ "atmOperadora,atmCodCons,atmDataDeb,atmValorDeb) VALUES (?, ?, ?, ?, ?,?)";
		PreparedStatement stm = null;
		boolean retorna = false;
		try {
			//
			// Inclusao dos dados na tabela Log //
			stm = conn.conectar().prepareStatement(sqlInsert);
			stm.setInt(1, debito.getIdDebito());
			stm.setString(2,debito.getTipoDebito());
			stm.setInt(3,debito.getOperadora());
			stm.setInt(4,debito.getCodConsumidor());
			stm.setInt(5,debito.getDataDebito());
			stm.setDouble(6, debito.getValorDebito());
			stm.execute();
			retorna = true;
		} catch (Exception e) {
			e.printStackTrace();
			
		} finally {
			if (stm != null) {
				try {
					stm.close();
				} catch (SQLException e1) {
					System.out.print(e1.getStackTrace());
				}
			}
		}
		return retorna;
	}

}
