package br.com.caelum.argentum.indicadores;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderada implements Indicador {

	private int dia;
	private Indicador outroIndicador;
	public MediaMovelPonderada(int dia,Indicador outroIndicador) {
		this.dia = dia;
		this.outroIndicador = outroIndicador;
	}
	
	public MediaMovelPonderada(Indicador outroIndicador) {
		this.dia = 3;
		this.outroIndicador = outroIndicador;
	}
	/* (non-Javadoc)
	 * @see br.com.caelum.argentum.indicadores.Indicador#calcula(int, br.com.caelum.argentum.modelo.SerieTemporal)
	 */
	@Override
	public double calcula (int posicao,SerieTemporal serie) {
		double soma = 0.0;
		int pesoTotal = 0;
		int peso = dia;
		for (int i = posicao; i >  (posicao - dia) ; i--) {
			Candle candle = serie.getCandle(i);
			soma += (this.outroIndicador.calcula(i, serie)) * peso;
			pesoTotal += peso;
			peso--;
			
		}
		
		return soma / (pesoTotal);
		
	}
	
	public String toString() {
		return "MMP de Fechamento";
	}
}
