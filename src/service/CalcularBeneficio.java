package service;

import java.util.List;

import model.Funcionario;
import model.Venda;

public class CalcularBeneficio {
	
	public double calcularBeneficio(Funcionario funcionario, String mesAno) {
	    int anoContratacao = funcionario.getDataContratacao().getYear() + 1900;
	    int anoAtual = Integer.parseInt(mesAno.split("/")[1]);
	    int anosDeServico = anoAtual - anoContratacao;

	    double beneficio = 0.0;

	    // Verifica se o cargo possui benefício (Gerente não possui benefício)
	    if (funcionario.getCargo().getNome().equals("Secretário") || funcionario.getCargo().getNome().equals("Vendedor")) {
	        beneficio = funcionario.getCargo().getBeneficioPorAno() * anosDeServico;
	    }

	    return beneficio;
	}

	private double calcularBeneficioVendas(Funcionario funcionario, String mesAno, List<Venda> vendas) {
	    double beneficioVendas = 0.0;

	    for (Venda venda : vendas) {
	        if (venda.getVendedor().equals(funcionario) && venda.getMesAno().equals(mesAno)) {
	            beneficioVendas += 0.3 * venda.getValor(); // 30% sobre o valor vendido
	        }
	    }

	    return beneficioVendas;
	}

}
