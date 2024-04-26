package br.com.poo.g6.services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.controllers.ContaController;
import br.com.poo.g6.entities.Cliente;

public class SubMenuClienteService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);
	static ContaController contaController = new ContaController();

	public static void movimentacoesDaConta(Cliente cliente) throws IOException, InterruptedException {
		Util.customizer();
		logger.log(Level.INFO, () -> "\n[1]Saque" + "\n[2]Depósito" + "\n[3]Transferência" + "\n[0]Voltar");
		Thread.sleep(1000);
		int opcao = lerOpcao(cliente);
		Thread.sleep(1000);

		try {
			switch (opcao) {
			case 1:
				SubMenuClienteService.tiposSaques(cliente);
				// candidatocontroller.listarCandidatos();
				SubMenuClienteService.movimentacoesDaConta(cliente);
				break;

			case 2:
				SubMenuClienteService.tiposDepositos(cliente);
				;
				// candidatocontroller.listarCandidatos();
				SubMenuClienteService.movimentacoesDaConta(cliente);
				break;

			case 3:
				contaController.transferir(cliente);
				// candidatocontroller.listarCandidatos();
				SubMenuClienteService.movimentacoesDaConta(cliente);
				break;

			case 0:
				MenuClienteService.menu(cliente);
				break;

			default:
				Util.customizer();
				logger.log(Level.INFO, "Opção invalida!");
				SubMenuClienteService.movimentacoesDaConta(cliente);
				break;
			}
		} catch (InputMismatchException e) {
			Util.customizer();
			logger.log(Level.INFO,
					"Opção inválida!! \n\n\n Digite entre as opções: [1]Saque \n [2]Depósito\n  [3]Transferência [0]Sair");
			sc.nextLine();
			Thread.sleep(1000);
			movimentacoesDaConta(cliente);
		}
	}

	public static void relatorios(Cliente cliente) throws IOException, InterruptedException {
		Util.customizer();
		logger.log(Level.INFO,
				() -> "\n[1]Relatórios Tributação Corrente" + "\n[2]Relatórios Rendimento Poupança" + "\n[0]Voltar");
		Thread.sleep(1000);
		int opcao = lerOpcao(cliente);
		Thread.sleep(1000);

		try {
			switch (opcao) {
			case 1:
				contaController.tributoContaCorrente(cliente);
				SubMenuClienteService.relatorios(cliente);
				break;

			case 2:
				contaController.rendimentoContaPoupanca(cliente);
				SubMenuClienteService.relatorios(cliente);
				break;
			case 0:
				SubMenuClienteService.movimentacoesDaConta(cliente);
				break;

			default:
				Util.customizer();
				logger.log(Level.INFO, "Opção invalida!");
				SubMenuClienteService.relatorios(cliente);
				break;
			}
		} catch (InputMismatchException e) {
			Util.customizer();
			logger.log(Level.INFO,
					"Opção inválida!! n[1]Relatórios Tributação Corrente \n[2]Relatórios Rendimento Poupança  \n[0]Voltar");
			sc.nextLine();
			Thread.sleep(1000);
			SubMenuClienteService.relatorios(cliente);
		}
	}

	public static void tiposSaques(Cliente cliente) throws IOException, InterruptedException {
		ContaController contacontroller = new ContaController();
		Util.customizer();
		logger.log(Level.INFO, () -> "\n[1]Saque Conta Corrente" + "\n[2]Saque Conta Poupança" + "\n[0]Voltar");
		Thread.sleep(1000);
		int opcao = sc.nextInt();
		Thread.sleep(1000);

		try {
			switch (opcao) {
			case 1:
				contacontroller.sacarContaCorrente(cliente);
				// candidatocontroller.listarCandidatos();
				SubMenuClienteService.tiposSaques(cliente);
				break;

			case 2:
				contacontroller.sacarContaPoupanca(cliente);
				// candidatocontroller.listarCandidatos();
				SubMenuClienteService.tiposSaques(cliente);
				break;
			case 0:
				SubMenuClienteService.movimentacoesDaConta(cliente);
				break;

			default:
				Util.customizer();
				logger.log(Level.INFO, "Opção invalida!");
				SubMenuClienteService.tiposSaques(cliente);
				break;
			}
		} catch (InputMismatchException e) {
			Util.customizer();
			logger.log(Level.INFO,
					"Opção inválida!! \n\n\n Digite entre as opções: [1]Saque Conta Corrente \n [2]Saque Conta Poupança\n  [0]Voltar");
			sc.nextLine();
			Thread.sleep(1000);
			tiposSaques(cliente);
		}
	}

	public static void tiposDepositos(Cliente cliente) throws IOException, InterruptedException {
		ContaController contacontroller = new ContaController();
		Util.customizer();
		logger.log(Level.INFO, () -> "\n[1]Depósito Conta Corrente" + "\n[2]Depósito Conta Poupança" + "\n[0]Voltar");
		Thread.sleep(1000);
		int opcao = sc.nextInt();
		Thread.sleep(1000);

		try {
			switch (opcao) {
			case 1:
				contacontroller.depositarContaCorrente(cliente);
				// candidatocontroller.listarCandidatos();
				SubMenuClienteService.tiposDepositos(cliente);
				break;

			case 2:
				contacontroller.depositarContaPoupanca(cliente);
				// candidatocontroller.listarCandidatos();
				SubMenuClienteService.tiposDepositos(cliente);
				break;
			case 0:
				SubMenuClienteService.movimentacoesDaConta(cliente);
				break;

			default:
				Util.customizer();
				logger.log(Level.INFO, "Opção invalida!");
				SubMenuClienteService.tiposDepositos(cliente);
				break;
			}
		} catch (InputMismatchException e) {
			Util.customizer();
			logger.log(Level.INFO,
					"Opção inválida!! \n\n\n Digite entre as opções: [1]Depósito Conta Corrente \n [2]Depósito Conta Poupança\n  [0]Voltar");
			sc.nextLine();
			Thread.sleep(1000);
			tiposDepositos(cliente);
		}
	}

	private static int lerOpcao(Cliente cliente) throws IOException, InterruptedException {
		while (true) {
			try {
				return sc.nextInt();
			} catch (InputMismatchException e) {
				logger.log(Level.INFO, "\nInsira um número válido!\n");
				sc.next();
				SubMenuClienteService.movimentacoesDaConta(cliente);
			}

		}
	}

}
