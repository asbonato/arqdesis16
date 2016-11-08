package com.aula_05_arquidesis.dao;

import java.util.List;

import com.aula_05_arquidesis.model.Conta;
import com.aula_05_arquidesis.model.Movimento;

public class Extrato {
	
	private MovimentoDao movimentoDB;
	public Extrato(){
		movimentoDB = new MovimentoDao();
	}
	
	public List<Movimento> consultarExtrato(Conta conta){
		return movimentoDB.consultarExtrato(conta);
	}
}
