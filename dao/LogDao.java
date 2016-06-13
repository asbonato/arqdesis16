package com.aula_05_arquidesis.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.aula_05_arquidesis.connection.Conexao;
import com.aula_05_arquidesis.model.Log;

public class LogDao {
	
	private Conexao conn;
	
	public LogDao() {
		// TODO Auto-generated constructor stub
		conn = new Conexao();
	}
	
	public boolean incluir(Log log){
		String sqlInsert = "INSERT INTO Log(idLog, atmTipoOp,atmDataOp, atmValor,"
				+ "Movimento_idMovimento,Movimento_Conta_atmConta,"
				+ "Movimento_Conta_Cliente_idCliente) VALUES (?, ?, ?, ?, ?, ?,?)";
		PreparedStatement stm = null;
		boolean retorna = false;
		try {
			//
			// Inclusao dos dados na tabela Log //
			stm = conn.conectar().prepareStatement(sqlInsert);
			stm.setInt(1, log.getIdLog());
			stm.setString(2,log.getTipoOperacao());
			Date date = new Date(System.currentTimeMillis());
			stm.setDate(3,date);
			stm.setDouble(4,log.getValor());
			stm.setInt(5,log.getIdMov());
			stm.setInt(6, log.getConta());
			stm.setDouble(7, log.getIdCliente());
			
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
