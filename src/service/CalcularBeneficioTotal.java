package service;

import java.util.List;

import model.Funcionario;

public class CalcularBeneficioTotal {

	public double calcularBeneficioTotal(List<Funcionario> funcionarios, String mesAno) {
	    double total = 0.0;
	    CalcularBeneficio calcularBeneficio = new CalcularBeneficio();
	    for (Funcionario funcionario : funcionarios) {
	        total += calcularBeneficio.calcularBeneficio(funcionario, mesAno);
	    }
	    return total;
	}
	
}
