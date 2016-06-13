package com.aula_05_arquidesis.model;

public class Saque extends Movimento{
	
	private Dispenser dispenser;
	
	public Saque(double valorOperacao,String tipoOperacao) {
		super(valorOperacao, tipoOperacao);
		dispenser = new Dispenser();
	}
	public boolean fazerSaque(){
		dispenser.contarNotas(super.valorOperacao);
		return true;
	}
	

}
