package model;

import java.util.Date;

public class Funcionario {

	String nome;
	Cargo cargo;
	Date dataContratacao;

	public Funcionario(String nome, Cargo cargo, Date dataContratacao) {
		super();
		this.nome = nome;
		this.cargo = cargo;
		this.dataContratacao = dataContratacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

}
