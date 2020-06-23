package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import modelo.entidades.AluguelCarro;
import modelo.entidades.Veiculos;
import modelo.servicos.ServicoAluguel;
import modelo.servicos.ServicoTaxaBrasil;

public class Programa {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		System.out.println("Entre com os dados da locação:");
		System.out.print("Modelo Veiculo: ");
		String modelo = sc.nextLine();
		System.out.print("Data inicio: ");
		Date inicio = sdf.parse(sc.nextLine());
		System.out.print("Data termino: ");
		Date termino = sdf.parse(sc.nextLine());

		AluguelCarro aluguelCarro = new AluguelCarro(inicio, termino, new Veiculos(modelo));

		System.out.print("Informar o preço por horas: ");
		double valorHora = sc.nextDouble();
		System.out.print("Informar o preço por dias: ");
		double valorDia = sc.nextDouble();
		System.out.println();

		ServicoAluguel servicoAluguel = new ServicoAluguel(valorHora, valorDia, new ServicoTaxaBrasil());
		servicoAluguel.processarFatura(aluguelCarro);
		
		System.out.println("DADOS NOTA FISCAL: ");
		System.out.println("Pagamento basico: " + String.format("%.2f", aluguelCarro.getFatura().getPagamentoBasico()));
		System.out.println("Taxa: " + String.format("%.2f", aluguelCarro.getFatura().getTaxa()));
		System.out.println("Pagamento Total: " + String.format("%.2f", aluguelCarro.getFatura().pagamentoTotal()));

		sc.close();
	}

}