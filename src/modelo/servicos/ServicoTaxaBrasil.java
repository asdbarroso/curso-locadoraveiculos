package modelo.servicos;

public class ServicoTaxaBrasil {

	public double taxa(Double valor) {
		
		if(valor <= 100.00) {
			return valor * 0.2;
		} else {
			return valor * 0.15;
		}
		
	}
	
	
}
