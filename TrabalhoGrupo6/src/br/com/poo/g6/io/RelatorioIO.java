package br.com.poo.g6.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.entities.Agencia;
import br.com.poo.g6.entities.Cliente;
import br.com.poo.g6.entities.ContaCorrente;
import br.com.poo.g6.entities.ContaPoupanca;
import br.com.poo.g6.entities.Diretor;
import br.com.poo.g6.entities.Gerente;
import br.com.poo.g6.entities.Presidente;
import br.com.poo.g6.enums.TipoAgencia;
import br.com.poo.g6.enums.TipoConta;
import br.com.poo.g6.enums.TipoPessoa;
import br.com.poo.g6.services.Util;

public class RelatorioIO {

	static final String PATH_BASICO = "./temp/";
	static final String EXTENSAO = ".txt";
	private static Logger logger = Util.setupLogger();

	static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(PATH_BASICO + path + EXTENSAO));
		String linha = "";
		while (true) {
			linha = buffRead.readLine();
			if (linha != null) {
				String[] dados = linha.split(";");

				if (dados[0].equalsIgnoreCase(TipoPessoa.CLIENTE.name())) {
					Cliente cliente = new Cliente(Integer.parseInt(dados[1]), dados[2], dados[3], dados[4], dados[5],
							dados[6], TipoPessoa.CLIENTE);
					Cliente.mapaCliente.put(Integer.parseInt(dados[1]), cliente);
//					Util.customizer();
//					logger.log(Level.INFO, cliente::toString);

				} else if (dados[0].equalsIgnoreCase(TipoPessoa.PRESIDENTE.name())) {
					Presidente presidente = new Presidente(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]),
							dados[3], Double.parseDouble(dados[4]), dados[5], dados[6], dados[7], dados[8],
							TipoPessoa.PRESIDENTE, Boolean.parseBoolean(dados[9]));
					Presidente.getMapaPresidente().put(Integer.parseInt(dados[1]), presidente);
//					Util.customizer();
//					logger.log(Level.INFO, presidente::toString);

				} else if (dados[0].equalsIgnoreCase(TipoPessoa.DIRETOR.name())) {
					Diretor diretor = new Diretor(Integer.parseInt(dados[1]), dados[2], Double.parseDouble(dados[3]),
							dados[4], dados[5], dados[6], dados[7], TipoPessoa.DIRETOR, Boolean.parseBoolean(dados[8]));
					Diretor.getMapaDiretor().put(Integer.parseInt(dados[1]), diretor);
//					Util.customizer();
//					logger.log(Level.INFO, diretor::toString);

				} else if (dados[0].equalsIgnoreCase(TipoConta.CONTAPOUPANCA.name())) {
					ContaPoupanca poupanca = new ContaPoupanca(Integer.parseInt(dados[1]), Double.parseDouble(dados[2]),
							Double.parseDouble(dados[3]), Integer.parseInt(dados[4]), Integer.parseInt(dados[5]),
							Double.parseDouble(dados[6]));
					ContaPoupanca.getMapaContaPoupanca().put(Integer.parseInt(dados[1]), poupanca);
//					Util.customizer();
//					logger.log(Level.INFO, poupanca::toString);

				} else if (dados[0].equalsIgnoreCase(TipoPessoa.GERENTE.name())) {
					Gerente ger = new Gerente(Integer.parseInt(dados[1]), Integer.parseInt(dados[2]), dados[3],
							Double.parseDouble(dados[4]), dados[5], dados[6], dados[7], dados[8], TipoPessoa.GERENTE,
							Boolean.parseBoolean(dados[9]));
					Gerente.getMapaGerente().put(Integer.parseInt(dados[1]), ger);
//					Util.customizer();
//					logger.log(Level.INFO, ger::toString);

				} else if (dados[0].equalsIgnoreCase(TipoAgencia.AGENCIA.name())) {
					Agencia agencia = new Agencia(Integer.parseInt(dados[1]), dados[2], (dados[3]), dados[4],
							Double.parseDouble(dados[5]), Integer.parseInt(dados[6]));
					Agencia.getMapaAgencia().put(Integer.parseInt(dados[1]), agencia);
//					Util.customizer();
//					logger.log(Level.INFO, agencia::toString);

				} else if (dados[0].equalsIgnoreCase(TipoConta.CONTACORRENTE.name())) {
					ContaCorrente corrente = new ContaCorrente(Integer.parseInt(dados[1]), Double.parseDouble(dados[2]),
							Double.parseDouble(dados[3]), Integer.parseInt(dados[4]), Integer.parseInt(dados[5]),
							Double.parseDouble(dados[6]), Double.parseDouble(dados[7]));
					ContaCorrente.getMapaContaCorrente().put(Integer.parseInt(dados[1]), corrente);
//					Util.customizer();
//					logger.log(Level.INFO, corrente::toString);
				}
			} else {

				break;
			}
		}
		buffRead.close();
	}

	public static void escritor(String path) throws IOException {
		Scanner sc = new Scanner(System.in);
		Util.customizer();
		logger.log(Level.INFO, () -> "Escreva o nome do arquivo: ");
		String nome = sc.nextLine();

		BufferedWriter buffWrite = new BufferedWriter(new FileWriter(PATH_BASICO + nome + path));
		String linha = "";

		Util.customizer();
		logger.log(Level.INFO, () -> "Escreva algo: ");
		linha = sc.nextLine();
		buffWrite.append(linha + "\n");
		buffWrite.close();
		sc.close();
	}

	public static void listaDiretores(List<Diretor> diretores, List<Agencia> agencias, List<Gerente> gerentes)
			throws IOException {
		String nome = "Lista de diretores";
		BufferedWriter buffW = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		buffW.append("\n----------------------------------------\n");
		buffW.append("Lista de diretores\n");
		if (!diretores.isEmpty() && !agencias.isEmpty() && !gerentes.isEmpty()) {
			for (Diretor diretor : diretores) {
				for (Agencia agencia : agencias) {
					for (Gerente gerente : gerentes) {
						if (agencia.getFkDiretor() == diretor.getId()
								&& gerente.getFkAgencia().equals(agencia.getId())) {
							buffW.append("\nNome diretor: " + diretor.getNome() + "\nAgencia: " + diretor.getFkAgencia()
									+ " | " + agencia.getCidade() + ", " + agencia.getUf() + "\nGerente: "
									+ gerente.getNome() + "\n----------------------------------------\n");
						}
					}
				}
			}
			DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			LocalDate ld = LocalDate.now();
			buffW.append("Data: " + dateFormat.format(ld));
			buffW.append("\n----------------------------------------\n");
		}

		buffW.close();
	}

	public static void listaCliente(List<Gerente> gerentes, List<Agencia> agencias) throws IOException {
		String nome = "Lista de clientes";
		BufferedWriter buffW = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		buffW.append("\n----------------------------------------\n");
		buffW.append("Lista de clientes\n");
		for (Gerente gerente : Gerente.getMapaGerente().values()) {
			for (Agencia agencia : Agencia.getMapaAgencia().values()) {
				for (ContaCorrente contaCorrente : ContaCorrente.getMapaContaCorrente().values()) {
					for (ContaPoupanca contaPoupanca : ContaPoupanca.getMapaContaPoupanca().values()) {
						for (Cliente cliente : Cliente.getMapaCliente().values()) {
							if (cliente.getId() == contaCorrente.getFkCliente()
									&& cliente.getId() == contaPoupanca.getFkCliente()) {
								if (gerente.getFkAgencia() == agencia.getId()) {
									if (contaCorrente.getFkAgencia() == agencia.getId()
											&& contaPoupanca.getFkAgencia() == agencia.getId()) {

										buffW.append("\nNome: " + cliente.getNome() + "\nEmail: " + cliente.getEmail()
												+ "\nTelefone: " + cliente.getTelefone()
												+ "\nNumero da Conta Corrente: " + contaCorrente.getNumeroConta()
												+ "\nNumero da Conta Poupança: " + contaPoupanca.getNumeroConta());
									}
								}
							}
						}
					}
				}
			}
		}

		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ld = LocalDate.now();
		buffW.append("Data: " + dateFormat.format(ld));
		buffW.append("\n----------------------------------------\n");
		buffW.close();
	}

	public static void caixaTotla(List<Agencia> agencias) throws IOException {
		DecimalFormat df = new DecimalFormat("#,###.##");
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate ld = LocalDate.now();
		String nome = "CaixaTotal";

		BufferedWriter buffW = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		buffW.append("\n----------------------------------------\n");
		buffW.append("Caixa de todas as agencias:\n");
		Double caixaTotal = 0.0;
		if (!agencias.isEmpty()) {
			for (Agencia agencia : agencias) {
				caixaTotal = caixaTotal + agencia.getCaixa();
			}
			buffW.append(
					"\n----------------------------------------\n" + "Total em caixa: R$ " + df.format(caixaTotal));
			buffW.append("\nData: " + dateFormat.format(ld) + "\n----------------------------------------\n");
		}
		buffW.close();
	}

	public static void cadastrarCliente(Cliente cliente) {
		String nome = "banco";
		try (BufferedWriter buffW = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true))) {
			String linha = "Cliente;" + cliente.getId() + ";" + cliente.getNome() + ";" + cliente.getCpf() + ";"
					+ cliente.getTelefone() + ";" + cliente.getEmail() + ";" + cliente.getSenha() + ";";

			buffW.append("\n").append(linha);
			buffW.flush();
		} catch (IOException e) {
			Util.customizer();
			logger.log(Level.INFO, "\nErro ao salvaro arquivo\n");
		}
	}

	public static void cadastrarContaCorrente(ContaCorrente contaCorrente) {
		String nome = "banco";
		try (BufferedWriter buffW = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true))) {
			String linha = "ContaCorrente;" + contaCorrente.getConta() + ";" + contaCorrente.getNumeroConta() + ";"
					+ contaCorrente.getSaldo() + ";" + contaCorrente.getFkCliente() + ";" + contaCorrente.getFkAgencia()
					+ ";" + contaCorrente.getSaldoMinimo() + ";" + contaCorrente.getTaxaManutencao() + ";";
			buffW.append("\n").append(linha);
			buffW.flush();
		} catch (IOException e) {
			Util.customizer();
			logger.log(Level.INFO, "\nErro ao salvaro arquivo\n");
		}
	}

	public static void cadastrarContaPoupanca(ContaPoupanca contaPoupanca) {
		String nome = "banco";
		try (BufferedWriter buffW = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true))) {
			String linha = "ContaCorrente;" + contaPoupanca.getConta() + ";" + contaPoupanca.getNumeroConta() + ";"
					+ contaPoupanca.getSaldo() + ";" + contaPoupanca.getFkCliente() + ";" + contaPoupanca.getFkAgencia()
					+ ";" + contaPoupanca.getRendimento() + ";";
			buffW.append("\n").append(linha);
			buffW.flush();
		} catch (IOException e) {
			Util.customizer();
			logger.log(Level.INFO, "\nErro ao salvaro arquivo\n");
		}
	}

	public static void cadastrarGerente(Gerente gerente) {
		String nome = "banco";
		try (BufferedWriter buffW = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true))) {
			String linha = "Gerente" + gerente.getId() + ";" + gerente.getFkAgencia() + ";" + gerente.getTelefone()
					+ ";" + gerente.getSalario() + ";" + gerente.getNome() + ";" + gerente.getCpf() + ";"
					+ gerente.getEmail() + ";" + gerente.getSenha() + ";" + gerente.isBonificacao() + ";";
			buffW.append("\n").append(linha);
			buffW.flush();
		} catch (IOException e) {
			Util.customizer();
			logger.log(Level.INFO, "\nErro ao salvaro arquivo\n");
		}
	}

	public static void cadastrarDiretor(Diretor diretor) {
		String nome = "banco";
		try (BufferedWriter buffW = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true))) {
			String linha = "Diretor" + diretor.getId() + ";" + diretor.getTelefone() + ";" + diretor.getSalario() + ";"
					+ diretor.getNome() + ";" + diretor.getCpf() + ";" + diretor.getEmail() + ";" + diretor.getSenha()
					+ ";" + diretor.isBonificacao();
			buffW.append("\n").append(linha);
			buffW.flush();
		} catch (IOException e) {
			Util.customizer();
			logger.log(Level.INFO, "\nErro ao salvaro arquivo\n");
		}
	}

	static String estado = null;

	public static void relatorioInfoClienteDiretor(Diretor diretor) throws IOException {
		String nome = "relatorio-info-cliente-diretor";
		BufferedWriter buffW = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		List<Cliente> listaClientes = new ArrayList<>();

		for (Agencia agencia : Agencia.getMapaAgencia().values()) {
			if (agencia.getFkDiretor() == diretor.getId()) {
				for (ContaCorrente contaCorrente : ContaCorrente.getMapaContaCorrente().values()) {
					if (contaCorrente.getFkAgencia() == agencia.getId()) {
						for (Cliente cliente : Cliente.getMapaCliente().values()) {
							if (cliente.getId() == contaCorrente.getFkCliente()) {
								estado = agencia.getUf();
								listaClientes.add(cliente);
							}
						}
					}
				}
				for (ContaPoupanca contaPoupanca : ContaPoupanca.getMapaContaPoupanca().values()) {
					if (contaPoupanca.getFkAgencia() == agencia.getId()) {
						for (Cliente cliente : Cliente.getMapaCliente().values()) {
							if (cliente.getId() == contaPoupanca.getFkCliente() && !listaClientes.contains(cliente)) {
								estado = agencia.getUf();
								listaClientes.add(cliente);
							}
						}
					}
				}
			}
		}
		Collections.sort(listaClientes, Comparator.comparing(Cliente::getNome));
		for (Cliente cliente : listaClientes) {
			buffW.append("\nnome cliente: " + cliente.getNome() + "\nCPF cliente: " + cliente.getCpf() + "\nAgencia: "
					+ estado);
		}
		buffW.close();
	}

	public static void numeroContas() throws IOException {

		String nome = "Número de Contas";

		BufferedWriter buffW = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		buffW.append("\n----------------------------------------\n");
		buffW.append("Número de contas desta agencia:\n");
		Integer numContas = 0;
		for (Gerente gerente : Gerente.getMapaGerente().values()) {
			for (Agencia agencia : Agencia.getMapaAgencia().values()) {
				for (ContaCorrente contaCorrente : ContaCorrente.getMapaContaCorrente().values()) {
					for (ContaPoupanca contaPoupanca : ContaPoupanca.getMapaContaPoupanca().values()) {
						if (contaCorrente.getFkAgencia() == agencia.getId()
								&& contaPoupanca.getFkAgencia() == agencia.getId()
								&& gerente.getFkAgencia() == agencia.getId()) {
							numContas++;
						}
					}
				}
			}
		}
		buffW.append("\n----------------------------------------\n" + "Total de " + numContas + " Contas");
		buffW.close();
	}

	public static void relatorioInfoClienteDiretorP(List<Diretor> diretor) throws IOException {

		String nome = "relatorio-info-cliente-diretor";
		BufferedWriter buffW = new BufferedWriter(new FileWriter(PATH_BASICO + nome + EXTENSAO, true));
		List<Cliente> listaClientes = new ArrayList<>();

		for (Agencia agencia : Agencia.getMapaAgencia().values()) {
			for (Diretor dd : Diretor.getMapaDiretor().values()) {
				if (agencia.getFkDiretor() == dd.getId()) {
					for (ContaCorrente contaCorrente : ContaCorrente.getMapaContaCorrente().values()) {
						if (contaCorrente.getFkAgencia() == agencia.getId()) {
							for (Cliente cliente : Cliente.getMapaCliente().values()) {
								if (cliente.getId() == contaCorrente.getFkCliente()) {
									estado = agencia.getUf();
									listaClientes.add(cliente);
								}
							}
						}
					}
				}
				for (ContaPoupanca contaPoupanca : ContaPoupanca.getMapaContaPoupanca().values()) {
					if (contaPoupanca.getFkAgencia() == agencia.getId()) {
						for (Cliente cliente : Cliente.getMapaCliente().values()) {
							if (cliente.getId() == contaPoupanca.getFkCliente() && !listaClientes.contains(cliente)) {
								estado = agencia.getUf();
								listaClientes.add(cliente);
							}
						}
					}
				}
			}
		}
		Collections.sort(listaClientes, Comparator.comparing(Cliente::getNome));
		for (Cliente cliente : listaClientes) {
			buffW.append("\nnome cliente: " + cliente.getNome() + "\nCPF cliente: " + cliente.getCpf() + "\nAgencia: "
					+ estado);
		}
		buffW.close();

	}

}
