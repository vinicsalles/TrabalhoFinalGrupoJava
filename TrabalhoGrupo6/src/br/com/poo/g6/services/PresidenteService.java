package br.com.poo.g6.services;

import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.entities.Agencia;
import br.com.poo.g6.entities.Cliente;
import br.com.poo.g6.entities.ContaCorrente;
import br.com.poo.g6.entities.ContaPoupanca;
import br.com.poo.g6.entities.Diretor;
import br.com.poo.g6.entities.Gerente;
import br.com.poo.g6.io.RelatorioIO;

public class PresidenteService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public static void listaDiretores() throws IOException, InterruptedException {
		for (Diretor diretor : Diretor.getMapaGerente().values()) {
			for (Agencia agencia : Agencia.getMapaAgencia().values()) {
				for (Gerente gerente : Gerente.getMapaGerente().values()) {
					if (agencia.getFkDiretor() == diretor.getId() && gerente.getFkAgencia().equals(agencia.getId())) {
						Util.customizer();
						logger.log(Level.INFO,
								"\n----------------------------------------\n" + "Nome diretor: " + diretor.getNome()
										+ "\nAgencia: " + agencia.getId() + " | " + agencia.getUf() + ", "
										+ agencia.getCidade() + "\nGerente: " + gerente.getNome());

					}
				}
			}
		}

