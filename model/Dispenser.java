package com.aula_05_arquidesis.model;

public class Dispenser {

	private int[] notas = { 1000, 1000, 500 };
	private int[] values = { 10, 20, 50 };

	public Dispenser() {

	}

	public void contarNotas(double valor) {
		int i = 2;
		while (valor > 0) {
			int aux = (int) valor / values[i];
			valor -= aux * values[i];
			notas[i] -= aux;
			i--;
		}
	}

	public String consultarExtratoNotas() {
		return notas[0] + " notas de 10\n" + notas[1] + " notas de 20\n" + notas[2] + " notas de 50";
	}
	
	

}
