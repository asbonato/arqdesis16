package com.aula_05_arquidesis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.aula_05_arquidesis.connection.Conexao;
import com.aula_05_arquidesis.model.Cliente;
import com.aula_05_arquidesis.model.Conta;

public class AcessoDao {
	
	public Conta validarAcesso(int conta) {
		String sqlSelect = "SELECT * FROM conta WHERE conta.conta = ? ";
		
		Conta contaRt = null;
		try (Connection conn = new Conexao().conectar(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, conta);

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					contaRt = new Conta();
					contaRt.setConta(rs.getInt("conta"));
					contaRt.setAgencia(rs.getInt("agencia"));
					contaRt.setSenha(rs.getInt("senha"));
					contaRt.setSaldo(rs.getDouble("saldo"));
				}
			}catch(Exception e){
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
		return contaRt;
	}

	public Cliente consultarCliente(Conta conta) {
		String sqlSelect = "SELECT * FROM cliente WHERE EXISTS(SELECT cliente_id_cliente FROM conta WHERE conta.conta = ?)";
		Cliente cliente = null;
		try (Connection conn = new Conexao().conectar(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, conta.getConta());

			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					cliente = new Cliente();
					cliente.setIdCliente(rs.getInt("id_cliente"));
					cliente.setNome(rs.getString("nome_cliente"));
				}
			}catch(Exception e){
				return null;
			}
		} catch (SQLException e) {
			return null;
		}
	
		return cliente;
	}
}
