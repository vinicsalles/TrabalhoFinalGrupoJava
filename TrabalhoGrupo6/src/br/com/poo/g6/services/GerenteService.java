package br.com.poo.g6.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.entities.Agencia;
import br.com.poo.g6.entities.Cliente;
import br.com.poo.g6.entities.ContaCorrente;
import br.com.poo.g6.entities.ContaPoupanca;
import br.com.poo.g6.entities.Gerente;
import br.com.poo.g6.io.RelatorioIO;

public class GerenteService {
	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public static void numeroContas(Gerente gerente) throws IOException, InterruptedException {
		Integer numContas = 0;
		for (Agencia agencia : Agencia.getMapaAgencia().values()) {
			for (ContaCorrente contaCorrente : ContaCorrente.getMapaContaCorrente().values()) {
				for (ContaPoupanca contaPoupanca : ContaPoupanca.getMapaContaPoupanca().values()) {
					if (contaCorrente.getFkAgencia() == agencia.getId()
							&& contaPoupanca.getFkAgencia() == agencia.getId()
							&& gerente.getFkAgencia() == agencia.getId()) {
						numContas++;
					}
				}
			}
		}
		Util.customizer();
		logger.log(Level.INFO, "\n----------------------------------------\n" + "Total de " + numContas + " Contas");

		Util.customizer();
		logger.log(Level.INFO,
				"\n----------------------------------------\n" + "[1]Gerar   arquivo para impressão: \n" + "[2]Voltar");
		int opcao = lerOpcao(gerente);
		switch (opcao) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "\nRelatorio gerado");
			logger.log(Level.INFO, "\n----------------------------------------\n");
			RelatorioIO.numeroContas();
			Thread.sleep(1000);
			MenuGerenteService.menuGerente(gerente);
			break;
		default:
			Thread.sleep(1000);
			MenuGerenteService.menuGerenteRelatorios(gerente);
			break;
		}
	}

	public static void contaTotal(Gerente gerente) throws IOException, InterruptedException {

		for (Agencia agencia : Agencia.getMapaAgencia().values()) {
			for (ContaCorrente contaCorrente : ContaCorrente.getMapaContaCorrente().values()) {
				for (ContaPoupanca contaPoupanca : ContaPoupanca.getMapaContaPoupanca().values()) {
					for (Cliente cliente : Cliente.getMapaCliente().values()) {
						if (cliente.getId() == contaCorrente.getFkCliente()
								&& cliente.getId() == contaPoupanca.getFkCliente()) {
							if (gerente.getFkAgencia() == agencia.getId()) {
								if (contaCorrente.getFkAgencia() == agencia.getId()
										&& contaPoupanca.getFkAgencia() == agencia.getId()) {

									Util.customizer();
									logger.log(Level.INFO,
											"\nNome: " + cliente.getNome() + "\nEmail: " + cliente.getEmail()
													+ "\nTelefone: " + cliente.getTelefone()
													+ "\nNumero da Conta Corrente: " + contaCorrente.getNumeroConta()
													+ "\nNumero da Conta Poupança: " + contaPoupanca.getNumeroConta());
								}
							}
						}
					}
				}
			}
		}
		Util.customizer();
		logger.log(Level.INFO,
				"\n----------------------------------------\n" + "[1]Gerar arquivo para impressão: \n" + "[2]Voltar");
		int opcao = lerOpcao(gerente);
		switch (opcao) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "\nRelatorio gerado");
			logger.log(Level.INFO, "\n----------------------------------------\n");
			RelatorioIO.listaCliente(gerente(), agencia());
			Thread.sleep(1000);
			MenuGerenteService.menuGerente(gerente);
			break;
		default:
			Thread.sleep(1000);
			MenuGerenteService.menuGerenteRelatorios(gerente);
			break;
		}
	}

	private static int lerOpcao(Gerente gerente) throws IOException, InterruptedException {
		while (true) {
			try {
				return sc.nextInt();
			} catch (InputMismatchException e) {
				logger.log(Level.INFO, "\nInsira um número válido!\n");
				sc.next();
				numeroContas(gerente);
			}

		}
	}

	public static List<Gerente> gerente() {
		List<Gerente> gerentes = new ArrayList<>();
		for (Gerente gerente : Gerente.getMapaGerente().values()) {
			gerentes.add(gerente);
		}
		return gerentes;
	}

	public static List<Agencia> agencia() {
		List<Agencia> agencias = new ArrayList<>();
		for (Agencia agencia : Agencia.getMapaAgencia().values()) {
			agencias.add(agencia);
		}
		return agencias;
	}
}
