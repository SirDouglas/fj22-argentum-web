package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candle {
private final double abertura;
private final double fechamento;
private final double minimo;
private final double maximo;
private final double volume;
private final Calendar data;
public Candle(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
	this.abertura = abertura;
	this.fechamento = fechamento;
 
	  this.minimo = minimo;
		this.maximo = maximo;
		if (maximo<minimo) {
throw new IllegalArgumentException("valor minimo não pode ter valor maximo");
}
	this.volume = volume;
	this.data = data;
	if (data == null) {
		throw new IllegalArgumentException("nao pode haver data null");		
	}
	if ((abertura<0) || (fechamento<0) || (volume<0) || (minimo<0) || (maximo<0) ) {
		throw new IllegalArgumentException("nao pode haver data null");
	}
	
}
public double getAbertura() {
	return abertura;
}
public double getFechamento() {
	return fechamento;
}
public double getMinimo() {
	return minimo;
}
public double getMaximo() {
	return maximo;
}
public double getVolume() {
	return volume;
}
public Calendar getData() {
	return data;
}

public boolean isAlta() {
	if (this.fechamento == this.abertura) {
		return true;
	}
	return this.abertura < this.fechamento;
	
}

public boolean isBaixa() {
	if (this.fechamento == this.abertura) {
		return false;
	}
	return this.abertura > this.fechamento;
}

@Override
	public String toString() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat();
	  sdf.applyPattern("dd/MM/yyyy");
			return "[" + "Abertura "  + this.abertura + ", Fechamento " + this.fechamento  + ", Mínima " + this.minimo + ", Máxima" + this.maximo + ", Volume " +
	this.volume + ", Data " + sdf.format(this.data.getTimeInMillis())  + "]";
	}
}
