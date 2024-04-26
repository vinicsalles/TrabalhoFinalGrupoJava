package br.com.poo.g6.entities;

import java.util.HashMap;
import java.util.Map;

import br.com.poo.g6.enums.TipoPessoa;

public class Presidente extends Funcionario {

	private boolean participacaoNosLucros;

	private static Map<Integer, Presidente> mapaPresidente = new HashMap<>();

	public Presidente() {
		super();
	}

	public Presidente(Integer id, Integer fkAgencia, String telefone, Double salario, String nome, String cpf,
			String email, String senha, TipoPessoa tipo, boolean participacaoNosLucros) {
		super(id, fkAgencia, telefone, salario, nome, cpf, email, senha, tipo);
		this.participacaoNosLucros = participacaoNosLucros;
	}

	public boolean isParticipacaoNosLucros() {
		return participacaoNosLucros;
	}

	public static Map<Integer, Presidente> getMapaPresidente() {
		return mapaPresidente;
	}

	@Override
	public String toString() {
		return "Presidente \nparticipacaoNosLucros= " + participacaoNosLucros + ", \nId= " + getId() + ", \nAgencia= "
				+ getFkAgencia() + ", \nTelefone =" + getTelefone() + ", \nSalario= " + getSalario() + ", \nNome= "
				+ getNome() + ", \nCpf= " + getCpf() + ", \nEmail= " + getEmail() + ", \nSenha= " + getSenha()
				+ ", \nClass= " + getClass() + ", \nhashCode= " + hashCode() + ", \ntoString= " + super.toString();

	}

}
