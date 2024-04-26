package br.com.poo.g6.entities;

import java.util.HashMap;
import java.util.Map;

import br.com.poo.g6.enums.TipoPessoa;

public class Diretor extends Funcionario {
	private static Map<Integer, Diretor> mapaDiretor = new HashMap<>();

	public static Map<Integer, Diretor> getMapaGerente() {
		return mapaDiretor;
	}

	private boolean bonificacao;

	public Diretor() {
		super();
	}

	public static Map<Integer, Diretor> getMapaDiretor() {
		return mapaDiretor;
	}

	public static void setMapaDiretor(Map<Integer, Diretor> mapaDiretor) {
		Diretor.mapaDiretor = mapaDiretor;
	}

	public void setBonificacao(boolean bonificacao) {
		this.bonificacao = bonificacao;
	}

	public Diretor(boolean bonificacao) {
		super();
		this.bonificacao = bonificacao;
	}

	public boolean isBonificacao() {
		return bonificacao;
	}

	public Diretor(Integer id, Integer fkAgencia, String telefone, Double salario, String nome, String cpf,
			String email, String senha, TipoPessoa tipo, boolean bonificacao) {
		super(id, fkAgencia, telefone, salario, nome, cpf, email, senha, tipo);
		this.bonificacao = bonificacao;
	}

	public Diretor(Integer id, String telefone, Double salario, String nome, String cpf, String email, String senha,
			TipoPessoa tipo, boolean bonificacao) {
		super(id, telefone, salario, nome, cpf, email, senha, tipo);
		this.bonificacao = bonificacao;
	}

	@Override
	public String toString() {
		return "Diretor [bonificacao=" + bonificacao + ", isBonificacao()=" + isBonificacao() + ", getId()=" + getId()
				+ ", getFkAgencia()=" + getFkAgencia() + ", getTelefone()=" + getTelefone() + ", getSalario()="
				+ getSalario() + ", getNome()=" + getNome() + ", getCpf()=" + getCpf() + ", getEmail()=" + getEmail()
				+ ", getSenha()=" + getSenha() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}