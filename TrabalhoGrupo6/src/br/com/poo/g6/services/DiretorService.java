package br.com.poo.g6.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.com.poo.g6.entities.Agencia;
import br.com.poo.g6.entities.Cliente;
import br.com.poo.g6.entities.ContaCorrente;
import br.com.poo.g6.entities.ContaPoupanca;
import br.com.poo.g6.entities.Diretor;

public class DiretorService {
	static Logger logger = Util.setupLogger();
	static String estado = null;

	public static void listaInfoClienteDiretor(Diretor diretor) {
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
			Util.customizer();
			logger.log(Level.INFO, () -> "\nnome cliente: " + cliente.getNome() + "\nCPF cliente: " + cliente.getCpf()
					+ "\nAgencia: " + estado);
		}
	}

}
