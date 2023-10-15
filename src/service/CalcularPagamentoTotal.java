package service;

import java.util.List;

import model.Funcionario;

public class CalcularPagamentoTotal {

	public double calcularPagamentoTotal(List<Funcionario> funcionarios, String mesAno) {
		CalcularSalario calcularSalario = new CalcularSalario();
		CalcularBeneficio calcularBeneficio = new CalcularBeneficio();
	    double total = 0.0;
	    for (Funcionario funcionario : funcionarios) {
	        total += calcularSalario.calcularSalario(funcionario, mesAno) +
	        		calcularBeneficio.calcularBeneficio(funcionario, mesAno);
	    }
	    return total;
	}
}
