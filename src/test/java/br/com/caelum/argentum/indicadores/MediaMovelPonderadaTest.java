package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;

import org.junit.Test;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelPonderadaTest {

	@Test
	public void sequenciaSimplesDeCandle() {
		SerieTemporal serie = GeradorDeSeries.criaSerie(1,2,3,4,5,6);
		Indicador mmp = new MediaMovelPonderada(3,new IndicadorFechamento());
		assertEquals(14.0/6, mmp.calcula(2, serie),0.00001);
		assertEquals(20.0/6, mmp.calcula(3, serie),0.00001);
		assertEquals(26.0/6, mmp.calcula(4, serie),0.00001);
		assertEquals(32.0/6, mmp.calcula(5, serie),0.00001);
		
	}
	
	@Test
	public void sequencia5DiasDeCandle() {
		SerieTemporal serie = GeradorDeSeries.criaSerie(1,2,3,4,5,6,7,8,9,6,10,11,9,8,7,6,3,2,3,9,10,10,20,20,20);
		Indicador mmp = new MediaMovelPonderada(5,new IndicadorFechamento());
		assertEquals(6.8, mmp.calcula(20, serie),0.00001);
		assertEquals(18, mmp.calcula(24, serie),0.00001);
	//	assertEquals(26.0/6, mmp.calcula(4, serie),0.00001);
	
		
	}

}
