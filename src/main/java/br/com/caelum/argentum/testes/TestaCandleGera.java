package br.com.caelum.argentum.testes;

import java.util.Calendar;

import br.com.caelum.argentum.builder.CandleBuilder;
import br.com.caelum.argentum.modelo.Candle;

public class TestaCandleGera {
public static void main(String[] args) {
	Calendar calendar =  Calendar.getInstance();
	
	Candle candle = new CandleBuilder().comAbertura(40.5).
			comFechamento(42.3).comMinimo(39.8).comMaximo(45.0)
			.comVolume(145234.20).comData(calendar).geraCandle();
	System.out.println(candle.toString());
}
}
