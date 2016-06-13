package com.aula_05_arquidesis.model;

import java.util.Date;

import com.aula_05_arquidesis.dao.MovimentoDao;

public class Movimento {

	protected Date dataMovimento;
	protected double valorOperacao;
	protected MovimentoDao db;
	protected int idMov;
	protected String tipoOperacao;
	
	public Movimento() {
		db = new MovimentoDao();
	}
	
	public Movimento(double valorOperacao, String tipoOperacao) {
		dataMovimento = null;
		this.valorOperacao = valorOperacao;
		this.tipoOperacao = tipoOperacao;
		db = new MovimentoDao();
	}
	
	public int getIdMov() {
		return idMov;
	}

	public void setIdMov(int idMov) {
		this.idMov = idMov;
	}

	public Date getDataMovimento() {
		return dataMovimento;
	}
	
	public void setDataMovimento(Date dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public double getValorOperacao() {
		return valorOperacao;
	}

	public void setValorOperacao(double valorOperacao) {
		this.valorOperacao = valorOperacao;
	}

	public String getTipoOperacao() {
		return tipoOperacao;
	}

	public void setTipoOperacao(String tipoOperacao) {
		this.tipoOperacao = tipoOperacao;
	}
	
	public void incluirMovimento(Movimento movimento,Conta conta,Cliente cliente){
		 db.incluirMovimento(this,conta,cliente);
	}
}
