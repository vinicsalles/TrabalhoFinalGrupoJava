package br.com.poo.g6.services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.entities.Diretor;
import br.com.poo.g6.io.RelatorioIO;

public class MenuDiretorService {
	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public static void menuDiretor(Diretor diretor) throws IOException, InterruptedException {
		Util.customizer();
		logger.log(Level.INFO, """
				\n----------------------------------------\n
				[1]Relatórios
				[2]Cadastro
				[0]Sair
				Escolha uma opção:
				\n----------------------------------------
				""");
		int opcao = lerOpcao(diretor);
		switch (opcao) {

		case 1:
			menuDiretorRelatorios(diretor);
			break;
		case 2:
			menuDiretorCadastro(diretor);
			break;
		case 0:
			Util.customizer();
			logger.log(Level.INFO, "Até logo, " /* + NomeDiretor| verificar com o fazer */);
			break;
		}
	}

	public static void menuDiretorRelatorios(Diretor diretor) throws IOException, InterruptedException {
		Util.customizer();
		logger.log(Level.INFO, """
				\n----------------------------------------\n
				[1]Lista Informações dos Clientes
				[2]Imprimir Informações dos Clientes
				[3]Voltar
				[0]Sair
				Escolha uma opção:
				\n----------------------------------------
				""");
		int opcao = lerOpcao(diretor);
		switch (opcao) {

		case 1:
			DiretorService.listaInfoClienteDiretor(diretor);
			menuDiretorRelatorios(diretor);
			break;
		case 2:
			RelatorioIO.relatorioInfoClienteDiretor(diretor);
			menuDiretorRelatorios(diretor);
			break;
		case 3:
			menuDiretor(diretor);
			break;
		case 0:
			Util.customizer();
			logger.log(Level.INFO, "Até logo, " /* + NomeDiretor | verificar com o fazer */);
			break;
		}
	}

	private static int lerOpcao(Diretor diretor) throws IOException, InterruptedException {

		while (true) {
			try {
				return sc.nextInt();
			} catch (InputMismatchException e) {
				logger.log(Level.INFO, "\nInsira um número válido!\n");
				sc.next();
				menuDiretor(diretor);
			}

		}
	}

	public static void menuDiretorCadastro(Diretor diretor) throws IOException, InterruptedException {
		CadastroService cadastroService = new CadastroService();

		Util.customizer();
		logger.log(Level.INFO, """
				\n----------------------------------------\n
				[1]Cliente
				[2]Gerente
				[3]Voltar
				[0]Sair
				Escolha uma opção:
				\n----------------------------------------
				""");
		int opcao = lerOpcao(diretor);
		switch (opcao) {

		case 1:
			Thread.sleep(250);
			cadastroService.cadastrarCliente();
			menuDiretorCadastro(diretor);
			break;
		case 2:
			Thread.sleep(250);
			cadastroService.cadastrarGerente();
			menuDiretorCadastro(diretor);
			break;
		case 3:
			Thread.sleep(250);
			menuDiretor(diretor);
			break;
		case 0:
			Thread.sleep(250);
			Util.customizer();
			logger.log(Level.INFO, "Até logo!");
			break;
		}
	}

}
