package br.com.caelum.argentum.indicadores;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class IndicadorAberturaTest {

	@Test
	public void testarIndicadorAbertura() {
		Indicador abertura = new IndicadorAbertura();
		List<Candle> candles = new ArrayList<>();
		Candle e = new Candle(4, 5, 1, 10, 6, Calendar.getInstance());
		candles.add(e);
		SerieTemporal serie = new SerieTemporal(candles );
		double name = abertura.calcula(0, serie );
		assertEquals(4.0, name,0.0001);
	}

}
