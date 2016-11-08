package com.aula_05_arquidesis.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.aula_05_arquidesis.connection.Conexao;
import com.aula_05_arquidesis.model.Cliente;
import com.aula_05_arquidesis.model.Conta;
import com.aula_05_arquidesis.model.Movimento;

public class MovimentoDao {


	public MovimentoDao() {
	}

	public void incluirMovimento(Movimento movimento,Conta conta,Cliente cliente) {
		String sqlInsert = "INSERT INTO movimento(data_movimento,valor_movimento,"+ 
						  "tipo_movimento,conta_conta,conta_cliente_id_cliente)" +
						  "VALUES(?, ?, ?, ?, ?)";

		try (Connection conn = new Conexao().conectar(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setDate(1, new Date(System.currentTimeMillis()));
			stm.setDouble(2, movimento.getValorOperacao());
			stm.setString(3 ,movimento.getTipoOperacao());
			stm.setInt(4, conta.getConta());
			stm.setInt(5, cliente.getIdCliente());
			stm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public List<Movimento> consultarExtrato(Conta conta) {
		String sqlSelect = "SELECT * FROM movimento where movimento.conta_conta = ?";
		
		List<Movimento> lista = new ArrayList<Movimento>();
		
		try (Connection conn = new Conexao().conectar(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				
				stm.setInt(1, conta.getConta());
			try(ResultSet rs = stm.executeQuery();) {
				while (rs.next()) {
					Movimento mov = new Movimento();
					mov.setIdMov(rs.getInt("id_movimento"));
					mov.setTipoOperacao(rs.getString("tipo_movimento"));
					mov.setValorOperacao(rs.getDouble("valor_movimento"));
					java.util.Date date = rs.getTimestamp("data_movimento");
					mov.setDataMovimento(date);
					lista.add(mov);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lista;
	}
}
