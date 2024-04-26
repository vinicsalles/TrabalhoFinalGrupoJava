package br.com.poo.g6;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.controllers.AutenticacaoController;
import br.com.poo.g6.controllers.LogoController;
import br.com.poo.g6.io.RelatorioIO;
import br.com.poo.g6.services.Util;

public class G6Application {
	private static Logger logger = Util.setupLogger();

	public static void main(String[] args) throws IOException, InterruptedException {
		AutenticacaoController autenticacaoController = new AutenticacaoController();

		try {
			RelatorioIO.leitor("banco");
			LogoController.logo();
			autenticacaoController.login();
		} catch (IOException e) {
			Util.customizer();
			logger.log(Level.INFO, "O Sistema não pode encontrar o arquivo específico!");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
