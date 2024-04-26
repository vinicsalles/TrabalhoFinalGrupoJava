package br.com.poo.g6.services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.entities.Gerente;

public class MenuGerenteService {
	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);
	static CadastroService cadastroService = new CadastroService();

	public static void menuGerente(Gerente gerente) throws IOException, InterruptedException {

		Util.customizer();
		logger.log(Level.INFO, """
				\n----------------------------------------\n
				[1]Relatórios
				[2]Cadastro
				[0]Sair
				Escolha uma opção:
				\n----------------------------------------
				""");
		int opcao = lerOpcao(gerente);
		switch (opcao) {

		case 1:
			menuGerenteRelatorios(gerente);
			break;
		case 2:
			cadastroService.cadastrarCliente();
			menuGerente(gerente);
			break;
		case 0:
			Util.customizer();
			logger.log(Level.INFO, "Até logo, " /* + NomePresidente | verificar com o fazer */);
			break;
		}
	}

	public static void menuGerenteRelatorios(Gerente gerente) throws IOException, InterruptedException {

		Util.customizer();
		logger.log(Level.INFO, """
				\n----------------------------------------\n
				[1]Total de contas dessa agência
				[2]Relatório das contas
				[0]Sair
				Escolha uma opção:
				\n----------------------------------------
				""");
		int opcao = lerOpcao(gerente);
		switch (opcao) {

		case 1:
			GerenteService.numeroContas(gerente);
			break;
		case 2:
			GerenteService.contaTotal(gerente);
			break;
		case 0:
			Util.customizer();
			logger.log(Level.INFO, "Até logo, " /* + NomePresidente | verificar com o fazer */);
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
				menuGerente(gerente);
			}

		}
	}
}
