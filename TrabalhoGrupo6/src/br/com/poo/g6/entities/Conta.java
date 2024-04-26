package br.com.poo.g6.entities;

public class Conta {
	private Integer conta;
	private Double numeroConta;
	private Double saldo;
	private Integer fkCliente;
	private Integer fkAgencia;

	public Conta() {
		super();
	}

	public Conta(Integer conta, Double numeroConta, Double saldo, Integer fkCliente, Integer fkAgencia) {
		super();
		this.conta = conta;
		this.numeroConta = numeroConta;
		this.saldo = saldo;
		this.fkCliente = fkCliente;
		this.fkAgencia = fkAgencia;
	}

	public Integer getConta() {
		return conta;
	}

	public void setConta(Integer conta) {
		this.conta = conta;
	}

	public Double getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(Double numeroConta) {
		this.numeroConta = numeroConta;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Integer getFkCliente() {
		return fkCliente;
	}

	public void setFkCliente(Integer fkCliente) {
		this.fkCliente = fkCliente;
	}

	public Integer getFkAgencia() {
		return fkAgencia;
	}

	public void setFkAgencia(Integer fkAgencia) {
		this.fkAgencia = fkAgencia;
	}
}
