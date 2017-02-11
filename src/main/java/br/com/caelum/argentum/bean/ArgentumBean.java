package br.com.caelum.argentum.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.chart.ChartModel;

import br.com.caelum.argentum.grafico.GeradorModeloGrafico;
import br.com.caelum.argentum.modelo.Candle;
import br.com.caelum.argentum.modelo.CandlesFactory;
import br.com.caelum.argentum.modelo.Negociacao;
import br.com.caelum.argentum.modelo.SerieTemporal;
import br.com.caelum.argentum.ws.ClienteWebService;

@ViewScoped
@ManagedBean
public class ArgentumBean implements Serializable  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Negociacao> negociacoes;
	private ChartModel modeloGrafico;
	private String nomeMedia;
	private String nomeIndicadorBase;
	private String titulo;
	
	
	public ArgentumBean() {
	negociacoes = new ClienteWebService().getConexao();
	geraGrafico();
	}

	public void geraGrafico() {
		List<Candle> candles = new CandlesFactory().constroiCandles(negociacoes);
		SerieTemporal serie = new SerieTemporal(candles);
		System.out.println("Plotando: " + nomeMedia + " de " + nomeIndicadorBase);
		GeradorModeloGrafico geradorGrafico = new GeradorModeloGrafico(serie, 2,serie.getUltimaPosicao(),titulo);
		IndicadorFactory fabrica = new IndicadorFactory(nomeIndicadorBase, nomeMedia,3); 
geradorGrafico.plotaIndicador(fabrica.defineIndicador()); 
		this.modeloGrafico = geradorGrafico.getModeloGrafico();
	}



	public List<Negociacao> getNegociacoes() {
		return negociacoes;
	}
public ChartModel getModeloGrafico() {
	return modeloGrafico;
}

public String getNomeMedia() {
	return nomeMedia;
}

public void setNomeMedia(String nomeMedia) {
	this.nomeMedia = nomeMedia;
}

public String getNomeIndicadorBase() {
	return nomeIndicadorBase;
}

public void setNomeIndicadorBase(String nomeIndicadorBase) {
	this.nomeIndicadorBase = nomeIndicadorBase;
}

public String getTitulo() {
	return titulo;
}

public void setTitulo(String titulo) {
	this.titulo = titulo;
}

}
