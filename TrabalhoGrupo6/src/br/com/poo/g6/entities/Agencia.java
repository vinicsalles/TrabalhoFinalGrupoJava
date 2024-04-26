package br.com.poo.g6.entities;

import java.util.HashMap;
import java.util.Map;

public class Agencia {
	private int id;
	private String uf;
	private String cidade;
	private String bairro;
	private Double caixa;
	private Integer fkDiretor;

	public static Map<Integer, Agencia> mapaAgencia = new HashMap<>();

	public static Map<Integer, Agencia> getMapaAgencia() {
		return mapaAgencia;
	}

	public Agencia() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Agencia(int id, String uf, String cidade, String bairro, Double caixa, Integer fkDiretor) {
		super();
		this.id = id;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.caixa = caixa;
		this.fkDiretor = fkDiretor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Double getCaixa() {
		return caixa;
	}

	public void setCaixa(Double caixa) {
		this.caixa = caixa;
	}

	@Override
	public String toString() {
		return "Agencia [id=" + id + ", uf=" + uf + ", cidade=" + cidade + ", Bairro=" + bairro + ", Caixa=" + caixa
				+ ", getId()=" + getId() + ", getUf()=" + getUf() + ", getCidade()=" + getCidade() + ", getBairro()="
				+ getBairro() + ", getCaixa()=" + getCaixa() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

	public Integer getFkDiretor() {
		return fkDiretor;
	}
}
