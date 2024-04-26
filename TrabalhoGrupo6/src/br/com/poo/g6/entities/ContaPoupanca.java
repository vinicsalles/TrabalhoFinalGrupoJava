package br.com.poo.g6.entities;

import java.util.HashMap;
import java.util.Map;

public class ContaPoupanca extends Conta {
	private Double rendimento = 10.0;

	private static Map<Integer, ContaPoupanca> mapaContaPoupanca = new HashMap<>();

	public static Map<Integer, ContaPoupanca> getMapaContaPoupanca() {
		return mapaContaPoupanca;
	}

	public ContaPoupanca() {
		super();
	}

	@Override
	public String toString() {
		return "ContaPoupanca [rendimento=" + rendimento + ", getRendimento()=" + getRendimento() + ", getConta()="
				+ getConta() + ", getNumeroConta()=" + getNumeroConta() + ", getSaldo()=" + getSaldo()
				+ ", getFkCliente()=" + getFkCliente() + ", getFkAgencia()=" + getFkAgencia() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public ContaPoupanca(Integer conta, Double numeroConta, Double saldo, Integer fkCliente, Integer fkAgencia,
			Double rendimento) {
		super(conta, numeroConta, saldo, fkCliente, fkAgencia);
		this.rendimento = rendimento;
	}

	public static void setMapaContaPoupanca(Map<Integer, ContaPoupanca> mapaContaPoupanca) {
		ContaPoupanca.mapaContaPoupanca = mapaContaPoupanca;
	}

	public double getRendimento() {
		return rendimento;
	}

	public void setRendimento(double rendimento) {
		this.rendimento = rendimento;
	}

	public ContaPoupanca(Double nConta) {
		this.setNumeroConta(nConta + 10);
	}

	public void ContaSaldo(Double ccSaldo) {
		this.setSaldo(ccSaldo + getRendimento());
	}

}
