package modelo.servicos;

import java.util.concurrent.TimeUnit;

import modelo.entidades.AluguelCarro;
import modelo.entidades.Fatura;

public class ServicoAluguel {

	private Double precoHora;
	private Double precoDia;
	
	private ServicoTaxaBrasil servicoTaxaBrasil;
	
	public ServicoAluguel() {
		
	}

	public ServicoAluguel(Double precoHora, Double precoDia, ServicoTaxaBrasil servicoTaxaBrasil) {
		this.precoHora = precoHora;
		this.precoDia = precoDia;
		this.servicoTaxaBrasil = servicoTaxaBrasil;
	}

	public void processarFatura(AluguelCarro aluguelCarro) {
		
		long inicio = aluguelCarro.getInicio().getTime();
		long termino = aluguelCarro.getTermino().getTime();
		double dif = (double) (termino - inicio) / 1000 / 60 / 60;

		double pagamentoBasico;
		
		if (dif <= 12) {
			pagamentoBasico = Math.ceil(dif) * precoHora;
		} else {
			pagamentoBasico = Math.ceil(dif / 24) * precoDia;
		}
		
		double taxa = servicoTaxaBrasil.taxa(pagamentoBasico);
		
		aluguelCarro.setFatura(new Fatura(pagamentoBasico, taxa));
		
	}
	
	
	
	
}
