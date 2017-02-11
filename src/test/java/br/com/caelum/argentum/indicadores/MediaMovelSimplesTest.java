package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.argentum.modelo.SerieTemporal;

public class MediaMovelSimplesTest {

	@Test
	public void sequenciaSimplesDeCandles() throws Exception {

	SerieTemporal serie =	GeradorDeSeries.criaSerie(1,2,3,4,3,4,5,4,3);
	MediaMovelSimples mms = new MediaMovelSimples(3,new IndicadorFechamento());
	
	assertEquals(2.0, mms.calcula(2, serie),0.0001);
	assertEquals(3.0,mms.calcula(3, serie),0.0001);
	assertEquals(10.0/3, mms.calcula(4, serie),0.0001);
	assertEquals(11.0/3, mms.calcula(5, serie),0.0001);
	assertEquals(4.0,mms.calcula(6, serie),0.0001);
	assertEquals(13.0/3, mms.calcula(7, serie),0.0001);
	assertEquals(4.0, mms.calcula(8, serie),0.0001);
		
	}
	
	@Test
	public void sequencia5DiasDeCandles() throws Exception {
	SerieTemporal serie =	GeradorDeSeries.criaSerie(1,2,3,4,5,6,7,8,9,6,10,11,9,8,7,6,3,2,3,9,10,10,20,20,20);
	MediaMovelSimples mms = new MediaMovelSimples(5,new IndicadorFechamento());
	
	assertEquals(32/5, mms.calcula(7, serie),0.0001);
	assertEquals(16.0, mms.calcula(24, serie),0.0001);
	assertEquals(32/5, mms.calcula(7, serie),0.0001);
	assertEquals(16, mms.calcula(24, serie),0.0001);
	assertEquals(5.4, mms.calcula(20, serie),0.0001);
	}

}
