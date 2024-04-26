package br.com.poo.g6.services;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.entities.Cliente;
import br.com.poo.g6.entities.Diretor;
import br.com.poo.g6.entities.Gerente;
import br.com.poo.g6.entities.Presidente;

public class AutenticacaoService {

	private static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public Object credenciais() throws InterruptedException {
//		return login(cpf, senha);
		Util.customizer();
		logger.log(Level.INFO, "\n\nDigite seu CPF: ");
		String cpf = sc.nextLine();
		Thread.sleep(250);
		logger.log(Level.INFO, "\n\nDigite sua senha: ");
		String senha = sc.nextLine();
		Thread.sleep(250);

		Cliente cliente = login(cpf, senha);
		if (cliente != null) {
			return cliente;
		} else {
			Presidente presidente = loginfp(cpf, senha);
			if (presidente != null) {
				return presidente;
			} else {
				Diretor diretor = loginfd(cpf, senha);
				if (diretor != null) {
					return diretor;
				} else {
					Gerente gerente = loginfg(cpf, senha);
					if (gerente != null) {
						return gerente;
					} else {
						Util.customizer();
						logger.log(Level.INFO, "Erro na autenticação");
						return null;
					}
				}
			}
		}
	}

	public Cliente login(String cpf, String senha) {
		for (Cliente cliente : Cliente.getMapaCliente().values()) {
			if (cpf.equals(cliente.getCpf()) && senha.equals(cliente.getSenha())) {
				return cliente;
			}
		}
		return null;
	}

	public Presidente loginfp(String cpf, String senha) {
		for (Presidente presidente : Presidente.getMapaPresidente().values()) {
			if (cpf.equals(presidente.getCpf()) && senha.equals(presidente.getSenha())) {
				return presidente;
			}
		}
		return null;
	}

	public Diretor loginfd(String cpf, String senha) {
		for (Diretor diretor : Diretor.getMapaDiretor().values()) {
			if (cpf.equals(diretor.getCpf()) && senha.equals(diretor.getSenha())) {
				return diretor;
			}
		}
		return null;
	}

	public Gerente loginfg(String cpf, String senha) {
		for (Gerente gerente : Gerente.getMapaGerente().values()) {
			if (cpf.equals(gerente.getCpf()) && senha.equals(gerente.getSenha())) {
				return gerente;
			}
		}
		return null;
	}
}
