package br.com.poo.g6.entities;

import java.util.HashMap;
import java.util.Map;

import br.com.poo.g6.enums.TipoPessoa;

public class Funcionario {
	private Integer id;
	private Integer fkAgencia;
	private String telefone;
	private Double salario;
	private String nome;
	private String cpf;
	private String email;
	private String senha;
	private TipoPessoa tipo;

	private static Map<Integer, Funcionario> mapaFuncionario = new HashMap<>();

	public Funcionario() {
		super();
	}

	public Funcionario(Integer id, Integer fkAgencia, String telefone, Double salario, String nome, String cpf,
			String email, String senha, TipoPessoa tipo) {
		super();
		this.id = id;
		this.fkAgencia = fkAgencia;
		this.telefone = telefone;
		this.salario = salario;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Funcionario(Integer id, String telefone, Double salario, String nome, String cpf, String email, String senha,
			TipoPessoa tipo) {
		super();
		this.id = id;
		this.telefone = telefone;
		this.salario = salario;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.tipo = tipo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFkAgencia() {
		return fkAgencia;
	}

	public void setFkAgencia(Integer fkAgencia) {
		this.fkAgencia = fkAgencia;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static Map<Integer, Funcionario> getMapaFuncionario() {
		return mapaFuncionario;
	}

	public TipoPessoa getTipo() {
		return tipo;
	}

}
