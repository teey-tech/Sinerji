package service;

import java.util.List;

import model.Funcionario;

public class EncontrarMaiorRecebimento {
	
	public Funcionario encontrarMaiorRecebimento(List<Funcionario> funcionarios, String mesAno) {
	    Funcionario funcionarioComMaiorRecebimento = null;
	    CalcularSalario calcularSalario = new CalcularSalario();
		CalcularBeneficio calcularBeneficio = new CalcularBeneficio();
	    double maiorValor = 0.0;
	    
	    for (Funcionario funcionario : funcionarios) {
	        double valorTotal =calcularSalario.calcularSalario(funcionario, mesAno) +
	        		calcularBeneficio.calcularBeneficio(funcionario, mesAno);
	        if (valorTotal > maiorValor) {
	            maiorValor = valorTotal;
	            funcionarioComMaiorRecebimento = funcionario;
	        }
	    }
	    
	    return funcionarioComMaiorRecebimento;
	}
}
