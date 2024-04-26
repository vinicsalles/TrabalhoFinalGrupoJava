package br.com.poo.g6.services;

import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.entities.Cliente;
import br.com.poo.g6.entities.Conta;
import br.com.poo.g6.entities.ContaCorrente;
import br.com.poo.g6.entities.ContaPoupanca;

public class ContaService {
	Conta conta = new Conta();
	static Logger logger = Util.setupLogger();
	ContaCorrente contaCorrente = new ContaCorrente();

	public void sacarContaCorrente(Cliente cliente) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###.00");

		for (ContaCorrente contaCorrente : ContaCorrente.getMapaContaCorrente().values()) {
			if (contaCorrente.getFkCliente().equals(cliente.getId())) {
				Util.customizer();
				logger.log(Level.INFO, "Digite o Valor de Saque: ");
				Double valor = sc.nextDouble();
				if (valor <= 0) {
					Util.customizer();
					logger.log(Level.INFO, "Você não pode sacar valor negativo ");
				} else if (valor > contaCorrente.getSaldo()) {
					Util.customizer();
					logger.log(Level.INFO, "Saldo Insuficiente ");
				} else {
					Double novoSaldo = contaCorrente.getSaldo() - valor - 0.10;
					contaCorrente.setSaldo(novoSaldo);
					Util.customizer();
					logger.log(Level.INFO, "Saque Efetuado com Sucesso!! ");
					Util.customizer();
					logger.log(Level.INFO, "Taxa de Saque cobrada no valor de R$:0,10 ");
					Util.customizer();
					logger.log(Level.INFO, "Seu Saldo da Conta Corrente é: " + df.format(contaCorrente.getSaldo()));
				}
				return;
			}
			sc.close();
		}
	}

	public void sacarContaPoupanca(Cliente cliente) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###.00");

		for (ContaPoupanca contaPoupanca : ContaPoupanca.getMapaContaPoupanca().values()) {
			if (contaPoupanca.getFkCliente().equals(cliente.getId())) {
				Util.customizer();
				logger.log(Level.INFO, "Digite o Valor de Saque: ");
				Double valor = sc.nextDouble();
				if (valor <= 0) {
					Util.customizer();
					logger.log(Level.INFO, "Você não pode sacar valor negativo ");
				} else if (valor > contaPoupanca.getSaldo()) {
					Util.customizer();
					logger.log(Level.INFO, "Saldo Insuficiente ");
				} else {
					Double novoSaldo = contaPoupanca.getSaldo() - valor - 0.10;
					contaPoupanca.setSaldo(novoSaldo);
					Util.customizer();
					logger.log(Level.INFO, "Saque Efetuado com Sucesso!! ");
					Util.customizer();
					logger.log(Level.INFO, "Taxa de Saque cobrada no valor de R$:0,10 ");
					Util.customizer();
					logger.log(Level.INFO, "Seu Saldo da Conta Poupança é: " + df.format(contaPoupanca.getSaldo()));
				}

				return;
			}
			sc.close();
		}
	}

	public void depositarContaCorrente(Cliente cliente) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###.00");

		for (ContaCorrente contaCorrente : ContaCorrente.getMapaContaCorrente().values()) {
			if (contaCorrente.getFkCliente().equals(cliente.getId())) {
				Util.customizer();
				logger.log(Level.INFO, "Digite o Valor de Depósito: ");
				Double valor = sc.nextDouble();
				if (valor <= 0) {
					Util.customizer();
					logger.log(Level.INFO, "Você não pode Depositar valor negativo ");
				} else {
					Double novoSaldo = contaCorrente.getSaldo() + valor - 0.10;
					contaCorrente.setSaldo(novoSaldo);
					Util.customizer();
					logger.log(Level.INFO, "Depósito Efetuado com Sucesso!! ");
					Util.customizer();
					logger.log(Level.INFO, "Taxa de Depósito cobrada no valor de R$:0,10 ");
					Util.customizer();
					logger.log(Level.INFO, "Seu Saldo da Conta Corrente é: " + df.format(contaCorrente.getSaldo()));
				}
				return;
			}
			sc.close();

		}
	}

	public void depositarContaPoupanca(Cliente cliente) {
		Scanner sc = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###.00");

		for (ContaPoupanca contaPoupanca : ContaPoupanca.getMapaContaPoupanca().values()) {
			if (contaPoupanca.getFkCliente().equals(cliente.getId())) {
				Util.customizer();
				logger.log(Level.INFO, "Digite o Valor de Depósito: ");
				Double valor = sc.nextDouble();
				if (valor <= 0) {
					Util.customizer();
					logger.log(Level.INFO, "Você não pode Depositar valor negativo ");
				} else {
					Double novoSaldo = contaPoupanca.getSaldo() + valor - 0.10;
					contaPoupanca.setSaldo(novoSaldo);
					Util.customizer();
					logger.log(Level.INFO, "Depósito Efetuado com Sucesso!! ");
					Util.customizer();
					logger.log(Level.INFO, "Taxa de Depósito cobrada no valor de R$:0,10 ");
					Util.customizer();
					logger.log(Level.INFO, "Seu Saldo da Conta Poupança é: " + df.format(contaPoupanca.getSaldo()));
				}
				return;
			}
			sc.close();
		}
	}

	public void transferirCorrenteCorrente(Cliente cliente) {
		Scanner sc1 = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("#,###.00");
		Integer numeroContaOrigem = cliente.getId();

		ContaCorrente contaOrigem = ContaCorrente.getMapaContaCorrente().get(numeroContaOrigem);
		if (contaOrigem == null || contaOrigem.getFkCliente() != cliente.getId()) {
			Util.customizer();
			logger.log(Level.INFO, "Digite o numero id da conta destino");
		}

		Util.customizer();
		logger.log(Level.INFO, "Digite o número da conta destino: ");
		Integer numeroContaDestino = sc1.nextInt();

		ContaCorrente contaDestino = ContaCorrente.getMapaContaCorrente().get(numeroContaDestino);
		if (contaDestino == null) {
			Util.customizer();
			logger.log(Level.INFO, "Id da conta destino inválido");
		}

		Util.customizer();
		logger.log(Level.INFO, "Digite o Valor de Transferência: ");
		Double valor = sc1.nextDouble();

		if (valor <= 0) {
			Util.customizer();
			logger.log(Level.INFO, "Você não pode transferir um valor negativo ");
		} else if (contaOrigem.getSaldo() < valor) {
			Util.customizer();
			logger.log(Level.INFO, "Saldo insuficiente para transferência");
		} else {
			Double novoSaldoOrigem = contaOrigem.getSaldo() - valor - 0.20;
			Double novoSaldoDestino = contaDestino.getSaldo() + valor;
			contaOrigem.setSaldo(novoSaldoOrigem);
			contaDestino.setSaldo(novoSaldoDestino);
			Util.customizer();
			logger.log(Level.INFO, "Transferência Efetuada com Sucesso!! ");
			Util.customizer();
			logger.log(Level.INFO, "Taxa de transferência cobrada no valor de R$:0,20 ");
			Util.customizer();
			logger.log(Level.INFO, "Seu novo Saldo da Conta é: " + df.format(contaOrigem.getSaldo()));
		}

	}

	public void relatorioTributoConta(Cliente cliente) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		for (ContaCorrente contaCorrente : ContaCorrente.getMapaContaCorrente().values()) {
			if (contaCorrente.getFkCliente().equals(cliente.getId())) {
				Util.customizer();
				logger.log(Level.INFO, "\nTributos Cobrados Anualmente caso o usuário faça 3 transações ao mês\n");
				double trib = 0.30;
				Util.customizer();
				logger.log(Level.INFO, "O valor de Tributação Cobrado por saque ano foi: R$:" + df.format(trib * 12));
			}
		}
	}

	public void relatorioRendimentoConta(Cliente cliente) {
		DecimalFormat df = new DecimalFormat("#,###.00");
		for (ContaPoupanca contaPoupanca : ContaPoupanca.getMapaContaPoupanca().values()) {
			if (contaPoupanca.getFkCliente().equals(cliente.getId())) {
				Util.customizer();
				logger.log(Level.INFO, "\nRendimento entre 5 anos\n");
				for (int i = 1; i < 6; i++) {
					double rend = 0.10;
					Util.customizer();
					logger.log(Level.INFO,
							"O valor Redimento do ano " + i + " foi: R$:" + df.format(rend * contaPoupanca.getSaldo()));
				}
			}
		}
	}
}
