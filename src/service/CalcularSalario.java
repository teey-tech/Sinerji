package service;

import model.Funcionario;

public class CalcularSalario {

	public double calcularSalario(Funcionario funcionario, String mesAno) {
	    int anoContratacao = funcionario.getDataContratacao().getYear() + 1900;
	    int mesContratacao = funcionario.getDataContratacao().getMonth() + 1;
	    int anoAtual = Integer.parseInt(mesAno.split("/")[1]);
	    int mesAtual = Integer.parseInt(mesAno.split("/")[0]);

	    int anosDeServico = anoAtual - anoContratacao;
	    if (mesAtual < mesContratacao) {
	        anosDeServico--; // Desconta um ano se o mês atual for anterior ao mês de contratação.
	    }

	    double salario = funcionario.getCargo().getSalarioBase() + (funcionario.getCargo().getBeneficioPorAno() * anosDeServico);
	    return salario;
	}
}
