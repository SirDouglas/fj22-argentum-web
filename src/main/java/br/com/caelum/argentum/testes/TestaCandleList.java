package br.com.caelum.argentum.testes;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandlesFactory;
import br.com.caelum.argentum.modelo.Negociacao;

public class TestaCandleList {
public static void main(String[] args) {
	Calendar hoje  = Calendar.getInstance();
	Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
	Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
	Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
	Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);

	Calendar amanha = (Calendar) hoje.clone();
	amanha.add(Calendar.DAY_OF_MONTH,-1);
	
	Negociacao negociacao5 = new Negociacao(48.8, 100, amanha);
	Negociacao negociacao6 = new Negociacao(49.3, 100, amanha);
	
Calendar depois	= (Calendar) amanha.clone();
depois.add(Calendar.DAY_OF_MONTH, 2);

Negociacao negociacao7 = new Negociacao(51.8, 100, depois);
Negociacao negociacao8 = new Negociacao(52.3,100, depois);

List<Negociacao> negociacoes = Arrays.asList(negociacao1,negociacao2,negociacao3,negociacao4,negociacao5,negociacao6,negociacao7,negociacao8);

CandlesFactory fabrica = new CandlesFactory();
List<Candle>  candles =  fabrica.constroiCandles(negociacoes);
for (Candle candlestick : candles) {	
	SimpleDateFormat sdf = new SimpleDateFormat();
	sdf.applyPattern("dd/MM/yyyy");
	sdf.setCalendar(candlestick.getData());
	String america = sdf.format(candlestick.getData().getTime());
System.out.println(america);
System.out.println(candlestick.getVolume());
System.out.println(candlestick.getAbertura());
}
SimpleDateFormat sdf = new SimpleDateFormat();
sdf.applyPattern("dd/MM/yyyy");
System.out.println("Aguarde");
System.out.println("Amanha " + sdf.format(amanha.getTime()));
System.out.println("Hoje " + sdf.format(hoje.getTime()));
System.out.println("Depois " + sdf.format(depois.getTime()));
}

}
