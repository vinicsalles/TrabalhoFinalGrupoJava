package br.com.poo.g6.services;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.entities.Cliente;

public class MenuClienteService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public static void menu(Cliente cliente) throws IOException, InterruptedException {
		Util.customizer();
		logger.log(Level.INFO, """
				Seja Bem Vindo ao Banco SixBank
				\n\nDigite uma opção:\n
				[1]\tMovimentações da Conta
				[2]\tRelatórios
				[0]\tSair
				""");
		try {

			int opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				Thread.sleep(1000);
				SubMenuClienteService.movimentacoesDaConta(cliente);
				break;
			case 2:
				SubMenuClienteService.relatorios(cliente);
				break;
			case 0:
				Util.customizer();
				logger.log(Level.INFO, "Voltando para o Login!");
				break;
			default:
				Util.customizer();
				logger.log(Level.INFO, "Opção inválida!");
				menu(cliente);
				break;
			}

		} catch (InputMismatchException e) {
			Util.customizer();
			logger.log(Level.INFO,
					"Opção inválida!! \n\n\n Digite entre as opções: [1]Movimentações da Conta\n [2]Relatórios\n [0]Sair");
			sc.nextLine();
			Thread.sleep(1000);
			menu(cliente);
		}
	}
}
