package br.com.poo.g6.services;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.entities.Cliente;
import br.com.poo.g6.entities.ContaCorrente;
import br.com.poo.g6.entities.ContaPoupanca;
import br.com.poo.g6.entities.Diretor;
import br.com.poo.g6.entities.Gerente;
import br.com.poo.g6.enums.TipoPessoa;
import br.com.poo.g6.io.RelatorioIO;

public class CadastroService {

	static Logger logger = Util.setupLogger();
	static Scanner sc = new Scanner(System.in);

	public void cadastrarCliente() {

		Util.customizer();
		logger.log(Level.INFO, "\nInforme o id para o novo cliente: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nNome completo: ");
		String nome = sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nDigite apenas os numeros do cpf\n");
		Util.customizer();
		logger.log(Level.INFO, "\nCpf: ");
		String cpf = sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nDigite apenas os numeros do telefone\n");
		Util.customizer();
		logger.log(Level.INFO, "\nTelefone: ");
		String telefone = sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nEmail: ");
		String email = sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nSenha: ");
		String senha = sc.nextLine();

		Cliente cliente = new Cliente(id, nome, cpf, telefone, email, senha, TipoPessoa.CLIENTE);

		Util.customizer();
		logger.log(Level.INFO, "\nCadastro realizado com sucesso\n");
		RelatorioIO.cadastrarCliente(cliente);

		try {
			Util.customizer();
			logger.log(Level.INFO, """
					\n[1]Conta Corrente;
					[2]Conta Poupança;
					\n""");
			int opcao = sc.nextInt();
			switch (opcao) {
			case 1:
				cadastrarContaCorrente();
				break;
			case 2:
				cadastrarContaPoupanca();
				break;
			default:
				cadastrarCliente();
				break;
			}
		} catch (InputMismatchException e) {
			Util.customizer();
			logger.log(Level.INFO, "\nInsira um número válido!\n");
			sc.next();
		}
	}

	public void cadastrarContaCorrente() {

		Util.customizer();
		logger.log(Level.INFO, "\nId da conta: ");
		Integer conta = sc.nextInt();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nNumero da conta: ");
		Double numeroConta = sc.nextDouble();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nSaldo minimo para abertura de conta é de R$ 50,0\n");
		Util.customizer();
		logger.log(Level.INFO, "Saldo: ");
		Double saldo = sc.nextDouble();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nId cliente: ");
		Integer fkCliente = sc.nextInt();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nId agencia: ");
		Integer fkAgencia = sc.nextInt();
		sc.nextLine();
		Double saldoMinimo = 50.0;
		Double taxaManutencao = 10.0;

		ContaCorrente contaCorrente = new ContaCorrente(conta, numeroConta, saldo, fkCliente, fkAgencia, saldoMinimo,
				taxaManutencao);

		Util.customizer();
		logger.log(Level.INFO, "\nConta corrente cadastrada com sucesso\n");
		RelatorioIO.cadastrarContaCorrente(contaCorrente);
	}

	public void cadastrarContaPoupanca() {

		Util.customizer();
		logger.log(Level.INFO, "\nId da conta: ");
		Integer conta = sc.nextInt();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nNumero da conta: ");
		Double numeroConta = sc.nextDouble();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "Saldo: ");
		Double saldo = sc.nextDouble();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nId cliente: ");
		Integer fkCliente = sc.nextInt();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nId agencia: ");
		Integer fkAgencia = sc.nextInt();
		sc.nextLine();
		Double rendimento = 0.05;

		ContaPoupanca contaPoupanca = new ContaPoupanca(conta, numeroConta, saldo, fkCliente, fkAgencia, rendimento);

		Util.customizer();
		logger.log(Level.INFO, "\nConta poupança cadastrada com sucesso\n");
		RelatorioIO.cadastrarContaPoupanca(contaPoupanca);

	}

	public void cadastrarGerente() {

		Util.customizer();
		logger.log(Level.INFO, "\nId: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nId da agencia: ");
		Integer fkAgencia = sc.nextInt();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nDigite apenas os numeros do telefone\n");
		Util.customizer();
		logger.log(Level.INFO, "\nTelefone: ");
		String telefone = sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nSalario: ");
		Double salario = sc.nextDouble();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nNome completo: ");
		String nome = sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nDigite apenas os numeros do cpf\n");
		Util.customizer();
		logger.log(Level.INFO, "\nCpf: ");
		String cpf = sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nEmail: ");
		String email = sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nSenha: ");
		String senha = sc.nextLine();

		boolean bonificacao = false;

		Gerente gerente = new Gerente(id, fkAgencia, telefone, salario, nome, cpf, email, senha, TipoPessoa.GERENTE,
				bonificacao);

		Util.customizer();
		logger.log(Level.INFO, "\nCadastro realizado com sucesso\n");
		RelatorioIO.cadastrarGerente(gerente);
	}

	public void cadastrarDiretor() {

		Util.customizer();
		logger.log(Level.INFO, "\nId: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nDigite apenas os numeros do telefone\n");
		Util.customizer();
		logger.log(Level.INFO, "\nTelefone: ");
		String telefone = sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nSalario: ");
		Double salario = sc.nextDouble();
		sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nNome completo: ");
		String nome = sc.nextLine();
		Util.customizer();
		Util.customizer();
		logger.log(Level.INFO, "\nDigite apenas os numeros do cpf\n");
		Util.customizer();
		logger.log(Level.INFO, "\nCpf: ");
		String cpf = sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nEmail: ");
		String email = sc.nextLine();
		Util.customizer();
		logger.log(Level.INFO, "\nSenha: ");
		String senha = sc.nextLine();

		boolean bonificacao = false;

		Diretor diretor = new Diretor(id, telefone, salario, nome, cpf, email, senha, TipoPessoa.DIRETOR, bonificacao);

		Util.customizer();
		logger.log(Level.INFO, "\nCadastro realizado com sucesso\n");
		RelatorioIO.cadastrarDiretor(diretor);

	}

}
