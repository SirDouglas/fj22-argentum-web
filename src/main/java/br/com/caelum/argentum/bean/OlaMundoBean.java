package br.com.caelum.argentum.bean;

import javax.faces.bean.ManagedBean;




@ManagedBean
public class OlaMundoBean {

private String mensagem = "Quem � voc�?";
private String nome;
	public String getMensagem() {
		return mensagem;
		
	}
	public String getNome() {
		return nome;
	}
	
 public void setNome(String nome) {
	 this.nome = nome;
 }
 
 public void nomeDigitado() {
	 System.out.println("\nChamou o bot�o");
 }
	
}
