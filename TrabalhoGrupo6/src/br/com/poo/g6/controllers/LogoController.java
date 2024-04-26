package br.com.poo.g6.controllers;

import br.com.poo.g6.services.LogoService;

public class LogoController {
	static LogoService LogoServ = new LogoService();

	public static void logo() {
		LogoServ.logo();
	}

}
