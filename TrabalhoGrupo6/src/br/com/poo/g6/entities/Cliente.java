package br.com.poo.g6.entities;

import java.util.HashMap;
import java.util.Map;

import br.com.poo.g6.enums.TipoPessoa;

public class Cliente {

	private Integer id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String senha;
	private TipoPessoa tipo;

	public static Map<Integer, Cliente> mapaCliente = new HashMap<>();

	public Cliente() {
		super();
	}

	public Cliente(Integer id, String nome, String cpf, String telefone, String email, String senha, TipoPessoa tipo) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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

	public TipoPessoa getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "\nCliente id= " + id + "; \nnome= " + nome + "; \ncpf= " + cpf + "; \ntelefone= " + telefone
				+ "; \nemail= " + email + "; \nsenha= " + senha + "\n";
	}

	public static Map<Integer, Cliente> getMapaCliente() {
		return mapaCliente;
	}

	public static void setMapaCliente(Map<Integer, Cliente> mapaCliente) {
		Cliente.mapaCliente = mapaCliente;
	}

}
