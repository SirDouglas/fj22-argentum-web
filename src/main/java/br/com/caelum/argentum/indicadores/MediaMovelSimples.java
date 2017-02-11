package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimples implements Indicador {
	
	private int dia;
	private Indicador outroIndicador;
	public MediaMovelSimples(int dia,Indicador outroIndicador) {
	this.dia = dia;
	this.outroIndicador = outroIndicador;
	}
	public MediaMovelSimples(Indicador outroIndicador) {
		this.dia = 3;
		this.outroIndicador = outroIndicador;
	}

	public double calcula(int posicao,SerieTemporal serie) {
		double soma = 0.0;
		for (int i = posicao; i > (posicao - this.dia); i--) {
			soma += outroIndicador.calcula(i, serie);
					
		}
		return soma / dia;
		
		
	}
	
	public String toString() {
		return "MMS de Fechamento";
	}
	
	
}
