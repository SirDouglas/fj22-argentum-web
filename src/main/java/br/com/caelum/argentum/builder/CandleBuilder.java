package br.com.caelum.argentum.builder;

import java.util.Calendar;

import br.com.caelum.argentum.modelo.Candle;

public class CandleBuilder {
private double abertura = -1;
private double fechamento = -1;
private double minimo = -1;
private double maximo = -1;
private double volume = -1;
private Calendar data;

public CandleBuilder comAbertura(double abertura) {
	this.abertura = abertura;
	return this;
	
}

public CandleBuilder comFechamento(double fechamento) {
	this.fechamento = fechamento;
	return this;
	
}

public CandleBuilder comMinimo(double minimo) {
	this.minimo = minimo;
	return this;
			
			
}

public CandleBuilder comMaximo(double maximo) {
	this.maximo = maximo;
	return this;
}

public CandleBuilder comVolume(double volume) {
	this.volume = volume;
	return this;
}

public CandleBuilder comData(Calendar data) {
	this.data = data;
	return this;
}

public Candle geraCandle() {
	if ((abertura == -1) || (fechamento == -1) || (minimo == -1) || (maximo == -1) || 
			(volume == -1) || (data == null) ) {
		throw new IllegalStateException("CandleBuilder não foi construido corretamente");
	}
	return new Candle(abertura,fechamento,minimo,maximo,volume,data);
	
}

}
