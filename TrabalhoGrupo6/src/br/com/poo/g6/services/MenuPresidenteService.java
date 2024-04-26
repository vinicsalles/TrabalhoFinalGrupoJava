package br.com.poo.g6.services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MenuPresidenteService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);
	static CadastroService cadastroService = new CadastroService();

	public static void menuPresidente() throws IOException, InterruptedException {

		Util.customizer();
		logger.log(Level.INFO, """
				\n----------------------------------------\n
				[1]Relatórios
				[2]Cadastro
				[0]Sair
				Escolha uma opção:
				\n----------------------------------------
				""");
		int opcao = lerOpcao();
		switch (opcao) {

		case 1:
			Thread.sleep(250);
			menuPresidenteRelatorios();
			break;
		case 2:
			Thread.sleep(250);
			menuPresidenteCadastro();
			break;
		case 0:
			Thread.sleep(250);
			Util.customizer();
			logger.log(Level.INFO, "Até logo!");
			break;
		}
	}

	public static void menuPresidenteRelatorios() throws IOException, InterruptedException {

		Util.customizer();
		logger.log(Level.INFO, """
				\n----------------------------------------\n
				[1]Presidente - Lista de diretores
				[2]Presidente - Capital em caixa
				[3]Gerencia - Numero de contas
				[4]Gerencia - Contas por agencia
				[5]Diretor - Informações clientes
				[9]Voltar
				[0]Sair
				Escolha uma opção:
				\n----------------------------------------
				""");
		int opcao = lerOpcao();
		switch (opcao) {

		case 1:
			Thread.sleep(250);
			PresidenteService.listaDiretores();
			break;
		case 2:
			Thread.sleep(250);
			PresidenteService.caixaTotal();
			break;
		case 3:
			Thread.sleep(250);
			PresidenteService.numeroContas();
			break;
		case 4:
			Thread.sleep(250);
			PresidenteService.contaTotal();
			break;
		case 5:
			Thread.sleep(250);
			PresidenteService.listaInfoClienteDiretor();
			break;
		case 9:
			Thread.sleep(250);
			menuPresidente();
			break;
		case 0:
			Thread.sleep(250);
			Util.customizer();
			logger.log(Level.INFO, "Até logo!");
			break;
		}
	}

	public static void menuPresidenteCadastro() throws IOException, InterruptedException {

		Util.customizer();
		logger.log(Level.INFO, """
				\n----------------------------------------\n
				[1]Cliente
				[2]Gerente
				[3]Diretor
				[4]Voltar
				[0]Sair
				Escolha uma opção:
				\n----------------------------------------
				""");
		int opcao = lerOpcao();
		switch (opcao) {

		case 1:
			Thread.sleep(250);
			cadastroService.cadastrarCliente();
			menuPresidenteCadastro();
			break;
		case 2:
			Thread.sleep(250);
			cadastroService.cadastrarGerente();
			menuPresidenteCadastro();
			break;
		case 3:
			Thread.sleep(250);
			cadastroService.cadastrarDiretor();
			menuPresidenteCadastro();
			break;
		case 4:
			Thread.sleep(250);
			menuPresidente();
			break;
		case 0:
			Thread.sleep(250);
			Util.customizer();
			logger.log(Level.INFO, "Até logo!");
			break;
		}
	}

	private static int lerOpcao() throws IOException, InterruptedException {
		while (true) {
			try {
				return sc.nextInt();
			} catch (InputMismatchException e) {
				logger.log(Level.INFO, "\nInsira um número válido!\n");
				sc.next();
				menuPresidente();
			}

		}
	}

}
