package br.com.caelum.argentum.modelo;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class CandleTest {

	@Test(expected=IllegalArgumentException.class)
	public void precoMaximoNaoPodeSerMenorQueMinimo() {
		new Candle(10, 20, 20, 10, 10000,Calendar.getInstance());
	}
	
	@Test(expected=IllegalArgumentException.class) 
	public void dataNaoPodeSerNula() {
		new Candle(10,10,5, 10, 1000, null);
	}
	
	@Test(expected=IllegalArgumentException.class)
    public void valorNegativo() {
		new Candle(2, 2, 4, 4, -1000, Calendar.getInstance());
	}
	
	@Test
	public void quandoAberturaIgualFechamentoEhAlta () {
		Candle candlestick = new Candle(10, 10, 2, 5, 2, Calendar.getInstance());
		assertEquals(true,candlestick.isAlta());
		assertEquals(false,candlestick.isBaixa());
		
	}
}
