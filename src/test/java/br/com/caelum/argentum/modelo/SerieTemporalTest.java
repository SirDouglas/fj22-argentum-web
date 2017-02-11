package br.com.caelum.argentum.modelo;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

public class SerieTemporalTest {

	@SuppressWarnings("unused")
	@Test(expected=IllegalStateException.class)
	public void ListaNula() {
		 List<Candle> candles = new ArrayList<Candle>();
		SerieTemporal temporal = new SerieTemporal(candles);
	
			}
	@Test
	public void listaComUmItem() {
		 List<Candle> candles = new ArrayList<Candle>();
		 
		 Candle e = new Candle(3.0, 2.0, 1.0, 4.3, 100, Calendar.getInstance());
		candles.add(e);
			SerieTemporal temporal = new SerieTemporal(candles);
			assertEquals(3.0, temporal.getCandle(0).getAbertura(),0.0001);
			assertEquals(1.0, temporal.getCandle(0).getMinimo(),0.0001);
	}

}
