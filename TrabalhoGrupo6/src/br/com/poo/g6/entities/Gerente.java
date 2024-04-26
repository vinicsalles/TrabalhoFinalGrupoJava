package br.com.poo.g6.entities;

import java.util.HashMap;
import java.util.Map;

import br.com.poo.g6.enums.TipoPessoa;

public class Gerente extends Funcionario {

	private boolean bonificacao;

	private static Map<Integer, Gerente> mapaGerente = new HashMap<>();

	public static Map<Integer, Gerente> getMapaGerente() {
		return mapaGerente;
	}

	public Gerente() {
		super();

	}

	public Gerente(Integer id, Integer fkAgencia, String telefone, Double salario, String nome, String cpf,
			String email, String senha, TipoPessoa tipo, boolean bonificacao) {
		super(id, fkAgencia, telefone, salario, nome, cpf, email, senha, tipo);
		this.bonificacao = bonificacao;
	}

	public Gerente(boolean bonificacao) {
		super();
		this.bonificacao = bonificacao;
	}

	public boolean isBonificacao() {
		return bonificacao;
	}

	public void setBonificacao(boolean bonificacao) {
		this.bonificacao = bonificacao;
	}

	@Override
	public String toString() {
		return "Gerente [bonificacao=" + bonificacao + ", isBonificacao()=" + isBonificacao() + ", getId()=" + getId()
				+ ", getFkAgencia()=" + getFkAgencia() + ", getTelefone()=" + getTelefone() + ", getSalario()="
				+ getSalario() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getEmail()=" + getEmail()
				+ ", getSenha()=" + getSenha() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}