		Util.customizer();
		logger.log(Level.INFO,
				"\n----------------------------------------\n" + "[1]Gerar arquivo para impressão: \n" + "[2]Voltar");
		int opcao = lerOpcao();
		switch (opcao) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "\nRelatorio gerado");
			logger.log(Level.INFO, "\n----------------------------------------\n");
			RelatorioIO.listaDiretores(diretor(), agencia(), gerente());
			Thread.sleep(250);
			MenuPresidenteService.menuPresidente();
			break;
		default:
			Thread.sleep(250);
			MenuPresidenteService.menuPresidenteRelatorios();
			break;
		}
	}

	public static void caixaTotal() throws IOException, InterruptedException {

		DecimalFormat df = new DecimalFormat("#,###.##");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ld = LocalDate.now();

		Double caixaTotal = 0.0;
		for (Agencia agencia : Agencia.getMapaAgencia().values()) {
			caixaTotal = caixaTotal + agencia.getCaixa();
		}
		Util.customizer();
		logger.log(Level.INFO,
				"\n----------------------------------------\n" + "Total em caixa: R$ " + df.format(caixaTotal)
						+ "\nData: " + dateFormat.format(ld) + "\n----------------------------------------\n");

		Util.customizer();
		logger.log(Level.INFO,
				"\n----------------------------------------\n" + "[1]Gerar arquivo para impressão: \n" + "[2]Voltar");
		int opcao = lerOpcao();
		switch (opcao) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "\nRelatorio gerado");
			logger.log(Level.INFO, "\n----------------------------------------\n");
			RelatorioIO.caixaTotla(agencia());
			Thread.sleep(250);
			MenuPresidenteService.menuPresidente();
			break;
		default:
			Thread.sleep(250);
			MenuPresidenteService.menuPresidenteRelatorios();
			break;
		}
	}

	private static int lerOpcao() throws IOException {
		while (true) {
			try {
				return sc.nextInt();
			} catch (InputMismatchException e) {
				logger.log(Level.INFO, "\nInsira um número válido!\n");
				sc.next();

			}

		}
	}

	public static void numeroContas() throws IOException, InterruptedException {
		Integer numContas = 0;
		for (Agencia agencia : Agencia.getMapaAgencia().values()) {
			for (Gerente gerente : Gerente.getMapaGerente().values()) {
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
		}
		Util.customizer();
		logger.log(Level.INFO, "\n----------------------------------------\n" + "Total de " + numContas + " Contas");

		Util.customizer();
		logger.log(Level.INFO,
				"\n----------------------------------------\n" + "[1]Gerar   arquivo para impressão: \n" + "[2]Voltar");
		int opcao = lerOpcao();
		switch (opcao) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "\nRelatorio gerado");
			logger.log(Level.INFO, "\n----------------------------------------\n");
			RelatorioIO.numeroContas();
			Thread.sleep(250);
			MenuPresidenteService.menuPresidenteRelatorios();
			break;
		default:
			Thread.sleep(250);
			MenuPresidenteService.menuPresidenteRelatorios();
			break;
		}
	}

	public static void contaTotal() throws IOException, InterruptedException {

		for (Agencia agencia : Agencia.getMapaAgencia().values()) {
			for (Gerente gerente : Gerente.getMapaGerente().values()) {
				for (ContaCorrente contaCorrente : ContaCorrente.getMapaContaCorrente().values()) {
					for (ContaPoupanca contaPoupanca : ContaPoupanca.getMapaContaPoupanca().values()) {
						for (Cliente cliente : Cliente.getMapaCliente().values()) {
							if (cliente.getId() == contaCorrente.getFkCliente()
									&& cliente.getId() == contaPoupanca.getFkCliente()) {
								if (gerente.getFkAgencia() == agencia.getId()) {
									if (contaCorrente.getFkAgencia() == agencia.getId()
											&& contaPoupanca.getFkAgencia() == agencia.getId()) {

										Util.customizer();
										logger.log(Level.INFO, "\nNome: " + cliente.getNome() + "\nEmail: "
												+ cliente.getEmail() + "\nTelefone: " + cliente.getTelefone()
												+ "\nNumero da Conta Corrente: " + contaCorrente.getNumeroConta()

												+ "\nNumero da Conta Poupança: " + contaPoupanca.getNumeroConta());
									}
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
		int opcao = lerOpcao();
		switch (opcao) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "\nRelatorio gerado");
			logger.log(Level.INFO, "\n----------------------------------------\n");
			RelatorioIO.listaCliente(gerente(), agencia());
			Thread.sleep(250);
			MenuPresidenteService.menuPresidenteRelatorios();
			break;
		default:
			Thread.sleep(250);
			MenuPresidenteService.menuPresidenteRelatorios();
			break;
		}
	}

	static String estado = null;

	public static void listaInfoClienteDiretor() throws IOException, InterruptedException {
		List<Cliente> listaClientes = new ArrayList<>();
		for (Agencia agencia : Agencia.getMapaAgencia().values()) {
			for (Diretor diretor : Diretor.getMapaDiretor().values()) {
				if (agencia.getFkDiretor() == diretor.getId()) {
					for (ContaCorrente contaCorrente : ContaCorrente.getMapaContaCorrente().values()) {
						if (contaCorrente.getFkAgencia() == agencia.getId()) {
							for (Cliente cliente : Cliente.getMapaCliente().values()) {
								if (cliente.getId() == contaCorrente.getFkCliente()) {
									estado = agencia.getUf();
									listaClientes.add(cliente);
								}
							}
						}

					}

				}
				for (ContaPoupanca contaPoupanca : ContaPoupanca.getMapaContaPoupanca().values()) {
					if (contaPoupanca.getFkAgencia() == agencia.getId()) {
						for (Cliente cliente : Cliente.getMapaCliente().values()) {
							if (cliente.getId() == contaPoupanca.getFkCliente() && !listaClientes.contains(cliente)) {
								estado = agencia.getUf();
								listaClientes.add(cliente);
							}
						}
					}
				}
			}
		}
		Collections.sort(listaClientes, Comparator.comparing(Cliente::getNome));
		for (Cliente cliente : listaClientes) {
			Util.customizer();
			logger.log(Level.INFO, () -> "\nnome cliente: " + cliente.getNome() + "\nCPF cliente: " + cliente.getCpf()
					+ "\nAgencia: " + estado);
		}

		Util.customizer();
		logger.log(Level.INFO,
				"\n----------------------------------------\n" + "[1]Gerar arquivo para impressão: \n" + "[2]Voltar");
		int opcao = lerOpcao();
		switch (opcao) {
		case 1:
			Util.customizer();
			logger.log(Level.INFO, "\nRelatorio gerado");
			logger.log(Level.INFO, "\n----------------------------------------\n");
			RelatorioIO.relatorioInfoClienteDiretorP(diretor());
			Thread.sleep(250);
			MenuPresidenteService.menuPresidenteRelatorios();
			break;
		default:
			Thread.sleep(250);
			MenuPresidenteService.menuPresidenteRelatorios();
			break;
		}

	}

	public static List<Diretor> diretor() {
		List<Diretor> diretores = new ArrayList<>();
		for (Diretor diretor : Diretor.getMapaDiretor().values()) {
			diretores.add(diretor);
		}
		return diretores;
	}

	public static List<Agencia> agencia() {
		List<Agencia> agencias = new ArrayList<>();
		for (Agencia agencia : Agencia.getMapaAgencia().values()) {
			agencias.add(agencia);
		}
		return agencias;
	}

	public static List<Gerente> gerente() {
		List<Gerente> gerentes = new ArrayList<>();
		for (Gerente gerente : Gerente.getMapaGerente().values()) {
			gerentes.add(gerente);
		}
		return gerentes;
	}

}
