package view;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import model.Cargo;
import model.Funcionario;
import model.Venda;
import service.CalcularBeneficioTotal;
import service.CalcularPagamentoTotal;
import service.CalcularSalarioTotal;
import service.EncontrarFuncionarioComMaiorBeneficio;
import service.EncontrarMaiorRecebimento;
import service.EncontrarVendedorComMaiorVenda;

public class Main {

	public static void main(String[] args) {
		Cargo secretario = new Cargo("Secretário", 7000.0, 1000.0, 0.20);
		Cargo vendedor = new Cargo("Vendedor", 12000.0, 1800.0, 0.30);
		Cargo gerente = new Cargo("Gerente", 20000.0, 3000.0, 0.0);

		SimpleDateFormat sdf = new SimpleDateFormat("MM/yyyy");
		List<Funcionario> funcionarios = new ArrayList<>();
		List<Venda> vendas = new ArrayList<>();
		try {
			Funcionario jorge = new Funcionario("Jorge Carvalho", secretario, sdf.parse("01/2018"));
			Funcionario maria = new Funcionario("Maria Souza", secretario, sdf.parse("12/2015"));
			Funcionario ana = new Funcionario("Ana Silva", vendedor, sdf.parse("12/2021"));
			Funcionario joao = new Funcionario("João Mendes", vendedor, sdf.parse("12/2021"));
			Funcionario juliana = new Funcionario("Juliana Alves", gerente, sdf.parse("07/2017"));
			Funcionario bento = new Funcionario("Bento Albino", gerente, sdf.parse("03/2014"));

			funcionarios.add(jorge);
			funcionarios.add(maria);
			funcionarios.add(ana);
			funcionarios.add(joao);
			funcionarios.add(juliana);
			funcionarios.add(bento);
			
			// Crie instâncias de vendas
			Venda vendaAnaDez21 = new Venda(ana, 5200.0, "12/2021");
			Venda vendaAnaJan22 = new Venda(ana, 4000.0, "01/2022");
			Venda vendaJoaoDez21 = new Venda(joao, 3400.0, "12/2021");
			Venda vendaJoaoJan22 = new Venda(joao, 7700.0, "01/2022");
			

			// Crie uma lista de vendas e adicione as vendas a ela
			
			vendas.add(vendaAnaDez21);
			vendas.add(vendaAnaJan22);
			vendas.add(vendaJoaoDez21);
			vendas.add(vendaJoaoJan22);

		} catch (ParseException e) {
			e.printStackTrace();
		}
	

		String mesAno = "12/2021";

		CalcularPagamentoTotal calcularPagamentoTotal = new CalcularPagamentoTotal();
		// Calcule o valor total pago para todos os funcionários em dezembro de 2021
		double totalPago = calcularPagamentoTotal.calcularPagamentoTotal(funcionarios, mesAno);
		System.out.println("Valor total pago em " + mesAno + ": " + totalPago);

		CalcularSalarioTotal calcularSalarioTotal = new CalcularSalarioTotal();
		// Calcule o salário total para todos os funcionários em dezembro de 2021
		double salarioTotal = calcularSalarioTotal.calcularSalarioTotal(funcionarios, mesAno);
		System.out.println("Salário total em " + mesAno + ": " + salarioTotal);

		CalcularBeneficioTotal calcularBeneficioTotal = new CalcularBeneficioTotal();
		// Calcule o benefício total para todos os funcionários em dezembro de 2021
		double beneficioTotal = calcularBeneficioTotal.calcularBeneficioTotal(funcionarios, mesAno);
		System.out.println("Benefício total em " + mesAno + ": " + beneficioTotal);

		EncontrarMaiorRecebimento encontrarMaiorRecebimento = new EncontrarMaiorRecebimento();
		// Encontre o funcionário com o maior recebimento em dezembro de 2021
		Funcionario funcionarioComMaiorRecebimento = encontrarMaiorRecebimento.encontrarMaiorRecebimento(funcionarios,
				mesAno);
		System.out.println(
				"Funcionário com o maior recebimento em " + mesAno + ": " + funcionarioComMaiorRecebimento.getNome());

		EncontrarFuncionarioComMaiorBeneficio encontrarFuncionarioComMaiorBeneficio = new EncontrarFuncionarioComMaiorBeneficio();
		// Encontre o nome do funcionário com o maior benefício em dezembro de 2021
		String funcionarioComMaiorBeneficio = encontrarFuncionarioComMaiorBeneficio
				.encontrarFuncionarioComMaiorBeneficio(funcionarios, mesAno);
		System.out.println("Funcionário com o maior benefício em " + mesAno + ": " + funcionarioComMaiorBeneficio);

		EncontrarVendedorComMaiorVenda encontrarVendedorComMaiorVenda = new EncontrarVendedorComMaiorVenda();
		// Encontre o vendedor que mais vendeu em dezembro de 2021
		Funcionario vendedorComMaiorVenda = encontrarVendedorComMaiorVenda.encontrarVendedorComMaiorVenda(funcionarios,
				mesAno, vendas);
		if (vendedorComMaiorVenda != null) {
			System.out.println("Vendedor com maior venda em " + mesAno + ": " + vendedorComMaiorVenda.getNome());
		} else {
			System.out.println("Nenhum vendedor encontrado em " + mesAno);
		}

	}

}
