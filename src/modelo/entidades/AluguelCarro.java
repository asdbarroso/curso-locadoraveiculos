package modelo.entidades;

import java.util.Date;

public class AluguelCarro {

	private Date inicio;
	private Date termino;

	private Veiculos veiculo;
	private Fatura fatura;

	public AluguelCarro() {

	}

	public AluguelCarro(Date inicio, Date termino, Veiculos veiculo) {
		this.inicio = inicio;
		this.termino = termino;
		this.veiculo = veiculo;
	}

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public Veiculos getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculos veiculo) {
		this.veiculo = veiculo;
	}

	public Fatura getFatura() {
		return fatura;
	}

	public void setFatura(Fatura fatura) {
		this.fatura = fatura;
	}
	
}
