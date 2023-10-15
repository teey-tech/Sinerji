package model;

public class Venda {

	Funcionario vendedor;
	double valor;
	String mesAno;

	public Venda(Funcionario vendedor, double valor, String mesAno) {
		super();
		this.vendedor = vendedor;
		this.valor = valor;
		this.mesAno = mesAno;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getMesAno() {
		return mesAno;
	}

	public void setMesAno(String mesAno) {
		this.mesAno = mesAno;
	}

}
