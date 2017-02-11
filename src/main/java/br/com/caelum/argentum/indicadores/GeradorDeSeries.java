package br.com.caelum.argentum.indicadores;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.SerieTemporal;

public class GeradorDeSeries {
public static SerieTemporal criaSerie(double... valores) {
	ArrayList<Candle> candles = new ArrayList<Candle>();
	
	for (double d: valores) {
		candles.add(new Candle(d, d, d, d, 1000, Calendar.getInstance()));
	}
	return new SerieTemporal(candles);


}
}
