package br.com.caelum.argentum.testes;

import br.com.caelum.argentum.indicadores.GeradorDeSeries;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class TestaIndicadoresModelo {
public static void main(String[] args) {
	
	SerieTemporal serie =	GeradorDeSeries.criaSerie(1,2,3,4,5,6,7,8,9,6,10,11,9,8,7,6,3,2,3,9,10,10,20,20,20);
	MediaMovelSimples mms = new MediaMovelSimples(5,new IndicadorFechamento());
	System.out.println("Calcular " + mms.calcula(5, serie));
System.out.println("Ultima posicao " +serie.getUltimaPosicao());
	System.out.println("Primeiro fechamento " + serie.getCandle(0).getFechamento());
	System.out.println("Ultimo dia " + serie.getCandle(24).getFechamento());
	System.out.println("Ultimo dia " + serie.getCandle(23).getFechamento());
	System.out.println("Ultimo dia " + serie.getCandle(22).getFechamento());
	System.out.println("Ultimo dia " + serie.getCandle(21).getFechamento());
	System.out.println("Ultimo dia " + serie.getCandle(20).getFechamento());
	System.out.println("Calcular dias " + mms.calcula(24, serie));
	System.out.println("Ultimo dia " + serie.getCandle(20).getFechamento());
	System.out.println("Ultimo dia " + serie.getCandle(19).getFechamento());
	System.out.println("Ultimo dia " + serie.getCandle(18).getFechamento());
	System.out.println("Ultimo dia " + serie.getCandle(17).getFechamento());
	System.out.println("Ultimo dia " + serie.getCandle(16).getFechamento());
	System.out.println("Calcular dias " + mms.calcula(20, serie));
	


}
}
