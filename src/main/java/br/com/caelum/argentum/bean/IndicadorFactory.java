package br.com.caelum.argentum.bean;

import java.lang.reflect.Constructor;

import br.com.caelum.argentum.indicadores.Indicador;
import br.com.caelum.argentum.indicadores.IndicadorFechamento;
import br.com.caelum.argentum.indicadores.MediaMovelSimples;

public class IndicadorFactory {

	
	private final String nomeIndicadorBase;
	private final String nomeMedia;
	private final int dia;

	
	public IndicadorFactory(String nomeIndicadorBase,String nomeMedia,int dia) {
		// TODO Auto-generated constructor stub
		this.nomeIndicadorBase = nomeIndicadorBase;
		this.nomeMedia = nomeMedia;
		this.dia = dia;
	}
	
public Indicador defineIndicador() {
		  if (nomeIndicadorBase == null || nomeMedia == null) 
	    return new MediaMovelSimples(3, new IndicadorFechamento()); 
try {
	String pacote = "br.com.caelum.argentum.indicadores.";
	Class<?> classeIndicadorBase = Class.forName(pacote + nomeIndicadorBase);
	Indicador IndicadorBase = (Indicador) classeIndicadorBase.newInstance();
	Class<?> classeMedia =  Class.forName(pacote + nomeMedia);
	Constructor<?> constructorMedia = classeMedia.getConstructor(Indicador.class);
	Indicador indicador = (Indicador) constructorMedia.newInstance(IndicadorBase);
	return indicador;
} catch (Exception e) {
	// TODO Auto-generated catch block
throw new RuntimeException(e);
}

}
}
