package br.com.poo.g6.controllers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.entities.Cliente;
import br.com.poo.g6.entities.Diretor;
import br.com.poo.g6.entities.Gerente;
import br.com.poo.g6.entities.Presidente;
import br.com.poo.g6.services.AutenticacaoService;
import br.com.poo.g6.services.MenuClienteService;
import br.com.poo.g6.services.MenuDiretorService;
import br.com.poo.g6.services.MenuGerenteService;
import br.com.poo.g6.services.MenuPresidenteService;
import br.com.poo.g6.services.Util;

public class AutenticacaoController {
	AutenticacaoService autenticacaoService = new AutenticacaoService();
	private static Logger logger = Util.setupLogger();

	public Cliente login() throws IOException, InterruptedException {
		Object usuario;
		do {
			usuario = autenticacaoService.credenciais();
			if (usuario instanceof Cliente) {
				Cliente cliente = (Cliente) usuario;
				Thread.sleep(500);
				Util.customizer();
				logger.log(Level.INFO, "\n\nLogin realizado com Sucesso!!\n\n");
				Thread.sleep(500);
				MenuClienteService.menu(cliente);
				return cliente;
			} else if (usuario instanceof Presidente) {
				Presidente presidente = (Presidente) usuario;
				Thread.sleep(500);
				Util.customizer();
				logger.log(Level.INFO, "\nBem vindo, " + presidente.getNome() + "\n");
				Thread.sleep(500);
				MenuPresidenteService.menuPresidente();
			} else if (usuario instanceof Diretor) {
				Diretor diretor = (Diretor) usuario;
				Thread.sleep(500);
				Util.customizer();
				logger.log(Level.INFO, "\nBem vindo, " + diretor.getNome() + "\n");
				Thread.sleep(500);
				MenuDiretorService.menuDiretor(diretor);
			} else if (usuario instanceof Gerente) {
				Gerente gerente = (Gerente) usuario;
				Thread.sleep(500);
				Util.customizer();
				logger.log(Level.INFO, "\nBem vindo, " + gerente.getNome() + "\n");
				Thread.sleep(500);
				MenuGerenteService.menuGerente(gerente);
			}

			else {
				Thread.sleep(1000);
				Util.customizer();
				logger.log(Level.INFO, "\n\nFalha na autenticação!!\n\n");
				Thread.sleep(1000);
			}
		} while (usuario == null);
		return null;
	}
}
