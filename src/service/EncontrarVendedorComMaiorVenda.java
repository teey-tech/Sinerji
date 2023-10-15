package service;

import java.util.List;

import model.Funcionario;
import model.Venda;

public class EncontrarVendedorComMaiorVenda {

	public Funcionario encontrarVendedorComMaiorVenda(List<Funcionario> funcionarios, String mesAno, List<Venda> vendas) {
	    Funcionario vendedorComMaiorVenda = null;
	    double maiorVenda = 0.0;

	    for (Funcionario funcionario : funcionarios) {
	        if (funcionario.getCargo().getNome().equals("Vendedor")) {
	            double totalVendas = calcularTotalVendas(funcionario, mesAno, vendas);
	            if (totalVendas > maiorVenda) {
	                maiorVenda = totalVendas;
	                vendedorComMaiorVenda = funcionario;
	            }
	        }
	    }

	    return vendedorComMaiorVenda;
	}

	private double calcularTotalVendas(Funcionario vendedor, String mesAno, List<Venda> vendas) {
	    double total = 0.0;
	    for (Venda venda : vendas) {
	        if (venda.getVendedor().equals(vendedor) && venda.getMesAno().equals(mesAno)) {
	            total += venda.getValor();
	        }
	    }
	    return total;
	}
}
