package br.com.poo.g6.services;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public static String solicitarCpf() {
		Util.customizer();
		logger.log(Level.INFO, "\n-------------------------------------------------------------------------\nCPF: ");
//		sc.nextLine();
		return sc.nextLine();
	}

	public static String solicitarSenha() {
		Util.customizer();
		logger.log(Level.INFO, "\n-------------------------------------------------------------------------\nSenha: ");
//		sc.nextLine();
		return sc.nextLine();
	}

	public static void fecharScanner() {
		sc.close();
	}

}
