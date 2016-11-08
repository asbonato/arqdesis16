package com.aula_05_arquidesis.model;

import com.aula_05_arquidesis.dao.ContaDao;

public class Conta {
	
	private int agencia;
	private int conta;
	private int senha;
	private double saldo;
	private ContaDao db;
	
	public Conta(){
		db = new ContaDao();
	}
	public Conta(int agencia, int conta, int senha) {
		this.agencia = agencia;
		this.conta = conta;
		this.senha = senha;
		this.saldo = 0;
		db = new ContaDao();
	}
	public int getAgencia() {
		return agencia;
	}
	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}
	public int getConta() {
		return conta;
	}
	public void setConta(int conta) {
		this.conta = conta;
	}
	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public double consultarSaldo(){
		 return db.consultarSaldo(this);
	}
	
	public int atualizarSaldo(){
		return db.atualizarSaldo(this);
	}
}
