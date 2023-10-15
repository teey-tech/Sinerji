package service;

import java.util.List;

import model.Funcionario;

public class EncontrarFuncionarioComMaiorBeneficio {

	public String encontrarFuncionarioComMaiorBeneficio(List<Funcionario> funcionarios, String mesAno) {
		Funcionario funcionarioComMaiorBeneficio = null;
		double maiorBeneficio = 0.0;
		CalcularSalario calcularSalario = new CalcularSalario();
		CalcularBeneficio calcularBeneficio = new CalcularBeneficio();

		for (Funcionario funcionario : funcionarios) {
			double beneficio = calcularBeneficio.calcularBeneficio(funcionario, mesAno);
			if (beneficio > maiorBeneficio) {
				maiorBeneficio = beneficio;
				funcionarioComMaiorBeneficio = funcionario;
			}
		}

		if (funcionarioComMaiorBeneficio != null) {
			return funcionarioComMaiorBeneficio.getNome();
		} else {
			return "Nenhum funcionário com benefício encontrado.";
		}
	}
}
