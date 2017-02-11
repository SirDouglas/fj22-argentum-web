package br.com.caelum.argentum.modelo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Comparator;
import java.util.List;

public class CandlesFactory {
public Candle constroiCandleParaData(Calendar data,List<Negociacao> negociacoes) {
	double maximo = 0;
	double minimo = 0;
	double volume = 0;
	
	for (Negociacao negociacao : negociacoes) {
		volume += negociacao.getVolume();
		double preco = negociacao.getPreco();
		if (minimo == 0) {
			minimo = preco;
		}
		if (preco > maximo) {
			maximo = preco;
		} else if (preco < minimo)  {
			minimo = preco;
		}
	}
		double abertura = negociacoes.isEmpty() ? 0 :  negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : negociacoes.get(negociacoes.size()-1).getPreco();
		return new Candle(abertura,fechamento,minimo,maximo,volume,data);
		


}

public List<Candle> constroiCandles(List<Negociacao> todasNegociacoes) {
List<Candle> candles = new ArrayList<Candle>();

List<Negociacao> negociacoesDoDia = new ArrayList<Negociacao>();

Calendar dataAtual = todasNegociacoes.get(0).getData();




for (Negociacao negociacao : todasNegociacoes) {
	if (!negociacao.isMesmoDia(dataAtual)) {
		criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);
		 negociacoesDoDia = new ArrayList<Negociacao>();
		 dataAtual = negociacao.getData();
	}
	negociacoesDoDia.add(negociacao);
	
}
criaEGuardaCandle(candles, negociacoesDoDia, dataAtual);
Comparator <Candle> comparator = (s1,s2) -> {
	return s1.getData().compareTo(s2.getData());
	};
candles.sort(comparator);
	return candles;
}

private void criaEGuardaCandle(List<Candle> candles, List<Negociacao> negociacoesDoDia, Calendar dataAtual) {
	Candle candleDoDia = constroiCandleParaData(dataAtual, negociacoesDoDia);
	candles.add(candleDoDia);
}
}
