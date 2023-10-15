package service;

import java.util.List;

import model.Funcionario;

public class CalcularSalarioTotal {
	public double calcularSalarioTotal(List<Funcionario> funcionarios, String mesAno) {
	    double total = 0.0;
	    CalcularSalario calcularSalario = new CalcularSalario();
	    for (Funcionario funcionario : funcionarios) {
	        total += calcularSalario.calcularSalario(funcionario, mesAno);
	    }
	    return total;
	}
}
