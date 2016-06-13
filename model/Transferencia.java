package com.aula_05_arquidesis.model;

public class Transferencia extends Movimento {
	
	private int agenciaDestino;
	private int contaDestino;
	
	public Transferencia(int idMov,double valorOperacao,int agenciaDestino,
						 int contaDestino,String tipoOperacao) {
		super(valorOperacao, tipoOperacao);
		// TODO Auto-generated constructor stub
		setAgenciaDestino(agenciaDestino);
		setContaDestino(contaDestino);
	}

	public int getAgenciaDestino() {
		return agenciaDestino;
	}

	public void setAgenciaDestino(int agenciaDestino) {
		this.agenciaDestino = agenciaDestino;
	}

	public int getContaDestino() {
		return contaDestino;
	}

	public void setContaDestino(int contaDestino) {
		this.contaDestino = contaDestino;
	}
	
	public void fazerTransferenccia(){
		
	}

}
