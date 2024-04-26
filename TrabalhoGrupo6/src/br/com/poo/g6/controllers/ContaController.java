package br.com.poo.g6.controllers;

import java.io.IOException;
import java.util.Scanner;

import br.com.poo.g6.entities.Cliente;
import br.com.poo.g6.services.ContaService;

public class ContaController {
	ContaService contaservice = new ContaService();
	Scanner sc = new Scanner(System.in);

	public void sacarContaCorrente(Cliente cliente) {
		contaservice.sacarContaCorrente(cliente);
	}

	public void sacarContaPoupanca(Cliente cliente) {
		contaservice.sacarContaPoupanca(cliente);
	}

	public void depositarContaCorrente(Cliente cliente) {
		contaservice.depositarContaCorrente(cliente);
	}

	public void depositarContaPoupanca(Cliente cliente) {
		contaservice.depositarContaPoupanca(cliente);
	}

	public void transferir(Cliente cliente) throws IOException, InterruptedException {
		contaservice.transferirCorrenteCorrente(cliente);
	}

//Adicionando tributo e rendimento das contas no relatórios
	public void tributoContaCorrente(Cliente cliente) throws IOException, InterruptedException {
		contaservice.relatorioTributoConta(cliente);
	}

	public void rendimentoContaPoupanca(Cliente cliente) throws IOException, InterruptedException {
		contaservice.relatorioRendimentoConta(cliente);
	}

}
