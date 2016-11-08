package com.aula_05_arquidesis.model;

import com.aula_05_arquidesis.dao.AcessoDao;

public class Acesso {
	
	private AcessoDao db;
	
	public Acesso(){
		db = new AcessoDao();
	}
	
	public boolean validarAcesso(Conta conta){
		Conta contaBD = db.validarAcesso(conta.getConta());
		
		boolean isValid = false;
		
		if(contaBD != null){
			
			if(contaBD.getConta() == conta.getConta() && 
				contaBD.getAgencia() == conta.getAgencia() &&
				contaBD.getSenha() == conta.getSenha()){
				isValid = true;
			}
			
		}
		
		return isValid;
	}

	public Cliente consultarCliente(Conta conta) {
		return db.consultarCliente(conta);
	}
}
