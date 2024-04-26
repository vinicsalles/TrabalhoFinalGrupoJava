package br.com.poo.g6.entities;

import java.util.HashMap;
import java.util.Map;

public class ContaCorrente extends Conta {
	private Double saldoMinimo;
	private Double taxaManutencao;

	private static Map<Integer, ContaCorrente> mapaContaCorrente = new HashMap<>();

	public static Map<Integer, ContaCorrente> getMapaContaCorrente() {
		return mapaContaCorrente;
	}

	public ContaCorrente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ContaCorrente(Integer conta, Double numeroConta, Double saldo, Integer fkCliente, Integer fkAgencia,
			Double saldoMinimo, Double taxaManutencao) {
		super(conta, numeroConta, saldo, fkCliente, fkAgencia);
		this.saldoMinimo = saldoMinimo;
		this.taxaManutencao = taxaManutencao;
		// TODO Auto-generated constructor stub
	}

	public Double getSaldoMinimo() {
		return saldoMinimo;
	}

	public void setSaldoMinimo(Double saldoMinimo) {
		this.saldoMinimo = saldoMinimo;
	}

	public Double getTaxaManutencao() {
		return taxaManutencao;
	}

	public void setTaxaManutencao(Double taxaManutencao) {
		this.taxaManutencao = taxaManutencao;
	}

	public static void setMapaContaCorrente(Map<Integer, ContaCorrente> mapaContaCorrente) {
		ContaCorrente.mapaContaCorrente = mapaContaCorrente;
	}

	public ContaCorrente(Double saldoMinimo, Double taxaManutencao) {
		super();
		this.saldoMinimo = saldoMinimo;
		this.taxaManutencao = taxaManutencao;
	}

	@Override
	public String toString() {
		return "ContaCorrente [saldoMinimo=" + saldoMinimo + ", taxaManutencao=" + taxaManutencao
				+ ", getSaldoMinimo()=" + getSaldoMinimo() + ", getTaxaManutencao()=" + getTaxaManutencao()
				+ ", getConta()=" + getConta() + ", getNumeroConta()=" + getNumeroConta() + ", getSaldo()=" + getSaldo()
				+ ", getFkCliente()=" + getFkCliente() + ", getFkAgencia()=" + getFkAgencia() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}
}