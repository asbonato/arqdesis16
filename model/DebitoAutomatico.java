package com.aula_05_arquidesis.model;

import com.aula_05_arquidesis.dao.DebitoAutomaticoDao;

public class DebitoAutomatico {
	
	private int idDebito;
	private String tipoDebito;
	private int operadora;
	private int codConsumidor;
	private int dataDebito;
	private double valorDebito;
	private DebitoAutomaticoDao db;
	
	
	public DebitoAutomatico(int idDebito,String tipoDebito, int operadora, int codConsumidor, int dataDebito,
			double valorDebito) {
		this.idDebito = idDebito;
		this.tipoDebito = tipoDebito;
		this.operadora = operadora;
		this.codConsumidor = codConsumidor;
		this.dataDebito = dataDebito;
		this.valorDebito = valorDebito;
		db = new DebitoAutomaticoDao();
	}
	
	public int getIdDebito() {
		return idDebito;
	}

	public void setIdDebito(int idDebito) {
		this.idDebito = idDebito;
	}

	public String getTipoDebito() {
		return tipoDebito;
	}
	public void setTipoDebito(String tipoDebito) {
		this.tipoDebito = tipoDebito;
	}
	public int getOperadora() {
		return operadora;
	}
	public void setOperadora(int operadora) {
		this.operadora = operadora;
	}
	public int getCodConsumidor() {
		return codConsumidor;
	}
	public void setCodConsumidor(int codConsumidor) {
		this.codConsumidor = codConsumidor;
	}
	public int getDataDebito() {
		return dataDebito;
	}
	public void setDataDebito(int dataDebito) {
		this.dataDebito = dataDebito;
	}
	public double getValorDebito() {
		return valorDebito;
	}
	public void setValorDebito(double valorDebito) {
		this.valorDebito = valorDebito;
	}
	
	public boolean cadastrar(){
		return db.cadastrar(this);
	}
}
