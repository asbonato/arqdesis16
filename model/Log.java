package com.aula_05_arquidesis.model;

import java.util.Date;

import com.aula_05_arquidesis.dao.LogDao;

public class Log {
	
	private int idLog;
	private Date dataOperacao;
	private String tipoOperacao;
	private int agencia;
	private int conta;
	private double valor;
	private LogDao db;
	private int idMov;
	private int idCliente;

	public Log(){
		
	}
	
	public Log(int idLog,String tipoOperacao,int agencia, int conta, double valor,int idCliente,int idMov) {
		dataOperacao = new Date();
		this.tipoOperacao = tipoOperacao;
		this.agencia = agencia;
		this.conta = conta;
		this.valor = valor;
		this.idMov = idMov;
		this.idCliente = idCliente;
		db = new LogDao();
	}
	
	public int getIdMov() {
		return idMov;
	}

	public void setIdMov(int idMov) {
		this.idMov = idMov;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public int getIdLog() {
		return idLog;
	}

	public void setIdLog(int idLog) {
		this.idLog = idLog;
	}

	public Date getDataOperacao() {
		return dataOperacao;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
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

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public boolean incluir(){
		return db.incluir(this);
	}

}
